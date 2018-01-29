/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;
 import cz.pecinovsky.english.lootp.manager.IModular;
import cz.pecinovsky.english.lootp.manager.IMovable;
import cz.pecinovsky.english.lootp.manager.Painter;
import cz.pecinovsky.english.lootp.manager.Rectangle;

import cz.pecinovsky.english.lootp.util.Area;
import cz.pecinovsky.english.lootp.util.Direction8;
import cz.pecinovsky.english.lootp.util.IO;
import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.Position;


import static cz.pecinovsky.english.lootp.town.TrafficLightState.*;



/*******************************************************************************
 * Instance of class {@code TrafficLight} represent traffic lights
 * similar to those which operate the traffic on crossroads.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class TrafficLight implements IDirectable
     {
    //== CONSTANT CLASS FIELDS =================================================

    private static final int DEFAULT_X = 0;

    private static final int DEFAULT_Y = 0;

    private static final int DEFAULT_MODUL = 50;

    private static final NamedColor DEFAULT_BOX_COLOR = NamedColor.BLACK;

    private static final Direction8 DEFAULT_DIRECTION = Direction8.EAST;

    /** Canvas on which the instance will be painted. */
    private static final CanvasManager CM = CanvasManager.getInstance();



    //== VARIABLE CLASS FIELDS =================================================

     /** Number of so far created instances. */
     private static int countCreated = 0;



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** ID of the instance. */
    private final int ID;

    /** Box with lights */
    private final Rectangle box;

    /** Upper (red) light */
    private final Light redLight;

    /** Middle (amber) light */
    private final Light amberLight;

    /** Bottom (green) light */
    private final Light greenLight;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** Instance name consisting by default from the class name
     *  and the instance ID. */
    private String name;

    /** Pixel horizontal coordinate of the instance. */
    private int xPos;

    /** Pixel vertical coordinate of the instance. */
    private int yPos;

    /** Pixel size of the square, in which the traffic light is placed.
     *  The light diameter as well as the box width are 1/4 of the module. */
    private int module;

    /** Direction of the traffic light,
     *  i.e. direction of vehicles controlled by this traffic light. */
    private Direction8 direction;

    /** Current state of the traffic light. */
    private TrafficLightState state;



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
        this(DEFAULT_X, DEFAULT_Y);
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
        this(x, y, DEFAULT_BOX_COLOR);
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
        this(x, y, DEFAULT_MODUL, boxColor);
    }


    /***************************************************************************
     * Creates a traffic light with the given size and the default color,
     * which will be placed at given coordinates.
     *
     * @param x      Horizontal coordinate
     * @param y      Vertical coordinate
     * @param module Pixel size of the square, in which the traffic light
     *               is placed. The light diameter as well as the box width
     *               are 1/4 of the module
     */
    public TrafficLight(int x, int y, int module)
    {
        this(x, y, module, DEFAULT_BOX_COLOR);
    }


    /***************************************************************************
     * Creates a traffic light with the given size,  default color
     * and given direction,
     * which will be placed at the given coordinates.
     *
     * @param x          Horizontal coordinate
     * @param y          Vertical coordinate
     * @param module     Pixel size of the square, in which the traffic light
     *                   is placed. The light diameter as well as the box width
     *                   are 1/4 of the module
     * @param direction  Direction of the traffic light, i.e. direction of
     *                   vehicles controlled by this traffic light
     */
    public TrafficLight(int x, int y, int module, Direction8 direction)
    {
        this(x, y, module, DEFAULT_BOX_COLOR, direction);
    }


    /***************************************************************************
     * Creates a traffic light with the given size and color,
     * which will be placed at the given coordinates.
     *
     * @param x          Horizontal coordinate
     * @param y          Vertical coordinate
     * @param module     Pixel size of the square, in which the traffic light
     *                   is placed. The light diameter as well as the box width
     *                   are 1/4 of the module
     * @param boxColor   Color of the traffic light box
     */
    public TrafficLight(int x, int y, int module, NamedColor boxColor)
    {
        this(x, y, module, DEFAULT_BOX_COLOR, DEFAULT_DIRECTION);
    }


    /***************************************************************************
     * Creates a traffic light with the given size, color and direction,
     * which will be placed at the given coordinates.
     *
     * @param x          Horizontal coordinate
     * @param y          Vertical coordinate
     * @param module     Pixel size of the square, in which the traffic light
     *                   is placed. The light diameter as well as the box width
     *                   are 1/4 of the module
     * @param boxColor   Color of the traffic light box
     * @param direction  Direction of the traffic light, i.e. direction of
     *                   vehicles controlled by this traffic light
     */
    public TrafficLight(int x, int y, int module, NamedColor boxColor, Direction8 direction)
    {
        countCreated = countCreated + 1;
        this.ID = countCreated;

        this.xPos  = x;
        this.yPos  = y;
        this.module = module;
        this.direction  = direction;

        int m1 = module;
        int m2 = module / 2;
        int m4 = module / 4;
        int m34= 3 * module / 4;

        Area ref = new Area(x, y, module, module);
        Area part;

        //box
        part = new Area(m4, 0, m34, m4);
        part = direction.turnInArea(ref, part);
        this.box = new Rectangle(part, boxColor);

        //redLight
        part = new Area(m34, 0, m4, m4);
        part = direction.turnInArea(ref, part);
        this.redLight = new Light(part.x, part.y, part.height,
                                  NamedColor.RED, NamedColor.NO);

        //amberLight
        part = new Area(m2, 0, m4, m4);
        part = direction.turnInArea(ref, part);
        this.amberLight = new Light(part.x, part.y, part.height,
                                NamedColor.YELLOW, NamedColor.NO);

        //greenLight
        part = new Area(m4, 0, m4, m4);
        part = direction.turnInArea(ref, part);
        this.greenLight = new Light(part.x, part.y, part.height,
                                 NamedColor.GREEN, NamedColor.NO);

        //We start with the trafficLight off
        allLightsOff();
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns the horizontal coordinate of the instance.
     *
     * @return  The horizontal coordinate.
     */
    public int getX()
    {
        return xPos;
    }


    /***************************************************************************
     * Returns the vertical coordinate of the instance.
     *
     * @return  The vertical coordinate.
     */
    public int getY()
    {
        return yPos;
    }


    /***************************************************************************
     * Returns a crate with the current position.
     *
     * @return Current position
     */
    @Override
    public Position getPosition()
    {
        return new Position(getX(), getY());
    }


    /***************************************************************************
     * Sets the new instance position.
     *
     * @param p The set position
     */
    @Override
    public void setPosition(Position p)
    {
        this.setPosition(p.x, p.y);
    }


    /***************************************************************************
     * Sets the new instance position.
     *
     * @param x  New x coordinate of instance
     * @param y  New y coordinate of instance
     */
    @Override
    public void setPosition(int x, int y)
    {
        int dx = x - getX();
        int dy = y - getY();
        CM.stopPainting(); {
            box.moveRight(dx);
            box.moveDown (dy);
            redLight  .setPosition(redLight.getX()+dx, redLight.getY()+dy);
            amberLight.setPosition(amberLight  .getX()+dx, amberLight  .getY()+dy);
            greenLight.setPosition(greenLight .getX()+dx, greenLight .getY()+dy);
        } CM.returnPainting();
        xPos = x;
        yPos = y;
    }


    /***************************************************************************
     * Returns the module &ndash; the basic size from which we derive
     * all the gauges of the object; in the case of the traffic light
     * it is the width of the box and the radius of the lights.
     *
     * @return The module (width of the box and radius of the lights)
     */
    @Override
    public int getModule()
    {
        return module;
    }


    /***************************************************************************
     * Sets the module &ndash; the basic size from which we derive
     * all the gauges of the object &ndash; in the case of the traffic light
     * it is the width of the box and the radius of the lights.
     *
     * @param module  The set module (width of the box and radius of the lights)
     */
    @Override
    public void setModule(int module)
    {
        if (module <= 0) {
            throw new IllegalArgumentException(
                    "\nModule may not be negative number. Entered: " + module);
        }
        int m1 = module;
        int m2 = module / 2;
        int m4 = module / 4;
        int m34= 3 * module / 4;

        Area ref = new Area(xPos, yPos, module, module);
        Area part;

        CM.stopPainting(); {
            //box
            part = new Area(m4, 0, m34, m4);
            part = direction.turnInArea(ref, part);
            this.box.setArea(part);

            //redLight
            part = new Area(m34, 0, m4, m4);
            part = direction.turnInArea(ref, part);
            this.redLight.setPosition(part.x, part.y);
            this.redLight.setModule(part.height);

            //amberLight
            part = new Area(m2, 0, m4, m4);
            part = direction.turnInArea(ref, part);
            this.amberLight.setPosition(part.x, part.y);
            this.amberLight.setModule(part.height);

            //greenLight
            part = new Area(m4, 0, m4, m4);
            part = direction.turnInArea(ref, part);
            this.greenLight.setPosition(part.x, part.y);
            this.greenLight.setModule(part.height);
        } CM.returnPainting();
        this.module = module;
    }


    /***************************************************************************
     * Returns the direction of the traffic light,
     * i.e. direction of vehicles controlled by this traffic light.
     *
     * @return Direction of the traffic light
     */
    @Override
    public Direction8 getDirection()
    {
        return direction;
    }


    /***************************************************************************
     * Turn the traffic light to the given direction.
     *
     * @param direction  Direction, to which the traffic light should be turned
     */
    @Override
    public void setDirection(Direction8 direction)
    {
        if (! direction.isMain()) {
            throw new IllegalArgumentException(
                "\nNo main directions enterred: " + direction);
        }
        this.direction = direction;
        this.setModule(module);
    }


    /***************************************************************************
     * Returns the traffic light state. This state determines
     * which lights are currently on.
     *
     * @return Current traffic light state
     */
    public TrafficLightState getState()
    {
        return state;
    }


    /***************************************************************************
     * Set the given state, ie. make the corresponding lights on a off.
     *
     * @param state The set state
     */
    public void setState(TrafficLightState state)
    {
        //Nemusím nastavovat state - ten nastaví spuštěná metoda
        switch (state)
        {
            case LIGHTS_OFF: allLightsOff();    return;
            case ATTENTION:  attention();       return;
            case STOP:       stop();            return;
            case GET_READY:  getReady();        return;
            case GO:         go();              return;
            case LIGHTS_ON:  allLightsOn();     return;

            default:
                throw new IllegalArgumentException(
                    "\nEntered a not known trafficLight state: " + state);
        }
    }



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
        state = ATTENTION;
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
        state = GET_READY;
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
        state = STOP;
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
        state = GO;
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
        state = LIGHTS_OFF;
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
        state = LIGHTS_ON;
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
        return "STrafficLight_" + ID + "(" + getPosition() +
               ", module=" + getModule() +
               ", box="    + box.getColor() + ")";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
