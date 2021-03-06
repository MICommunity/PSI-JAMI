package psidev.psi.mi.jami.json.elements;

import org.json.simple.JSONValue;
import psidev.psi.mi.jami.json.MIJsonUtils;
import psidev.psi.mi.jami.json.IncrementalIdGenerator;
import psidev.psi.mi.jami.model.*;

import java.io.IOException;
import java.io.Writer;
import java.util.Iterator;
import java.util.Map;

/**
 * Json writer for participants
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>18/07/14</pre>
 */
public class SimpleJsonInteractorWriter implements JsonElementWriter<Interactor>{

    private Writer writer;
    private JsonElementWriter<CvTerm> cvWriter;
    private JsonElementWriter<Xref> identifierWriter;
    private Map<String, String> processedInteractors;
    private IncrementalIdGenerator idGenerator;
    private JsonElementWriter<Organism> organismWriter;

    /**
     * <p>Constructor for SimpleJsonInteractorWriter.</p>
     *
     * @param writer a {@link java.io.Writer} object.
     * @param processedInteractors a {@link java.util.Map} object.
     */
    public SimpleJsonInteractorWriter(Writer writer,  Map<String, String>processedInteractors) {
        if (writer == null) {
            throw new IllegalArgumentException("The json interactor writer needs a non null Writer");
        }
        this.writer = writer;
        if (processedInteractors == null){
            throw new IllegalArgumentException("The json interactor writer needs a non null map of processed interactors");
        }
        this.processedInteractors = processedInteractors;
    }

    /**
     * <p>Constructor for SimpleJsonInteractorWriter.</p>
     *
     * @param writer a {@link java.io.Writer} object.
     * @param processedInteractors a {@link java.util.Map} object.
     * @param idGenerator a {@link psidev.psi.mi.jami.json.IncrementalIdGenerator} object.
     */
    public SimpleJsonInteractorWriter(Writer writer,  Map<String, String>processedInteractors, IncrementalIdGenerator idGenerator) {
        if (writer == null) {
            throw new IllegalArgumentException("The json interactor writer needs a non null Writer");
        }
        this.writer = writer;
        if (processedInteractors == null){
            throw new IllegalArgumentException("The json interactor writer needs a non null map of processed interactors");
        }
        this.processedInteractors = processedInteractors;
        this.idGenerator = idGenerator;
    }

    /**
     * <p>write.</p>
     *
     * @param object a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @throws java.io.IOException if any.
     */
    public void write(Interactor object) throws IOException {
        String[] interactorIds = MIJsonUtils.extractInteractorId(object.getPreferredIdentifier(), object);
        String interactorKey = interactorIds[0]+"_"+interactorIds[1];
        // if the interactor has not yet been processed, we write the interactor
        if (!processedInteractors.containsKey(interactorKey)){

            // when the interactor is not the first one, we write an element separator
            if (!processedInteractors.isEmpty()){
                MIJsonUtils.writeSeparator(writer);
            }
            processedInteractors.put(interactorKey, interactorKey);
            MIJsonUtils.writeStartObject(writer);
            MIJsonUtils.writeProperty("object", "interactor", writer);
            // write accession
            MIJsonUtils.writeSeparator(writer);
            MIJsonUtils.writeProperty("id", interactorKey, writer);

            // write sequence if possible
            if (object instanceof Polymer){
                Polymer polymer = (Polymer) object;
                if (polymer.getSequence() != null){
                    MIJsonUtils.writeSeparator(writer);
                    MIJsonUtils.writeProperty("sequence", JSONValue.escape(polymer.getSequence()), writer);
                }
            }
            // write interactor type
            MIJsonUtils.writeSeparator(writer);
            MIJsonUtils.writePropertyKey("type", writer);
            getCvWriter().write(object.getInteractorType());

            // write organism
            if (object.getOrganism() != null){
                MIJsonUtils.writeSeparator(writer);
                MIJsonUtils.writePropertyKey("organism", writer);
                getOrganismWriter().write(object.getOrganism());
            }

            // write accession
            if (object.getPreferredIdentifier() != null){
                MIJsonUtils.writeSeparator(writer);
                MIJsonUtils.writePropertyKey("identifier", writer);
                getIdentifierWriter().write(object.getPreferredIdentifier());
            }

            if (object instanceof InteractorPool){
                InteractorPool pool = (InteractorPool)object;
                if (!pool.isEmpty()){
                    MIJsonUtils.writeSeparator(writer);
                    MIJsonUtils.writePropertyKey("setComponents", writer);
                    MIJsonUtils.writeOpenArray(writer);

                    Iterator<Interactor> interactorIterator = pool.iterator();
                    while (interactorIterator.hasNext()){
                        Interactor interactor = interactorIterator.next();
                        writeInteractorComponent(interactor);

                        if (interactorIterator.hasNext()){
                            MIJsonUtils.writeSeparator(writer);
                        }
                    }

                    MIJsonUtils.writeEndArray(writer);
                }
            }

            // write label
            MIJsonUtils.writeSeparator(writer);
            MIJsonUtils.writeProperty("label", JSONValue.escape(object.getPreferredName()), writer);
            MIJsonUtils.writeEndObject(writer);
        }
    }

    private void writeInteractorComponent(Interactor object) throws IOException {
        MIJsonUtils.writeStartObject(writer);
        // write accession
        MIJsonUtils.writeProperty("label", JSONValue.escape(object.getShortName()), writer);

        // write sequence if possible
        if (object instanceof Polymer){
            Polymer polymer = (Polymer) object;
            if (polymer.getSequence() != null){
                MIJsonUtils.writeSeparator(writer);
                MIJsonUtils.writeProperty("sequence", JSONValue.escape(polymer.getSequence()), writer);
            }
        }
        // write interactor type
        MIJsonUtils.writeSeparator(writer);
        MIJsonUtils.writePropertyKey("type", writer);
        getCvWriter().write(object.getInteractorType());

        // write organism
        if (object.getOrganism() != null){
            MIJsonUtils.writeSeparator(writer);
            MIJsonUtils.writePropertyKey("organism", writer);
            getOrganismWriter().write(object.getOrganism());
        }

        // write accession
        if (object.getPreferredIdentifier() != null){
            MIJsonUtils.writeSeparator(writer);
            MIJsonUtils.writePropertyKey("identifier", writer);
            getIdentifierWriter().write(object.getPreferredIdentifier());
        }

        // write end object
        MIJsonUtils.writeEndObject(writer);
    }

    /**
     * <p>Getter for the field <code>cvWriter</code>.</p>
     *
     * @return a {@link psidev.psi.mi.jami.json.elements.JsonElementWriter} object.
     */
    public JsonElementWriter<CvTerm> getCvWriter() {
        if (this.cvWriter == null){
            this.cvWriter = new SimpleJsonCvTermWriter(writer);
        }
        return cvWriter;
    }

    /**
     * <p>Setter for the field <code>cvWriter</code>.</p>
     *
     * @param cvWriter a {@link psidev.psi.mi.jami.json.elements.JsonElementWriter} object.
     */
    public void setCvWriter(JsonElementWriter<CvTerm> cvWriter) {
        this.cvWriter = cvWriter;
    }

    /**
     * <p>Getter for the field <code>idGenerator</code>.</p>
     *
     * @return a {@link psidev.psi.mi.jami.json.IncrementalIdGenerator} object.
     */
    public IncrementalIdGenerator getIdGenerator() {
        if (this.idGenerator == null){
            this.idGenerator = new IncrementalIdGenerator();
        }
        return idGenerator;
    }

    /**
     * <p>Setter for the field <code>idGenerator</code>.</p>
     *
     * @param idGenerator a {@link psidev.psi.mi.jami.json.IncrementalIdGenerator} object.
     */
    public void setIdGenerator(IncrementalIdGenerator idGenerator) {
        this.idGenerator = idGenerator;
    }

    /**
     * <p>Getter for the field <code>organismWriter</code>.</p>
     *
     * @return a {@link psidev.psi.mi.jami.json.elements.JsonElementWriter} object.
     */
    public JsonElementWriter<Organism> getOrganismWriter() {
        if (this.organismWriter == null){
             this.organismWriter = new SimpleJsonOrganismWriter(this.writer);
        }
        return organismWriter;
    }

    /**
     * <p>Setter for the field <code>organismWriter</code>.</p>
     *
     * @param organismWriter a {@link psidev.psi.mi.jami.json.elements.JsonElementWriter} object.
     */
    public void setOrganismWriter(JsonElementWriter<Organism> organismWriter) {
        this.organismWriter = organismWriter;
    }

    /**
     * <p>Getter for the field <code>identifierWriter</code>.</p>
     *
     * @return a {@link psidev.psi.mi.jami.json.elements.JsonElementWriter} object.
     */
    public JsonElementWriter<Xref> getIdentifierWriter() {
        if (this.identifierWriter == null){
             this.identifierWriter = new SimpleJsonIdentifierWriter(this.writer);
        }
        return identifierWriter;
    }

    /**
     * <p>Setter for the field <code>identifierWriter</code>.</p>
     *
     * @param identifierWriter a {@link psidev.psi.mi.jami.json.elements.JsonElementWriter} object.
     */
    public void setIdentifierWriter(JsonElementWriter<Xref> identifierWriter) {
        this.identifierWriter = identifierWriter;
    }

    /**
     * <p>Getter for the field <code>writer</code>.</p>
     *
     * @return a {@link java.io.Writer} object.
     */
    protected Writer getWriter() {
        return writer;
    }
}
