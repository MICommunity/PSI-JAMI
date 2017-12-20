package psidev.psi.mi.jami.xml.model.xml25;

import psidev.psi.mi.jami.xml.model.AbstractEntrySet;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Basic EntrySet implementation for JAXB read only .
 *
 * Ignore all experimental details
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>07/11/13</pre>
 */
@XmlRootElement(name = "entrySet", namespace = "http://psi.hupo.org/mi/mif")
@XmlAccessorType(XmlAccessType.NONE)
public class Xml254BasicEntrySet extends AbstractEntrySet<BasicEntry> {

    /**
     * <p>getEntries.</p>
     *
     * @return a {@link java.util.List} object.
     */
    @XmlElement(type=BasicEntry.class, name="entry", required = true)
    public List<BasicEntry> getEntries() {
        return super.getEntries();
    }

}
