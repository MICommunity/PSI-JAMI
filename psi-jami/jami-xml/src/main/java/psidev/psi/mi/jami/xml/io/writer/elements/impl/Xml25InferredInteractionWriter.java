package psidev.psi.mi.jami.xml.io.writer.elements.impl;

import org.codehaus.stax2.XMLStreamWriter2;
import psidev.psi.mi.jami.exception.MIIOException;
import psidev.psi.mi.jami.model.Feature;
import psidev.psi.mi.jami.xml.PsiXml25ObjectIndex;
import psidev.psi.mi.jami.xml.io.writer.elements.PsiXml25ElementWriter;
import psidev.psi.mi.jami.xml.utils.PsiXml25Utils;

import javax.xml.stream.XMLStreamException;
import java.util.Set;

/**
 * XML 2.5 writer for Inferred interactions
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>14/11/13</pre>
 */

public class Xml25InferredInteractionWriter implements PsiXml25ElementWriter<Set<Feature>>{
    private XMLStreamWriter2 streamWriter;
    private PsiXml25ObjectIndex objectIndex;

    public Xml25InferredInteractionWriter(XMLStreamWriter2 writer, PsiXml25ObjectIndex objectIndex){
        if (writer == null){
            throw new IllegalArgumentException("The XML stream writer is mandatory for the Xml25InferredInteractionWriter");
        }
        this.streamWriter = writer;
        if (objectIndex == null){
            throw new IllegalArgumentException("The PsiXml 2.5 object index is mandatory for the Xml25InferredInteractionWriter. It is necessary for generating an id to an experimentDescription");
        }
        this.objectIndex = objectIndex;
    }

    @Override
    public void write(Set<Feature> object) throws MIIOException {
        try {
            // write start
            this.streamWriter.writeStartElement("inferredInteraction");
            this.streamWriter.writeCharacters(PsiXml25Utils.LINE_BREAK);
            // write participants
            for (Feature feature : object){
                this.streamWriter.writeStartElement("participant");
                this.streamWriter.writeCharacters(PsiXml25Utils.LINE_BREAK);
                this.streamWriter.writeStartElement("participantFeatureRef");
                this.streamWriter.writeCharacters(Integer.toString(this.objectIndex.extractIdFor(feature)));
                // write end feature ref
                this.streamWriter.writeEndElement();
                this.streamWriter.writeCharacters(PsiXml25Utils.LINE_BREAK);
                // write end inferred participant
                this.streamWriter.writeEndElement();
                this.streamWriter.writeCharacters(PsiXml25Utils.LINE_BREAK);
            }

            // write end inferred interaction
            this.streamWriter.writeEndElement();

        } catch (XMLStreamException e) {
            throw new MIIOException("Impossible to write the inferred interaction : "+object.toString(), e);
        }
    }
}