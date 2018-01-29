
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * The class {@code Robot} defines a set of unit tests
 * created in the interactive mode
 * during the first introduction of objects.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Robot
{
    private Rectangle head;
    private Rectangle leftHand;
    private Rectangle rightHand;
    private Rectangle body;
    private Rectangle legs;
    private Ellipse   leftWheel;
    private Ellipse   rightWheel;



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
    //== PREPARATION AND CLEANING THE TEST FIXTURE =============================

    /***************************************************************************
     * Creates a test fixture, i.e. a set of objects that will be prepared
     * before each run test.
     */
    @Before
    public void setUp()
    {
        head       = new Rectangle(100,  50,  50,  50, NamedColor.RED);
        body       = new Rectangle( 75, 100, 100, 125, NamedColor.CYAN);
        leftHand   = new Rectangle( 50, 100,  25, 100, NamedColor.STEELY);
        rightHand  = new Rectangle(175, 100,  25, 100, NamedColor.STEELY);
        leftWheel  = new Ellipse  ( 75, 225,  50,  50, NamedColor.BLACK);
        rightWheel = new Ellipse  (125, 225,  50,  50, NamedColor.BLACK);
        IO.inform("Robot prepared");
    }


    /***************************************************************************
     * Clean-up after - this method is called after each test.
     */
    @After
    public void tearDown()
    {
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================
    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
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
     * Sweep with the robot's left (for the viewer with the right) hand.
     */
    @Test
    public void testSweep()
    {
        rightHand.moveDown(-75);
        IO.pause(500);
        rightHand.moveDown(+75);
    }


    @Test
    public void testChangeColor()
    {
        NamedColor steely = NamedColor.getNamedColor("steely");
        rightHand.setColor(steely);
        leftHand .setColor(steely);
        NamedColor cyan = NamedColor.getNamedColor("cyan");
        body.setColor(cyan);
    }


    @Test
    public void testSmoothSweep()
    {
        Mover mover = new Mover(15);
        mover.moveBy(0, -75, rightHand);
        mover.moveBy(0,  75, rightHand);
    }

}
