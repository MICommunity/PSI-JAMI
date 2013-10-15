package psidev.psi.mi.jami.xml.extension;

import psidev.psi.mi.jami.model.*;
import psidev.psi.mi.jami.xml.AbstractExperimentRef;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * Xml implementation of ModelledParameter
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>08/10/13</pre>
 */
@XmlAccessorType(XmlAccessType.NONE)
@XmlType(name = "",propOrder = {
        "JAXBExperimentRef"
})
public class XmlModelledParameter extends XmlParameter implements ModelledParameter{
    private Experiment experiment;
    private Collection<Publication> publications;

    public XmlModelledParameter() {
        super();
    }

    public XmlModelledParameter(CvTerm type, ParameterValue value, BigDecimal uncertainty, CvTerm unit) {
        super(type, value, uncertainty, unit);
    }

    public Collection<Publication> getPublications() {
        if (publications == null){
            this.publications = new ArrayList<Publication>();
        }
        return this.publications;
    }

    /**
     * Gets the value of the experimentRefList property.
     *
     * @return
     *     possible object is
     *     {@link Integer }
     *
     */
    @XmlElement(name="experimentRef")
    public Integer getJAXBExperimentRef() {
        if (experiment instanceof XmlExperiment){
            return ((XmlExperiment) experiment).getId();
        }
        return null;
    }

    /**
     * Sets the value of the experimentRefList property.
     *
     * @param value
     *     allowed object is
     *     {@link Integer }
     *
     */
    public void setJAXBExperimentRef(Integer value) {
        if (value != null){
            this.experiment = new AbstractExperimentRef(value) {
                public boolean resolve(Map<Integer, Object> parsedObjects) {
                    if (parsedObjects.containsKey(this.ref)){
                        Object obj = parsedObjects.get(this.ref);
                        if (obj instanceof Experiment){
                            experiment = (Experiment)obj;
                            if (experiment.getPublication() != null){
                                publications.add(experiment.getPublication());
                                return true;
                            }
                        }
                    }
                    return false;
                }
            };
        }
    }

    public Experiment getExperiment() {
        return experiment;
    }
}