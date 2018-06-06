/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */


/*******************************************************************************
 * Instance of the class {@code Light} represents simulated lights
 * which can be turned on and off.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Light implements IMovable
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Default horizontal coordinate. */
    private static final int DEFAULT_X = 0;

    /** Default vertical coordinate. */
    private static final int DEFAULT_Y = 0;

    /** Default color of a switched-on light. */
    private static final NamedColor DEFAULT_LIGHT_COLOR = NamedColor.YELLOW;

    /** Default color of a switched-off light. */
    private static final NamedColor DEFAULT_DARK_COLOR = NamedColor.BLACK;

    /** Default size of the light diameter. */
    private static final int DEFAULT_DIAMETER = 50;



    //== VARIABLE CLASS FIELDS =================================================

     /** Number of so far created instances. */
     private static int countCreated = 0;



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Identification number of given instance. */
    private final int ID;

    /** Color of the light when turned on. */
    private final NamedColor color;

    /** Color of the light when turned off. */
    private final NamedColor switchedOffColor;

    /** Shape representing the light on the canvas. */
    private final Ellipse bulb;



    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a new light with the default size and color,
     * which will be placed into the upper left corner.
     */
    public Light()
    {
        this(DEFAULT_X, DEFAULT_Y);
    }


    /***************************************************************************
     * Creates a new light with the default size and color,
     * which will be placed at the given coordinates.
     *
     * @param x  Horizontal coordinate
     * @param y  Vertical coordinate
     */
    public Light(int x, int y)
    {
        this(x, y, DEFAULT_LIGHT_COLOR);
    }


    /***************************************************************************
     * Creates a new light with the default size, the entered color,
     * which will be placed at the given coordinates.
     *
     * @param x     Horizontal coordinate
     * @param y     Vertical coordinate
     * @param color Color of the turned on light
     */
    public Light(int x, int y, NamedColor color)
    {
        this(x, y, DEFAULT_DIAMETER, color);
    }


    /***************************************************************************
     * Creates a new light with the given size, the default color,
     * which will be placed at the given coordinates.
     *
     * @param x         Horizontal coordinate
     * @param y         Vertical coordinate
     * @param diameter  Diameter of the light
     */
    public Light(int x, int y, int diameter)
    {
        this(x, y, diameter, DEFAULT_LIGHT_COLOR);
    }


    /***************************************************************************
     * Creates a new light with the given size and color,
     * which will be placed at the given coordinates.
     *
     * @param x         Horizontal coordinate
     * @param y         Vertical coordinate
     * @param diameter  Diameter of the light
     * @param color     Color of the turned on light
     */
    public Light(int x, int y, int diameter, NamedColor color)
    {
        this(x, y, diameter, color, DEFAULT_DARK_COLOR);
    }


    /***************************************************************************
     * Creates a new light with the given size and color,
     * and with the given box color,
     * which will be placed at the entered coordinates.
     *
     * @param x                Horizontal coordinate
     * @param y                Vertical coordinate
     * @param diameter         Diameter of the light
     * @param color            Color of the turned on light
     * @param switchedOffColor Color of the switched of light
     */
    public Light(int x, int y, int diameter, NamedColor color,
                                             NamedColor switchedOffColor)
    {
        countCreated = countCreated + 1;
        this.ID      = countCreated;
        this.bulb    = new Ellipse(x, y, diameter, diameter, color);
        this.color   = color;
        this.switchedOffColor = switchedOffColor;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns the color of the light when turned on.
     *
     * @return  Color of the light when turned on
     */
    public NamedColor getColor()
    {
        return color;
    }


    // Sada přístupových metod vlastnosti: Position ******************************

    /***************************************************************************
     * Returns x (horizontal) coordinate of position of the instance.
     *
     * @return  Horizontal coordinate
     */
    public int getX()
    {
        return bulb.getX();
    }


    /***************************************************************************
     * Returns y (vertical) coordinate of position of the instance.
     *
     * @return  Vertical coordinate
     */
    public int getY()
    {
        return bulb.getY();
    }


    /***************************************************************************
     * Returns the current position.
     *
     * @return Current position
     */
    @Override
    public Position getPosition()
    {
        return new Position(getX(), getY());
    }


    /***************************************************************************
     * Sets the given position.
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
     * @param x   The set horizontal coordinate
     * @param y   The set vertical coordinate
     */
    @Override
    public void setPosition(int x, int y)
    {
        bulb.setPosition(x, y);
    }


    // Sada přístupových metod vlastnosti: Rozměr / Modul **********************

    /***************************************************************************
     * Returns the diameter of the light.
     *
     * @return Diameter of the light
     */
    public int getDiameter()
    {
        return bulb.getHeight();
    }


    /***************************************************************************
     * Returns the size of the circumscribed square.
     *
     * @return The size of the circumscribed square
     */
    public int getModule()
    {
        return getDiameter();
    }


    /***************************************************************************
     * Sets the new module (and so also the size) of the light.
     *
     * @param module  The set module
     */
    public void setModule(int module)
    {
        bulb.setSize(module);
    }


    /***************************************************************************
     * Returns information if the light is currently on or off.
     *
     * @return If the light is turned off, it returns {@code true},
     *         otherwise it returns {@code false}
     */
    public boolean isOff()
    {
        return bulb.getColor().equals(switchedOffColor);
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Turns the light on for 500 milliseconds and then turns it off.
     */
    public void blink()
    {
        switchOn ();    IO.pause(500);
        switchOff();    IO.pause(500);
    }


    /***************************************************************************
     * Paints the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
    @Override
    public void paint(Painter painter)
    {
        bulb.paint(painter);
    }


    /***************************************************************************
     * Turns the light on, that means it will set its color
     * to the light-on-color.
     */
    public void switchOn()
    {
        bulb.setColor(color);
    }


    /***************************************************************************
     * Turns the light off, that means it will set its color
     * to the light-off-color.
     */
    public void switchOff()
    {
        bulb.setColor(switchedOffColor);
    }


    /***************************************************************************
     * Return the text representation (text signature) of the given instance.
     * It is used mostly for debugging.
     *
     * @return The requested text representation
     */
    @Override
    public String toString()
    {
        return "Light_"    + ID          + "("               + getPosition() +
               ", module=" + getModule() + ", color="        + color         +
               ", switchedOffColor="     + switchedOffColor  +
               ", isOff="  + isOff()     + ")";
    }




    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}