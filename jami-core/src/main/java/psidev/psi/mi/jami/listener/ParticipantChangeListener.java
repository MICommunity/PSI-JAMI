package psidev.psi.mi.jami.listener;

import psidev.psi.mi.jami.model.*;

/**
 * Listener for changes in a participant
 *
 * @author Gabriel Aldam (galdam@ebi.ac.uk)
 * @since 19/07/13
 */
public interface ParticipantChangeListener<F extends Participant> extends AnnotationsChangeListener<F>, XrefsChangeListener<F>, AliasesChangeListener<F>, EntityInteractorChangeListener {

    public void onBiologicalRoleUpdate(F participant, CvTerm oldType);

    public void onStoichiometryUpdate(F participant, Stoichiometry oldStoichiometry);

    public void onAddedCausalRelationship(F participant, CausalRelationship added);

    public void onRemovedCausalRelationship(F participant, CausalRelationship removed);

    public void onAddedFeature(F participant, Feature added);

    public void onRemovedFeature(F participant, Feature removed);
}
