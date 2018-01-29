/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.util;



/*******************************************************************************
 * Instances of the  {@code ITurnable4} interface represents object
 * that are able to turn into four cardinal directions.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface ITurnable4 //extends IDirectable
{
    //== CONSTANTS =============================================================
    //== DECLARED GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Return the direction, into which the instance is turned.
     *
     * @return Direction, into which the instance is turned
     */
//    @Override
    public Direction8 getDirection();

//
//    /***************************************************************************
//     * Turns the instance into the given direction.
//     *
//     * @param direction Direction, into which the instance should be turned
//     */
//    @Override
//    public void setDirection(Direction8 direction);
//
//
//
    //== INHERITED GETTERS AND SETTERS =========================================
    //== REMAINING DECLARED METHODS ============================================

    /***************************************************************************
     * Turns the instance by 90° to the left.
     */
    public void turnLeft();


    /***************************************************************************
     * Turns the instance by 90° to the right.
     */
    public void turnRight();


    /***************************************************************************
     * Turns the instance by .
     */
    public void turnAbout();


    /***************************************************************************
     * Turns the instance to the given direction.
     * It is the {@code setDirection(Direction8)} method with another name
     * to better correspond with other names in this interface.
     *
     * @param direction Direction, into which the instance should be turned
     */
    public void turnTo4(Direction8 direction);



    //== REMAINING INHERITED METHODS ===========================================
    //== EMBEDDED DATA TYPES ===================================================
}
