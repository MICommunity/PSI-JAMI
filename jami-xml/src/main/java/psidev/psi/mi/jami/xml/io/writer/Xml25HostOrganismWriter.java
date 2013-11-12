package psidev.psi.mi.jami.xml.io.writer;

import org.codehaus.stax2.XMLStreamWriter2;
import psidev.psi.mi.jami.model.Alias;
import psidev.psi.mi.jami.model.CvTerm;

import javax.xml.stream.XMLStreamException;

/**
 * PSI-XML 2.5 writer for host organism
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>12/11/13</pre>
 */

public class Xml25HostOrganismWriter extends AbstractXml25OrganismWriter{
    public Xml25HostOrganismWriter(XMLStreamWriter2 writer) {
        super(writer);
    }

    public Xml25HostOrganismWriter(XMLStreamWriter2 writer, PsiXml25ElementWriter<Alias> aliasWriter, PsiXml25ElementWriter<CvTerm> tissueWriter, PsiXml25ElementWriter<CvTerm> compartmentWriter, PsiXml25ElementWriter<CvTerm> cellTypeWriter) {
        super(writer, aliasWriter, tissueWriter, compartmentWriter, cellTypeWriter);
    }

    @Override
    protected void writeStartOrganism() throws XMLStreamException {
        getStreamWriter().writeStartElement("hostOrganism");
    }
}