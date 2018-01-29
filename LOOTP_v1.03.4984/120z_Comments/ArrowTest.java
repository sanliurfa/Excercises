
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testing class {@code ArrowTest} serves as a complex way to test
 * the class {@code Arrow}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class ArrowTest
{
    private CanvasManager CM;

    private Arrow arrow0;
    private Arrow arrowXY;
    private Arrow arrowXYB;



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
        arrow0     = new Arrow();
        arrowXY    = new Arrow(50,  50);
        arrowXYB   = new Arrow(100, 100, NamedColor.BLUE);

        CM = CanvasManager.getInstance();
        CM.add(arrow0);
        CM.add(arrowXY);
        CM.add(arrowXYB);

        IO.inform("Arrows prepared");
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
    public void testTranslucent()
    {
        Rectangle ground = new Rectangle(25, 25, 100, 100, NamedColor.WHITE);
        CM.addBehind(arrow0, ground);

        arrow0   .translucent();
        arrowXY  .translucent();
        arrowXYB .translucent();

        IO.inform("Verify translucency");

        arrow0   .restoreColor();
        arrowXY  .restoreColor();
        arrowXYB .restoreColor();
     }

}
