package psidev.psi.mi.jami.listener.impl;

import psidev.psi.mi.jami.listener.ExperimentChangeListener;
import psidev.psi.mi.jami.model.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This listener will listen to experiment change events
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>11/06/13</pre>
 */
public class ExperimentChangeLogger implements ExperimentChangeListener {

    private static final Logger experimentChangeLogger = Logger.getLogger("ExperimentChangeLogger");

    /** {@inheritDoc} */
    public void onPublicationUpdate(Experiment experiment, Publication oldPublication) {
        if (oldPublication == null){
            experimentChangeLogger.log(Level.INFO, "The publication has been initialised for the experiment " + experiment.toString());
        }
        else if (experiment.getPublication() == null){
            experimentChangeLogger.log(Level.INFO, "The publication has been reset for the experiment " + experiment.toString());
        }
        else {
            experimentChangeLogger.log(Level.INFO, "The publication " + oldPublication + " has been updated with " + experiment.getPublication() + " in the experiment " + experiment.toString());
        }
    }

    /** {@inheritDoc} */
    public void onInteractionDetectionMethodUpdate(Experiment experiment, CvTerm oldCv) {
        if (oldCv == null){
            experimentChangeLogger.log(Level.INFO, "The interaction detection method has been initialised for the experiment " + experiment.toString());
        }
        else if (experiment.getInteractionDetectionMethod() == null){
            experimentChangeLogger.log(Level.INFO, "The interaction detection method has been reset for the experiment " + experiment.toString());
        }
        else {
            experimentChangeLogger.log(Level.INFO, "The interaction detection method " + oldCv + " has been updated with " + experiment.getInteractionDetectionMethod() + " in the experiment " + experiment.toString());
        }
    }

    /** {@inheritDoc} */
    public void onHostOrganismUpdate(Experiment experiment, Organism oldOrganism) {
        if (oldOrganism == null){
            experimentChangeLogger.log(Level.INFO, "The host organism has been initialised for the experiment " + experiment.toString());
        }
        else if (experiment.getHostOrganism() == null){
            experimentChangeLogger.log(Level.INFO, "The host organism has been reset for the experiment " + experiment.toString());
        }
        else {
            experimentChangeLogger.log(Level.INFO, "The host organism " + oldOrganism + " has been updated with " + experiment.getHostOrganism() + " in the experiment " + experiment.toString());
        }
    }

    /** {@inheritDoc} */
    public void onAddedVariableParameter(Experiment experiment, VariableParameter addedParameter) {
        experimentChangeLogger.log(Level.INFO, "The variable parameter " + addedParameter + " has been added to the experiment " + experiment.toString());

    }

    /** {@inheritDoc} */
    public void onRemovedVariableParameter(Experiment experiment, VariableParameter removedParameter) {
        experimentChangeLogger.log(Level.INFO, "The variable parameter " + removedParameter + " has been removed from the experiment " + experiment.toString());

    }

    /** {@inheritDoc} */
    public void onAddedXref(Experiment experiment, Xref added) {
        experimentChangeLogger.log(Level.INFO, "The xref " + added.toString() + " has been added to the experiment " + experiment.toString());
    }

    /** {@inheritDoc} */
    public void onRemovedXref(Experiment experiment, Xref removed) {
        experimentChangeLogger.log(Level.INFO, "The xref " + removed.toString() + " has been removed from the experiment " + experiment.toString());
    }

    /** {@inheritDoc} */
    public void onAddedAnnotation(Experiment experiment, Annotation added) {
        experimentChangeLogger.log(Level.INFO, "The annotation " + added.toString() + " has been added to the experiment " + experiment.toString());
    }

    /** {@inheritDoc} */
    public void onRemovedAnnotation(Experiment experiment, Annotation removed) {
        experimentChangeLogger.log(Level.INFO, "The annotation " + removed.toString() + " has been removed from the experiment " + experiment.toString());
    }

    /** {@inheritDoc} */
    public void onAddedConfidence(Experiment experiment, Confidence added) {
        experimentChangeLogger.log(Level.INFO, "The confidence " + added.toString() + " has been added to the experiment " + experiment.toString());
    }

    /** {@inheritDoc} */
    public void onRemovedConfidence(Experiment experiment, Confidence removed) {
        experimentChangeLogger.log(Level.INFO, "The confidence " + removed.toString() + " has been removed from the experiment " + experiment.toString());

    }
}
