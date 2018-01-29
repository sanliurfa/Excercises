/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.manager;



/*******************************************************************************
 * Interface {@code IControllable} defines the requirements to the object
 * controlled from a keyboard by cursor keys, space bar and Enter key.
 * It supposes that the controlled objects should be painted on the canvas
 * and therefore they should implement the {@link IPaintable} interface.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IControllable extends IPaintable
{
    //== CONSTANTS =============================================================
    //== GETTERS AND SETTERS ===================================================
    //== OTHER METHODS =========================================================

    /***************************************************************************
     * Reacts to the right arrow key or its equivalent.
     */
//    @Override
    public void right();


    /***************************************************************************
     * Reacts to the left arrow key or its equivalent.
     */
//    @Override
    public void left();


    /***************************************************************************
     * Reacts to the up arrow key or its equivalent.
     */
//    @Override
    public void up();


    /***************************************************************************
     * Reacts to the down arrow key or its equivalent.
     */
//    @Override
    public void down();


    /***************************************************************************
     * Reacts to the Enter key or its equivalent.
     */
//    @Override
    public void enter();


    /***************************************************************************
     * Reacts to the space bar key or its equivalent.
     */
//    @Override
    public void space();


    /***************************************************************************
     * Reacts to the Escape key or its equivalent.,
     * i.e. to the ending of the control from the keyboard.
     */
//    @Override
    public void escape();



    //== EMBEDDED DATA TYPES ===================================================
}
