package psidev.psi.mi.jami.xml.io.writer.elements.impl.expanded;

import org.codehaus.stax2.XMLStreamWriter2;
import psidev.psi.mi.jami.model.*;
import psidev.psi.mi.jami.xml.PsiXml25ObjectIndex;
import psidev.psi.mi.jami.xml.io.writer.elements.ExpandedPsiXml25ElementWriter;
import psidev.psi.mi.jami.xml.io.writer.elements.PsiXml25ElementWriter;
import psidev.psi.mi.jami.xml.io.writer.elements.PsiXml25XrefWriter;
import psidev.psi.mi.jami.xml.io.writer.elements.impl.abstracts.AbstractXml25InteractionWriter;

import javax.xml.stream.XMLStreamException;
import java.util.Set;

/**
 * Expanded XML 2.5 writer for a basic interaction (ignore experimental details)
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>15/11/13</pre>
 */

public class ExpandedXml25BasicInteractionWriter extends AbstractXml25InteractionWriter<Interaction,Participant> implements ExpandedPsiXml25ElementWriter<Interaction>{
    public ExpandedXml25BasicInteractionWriter(XMLStreamWriter2 writer, PsiXml25ObjectIndex objectIndex) {
        super(writer, objectIndex, new ExpandedXml25ParticipantWriter(writer, objectIndex));
    }

    public ExpandedXml25BasicInteractionWriter(XMLStreamWriter2 writer, PsiXml25ObjectIndex objectIndex,
                                               PsiXml25XrefWriter primaryRefWriter, PsiXml25XrefWriter secondaryRefWriter,
                                               ExpandedPsiXml25ElementWriter<Participant> participantWriter, PsiXml25ElementWriter<CvTerm> interactionTypeWriter,
                                               PsiXml25ElementWriter<Annotation> attributeWriter, PsiXml25ElementWriter<Set<Feature>> inferredInteractionWriter,
                                               PsiXml25ElementWriter<Experiment> experimentWriter) {
        super(writer, objectIndex, primaryRefWriter, secondaryRefWriter,
                participantWriter != null ? participantWriter : new ExpandedXml25ParticipantWriter(writer, objectIndex), interactionTypeWriter, attributeWriter, inferredInteractionWriter,
                experimentWriter);
    }

    @Override
    protected void writeAvailability(Interaction object) {
        // nothing to do
    }

    @Override
    protected void writeExperiments(Interaction object) throws XMLStreamException {
        writeExperimentDescription();
    }

    @Override
    protected void writeOtherAttributes(Interaction object) {
        // nothing to do
    }

    @Override
    protected void writeIntraMolecular(Interaction object) {
        // nothing to do
    }

    @Override
    protected void writeModelled(Interaction object) {
        // nothing to do
    }

    @Override
    protected void writeParameters(Interaction object) {
        // nothing to do
    }

    @Override
    protected void writeConfidences(Interaction object) {
        // nothing to do
    }

    @Override
    protected void writeNegative(Interaction object) {
        // nothing to do
    }
}