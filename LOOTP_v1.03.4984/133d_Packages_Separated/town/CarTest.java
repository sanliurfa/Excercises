/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package town;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testing class {@code CarTest} serves as a complex way to test
 * the class {@link CarTest}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class CarTest
{
    private CanvasManager CM;
    private Car car0;
    private Car carXY;
    private Car carXYB;
    private Car carXYM;
    private Car carXYMB;



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
        car0    = new Car();
        carXY   = new Car( 50, 100);
        carXYB  = new Car(150,  25,      NamedColor.BLACK);
        carXYM  = new Car(200, 100,  64);
        carXYMB = new Car( 0,  172, 256, NamedColor.RED);

        CM = CanvasManager.getInstance();
        CM.add(car0);
        CM.add(carXY);
        CM.add(carXYB);
        CM.add(carXYM);
        CM.add(carXYMB);

        System.out.println("\n====== Instances in the test fixture" +
                           "\n| CM: " + CM +
                           "\n| car0:    " + car0 +
                           "\n| carXY:   " + carXY +
                           "\n| carXYB:  " + carXYB +
                           "\n| carXYM : " + carXYM +
                           "\n| carXYMB: " + carXYMB +
                           "\n======");
        IO.inform("Cars prepared");
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
     * Tries the blinking of the car
     */
    private void auxBlink(Car car)
    {
        car.lightOff();     IO.pause(500);
        car.blinkLeft();    IO.pause(500);
        car.blinkRight();   IO.pause(500);
        car.lightOn();
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
     *
     */
    @Test
    public void testBlink()
    {
        auxBlink(car0);
        auxBlink(carXY);
        auxBlink(carXYB);
        auxBlink(carXYM);
        auxBlink(carXYMB);
    }


    @Test
    public void testSmoothMovement()
    {
        Mover p = new Mover(10);
        p.moveTo(150, 150, car0);
        p.moveTo(  0, 200, carXY);
        p.moveTo(  0,   0, carXYMB);
        p.moveTo(150, 236, carXYB);
        p.moveTo(  0, 150, carXYM);
    }


    @Test
    public void testPositionSize()
    {
        TestUtility.setPositionsModules(new Position(50, 200), 25, 200);
        TestUtility.positionSize(carXYMB);
        TestUtility.positionSize(carXYM);
        TestUtility.positionSize(carXYB);
        TestUtility.positionSize(carXY);
        TestUtility.positionSize(car0);
    }


    @Test
    public void testSwapPositionsWithCheck()
    {
        TestUtility.swapPositionsWithCheck(car0,   carXYB);
        TestUtility.swapPositionsWithCheck(carXYB, carXYM);
        TestUtility.swapPositionsWithCheck(carXYM, carXYMB);
    }
}
