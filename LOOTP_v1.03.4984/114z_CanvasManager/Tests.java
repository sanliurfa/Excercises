
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * The class {@code Tests} defines a set of unit tests
 * created in the interactive mode.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Tests
{
    private Rectangle rectangl0;
    private Ellipse   ellipse0;
    private Triangle  triangle0;
    private Rectangle rectangl1;
    private Ellipse   ellipse1;
    private Triangle  triangle1;
    private CanvasManager CM;



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
        rectangl0 = new Rectangle();
        ellipse0  = new Ellipse  ();
        triangle0 = new Triangle ();
        rectangl1 = new Rectangle(50, 50, 200, 100);
        ellipse1  = new Ellipse  (50, 50, 200, 100);
        triangle1 = new Triangle (50, 50, 200, 100);
        rectangl0.paint();
        ellipse0 .paint();
        triangle0.paint();
        rectangl1.paint();
        ellipse1 .paint();
        triangle1.paint();
        IO.inform("Fixture prepared");
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

    @Test
    public void testMovements()
    {
        triangle1.moveDown();
        ellipse1 .moveRight();
        rectangl1.paint();
    }


    @Test
    public void testMovements2()
    {
        ellipse1 .moveDown();
        triangle1.moveRight();
        rectangl1.paint();
    }


    @Test
    public void testColor()
    {
        NamedColor BARVA_OBD = rectangl1.getColor();
        triangle1.setColor(BARVA_OBD);
        NamedColor.showDefinedNames();
        NamedColor GRAY = NamedColor.getNamedColor("gray");
        triangle1.setColor(GRAY);
        triangle1.setColor(BARVA_OBD);
        IO.inform("It is red, it will be gray");
        triangle1.setColor(GRAY);
        IO.inform("It is gray, it will have the ellipse's color");
        triangle1.setColor(ellipse1.getColor());
    }


    @Test
    public void testSmoothMovements()
    {
        Mover mover = new Mover(3);
        mover.moveBy( 0, 50, triangle1);
        mover.moveTo(50,  0, ellipse1);
        rectangl0.paint();
    }

}
