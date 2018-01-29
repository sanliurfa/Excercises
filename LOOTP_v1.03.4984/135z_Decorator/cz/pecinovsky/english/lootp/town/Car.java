/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;
import cz.pecinovsky.english.lootp.manager.IModular;
import cz.pecinovsky.english.lootp.manager.Painter;
import cz.pecinovsky.english.lootp.manager.Rectangle;

import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.Position;



/*******************************************************************************
 * Instance of class {@code Car} represent cars directed to the east.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Car implements IModular
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Default horizontal coordinate. */
    private static final int DEFAULT_X = 0;

    /** Default vertical coordinate. */
    private static final int DEFAULT_Y = 0;

    /** Default module = size of the circumscribed square = car length. */
    private static final int DEFAULT_MODULE = 128;

    /** Default color of the chassis. */
    private static final NamedColor DEFAULT_CHASSIS_COLOR = NamedColor.BLUE;

    private static final NamedColor BARVA_KABINY = NamedColor.GRAY;



    //== VARIABLE CLASS FIELDS =================================================

     /** Number of so far created instances. */
     private static int countCreated = 0;



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Instance identification number. */
    private final int ID;

    /** Chassis of the car */
    private final Rectangle chassis;

    /** Cab of the car. */
    private final Rectangle cab;

    /** Left front light. */
    private final Light lightL;

    /** Right front light. */
    private final Light lightR;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** Instance name consisting from the class name and instance ID. */
    private String name;



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
        this(DEFAULT_X, DEFAULT_Y);
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
        this(x, y, DEFAULT_CHASSIS_COLOR);
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
        this(x, y, DEFAULT_MODULE, chassisColor);
    }


    /***************************************************************************
     * Creates a car with the given size,
     * the default color of the chassis,
     * which will be placed at the given coordinates.
     *
     * @param x      Horizontal coordinate
     * @param y      Vertical coordinate
     * @param module Length of the car
     */
    public Car(int x, int y, int module)
    {
        this(x, y, module, DEFAULT_CHASSIS_COLOR);
    }


    /***************************************************************************
     * Creates a car with the given size,
     * and with the given color of the chassis,
     * which will be placed at the given coordinates.
     *
     * @param x             Horizontal coordinate
     * @param y             Vertical coordinate
     * @param module        Length of the car
     * @param chassisColor  Color of chassis
     */
    public Car(int x, int y, int module, NamedColor chassisColor)
    {
        countCreated   = countCreated + 1;
        this.ID = countCreated;

        int d1  = module;
        int d2  = module/2;
        int d4  = module/4;
        int d8  = module/8;

        chassis = new Rectangle(x,    y,    d1, d2, chassisColor);
        cab     = new Rectangle(x+d8, y+d8, d2, d4, BARVA_KABINY);

        lightL  = new Light(x+7*d8, y,      d8);
        lightR  = new Light(x+7*d8, y+3*d8, d8);
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns the horizontal coordinate of the position of the instance.
     *
     * @return  The horizontal coordinate
     */
    public int getX()
    {
        return chassis.getX();
    }


    /***************************************************************************
     * Returns the vertical coordinate of the position of the instance.
     *
     * @return  The vertical coordinate
     */
    public int getY()
    {
        return chassis.getY();
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
     * @param x  Horizontal coordinate
     * @param y  Vertical coordinate
     */
    @Override
    public void setPosition(int x, int y)
    {
        int d8 = chassis.getWidth() / 8;   //One eight of car’s length

        chassis.setPosition(x,      y);
        cab  .setPosition(x+d8,   y+d8);
        lightL .setPosition(x+7*d8, y);
        lightR .setPosition(x+7*d8, y+3*d8);
    }


    /***************************************************************************
     * Returns the basic size from which we will derive all the gauges
     * of the object &ndash; in the case of the car it is
     * the car's length.
     *
     * @return The module (the car's length)
     */
    @Override
    public int getModule()
    {
        return chassis.getWidth();
    }


    /***************************************************************************
     * Sets the basic size from which we will derive all the gauges
     * of the object &ndash; in the case of the car it is
     * the car's length.
     *
     * @param module  The set module (the car's length)
     */
    @Override
    public void setModule(int module)
    {
        int x  = chassis.getX();
        int y  = chassis.getY();
        int m1 = module;
        int m2 = m1/2;
        int m4 = m1/4;
        int m8 = m1/8;

        chassis.setSize(m1, m2);

        //U ostatních částí vozu se se změnou rozměru vozu mění i jejich pozice
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


    /***************************************************************************
     * Returns a text representation (signature) of the instance
     * used especially for debug purpose.
     *
     * @return The asked text representation
     */
    @Override
    public String toString()
    {
        return "Car_" + ID + "(" + getPosition() + ", module=" + getModule() +
               ", color=" + chassis.getColor() + ")";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
