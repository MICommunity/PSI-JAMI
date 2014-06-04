package psidev.psi.mi.jami.xml.io.writer.elements.impl.compact.xml30;

import junit.framework.Assert;
import org.junit.Ignore;
import org.junit.Test;
import psidev.psi.mi.jami.binary.ModelledBinaryInteraction;
import psidev.psi.mi.jami.binary.impl.DefaultModelledBinaryInteraction;
import psidev.psi.mi.jami.exception.IllegalRangeException;
import psidev.psi.mi.jami.model.*;
import psidev.psi.mi.jami.model.impl.*;
import psidev.psi.mi.jami.utils.CvTermUtils;
import psidev.psi.mi.jami.utils.InteractorUtils;
import psidev.psi.mi.jami.utils.RangeUtils;
import psidev.psi.mi.jami.utils.XrefUtils;
import psidev.psi.mi.jami.xml.cache.InMemoryIdentityObjectCache;
import psidev.psi.mi.jami.xml.cache.PsiXmlObjectCache;
import psidev.psi.mi.jami.xml.io.writer.elements.impl.AbstractXmlWriterTest;

import javax.xml.stream.XMLStreamException;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * Unit tester for XmlModelledInteractionWriter
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>25/11/13</pre>
 */

public class XmlModelledInteractionWriterTest extends AbstractXmlWriterTest {

    private String interaction = "<abstractInteraction id=\"1\">\n" +
            "  <participantList>\n" +
            "    <participant id=\"2\">\n" +
            "      <interactorRef>3</interactorRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "    </participant>\n"+
            "  </participantList>\n" +
            "</abstractInteraction>";

    private String full_complex = "<abstractInteraction id=\"1\">\n" +
            "  <names>\n" +
            "    <shortLabel>test complex</shortLabel>\n" +
            "  </names>\n" +
            "  <participantList>\n" +
            "    <participant id=\"2\">\n" +
            "      <interactorRef>3</interactorRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "    </participant>\n"+
            "  </participantList>\n" +
            "  <organism ncbiTaxId=\"9606\">\n" +
            "    <names>\n" +
            "      <shortLabel>human</shortLabel>\n" +
            "    </names>\n" +
            "  </organism>\n" +
            "  <interactorType>\n" +
            "    <names>\n" +
            "      <shortLabel>complex</shortLabel>\n" +
            "    </names>\n" +
            "    <xref>\n" +
            "      <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0314\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "    </xref>\n" +
            "  </interactorType>\n" +
            "  <evidenceType>\n" +
            "    <names>\n" +
            "      <shortLabel>inferred</shortLabel>\n" +
            "    </names>\n" +
            "    <xref>\n" +
            "      <primaryRef db=\"eco\" id=\"ECO-xxxx\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "    </xref>\n" +
            "  </evidenceType>\n" +
            "</abstractInteraction>";

    private String interaction_complex = "<abstractInteraction id=\"1\">\n" +
            "  <participantList>\n" +
            "    <participant id=\"2\">\n" +
            "      <interactionRef>3</interactionRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "    </participant>\n"+
            "  </participantList>\n" +
            "</abstractInteraction>";

    private String interaction_shortName ="<abstractInteraction id=\"1\">\n" +
            "  <names>\n" +
            "    <shortLabel>interaction test</shortLabel>\n"+
            "  </names>\n" +
            "  <participantList>\n" +
            "    <participant id=\"2\">\n" +
            "      <interactorRef>3</interactorRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "    </participant>\n"+
            "  </participantList>\n" +
            "</abstractInteraction>";

    private String interaction_identifier = "<abstractInteraction id=\"1\">\n" +
            "  <xref>\n" +
            "    <primaryRef db=\"intact\" id=\"EBI-xxx\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "    <secondaryRef db=\"test\" id=\"xxxx1\"/>\n"+
            "  </xref>\n"+
            "  <participantList>\n" +
            "    <participant id=\"2\">\n" +
            "      <interactorRef>3</interactorRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "    </participant>\n"+
            "  </participantList>\n" +
            "</abstractInteraction>";
    private String interaction_xref = "<abstractInteraction id=\"1\">\n" +
            "  <xref>\n" +
            "    <primaryRef db=\"test2\" id=\"xxxx2\"/>\n" +
            "    <secondaryRef db=\"test\" id=\"xxxx1\"/>\n"+
            "  </xref>\n"+
            "  <participantList>\n" +
            "    <participant id=\"2\">\n" +
            "      <interactorRef>3</interactorRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "    </participant>\n"+
            "  </participantList>\n" +
            "</abstractInteraction>";
    private String interaction_inferred = "<abstractInteraction id=\"1\">\n" +
            "  <participantList>\n" +
            "    <participant id=\"2\">\n" +
            "      <interactorRef>3</interactorRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "      <featureList>\n" +
            "        <feature id=\"4\">\n" +
            "          <featureType>\n" +
            "            <names>\n" +
            "              <shortLabel>biological feature</shortLabel>\n" +
            "            </names>\n" +
            "            <xref>\n" +
            "              <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0252\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "            </xref>\n" +
            "          </featureType>\n" +
            "          <featureRangeList>\n" +
            "            <featureRange>\n" +
            "              <startStatus>\n" +
            "                <names>\n" +
            "                  <shortLabel>certain</shortLabel>\n"+
            "                </names>\n"+
            "                <xref>\n" +
            "                  <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0335\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n"+
            "                </xref>\n"+
            "              </startStatus>\n" +
            "              <begin position=\"1\"/>\n"+
            "              <endStatus>\n" +
            "                <names>\n" +
            "                  <shortLabel>certain</shortLabel>\n"+
            "                </names>\n"+
            "                <xref>\n" +
            "                  <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0335\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n"+
            "                </xref>\n"+
            "              </endStatus>\n" +
            "              <end position=\"4\"/>\n"+
            "            </featureRange>\n"+
            "          </featureRangeList>\n" +
            "        </feature>\n"+
            "      </featureList>\n" +
            "    </participant>\n"+
            "    <participant id=\"5\">\n" +
            "      <interactorRef>6</interactorRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "      <featureList>\n" +
            "        <feature id=\"7\">\n" +
            "          <featureType>\n" +
            "            <names>\n" +
            "              <shortLabel>biological feature</shortLabel>\n" +
            "            </names>\n" +
            "            <xref>\n" +
            "              <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0252\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "            </xref>\n" +
            "          </featureType>\n" +
            "          <featureRangeList>\n" +
            "            <featureRange>\n" +
            "              <startStatus>\n" +
            "                <names>\n" +
            "                  <shortLabel>certain</shortLabel>\n"+
            "                </names>\n"+
            "                <xref>\n" +
            "                  <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0335\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n"+
            "                </xref>\n"+
            "              </startStatus>\n" +
            "              <begin position=\"1\"/>\n"+
            "              <endStatus>\n" +
            "                <names>\n" +
            "                  <shortLabel>certain</shortLabel>\n"+
            "                </names>\n"+
            "                <xref>\n" +
            "                  <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0335\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n"+
            "                </xref>\n"+
            "              </endStatus>\n" +
            "              <end position=\"4\"/>\n"+
            "            </featureRange>\n"+
            "          </featureRangeList>\n" +
            "        </feature>\n"+
            "      </featureList>\n" +
            "    </participant>\n"+
            "    <participant id=\"8\">\n" +
            "      <interactorRef>9</interactorRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "      <featureList>\n" +
            "        <feature id=\"10\">\n" +
            "          <featureType>\n" +
            "            <names>\n" +
            "              <shortLabel>biological feature</shortLabel>\n" +
            "            </names>\n" +
            "            <xref>\n" +
            "              <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0252\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "            </xref>\n" +
            "          </featureType>\n" +
            "          <featureRangeList>\n" +
            "            <featureRange>\n" +
            "              <startStatus>\n" +
            "                <names>\n" +
            "                  <shortLabel>certain</shortLabel>\n"+
            "                </names>\n"+
            "                <xref>\n" +
            "                  <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0335\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n"+
            "                </xref>\n"+
            "              </startStatus>\n" +
            "              <begin position=\"1\"/>\n"+
            "              <endStatus>\n" +
            "                <names>\n" +
            "                  <shortLabel>certain</shortLabel>\n"+
            "                </names>\n"+
            "                <xref>\n" +
            "                  <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0335\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n"+
            "                </xref>\n"+
            "              </endStatus>\n" +
            "              <end position=\"4\"/>\n"+
            "            </featureRange>\n"+
            "          </featureRangeList>\n" +
            "        </feature>\n"+
            "      </featureList>\n" +
            "    </participant>\n"+
            "    <participant id=\"11\">\n" +
            "      <interactorRef>12</interactorRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "      <featureList>\n" +
            "        <feature id=\"13\">\n" +
            "          <featureType>\n" +
            "            <names>\n" +
            "              <shortLabel>biological feature</shortLabel>\n" +
            "            </names>\n" +
            "            <xref>\n" +
            "              <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0252\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "            </xref>\n" +
            "          </featureType>\n" +
            "          <featureRangeList>\n" +
            "            <featureRange>\n" +
            "              <startStatus>\n" +
            "                <names>\n" +
            "                  <shortLabel>certain</shortLabel>\n"+
            "                </names>\n"+
            "                <xref>\n" +
            "                  <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0335\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n"+
            "                </xref>\n"+
            "              </startStatus>\n" +
            "              <begin position=\"1\"/>\n"+
            "              <endStatus>\n" +
            "                <names>\n" +
            "                  <shortLabel>certain</shortLabel>\n"+
            "                </names>\n"+
            "                <xref>\n" +
            "                  <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0335\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n"+
            "                </xref>\n"+
            "              </endStatus>\n" +
            "              <end position=\"4\"/>\n"+
            "            </featureRange>\n"+
            "          </featureRangeList>\n" +
            "        </feature>\n"+
            "      </featureList>\n" +
            "    </participant>\n"+
            "  </participantList>\n" +
            "  <bindingFeaturesList>\n" +
            "    <bindingFeatures>\n" +
            "      <participantFeatureRef>4</participantFeatureRef>\n" +
            "      <participantFeatureRef>10</participantFeatureRef>\n" +
            "      <participantFeatureRef>7</participantFeatureRef>\n" +
            "    </bindingFeatures>\n"+
            "    <bindingFeatures>\n" +
            "      <participantFeatureRef>10</participantFeatureRef>\n" +
            "      <participantFeatureRef>13</participantFeatureRef>\n" +
            "    </bindingFeatures>\n"+
            "  </bindingFeaturesList>\n" +
            "</abstractInteraction>";
    private String interaction_type =  "<abstractInteraction id=\"1\">\n" +
            "  <participantList>\n" +
            "    <participant id=\"2\">\n" +
            "      <interactorRef>3</interactorRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "    </participant>\n"+
            "  </participantList>\n" +
            "  <interactionType>\n" +
            "    <names>\n" +
            "      <shortLabel>association</shortLabel>\n" +
            "    </names>\n" +
            "    <xref>\n" +
            "      <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0914\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "    </xref>\n" +
            "  </interactionType>\n" +
            "</abstractInteraction>";
    private String interaction_attributes =  "<abstractInteraction id=\"1\">\n" +
            "  <participantList>\n" +
            "    <participant id=\"2\">\n" +
            "      <interactorRef>3</interactorRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "    </participant>\n"+
            "  </participantList>\n" +
            "  <attributeList>\n" +
            "    <attribute name=\"test2\"/>\n"+
            "    <attribute name=\"test3\"/>\n"+
            "  </attributeList>\n"+
            "</abstractInteraction>";
    private String interaction_registered = "<abstractInteraction id=\"2\">\n" +
            "  <participantList>\n" +
            "    <participant id=\"3\">\n" +
            "      <interactorRef>4</interactorRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "    </participant>\n"+
            "  </participantList>\n" +
            "</abstractInteraction>";

    private String interaction_confidence = "<abstractInteraction id=\"1\">\n" +
            "  <participantList>\n" +
            "    <participant id=\"2\">\n" +
            "      <interactorRef>3</interactorRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "    </participant>\n"+
            "  </participantList>\n" +
            "  <confidenceList>\n" +
            "    <confidence>\n" +
            "      <unit>\n" +
            "        <names>\n" +
            "          <shortLabel>intact-miscore</shortLabel>\n"+
            "        </names>\n"+
            "      </unit>\n" +
            "      <value>0.8</value>\n" +
            "    </confidence>\n"+
            "  </confidenceList>\n" +
            "</abstractInteraction>";

    private String interaction_parameter = "<abstractInteraction id=\"1\">\n" +
            "  <participantList>\n" +
            "    <participant id=\"2\">\n" +
            "      <interactorRef>3</interactorRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "    </participant>\n"+
            "  </participantList>\n" +
            "  <parameterList>\n" +
            "    <parameter term=\"kd\" base=\"10\" exponent=\"0\" factor=\"5\"/>\n" +
            "  </parameterList>\n" +
            "</abstractInteraction>";

    private String interaction_preAssembly = "<abstractInteraction id=\"1\">\n" +
            "  <participantList>\n" +
            "    <participant id=\"2\">\n" +
            "      <interactorRef>3</interactorRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "    </participant>\n"+
            "  </participantList>\n" +
            "  <attributeList>\n" +
            "    <attribute name=\"pre-assembly\" nameAc=\"MI:1158\"/>\n" +
            "    <attribute name=\"positive cooperative effect\" nameAc=\"MI:1154\"/>\n" +
            "    <attribute name=\"configurational pre-organization\" nameAc=\"MI:1174\"/>\n"+
            "    <attribute name=\"affected interaction\" nameAc=\"MI:1150\">5</attribute>\n" +
            "  </attributeList>\n" +
            "</abstractInteraction>";

    private String interaction_allostery = "<abstractInteraction id=\"1\">\n" +
            "  <participantList>\n" +
            "    <participant id=\"2\">\n" +
            "      <interactorRef>3</interactorRef>\n" +
            "      <biologicalRole>\n" +
            "        <names>\n" +
            "          <shortLabel>unspecified role</shortLabel>\n" +
            "        </names>\n" +
            "        <xref>\n" +
            "          <primaryRef db=\"psi-mi\" dbAc=\"MI:0488\" id=\"MI:0499\" refType=\"identity\" refTypeAc=\"MI:0356\"/>\n" +
            "        </xref>\n" +
            "      </biologicalRole>\n" +
            "    </participant>\n"+
            "  </participantList>\n" +
            "  <attributeList>\n" +
            "    <attribute name=\"allostery\" nameAc=\"MI:1157\"/>\n" +
            "    <attribute name=\"allosteric molecule\" nameAc=\"MI:1159\">3</attribute>\n" +
            "    <attribute name=\"allosteric effector\" nameAc=\"MI:1160\">5</attribute>\n" +
            "    <attribute name=\"heterotropic allostery\" nameAc=\"MI:1168\"/>\n" +
            "    <attribute name=\"allosteric change in structure\" nameAc=\"MI:1165\"/>\n" +
            "    <attribute name=\"positive cooperative effect\" nameAc=\"MI:1154\"/>\n" +
            "    <attribute name=\"allosteric v-type response\" nameAc=\"MI:1163\"/>\n" +
            "    <attribute name=\"affected interaction\" nameAc=\"MI:1150\">6</attribute>\n" +
            "  </attributeList>\n" +
            "</abstractInteraction>";

    private PsiXmlObjectCache elementCache = new InMemoryIdentityObjectCache();

    @Test
    public void test_write_interaction() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledInteraction interaction = new DefaultModelledInteraction();
        ModelledParticipant participant = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        interaction.addParticipant(participant);
        elementCache.clear();

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction, output.toString());
    }

    @Test
    public void test_full_complex() throws XMLStreamException, IOException, IllegalRangeException {
        Complex interaction = new DefaultComplex("test complex");
        ModelledParticipant participant = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        interaction.addParticipant(participant);
        interaction.setOrganism(new DefaultOrganism(9606,"human"));
        interaction.setEvidenceType(new DefaultCvTerm("inferred", null, XrefUtils.createIdentityXref("eco", "ECO-xxxx")));
        elementCache.clear();

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.full_complex, output.toString());
    }

    @Test
    public void test_write_interaction_full_complex() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledBinaryInteraction interaction = new DefaultModelledBinaryInteraction();
        ModelledParticipant participant = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        interaction.addParticipant(participant);
        elementCache.clear();

        XmlModelledBinaryInteractionWriter writer = new XmlModelledBinaryInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction, output.toString());
    }

    @Test
    public void test_write_participant_complex() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledInteraction interaction = new DefaultModelledInteraction();
        Complex complex = new DefaultComplex("test complex");
        complex.getParticipants().add(new DefaultModelledParticipant(new DefaultProtein("test protein")));
        ModelledParticipant participant = new DefaultModelledParticipant(complex);
        interaction.addParticipant(participant);
        elementCache.clear();

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction_complex, output.toString());
    }

    @Test
    public void test_write_participant_complex_as_interactor() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledInteraction interaction = new DefaultModelledInteraction();
        Complex complex = new DefaultComplex("test complex");
        complex.getParticipants().add(new DefaultModelledParticipant(new DefaultProtein("test protein")));
        ModelledParticipant participant = new DefaultModelledParticipant(complex);
        interaction.addParticipant(participant);
        elementCache.clear();

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.setComplexAsInteractor(true);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction, output.toString());
    }

    @Test
    public void test_write_participant_complex_no_participants() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledInteraction interaction = new DefaultModelledInteraction();
        Complex complex = new DefaultComplex("test complex");
        ModelledParticipant participant = new DefaultModelledParticipant(complex);
        interaction.addParticipant(participant);
        elementCache.clear();

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction, output.toString());
    }

    @Test
    public void test_write_interaction_shortName() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledInteraction interaction = new DefaultModelledInteraction("interaction test");
        ModelledParticipant participant = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        interaction.addParticipant(participant);
        elementCache.clear();

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction_shortName, output.toString());
    }

    @Test
    public void test_write_interaction_identifier() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledInteraction interaction = new DefaultModelledInteraction();
        ModelledParticipant participant = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        interaction.addParticipant(participant);
        interaction.getIdentifiers().add(new DefaultXref(new DefaultCvTerm("intact"), "EBI-xxx"));
        interaction.getXrefs().add(new DefaultXref(new DefaultCvTerm("test"), "xxxx1"));
        elementCache.clear();

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction_identifier, output.toString());
    }

    @Test
    public void test_write_interaction_xref() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledInteraction interaction = new DefaultModelledInteraction();
        ModelledParticipant participant = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        interaction.addParticipant(participant);
        interaction.getXrefs().add(new DefaultXref(new DefaultCvTerm("test2"), "xxxx2"));
        interaction.getXrefs().add(new DefaultXref(new DefaultCvTerm("test"), "xxxx1"));
        elementCache.clear();

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction_xref, output.toString());
    }

    @Test
    @Ignore
    public void test_write_interaction_inferred() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledInteraction interaction = new DefaultModelledInteraction();
        ModelledParticipant participant = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        ModelledParticipant participant2 = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        ModelledParticipant participant3 = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        ModelledParticipant participant4 = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        // two inferred interactiosn f1, f2, f3 and f3,f4
        ModelledFeature f1 = new DefaultModelledFeature();
        f1.getRanges().add(RangeUtils.createRangeFromString("1-4"));
        ModelledFeature f2 = new DefaultModelledFeature();
        f2.getRanges().add(RangeUtils.createRangeFromString("1-4"));
        ModelledFeature f3 = new DefaultModelledFeature();
        f3.getRanges().add(RangeUtils.createRangeFromString("1-4"));
        ModelledFeature f4 = new DefaultModelledFeature();
        f4.getRanges().add(RangeUtils.createRangeFromString("1-4"));
        f1.getLinkedFeatures().add(f2);
        f1.getLinkedFeatures().add(f3);
        f2.getLinkedFeatures().add(f1);
        f2.getLinkedFeatures().add(f3);
        f3.getLinkedFeatures().add(f1);
        f3.getLinkedFeatures().add(f2);
        f3.getLinkedFeatures().add(f4);
        f4.getLinkedFeatures().add(f3);
        participant.addFeature(f1);
        participant2.addFeature(f2);
        participant3.addFeature(f3);
        participant4.addFeature(f4);
        interaction.addParticipant(participant);
        interaction.addParticipant(participant2);
        interaction.addParticipant(participant3);
        interaction.addParticipant(participant4);
        elementCache.clear();

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction_inferred, output.toString());
    }

    @Test
    public void test_write_interaction_type() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledInteraction interaction = new DefaultModelledInteraction();
        ModelledParticipant participant = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        interaction.addParticipant(participant);
        interaction.setInteractionType(CvTermUtils.createMICvTerm("association", "MI:0914"));
        elementCache.clear();

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction_type, output.toString());
    }

    @Test
    public void test_write_interaction_attributes() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledInteraction interaction = new DefaultModelledInteraction();
        ModelledParticipant participant = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        interaction.addParticipant(participant);
        interaction.getAnnotations().add(new DefaultAnnotation(new DefaultCvTerm("test2")));
        interaction.getAnnotations().add(new DefaultAnnotation(new DefaultCvTerm("test3")));
        elementCache.clear();

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction_attributes, output.toString());
    }

    @Test
    public void test_write_interaction_registered() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledInteraction interaction = new DefaultModelledInteraction();
        ModelledParticipant participant = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        interaction.addParticipant(participant);
        elementCache.clear();
        elementCache.extractIdForInteraction(new DefaultInteraction());
        elementCache.extractIdForInteraction(interaction);

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction_registered, output.toString());
    }

    @Test
    public void test_write_interaction_parameter() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledInteraction interaction = new DefaultModelledInteraction();
        ModelledParticipant participant = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        interaction.addParticipant(participant);
        interaction.getModelledParameters().add(new DefaultModelledParameter(new DefaultCvTerm("kd"), new ParameterValue(new BigDecimal(5))));
        elementCache.clear();

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction_parameter, output.toString());
    }

    @Test
    public void test_write_interaction_confidence() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledInteraction interaction = new DefaultModelledInteraction();
        ModelledParticipant participant = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        interaction.addParticipant(participant);
        interaction.getModelledConfidences().add(new DefaultModelledConfidence(new DefaultCvTerm("intact-miscore"), "0.8"));
        elementCache.clear();

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction_confidence, output.toString());
    }

    @Test
    public void test_write_interaction_preassembly() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledInteraction interaction = new DefaultModelledInteraction();
        ModelledParticipant participant = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        interaction.addParticipant(participant);
        Preassembly assembly = new DefaultPreassemby(CvTermUtils.createMICvTerm("positive cooperative effect", "MI:1154"));
        assembly.setResponse(CvTermUtils.createMICvTerm("configurational pre-organization", "MI:1174"));
        assembly.getAffectedInteractions().add(new DefaultModelledInteraction());
        interaction.getCooperativeEffects().add(assembly);
        elementCache.clear();

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction_preAssembly, output.toString());
    }

    @Test
    public void test_write_interaction_preassembly_defaultExperiment() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledInteraction interaction = new DefaultModelledInteraction();
        ModelledParticipant participant = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        interaction.addParticipant(participant);
        Preassembly assembly = new DefaultPreassemby(CvTermUtils.createMICvTerm("positive cooperative effect", "MI:1154"));
        assembly.setResponse(CvTermUtils.createMICvTerm("configurational pre-organization", "MI:1174"));
        assembly.getAffectedInteractions().add(new DefaultModelledInteraction());
        assembly.getCooperativityEvidences().add(new DefaultCooperativityEvidence(new DefaultPublication("12345")));
        interaction.getCooperativeEffects().add(assembly);
        elementCache.clear();

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction_preAssembly, output.toString());
    }

    @Test
    public void test_write_interaction_allostery() throws XMLStreamException, IOException, IllegalRangeException {
        ModelledInteraction interaction = new DefaultModelledInteraction();
        ModelledParticipant participant = new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor());
        interaction.addParticipant(participant);
        Allostery allostery = new DefaultAllostery(CvTermUtils.createMICvTerm("positive cooperative effect", "MI:1154"),
                participant, new DefaultMoleculeEffector(new DefaultModelledParticipant(InteractorUtils.createUnknownBasicInteractor())));
        allostery.setResponse(CvTermUtils.createMICvTerm("allosteric v-type response", "MI:1163"));
        allostery.getAffectedInteractions().add(new DefaultModelledInteraction());
        allostery.setAllostericMechanism(CvTermUtils.createMICvTerm("allosteric change in structure", "MI:1165"));
        allostery.setAllosteryType(CvTermUtils.createMICvTerm("heterotropic allostery", "MI:1168"));
        interaction.getCooperativeEffects().add(allostery);
        elementCache.clear();

        XmlModelledInteractionWriter writer = new XmlModelledInteractionWriter(createStreamWriter(), this.elementCache);
        writer.write(interaction);
        streamWriter.flush();

        Assert.assertEquals(this.interaction_allostery, output.toString());
    }
}
