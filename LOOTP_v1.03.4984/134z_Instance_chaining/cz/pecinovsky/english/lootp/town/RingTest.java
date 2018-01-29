/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;
import cz.pecinovsky.english.lootp.manager.IMovable;
import cz.pecinovsky.english.lootp.manager.Mover;

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

}
