/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;
import cz.pecinovsky.english.lootp.manager.Ellipse;
import cz.pecinovsky.english.lootp.manager.IMovable;
import cz.pecinovsky.english.lootp.manager.IPaintable;
import cz.pecinovsky.english.lootp.manager.Line;
import cz.pecinovsky.english.lootp.manager.Mover;
import cz.pecinovsky.english.lootp.manager.Multishape;
import cz.pecinovsky.english.lootp.manager.Multimover;
import cz.pecinovsky.english.lootp.manager.Painter;
import cz.pecinovsky.english.lootp.manager.Rectangle;
import cz.pecinovsky.english.lootp.manager.Text;
import cz.pecinovsky.english.lootp.manager.Triangle;

import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.IO;
import cz.pecinovsky.english.lootp.util.Position;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * The class {@code RingTest} serves
 * for a complex test of the class {@link Ring}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class RingTest
{
    private CanvasManager CM;
    private Ring ringSquare;
    private Ring ringLShape;



    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================
    //-- The default parameterless constructor is enough -----------------------
    //== PREPARATION AND CLEANING THE FIXTURE ==================================

    /***************************************************************************
     * Creates a test fixture, i.e. a set of objects that will be prepared
     * before each run test.
     */
    @Before
    public void setUp()
    {
        CM         = CanvasManager.getInstance();
        ringSquare = Ring.newSquareRing(new Position(0,0));
        ringLShape = Ring.newLShapeRing(new Position(100, 100),
                                        NamedColor.BROWN);
        CM.add(ringSquare, ringLShape);
        IO.inform("Rings prepared");
    }


    /***************************************************************************
     * Clean-up after - this method is called after each test.
     */
    @After
    public void tearDown()
    {
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * Wraps the given movable object into a circular one,
     * places the resulting circular object at the given field,
     * runs its move and returns a reference to the field after the next.
     *
     * @param field   Road-field, where the wrapped object should be placed
     * @param movable Wrapped movable object
     * @return The descendant of the descendant of the field
     */
    private RoadField auxPutOnRing(RoadField field, IMovable movable)
    {
       Circular circular = new Circular(movable);
       circular.continueFrom(field);
       return field.getNext().getNext();
    }


    /***************************************************************************
     * Runs around the given ring with a light;
     * version with repeated call.
     *
     * @param ring Ring where the light should run
     */
    private void auxRunRound(Ring ring)
    {
        RoadField startField = ring.getStartField();
        Position  position   = startField.getPosition();
        Light     light      = new Light(position.x, position.y);
        Mover     mover      = new Mover(10);

        CM.add(light);
        startField = auxMove(startField, mover, light);

        //...  The previous statement can be repeated as needed

        startField = auxMove(startField, mover, light);
        startField = auxMove(startField, mover, light);
        startField = auxMove(startField, mover, light);
        startField = auxMove(startField, mover, light);
        startField = auxMove(startField, mover, light);
        startField = auxMove(startField, mover, light);
        startField = auxMove(startField, mover, light);
        startField = auxMove(startField, mover, light);
        startField = auxMove(startField, mover, light);
        startField = auxMove(startField, mover, light);
        startField = auxMove(startField, mover, light);
    }


    /***************************************************************************
     * Runs around the given ring with a light;
     * version with recursive call.
     *
     * @param okruh Ring where the light should run
     */
    private void auxRunRoundRecursive(Ring okruh)
    {
        RoadField start    = okruh.getStartField();
        Position  position = start.getPosition();
        Light     light    = new Light(position.x, position.y);
        Mover     mover    = new Mover(10);

        CM.add(light);

        //Next statement forth the infinitive recursive calling
        //auxMoveRecursive(start, mover, light);

        //Version stopping the object after reaching the starting ring field
        auxMoveRecursive(start, mover, light, start);
    }


    /***************************************************************************
     * Moves the given movable object with the given mover
     * from the given field to its successor
     * and returns a reference to this successor.
     *
     * @param field   Starting field
     * @param mover   Mover drawing the moved object
     * @param movable Moved object
     * @return Successor of the current field = object's destination
     */
    private RoadField auxMove(RoadField field, Mover mover, IMovable movable)
    {
        RoadField nextField = field.getNext();
        Position  position  = nextField.getPosition();
        mover.moveTo(position, movable);
        return nextField;
    }


    /***************************************************************************
     * Moves the given movable object with the given mover
     * from the given start field through the sequence of the linked field.
     * The method calls itself after each movement.
     * Thus it accomplishes the infinite loop
     * leading to the return stack overflow.
     *
     * @param field         Starting field
     * @param mover         Mover for the smooth movement
     * @param movedObject   Moved object
     */
    private void auxMoveRecursive(RoadField field, Mover mover,
                                  IMovable movedObject)
    {
        RoadField nextField = field.getNext();
        Position  position  = nextField.getPosition();
        mover.moveTo(position, movedObject);
        auxMoveRecursive(nextField, mover, movedObject);
    }


    /***************************************************************************
     * Moves the given movable object with the given mover
     * from the given start field through the sequence of the linked field
     * to the given end field.
     * When the object reaches the end field,
     * it announces ran around the whole ring
     * and ends the whole application.
     *
     * @param field         Starting field
     * @param mover         Mover for the smooth movement
     * @param movedObject   Moved object
     * @param endField      Field, where the whole run ends
     */
    private void auxMoveRecursive(RoadField field, Mover mover,
                                  IMovable movedObject, RoadField endField)
    {
        RoadField nextField  = field.getNext();
        Position  position   = nextField.getPosition();
        mover.moveTo(position, movedObject);
        IO.endIf(nextField.equals(endField), "Ring ran around");
        auxMoveRecursive(nextField, mover, movedObject, endField);
    }



    //== MEMBER DATA TYPES =====================================================
    //== THE TESTS =============================================================
    //
    //     /********************************************************************
    //      *
    //      */
    //     @Test
    //     public void testXxx()
    //     {
    //     }
    //

    /***************************************************************************
     * Tests how the light runs around the L-shape ring.
     */
    @Test
    public void testLShapeRing()
    {
       auxRunRound(ringLShape);
    }


    /***************************************************************************
     * Tests how the light runs around the square-shape ring.
     */
    @Test
    public void testSquareRing()
    {
       auxRunRound(ringSquare);
    }


    /***************************************************************************
     *
     */
    @Test
   public void testLShapeRingRecursive()
    {
       auxRunRoundRecursive(ringLShape);
    }


    /***************************************************************************
     *
     */
    @Test
    public void testSquareRingRecursive()
    {
       auxRunRoundRecursive(ringSquare);
    }


    /***************************************************************************
     *
     */
    @Test
    public void testLShapeRingWithDecorator()
    {
       Circular circular = new Circular(new Light());
       circular.goRound(ringLShape);
    }


    /***************************************************************************
     * Puts instances of all till now defined movable types on both rings.
     * The put instances will be wrapped into circular objects and will be put
     * in the way that among the running objects will be one empty field.
     * Besides the equidistant instances running with the same speed
     * also one instance with the half speed and one with the double speed
     * will be put.
     */
    @Test
    public void testMovingGroup()
    {
        int step = CM.getStep();
        TrafficLight trafficLight = new TrafficLight(0, 0, step);
        trafficLight.allLightsOn();

        RoadField field = ringSquare.getStartField();

        field = auxPutOnRing(field, new Light());
        field = auxPutOnRing(field, new Triangle(0,0,50,50));

        field  = ringLShape.getStartField();

        field = auxPutOnRing(field, new Car         (0, 0, step));
        field = auxPutOnRing(field, new Ellipse     (0, 0, step, step));
        field = auxPutOnRing(field, trafficLight);
        field = auxPutOnRing(field, new Rectangle   (0, 0, step, step,
                                                           NamedColor.GOLD));
        field = auxPutOnRing(field, new Arrow       (0, 0, step));
        field = auxPutOnRing(field, new Line        (0, 0, step, step,
                                                           NamedColor.WHITE));

        //One slow multishape
        Multishape m = new Multishape("Triple-shape", new Rectangle(),
                                       new Ellipse(), new Triangle());
        m.setSize(50);
        Circular o = new Circular(m);
        o.setSpeed(50);
        o.goRound(ringLShape);

        //One quick text
        o = new Circular(new Text(0, 0, NamedColor.YELLOW, "FLYER"));
        o.setSpeed(200);
        o.goRound(ringLShape);

        IO.inform("When you check it, press OK");
        Multimover.getInstance().stopAll();
    }


    /***************************************************************************
     * Puts an arrow on the small ring and the car on the bigger one.
     * It demonstrated, how the object goes (with decorator's help)
     * around the ring and their shape respects the direction of movement.
     */
    @Test
    public void testDirectableCircular()
    {
        new DirectableCircular(new Arrow()).goRound(ringSquare);
        new DirectableCircular(new TrafficLight()).continueFrom(
                ringSquare.getStartField().getNext().getNext());

        new DirectableCircular(new Arrow()).goRound(ringLShape);
        new DirectableCircular(new Car()).continueFrom(
                ringLShape.getStartField().getNext().getNext());
        new DirectableCircular(new TrafficLight()).continueFrom(
                ringLShape.getStartField().getNext().getNext().getNext().getNext());
    }

}
