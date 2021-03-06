package psidev.psi.mi.jami.enricher.listener;

import psidev.psi.mi.jami.listener.ModelledInteractionChangeListener;
import psidev.psi.mi.jami.model.ModelledInteraction;

/**
 *Listener for modelled interaction enrichment
 *
 * @author Gabriel Aldam (galdam@ebi.ac.uk)
 * @since 28/06/13

 */
public interface ModelledInteractionEnricherListener<I extends ModelledInteraction> extends InteractionEnricherListener<I>, ModelledInteractionChangeListener<I> {

}
