/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */



/*******************************************************************************
 * Instances of class {@code Position} are trasport objects (crates)
 * containing dimensions.
 * Their attributes are therefore defined as public constants.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Area
{
    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS ATTRIBUTES==============================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Horizontal coordinate of the area = of its upper left corner. */
    public final int x;

    /** Vertical coordinate of the area = of its upper left corner. */
    public final int y;

    /** Object width. */
    public final int width;

    /** Object height. */
    public final int height;



    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS========================================

    /***************************************************************************
     * Creates new area with given position and dimensions.
     *
     * @param x Horizontal coordinate of the upper left corner
     * @param y Vertical coordinate of the upper left corner
     * @param width  Width of the area
     * @param height Height of the area
     */
    public Area(int x, int y, int width, int height)
    {
        this.x     = x;
        this.y     = y;
        this.width = width;
        this.height = height;
    }


    /***************************************************************************
     * Creates new area with given position and dimensions.
     *
     * @param position Position of the upper left corner
     * @param size     Size of the area
     */
    public Area(Position position, Size size)
    {
        this(position.x, position.y, size.width, size.height);
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns the horizontal coordinate.
     *
     * @return  The horizontal coordinate
     */
    public int getX()
    {
        return x;
    }


    /***************************************************************************
     * Returns the vertical coordinate.
     *
     * @return  The vertical coordinate
     */
    public int getY()
    {
        return y;
    }


    /***************************************************************************
     * Returns the positon af the area.
     *
     * @return  The positon af the area
     */
    public Position getPosition()
    {
        return new Position (x, y);
    }


    /***************************************************************************
     * Returns the area's width.
     *
     * @return  Area's width
     */
    public int getWidth()
    {
        return width;
    }


    /***************************************************************************
     * Returns the area's height.
     *
     * @return  Area's height
     */
    public int getHeight()
    {
        return height;
    }


    /***************************************************************************
     * Returns the area's size.
     *
     * @return  Area's size
     */
    public Size getSize()
    {
        return new Size(width, height);
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Returns a string representation of the object.
     * It is used mostly for debugging purposes.
     *
     * @return String representation of the instance
     */
    @Override
    public String toString()
    {
        return "Area:[x=" + x + ", y=" + y +
               ", width=" + width + ", height=" + height + "]";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== EMBEDDED AND INNER CLASSES ============================================
    //== TESTING CLASSES AND METHODS ===========================================
}
