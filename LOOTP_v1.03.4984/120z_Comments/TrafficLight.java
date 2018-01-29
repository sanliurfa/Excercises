

/*******************************************************************************
 * Instance of class {@code TrafficLight} represent traffic lights
 * similar to those which operate the traffic on crossroads.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class TrafficLight implements IPaintable
{
    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Box with lights */
    private Rectangle box;

    /** Upper (red) light */
    private Light redLight;

    /** Middle (amber) light */
    private Light amberLight;

    /** Bottom (green) light */
    private Light greenLight;



    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a traffic light with default size and color
     * which will be placed into the upper left corner.
     */
    public TrafficLight()
    {
        box        = new Rectangle(0,   0, 50, 150, NamedColor.BLACK);
        redLight   = new Light    (0,   0, NamedColor.RED);
        amberLight = new Light    (0,  50, NamedColor.AMBER);
        greenLight = new Light    (0, 100, NamedColor.GREEN);
    }


    /***************************************************************************
     * Creates a traffic light with default size and color
     * which will be placed at given coordinates.
     *
     * @param x  Horizontal coordinate
     * @param y  Vertical coordinate
     */
    public TrafficLight(int x, int y)
    {
        box        = new Rectangle(x, y+  0,  50, 150, NamedColor.BLACK);
        redLight   = new Light    (x, y+  0, NamedColor.RED);
        amberLight = new Light    (x, y+ 50, NamedColor.AMBER);
        greenLight = new Light    (x, y+100, NamedColor.GREEN);
    }


    /***************************************************************************
     * Creates a traffic light with default size and given color
     * which will be placed at given coordinates.
     *
     * @param x         Horizontal coordinate
     * @param y         Vertical coordinate
     * @param boxColor  Color of the traffic light box
     */
    public TrafficLight(int x, int y, NamedColor boxColor)
    {
        box        = new Rectangle(x, y+  0,  50, 150, boxColor);
        redLight   = new Light    (x, y+  0, NamedColor.RED);
        amberLight = new Light    (x, y+ 50, NamedColor.AMBER);
        greenLight = new Light    (x, y+100, NamedColor.GREEN);
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Subsequently executes all of the states which traffic light can be in.
     * The arguments values tell how many milliseconds will particular
     * state last.
     *
     * @param stop      The duration for red light only
     * @param getReady  The duration for red and orange light
     * @param go        The duration for green light only
     * @param attention The duration for orange light only
     * @param lightsOff The duration for all lights off
     */
    public void cycle(int stop, int getReady, int go, int attention, int lightsOff)
    {
        stop();             IO.pause(stop);
        getReady();         IO.pause(getReady);
        go();               IO.pause(go);
        attention();        IO.pause(attention);
        allLightsOff();     IO.pause(lightsOff);
    }


    /***************************************************************************
     * Subsequently executes all of the states which traffic light can be in
     * with staying 500 ms in each state.
     * This method is useful for testing.
     */
    public void cycle()
    {
        cycle(500, 500, 500, 500, 500);
    }


    /***************************************************************************
     * Paints the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
    @Override
    public void paint(Painter painter)
    {
        box        .paint(painter);
        redLight   .paint(painter);
        amberLight .paint(painter);
        greenLight .paint(painter);
    }


    /***************************************************************************
     * Turns the traffic light into the state, where
     * only the amber light is on.
     */
    public void attention()
    {
        redLight   .switchOff();
        amberLight .switchOn();
        greenLight .switchOff();
    }


    /***************************************************************************
     * Turns the traffic light into the state, where
     * the red light and the amber light are on and the green light is off.
     */
    public void getReady()
    {
        redLight   .switchOn();
        amberLight .switchOn();
        greenLight .switchOff();
    }


    /***************************************************************************
     * Turns the traffic light into the state, where
     * only the red light is on.
     */
    public void stop()
    {
        redLight   .switchOn();
        amberLight .switchOff();
        greenLight .switchOff();
    }


    /***************************************************************************
     * Turns the traffic light into the state, where
     * only the green light is on.
     */
    public void go()
    {
        redLight   .switchOff();
        amberLight .switchOff();
        greenLight .switchOn();
    }


    /***************************************************************************
     * Turns the traffic light into the state, where
     * all the lights are off.
     */
    public void allLightsOff()
    {
        redLight   .switchOff();
        amberLight .switchOff();
        greenLight .switchOff();
    }


    /***************************************************************************
     * Turns the traffic light into the state, where
     * all the lights are on.
     */
    public void allLightsOn()
    {
        redLight   .switchOn();
        amberLight .switchOn();
        greenLight .switchOn();
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
