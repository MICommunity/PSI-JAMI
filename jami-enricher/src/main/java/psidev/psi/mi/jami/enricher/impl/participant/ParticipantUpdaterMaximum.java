package psidev.psi.mi.jami.enricher.impl.participant;

import psidev.psi.mi.jami.model.Feature;
import psidev.psi.mi.jami.model.Participant;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Gabriel Aldam (galdam@ebi.ac.uk)
 * @since 13/06/13
 */
public class ParticipantUpdaterMaximum<P extends Participant, F extends Feature>
        extends ParticipantUpdaterMinimum<P , F> {


    /*
    @Override
    public ProteinEnricher getProteinEnricher(){
        if(proteinEnricher == null) proteinEnricher = new ProteinUpdaterMaximum();
        return proteinEnricher;
    }

    @Override
    public CvTermEnricher getCvTermEnricher(){
        if(cvTermEnricher == null) cvTermEnricher = new MaximumCvTermUpdater();
        return cvTermEnricher;
    }

    @Override
    public FeatureEnricher<F> getFeatureEnricher(){
        if(featureEnricher == null){
            featureEnricher = new FeatureUpdaterMaximum<F>();
            EnricherUtil.linkFeatureEnricherToProteinEnricher(featureEnricher, getProteinEnricher());
        }
        return featureEnricher;
    } */
}
