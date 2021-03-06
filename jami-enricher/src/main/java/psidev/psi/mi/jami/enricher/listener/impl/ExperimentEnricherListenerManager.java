package psidev.psi.mi.jami.enricher.listener.impl;

import psidev.psi.mi.jami.enricher.listener.ExperimentEnricherListener;
import psidev.psi.mi.jami.model.*;

/**
 * A manager for listeners which holds a list of listeners.
 * Listener manager allows enrichers to send events to multiple listeners.
 * A listener itself, it implements all methods
 * which will then fire the corresponding method in each entry of the listener list.
 * No promise can be given to the order in which the listeners are fired.
 *
 * @author Gabriel Aldam (galdam@ebi.ac.uk)
 * @since 0 1/08/13

 */
public class ExperimentEnricherListenerManager
        extends EnricherListenerManager<Experiment, ExperimentEnricherListener>
        implements ExperimentEnricherListener{

    /**
     * <p>Constructor for ExperimentEnricherListenerManager.</p>
     *
     * @param experimentEnricherListener a {@link psidev.psi.mi.jami.enricher.listener.ExperimentEnricherListener} object.
     */
    public ExperimentEnricherListenerManager (ExperimentEnricherListener... experimentEnricherListener){
        super (experimentEnricherListener);
    }

    /** {@inheritDoc} */
    public void onPublicationUpdate(Experiment experiment, Publication oldPublication) {
        for (ExperimentEnricherListener listener : getListenersList()){
            listener.onPublicationUpdate(experiment, oldPublication);
        }
    }

    /** {@inheritDoc} */
    public void onInteractionDetectionMethodUpdate(Experiment experiment, CvTerm oldCv) {
        for (ExperimentEnricherListener listener : getListenersList()){
            listener.onInteractionDetectionMethodUpdate(experiment, oldCv);
        }
    }

    /** {@inheritDoc} */
    public void onHostOrganismUpdate(Experiment experiment, Organism oldOrganism) {
        for (ExperimentEnricherListener listener : getListenersList()){
            listener.onHostOrganismUpdate(experiment, oldOrganism);
        }
    }

    /** {@inheritDoc} */
    public void onAddedVariableParameter(Experiment experiment, VariableParameter added) {
        for (ExperimentEnricherListener listener : getListenersList()){
            listener.onAddedVariableParameter(experiment, added);
        }
    }

    /** {@inheritDoc} */
    public void onRemovedVariableParameter(Experiment o, VariableParameter removed) {
        for (ExperimentEnricherListener listener : getListenersList()){
            listener.onRemovedVariableParameter(o, removed);
        }
    }

    /** {@inheritDoc} */
    public void onAddedAnnotation(Experiment experiment, Annotation added) {
        for (ExperimentEnricherListener listener : getListenersList()){
            listener.onAddedAnnotation(experiment, added);
        }
    }

    /** {@inheritDoc} */
    public void onRemovedAnnotation(Experiment experiment, Annotation removed) {
        for (ExperimentEnricherListener listener : getListenersList()){
            listener.onRemovedAnnotation(experiment, removed);
        }
    }

    /** {@inheritDoc} */
    public void onAddedConfidence(Experiment experiment, Confidence added) {
        for (ExperimentEnricherListener listener : getListenersList()){
            listener.onAddedConfidence(experiment, added);
        }
    }

    /** {@inheritDoc} */
    public void onRemovedConfidence(Experiment experiment, Confidence removed) {
        for (ExperimentEnricherListener listener : getListenersList()){
            listener.onRemovedConfidence(experiment, removed);
        }
    }

    /** {@inheritDoc} */
    public void onAddedXref(Experiment experiment, Xref added) {
        for (ExperimentEnricherListener listener : getListenersList()){
            listener.onAddedXref(experiment, added);
        }
    }

    /** {@inheritDoc} */
    public void onRemovedXref(Experiment experiment, Xref removed) {
        for (ExperimentEnricherListener listener : getListenersList()){
            listener.onRemovedXref(experiment, removed);
        }
    }
}
