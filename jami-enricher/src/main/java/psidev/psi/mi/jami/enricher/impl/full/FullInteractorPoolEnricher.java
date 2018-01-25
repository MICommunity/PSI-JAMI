package psidev.psi.mi.jami.enricher.impl.full;

import psidev.psi.mi.jami.bridges.fetcher.InteractorFetcher;
import psidev.psi.mi.jami.enricher.InteractorPoolEnricher;
import psidev.psi.mi.jami.enricher.exception.EnricherException;
import psidev.psi.mi.jami.enricher.impl.CompositeInteractorEnricher;
import psidev.psi.mi.jami.listener.InteractorPoolChangeListener;
import psidev.psi.mi.jami.model.Interactor;
import psidev.psi.mi.jami.model.InteractorPool;
import psidev.psi.mi.jami.utils.comparator.interactor.UnambiguousExactInteractorComparator;

import java.util.*;

/**
 * A full enricher for interactor pools.
 *
 * See description of minimal enrichment in AbstractInteractorEnricher.
 * - enrich all interactors in existing pool using a composite interactor enricher if it is not null.
 * It will only add missing interactors in the pool and not remove any interactors that are not in the fetched interactor pool
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>30/01/14</pre>
 */
public class FullInteractorPoolEnricher extends FullInteractorBaseEnricher<InteractorPool> implements InteractorPoolEnricher {
    private CompositeInteractorEnricher interactorEnricher;
    private Comparator<Interactor> interactorComparator;

    /**
     * <p>Constructor for FullInteractorPoolEnricher.</p>
     */
    public FullInteractorPoolEnricher() {
        super();
    }

    /**
     * <p>Constructor for FullInteractorPoolEnricher.</p>
     *
     * @param fetcher a {@link psidev.psi.mi.jami.bridges.fetcher.InteractorFetcher} object.
     */
    public FullInteractorPoolEnricher(InteractorFetcher<InteractorPool> fetcher) {
        super(fetcher);
    }

    /**
     * <p>Getter for the field <code>interactorEnricher</code>.</p>
     *
     * @return a {@link psidev.psi.mi.jami.enricher.impl.CompositeInteractorEnricher} object.
     */
    public CompositeInteractorEnricher getInteractorEnricher() {
        return interactorEnricher;
    }

    /** {@inheritDoc} */
    public void setInteractorEnricher(CompositeInteractorEnricher interactorEnricher) {
        this.interactorEnricher = interactorEnricher;
    }

    /**
     * <p>Getter for the field <code>interactorComparator</code>.</p>
     *
     * @return a {@link java.util.Comparator} object.
     */
    public Comparator<Interactor> getInteractorComparator() {
        if (interactorComparator == null){
            interactorComparator = new UnambiguousExactInteractorComparator();
        }
        return interactorComparator;
    }

    /** {@inheritDoc} */
    public void setInteractorComparator(Comparator<Interactor> interactorComparator) {
        this.interactorComparator = interactorComparator;
    }

    /**
     * <p>isFullEnrichment.</p>
     *
     * @return a boolean.
     */
    protected boolean isFullEnrichment() {
        return true;
    }

    /** {@inheritDoc} */
    @Override
    protected void processOtherProperties(InteractorPool poolToEnrich, InteractorPool fetched) throws EnricherException {
        processMembers(poolToEnrich, fetched);
    }

    /**
     * <p>processMembers.</p>
     *
     * @param poolToEnrich a {@link psidev.psi.mi.jami.model.InteractorPool} object.
     * @param fetched a {@link psidev.psi.mi.jami.model.InteractorPool} object.
     * @throws psidev.psi.mi.jami.enricher.exception.EnricherException if any.
     */
    protected void processMembers(InteractorPool poolToEnrich, InteractorPool fetched) throws EnricherException {
        if (fetched != null){
            TreeSet<Interactor> set1 = new TreeSet<Interactor>(getInteractorComparator());
            set1.addAll(poolToEnrich);
            TreeSet<Interactor> set2 = new TreeSet<Interactor>(getInteractorComparator());
            set2.addAll(fetched);

            Iterator<Interactor> iterator1 = set1.iterator();
            Iterator<Interactor> iterator2 = set2.iterator();

            Collection<Interactor> interactorsToAdd = new ArrayList<Interactor>(fetched.size());
            Interactor i1 = iterator1.hasNext() ? iterator1.next() : null;
            Interactor i2 = iterator2.hasNext() ? iterator2.next() : null;
            while(i1 != null && i2 != null){

                int comp = getInteractorComparator().compare(i1, i2);
                // i1 is before i2. It means that i1 is not in i2
                // we can delete the interactor from the object to enrich if allowed
                if (comp < 0){
                    // we enrich i2
                    if (getInteractorEnricher() != null){
                        getInteractorEnricher().enrich(i1);
                    }
                    i1 = iterator1.hasNext() ? iterator1.next() : null;
                }
                // i1 is after i2. It means that i2 is not in i1
                // we can add the interactor to the object to enrich
                else if (comp > 0){
                    interactorsToAdd.add(i2);
                    if (getListener() instanceof InteractorPoolChangeListener){
                        ((InteractorPoolChangeListener)getListener()).onAddedInteractor(poolToEnrich, i2);
                    }
                    // we enrich i2
                    if (getInteractorEnricher() != null){
                        getInteractorEnricher().enrich(i2);
                    }
                    i2 = iterator2.hasNext() ? iterator2.next() : null;
                }
                // i1 is the same as i2.
                else{
                    // we enrich i1 with properties of i2 in case we have small differences
                    if (getInteractorEnricher() != null){
                        getInteractorEnricher().enrich(i1, i2);
                        // then enrich i1
                        getInteractorEnricher().enrich(i1);
                    }
                    i1 = iterator1.hasNext() ? iterator1.next() : null;
                    i2 = iterator2.hasNext() ? iterator2.next() : null;
                }
            }

            // It means that i2 is not in i1
            // we can add the interactor to the object to enrich
            if (i2 != null){
                interactorsToAdd.add(i2);
                while(iterator2.hasNext()){
                    Interactor interactorToAdd = iterator2.next();
                    interactorsToAdd.add(interactorToAdd);
                    if (getListener() instanceof InteractorPoolChangeListener){
                        ((InteractorPoolChangeListener)getListener()).onAddedInteractor(poolToEnrich, interactorToAdd);
                    }
                }
            }

            poolToEnrich.addAll(interactorsToAdd);
        }
        else if (getInteractorEnricher() != null){
            for (Interactor i : poolToEnrich){
                getInteractorEnricher().enrich(i);
            }
        }
    }
}
