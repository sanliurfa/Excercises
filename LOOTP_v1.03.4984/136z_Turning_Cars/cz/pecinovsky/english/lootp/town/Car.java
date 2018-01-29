/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;
import cz.pecinovsky.english.lootp.manager.Painter;
import cz.pecinovsky.english.lootp.manager.Rectangle;

import cz.pecinovsky.english.lootp.util.Area;
import cz.pecinovsky.english.lootp.util.Direction8;
import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.Position;



/*******************************************************************************
 * Instance of class {@code Car} represent cars directed to the east.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Car implements IDirectable
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

    private static final Direction8 DEFAULT_DIRECTION = Direction8.EAST;

    /** Canvas on which the instance will be painted. */
    private static final CanvasManager CM = CanvasManager.getInstance();



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

    /** Pixel horizontal coordinate. */
    private int xPos;

    /** Pixel vertical coordinate. */
    private int yPos;

    /** Pixel size of the circumscribe square. */
    private int module;

    /** Car direction. */
    private Direction8 direction;



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
        this(x, y, module, chassisColor, Direction8.EAST);
    }


    /***************************************************************************
     * Creates a car with the given size,
     * and with the given color of the chassis,
     * which will be placed at the given coordinates
     * and turned into the given direction.
     *
     * @param x             Horizontal coordinate
     * @param y             Vertical coordinate
     * @param module        Length of the car
     * @param chassisColor  Color of chassis
     * @param direction     Direction, to which the car is turned
     */
    public Car(int x, int y, int module, NamedColor chassisColor, Direction8 direction)
    {
        Car.countCreated = countCreated + 1;
        this.ID    = countCreated;

        this.xPos  = x;
        this.yPos  = y;
        this.module = module;
        this.direction  = direction;

        int m1 =     module;
        int m2 =     module / 2;
        int m4 =     module / 4;
        int m8 =     module / 8;
        int m38= 3 * module / 8;
        int m58= 5 * module / 8;
        int m78= 7 * module / 8;

        Area ref = new Area(x, y, module, module);
        Area díl;

        //Chassis
        díl = new Area(0, m4, m1, m2);
        díl = direction.turnInArea(ref, díl);
        this.chassis = new Rectangle(díl, chassisColor);

        //Cab
        díl = new Area(m8, m38, m2, m4);
        díl = direction.turnInArea(ref, díl);
        this.cab = new Rectangle(díl, BARVA_KABINY);

        //lightL
        díl = new Area(m78, m4, m8, m8);
        díl = direction.turnInArea(ref, díl);
        this.lightL = new Light(díl.x, díl.y, díl.height);

        //lightR
        díl = new Area(m78, m58, m8, m8);
        díl = direction.turnInArea(ref, díl);
        this.lightR = new Light(díl.x, díl.y, díl.height);
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
        return xPos;
    }


    /***************************************************************************
     * Returns the vertical coordinate of the position of the instance.
     *
     * @return  The vertical coordinate
     */
    public int getY()
    {
        return yPos;
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
        int dx = x - getX();
        int dy = y - getY();
        CM.stopPainting(); {
            chassis.moveRight(dx);       chassis.moveDown  (dy);
            cab  .moveRight(dx);       cab  .moveDown  (dy);
            lightL .setPosition(lightL.getX()+dx, lightL.getY()+dy);
            lightR .setPosition(lightR.getX()+dx, lightR.getY()+dy);
        } CM.returnPainting();
        xPos = x;
        yPos = y;
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
        return module;
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
        int m38= 3 * m1 / 8;
        int m58= 5 * m1 / 8;
        int m78= 7 * m1 / 8;

        Area ref = new Area(xPos, yPos, module, module);
        Area díl;

        CM.stopPainting(); {
            //Podvozek
            díl = new Area(0, m4, m1, m2);
            díl = direction.turnInArea(ref, díl);
            this.chassis.setArea(díl);

            //Kabina
            díl = new Area(m8, m38, m2, m4);
            díl = direction.turnInArea(ref, díl);
            this.cab.setArea(díl);

            //lightL
            díl = new Area(m78, m4, m8, m8);
            díl = direction.turnInArea(ref, díl);
            this.lightL.setPosition(díl.x, díl.y);
            this.lightL.setModule(díl.height);

            //lightR
            díl = new Area(m78, m58, m8, m8);
            díl = direction.turnInArea(ref, díl);
            this.lightR.setPosition(díl.x, díl.y);
            this.lightR.setModule(díl.height);
        } CM.returnPainting();
        this.module = module;
    }


    /***************************************************************************
     * Return the direction into which the car is turned.
     *
     * @return Direction into which the car is turned
     */
    @Override
    public Direction8 getDirection()
    {
        return direction;
    }


    /***************************************************************************
     * Set the car direction.
     *
     * @param direction  Direction into which the car should be turned
     */
    @Override
    public void setDirection(Direction8 direction)
    {
        this.direction = direction;
        this.setModule(module);
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
