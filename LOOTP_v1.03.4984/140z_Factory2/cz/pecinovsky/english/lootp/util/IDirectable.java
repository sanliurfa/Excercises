/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.util;



/*******************************************************************************
 * The {@code IDirectable} instances represent modular instances
 * which are able to turn in the defined direction.
 * These instances are mostly intended for going through the winding roads,
 * however, they may be also stationary instances,
 * which should be turned to a specified direction.

 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IDirectable
{
    //== CONSTANTS =============================================================
    //== DEFAULT STATIC METHODS ================================================
    //== ABSTRACT GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns the direction to which the instance is turned.
     *
     * @return Direction to which the instance is turned
     */
//    @Override
    public Direction8 getDirection();


    /***************************************************************************
     * Turns the instance to the given direction.
     *
     * @param direction The direction, instance should be turned to
     */
//    @Override
    public void setDirection(Direction8 direction);



    //== OTHER ABSTRACT METHODS ================================================
    //== DEFAULT GETTERS AND SETTERS ===========================================
    //== OTHER DEFAULT METHODS =================================================
    //== EMBEDDED DATA TYPES ===================================================
}
