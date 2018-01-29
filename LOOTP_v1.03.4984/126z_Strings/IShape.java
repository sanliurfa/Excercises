/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */



/*******************************************************************************
 * Instances of the interface {@code IShape} represents
 * general geometric objects
 * that are mind for work on a virtual canvas
 * during the first introduction to objects.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IShape extends IChangeable, ICopyable
{
    //== CONSTANTS =============================================================
    //== GETTERS AND SETTERS ===================================================
    //== OTHER METHODS =========================================================

    /***************************************************************************
     * Returns a deep copy of the instance.
     * <p>
     * In opposition to its parent that returns an instance of the interface
     * {@link ICopyable} this method restricts the returned values
     * to instances of this interface {@code IShape}.
     *
     * @return The requested copy
     */
    @Override
    public IShape copy();



    //== EMBEDDED DATA TYPES ===================================================
}
