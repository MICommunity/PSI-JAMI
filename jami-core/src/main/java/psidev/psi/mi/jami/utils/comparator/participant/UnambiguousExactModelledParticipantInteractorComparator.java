package psidev.psi.mi.jami.utils.comparator.participant;

import psidev.psi.mi.jami.model.ModelledEntity;
import psidev.psi.mi.jami.utils.comparator.interactor.UnambiguousExactComplexComparator;
import psidev.psi.mi.jami.utils.comparator.interactor.UnambiguousExactInteractorComparator;

/**
 * Unambiguous exact biological participant comparator based on the interactor only.
 * It will compare the basic properties of an interactor using UnambiguousExactInteractorComparator.
 *
 * This comparator will ignore all the other properties of a biological participant.
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>30/05/13</pre>
 */
public class UnambiguousExactModelledParticipantInteractorComparator extends
        ParticipantInteractorComparator<ModelledEntity> implements CustomizableModelledParticipantComparator<ModelledEntity>{

    private static UnambiguousExactModelledParticipantInteractorComparator unambiguousExactParticipantInteractorComparator;

    private boolean checkComplexesAsInteractor = true;

    /**
     * {@inheritDoc}
     *
     * Creates a new UnambiguousExactModelledParticipantInteractorComparator. It will use a UnambiguousExactInteractorComparator to compare
     * the basic properties of an interactor.
     */
    public UnambiguousExactModelledParticipantInteractorComparator() {
        super(null);
        setInteractorComparator(new UnambiguousExactInteractorComparator(new UnambiguousExactComplexComparator(this)));
    }

    @Override
    public UnambiguousExactInteractorComparator getInteractorComparator() {
        return (UnambiguousExactInteractorComparator) super.getInteractorComparator();
    }

    /**
     * It will compare the basic properties of an interactor using UnambiguousInteractorComparator.
     *
     * This comparator will ignore all the other properties of a biological participant.
     */
    @Override
    public int compare(ModelledEntity component1, ModelledEntity component2) {
        return checkComplexesAsInteractor ? super.compare(component1, component2) : 0;
    }

    /**
     * Use UnambiguousExactModelledParticipantInteractorComparator to know if two biological participants are equals.
     *
     * @param component1 a {@link psidev.psi.mi.jami.model.ModelledEntity} object.
     * @param component2 a {@link psidev.psi.mi.jami.model.ModelledEntity} object.
     * @return true if the two biological participants are equal
     */
    public static boolean areEquals(ModelledEntity component1, ModelledEntity component2){
        if (unambiguousExactParticipantInteractorComparator == null){
            unambiguousExactParticipantInteractorComparator = new UnambiguousExactModelledParticipantInteractorComparator();
        }

        return unambiguousExactParticipantInteractorComparator.compare(component1, component2) == 0;
    }

    /**
     * <p>isCheckComplexesAsInteractors</p>
     *
     * @return a boolean.
     */
    public boolean isCheckComplexesAsInteractors() {
        return checkComplexesAsInteractor;
    }

    /** {@inheritDoc} */
    public void setCheckComplexesAsInteractors(boolean checkComplexesAsInteractors) {
        this.checkComplexesAsInteractor = checkComplexesAsInteractors;
    }

    /**
     * <p>clearProcessedComplexes</p>
     */
    public void clearProcessedComplexes() {
        // do nothing
    }
}
