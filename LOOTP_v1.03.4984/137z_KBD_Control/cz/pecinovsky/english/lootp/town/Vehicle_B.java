/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;
import cz.pecinovsky.english.lootp.manager.Painter;

import cz.pecinovsky.english.lootp.util.Direction8;
import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.Position;



/*******************************************************************************
 * Instances of the {@code Vehicle_B} class represent movable objects
 * that can be controlled from a keyboard
 * and that can be registered at a race.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Vehicle_B implements IRacer
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Manager of the canvas on which the instance will be painted. */
    private static final CanvasManager CM = CanvasManager.getInstance();



    //== VARIABLE CLASS FIELDS =================================================

    /** The movement speed, i.e. how much the object moves after one command. */
    private static int speed = CM.getStep();



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** The decorated object that will be controlled from a keyboard. */
    private final IDirectable decorated;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** The rase, the ricer registered at. */
    private Race race;

    /** Racer name that facilitate its later identification. */
    private String name;


    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Wraps the given directable object and adds an ability
     * to be controlled from a keyboard and registered at a race.
     *
     * @param wrapped Decorated object
     */
    public Vehicle_B(IDirectable wrapped)
    {
        this.decorated = wrapped;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Return the instance name -
     * implicitly the class-name followed by the instance ID.
     *
     * @return  String with the instance name
     */
    @Override
     public String getName()
     {
        return name;
     }


    /***************************************************************************
     * Set the new instance name.
     *
     * @param name  The set instance name
     */
    @Override
    public void setName(String name)
    {
        this.name = name;
    }


    /***************************************************************************
     * Returns instance of the class {@code Position} with current position.
     * The position of a shape is defined as the position
     * of the upper left corner of its circumscribe rectangle.
     *
     * @return Instance of the class {@code Position} with current position
     */
    @Override
    public Position getPosition()
    {
        return decorated.getPosition();
    }


    /***************************************************************************
     * Set a new position of the instance.
     * The position of a shape is defined as the position
     * of the upper left corner of its circumscribe rectangle.
     *
     * @param position   The set position
     */
    @Override
    public void setPosition(Position position)
    {
        decorated.setPosition(position);
    }


    /***************************************************************************
     * Set a new coordinates of the instance.
     * The position of a shape is defined as the position
     * of the upper left corner of its circumscribe rectangle.
     *
     * @param x  The newly set horizontal coordinate,
     *           left canvas border has x=0, coordinate increases to the right
     * @param y  The newly set vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     */
    @Override
    public void setPosition(int x, int y)
    {
        decorated.setPosition(x, y);
    }


    /***************************************************************************
     * Returns the module &ndash; the basic size from which we derive
     * all the gauges of the object.
     *
     * @return The object's module
     */
    @Override
    public int getModule()
    {
        return decorated.getModule();
    }


    /***************************************************************************
     * Returns the module &ndash; the basic size from which we derive
     * all the gauges of the object.
     *
     * @param module  The set module
     */
    @Override
    public void setModule(int module)
    {
        //Upravíme speed, aby byl zachován její poměr vůči modulu
        speed = speed * module / decorated.getModule();
        if (speed == 0) {
            speed = 1;
        }
        decorated.setModule(module);
    }


    /***************************************************************************
     * Return the direction to which the instance is turned.
     *
     * @return Direction to which the instance is turned
     */
    @Override
    public Direction8 getDirection()
    {
        return decorated.getDirection();
    }


    /***************************************************************************
     * Turn the instance to the given direction.
     *
     * @param direction The direction, instance should be turned to
     */
    @Override
    public void setDirection(Direction8 direction)
    {
        decorated.setDirection(direction);
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Method register the racer at a given race.
     * To this race then will be reported the reached positions.
     *
     * @param race Race, where the racer will be registered
     */
    @Override
    public void registerFor(Race race)
    {
        this.race = race;
        race.register(this);
    }


    /***************************************************************************
     * Reacts to the right arrow key or its equivalent.
     */
    @Override
    public void right()
    {
        Direction8 direction = decorated.getDirection();
        decorated.setDirection(direction.rightTurn());
    }


    /***************************************************************************
     * Reacts to the left arrow key or its equivalent.
     */
    @Override
    public void left()
    {
        Direction8 direction = decorated.getDirection();
        decorated.setDirection(direction.leftTurn());
    }


    /***************************************************************************
     * Reacts to the up arrow key or its equivalent.
     */
    @Override
    public void up()
    {
        popojeď(speed);
    }


    /***************************************************************************
     * Reacts to the down arrow key or its equivalent.
     */
    @Override
    public void down()
    {
        popojeď(-speed);
    }


    /***************************************************************************
     * Reacts to the Enter key or its equivalent.
     */
    @Override
    public void enter()
    {
    }


    /***************************************************************************
     * Reacts to the space bar key or its equivalent.
     */
    @Override
    public void space()
    {
    }


    /***************************************************************************
     * Reacts to the Escape key or its equivalent.,
     * i.e. to the ending of the control from the keyboard.
     */
    @Override
    public void escape()
    {
    }


    /***************************************************************************
     * Paints the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
    @Override
    public void paint(Painter painter)
    {
        decorated.paint(painter);
    }


    /***************************************************************************
     * Returns a string representation of the object &ndash; its text signature.
     *
     * @return A string representation of the object
     */
    @Override
    public String toString()
    {
        return "Vehicle_B_(" + decorated.toString() + ")";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * Move the vehicle in its direction by a given distance;
     * if the distance is negative, move it in the opposite direction.
     * It checks, if the vehicle does not leave the canvas.
     * In such case it does not move with it.
     *
     * @param distance Distance the vehicle should move by
     */
    private void popojeď(int distance)
    {
        Position position = decorated.getPosition();
        Direction8 direction = decorated.getDirection();
        position = direction.nextPosition(position, distance);
        if ((position.x < 0)  ||  (position.x >= CM.getWidth ())  ||
            (position.y < 0)  ||  (position.y >= CM.getHeight()))
        {
            return;         //==========>
        }
        decorated.setPosition(position);
        race.checkpoint(this);
    }



    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================

    /***************************************************************************
     * Tests, that the instance can react to commands entered from a keyboard.
     */
    public static void test()
    {
        Arrow arrow  = new Arrow();
        Vehicle_B vb = new Vehicle_B(arrow);

        //The racing ring can be selected by uncommenting appropriate line(s)
        Ring ring    = Ring.newLShapeRing(new Position(0,0), NamedColor.BROWN);
        //Ring ring    = Ring.newSquareRing(new Position(50,50));
        CanvasManager.getInstance().add(ring);

        Race race    = new Race(ring);
        vb.setName("First");
        vb.registerFor(race);
    }
    ///** @param args Command line arguments - not used. */
    //public static void main(String[] args)  {  test();  }
}
