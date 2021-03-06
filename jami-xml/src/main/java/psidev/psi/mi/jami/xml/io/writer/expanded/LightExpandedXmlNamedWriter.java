package psidev.psi.mi.jami.xml.io.writer.expanded;

import psidev.psi.mi.jami.model.ComplexType;
import psidev.psi.mi.jami.model.Interaction;
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
 * Expanded PSI-XML writer for light interactions (no experimental evidences) having names.
 * Participants, experiments and features are also assumed to have expanded names
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>19/11/13</pre>
 */
public class LightExpandedXmlNamedWriter extends AbstractExpandedXmlWriter<Interaction> {

    /**
     * <p>Constructor for LightExpandedXmlNamedWriter.</p>
     */
    public LightExpandedXmlNamedWriter() {
        super(Interaction.class);
    }

    /**
     * <p>Constructor for LightExpandedXmlNamedWriter.</p>
     *
     * @param file a {@link java.io.File} object.
     * @throws java.io.IOException if any.
     * @throws javax.xml.stream.XMLStreamException if any.
     */
    public LightExpandedXmlNamedWriter(File file) throws IOException, XMLStreamException {
        super(Interaction.class, file);
    }

    /**
     * <p>Constructor for LightExpandedXmlNamedWriter.</p>
     *
     * @param output a {@link java.io.OutputStream} object.
     * @throws javax.xml.stream.XMLStreamException if any.
     */
    public LightExpandedXmlNamedWriter(OutputStream output) throws XMLStreamException {
        super(Interaction.class, output);
    }

    /**
     * <p>Constructor for LightExpandedXmlNamedWriter.</p>
     *
     * @param writer a {@link java.io.Writer} object.
     * @throws javax.xml.stream.XMLStreamException if any.
     */
    public LightExpandedXmlNamedWriter(Writer writer) throws XMLStreamException {
        super(Interaction.class, writer);
    }

    /**
     * <p>Constructor for LightExpandedXmlNamedWriter.</p>
     *
     * @param streamWriter a {@link javax.xml.stream.XMLStreamWriter} object.
     * @param cache a {@link psidev.psi.mi.jami.xml.cache.PsiXmlObjectCache} object.
     */
    public LightExpandedXmlNamedWriter(XMLStreamWriter streamWriter, PsiXmlObjectCache cache) {
        super(Interaction.class, streamWriter, cache);
    }

    /** {@inheritDoc} */
    @Override
    protected void initialiseSubWriters() {
        super.initialiseSubWriters(false, true, PsiXmlType.expanded, InteractionCategory.basic, ComplexType.n_ary);
    }
}
