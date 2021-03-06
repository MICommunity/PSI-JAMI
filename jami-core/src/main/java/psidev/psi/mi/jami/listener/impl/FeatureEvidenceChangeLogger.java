package psidev.psi.mi.jami.listener.impl;

import psidev.psi.mi.jami.listener.FeatureEvidenceChangeListener;
import psidev.psi.mi.jami.model.*;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This listener will just interactor change events
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>11/06/13</pre>
 */
public class FeatureEvidenceChangeLogger extends FeatureChangeLogger<FeatureEvidence> implements FeatureEvidenceChangeListener {

    private static final Logger featureEvidenceChangeLogger = Logger.getLogger("FeatureEvidenceChangeLogger");

    /** {@inheritDoc} */
    public void onAddedDetectionMethod(FeatureEvidence feature, CvTerm added) {
        featureEvidenceChangeLogger.log(Level.INFO, "The detection method " + added.toString() + " has been added to the feature " + feature.toString());
    }

    /** {@inheritDoc} */
    public void onRemovedDetectionMethod(FeatureEvidence feature, CvTerm removed) {
        featureEvidenceChangeLogger.log(Level.INFO, "The detection method " + removed.toString() + " has been removed from the feature " + feature.toString());
    }

    /** {@inheritDoc} */
    public void onAddedParameter(FeatureEvidence feature, Parameter added) {
        featureEvidenceChangeLogger.log(Level.INFO, "The parameter " + added.toString() + " has been added to the feature " + feature.toString());
    }

    /** {@inheritDoc} */
    public void onRemovedParameter(FeatureEvidence feature, Parameter removed) {
        featureEvidenceChangeLogger.log(Level.INFO, "The parameter " + removed.toString() + " has been removed from the feature " + feature.toString());
    }
}
