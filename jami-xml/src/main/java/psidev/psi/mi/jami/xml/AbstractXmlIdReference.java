package psidev.psi.mi.jami.xml;

/**
 * Abstract implementation for XmlIdReference
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>11/10/13</pre>
 */

public abstract class AbstractXmlIdReference implements XmlIdReference {
    protected int ref;

    public AbstractXmlIdReference(int ref) {
        this.ref = ref;
    }

    public void registerForResolution() {
        XmlEntryContext.getInstance().getReferences().add(this);
    }
}
