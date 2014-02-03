package psidev.psi.mi.jami.enricher.impl;

import psidev.psi.mi.jami.enricher.exception.EnricherException;
import psidev.psi.mi.jami.enricher.util.EnricherUtils;
import psidev.psi.mi.jami.model.CvTerm;
import psidev.psi.mi.jami.model.Feature;
import psidev.psi.mi.jami.model.Range;
import psidev.psi.mi.jami.utils.PositionUtils;

import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Gabriel Aldam (galdam@ebi.ac.uk)
 * @since 13/08/13
 */
public class MinimalFeatureUpdater<F extends  Feature> extends MinimalFeatureEnricher<F> {

    @Override
    protected boolean updateRangePositions() {
        return true;
    }

    @Override
    protected void onInvalidRange(F feature, Range range, Collection<String> errorMessages) {
        if (getFeatureEnricherListener() != null){
            getFeatureEnricherListener().onRemovedRange(feature, range);
        }
        range.setPositions(PositionUtils.createUndeterminedPosition(), PositionUtils.createUndeterminedPosition());
        if (getFeatureEnricherListener() != null){
            getFeatureEnricherListener().onAddedRange(feature, range);
        }
    }

    @Override
    protected void onOutOfDateRange(F feature, Range range, Collection<String> errorMessages, String oldSequence) {
        if (getFeatureEnricherListener() != null){
            getFeatureEnricherListener().onRemovedRange(feature, range);
        }
        range.setPositions(PositionUtils.createUndeterminedPosition(), PositionUtils.createUndeterminedPosition());
        if (getFeatureEnricherListener() != null){
            getFeatureEnricherListener().onAddedRange(feature, range);
        }
    }

    @Override
    protected void processFeatureType(F featureToEnrich, F objectSource) throws EnricherException {
        if (featureToEnrich.getType() != objectSource.getType()){
            CvTerm oldType = featureToEnrich.getType();
            featureToEnrich.setType(objectSource.getType());
            if (getFeatureEnricherListener() != null){
                getFeatureEnricherListener().onTypeUpdate(featureToEnrich, oldType);
            }
        }
        processFeatureType(featureToEnrich);
    }

    @Override
    protected void processShortLabel(F objectToEnrich, F objectSource) {
        if(objectSource.getShortName() != null
                && ! objectSource.getShortName().equalsIgnoreCase(objectToEnrich.getShortName())){

            String oldValue = objectToEnrich.getShortName();
            objectToEnrich.setShortName(objectSource.getShortName());
            if (getFeatureEnricherListener() != null)
                getFeatureEnricherListener().onShortNameUpdate(objectToEnrich, oldValue);
        }
    }

    @Override
    protected void processFullName(F objectToEnrich, F objectSource) {
        // == Full Name ======================================================================
        if((objectSource.getFullName() != null && !objectSource.getFullName().equals(objectToEnrich.getFullName()))
                || (objectSource.getFullName() == null
                && objectToEnrich.getFullName() != null)){

            String oldValue = objectToEnrich.getFullName();
            objectToEnrich.setFullName(objectSource.getFullName());
            if (getFeatureEnricherListener() != null)
                getFeatureEnricherListener().onFullNameUpdate(objectToEnrich, oldValue);
        }
    }

    @Override
    protected void processIdentifiers(F objectToEnrich, F objectSource) {
        EnricherUtils.mergeXrefs(objectToEnrich, objectToEnrich.getIdentifiers(), objectSource.getIdentifiers(), true, true,
                getFeatureEnricherListener(), getFeatureEnricherListener());
    }
}
