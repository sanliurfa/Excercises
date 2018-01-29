


/*******************************************************************************
 * Instances of interface {@code IChangeable} represents geometrical shapes
 * that can reveal and set their positions and dimensions.
 * The position of a shape is defined as the position
 * of the upper left corner of its circumscribe rectangle.
 * The size of a shape is defined as the size
 * of its circumscribe rectangle.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IChangeable
{
    //== CONSTANTS =============================================================
    //== DECLARED METHODS ======================================================
    //== INHERITED METHODS =====================================================

    /***************************************************************************
     * Returns the horizontal coordinate.
     * The position of a shape is defined as the position
     * of the upper left corner of its circumscribe rectangle.
     *
     * @return  The horizontal coordinate,
     *          left canvas border has x=0, coordinate increases to the right
     */
    public int getX();


    /***************************************************************************
     * Returns the vertical coordinate.
     * The position of a shape is defined as the position
     * of the upper left corner of its circumscribe rectangle.
     *
     * @return  The vertical coordinate,
     *          upper canvas border has y=0, coordinate increases to the down
     */
    public int getY();


    /***************************************************************************
     * Set a new position of the instance.
     * The position of a shape is defined as the position
     * of the upper left corner of its circumscribe rectangle.
     *
     * @param x  The newly set horizontal coordinate,
     *           Left canvas border has x=0, coordinate increases to the right
     * @param y  The newly set vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     */
    public void setPosition(int x, int y);


    /***************************************************************************
     * Returns the object width.
     * The size of instance is defined as the size
     * of the circumscribe rectangle.
     *
     * @return  Object width
     */
    public int getWidth();


    /***************************************************************************
     * Returns the object height.
     * The size of instance is defined as the size
     * of the circumscribe rectangle.
     *
     * @return  Object height
     */
    public int getHeight();


    /***************************************************************************
     * Set dimensions of the object.
     * The size of instance is defined as the size
     * of the circumscribe rectangle.
     * The set dimensions must be non-negative,
     * the zero value is substituted by one.
     *
     * @param width    The newly set width;  width&gt;0
     * @param height   The newly set height; height&gt;0
     */
    public void setSize(int width, int height);



    //== EMBEDDED DATA TYPES ===================================================
}
