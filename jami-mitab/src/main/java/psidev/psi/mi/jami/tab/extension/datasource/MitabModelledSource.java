package psidev.psi.mi.jami.tab.extension.datasource;

import psidev.psi.mi.jami.datasource.ModelledInteractionSource;
import psidev.psi.mi.jami.model.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * A mitab datasource that loads modelled interactions and ignore experimental details
 * It will load the full interaction dataset.
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>08/11/13</pre>
 */
public class MitabModelledSource extends AbstractMitabSource<ModelledInteraction, ModelledParticipant, ModelledFeature> implements ModelledInteractionSource<ModelledInteraction>{
    /**
     * <p>Constructor for MitabModelledSource.</p>
     */
    public MitabModelledSource() {
        super(new MitabModelledStreamSource());
    }

    /**
     * <p>Constructor for MitabModelledSource.</p>
     *
     * @param file a {@link java.io.File} object.
     * @throws java.io.IOException if any.
     */
    public MitabModelledSource(File file) throws IOException {
        super(new MitabModelledStreamSource(file));
    }

    /**
     * <p>Constructor for MitabModelledSource.</p>
     *
     * @param input a {@link java.io.InputStream} object.
     */
    public MitabModelledSource(InputStream input) {
        super(new MitabModelledStreamSource(input));
    }

    /**
     * <p>Constructor for MitabModelledSource.</p>
     *
     * @param reader a {@link java.io.Reader} object.
     */
    public MitabModelledSource(Reader reader) {
        super(new MitabModelledStreamSource(reader));
    }
}
