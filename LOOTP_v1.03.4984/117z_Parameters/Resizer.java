


/*******************************************************************************
 * Instances of class {@code Resizer} works as servants
 * continuously resizing the served instances implementing the interface
 * {@code IResizable}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Resizer
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Time between particular jerks.*/
    private final static int PERIOD = 30;



    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================

    /** Specify the power of the jerk, which means
     *  how much the size increases or decreases by one jerk. */
    private int power;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a resizer with power = 1 (power defines how much
     * the size increases or decreases by one jerk.
     */
    public Resizer()
    {
        this(1);
    }


    /***************************************************************************
     * Creates a resizer with the specified power (power defines how much
     * the size increases or decreases by one jerk.
     *
     * @param power  Size change after one jerk
     */
    public Resizer(int power)
    {
        this.power = power;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Changes the size of the specified instance to the specified multiple.
     * By thich resize the aspect ratio doesn't change.
     *
     * @param multiple  How many times should the object increase or decrease
     *                  its size
     * @param object    Object with the changed size
     */
    public void resizeByMultipleOf(double multiple, IResizable object)
    {
        int width  = (int)Math.round(object.getWidth()  * multiple);
        int height = (int)Math.round(object.getHeight() * multiple);
        resize(object, width, height, Direction8.NORTH_WEST);
    }


    /***************************************************************************
     * Changes the size of the specified instance to the specified multiple
     * with the specified point at the perimeter of the circumscribe rectangle
     * which doesn't move during the size change.
     * By thich resize the aspect ratio doesn't change.
     *
     * @param multiple   How many times should the object increase or decrease
     *                   its size
     * @param object Object with the changed size
     * @param fixed  Direction from the center of the shape where is the point,
     *               which position doesn't change during resizing.
     *               Directions {@link Direction8#NOWHERE} a {@code null}
     *               specifies the point in the shape's center
     */
    public void resizeByMultipleOf(double multiple, IChangeable object,
                                   Direction8 fixed)
    {
        int width = (int)Math.round(object.getWidth()  * multiple);
        int height = (int)Math.round(object.getHeight() * multiple);
        resize((IResizable)object, width, height, fixed);
    }


    /***************************************************************************
     * Changes the size of the specified instance to the specified sizes.
     *
     * @param width  The new width of the resized object
     * @param height The new height of the resized object
     * @param object Object with the changed size
     */
    public void resizeTo(int width, int height, IResizable object)
    {
        resize(object, width, height, Direction8.NORTH_WEST);
    }


    /***************************************************************************
     * Changes the size of the specified instance to the specified sizes
     * with the specified point at the perimeter of the circumscribe rectangle
     * which doesn't move during the size change.
     *
     * @param width  The new width of the resized object
     * @param height The new height of the resized object
     * @param object Object with the changed size
     * @param fixed  Direction from the center of the shape where is the point,
     *               which position doesn't change during resizing.
     *               Directions {@link Direction8#NOWHERE} a {@code null}
     *               specifies the point in the shape's center
     */
    public void resizeTo(int width, int height, IChangeable object,
                         Direction8 fixed)
    {
        resize((IResizable)object, width, height, fixed);
    }


    /***************************************************************************
     * Changes the size of the specified instance by the specified sizes.
     *
     * @param dx     The change of the size in the horizontal direction
     * @param dy     The change of the size in the vertical direction
     * @param object Object with the changed size
     */
    public void resizeBy(int dx, int dy, IResizable object)
    {
        int width  = object.getWidth()  + dx;
        int height = object.getHeight() + dy;
        resize(object, width, height, Direction8.NORTH_WEST);
    }


    /***************************************************************************
     * Changes the size of the specified instance by the specified sizes
     * with the specified point at the perimeter of the circumscribe rectangle
     * which doesn't move during the size change.
     *
     * @param dx     The change of the size in the horizontal direction
     * @param dy     The change of the size in the vertical direction
     * @param object Object with the changed size
     * @param fixed  Direction from the center of the shape where is the point,
     *               which position doesn't change during resizing.
     *               Directions {@link Direction8#NOWHERE} a {@code null}
     *               specifies the point in the shape's center
     */
    public void resizeBy(int dx, int dy, IChangeable object, Direction8 fixed)
    {
        int width  = object.getWidth()  + dx;
        int height = object.getHeight() + dy;
        resize((IResizable)object, width, height, fixed);
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * Changes the size of the specified instance to the specified size
     * with the specified point at the perimeter of the circumscribe rectangle
     * which doesn't move during the size change.
     * If the direction to the fixed point is not specified,
     * the NORTHWEST (upper left corner) is set.
     *
     * @param object Object with the changed size
     * @param width  The new width of the resized object
     * @param height The new height of the resized object
     * @param fixed  Direction from the center of the shape where is the point,
     *               which position doesn't change during resizing.
     *               Directions {@link Direction8#NOWHERE} a {@code null}
     *               specifies the point in the shape's center
     */
    private void resize(IResizable object, int width, int height,
                        Direction8 fixed)
    {
        int    ow = object.getWidth();
        int    oh = object.getHeight();
        int    horizontal = width  - ow;
        int    vertical   = height - oh;
        int    numSteps   = (int)(Math.hypot(horizontal, vertical) / power);
        double dx = (double)horizontal / numSteps;
        double dy = (double)vertical   / numSteps;
        execute(object, numSteps, dx, dy, fixed);
    }


    /***************************************************************************
     * Execution method performing the resizing.
     *
     * @param object    Object with the changed size
     * @param numSteps  Number of steps used for resizing
     * @param dx        Horizontal change in one step
     * @param dy        Vertical change in one step
     * @param fixed     Direction to the fixed point
     */
    private void execute(IResizable object, int numSteps,
                         double dx, double dy, Direction8 fixed)
    {
        if (fixed == null) {
            fixed = Direction8.NOWHERE;
        }
        IChangeable icho = null;    //Object casted to IChangeable
        double dxx = 0, dyy = 0;    //Position change in each jerk
        double x   = 0, y   = 0;    //Coordinates after jerk
        if (fixed != Direction8.NORTH_WEST)
        {
            if (! (object instanceof IChangeable)) {
                throw new IllegalArgumentException(
                      "\nOnly the instances of IChangeable can be resized " +
                        "with the fixed point in the direction " + fixed);
            }
            icho = (IChangeable)object;
            x  = icho.getX() + .4;
            y  = icho.getY() + .4;
            if (     (fixed == Direction8.SOUTH_EAST) ||
                     (fixed == Direction8.EAST)       ||
                     (fixed == Direction8.NORTH_EAST))
            {
                dxx = -dx;
            }
            else if ((fixed == Direction8.NORTH)  ||
                     (fixed == Direction8.SOUTH)  ||
                     (fixed == Direction8.NOWHERE))
            {
                dxx = -dx/2;
            }
            if (     (fixed == Direction8.SOUTH_WEST)  ||
                     (fixed == Direction8.SOUTH)       ||
                     (fixed == Direction8.SOUTH_EAST))
            {
                dyy = -dy;
            }
            else if ((fixed == Direction8.EAST)  ||
                     (fixed == Direction8.WEST)  ||
                     (fixed == Direction8.NOWHERE))
            {
                dyy = -dy/2;
            }
        }
        //We add the constant to make the jerks more equal
        int    oldWidth  = object.getWidth();
        int    oldHeight = object.getHeight();
        double width     = oldWidth  + .4;
        double height    = oldHeight + .4;

        while (numSteps-- > 0) {
            IO.pause(PERIOD);
            width  += dx;
            height += dy;
            object.setSize((int)width, (int)height);
            if (fixed != Direction8.NORTH_WEST) {
                x += dxx;
                y += dyy;
                icho.setPosition((int)x, (int)y);
            }
        }
    }



    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
