/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testing class {@code ArrowTest} serves as a complex way to test
 * the class {@code Arrow}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class ArrowTest
{
    private CanvasManager CM;

    private Arrow arrow0;
    private Arrow arrowXY;
    private Arrow arrowXYB;
    private Arrow arrowXYM;
    private Arrow arrowXYMB;



    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================
    //== PREPARATION AND CLEANING THE FIXTURE ==================================

    /***************************************************************************
     * Prepares the tested instances and performs the actions,
     * which should be performed before each test.
     */
    @Before
    public void setUp()
    {
        arrow0     = new Arrow();
        arrowXY    = new Arrow(50,  50);
        arrowXYB   = new Arrow(100, 100, NamedColor.BLUE);
        arrowXYM   = new Arrow(  0, 100, 100);
        arrowXYMB  = new Arrow(100,   0, 100, NamedColor.BLUE);

        CM = CanvasManager.getInstance();
        CM.add(arrow0);
        CM.add(arrowXY);
        CM.add(arrowXYB);
        CM.add(arrowXYM);
        CM.add(arrowXYMB);

        IO.inform("Arrows prepared");
    }


    /***************************************************************************
     * Cleans up after the ran test and performs the actions,
     * which should be performed after each test.
     */
    @After
    public void tearDown()
    {
    }


    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * With the help of mover smoothly exchanges positions of arrows.
     *
     * @param a1 1st arrow
     * @param a2 2nd arrow
     */
    private void auxSmoothlySwapPositions(Arrow a1, Arrow a2)
    {
        Mover mover = new Mover(10);
        Position p1 = a1.getPosition();
        a1.translucent();
        a2.translucent();
        mover.moveTo(a2.getPosition(), a1);
        mover.moveTo(p1,               a2);
        a1.restoreColor();
        a2.restoreColor();
    }


    /***************************************************************************
     * Tests the changes of position and size of entered arrow.
     *
     * @param a Tested arrow
     */
    private void auxPositionSize(Arrow a)
    {
        final int ms = 500;
        a.setPosition(150, 150);      IO.pause(ms);
        a.setModule(150);             IO.pause(ms);
        a.setModule(25);              IO.pause(ms);
        CM.remove(a);                 IO.pause(ms);
    }



    //== MEMBER DATA TYPES =====================================================
    //== THE TESTS =============================================================
    //
    //     /********************************************************************
    //      *
    //      */
    //     @Test
    //     public void testXXX()
    //     {
    //     }
    //

    @Test
    public void testTranslucent()
    {
        Rectangle ground = new Rectangle(25, 25, 100, 100, NamedColor.WHITE);
        CM.addBehind(arrow0, ground);

        arrow0   .translucent();
        arrowXY  .translucent();
        arrowXYB .translucent();
        arrowXYM .translucent();
        arrowXYMB.translucent();

        IO.inform("Verify translucency");

        arrow0   .restoreColor();
        arrowXY  .restoreColor();
        arrowXYB .restoreColor();
        arrowXYM .restoreColor();
        arrowXYMB.restoreColor();
     }


    @Test
    public void testPositionSize()
    {
        auxPositionSize(arrow0);
        auxPositionSize(arrowXY);
        auxPositionSize(arrowXYB);
        auxPositionSize(arrowXYM);
        auxPositionSize(arrowXYMB);
    }


    @Test
    public void testSmoothMovement()
    {
        arrow0   .translucent();
        arrowXY  .translucent();
        arrowXYB .translucent();
        arrowXYM .translucent();
        arrowXYMB.translucent();
        Mover p = new Mover(10);
        p.moveTo(250,   0, arrow0);
        p.moveTo(250,  50, arrowXY);
        p.moveTo(250, 100, arrowXYB);
        p.moveTo(200, 100, arrowXYM);
        p.moveTo(200,   0, arrowXYMB);
    }


    public void testSmoothlySwapPositions()
    {
        auxSmoothlySwapPositions(arrowXYMB, arrowXYM);
        auxSmoothlySwapPositions(arrowXYB,  arrow0);
    }

}