
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * The class {@code MultishapeTest} defines a set of unit tests
 * created in the interactive mode during the first introduction of objects.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class MultishapeTest
{
    private Multishape m1;
    private Multishape m2;

    private CanvasManager CM;
    private Mover mover;



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
        CM = CanvasManager.getInstance();
        m1 = new Multishape("m1", new Rectangle(), new Ellipse(), new Triangle());
        CM.add(m1);
        m2 = new Multishape("m2");
        CM.add(m2);
        m2.addShapes(m1);
        m1.setSize(33, 25);
        m1.setPosition(33, 25);
        m2.addShapes(m1);
        mover = new Mover(5);
        mover.moveTo(150, 0, m1);
        m2.creationDone();
        IO.inform("Multishapes prepared");
    }


    /***************************************************************************
     * Clean up after - this method is called after aech test.
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
    public void testSmoothMovement()
    {
        Mover mover = new Mover(10);
        mover.moveBy (100,   0, m1);
        mover.moveTo(100, 100, m2);
    }


    @Test
    public void testSmoothResizing()
    {
        Resizer resizer = new Resizer(10);
        resizer.resizeTo(300, 300, m2);
        resizer.resizeByMultipleOf(0.5, m2, Direction8.EAST);
        resizer.resizeBy(50, -50, m2, null);
    }

}