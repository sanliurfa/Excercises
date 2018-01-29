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
    private TrafficLight trafficLightXYC;
    private TrafficLight trafficLightXYM;
    private TrafficLight trafficLightXYMC;



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
        trafficLightXYC = new TrafficLight(150, 100, NamedColor.BROWN);
        trafficLightXYM = new TrafficLight( 75,  25,  25);
        trafficLightXYMC= new TrafficLight(200,   0, 100, NamedColor.BLUE);

        CM = CanvasManager.getInstance();
        CM.add(trafficLight0);
        CM.add(trafficLightXY);
        CM.add(trafficLightXYC);
        CM.add(trafficLightXYM);
        CM.add(trafficLightXYMC);

        System.out.println("\n====== Instance v přípravku pro " + this +
                           "\n| CM: " + CM +
                           "\n| trafficLight0:    " + trafficLight0 +
                           "\n| trafficLightXY:   " + trafficLightXY +
                           "\n| trafficLightXYC:  " + trafficLightXYC +
                           "\n| trafficLightXYM : " + trafficLightXYM +
                           "\n| trafficLightXYMC: " + trafficLightXYMC +
                           "\n======");
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

    /***************************************************************************
     * With the help of a mover smoothly exchanges positions
     * of given trafficLights.
     *
     * @param tl1 First traffic light
     * @param tl2 Second traffic l ight
     */
    private void auxSmoothlySwapPositions(TrafficLight tl1, TrafficLight tl2)
    {
        Mover mover = new Mover(10);
        Position p1 = tl1.getPosition();
        mover.moveTo(tl2.getPosition(), tl1);
        mover.moveTo(p1,             tl2);
    }


    /***************************************************************************
     * Test the changes of position and size of given trafficlight.
     *
     * @param tl Tested traffic light
     */
    private void auxPositionSize(TrafficLight tl)
    {
        final int ms = 500;
        tl.setPosition(50, 0);        IO.pause(ms);
        tl.setModule(100);            IO.pause(ms);
        tl.setModule(25);             IO.pause(ms);
        CM.remove(tl);                IO.pause(ms);
    }


    /***************************************************************************
     * Exchanges positions of given traffic lights and checks
     * if the positions was really exchanged.
     *
     * @param tl1 First traffic light
     * @param tl2 Second traffic light
     */
    private void auxSwapPositionsWithCheck(TrafficLight tl1, TrafficLight tl2)
    {
        Position p1 = tl1.getPosition();
        Position p2 = tl2.getPosition();

        System.out.println("Výchozí: " + p1 + " <--> " + p2);
        auxSmoothlySwapPositions(tl1, tl2);
        System.out.println("Cílová:  " + tl1.getPosition() +
                              " <--> " + tl2.getPosition() + "\n");

        assertEquals(p1, tl2.getPosition());
        assertEquals(p2, tl1.getPosition());
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
    public void testCycle()
    {
        trafficLight0   .cycle();
        trafficLightXY  .cycle();
        trafficLightXYC .cycle();
        trafficLightXYM .cycle();
        trafficLightXYMC.cycle();
    }


    @Test
    public void testPositionSize()
    {
        auxPositionSize(trafficLight0);
        auxPositionSize(trafficLightXY);
        auxPositionSize(trafficLightXYC);
        auxPositionSize(trafficLightXYM);
        auxPositionSize(trafficLightXYMC);
    }


    @Test
    public void testSmoothMovement()
    {
        Mover p = new Mover(10);
        p.moveTo(100, 150, trafficLight0);
        p.moveTo(150,   0, trafficLightXY);
        p.moveTo(100,   0, trafficLightXYC);
        p.moveTo(150, 150, trafficLightXYM);
        p.moveTo(  0,   0, trafficLightXYMC);
    }


    @Test
    public void testSmoothlySwapPositions()
    {
        auxSmoothlySwapPositions(trafficLightXYMC, trafficLight0);
        auxSmoothlySwapPositions(trafficLightXYC,  trafficLightXYM);
    }


    @Test
    public void testSwapPositionsWithCheck()
    {
        auxSwapPositionsWithCheck(trafficLight0,   trafficLightXYMC);
        auxSwapPositionsWithCheck(trafficLightXYC, trafficLightXYM);
        auxSwapPositionsWithCheck(trafficLightXYM, trafficLight0);
    }
}
