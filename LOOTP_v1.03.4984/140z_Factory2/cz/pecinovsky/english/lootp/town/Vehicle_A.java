/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;
import cz.pecinovsky.english.lootp.manager.Controller;
import cz.pecinovsky.english.lootp.manager.IControllable;
import cz.pecinovsky.english.lootp.manager.Painter;

import cz.pecinovsky.english.lootp.util.Direction8;
import cz.pecinovsky.english.lootp.util.IO;
import cz.pecinovsky.english.lootp.util.Position;



/*******************************************************************************
 * Instances of the {@code Vehicle_A} class represent movable objects
 * that can be controlled from a keyboard.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Vehicle_A implements IControllable
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
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Wraps the given directable object and adds an ability
     * to be controlled from a keyboard to it.
     *
     * @param wrapped Decorated object
     */
    public Vehicle_A(IDirectable wrapped)
    {
        this.decorated = wrapped;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

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
        Position position = decorated.getPosition();
        Direction8  direction   = decorated.getDirection();
        position = direction.nextPosition(position, speed);
        decorated.setPosition(position);
    }


    /***************************************************************************
     * Reacts to the down arrow key or its equivalent.
     */
    @Override
    public void down()
    {
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
        return "Vehicle_A_(" + decorated.toString() + ")";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================

    /***************************************************************************
     * Tests, that the instance can react to commands entered from a keyboard.
     */
    public static void test()
    {
        Arrow      arrow      = new Arrow();
        Vehicle_A  va         = new Vehicle_A(arrow);
        Controller controller = new Controller(va);

        IO.inform("After you take a ride, press OK");
        System.exit(0);
    }
    ///** @param args Command line arguments - not used. */
    //public static void main(String[] args)  {  test();  }
}
