/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.manager;

import cz.pecinovsky.english.lootp.util.Position;



/*******************************************************************************
 * Instances of interface {@code IMovable} represents geometrical shapes
 * that can reveal and set their position.
 * The position of a shape is defined as the position
 * of the upper left corner of its circumscribe rectangle.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IMovable extends IPaintable
{
    //== CONSTANTS =============================================================
    //== GETTERS AND SETTERS ===================================================

    /***************************************************************************
     * Returns instance of the class {@code Position} with current position.
     * The position of a shape is defined as the position
     * of the upper left corner of its circumscribe rectangle.
     *
     * @return Instance of the class {@code Position} with current position
     */
//     @Override
    public Position getPosition();


    /***************************************************************************
     * Set a new position of the instance.
     * The position of a shape is defined as the position
     * of the upper left corner of its circumscribe rectangle.
     *
     * @param position   The set position
     */
//     @Override
    public void setPosition(Position position);


    /***************************************************************************
     * Set a new coordinates of the instance.
     * The position of a shape is defined as the position
     * of the upper left corner of its circumscribe rectangle.
     *
     * @param x  The newly set horizontal coordinate,
     *           left canvas border has x=0, coordinate increases to the right
     * @param y  The newly set vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     */
//     @Override
    public void setPosition(int x, int y);



    //== OTHER METHODS =========================================================
    //== EMBEDDED DATA TYPES ===================================================
}
