/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testing class {@code LightTest} serves as a complex way to test
 * the class {@link Light}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class LightTest
{
    private CanvasManager CM;
    private Light light0;
    private Light lightXY;
    private Light lightXYC;
    private Light lightXYD;
    private Light lightXYDC;
    private Light lightXYDCF;



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
        light0    = new Light();
        lightXY   = new Light(50,  50);
        lightXYC  = new Light(100, 100, NamedColor.RED);
        lightXYD  = new Light(  0, 100, 100);
        lightXYDC = new Light(100,   0, 100, NamedColor.BLUE);
        lightXYDCF= new Light(150, 150, 150, NamedColor.MAGENTA, NamedColor.NO);

        CM = CanvasManager.getInstance();
        CM.add(light0, lightXY, lightXYC);
        CM.add(lightXYD, lightXYDC, lightXYDCF);

        IO.inform("Lights prepared");
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

    @Test
    public void testBlink()
    {
        light0    .switchOff();
        lightXY   .switchOff();
        lightXYC  .switchOff();
        lightXYD  .switchOff();
        lightXYDC .switchOff();
        lightXYDCF.switchOff();
        IO.pause(500);
        light0    .blink();
        lightXY   .blink();
        lightXYC  .blink();
        lightXYD  .blink();
        lightXYDC .blink();
        lightXYDCF.blink();
        IO.pause(500);
        light0    .switchOn();
        lightXY   .switchOn();
        lightXYC  .switchOn();
        lightXYD  .switchOn();
        lightXYDC .switchOn();
        lightXYDCF.switchOn();
    }

}
