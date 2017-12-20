package psidev.psi.mi.jami.datasource;

/**
 * A source locator of an object in a file
 *
 * @author Marine Dumousseau (marine@ebi.ac.uk)
 * @version $Id$
 * @since <pre>22/03/13</pre>
 */
public class FileSourceLocator {

    private int lineNumber = -1;
    private int charNumber = -1;

    /**
     * <p>Constructor for FileSourceLocator.</p>
     *
     * @param lineNumber a int.
     * @param charNumber a int.
     */
    public FileSourceLocator(int lineNumber, int charNumber){
        this.lineNumber = lineNumber;
        this.charNumber = charNumber;
    }

    /**
     * The line number in the file where the object is located
     *
     * @return the line number
     */
    public int getLineNumber() {
        return lineNumber;
    }

    /**
     * The character number in the file where the object is located.
     *
     * @return the character number
     */
    public int getCharNumber() {
        return charNumber;
    }

    /**
     * <p>toString</p>
     *
     * @return a {@link java.lang.String} object.
     */
    public String toString() {
        return "Line: " + lineNumber + ", Character: " + charNumber;
    }
}
