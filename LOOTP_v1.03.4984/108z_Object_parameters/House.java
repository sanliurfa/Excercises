
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * The class {@code House} defines a set of unit tests
 * created in the interactive mode.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class House
{
    private Rectangle building;
    private Rectangle chimney;
    private Triangle  roof;

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
        building = new Rectangle( 50, 200, 200, 100);
        chimney  = new Rectangle(100, 100,  20,  50);
        roof     = new Triangle ( 50, 100, 200, 100);
        IO.inform("House prepared");
    }


    /***************************************************************************
     * Clean up after each test.
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
    public void testSmoke()
    {
        Ellipse s1 = new Ellipse(100,  50,  50,  50);
        Ellipse s2 = new Ellipse(125,  25,  75,  50);
        Ellipse s3 = new Ellipse(150,   0, 100,  50);
    }


    public void testColor()
    {
        roof     .setColor(NamedColor.RED);
        building .setColor(NamedColor.AMBER);
    }

}
