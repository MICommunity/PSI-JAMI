package psidev.psi.mi.jami.model.impl;

import psidev.psi.mi.jami.model.*;
import psidev.psi.mi.jami.utils.AliasUtils;
import psidev.psi.mi.jami.utils.ChecksumUtils;
import psidev.psi.mi.jami.utils.CvTermUtils;
import psidev.psi.mi.jami.utils.XrefUtils;
import psidev.psi.mi.jami.utils.collection.AbstractListHavingProperties;

/**
 * Default implementation for proteins and peptides
 *
 * Notes: The equals and hashcode methods have NOT been overridden because the Protein object is a complex object.
 * To compare Protein objects, you can use some comparators provided by default:
 * - DefaultProteinComparator
 * - UnambiguousProteinComparator
 * - DefaultExactProteinComparator
 * - UnambiguousExactProteinComparator
 * - AvbstractProteinComparator
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>01/02/13</pre>
 */
public class DefaultProtein extends DefaultPolymer implements Protein {

    private Xref uniprotkb;
    private Xref refseq;
    private Alias geneName;
    private Checksum rogid;

    /**
     * <p>Constructor for DefaultProtein.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param type a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultProtein(String name, CvTerm type) {
        super(name, type != null ? type : CvTermUtils.createProteinInteractorType());
    }

    /**
     * <p>Constructor for DefaultProtein.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param fullName a {@link java.lang.String} object.
     * @param type a {@link psidev.psi.mi.jami.model.CvTerm} object.
     */
    public DefaultProtein(String name, String fullName, CvTerm type) {
        super(name, fullName, type != null ? type : CvTermUtils.createProteinInteractorType());
    }

    /**
     * <p>Constructor for DefaultProtein.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param type a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param organism a {@link psidev.psi.mi.jami.model.Organism} object.
     */
    public DefaultProtein(String name, CvTerm type, Organism organism) {
        super(name, type != null ? type : CvTermUtils.createProteinInteractorType(), organism);
    }

    /**
     * <p>Constructor for DefaultProtein.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param fullName a {@link java.lang.String} object.
     * @param type a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param organism a {@link psidev.psi.mi.jami.model.Organism} object.
     */
    public DefaultProtein(String name, String fullName, CvTerm type, Organism organism) {
        super(name, fullName, type != null ? type : CvTermUtils.createProteinInteractorType(), organism);
    }

    /**
     * <p>Constructor for DefaultProtein.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param type a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param uniqueId a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    public DefaultProtein(String name, CvTerm type, Xref uniqueId) {
        super(name, type != null ? type : CvTermUtils.createProteinInteractorType(), uniqueId);
    }

    /**
     * <p>Constructor for DefaultProtein.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param fullName a {@link java.lang.String} object.
     * @param type a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param uniqueId a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    public DefaultProtein(String name, String fullName, CvTerm type, Xref uniqueId) {
        super(name, fullName, type != null ? type : CvTermUtils.createProteinInteractorType(), uniqueId);
    }

    /**
     * <p>Constructor for DefaultProtein.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param type a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param organism a {@link psidev.psi.mi.jami.model.Organism} object.
     * @param uniqueId a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    public DefaultProtein(String name, CvTerm type, Organism organism, Xref uniqueId) {
        super(name, type != null ? type : CvTermUtils.createProteinInteractorType(), organism, uniqueId);
    }

    /**
     * <p>Constructor for DefaultProtein.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param fullName a {@link java.lang.String} object.
     * @param type a {@link psidev.psi.mi.jami.model.CvTerm} object.
     * @param organism a {@link psidev.psi.mi.jami.model.Organism} object.
     * @param uniqueId a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    public DefaultProtein(String name, String fullName, CvTerm type, Organism organism, Xref uniqueId) {
        super(name, fullName, type != null ? type : CvTermUtils.createProteinInteractorType(), organism, uniqueId);
    }

    /**
     * <p>Constructor for DefaultProtein.</p>
     *
     * @param name a {@link java.lang.String} object.
     */
    public DefaultProtein(String name) {
        super(name, CvTermUtils.createProteinInteractorType());
    }

    /**
     * <p>Constructor for DefaultProtein.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param fullName a {@link java.lang.String} object.
     */
    public DefaultProtein(String name, String fullName) {
        super(name, fullName, CvTermUtils.createProteinInteractorType());
    }

    /**
     * <p>Constructor for DefaultProtein.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param organism a {@link psidev.psi.mi.jami.model.Organism} object.
     */
    public DefaultProtein(String name, Organism organism) {
        super(name, CvTermUtils.createProteinInteractorType(), organism);
    }

    /**
     * <p>Constructor for DefaultProtein.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param fullName a {@link java.lang.String} object.
     * @param organism a {@link psidev.psi.mi.jami.model.Organism} object.
     */
    public DefaultProtein(String name, String fullName, Organism organism) {
        super(name, fullName, CvTermUtils.createProteinInteractorType(), organism);
    }

    /**
     * <p>Constructor for DefaultProtein.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param uniqueId a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    public DefaultProtein(String name, Xref uniqueId) {
        super(name, CvTermUtils.createProteinInteractorType(), uniqueId);
    }

    /**
     * <p>Constructor for DefaultProtein.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param fullName a {@link java.lang.String} object.
     * @param uniqueId a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    public DefaultProtein(String name, String fullName, Xref uniqueId) {
        super(name, fullName, CvTermUtils.createProteinInteractorType(), uniqueId);
    }

    /**
     * <p>Constructor for DefaultProtein.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param organism a {@link psidev.psi.mi.jami.model.Organism} object.
     * @param uniqueId a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    public DefaultProtein(String name, Organism organism, Xref uniqueId) {
        super(name, CvTermUtils.createProteinInteractorType(), organism, uniqueId);
    }

    /**
     * <p>Constructor for DefaultProtein.</p>
     *
     * @param name a {@link java.lang.String} object.
     * @param fullName a {@link java.lang.String} object.
     * @param organism a {@link psidev.psi.mi.jami.model.Organism} object.
     * @param uniqueId a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    public DefaultProtein(String name, String fullName, Organism organism, Xref uniqueId) {
        super(name, fullName, CvTermUtils.createProteinInteractorType(), organism, uniqueId);
    }

    /** {@inheritDoc} */
    @Override
    protected void initialiseIdentifiers() {
        initialiseIdentifiersWith(new ProteinIdentifierList());
    }

    /** {@inheritDoc} */
    @Override
    protected void initialiseChecksums() {
        initialiseChecksumsWith(new ProteinChecksumList());
    }

    /** {@inheritDoc} */
    @Override
    protected void initialiseAliases() {
        initialiseAliasesWith(new ProteinAliasList());
    }

    /** {@inheritDoc} */
    @Override
    public Xref getPreferredIdentifier() {
        return uniprotkb != null ? uniprotkb : (refseq != null ? refseq : super.getPreferredIdentifier());
    }

    /** {@inheritDoc} */
    @Override
    public String getPreferredName(){
        return this.getGeneName();
    }

    /**
     * <p>Getter for the field <code>uniprotkb</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getUniprotkb() {
        return this.uniprotkb != null ? this.uniprotkb.getId() : null;
    }

    /** {@inheritDoc} */
    public void setUniprotkb(String ac) {
        ProteinIdentifierList proteinIdentifiers = (ProteinIdentifierList)getIdentifiers();

        // add new uniprotkb if not null
        if (ac != null){
            CvTerm uniprotkbDatabase = CvTermUtils.createUniprotkbDatabase();
            CvTerm identityQualifier = CvTermUtils.createIdentityQualifier();
            // first remove old uniprotkb if not null
            if (this.uniprotkb != null){
                proteinIdentifiers.removeOnly(this.uniprotkb);
            }
            this.uniprotkb = new DefaultXref(uniprotkbDatabase, ac, identityQualifier);
            proteinIdentifiers.addOnly(this.uniprotkb);
        }
        // remove all uniprotkb if the collection is not empty
        else if (!proteinIdentifiers.isEmpty()) {
            XrefUtils.removeAllXrefsWithDatabase(proteinIdentifiers, Xref.UNIPROTKB_MI, Xref.UNIPROTKB);
            this.uniprotkb = null;
        }
    }

    /**
     * <p>Getter for the field <code>refseq</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRefseq() {
        return this.refseq != null ? this.refseq.getId() : null;
    }

    /** {@inheritDoc} */
    public void setRefseq(String ac) {
        ProteinIdentifierList proteinIdentifiers = (ProteinIdentifierList)getIdentifiers();

        // add new refseq if not null
        if (ac != null){
            CvTerm refseqDatabase = CvTermUtils.createRefseqDatabase();
            CvTerm identityQualifier = CvTermUtils.createIdentityQualifier();
            // first remove old refseq if not null
            if (this.refseq != null){
                proteinIdentifiers.removeOnly(this.refseq);
            }
            this.refseq = new DefaultXref(refseqDatabase, ac, identityQualifier);
            proteinIdentifiers.addOnly(this.refseq);
        }
        // remove all refseq if the collection is not empty
        else if (!proteinIdentifiers.isEmpty()) {
            XrefUtils.removeAllXrefsWithDatabase(proteinIdentifiers, Xref.REFSEQ_MI, Xref.REFSEQ);
            this.refseq = null;
        }
    }

    /**
     * <p>Getter for the field <code>geneName</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getGeneName() {
        return this.geneName != null ? this.geneName.getName() : null;
    }

    /** {@inheritDoc} */
    public void setGeneName(String name) {
        ProteinAliasList proteinAliases = (ProteinAliasList)getAliases();

        // add new gene name if not null
        if (name != null){
            CvTerm geneNameType = CvTermUtils.createGeneNameAliasType();
            // first remove old gene name if not null
            if (this.geneName != null){
                proteinAliases.removeOnly(this.geneName);
            }
            this.geneName = new DefaultAlias(geneNameType, name);
            proteinAliases.addOnly(this.geneName);
        }
        // remove all gene names if the collection is not empty
        else if (!proteinAliases.isEmpty()) {
            AliasUtils.removeAllAliasesWithType(proteinAliases, Alias.GENE_NAME_MI, Alias.GENE_NAME);
            this.geneName = null;
        }
    }

    /**
     * <p>Getter for the field <code>rogid</code>.</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String getRogid() {
        return this.rogid != null ? this.rogid.getValue() : null;
    }

    /** {@inheritDoc} */
    public void setRogid(String rogid) {
        ProteinChecksumList proteinChecksums = (ProteinChecksumList)getChecksums();

        if (rogid != null){
            CvTerm rogidMethod = CvTermUtils.createRogid();
            // first remove old rogid
            if (this.rogid != null){
                proteinChecksums.removeOnly(this.rogid);
            }
            this.rogid = new DefaultChecksum(rogidMethod, rogid);
            proteinChecksums.addOnly(this.rogid);
        }
        // remove all smiles if the collection is not empty
        else if (!proteinChecksums.isEmpty()) {
            ChecksumUtils.removeAllChecksumWithMethod(proteinChecksums, Checksum.ROGID_MI, Checksum.ROGID);
            this.rogid = null;
        }
    }

    /**
     * <p>processAddedAliasEvent</p>
     *
     * @param added a {@link psidev.psi.mi.jami.model.Alias} object.
     */
    protected void processAddedAliasEvent(Alias added) {
        // the added alias is gene name and it is not the current gene name
        if (geneName == null && AliasUtils.doesAliasHaveType(added, Alias.GENE_NAME_MI, Alias.GENE_NAME)){
            geneName = added;
        }
    }

    /**
     * <p>processRemovedAliasEvent</p>
     *
     * @param removed a {@link psidev.psi.mi.jami.model.Alias} object.
     */
    protected void processRemovedAliasEvent(Alias removed) {
        if (geneName != null && geneName.equals(removed)){
            geneName = AliasUtils.collectFirstAliasWithType(getAliases(), Alias.GENE_NAME_MI, Alias.GENE_NAME);
        }
    }

    /**
     * <p>clearPropertiesLinkedToAliases</p>
     */
    protected void clearPropertiesLinkedToAliases() {
        geneName = null;
    }

    /**
     * <p>processAddedChecksumEvent</p>
     *
     * @param added a {@link psidev.psi.mi.jami.model.Checksum} object.
     */
    protected void processAddedChecksumEvent(Checksum added) {
        if (rogid == null && ChecksumUtils.doesChecksumHaveMethod(added, Checksum.ROGID_MI, Checksum.ROGID)){
            // the rogid is not set, we can set the rogid
            rogid = added;
        }
    }

    /**
     * <p>processRemovedChecksumEvent</p>
     *
     * @param removed a {@link psidev.psi.mi.jami.model.Checksum} object.
     */
    protected void processRemovedChecksumEvent(Checksum removed) {
        if (rogid != null && rogid.equals(removed)){
            rogid = ChecksumUtils.collectFirstChecksumWithMethod(getChecksums(), Checksum.ROGID_MI, Checksum.ROGID);
        }
    }

    /**
     * <p>clearPropertiesLinkedToChecksums</p>
     */
    protected void clearPropertiesLinkedToChecksums() {
        rogid = null;
    }

    /**
     * <p>processAddedIdentifierEvent</p>
     *
     * @param added a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    protected void processAddedIdentifierEvent(Xref added) {
        // the added identifier is uniprotkb and it is not the current uniprotkb identifier
        if (uniprotkb != added && (XrefUtils.isXrefFromDatabase(added, Xref.UNIPROTKB_MI, Xref.UNIPROTKB)
        || XrefUtils.isXrefFromDatabase(added, Xref.UNIPROTKB_SWISSPROT_MI, Xref.UNIPROTKB_SWISSPROT)
        || XrefUtils.isXrefFromDatabase(added, Xref.UNIPROTKB_TREMBL_MI, Xref.UNIPROTKB_TREMBL))){
            // the current uniprotkb identifier is not identity, we may want to set uniprotkb Identifier
            if (!XrefUtils.doesXrefHaveQualifier(uniprotkb, Xref.IDENTITY_MI, Xref.IDENTITY)){
                // the uniprotkb identifier is not set, we can set the uniprotkb identifier
                if (uniprotkb == null){
                    uniprotkb = added;
                }
                else if (XrefUtils.doesXrefHaveQualifier(added, Xref.IDENTITY_MI, Xref.IDENTITY)){
                    uniprotkb = added;
                }
                // the added xref is secondary object and the current uniprotkb identifier is not a secondary object, we reset uniprotkb identifier
                else if (!XrefUtils.doesXrefHaveQualifier(uniprotkb, Xref.SECONDARY_MI, Xref.SECONDARY)
                        && XrefUtils.doesXrefHaveQualifier(added, Xref.SECONDARY_MI, Xref.SECONDARY)){
                    uniprotkb = added;
                }
            }
        }
        // the added identifier is refseq id and it is not the current refseq id
        else if (refseq != added && XrefUtils.isXrefFromDatabase(added, Xref.REFSEQ_MI, Xref.REFSEQ)){
            // the current refseq id is not identity, we may want to set refseq id
            if (!XrefUtils.doesXrefHaveQualifier(refseq, Xref.IDENTITY_MI, Xref.IDENTITY)){
                // the refseq id is not set, we can set the refseq id
                if (refseq == null){
                    refseq = added;
                }
                else if (XrefUtils.doesXrefHaveQualifier(added, Xref.IDENTITY_MI, Xref.IDENTITY)){
                    refseq = added;
                }
                // the added xref is secondary object and the current refseq id is not a secondary object, we reset refseq id
                else if (!XrefUtils.doesXrefHaveQualifier(refseq, Xref.SECONDARY_MI, Xref.SECONDARY)
                        && XrefUtils.doesXrefHaveQualifier(added, Xref.SECONDARY_MI, Xref.SECONDARY)){
                    refseq = added;
                }
            }
        }
    }

    /**
     * <p>processRemovedIdentifierEvent</p>
     *
     * @param removed a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    protected void processRemovedIdentifierEvent(Xref removed) {
        if (uniprotkb != null && uniprotkb.equals(removed)){
            uniprotkb = XrefUtils.collectFirstIdentifierWithDatabase(getIdentifiers(), Xref.UNIPROTKB_MI, Xref.UNIPROTKB);
            if (uniprotkb == null){
                uniprotkb = XrefUtils.collectFirstIdentifierWithDatabase(getIdentifiers(), Xref.UNIPROTKB_SWISSPROT_MI, Xref.UNIPROTKB_SWISSPROT);
                if (uniprotkb == null){
                    uniprotkb = XrefUtils.collectFirstIdentifierWithDatabase(getIdentifiers(), Xref.UNIPROTKB_TREMBL_MI, Xref.UNIPROTKB_TREMBL);
                }
            }
        }
        else if (refseq != null && refseq.equals(removed)){
            refseq = XrefUtils.collectFirstIdentifierWithDatabase(getIdentifiers(), Xref.REFSEQ_MI, Xref.REFSEQ);
        }
    }

    /**
     * <p>clearPropertiesLinkedToIdentifiers</p>
     */
    protected void clearPropertiesLinkedToIdentifiers() {
        uniprotkb = null;
        refseq = null;
    }

    /**
     * {@inheritDoc}
     *
     * Sets the interactor type of this protein.
     * If the given interactorType is null, it will set the interactor type to 'protein' (MI:0326)
     */
    @Override
    public void setInteractorType(CvTerm interactorType) {
        if (interactorType == null){
            super.setInteractorType(CvTermUtils.createProteinInteractorType());
        }
        else {
            super.setInteractorType(interactorType);
        }
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "Protein"
                +(getGeneName() != null ? getGeneName() :
                (getUniprotkb() != null ? getUniprotkb() :
                        (getRefseq() != null ? getRefseq() : super.toString())));
    }

    private class ProteinIdentifierList extends AbstractListHavingProperties<Xref> {
        public ProteinIdentifierList(){
            super();
        }

        @Override
        protected void processAddedObjectEvent(Xref added) {
            processAddedIdentifierEvent(added);
        }

        @Override
        protected void processRemovedObjectEvent(Xref removed) {
            processRemovedIdentifierEvent(removed);
        }

        @Override
        protected void clearProperties() {
            clearPropertiesLinkedToIdentifiers();
        }
    }

    private class ProteinChecksumList extends AbstractListHavingProperties<Checksum> {
        public ProteinChecksumList(){
            super();
        }

        @Override
        protected void processAddedObjectEvent(Checksum added) {
            processAddedChecksumEvent(added);
        }

        @Override
        protected void processRemovedObjectEvent(Checksum removed) {
            processRemovedChecksumEvent(removed);
        }

        @Override
        protected void clearProperties() {
            clearPropertiesLinkedToChecksums();
        }
    }

    private class ProteinAliasList extends AbstractListHavingProperties<Alias> {
        public ProteinAliasList(){
            super();
        }

        @Override
        protected void processAddedObjectEvent(Alias added) {
            processAddedAliasEvent(added);
        }

        @Override
        protected void processRemovedObjectEvent(Alias removed) {
            processRemovedAliasEvent(removed);
        }

        @Override
        protected void clearProperties() {
            clearPropertiesLinkedToAliases();
        }
    }
}
