/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.manager;



/*******************************************************************************
 * Interface add to the inherited methods the {@link #moved()} method,
 * which will be called by a {@link Multimover} in the moment,
 * when it brings the multimovable object to the requested target.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IMultimovable extends IMovable
{
    //== CONSTANTS =============================================================
    //== GETTERS AND SETTERS ===================================================
    //== OTHER METHODS =========================================================

    /***************************************************************************
     * Method called by multimover in the moment,
     * when it brings the object to the requested target.
     */
//    @Override
    public void moved();



    //== EMBEDDED DATA TYPES ===================================================
}
