package psidev.psi.mi.jami.model.impl;

import psidev.psi.mi.jami.model.*;
import psidev.psi.mi.jami.utils.comparator.interaction.UnambiguousExactModelledInteractionComparator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Default implemntation for ModelledInteraction
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>05/02/13</pre>
 */

public class DefaultModelledInteraction extends DefaultInteraction implements ModelledInteraction{

    private Collection<Experiment> experiments;
    private Source source;
    private Collection<ModelledParticipant> modelledParticipants;

    public DefaultModelledInteraction() {
        super();
    }

    public DefaultModelledInteraction(String shortName) {
        super(shortName);
    }

    public DefaultModelledInteraction(String shortName, Source source) {
        super(shortName, source);
    }

    public DefaultModelledInteraction(String shortName, CvTerm type) {
        super(shortName, type);
    }

    public DefaultModelledInteraction(String shortName, Source source, CvTerm type) {
        this(shortName, type);
        this.source = source;
    }

    protected void initialiseModelledParticipants(){
        this.modelledParticipants = new ArrayList<ModelledParticipant>();
    }

    protected void initialiseExperiments(){
        this.experiments = new ArrayList<Experiment>();
    }

    protected void initialiseExperimentsWith(Collection<Experiment> experiments){
        if (experiments == null){
            this.experiments = Collections.EMPTY_LIST;
        }
        else {
            this.experiments = experiments;
        }
    }

    protected void initialiseModelledParticipantsWith(Collection<ModelledParticipant> participants){
        if (participants == null){
            this.modelledParticipants = Collections.EMPTY_LIST;
        }
        else {
            this.modelledParticipants = participants;
        }
    }

    public Collection<Experiment> getExperiments() {
        if (experiments == null){
            initialiseExperiments();
        }
        return this.experiments;
    }

    public Collection<? extends ModelledParticipant> getModelledParticipants() {
        if (modelledParticipants == null){
            initialiseModelledParticipants();
        }
        return this.modelledParticipants;
    }

    public Source getSource() {
        return this.source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public boolean addModelledParticipant(ModelledParticipant part) {
        if (part == null){
            return false;
        }
        if (modelledParticipants == null){
            initialiseModelledParticipants();
        }
        if (modelledParticipants.add(part)){
            part.setModelledInteraction(this);
            return true;
        }
        return false;
    }

    public boolean removeModelledParticipant(ModelledParticipant part) {
        if (part == null){
            return false;
        }
        if (modelledParticipants == null){
            initialiseModelledParticipants();
        }
        if (modelledParticipants.remove(part)){
            part.setModelledInteraction(null);
            return true;
        }
        return false;
    }

    public boolean addAllModelledParticipants(Collection<? extends ModelledParticipant> participants) {
        if (participants == null){
            return false;
        }

        boolean added = false;
        for (ModelledParticipant p : participants){
            if (addModelledParticipant(p)){
                added = true;
            }
        }
        return added;
    }

    public boolean removeAllModelledParticipants(Collection<? extends ModelledParticipant> participants) {
        if (participants == null){
            return false;
        }

        boolean removed = false;
        for (ModelledParticipant p : participants){
            if (removeModelledParticipant(p)){
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }

        if (!(o instanceof ModelledInteraction)){
            return false;
        }

        // use UnambiguousExactModelledInteraction comparator for equals
        return UnambiguousExactModelledInteractionComparator.areEquals(this, (ModelledInteraction) o);
    }
}
