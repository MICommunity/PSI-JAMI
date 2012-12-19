package psidev.psi.mi.jami.utils.comparator;

/**
 * Default parameter comparator.
 *
 * - Two parameters which are null are equals
 * - The parameter which is not null is before null.
 * - Use DefaultCvTermComparator to compare first the parameter types.
 * - If parameter types are equals, use DefaultCvTermComparator to compare the units.
 * - If the units are not set, compares the values
 * - If both units are set and If they are equals, compares the values (case sensitive)
 * - If both values are equals, compares the uncertainty.
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>19/12/12</pre>
 */

public class DefaultParameterComparator extends AbstractParameterComparator<DefaultCvTermComparator> {
    @Override
    protected void instantiateCvTermComparator() {
        this.cvTermComparator = new DefaultCvTermComparator();
    }
}
