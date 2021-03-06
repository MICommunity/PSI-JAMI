package psidev.psi.mi.jami.utils.comparator.participant;

import psidev.psi.mi.jami.model.*;

import java.util.Comparator;

/**
 * Generic participant comparator.
 * Modelled participants come first and then experimental participants.
 * - It uses ParticipantEvidenceComparator to compare experimental participants
 * - It uses ModelledParticipantComparator to compare biological participants
 * - It uses ParticipantBaseComparator to compare basic participant properties
 * - It uses ParticipantPoolComparator to compare basic participant pool properties
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>04/02/13</pre>
 */
public class ParticipantComparator implements Comparator<Participant> {

    private ParticipantBaseComparator participantBaseComparator;
    private ParticipantEvidenceComparator experimentalParticipantComparator;
    private ModelledParticipantComparator biologicalParticipantComparator;
    private ParticipantPoolComparator poolComparator;

    /**
     * <p>Constructor for ParticipantComparator.</p>
     *
     * @param participantBaseComparator a {@link psidev.psi.mi.jami.utils.comparator.participant.ParticipantBaseComparator} object.
     * @param experimentalParticipantComparator a {@link psidev.psi.mi.jami.utils.comparator.participant.ParticipantEvidenceComparator} object.
     * @param modelledParticipantComparator a {@link psidev.psi.mi.jami.utils.comparator.participant.ModelledParticipantComparator} object.
     * @param poolComparator a {@link psidev.psi.mi.jami.utils.comparator.participant.ParticipantPoolComparator} object.
     */
    public ParticipantComparator(ParticipantBaseComparator participantBaseComparator,
                                 ParticipantEvidenceComparator experimentalParticipantComparator,
                                 ModelledParticipantComparator modelledParticipantComparator,
                                 ParticipantPoolComparator poolComparator){
        if (participantBaseComparator == null){
            throw new IllegalArgumentException("The entityBaseComparator is required to create more specific participant comparators and compares basic participant properties. It cannot be null");
        }
        this.participantBaseComparator = participantBaseComparator;
        if (experimentalParticipantComparator == null){
            throw new IllegalArgumentException("The experimentalEntityComparator is required to compare experimental participant properties. It cannot be null");
        }
        this.experimentalParticipantComparator = experimentalParticipantComparator;
        if (modelledParticipantComparator == null){
            throw new IllegalArgumentException("The modelledParticipantComparator is required to compare modelled participant properties. It cannot be null");
        }
        this.biologicalParticipantComparator = modelledParticipantComparator;
        if (poolComparator == null){
            throw new IllegalArgumentException("The ParticipantPoolComparator is required to compare participant pool properties. It cannot be null");
        }
        this.poolComparator = poolComparator;
    }

    /**
     * Modelled participants come first and then experimental participants.
     * - It uses ParticipantEvidenceComparator to compare experimental participants
     * - It uses ModelledParticipantComparator to compare biological participants
     * - It uses ParticipantBaseComparator to compare basic participant properties
     *
     * @param participant1 a {@link psidev.psi.mi.jami.model.Participant} object.
     * @param participant2 a {@link psidev.psi.mi.jami.model.Participant} object.
     * @return a int.
     */
    public int compare(Participant participant1, Participant participant2) {
        int EQUAL = 0;
        int BEFORE = -1;
        int AFTER = 1;

        if (participant1 == participant2){
            return EQUAL;
        }
        else if (participant1 == null){
            return AFTER;
        }
        else if (participant2 == null){
            return BEFORE;
        }
        else {
            // first check if both participants are from the same interface
            // both are biological participants
            boolean isBiologicalParticipant1 = participant1 instanceof ModelledParticipant;
            boolean isBiologicalParticipant2 = participant2 instanceof ModelledParticipant;
            if (isBiologicalParticipant1 && isBiologicalParticipant2){
                return biologicalParticipantComparator.compare((ModelledParticipant) participant1, (ModelledParticipant) participant2);
            }
            // the biological participant is before
            else if (isBiologicalParticipant1){
                return BEFORE;
            }
            else if (isBiologicalParticipant2){
                return AFTER;
            }
            else {
                // both are experimental participants
                boolean isExperimentalParticipant1 = participant1 instanceof ParticipantEvidence;
                boolean isExperimentalParticipant2 = participant2 instanceof ParticipantEvidence;
                if (isExperimentalParticipant1 && isExperimentalParticipant2){
                    return experimentalParticipantComparator.compare((ParticipantEvidence) participant1, (ParticipantEvidence) participant2);
                }
                // the experimental participant is before
                else if (isExperimentalParticipant1){
                    return BEFORE;
                }
                else if (isExperimentalParticipant2){
                    return AFTER;
                }
                else {
                    // both are experimental participants
                    boolean isPool1 = participant1 instanceof ParticipantPool;
                    boolean isPool2 = participant2 instanceof ParticipantPool;
                    if (isPool1 && isPool2){
                        return poolComparator.compare((ParticipantPool) participant1,
                                (ParticipantPool) participant2);
                    }
                    // the experimental participant is before
                    else if (isPool1){
                        return BEFORE;
                    }
                    else if (isPool2){
                        return AFTER;
                    }
                    else {
                        return participantBaseComparator.compare(participant1, participant2);
                    }
                }
            }
        }
    }

    /**
     * <p>Getter for the field <code>participantBaseComparator</code>.</p>
     *
     * @return a {@link psidev.psi.mi.jami.utils.comparator.participant.ParticipantBaseComparator} object.
     */
    public ParticipantBaseComparator getParticipantBaseComparator() {
        return participantBaseComparator;
    }

    /**
     * <p>Getter for the field <code>experimentalParticipantComparator</code>.</p>
     *
     * @return a {@link psidev.psi.mi.jami.utils.comparator.participant.ParticipantEvidenceComparator} object.
     */
    public ParticipantEvidenceComparator getExperimentalParticipantComparator() {
        return experimentalParticipantComparator;
    }

    /**
     * <p>Getter for the field <code>biologicalParticipantComparator</code>.</p>
     *
     * @return a {@link psidev.psi.mi.jami.utils.comparator.participant.ModelledParticipantComparator} object.
     */
    public ModelledParticipantComparator getBiologicalParticipantComparator() {
        return biologicalParticipantComparator;
    }

    /**
     * <p>Getter for the field <code>poolComparator</code>.</p>
     *
     * @return a {@link psidev.psi.mi.jami.utils.comparator.participant.ParticipantPoolComparator} object.
     */
    public ParticipantPoolComparator getPoolComparator() {
        return poolComparator;
    }
}
