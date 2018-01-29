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
public class Light implements IPaintable
{
    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Color of the light when turned on. */
    private NamedColor  color;

    /** Color of the light when turned off. */
    private NamedColor switchedOffColor;

    /** Shape representing the light on the canvas. */
    private Ellipse bulb;



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
        this(0, 0);
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
        this(x, y, NamedColor.YELLOW);
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
        this(x, y, 50, color);
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
        this(x, y, diameter, NamedColor.YELLOW);
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
        this(x, y, diameter, color, NamedColor.BLACK);
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
        this.bulb  = new Ellipse(x, y, diameter, diameter, color);
        this.color = color;
        this.switchedOffColor = switchedOffColor;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
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



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
