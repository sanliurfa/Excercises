


/*******************************************************************************
 * Instances of class {@code Mover} works as servants
 * continuously moving the served instances implementing the interface
 * {@link IShape}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Mover
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Number of miliseconds between moving and repainting object. */
    private static final int PERIOD = 50;



    //== VARIABLE CLASS FIELDS =================================================

    /** Number of created instances. */
    private static int countCreated = 0;



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Instance ID = the order of the created instance inside its class. */
    private final int ID = ++countCreated;

    /** Name consisting from the class name and instance ID. */
    private final String name;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** The speed of movement by this mover. */
    private int speed;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a moover that moves the served objects with the default speed 1.
     */
    public Mover()
    {
        this(1);
    }


    /***************************************************************************
     * Creates a mover that moves the served objects with the specified speed.
     *
     * @param speed The speed that the mover uses for moving
     *              the served objects
     */
    public Mover(int speed)
    {
        if (speed <= 0) {
            throw new IllegalArgumentException(
                "The given speed must be positive!");
        }
        this.speed = speed;
        this.name  = getClass().getSimpleName() +
                     "[ID=" + ID + ", speed=" + speed + "]";
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Returns a string representation of the object (objects's signture).
     * It is used mainly by the debugging.
     *
     * @return  Simple class name followed by brackets
     *          with instance ID and speed
     */
    @Override
    public String toString()
    {
        return name;
    }


    /***************************************************************************
     * Smoothly moves the specified object by the specified number of points.
     *
     * @param right   Number of points moving to the right
     * @param down    Number of points moving down
     * @param object  The moved object
     */
    public void moveBy(int right, int down, IShape object)
    {
        double distance = Math.sqrt(right*right + down*down);
        int    step     = (int)(distance / speed);
        double dx = (right+.4) / step;
        double dy = (down +.4) / step;
        int    px = object.getX();
        int    py = object.getY();
        double x  = px + .4;
        double y  = py + .4;

        for (int i=step;   i > 0;   i--) {
            x += dx;
            y += dy;
            object.setPosition((int)x, (int)y);
            IO.pause(PERIOD);
        }
    }


    /***************************************************************************
     * Smoothly moves the given object to given position.
     *
     * @param x       x coordinate of the required destination position
     * @param y       y coordinate of the required destination position
     * @param object  The moved object
     */
    public void moveTo(int x, int y, IShape object)
    {
        int currentX = object.getX();
        int currentY = object.getY();
        moveBy(x-currentX, y-currentY, object);
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
