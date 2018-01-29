/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.manager;

import cz.pecinovsky.english.lootp.util.Size;



/*******************************************************************************
 * Instances of interface {@code IResizable} represents geometrical shapes
 * that can reveal and set their dimensions.
 * The size of a shape is defined as the size
 * of its circumscribe rectangle.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IResizable extends IPaintable
{
    //== CONSTANTS =============================================================
    //== GETTERS AND SETTERS ===================================================

    /***************************************************************************
     * Returns instance of the class {@code Size} with current dimensions.
     * The size of instance is defined as the size
     * of the circumscribe rectangle.
     *
     * @return Instance of the class {@code Size} with current dimensions
     */
//     @Override
    public Size getSize();


    /***************************************************************************
     * Set dimensions of the object.
     * The size of instance is defined as the size
     * of the circumscribe rectangle.
     * The set dimensions must be non-negative,
     * the zero value is substituted by one.
     *
     * @param width    The newly set width;  width  &gt;= 0
     * @param height   The newly set height; height &gt;= 0
     */
//    @Override
    public void setSize(int width, int height);


    /***************************************************************************
     * Set dimensions of the object.
     * The size of instance is defined as the size
     * of the circumscribe rectangle.
     * The set dimensions must be non-negative,
     * the zero value is substituted by one.
     *
     * @param size The set size
     */
//    @Override
    public void setSize(Size size);



    //== OTHER METHODS =========================================================
    //== EMBEDDED DATA TYPES ===================================================
}
