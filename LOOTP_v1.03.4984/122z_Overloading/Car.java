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
        chassis = new Rectangle(x, y, length, length/2, chassisColor);
        cab     = new Rectangle(x+length/8, y+length/8, length/2, length/4,
                                                        NamedColor.GRAY);
        lightL  = new Light(x+7*length/8, y,            length/8);
        lightR  = new Light(x+7*length/8, y+3*length/8, length/8);
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
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
