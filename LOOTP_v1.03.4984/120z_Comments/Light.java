


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
        bulb  = new Ellipse();
        color = bulb.getColor();
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
        bulb  = new Ellipse(x, y, 50, 50);
        color = bulb.getColor();
    }


    /***************************************************************************
     * Creates a new light with the default size, the entered color,
     * which will be placed at the given coordinates.
     *
     * @param x     Horizontal coordinate
     * @param y     Vertical coordinate
     * @param b     Color of the turned on light
     */
    public Light(int x, int y, NamedColor b)
    {
        color = b;
        bulb  = new Ellipse(x, y, 50, 50, color);
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
        bulb.setColor(NamedColor.BLACK);
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
