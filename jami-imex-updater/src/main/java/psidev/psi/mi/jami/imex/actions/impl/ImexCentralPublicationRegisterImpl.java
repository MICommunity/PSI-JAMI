package psidev.psi.mi.jami.imex.actions.impl;

import edu.ucla.mbi.imex.central.ws.v20.IcentralFault;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import psidev.psi.mi.jami.bridges.exception.BridgeFailedException;
import psidev.psi.mi.jami.bridges.imex.ImexCentralClient;
import psidev.psi.mi.jami.model.Publication;
import psidev.psi.mi.jami.model.Xref;
import psidev.psi.mi.jami.imex.actions.ImexCentralPublicationRegister;

/**
 * This class can register a publication in IMEx central and collect a publication record in IMEx central using imex central webservice
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>28/03/12</pre>
 */
public class ImexCentralPublicationRegisterImpl implements ImexCentralPublicationRegister{

    private static final Log log = LogFactory.getLog(ImexCentralPublicationRegisterImpl.class);
    private ImexCentralClient imexCentral;

    /**
     * <p>Constructor for ImexCentralPublicationRegisterImpl.</p>
     *
     * @param client a {@link psidev.psi.mi.jami.bridges.imex.ImexCentralClient} object.
     */
    public ImexCentralPublicationRegisterImpl(ImexCentralClient client){
        if (client == null){
            throw new IllegalArgumentException("The IMEx central client cannot be null");
        }
        this.imexCentral = client;
    }

    /** {@inheritDoc} */
    public Publication getExistingPublicationInImexCentral(String publicationId, String source) throws BridgeFailedException {

        if (publicationId != null && source != null){
            return imexCentral.fetchByIdentifier(publicationId, source);
        }
        return null;
    }

    /** {@inheritDoc} */
    public Publication registerPublicationInImexCentral(Publication publication) throws BridgeFailedException{
        // create a new publication record in IMEx central
        psidev.psi.mi.jami.model.Publication newPublication = null;
        String pubId = publication.getPubmedId() != null ? publication.getPubmedId() : publication.getDoi();
        String source = publication.getPubmedId() != null ? Xref.PUBMED : Xref.DOI;
        if (pubId == null && !publication.getIdentifiers().isEmpty()){
            Xref id = publication.getXrefs().iterator().next();
            source = id.getDatabase().getShortName();
            pubId = id.getId();
        }

        try {
            newPublication = imexCentral.createPublicationById(pubId, source);
            log.info("Registered publication : " + pubId + " in IMEx central.");

            return newPublication;
        } catch (BridgeFailedException e) {
            IcentralFault f = (IcentralFault) e.getCause();
            // IMEx central throw an Exception when the record cannot be created
            if( f.getFaultInfo().getFaultCode() == ImexCentralClient.NO_RECORD_CREATED ) {
                log.error("Cannot create a new record in IMEx central for publication " + pubId, e);
                return null;
            }
            else {
                throw e;
            }
        }
    }

    /**
     * <p>getImexCentralClient.</p>
     *
     * @return a {@link psidev.psi.mi.jami.bridges.imex.ImexCentralClient} object.
     */
    public ImexCentralClient getImexCentralClient() {
        return imexCentral;
    }
}
