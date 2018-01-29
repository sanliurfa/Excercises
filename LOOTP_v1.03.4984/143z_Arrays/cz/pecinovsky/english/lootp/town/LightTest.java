/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;
import cz.pecinovsky.english.lootp.manager.IModular;
import cz.pecinovsky.english.lootp.manager.Mover;

import cz.pecinovsky.english.lootp.util.IO;
import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.Position;

import java.util.ArrayList;
import java.util.List;

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
        CM.add(light0);
        CM.add(lightXY);
        CM.add(lightXYC);
        CM.add(lightXYD);
        CM.add(lightXYDC);
        CM.add(lightXYDCF);

        System.out.println("\n====== Instance v přípravku pro " + this +
                           "\n| CM: "        + CM +
                           "\n| light0:     " + light0      +
                           "\n| lightXY:    " + lightXY     +
                           "\n| lightXYC:   " + lightXYC    +
                           "\n| lightXYD:   " + lightXYD    +
                           "\n| lightXYDC:  " + lightXYDC   +
                           "\n| lightXYDCF: " + lightXYDCF  +
                           "\n======");
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

    /***************************************************************************
     * Exchanges positions of entered lights and checks
     * if the positions was really exchanged.
     *
     * @param l1 First light
     * @param l2 Second light
     */
    private void auxSwapPositions(Light l1, Light l2)
    {
        final int ms = 1000;

        l1.switchOff();
        l2.switchOff();
        IO.pause(ms);

        Position p1 = l1.getPosition();
        l1.setPosition(l2.getPosition());
        l2.setPosition(p1);

        IO.pause(ms);
        l1.switchOn();
        l2.switchOn();

        IO.pause(ms);
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


    @Test
    public void testSmoothMovement()
    {
        Mover p = new Mover(10);
        p.moveTo(200,   0, light0);
        p.moveTo(200,  50, lightXY);
        p.moveTo(  0,   0, lightXYDCF);
        p.moveTo(200, 100, lightXYDC);
        p.moveTo(150,   0, lightXYC);
        p.moveTo(  0, 150, lightXYD);
    }


    @Test
    public void testPositionSize()
    {
        Position sem = new Position(0, 150);
        int small = 25;
        int big   = 150;

        TestUtility.positionSize(lightXYDCF, sem, small, big);
        TestUtility.positionSize(lightXYDC,  sem, small, big);
        TestUtility.positionSize(lightXYD,   sem, small, big);
        TestUtility.positionSize(lightXYC,   sem, small, big);
        TestUtility.positionSize(lightXY,    sem, small, big);
        TestUtility.positionSize(light0,     sem, small, big);
    }


    @Test
    public void testGetColor()
    {
        assertEquals(NamedColor.BLUE, lightXYDC.getColor());
        assertEquals(NamedColor.BLUE, light0.getColor());
    }


    @Test
    public void testSwapPositions()
    {
        auxSwapPositions(light0,   lightXYDC);
        auxSwapPositions(lightXYC, lightXYD);
        auxSwapPositions(lightXYD, light0);
    }


    @Test
    public void testSwapPositionsWithCheck()
    {
        TestUtility.swapPositionsWithCheck(light0,   lightXYDC);
        TestUtility.swapPositionsWithCheck(lightXYC, lightXYD);
        TestUtility.swapPositionsWithCheck(lightXYD, light0);
    }


    /***************************************************************************
     * Vyzkouší schopnosti komparátoru ve třídě {@link TestUtility}
     * při řazení světel.
     */
    @Test
    public void testSortList()
    {
        List<IModular> seznam = new ArrayList<>();
        seznam.add(light0);
        seznam.add(lightXY);
        seznam.add(lightXYC);
        seznam.add(lightXYD);
        seznam.add(lightXYDC);
        seznam.add(lightXYDCF);
        seznam.add(light0);
        TestUtility.seřaďSeznam(seznam);
    }

}
