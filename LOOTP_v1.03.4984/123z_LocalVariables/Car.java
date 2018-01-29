/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */



/*******************************************************************************
 * Instance of class {@code Car} represent cars directed to the east.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Car implements IPaintable
{
    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Chassis of the car.*/
    private Rectangle chassis;

    /** Cab of the car. */
    private Rectangle cab;

    /** Left front light. */
    private Light lightL;

    /** Right front light. */
    private Light lightR;



    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a car with the default size
     * and with the default color of the chassis,
     * which will be placed into the canvas upper left corner.
     */
    public Car()
    {
         this(0, 0);
    }


    /***************************************************************************
     * Creates a car with the default size
     * and with the default color of the chassis,
     * which will be placed at the given coordinates.
     *
     * @param x  Horizontal coordinate
     * @param y  Vertical coordinate
     */
    public Car(int x, int y)
    {
        this(x, y, NamedColor.BLUE);
    }


    /***************************************************************************
     * Creates a car with the default size
     * with the given color of the chassis,
     * which will be placed at the given coordinates.
     *
     * @param x             Horizontal coordinate
     * @param y             Vertical coordinate
     * @param chassisColor  Color of chassis
     */
    public Car(int x, int y, NamedColor chassisColor)
    {
        this(x, y, 128, chassisColor);
    }


    /***************************************************************************
     * Creates a car with the given size,
     * the default color of the chassis,
     * which will be placed at the given coordinates.
     *
     * @param x      Horizontal coordinate
     * @param y      Vertical coordinate
     * @param length Length of the car
     */
    public Car(int x, int y, int length)
    {
        this(x, y, length, NamedColor.BLUE);
    }


    /***************************************************************************
     * Creates a car with the given size,
     * and with the given color of the chassis,
     * which will be placed at the given coordinates.
     *
     * @param x             Horizontal coordinate
     * @param y             Vertical coordinate
     * @param length        Length of the car
     * @param chassisColor  Color of chassis
     */
    public Car(int x, int y, int length, NamedColor chassisColor)
    {
        int d1 = length;
        int d2 = length/2;
        int d4 = length/4;
        int d8 = length/8;

        chassis = new Rectangle(x,    y,    d1, d2, chassisColor);
        cab     = new Rectangle(x+d8, y+d8, d2, d4, NamedColor.GRAY);

        lightL  = new Light(x+7*d8, y,      d8);
        lightR  = new Light(x+7*d8, y+3*d8, d8);
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Sets the given coordinates.
     *
     * @param x  Horizontal coordinate
     * @param y  Vertical coordinate
     */
    public void setPosition(int x, int y)
    {
        int d8 = chassis.getWidth() / 8;   //Osmina délky vozu

        chassis.setPosition(x,      y);
        cab    .setPosition(x+d8,   y+d8);
        lightL .setPosition(x+7*d8, y);
        lightR .setPosition(x+7*d8, y+3*d8);
    }


    /***************************************************************************
     * Sets the basic size from which we will derive all the gauges
     * of the object &ndash; in the case of the car it is
     * the car's length.
     *
     * @param module  The set module (the car's length)
     */
    public void setModule(int module)
    {
        int x  = chassis.getX();
        int y  = chassis.getY();
        int m1 = module;
        int m2 = m1/2;
        int m4 = m1/4;
        int m8 = m1/8;

        chassis.setSize(m1, m2);

        //Other parts of the car change their sizes as well as position.
        cab.setPosition(x+m8, y+m8);
        cab.setSize(m2, m4);

        lightL.setPosition(x+7*m8, y);
        lightR.setPosition(x+7*m8, y+3*m8);
        lightL.setModule(m8);
        lightR.setModule(m8);
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Blinks with the lights on the left side of the car.
     */
    public void blinkLeft()
    {
        lightL.blink();
    }


    /***************************************************************************
     * Blinks with the lights on the right side of the car.
     */
    public void blinkRight()
    {
        lightR.blink();
    }


    /***************************************************************************
     * Paints the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
    @Override
    public void paint(Painter painter)
    {
        chassis.paint(painter);
        cab    .paint(painter);
        lightL .paint(painter);
        lightR .paint(painter);
    }


    /***************************************************************************
     * Turns on all the car's lights.
     */
    public void lightOn()
    {
        lightL.switchOn();
        lightR.switchOn();
    }


    /***************************************************************************
     * Turns off all the car's lights.
     */
    public void lightOff()
    {
        lightL.switchOff();
        lightR.switchOff();
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
