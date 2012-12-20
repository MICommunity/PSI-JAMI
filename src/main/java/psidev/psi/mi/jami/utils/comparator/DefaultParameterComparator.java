package psidev.psi.mi.jami.utils.comparator;

import psidev.psi.mi.jami.model.Parameter;

/**
 * Default parameter comparator.
 *
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

public class DefaultParameterComparator extends ParameterComparator {

    public DefaultParameterComparator() {
        super(new DefaultCvTermComparator());
    }

    public DefaultParameterComparator(ParameterValueComparator valueComparator) {
        super(new DefaultCvTermComparator(), valueComparator);
    }

    @Override
    public DefaultCvTermComparator getCvTermComparator() {
        return (DefaultCvTermComparator) cvTermComparator;
    }

    /**
     * It first compares parameter types, then parameter units and then it uses ParameterValueComparator for comparing parameter values
     * It will also compare the uncertainty.
     * - Two parameters which are null are equals
     * - The parameter which is not null is before null.
     * - Use DefaultCvTermComparator to compare first the parameter types.
     * - If parameter types are equals, use DefaultCvTermComparator to compare the units.
     * - If the units are not set, compares the values
     * - If both units are set and If they are equals, compares the values (case sensitive)
     * - If both values are equals, compares the uncertainty.
     * @param parameter1
     * @param parameter2
     * @return
     */
    public int compare(Parameter parameter1, Parameter parameter2) {
        return super.compare(parameter1, parameter2);
    }
}
