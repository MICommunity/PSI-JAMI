package psidev.psi.mi.jami.xml.io.writer.expanded;

import psidev.psi.mi.jami.factory.options.InteractionWriterOptions;
import psidev.psi.mi.jami.exception.MIIOException;
import psidev.psi.mi.jami.model.*;
import psidev.psi.mi.jami.xml.PsiXmlVersion;
import psidev.psi.mi.jami.xml.cache.PsiXmlObjectCache;
import psidev.psi.mi.jami.xml.io.writer.elements.*;

import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.*;

/**
 * Abstract class for an expanded PSI-XML 2.5 writer of mixed interactions
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>20/11/13</pre>
 */
public abstract class AbstractExpandedXmlMixWriter<I extends Interaction, M extends ModelledInteraction, E extends InteractionEvidence> extends AbstractExpandedXmlWriter<I> {

    private AbstractExpandedXmlWriter<E> evidenceWriter;
    private AbstractExpandedXmlWriter<M> modelledWriter;
    private AbstractExpandedXmlWriter<I> lightWriter;

    /**
     * <p>Constructor for AbstractExpandedXmlMixWriter.</p>
     *
     * @param type a {@link java.lang.Class} object.
     */
    public AbstractExpandedXmlMixWriter(Class<I> type) {
        super(type);
    }

    /**
     * <p>Constructor for AbstractExpandedXmlMixWriter.</p>
     *
     * @param type a {@link java.lang.Class} object.
     * @param file a {@link java.io.File} object.
     * @throws java.io.IOException if any.
     * @throws javax.xml.stream.XMLStreamException if any.
     */
    public AbstractExpandedXmlMixWriter(Class<I> type, File file) throws IOException, XMLStreamException {
        super(type, file);
    }

    /**
     * <p>Constructor for AbstractExpandedXmlMixWriter.</p>
     *
     * @param type a {@link java.lang.Class} object.
     * @param output a {@link java.io.OutputStream} object.
     * @throws javax.xml.stream.XMLStreamException if any.
     */
    public AbstractExpandedXmlMixWriter(Class<I> type, OutputStream output) throws XMLStreamException {
        super(type, output);
    }

    /**
     * <p>Constructor for AbstractExpandedXmlMixWriter.</p>
     *
     * @param type a {@link java.lang.Class} object.
     * @param writer a {@link java.io.Writer} object.
     * @throws javax.xml.stream.XMLStreamException if any.
     */
    public AbstractExpandedXmlMixWriter(Class<I> type, Writer writer) throws XMLStreamException {
        super(type, writer);
    }

    /** {@inheritDoc} */
    @Override
    protected void initialiseSubWriters() {
        initialiseDelegateWriters();
    }

    /** {@inheritDoc} */
    @Override
    public void close() throws MIIOException {
        super.close();
        this.modelledWriter = null;
        this.evidenceWriter = null;
        this.lightWriter = null;
    }

    /** {@inheritDoc} */
    @Override
    public void reset() throws MIIOException {
        super.reset();
        this.modelledWriter = null;
        this.evidenceWriter = null;
        this.lightWriter = null;
    }

    /** {@inheritDoc} */
    @Override
    public void flush() throws MIIOException {
        super.flush();
        this.evidenceWriter.flush();
        this.modelledWriter.flush();
        this.lightWriter.flush();
    }

    /** {@inheritDoc} */
    @Override
    public void setWriteComplexesAsInteractors(boolean writeComplexesAsInteractors) {
        super.setWriteComplexesAsInteractors(writeComplexesAsInteractors);
        if (this.modelledWriter != null){
            this.modelledWriter.setWriteComplexesAsInteractors(writeComplexesAsInteractors);
        }
        if (this.evidenceWriter != null){
            this.evidenceWriter.setWriteComplexesAsInteractors(writeComplexesAsInteractors);
        }
        if (this.lightWriter != null){
            this.lightWriter.setWriteComplexesAsInteractors(writeComplexesAsInteractors);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setInteractionSet(Set<Interaction> processedInteractions) {
        super.setInteractionSet(processedInteractions);
        if (this.modelledWriter != null){
            this.modelledWriter.setInteractionSet(processedInteractions);
        }
        if (this.evidenceWriter != null){
            this.evidenceWriter.setInteractionSet(processedInteractions);
        }
        if (this.lightWriter != null){
            this.lightWriter.setInteractionSet(processedInteractions);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setDefaultSource(Source defaultSource) {
        super.setDefaultSource(defaultSource);
        if (this.modelledWriter != null){
            this.modelledWriter.setDefaultSource(defaultSource);
        }
        if (this.evidenceWriter != null){
            this.evidenceWriter.setDefaultSource(defaultSource);
        }
        if (this.lightWriter != null){
            this.lightWriter.setDefaultSource(defaultSource);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setDefaultReleaseDate(XMLGregorianCalendar defaultReleaseDate) {
        super.setDefaultReleaseDate(defaultReleaseDate);
        if (this.modelledWriter != null){
            this.modelledWriter.setDefaultReleaseDate(defaultReleaseDate);
        }
        if (this.evidenceWriter != null){
            this.evidenceWriter.setDefaultReleaseDate(defaultReleaseDate);
        }
        if (this.lightWriter != null){
            this.lightWriter.setDefaultReleaseDate(defaultReleaseDate);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void write(Iterator<? extends I> interactions) throws MIIOException {
        if (this.modelledWriter == null || this.evidenceWriter == null || this.lightWriter == null){
            throw new IllegalStateException("The PSI-XML writer was not initialised. The options for the PSI-XML writer should contains at least "+ InteractionWriterOptions.OUTPUT_OPTION_KEY + " to know where to write the interactions.");
        }
        List<E> evidences = new ArrayList<E>();
        List<M> modelledList = new ArrayList<M>();
        List<I> interactionList = new ArrayList<I>();
        I interaction = null;
        if (interactions.hasNext()){
            interaction = interactions.next();
        }

        do{
            if (interaction != null && this.evidenceWriter.getInteractionType() != null
                    && this.evidenceWriter.getInteractionType().isAssignableFrom(interaction.getClass())){
                evidences.clear();
                do{
                    evidences.add((E)interaction);
                    if (interactions.hasNext()){
                        interaction = interactions.next();
                    }
                    else{
                        interaction = null;
                    }
                }
                while(interaction != null && this.evidenceWriter.getInteractionType().isAssignableFrom(interaction.getClass()));
                this.evidenceWriter.write(evidences);
            }
            else if (interaction != null && this.modelledWriter.getInteractionType() != null
                    && this.modelledWriter.getInteractionType().isAssignableFrom(interaction.getClass())){
                modelledList.clear();
                do{
                    modelledList.add((M)interaction);
                    if (interactions.hasNext()){
                        interaction = interactions.next();
                    }
                    else{
                        interaction = null;
                    }
                }
                while(interaction != null && this.modelledWriter.getInteractionType().isAssignableFrom(interaction.getClass()));
                this.modelledWriter.write(modelledList);
            }
            else if (interaction != null){
                interactionList.clear();
                do{
                    interactionList.add(interaction);
                    if (interactions.hasNext()){
                        interaction = interactions.next();
                    }
                    else{
                        interaction = null;
                    }
                }
                while(interaction != null && !this.evidenceWriter.getInteractionType().isAssignableFrom(interaction.getClass())
                        && !this.modelledWriter.getInteractionType().isAssignableFrom(interaction.getClass()));
                this.lightWriter.write(interactionList);
            }
            else{
                break;
            }
        }
        while (interaction != null);
    }

    /** {@inheritDoc} */
    @Override
    public void write(Collection<? extends I> interactions) throws MIIOException {
        write(interactions.iterator());
    }

    /** {@inheritDoc} */
    @Override
    public void write(I interaction) throws MIIOException {
        if (this.modelledWriter == null || this.evidenceWriter == null || this.lightWriter == null){
            throw new IllegalStateException("The PSI-XML writer was not initialised. The options for the PSI-XML writer should contains at least "+ InteractionWriterOptions.OUTPUT_OPTION_KEY + " to know where to write the interactions.");
        }
        if (this.evidenceWriter.getInteractionType() != null && this.evidenceWriter.getInteractionType().isAssignableFrom(interaction.getClass())){
            this.evidenceWriter.write((E)interaction);
        }
        else if (this.modelledWriter.getInteractionType() != null && this.modelledWriter.getInteractionType().isAssignableFrom(interaction.getClass())){
            this.modelledWriter.write((M)interaction);
        }
        else{
            this.lightWriter.write(interaction);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setSourceWriter(PsiXmlSourceWriter sourceWriter) {
        super.setSourceWriter(sourceWriter);
        if (this.modelledWriter != null){
            this.modelledWriter.setSourceWriter(sourceWriter);
        }
        if (this.evidenceWriter != null){
            this.evidenceWriter.setSourceWriter(sourceWriter);
        }
        if (this.lightWriter != null){
            this.lightWriter.setSourceWriter(sourceWriter);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setComplexWriter(PsiXmlInteractionWriter<ModelledInteraction> complexWriter) {
        super.setComplexWriter(complexWriter);
        if (this.modelledWriter != null){
            this.modelledWriter.setComplexWriter(complexWriter);
        }
        if (this.evidenceWriter != null){
            this.evidenceWriter.setComplexWriter(complexWriter);
        }
        if (this.lightWriter != null){
            this.lightWriter.setComplexWriter(complexWriter);
        }

    }

    /** {@inheritDoc} */
    @Override
    public void setElementCache(PsiXmlObjectCache elementCache) {
        super.setElementCache(elementCache);
        if (this.modelledWriter != null){
            this.modelledWriter.setElementCache(elementCache);
        }
        if (this.evidenceWriter != null){
            this.evidenceWriter.setElementCache(elementCache);
        }
        if (this.lightWriter != null){
            this.lightWriter.setElementCache(elementCache);
        }
    }

    /** {@inheritDoc} */
    @Override
    public void setVersion(PsiXmlVersion version) {
        super.setVersion(version);
        if (this.modelledWriter != null){
            this.modelledWriter.setVersion(version);
        }
        if (this.evidenceWriter != null){
            this.evidenceWriter.setVersion(version);
        }
        if (this.lightWriter != null){
            this.lightWriter.setVersion(version);
        }
    }

    /**
     * <p>Getter for the field <code>evidenceWriter</code>.</p>
     *
     * @return a {@link psidev.psi.mi.jami.xml.io.writer.expanded.AbstractExpandedXmlWriter} object.
     */
    protected AbstractExpandedXmlWriter<E> getEvidenceWriter() {
        return evidenceWriter;
    }

    /**
     * <p>Setter for the field <code>evidenceWriter</code>.</p>
     *
     * @param evidenceWriter a {@link psidev.psi.mi.jami.xml.io.writer.expanded.AbstractExpandedXmlWriter} object.
     */
    protected void setEvidenceWriter(AbstractExpandedXmlWriter<E> evidenceWriter) {
        this.evidenceWriter = evidenceWriter;
        this.evidenceWriter.setElementCache(getElementCache());
    }

    /**
     * <p>Getter for the field <code>modelledWriter</code>.</p>
     *
     * @return a {@link psidev.psi.mi.jami.xml.io.writer.expanded.AbstractExpandedXmlWriter} object.
     */
    protected AbstractExpandedXmlWriter<M> getModelledWriter() {
        return modelledWriter;
    }

    /**
     * <p>Setter for the field <code>modelledWriter</code>.</p>
     *
     * @param modelledWriter a {@link psidev.psi.mi.jami.xml.io.writer.expanded.AbstractExpandedXmlWriter} object.
     */
    protected void setModelledWriter(AbstractExpandedXmlWriter<M> modelledWriter) {
        this.modelledWriter = modelledWriter;
        this.modelledWriter.setElementCache(getElementCache());
    }

    /**
     * <p>Getter for the field <code>lightWriter</code>.</p>
     *
     * @return a {@link psidev.psi.mi.jami.xml.io.writer.expanded.AbstractExpandedXmlWriter} object.
     */
    protected AbstractExpandedXmlWriter<I> getLightWriter() {
        return lightWriter;
    }

    /**
     * <p>Setter for the field <code>lightWriter</code>.</p>
     *
     * @param lightWriter a {@link psidev.psi.mi.jami.xml.io.writer.expanded.AbstractExpandedXmlWriter} object.
     */
    protected void setLightWriter(AbstractExpandedXmlWriter<I> lightWriter) {
        this.lightWriter = lightWriter;
        this.lightWriter.setElementCache(getElementCache());
    }

    /**
     * <p>initialiseDelegateWriters.</p>
     */
    protected abstract void initialiseDelegateWriters();
}
