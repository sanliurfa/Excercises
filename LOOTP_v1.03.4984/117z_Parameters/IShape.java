


/*******************************************************************************
 * Instances of interface {@code IShape} represents geometrical shapes
 * that are mind for work on a virtual canvas
 * during the first introduction to objects.
 * The position of a shape is defined as the position
 * of the upper left corner of its circumscribe rectangle.
 * The size of a shape is defined as the size
 * of its circumscribe rectangle.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IShape extends IChangeable
{
    //== CONSTANTS =============================================================
    //== DECLARED METHODS ======================================================

    /***************************************************************************
     * Paints the represented shape on the canvas.
     */
//     @Override
    public void paint();


    /***************************************************************************
     * Rubs out represented shape from the canvas, it means
     * repaints it by the background color.
     */
//     @Override
    public void rubOut();


    /***************************************************************************
     * Returns a copy of the shape, which means the same shape
     * with the same position, dimension and color.
     *
     * @return The requested copy
     */
//     @Override
    public IShape copy();



    //== INHERITED METHODS =====================================================
    //== EMBEDDED DATA TYPES ===================================================
}
