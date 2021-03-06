package psidev.psi.mi.jami.binary.expansion;

import psidev.psi.mi.jami.binary.BinaryInteraction;
import psidev.psi.mi.jami.model.Interaction;
import psidev.psi.mi.jami.model.Participant;
import psidev.psi.mi.jami.utils.CvTermUtils;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Abstract class for SpokeExpansion
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>19/06/13</pre>
 */
public abstract class AbstractSpokeExpansion<T extends Interaction, B extends BinaryInteraction>
        extends AbstractComplexExpansionMethod<T,B> {

    /**
     * <p>Constructor for AbstractSpokeExpansion.</p>
     */
    public AbstractSpokeExpansion() {
        super(CvTermUtils.createMICvTerm(ComplexExpansionMethod.SPOKE_EXPANSION, ComplexExpansionMethod.SPOKE_EXPANSION_MI));
    }

    /** {@inheritDoc} */
    @Override
    protected Collection<B> collectBinaryInteractionsFromNary(T interaction) {
        Collection<B> binaryInteractions = new ArrayList<B>(interaction.getParticipants().size()-1);

        Participant bait = collectBestBaitForSpokeExpansion(interaction);

        for ( Object p : interaction.getParticipants() ) {
            if (p != bait){
                // build a new interaction
                B binary = createBinaryInteraction(interaction, bait, (Participant)p);

                binaryInteractions.add(binary);
            }
        }

        return binaryInteractions;
    }

    /**
     * <p>createBinaryInteraction</p>
     *
     * @param interaction : the interaction to expand
     * @param c1 : the bait
     * @param c2 : the prey
     * @return the binary interaction
     * @param <P> a P object.
     */
    protected abstract <P extends Participant> B createBinaryInteraction(T interaction, P c1, P c2);

    /**
     * <p>collectBestBaitForSpokeExpansion</p>
     *
     * @param interaction : the interaction to expand
     * @return the best bait to use for complex expansion among all participants of this interaction
     * @param <P> a P object.
     */
    protected abstract <P extends Participant> P collectBestBaitForSpokeExpansion(T interaction);
}
