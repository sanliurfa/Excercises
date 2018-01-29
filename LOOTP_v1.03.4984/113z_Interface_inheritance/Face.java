
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * The class {@code Face} defines a set of unit tests
 * created in the interactive mode.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Face
{
    private Ellipse   body;
    private Rectangle head;
    private Ellipse   leftEye;
    private Ellipse   rightEye;
    private Ellipse   nose;
    private Ellipse   mouth;



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
        body     = new Ellipse  ( 0, 225, 300, 150, NamedColor.GREEN);
        head     = new Rectangle( 50,  50, 200, 200);
        leftEye  = new Ellipse  ( 75,  75,  25,  25);
        rightEye = new Ellipse  (200,  75,  25,  25);
        nose     = new Ellipse  (125,  75,  50,  75);
        mouth    = new Ellipse  ( 75, 175, 150,  50);
        IO.inform("Face prepared");
    }


    /***************************************************************************
     * Clean-up after the test - this method is called after each test.
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

    @Test
    public void testSmile()
    {
        mouth.setPosition(75, 150);
        mouth.setSize(150, 100);
        Rectangle ret = new Rectangle(75, 150, 150, 50);
    }


    @Test
    public void testBlink()
    {
        NamedColor hColor = head  .getColor();
        NamedColor eColor = leftEye.getColor();
        leftEye.setColor(hColor);
        IO.pause(250);
        leftEye.setColor(eColor);
    }


    @Test
    public void testCap()
    {
        Triangle cap = new Triangle(50, 0, 200, 50);
        cap.setPosition(50, -50);
        Mover mover = new Mover(5);
        mover.moveBy(0, 50, cap);
    }

}
