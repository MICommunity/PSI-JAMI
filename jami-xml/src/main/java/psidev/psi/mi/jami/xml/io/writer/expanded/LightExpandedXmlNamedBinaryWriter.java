package psidev.psi.mi.jami.xml.io.writer.expanded;

import psidev.psi.mi.jami.binary.BinaryInteraction;
import psidev.psi.mi.jami.model.ComplexType;
import psidev.psi.mi.jami.model.InteractionCategory;
import psidev.psi.mi.jami.xml.PsiXmlType;
import psidev.psi.mi.jami.xml.cache.PsiXmlObjectCache;

import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

/**
 * Expanded PSI-XML writer for light binary interactions (no experimental evidences) having names.
 * Participants, experiments and features are also assumed to have expanded names
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>19/11/13</pre>
 */
public class LightExpandedXmlNamedBinaryWriter extends AbstractExpandedXmlWriter<BinaryInteraction> {

    /**
     * <p>Constructor for LightExpandedXmlNamedBinaryWriter.</p>
     */
    public LightExpandedXmlNamedBinaryWriter() {
        super(BinaryInteraction.class);
    }

    /**
     * <p>Constructor for LightExpandedXmlNamedBinaryWriter.</p>
     *
     * @param file a {@link java.io.File} object.
     * @throws java.io.IOException if any.
     * @throws javax.xml.stream.XMLStreamException if any.
     */
    public LightExpandedXmlNamedBinaryWriter(File file) throws IOException, XMLStreamException {
        super(BinaryInteraction.class, file);
    }

    /**
     * <p>Constructor for LightExpandedXmlNamedBinaryWriter.</p>
     *
     * @param output a {@link java.io.OutputStream} object.
     * @throws javax.xml.stream.XMLStreamException if any.
     */
    public LightExpandedXmlNamedBinaryWriter(OutputStream output) throws XMLStreamException {
        super(BinaryInteraction.class, output);
    }

    /**
     * <p>Constructor for LightExpandedXmlNamedBinaryWriter.</p>
     *
     * @param writer a {@link java.io.Writer} object.
     * @throws javax.xml.stream.XMLStreamException if any.
     */
    public LightExpandedXmlNamedBinaryWriter(Writer writer) throws XMLStreamException {
        super(BinaryInteraction.class, writer);
    }

    /**
     * <p>Constructor for LightExpandedXmlNamedBinaryWriter.</p>
     *
     * @param streamWriter a {@link javax.xml.stream.XMLStreamWriter} object.
     * @param cache a {@link psidev.psi.mi.jami.xml.cache.PsiXmlObjectCache} object.
     */
    public LightExpandedXmlNamedBinaryWriter(XMLStreamWriter streamWriter, PsiXmlObjectCache cache) {
        super(BinaryInteraction.class, streamWriter, cache);
    }

    /** {@inheritDoc} */
    @Override
    protected void initialiseSubWriters() {
        super.initialiseSubWriters(false, true, PsiXmlType.expanded, InteractionCategory.basic, ComplexType.binary);
    }
}
