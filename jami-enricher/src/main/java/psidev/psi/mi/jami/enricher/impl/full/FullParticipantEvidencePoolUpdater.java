package psidev.psi.mi.jami.enricher.impl.full;

import psidev.psi.mi.jami.enricher.impl.minimal.MinimalParticipantEvidencePoolEnricher;
import psidev.psi.mi.jami.model.ParticipantEvidencePool;

/**
 * A full enricher for experimental Participant pools
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>01/10/13</pre>
 */

public class FullParticipantEvidencePoolUpdater extends MinimalParticipantEvidencePoolEnricher {

    public FullParticipantEvidencePoolUpdater(){
        super(new FullParticipantEvidenceUpdater<ParticipantEvidencePool>());
    }

    protected boolean removeEntitiesFromPool(){
        return true;
    }
}
