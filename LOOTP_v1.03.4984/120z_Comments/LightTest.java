
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

        CM = CanvasManager.getInstance();
        CM.add(light0, lightXY, lightXYC);

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
        IO.pause(500);
        light0    .blink();
        lightXY   .blink();
        lightXYC  .blink();
        IO.pause(500);
        light0    .switchOn();
        lightXY   .switchOn();
        lightXYC  .switchOn();
    }

}
