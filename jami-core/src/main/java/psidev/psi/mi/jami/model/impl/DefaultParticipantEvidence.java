package psidev.psi.mi.jami.model.impl;

import psidev.psi.mi.jami.model.*;
import psidev.psi.mi.jami.utils.CvTermUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Default implementation for ParticipantEvidence
 *
 * Notes: The equals and hashcode methods have NOT been overridden because the ParticipantEvidence object is a complex object.
 * To compare ParticipantEvidence objects, you can use some comparators provided by default:
 * - DefaultParticipantEvidenceComparator
 * - UnambiguousParticipantEvidenceComparator
 * - DefaultExactParticipantEvidenceComparator
 * - UnambiguousExactParticipantEvidenceComparator
 * - ParticipantEvidenceComparator
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>04/02/13</pre>
 */
public class DefaultParticipantEvidence extends AbstractParticipant<InteractionEvidence, FeatureEvidence> implements ParticipantEvidence {

    private CvTerm experimentalRole;
    private Collection<CvTerm> identificationMethods;
    private Collection<CvTerm> experimentalPreparations;
    private Organism expressedIn;
    private Collection<Confidence> confidences;
    private Collection<Parameter> parameters;

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interaction a {@link psidev.psi.mi.jami.model.InteractionEvidence} object.
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @param participantIdentificationMethod a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultParticipantEvidence(InteractionEvidence interaction, Interactor interactor, CvTerm participantIdentificationMethod) {
        super(interactor);
        if (participantIdentificationMethod != null){
            getIdentificationMethods().add(participantIdentificationMethod);
        }
        this.experimentalRole = CvTermUtils.createUnspecifiedRole();
        setInteraction(interaction);
    }

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interaction a {@link psidev.psi.mi.jami.model.InteractionEvidence} object.
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @param bioRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param participantIdentificationMethod a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultParticipantEvidence(InteractionEvidence interaction, Interactor interactor, CvTerm bioRole, CvTerm participantIdentificationMethod) {
        super(interactor, bioRole);
        if (participantIdentificationMethod != null){
            getIdentificationMethods().add(participantIdentificationMethod);
        }        this.experimentalRole = CvTermUtils.createUnspecifiedRole();
        setInteraction(interaction);
    }

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interaction a {@link psidev.psi.mi.jami.model.InteractionEvidence} object.
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @param stoichiometry a {@link psidev.psi.mi.jami.model.Stoichiometry} object.
     * @param participantIdentificationMethod a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultParticipantEvidence(InteractionEvidence interaction, Interactor interactor, Stoichiometry stoichiometry, CvTerm participantIdentificationMethod) {
        super(interactor, stoichiometry);
        if (participantIdentificationMethod != null){
            getIdentificationMethods().add(participantIdentificationMethod);
        }        this.experimentalRole = CvTermUtils.createUnspecifiedRole();
        setInteraction(interaction);
    }

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interaction a {@link psidev.psi.mi.jami.model.InteractionEvidence} object.
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @param bioRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param stoichiometry a {@link psidev.psi.mi.jami.model.Stoichiometry} object.
     * @param participantIdentificationMethod a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultParticipantEvidence(InteractionEvidence interaction, Interactor interactor, CvTerm bioRole, Stoichiometry stoichiometry, CvTerm participantIdentificationMethod) {
        super(interactor, bioRole, stoichiometry);
        if (participantIdentificationMethod != null){
            getIdentificationMethods().add(participantIdentificationMethod);
        }        this.experimentalRole = CvTermUtils.createUnspecifiedRole();
        setInteraction(interaction);
    }

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interaction a {@link psidev.psi.mi.jami.model.InteractionEvidence} object.
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @param bioRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param expRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param participantIdentificationMethod a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultParticipantEvidence(InteractionEvidence interaction, Interactor interactor, CvTerm bioRole, CvTerm expRole, CvTerm participantIdentificationMethod) {
        super(interactor, bioRole);
        if(expRole == null){
           this.experimentalRole = CvTermUtils.createUnspecifiedRole();
        }
        else {
            this.experimentalRole = expRole;
        }
        if (participantIdentificationMethod != null){
            getIdentificationMethods().add(participantIdentificationMethod);
        }
        setInteraction(interaction);
    }

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interaction a {@link psidev.psi.mi.jami.model.InteractionEvidence} object.
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @param bioRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param expRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param stoichiometry a {@link psidev.psi.mi.jami.model.Stoichiometry} object.
     * @param participantIdentificationMethod a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultParticipantEvidence(InteractionEvidence interaction, Interactor interactor, CvTerm bioRole, CvTerm expRole, Stoichiometry stoichiometry, CvTerm participantIdentificationMethod) {
        super(interactor, bioRole, stoichiometry);
        if(expRole == null){
            this.experimentalRole = CvTermUtils.createUnspecifiedRole();
        }
        else {
            this.experimentalRole = expRole;
        }
        if (participantIdentificationMethod != null){
            getIdentificationMethods().add(participantIdentificationMethod);
        }
        setInteraction(interaction);
    }

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interaction a {@link psidev.psi.mi.jami.model.InteractionEvidence} object.
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @param bioRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param expRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param expressedIn a {@link psidev.psi.mi.jami.model.Organism} object.
     * @param participantIdentificationMethod a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultParticipantEvidence(InteractionEvidence interaction, Interactor interactor, CvTerm bioRole, CvTerm expRole, Organism expressedIn, CvTerm participantIdentificationMethod) {
        super(interactor, bioRole);
        if(expRole == null){
            this.experimentalRole = CvTermUtils.createUnspecifiedRole();
        }
        else {
            this.experimentalRole = expRole;
        }
        this.expressedIn = expressedIn;
        if (participantIdentificationMethod != null){
            getIdentificationMethods().add(participantIdentificationMethod);
        }
        setInteraction(interaction);
    }

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interaction a {@link psidev.psi.mi.jami.model.InteractionEvidence} object.
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @param bioRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param expRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param stoichiometry a {@link psidev.psi.mi.jami.model.Stoichiometry} object.
     * @param expressedIn a {@link psidev.psi.mi.jami.model.Organism} object.
     * @param participantIdentificationMethod a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultParticipantEvidence(InteractionEvidence interaction, Interactor interactor, CvTerm bioRole, CvTerm expRole, Stoichiometry stoichiometry, Organism expressedIn, CvTerm participantIdentificationMethod) {
        super(interactor, bioRole, stoichiometry);
        if(expRole == null){
            this.experimentalRole = CvTermUtils.createUnspecifiedRole();
        }
        else {
            this.experimentalRole = expRole;
        }
        this.expressedIn = expressedIn;
        if (participantIdentificationMethod != null){
            getIdentificationMethods().add(participantIdentificationMethod);
        }
        setInteraction(interaction);
    }

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @param participantIdentificationMethod a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultParticipantEvidence(Interactor interactor, CvTerm participantIdentificationMethod) {
        super(interactor);
        if (participantIdentificationMethod != null){
            getIdentificationMethods().add(participantIdentificationMethod);
        }
        this.experimentalRole = CvTermUtils.createUnspecifiedRole();
    }

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @param bioRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param participantIdentificationMethod a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultParticipantEvidence(Interactor interactor, CvTerm bioRole, CvTerm participantIdentificationMethod) {
        super(interactor, bioRole);
        if (participantIdentificationMethod != null){
            getIdentificationMethods().add(participantIdentificationMethod);
        }
        this.experimentalRole = CvTermUtils.createUnspecifiedRole();
    }

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @param stoichiometry a {@link psidev.psi.mi.jami.model.Stoichiometry} object.
     * @param participantIdentificationMethod a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultParticipantEvidence(Interactor interactor, Stoichiometry stoichiometry, CvTerm participantIdentificationMethod) {
        super(interactor, stoichiometry);
        if (participantIdentificationMethod != null){
            getIdentificationMethods().add(participantIdentificationMethod);
        }
        this.experimentalRole = CvTermUtils.createUnspecifiedRole();
    }

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @param bioRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param expRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param participantIdentificationMethod a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultParticipantEvidence(Interactor interactor, CvTerm bioRole, CvTerm expRole, CvTerm participantIdentificationMethod) {
        super(interactor, bioRole);
        if(expRole == null){
            this.experimentalRole = CvTermUtils.createUnspecifiedRole();
        }
        else {
            this.experimentalRole = expRole;
        }
        if (participantIdentificationMethod != null){
            getIdentificationMethods().add(participantIdentificationMethod);
        }
    }

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @param bioRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param expRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param stoichiometry a {@link psidev.psi.mi.jami.model.Stoichiometry} object.
     * @param participantIdentificationMethod a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultParticipantEvidence(Interactor interactor, CvTerm bioRole, CvTerm expRole, Stoichiometry stoichiometry, CvTerm participantIdentificationMethod) {
        super(interactor, bioRole, stoichiometry);
        if(expRole == null){
            this.experimentalRole = CvTermUtils.createUnspecifiedRole();
        }
        else {
            this.experimentalRole = expRole;
        }
        if (participantIdentificationMethod != null){
            getIdentificationMethods().add(participantIdentificationMethod);
        }
    }

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @param bioRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param expRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param expressedIn a {@link psidev.psi.mi.jami.model.Organism} object.
     * @param participantIdentificationMethod a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultParticipantEvidence(Interactor interactor, CvTerm bioRole, CvTerm expRole, Organism expressedIn, CvTerm participantIdentificationMethod) {
        super(interactor, bioRole);
        if(expRole == null){
            this.experimentalRole = CvTermUtils.createUnspecifiedRole();
        }
        else {
            this.experimentalRole = expRole;
        }
        this.expressedIn = expressedIn;
        if (participantIdentificationMethod != null){
            getIdentificationMethods().add(participantIdentificationMethod);
        }
    }

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @param bioRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param expRole a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param stoichiometry a {@link psidev.psi.mi.jami.model.Stoichiometry} object.
     * @param expressedIn a {@link psidev.psi.mi.jami.model.Organism} object.
     * @param participantIdentificationMethod a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultParticipantEvidence(Interactor interactor, CvTerm bioRole, CvTerm expRole, Stoichiometry stoichiometry, Organism expressedIn, CvTerm participantIdentificationMethod) {
        super(interactor, bioRole, stoichiometry);
        if(expRole == null){
            this.experimentalRole = CvTermUtils.createUnspecifiedRole();
        }
        else {
            this.experimentalRole = expRole;
        }
        this.expressedIn = expressedIn;
        if (participantIdentificationMethod != null){
            getIdentificationMethods().add(participantIdentificationMethod);
        }
    }

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     */
    public DefaultParticipantEvidence(Interactor interactor) {
        super(interactor);
        this.experimentalRole = CvTermUtils.createUnspecifiedRole();
    }

    /**
     * <p>Constructor for DefaultParticipantEvidence.</p>
     *
     * @param interactor a {@link psidev.psi.mi.jami.model.Interactor} object.
     * @param stoichiometry a {@link psidev.psi.mi.jami.model.Stoichiometry} object.
     */
    public DefaultParticipantEvidence(Interactor interactor, Stoichiometry stoichiometry) {
        super(interactor, stoichiometry);
        this.experimentalRole = CvTermUtils.createUnspecifiedRole();
    }

    /**
     * <p>initialiseExperimentalPreparations</p>
     */
    protected void initialiseExperimentalPreparations() {
        this.experimentalPreparations = new ArrayList<CvTerm>();
    }

    /**
     * <p>initialiseConfidences</p>
     */
    protected void initialiseConfidences() {
        this.confidences = new ArrayList<Confidence>();
    }

    /**
     * <p>initialiseParameters</p>
     */
    protected void initialiseParameters() {
        this.parameters = new ArrayList<Parameter>();
    }

    /**
     * <p>initialiseIdentificationMethods</p>
     */
    protected void initialiseIdentificationMethods(){
        this.identificationMethods = new ArrayList<CvTerm>();
    }

    /**
     * <p>initialiseIdentificationMethodsWith</p>
     *
     * @param methods a {@link java.util.Collection} object.
     */
    protected void initialiseIdentificationMethodsWith(Collection<CvTerm> methods){
        if (methods == null){
            this.identificationMethods = Collections.EMPTY_LIST;
        }
        else {
            this.identificationMethods = methods;
        }
    }

    /**
     * <p>initialiseExperimentalPreparationsWith</p>
     *
     * @param expPreparations a {@link java.util.Collection} object.
     */
    protected void initialiseExperimentalPreparationsWith(Collection<CvTerm> expPreparations) {
        if (expPreparations == null){
            this.experimentalPreparations = Collections.EMPTY_LIST;
        }
        else {
            this.experimentalPreparations = expPreparations;
        }
    }

    /**
     * <p>initialiseConfidencesWith</p>
     *
     * @param confidences a {@link java.util.Collection} object.
     */
    protected void initialiseConfidencesWith(Collection<Confidence> confidences) {
        if (confidences == null){
            this.confidences = Collections.EMPTY_LIST;
        }
        else {
            this.confidences = confidences;
        }
    }

    /**
     * <p>initialiseParametersWith</p>
     *
     * @param parameters a {@link java.util.Collection} object.
     */
    protected void initialiseParametersWith(Collection<Parameter> parameters) {
        if (parameters == null){
            this.parameters = Collections.EMPTY_LIST;
        }
        else {
            this.parameters = parameters;
        }
    }

    /**
     * <p>Getter for the field <code>experimentalRole</code>.</p>
     *
     * @return a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public CvTerm getExperimentalRole() {
        return this.experimentalRole;
    }

    /** {@inheritDoc} */
    public void setExperimentalRole(CvTerm expRole) {
        if (expRole == null){
           this.experimentalRole = CvTermUtils.createUnspecifiedRole();
        }
        else {
            this.experimentalRole = expRole;
        }
    }

    /**
     * <p>Getter for the field <code>identificationMethods</code>.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<CvTerm> getIdentificationMethods() {
        if (identificationMethods == null){
            initialiseIdentificationMethods();
        }
        return this.identificationMethods;
    }

    /**
     * <p>Getter for the field <code>experimentalPreparations</code>.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<CvTerm> getExperimentalPreparations() {
        if (experimentalPreparations == null){
            initialiseExperimentalPreparations();
        }
        return this.experimentalPreparations;
    }

    /**
     * <p>getExpressedInOrganism</p>
     *
     * @return a {@link psidev.psi.mi.jami.model.Organism} object.
     */
    public Organism getExpressedInOrganism() {
        return this.expressedIn;
    }

    /** {@inheritDoc} */
    public void setExpressedInOrganism(Organism organism) {
        this.expressedIn = organism;
    }

    /**
     * <p>Getter for the field <code>confidences</code>.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<Confidence> getConfidences() {
        if (confidences == null){
            initialiseConfidences();
        }
        return this.confidences;
    }

    /**
     * <p>Getter for the field <code>parameters</code>.</p>
     *
     * @return a {@link java.util.Collection} object.
     */
    public Collection<Parameter> getParameters() {
        if (parameters == null){
            initialiseParameters();
        }
        return this.parameters;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return super.toString()
                + (getExperimentalRole() != null ? ", " + getExperimentalRole().toString() : "")
                + (getExpressedInOrganism() != null ? ", " + getExpressedInOrganism().toString() : "");
    }
}
