/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */



/*******************************************************************************
 * Instances of class {@code Arrow} represent arrows pointing towards east.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Arrow implements IModular
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Default horizontal coordinate. */
    private static final int DEFAULT_X = 0;

    /** Default vertical coordinate. */
    private static final int DEFAULT_Y = 0;

    /** Default module = size of the circumscribed square = arrow length. */
    private static final int DEFAULT_MODULE = 50;

    /** Default color. */
    private static final NamedColor DEFAULT_COLOR = NamedColor.BLACK;



    //== VARIABLE CLASS FIELDS =================================================

     /** Number of so far created instances. */
     private static int countCreated = 0;



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Identification number of the instance. */
    private final int ID;

    /** Rectangular part representing body of the arrow. */
    private final Rectangle body;

    /** Triangular part representing the head of the arrow. */
    private final Triangle head;

    /** Color of the whole arrow. */
    private final NamedColor color;



    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates an arrow of default size and color
     * which will be placed at the upper left corner.
     */
    public Arrow()
    {
        this(DEFAULT_X, DEFAULT_Y);
    }


    /***************************************************************************
     * Creates an arrow with the  default size and color
     * which will be placed at the given coordinates.
     *
     * @param x  Horizontal coordinate
     * @param y  Vertical coordinate
     */
    public Arrow(int x, int y)
    {
        this(x, y, DEFAULT_COLOR);
    }


    /***************************************************************************
     * Creates an arrow with the default size and the given color
     * which will be placed at the given coordinates.
     *
     * @param x      Horizontal coordinate
     * @param y      Vertical coordinate
     * @param color  The color of the arrow
     */
    public Arrow(int x, int y, NamedColor color)
    {
        this(x, y, DEFAULT_MODULE, color);
    }


    /***************************************************************************
     * Creates an arrow with the given size and the default color
     * which will be placed at the given coordinates.
     *
     * @param x      Horizontal coordinate
     * @param y      Vertical coordinate
     * @param module The size of the created arrow
     */
    public Arrow(int x, int y, int module)
    {
        this(x, y, module, DEFAULT_COLOR);
    }


    /***************************************************************************
     * Creates an arrow with the given size and color
     * which will be placed at the given coordinates.
     *
     * @param x      Horizontal coordinate
     * @param y      Vertical coordinate
     * @param module The size of the created arrow
     * @param color  Arrow color
     */
    public Arrow(int x, int y, int module, NamedColor color)
    {
        countCreated   = countCreated + 1;
        this.ID = countCreated;

        int m2 = module / 2;
        int m3 = module / 3;

        this.body  = new Rectangle   (x,    y+m3, m2, m3,   color);
        this.head = new Triangle(x+m2, y,    m2, module,color, Direction8.EAST);
        this.color   = color;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Sets new color of the arrow; it still remembers its previous color.
     *
     * @param color The set color
     */
    public void setColor(NamedColor color)
    {
        body.setColor(color);
        head.setColor(color);
    }


    // Sada přístupových metod vlastnosti: Position ******************************

    /***************************************************************************
     * Returns horizontal coordinate of the instance.
     *
     * @return  Horizontal coordinate
     */
    public int getX()
    {
        return body.getX();
    }


    /***************************************************************************
     * Returns vertical coordinate of the instance.
     *
     * @return  Vertical coordinate
     */
    public int getY()
    {
        return head.getY();
    }


    /***************************************************************************
     * Returns the current position.
     *
     * @return The current position
     */
    @Override
    public Position getPosition()
    {
        return new Position(getX(), getY());
    }


    /***************************************************************************
     * Sets the new position.
     *
     * @param p The set position
     */
    @Override
    public void setPosition(Position p)
    {
        this.setPosition(p.x, p.y);
    }


    /***************************************************************************
     * Sets the given coordinates.
     *
     * @param x  Horizontal coordinate
     * @param y  Vertical coordinate
     */
    @Override
    public void setPosition(int x, int y)
    {
        int m  = head.getHeight();
        int m2 = m / 2;
        int m3 = m / 3;

        body .setPosition(x,    y+m3);
        head.setPosition(x+m2, y);
    }


    /***************************************************************************
     * Returns the basic size from which we will derive all the gauges
     * of the object &ndash; in the case of the arrow it is
     * its length.
     *
     * @return The module (the arrow length)
     */
    @Override
    public int getModule()
    {
        return head.getHeight();
    }


    /***************************************************************************
     * Sets the basic size from which we will derive all the gauges
     * of the object &ndash; in the case of the arrow it is
     * its length.
     *
     * @param module The set module (the arrow length)
     */
    @Override
    public void setModule(int module)
    {
        int x  = body.getX();
        int y  = head.getY();
        int m  = module;
        int m2 = m / 2;
        int m3 = m / 3;

        body .setPosition(x,    y+m3);
        head.setPosition(x+m2, y);

        body .setSize(m2, m3);
        head.setSize(m2, m);
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Makes the arrow more transparent.
     */
    public void translucent()
    {
        body.setColor(color.translucent());
        head.setColor(color.translucent());
    }


    /***************************************************************************
     * Restores the original color of the arrow.
     */
    public void restoreColor()
    {
        setColor(color);
    }


    /***************************************************************************
     * Paint the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
    @Override
    public void paint(Painter painter)
    {
        body.paint(painter);
        head.paint(painter);
    }


    /***************************************************************************
     * Returns a text representation (signature) of the instance
     * used especially for debug purpose.
     *
     * @return The asked text representation
     */
    @Override
    public String toString()
    {
        return "Arrow" + ID + "(" + getPosition() + ", module=" + getModule() +
               ", color=" + color + ")";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
