package psidev.psi.mi.jami.xml.io.parser;

import psidev.psi.mi.jami.binary.BinaryInteraction;
import psidev.psi.mi.jami.binary.expansion.ComplexExpansionMethod;
import psidev.psi.mi.jami.exception.MIIOException;
import psidev.psi.mi.jami.model.Interaction;
import psidev.psi.mi.jami.model.Participant;
import psidev.psi.mi.jami.xml.io.iterator.Xml25InteractionIterator;

import javax.xml.bind.JAXBException;
import javax.xml.stream.XMLStreamException;
import java.io.*;
import java.net.URL;
import java.util.Iterator;

/**
 * Datasource for PSI-xml 2.5 returning basic interactions
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>17/10/13</pre>
 */

public class LightXml25StreamSource extends AbstractPsiXml25Stream<Interaction<?extends Participant>> {

    public LightXml25StreamSource() {
    }

    public LightXml25StreamSource(File file) {
        super(file);
    }

    public LightXml25StreamSource(InputStream input) {
        super(input);
    }

    public LightXml25StreamSource(Reader reader) {
        super(reader);
    }

    public LightXml25StreamSource(URL url) {
        super(url);
    }

    @Override
    protected void initialiseXmlParser(Reader reader) {
        try {
            Xml25Parser parser = new Xml25Parser(reader);
            parser.setListener(this);
            parser.setCacheOfComplexes(getComplexCache());
            parser.setCacheOfObjects(getElementCache());
            setParser(parser);

        } catch (XMLStreamException e) {
            throw new MIIOException("Impossible to read with provided reader ",e);
        } catch (JAXBException e) {
            throw new MIIOException("Impossible to read with provided reader",e);
        }      }

    @Override
    protected void initialiseXmlParser(File file) {
        try {
            Xml25Parser parser = new Xml25Parser(file);
            parser.setListener(this);
            parser.setCacheOfComplexes(getComplexCache());
            parser.setCacheOfObjects(getElementCache());
            setParser(parser);
        } catch (XMLStreamException e) {
            throw new MIIOException("Impossible to parse the file "+file.getName(),e);
        } catch (JAXBException e) {
            throw new MIIOException("Impossible to parse the file "+file.getName(),e);
        }
    }

    @Override
    protected void initialiseXmlParser(InputStream input) {
        try {
            Xml25Parser parser = new Xml25Parser(input);
            parser.setListener(this);
            parser.setCacheOfComplexes(getComplexCache());
            parser.setCacheOfObjects(getElementCache());
            setParser(parser);
        } catch (XMLStreamException e) {
            throw new MIIOException("Impossible to parse the inputstream ",e);
        } catch (JAXBException e) {
            throw new MIIOException("Impossible to parse the inputstream ",e);
        }
    }

    @Override
    protected void initialiseXmlParser(URL url) {
        try {
            Xml25Parser parser = new Xml25Parser(url);
            parser.setListener(this);
            parser.setCacheOfComplexes(getComplexCache());
            parser.setCacheOfObjects(getElementCache());
            setParser(parser);
        } catch (IOException e) {
            throw new MIIOException("Impossible to read the url "+url.toExternalForm(),e);
        } catch (XMLStreamException e) {
            throw new MIIOException("Impossible to parse the url "+url.toExternalForm(),e);
        } catch (JAXBException e) {
            throw new MIIOException("Impossible to parse the url "+url.toExternalForm(),e);
        }
    }

    @Override
    protected void initialiseExpansionMethod(ComplexExpansionMethod<? extends Interaction, ? extends BinaryInteraction> expansionMethod) {
        // nothing to do as we don't expand
    }

    @Override
    protected Iterator<Interaction<? extends Participant>> createXmlIterator() {
        return new Xml25InteractionIterator(getParser());
    }
}
