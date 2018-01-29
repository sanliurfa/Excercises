/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testing class {@code CarTest} serves as a complex way to test
 * the class {@link Car}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class CarTest
{
    private CanvasManager CM;
    private Car car0;
    private Car carXY;
    private Car carXYC;
    private Car carXYM;
    private Car carXYMC;

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
        car0    = new Car();
        carXY   = new Car( 50, 100);
        carXYC  = new Car(150,  25, NamedColor.BLACK);
        carXYM  = new Car(200, 100,  64);
        carXYMC = new Car(  0, 172, 256, NamedColor.RED);

        CM = CanvasManager.getInstance();
        CM.add(car0, carXY, carXYC, carXYM, carXYMC);

        IO.inform("Cars prepared");
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
     * Tests the blinking of the given car.
     *
     * @param car The tested car
     */
    private void auxBlink(Car car)
    {
        car.lightOff();     IO.pause(500);
        car.blinkLeft();    IO.pause(500);
        car.blinkRight();   IO.pause(500);
        car.lightOn();      IO.pause(500);
    }


    /***************************************************************************
     * Tests the change of the position and the size of the given car.
     *
     * @param car The tested car
     */
    private void auxPositionSize(Car car)
    {
        final int ms = 500;
        car.setPosition(50, 200);   IO.pause(ms);
        car.setModule(200);         IO.pause(ms);
        car.setModule(25);          IO.pause(ms);
        CM.remove(car);             IO.pause(ms);
    }



    //== MEMBER DATA TYPES =====================================================
    //== THE TESTS =============================================================
    //
    //     /***************************************************************************
    //      *
    //      */
    //     @Test
    //     public void testXXX()
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
        auxBlink(carXYC);
        auxBlink(carXYM);
        auxBlink(carXYMC);
    }


    @Test
    public void testSmoothMovement()
    {
        Mover p = new Mover(10);
        p.moveTo(150, 150, car0);
        p.moveTo(  0, 200, carXY);
        p.moveTo(  0,   0, carXYMC);
        p.moveTo(150, 236, carXYC);
        p.moveTo(  0, 150, carXYM);
    }


    @Test
    public void testPositionSize()
    {
        auxPositionSize(carXYMC);
        auxPositionSize(carXYM);
        auxPositionSize(carXYC);
        auxPositionSize(carXY);
        auxPositionSize(car0);
    }
}
