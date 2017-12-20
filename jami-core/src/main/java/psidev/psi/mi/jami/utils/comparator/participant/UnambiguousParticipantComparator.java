package psidev.psi.mi.jami.utils.comparator.participant;

import psidev.psi.mi.jami.model.Participant;

/**
 * Unambiguous generic Participant comparator
 * Modelled participants come first and then experimental participants.
 * - It uses UnambiguousEntityComparator to compare components
 * - It uses UnambiguousModelledParticipantComparator to compare components
 * - It uses UnambiguousParticipantEvidenceComparator to compare experimental participants
 * - It uses UnambiguousParticipantBaseComparator to compare basic participant properties
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>04/02/13</pre>
 */
public class UnambiguousParticipantComparator extends ParticipantComparator {

    private static UnambiguousParticipantComparator unambiguousParticipantComparator;

    /**
     * {@inheritDoc}
     *
     * Creates a UnambiguousParticipantComparator. It will use a UnambiguousParticipantBaseComparator to compare basic feature properties
     */
    public UnambiguousParticipantComparator() {
        super(new UnambiguousParticipantBaseComparator(), new UnambiguousParticipantEvidenceComparator(),
                new UnambiguousModelledParticipantComparator(), new UnambiguousParticipantPoolComparator());
    }

    /** {@inheritDoc} */
    @Override
    public UnambiguousParticipantBaseComparator getParticipantBaseComparator() {
        return (UnambiguousParticipantBaseComparator) super.getParticipantBaseComparator();
    }

    /** {@inheritDoc} */
    @Override
    public UnambiguousParticipantEvidenceComparator getExperimentalParticipantComparator() {
        return (UnambiguousParticipantEvidenceComparator)super.getExperimentalParticipantComparator();
    }

    /** {@inheritDoc} */
    @Override
    public UnambiguousModelledParticipantComparator getBiologicalParticipantComparator() {
        return (UnambiguousModelledParticipantComparator) super.getBiologicalParticipantComparator();
    }

    @Override
    public UnambiguousParticipantPoolComparator getPoolComparator() {
        return (UnambiguousParticipantPoolComparator) super.getPoolComparator();
    }

    /**
     * Modelled participants come first and then experimental participants.
     * - It uses UnambiguousEntityComparator to compare components
     * - It uses UnambiguousModelledParticipantComparator to compare components
     * - It uses UnambiguousParticipantEvidenceComparator to compare experimental participants
     * - It uses UnambiguousParticipantBaseComparator to compare basic participant properties
     *
     */
    @Override
    public int compare(Participant participant1, Participant participant2) {
        return super.compare(participant1, participant2);
    }

    /**
     * Use UnambiguousParticipantComparator to know if two participants are equals.
     *
     * @param participant1 a {@link psidev.psi.mi.jami.model.Participant} object.
     * @param participant2 a {@link psidev.psi.mi.jami.model.Participant} object.
     * @return true if the two participants are equal
     */
    public static boolean areEquals(Participant participant1, Participant participant2){
        if (unambiguousParticipantComparator == null){
            unambiguousParticipantComparator = new UnambiguousParticipantComparator();
        }

        return unambiguousParticipantComparator.compare(participant1, participant2) == 0;
    }
}
