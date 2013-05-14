package psidev.psi.mi.enricher.cvtermenricher;

import psidev.psi.mi.enricher.cvtermenricher.enricherlistener.event.EnricherEvent;
import psidev.psi.mi.enricher.cvtermenricher.exception.EnrichmentException;
import psidev.psi.mi.enricher.cvtermenricher.enricherlistener.event.AdditionEvent;
import psidev.psi.mi.jami.model.Alias;
import psidev.psi.mi.jami.model.CvTerm;
import psidev.psi.mi.jami.model.Xref;
import psidev.psi.mi.jami.utils.comparator.alias.DefaultAliasComparator;
import psidev.psi.mi.jami.utils.comparator.xref.DefaultXrefComparator;
import psidev.psi.mi.util.CollectionUtilsExtra;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: Gabriel Aldam (galdam@ebi.ac.uk)
 * Date: 08/05/13
 * Time: 14:19
 */
public class MinimumCvTermEnricher
        extends AbstractCvTermEnricher{

    public MinimumCvTermEnricher() throws EnrichmentException {
    }

    public void enrichCvTerm(CvTerm cvTermMaster) throws EnrichmentException{
        EnricherEvent report = new EnricherEvent();
        CvTerm cvTermEnriched = getEnrichedForm(cvTermMaster, report);

        //Todo report obsolete
        //Add full name
        if(cvTermMaster.getFullName() == null
                && cvTermEnriched.getFullName() != null){
            cvTermMaster.setFullName(cvTermEnriched.getFullName());
            AdditionEvent e = new AdditionEvent(report);
            e.setAdditionValues("FullName", cvTermMaster.getFullName());
            fireAdditionEvent(e);
        }




        //Add identifiers
        Collection<Xref> subtractedIdentifiers = CollectionUtilsExtra.comparatorSubtract(
                cvTermEnriched.getIdentifiers(),
                cvTermMaster.getIdentifiers(),
                new DefaultXrefComparator());

        for(Xref x: subtractedIdentifiers){
            cvTermMaster.getIdentifiers().add(x);
            AdditionEvent e = new AdditionEvent(report);
            e.setAdditionValues("Identifier", x.getId());
            fireAdditionEvent(e);
        }

        //Add synonyms
        Collection<Alias> subtractedSynonyms = CollectionUtilsExtra.comparatorSubtract(
                cvTermEnriched.getSynonyms(),
                cvTermMaster.getSynonyms(),
                new DefaultAliasComparator());

        for(Alias x: subtractedSynonyms){
            cvTermMaster.getSynonyms().add(x);

            AdditionEvent e = new AdditionEvent(report);
            e.setAdditionValues( "Synonym", "Name: "+x.getName()+", Type: "+x.getType());
            fireAdditionEvent(e);
        }
    }

    public void enrichCvTerms(Collection<CvTerm> cvTermMasters) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

}
