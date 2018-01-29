


/*******************************************************************************
 * Instance of class {@code Car} represent cars directed to the east.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Car implements IPaintable
{
    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Chassis of the car.*/
    private Rectangle chassis;

    /** Cab of the car. */
    private Rectangle cab;

    /** Left front light. */
    private Ellipse lightL;

    /** Right front light. */
    private Ellipse lightR;



    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a car with the default size
     * and with the default color of the chassis,
     * which will be placed into the canvas upper left corner.
     */
    public Car()
    {
        chassis = new Rectangle(  0,  0, 128, 64, NamedColor.BLUE);
        cab     = new Rectangle( 16, 16,  64, 32, NamedColor.GRAY);
        lightL  = new Ellipse  (112,  0,  16, 16, NamedColor.YELLOW);
        lightR  = new Ellipse  (112, 48,  16, 16, NamedColor.YELLOW);
    }


    /***************************************************************************
     * Creates a car with the default size
     * and with the default color of the chassis,
     * which will be placed at the given coordinates.
     *
     * @param x  Horizontal coordinate
     * @param y  Vertical coordinate
     */
    public Car(int x, int y)
    {
        chassis = new Rectangle(x+  0, y+ 0, 128, 64, NamedColor.BLUE);
        cab     = new Rectangle(x+ 16, y+16,  64, 32, NamedColor.GRAY);
        lightL  = new Ellipse  (x+112, y+ 0,  16, 16, NamedColor.YELLOW);
        lightR  = new Ellipse  (x+112, y+48,  16, 16, NamedColor.YELLOW);
    }


    /***************************************************************************
     * Creates a car with the default size
     * with the given color of the chassis,
     * which will be placed at the given coordinates.
     *
     * @param x             Horizontal coordinate
     * @param y             Vertical coordinate
     * @param chassisColor  Color of chassis
     */
    public Car(int x, int y, NamedColor chassisColor)
    {
        chassis = new Rectangle(x+  0, y+ 0, 128, 64, chassisColor);
        cab     = new Rectangle(x+ 16, y+16,  64, 32, NamedColor.GRAY);
        lightL  = new Ellipse  (x+112, y+ 0,  16, 16, NamedColor.YELLOW);
        lightR  = new Ellipse  (x+112, y+48,  16, 16, NamedColor.YELLOW);
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Paints the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
    @Override
    public void paint(Painter painter)
    {
        chassis.paint(painter);
        cab    .paint(painter);
        lightL .paint(painter);
        lightR .paint(painter);
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
