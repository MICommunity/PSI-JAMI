package psidev.psi.mi.jami.bridges.ols;

import org.junit.Before;
import org.junit.Test;
import psidev.psi.mi.jami.bridges.exception.BridgeFailedException;
import psidev.psi.mi.jami.model.OntologyTerm;

import java.util.logging.Logger;

import static junit.framework.Assert.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @author Gabriel Aldam (galdam@ebi.ac.uk)
 * @since 03/07/13
 */
public class OntologyOlsFetcherTest {

    protected static final Logger log = Logger.getLogger(OntologyOlsFetcherTest.class.getName());

    private OlsOntologyTermFetcher ontologyOLSFetcher;

    public static final String TEST_TERM_A_IDENTIFIER = "MI:0113";
    public static final String TEST_TERM_A_DBNAME = "psi-mi";
    public static final String TEST_TERM_A_SHORTNAME = "western blot";
    public static final String TEST_TERM_B_IDENTIFIER = "MI:0661";
    public static final String TEST_TERM_B_DBNAME = "psi-mi";
    public static final String TEST_TERM_B_SHORTNAME = "experimental particp";
    public static final String TEST_TERM_B_FULLNAME = "experimental participant identification";


    @Before
    public void setup() throws BridgeFailedException {
        ontologyOLSFetcher = new OlsOntologyTermFetcher();
    }

    //===========================

    /**
     * Confirm that the Ontology term is correctly retrieved
     * @throws BridgeFailedException
     */
    @Test
    public void test_getCvTermByExactName_without_relations() throws BridgeFailedException {
        OntologyTerm result = ontologyOLSFetcher.fetchByName(TEST_TERM_A_SHORTNAME , TEST_TERM_A_DBNAME);

        assertNotNull(result);
        assertEquals(TEST_TERM_A_SHORTNAME , result.getShortName());
        assertTrue(result.getIdentifiers().size() == 1);
        assertTrue(result.getIdentifiers().iterator().hasNext());
        assertEquals(TEST_TERM_A_IDENTIFIER , result.getIdentifiers().iterator().next().getId());

        assertFalse(result.getChildren().isEmpty());
        assertFalse(result.getParents().isEmpty());
    }
}