package psidev.psi.mi.jami.utils.comparator.interaction;

import psidev.psi.mi.jami.model.Interaction;

/**
 * Unambiguous exact curated Generic interaction comparator.
 * Modelled interactions come first and then experimental interactions
 * - It uses UnambiguousExactCuratedInteractionEvidenceComparator to compare experimental interactions
 * - It uses UnambiguousExactCuratedModelledInteractionComparator to compare modelled interactions
 * - It uses UnambiguousCuratedInteractionBaseComparator to compare basic interaction properties
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>05/02/13</pre>
 */
public class UnambiguousExactCuratedInteractionComparator extends InteractionComparator {

    private static UnambiguousExactCuratedInteractionComparator unambiguousExactCuratedInteractionComparator;

    /**
     * {@inheritDoc}
     *
     * Creates a new UnambiguousExactCuratedInteractionComparator.
     */
    public UnambiguousExactCuratedInteractionComparator() {
        super(new UnambiguousCuratedInteractionBaseComparator(), new UnambiguousExactCuratedModelledInteractionComparator(), new UnambiguousExactCuratedInteractionEvidenceComparator());
    }

    /** {@inheritDoc} */
    @Override
    public UnambiguousCuratedInteractionBaseComparator getInteractionBaseComparator() {
        return (UnambiguousCuratedInteractionBaseComparator) super.getInteractionBaseComparator();
    }

    /** {@inheritDoc} */
    @Override
    public UnambiguousExactCuratedInteractionEvidenceComparator getExperimentalInteractionComparator() {
        return (UnambiguousExactCuratedInteractionEvidenceComparator) super.getExperimentalInteractionComparator();
    }

    @Override
    public UnambiguousExactCuratedModelledInteractionComparator getModelledInteractionComparator() {
        return (UnambiguousExactCuratedModelledInteractionComparator) super.getModelledInteractionComparator();
    }

    /**
     * Modelled interactions come first and then experimental interactions
     * - It uses UnambiguousExactCuratedInteractionEvidenceComparator to compare experimental interactions
     * - It uses UnambiguousExactCuratedModelledInteractionComparator to compare modelled interactions
     * - It uses UnambiguousCuratedInteractionBaseComparator to compare basic interaction properties
     */
    @Override
    public int compare(Interaction interaction1, Interaction interaction2) {
        return super.compare(interaction1, interaction2);
    }

    /**
     * Use UnambiguousExactCuratedInteractionComparator to know if two interactions are equals.
     *
     * @param interaction1 a {@link psidev.psi.mi.jami.model.Interaction} object.
     * @param interaction2 a {@link psidev.psi.mi.jami.model.Interaction} object.
     * @return true if the two interactions are equal
     */
    public static boolean areEquals(Interaction interaction1, Interaction interaction2){
        if (unambiguousExactCuratedInteractionComparator == null){
            unambiguousExactCuratedInteractionComparator = new UnambiguousExactCuratedInteractionComparator();
        }

        return unambiguousExactCuratedInteractionComparator.compare(interaction1, interaction2) == 0;
    }
}
