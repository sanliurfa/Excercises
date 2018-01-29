/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */



/*******************************************************************************
 * Instance¨s of class {@code Arrow} represent arrows pointing towards east.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Arrow implements IPaintable
{
    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Rectangular part representing body of the arrow. */
    private Rectangle body;

    /** Triangular part representing the head of the arrow. */
    private Triangle head;

    /** Color of the whole arrow. */
    private NamedColor color;



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
         this(0, 0);
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
        this(x, y, NamedColor.BLACK);
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
        this(x, y, 50, color);
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
        this(x, y, module, NamedColor.BLACK);
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
        this.body  = new Rectangle(x,         y+module/3,
                                   module/2,   module/3, color);
        this.head = new Triangle  (x+module/2, y,
                                   module/2,   module,   color, Direction8.EAST);
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



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
