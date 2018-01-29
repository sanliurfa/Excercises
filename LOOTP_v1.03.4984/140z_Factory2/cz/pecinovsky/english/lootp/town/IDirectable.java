/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.IModular;

import cz.pecinovsky.english.lootp.util.Direction8;



/*******************************************************************************
 * The {@code IDirectable} instances represents modular instances
 * which are able to turn in the defined direction.
 * These instances are mostly intended for going through the winding roads,
 * however it may be also a stationary instances,
 * which should be turned to a specified direction.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IDirectable extends IModular
{
    //== CONSTANTS =============================================================
    //== DECLARED METHODS ======================================================

    /***************************************************************************
     * Return the direction to which the instance is turned.
     *
     * @return Direction to which the instance is turned
     */
//    @Override
    public Direction8 getDirection();


    /***************************************************************************
     * Turn the instance to the given direction.
     *
     * @param direction The direction, instance should be turned to
     */
//    @Override
    public void setDirection(Direction8 direction);



    //== INHERITED METHODS =====================================================
    //== EMBEDDED DATA TYPES ===================================================
}
