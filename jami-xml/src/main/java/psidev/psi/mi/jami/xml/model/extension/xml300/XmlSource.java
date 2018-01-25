//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.04.03 at 12:49:45 PM BST 
//


package psidev.psi.mi.jami.xml.model.extension.xml300;

import psidev.psi.mi.jami.model.Publication;
import psidev.psi.mi.jami.model.Xref;
import psidev.psi.mi.jami.xml.model.extension.AbstractXmlSource;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * Desciption of the source of the entry, usually an organisation
 *
 *
 * <p>Java class for source complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * The JAXB binding is designed to be read-only and is not designed for writing
 *

 */
@XmlRootElement(name = "source", namespace = "http://psi.hupo.org/mi/mif300")
@XmlAccessorType(XmlAccessType.NONE)
public class XmlSource extends AbstractXmlSource
{
    /**
     * <p>Constructor for XmlSource.</p>
     */
    public XmlSource(){
        super();
    }

    /**
     * <p>Constructor for XmlSource.</p>
     *
     * @param shortName a {@link java.lang.String} object.
     */
    public XmlSource(String shortName) {
        super(shortName);
    }

    /**
     * <p>Constructor for XmlSource.</p>
     *
     * @param shortName a {@link java.lang.String} object.
     * @param ontologyId a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    public XmlSource(String shortName, Xref ontologyId) {
        super(shortName, ontologyId);
    }

    /**
     * <p>Constructor for XmlSource.</p>
     *
     * @param shortName a {@link java.lang.String} object.
     * @param fullName a {@link java.lang.String} object.
     * @param ontologyId a {@link psidev.psi.mi.jami.model.Xref} object.
     */
    public XmlSource(String shortName, String fullName, Xref ontologyId) {
        super(shortName, fullName, ontologyId);
    }

    /**
     * <p>Constructor for XmlSource.</p>
     *
     * @param shortName a {@link java.lang.String} object.
     * @param url a {@link java.lang.String} object.
     * @param address a {@link java.lang.String} object.
     * @param bibRef a {@link psidev.psi.mi.jami.model.Publication} object.
     */
    public XmlSource(String shortName, String url, String address, Publication bibRef) {
        super(shortName,url, address, bibRef);
    }

    /**
     * <p>Constructor for XmlSource.</p>
     *
     * @param shortName a {@link java.lang.String} object.
     * @param ontologyId a {@link psidev.psi.mi.jami.model.Xref} object.
     * @param url a {@link java.lang.String} object.
     * @param address a {@link java.lang.String} object.
     * @param bibRef a {@link psidev.psi.mi.jami.model.Publication} object.
     */
    public XmlSource(String shortName, Xref ontologyId, String url, String address, Publication bibRef) {
        super(shortName, ontologyId, url, address, bibRef);
    }

    /**
     * <p>Constructor for XmlSource.</p>
     *
     * @param shortName a {@link java.lang.String} object.
     * @param fullName a {@link java.lang.String} object.
     * @param ontologyId a {@link psidev.psi.mi.jami.model.Xref} object.
     * @param url a {@link java.lang.String} object.
     * @param address a {@link java.lang.String} object.
     * @param bibRef a {@link psidev.psi.mi.jami.model.Publication} object.
     */
    public XmlSource(String shortName, String fullName, Xref ontologyId, String url, String address, Publication bibRef) {
        super(shortName, fullName, ontologyId, url, address, bibRef);
    }

    /**
     * <p>Constructor for XmlSource.</p>
     *
     * @param shortName a {@link java.lang.String} object.
     * @param miId a {@link java.lang.String} object.
     */
    public XmlSource(String shortName, String miId) {
        super(shortName, miId);
    }

    /**
     * <p>Constructor for XmlSource.</p>
     *
     * @param shortName a {@link java.lang.String} object.
     * @param fullName a {@link java.lang.String} object.
     * @param miId a {@link java.lang.String} object.
     */
    public XmlSource(String shortName, String fullName, String miId) {
        super(shortName, fullName, miId);
    }

    /**
     * <p>Constructor for XmlSource.</p>
     *
     * @param shortName a {@link java.lang.String} object.
     * @param miId a {@link java.lang.String} object.
     * @param url a {@link java.lang.String} object.
     * @param address a {@link java.lang.String} object.
     * @param bibRef a {@link psidev.psi.mi.jami.model.Publication} object.
     */
    public XmlSource(String shortName, String miId, String url, String address, Publication bibRef) {
        super(shortName, miId, url, address, bibRef);
    }

    /**
     * <p>Constructor for XmlSource.</p>
     *
     * @param shortName a {@link java.lang.String} object.
     * @param fullName a {@link java.lang.String} object.
     * @param miId a {@link java.lang.String} object.
     * @param url a {@link java.lang.String} object.
     * @param address a {@link java.lang.String} object.
     * @param bibRef a {@link psidev.psi.mi.jami.model.Publication} object.
     */
    public XmlSource(String shortName, String fullName, String miId, String url, String address, Publication bibRef) {
        super(shortName, fullName, miId, url, address, bibRef);
    }
}
