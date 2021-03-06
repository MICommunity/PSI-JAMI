package psidev.psi.mi.jami.xml.model.extension;

import psidev.psi.mi.jami.model.Feature;
import psidev.psi.mi.jami.model.Interaction;
import psidev.psi.mi.jami.model.NamedParticipant;

/**
 * Extended participant for PSI-XML 2,5 standards
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>30/10/13</pre>
 */
public interface ExtendedPsiXmlParticipant<I extends Interaction, F extends Feature> extends ExtendedPsiXmlEntity<F>, NamedParticipant<I,F> {
}
