/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testing class {@code TrafficLightTest} serves as a complex way to test
 * the class {@link TrafficLight}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class TrafficLightTest
{
    private CanvasManager CM;

    private TrafficLight trafficLight0;
    private TrafficLight trafficLightXY;
    private TrafficLight trafficLightXYB;
    private TrafficLight trafficLightXYM;
    private TrafficLight trafficLightXYMB;



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
        trafficLight0   = new TrafficLight();
        trafficLightXY  = new TrafficLight(100,  50);
        trafficLightXYB = new TrafficLight(150, 100, NamedColor.BROWN);
        trafficLightXYM = new TrafficLight( 75,  25,  25);
        trafficLightXYMB= new TrafficLight(200,   0, 100, NamedColor.BLUE);

        CM = CanvasManager.getInstance();
        CM.add(trafficLight0);
        CM.add(trafficLightXY);
        CM.add(trafficLightXYB);
        CM.add(trafficLightXYM);
        CM.add(trafficLightXYMB);

        IO.inform("Traffic lights prepared");
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
    //     /********************************************************************
    //      *
    //      */
    //     @Test
    //     public void testXXX()
    //     {
    //     }
    //

    @Test
    public void testCycle()
    {
        trafficLight0   .cycle();
        trafficLightXY  .cycle();
        trafficLightXYB .cycle();
        trafficLightXYM .cycle();
        trafficLightXYMB.cycle();
    }

}
