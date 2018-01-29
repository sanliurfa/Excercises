


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
    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================

    /***************************************************************************
     * Returns the horizontal coordinate.
     * The position of a shape is defined as the position
     * of the upper left corner of its circumscribe rectangle.
     *
     * @return  The horizontal coordinate,
     *          left canvas border has x=0, coordinate increases to the right
     */
//     @Override
    public int getX();


    /***************************************************************************
     * Returns the vertical coordinate.
     * The position of a shape is defined as the position
     * of the upper left corner of its circumscribe rectangle.
     *
     * @return  The vertical coordinate,
     *          upper canvas border has y=0, coordinate increases to the down
     */
//     @Override
    public int getY();


    /***************************************************************************
     * Set a new position of the instance.
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



    //== INHERITED METHODS =====================================================
    //== EMBEDDED DATA TYPES ===================================================
}
