/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */



/*******************************************************************************
 * Instances of class {@code Mover} works as servants
 * continuously moving the served instances implementing the interface
 * {@link IMovable}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Mover
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Number of milliseconds between moving and repainting object. */
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
     * Creates a mover that moves the served objects with the default speed 1.
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
    public void moveBy(int right, int down, IMovable object)
    {
        double distance = Math.sqrt(right*right + down*down);
        int    step     = (int)(distance / speed);
        double dx = (right+.4) / step;
        double dy = (down   +.4) / step;
        Position pozice = object.getPosition();
        double   x      = pozice.x + .4;
        double   y      = pozice.y + .4;

        for (int i=step;   i > 0;   i--) {
            x = x + dx;
            y = y + dy;
            object.setPosition((int)x, (int)y);
            IO.pause(PERIOD);
        }
    }


    /***************************************************************************
     * Smoothly moves the specified object by the specified number of points.
     *
     * @param distance  Number of points for moving
     * @param object  The moved object
     */
    public void moveBy(Position distance, IMovable object)
    {
        moveBy(distance.x, distance.y, object);
    }


    /***************************************************************************
     * Smoothly moves the given object to given position.
     *
     * @param x       x coordinate of the requiered destination position
     * @param y       y coordinate of the requiered destination position
     * @param object  The moved object
     */
    public void moveTo(int x, int y, IMovable object)
    {
        Position position = object.getPosition();
        moveBy(x-position.x, y-position.y, object);
    }


    /***************************************************************************
     * Smoothly moves the given object to given position.
     *
     * @param position The destination position
     * @param object   The moved object
     */
    public void moveTo(Position position, IMovable object)
    {
        moveTo(position.x, position.y, object);
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
