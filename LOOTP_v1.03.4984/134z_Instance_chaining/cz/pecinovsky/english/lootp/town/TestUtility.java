/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;
import cz.pecinovsky.english.lootp.manager.IModular;
import cz.pecinovsky.english.lootp.manager.IMovable;
import cz.pecinovsky.english.lootp.manager.Mover;

import cz.pecinovsky.english.lootp.util.IO;
import cz.pecinovsky.english.lootp.util.Position;


import static org.junit.Assert.*;



/*******************************************************************************
 * Library class {@code TestUtility} contains a set of auxiliary methods
 * used by test classes of objects implementing the {@link IModular} interface.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class TestUtility
{
    //== CONSTANT CLASS FIELDS =================================================

    private static final CanvasManager CM = CanvasManager.getInstance();



    //== VARIABLE CLASS FIELDS =================================================

    /** Position, where the tested object will move
     *  in the {@link #positionSize(IModular)} method. */
    private static Position position;

    /** Size of the smaller of the two modules,
     *  which are going to be set up to object
     *  that is tested in method {@link #positionSize(IModular)}. */
    private static int smallModule;

    /** Size of the bigger of the two modules,
     *  which are going to be set up to object
     *  that is tested in method {@link #positionSize(IModular)}. */
    private static int bigModule;



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================

    /***************************************************************************
     * Tests the changes of position and sizes of entered object;
     * parameters of test has to be set by method in advance
     *
     * @param position  Position where the tested object will move
     * @param small     Small sized module
     * @param big       Big sized module
     */
    public static void setPositionsModules(Position position,
                                           int small, int big)
    {
        TestUtility.position    = position;
        TestUtility.smallModule = small;
        TestUtility.bigModule   = big;
    }



    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    /***************************************************************************
     * Tests the changes of position and sizes of entered object;
     * parameters of the test has to be set by the method in advance.
     *
     * @param object Tested object
     */
    public static void positionSize(IModular object)
    {
        positionSize(object, position, smallModule, bigModule);
    }


    /***************************************************************************
     * Tries the changes of position and size of entered object with entered
     * parameters.
     *
     * @param object    Tested object
     * @param position  Position where the tested object will move
     * @param small     Small sized module
     * @param big       Big sized module
     */
    public static void positionSize(IModular object,
                                    Position position, int small, int big)
    {
        final int ms = 500;
        object.setPosition(position.x, position.y);     IO.pause(ms);
        object.setModule(big);                          IO.pause(ms);
        object.setModule(small);                        IO.pause(ms);
        CM.remove(object);                              IO.pause(ms);
    }


    /***************************************************************************
     * Will exchange positions of the entered objects and will check
     * if the objects really exchanged their positions.
     *
     * @param o1 1st object
     * @param o2 2nd object
     */
    public static void swapPositionsWithCheck(IMovable o1, IMovable o2)
    {
        Mover mover = new Mover(10);
        Position p1 = o1.getPosition();
        Position p2 = o2.getPosition();

        System.out.println("Initial: " + p1 + " <--> " + p2);

        mover.moveTo(p2, o1);
        mover.moveTo(p1, o2);

        System.out.println("Target:  " + o1.getPosition() +
                              " <--> " + o2.getPosition() + "\n");

        assertEquals(p1, o2.getPosition());
        assertEquals(p2, o1.getPosition());
    }



    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /** Private constructor blocks the creation of instances. */
    private TestUtility(String name) {}

    //== PREPARATION AND CLEANING THE FIXTURE ==================================
    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== THE TESTS =============================================================
}
