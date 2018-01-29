


/*******************************************************************************
 * Instances of the class {@code Line} represents lines
 * that are mind for work on a virtual canvas
 * during the first introduction to objects.
 * They are defined by their start and end points and color.
 * The position of an instance is defined as the position
 * of its start point.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Line implements IMovable, ICopyable
{
    //== CONSTANT CLASS FIELDS =================================================

    /** The default named color of created instances for the case,
     *  when the caller doesn't set any -
     *  for lines it is {@code NamedColor.BLACK}. */
    public static final NamedColor DEFAULT_COLOR = NamedColor.BLACK;

    /** The canva manager controlling painting of the instance. */
    private static final CanvasManager CM = CanvasManager.getInstance(false);



    //== VARIABLE CLASS FIELDS =================================================

    /** The number of created instances. */
    private static int count = 0;



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Instance ID = the order of the created instance inside its class. */
    private final int ID = ++count;

    /** The name constructed from simple class name and instance ID. */
    private final String name = "Line_" + ID;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** The x-coordinate of the instance,
     *  the x-coordinate of the start point.*/
    private int xPos;

    /** The y-coordinate of the instance,
     *  the y-coordinate of the start point.*/
    private int yPos;

    /** The x-coordinate of the end point.*/
    protected int xEnd;

    /** The x-coordinate of the end point.*/
    protected int yEnd;

    /** The instance color. */
    private NamedColor color;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a new instance with default position, size and color.
     * The instance will be placed in the upper left corner of the canvas,
     * it will have a default color
     * and it will end in the center of the present canvas.
     */
    public Line()
    {
        this(0, 0, CM.getWidth()  / 2,
                   CM.getHeight() / 2);
    }


    /***************************************************************************
     * Creates a new instance with given position and size
     * and with default color.
     * The position of an instance is defined as the position
     * of its start point.
     *
     * @param x     The horizontal coordinate of the start point
     * @param y     The vertical   coordinate of the start point
     * @param xEnd  The horizontal coordinate of the end   point
     * @param yEnd  The vertical   coordinate of the end   point
     */
    public Line(int x, int y, int xEnd, int yEnd)
    {
        this(x, y, xEnd, yEnd, DEFAULT_COLOR);
    }


    /***************************************************************************
     * Creates a new instance with given position and size
     * and with a given color.
     * The position of an instance is defined as the position
     * of its start point.
     *
     * @param x     The horizontal coordinate of the start point
     * @param y     The vertical   coordinate of the start point
     * @param xEnd  The horizontal coordinate of the end   point
     * @param yEnd  The vertical   coordinate of the end   point
     * @param color  The color of the instance
     */
    public Line(int x, int y, int xEnd, int yEnd, NamedColor color)
    {
//        //Test platnosti parametru
//        if ((x<0) || (y<0) || (xEnd<0) || (yEnd<0)) {
//            throw new IllegalArgumentException(
//                "\nParametry nemají povolené hodnoty: x="
//                + x + ", y=" + y + ", xEnd=" + xEnd + ", yEnd=" + yEnd);
//        }

        //Parametry akceptovány --> můžeme tvořit
        this.xPos  = x;
        this.yPos  = y;
        this.xEnd  = xEnd;
        this.yEnd  = yEnd;
        this.color = color;
    }


    /***************************************************************************
     * Returns a copy of the instance, which means a line
     * with the same size, position and color.
     *
     * @return The requested copy
     */
    @Override
    public Line copy()
    {
        return new Line(xPos, yPos, xEnd, yEnd, color);
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns the current x coordinate of the instance,
     * which means the horizontal position
     * of its start point.
     *
     * @return  The horizontal coordinate,
     *          left canvas border has x=0, coordinate increases to the right
     */
    @Override
    public int getX()
    {
        return xPos;
    }


    /***************************************************************************
     * Returns the current y coordinate of the instance,
     * which means the horizontal position
     * of its start point.
     *
     * @return  The vertical coordinate,
     *          upper canvas border has y=0, coordinate increases down
     */
    @Override
    public int getY()
    {
        return yPos;
    }


    /***************************************************************************
     * Sets a position of the instance (new values of its coordinates)
     * and moves the instance to this position.
     * The position of instance is defined as the position
     * of its start point.
     *
     * @param x  The newly set horizontal coordinate,
     *           Left canvas border has x=0, coordinate increases to the right
     * @param y  The newly set vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     */
    @Override
    public void setPosition(int x, int y)
    {
        CM.stopPainting(); {
            xEnd   = x  +  (xEnd - xPos);
            yEnd   = y  +  (yEnd - yPos);
            xPos = x;
            yPos = y;
        } CM.returnPainting();
    }


    /***************************************************************************
     * Returns the current x coordinate of the end point.
     *
     * @return  The horizontal coordinate of the end point,
     *          left canvas border has x=0, coordinate increases to the right
     */
    public int getEndX()
    {
        return xEnd;
    }


    /***************************************************************************
     * Returns the current y coordinate of the end point.
     *
     * @return  The vertical coordinate of the end point,
     *          upper canvas border has y=0, coordinate increases down
     */
     public int getEndY()
     {
         return yEnd;
     }


    /***************************************************************************
     * Sets a position of the line end point.
     *
     * @param xEnd The newly set horizontal coordinate. Left canvas border
     *             has x=0, coordinate increases to the right
     * @param yEnd The newly set vertical coordinate. Upper canvas border
     *             has y=0, coordinate increases to the down
     */
     public void setEndPosition(int xEnd, int yEnd)
     {
         this.xEnd = xEnd;
         this.yEnd = yEnd;
         CM.repaint();
     }


    /***************************************************************************
     * Returns the current color of the instance.
     *
     * @return The current color of the instance
     */
    public NamedColor getColor()
    {
        return color;
    }


    /***************************************************************************
     * Sets a new color of the instance.
     *
     * @param newColor The new color of the instance
     */
    public void setColor(NamedColor newColor)
    {
        this.color = newColor;
        CM.repaint();
    }


    /***************************************************************************
     * Returns the name of the instance, which means the name of its class
     * followed by the order of the instance ID.
     *
     * @return  Instance name
     */
    public String getName()
    {
        return name;
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Returns a string representation of the object (objects's signture).
     * It is used mainly by the debugging.
     *
     * @return Name of the instance followed by its coordinates,
     *         dimensons and color
     */
    @Override
    public String toString()
    {
        return name + "_[x=" + xPos + ", y=" + yPos  +
                      ", kx=" + xEnd + ", ky=" + yEnd +
                      ", color=" + color + "]";
    }


    /***************************************************************************
     * Paint the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
    @Override
    public void paint(Painter painter)
    {
        painter.drawLine(getX(), getY(), xEnd, yEnd, getColor());
    }


    /***************************************************************************
     * Registers the instance at the canvas manager
     * and so force painting the instance on the canvas.
     */
    public void paint()
    {
        CM.add(this);
    }


    /***************************************************************************
     * Unregisters the instance at the canvas manager
     * which is equal to rub out the instance from the canvas.
     */
    public void rubOut()
    {
        CM.remove(this);
    }


    /***************************************************************************
     * Move the instance by the specified amount of points to the right or
     * (by negative argument) left.
     *
     * @param distance Distance for move
     */
    public void moveRight(int distance)
    {
        setPosition(xPos+distance, yPos);
    }


    /**************************************************************************
     * Move the instance by the default amount of points to the right.
     * This default distance equals to the step of {@link CanvasManager}.
     * It can be obtained by calling its method {@link CanvasManager#getStep()}
     * and set by calling its method {@link CanvasManager#setStep(int)}
     * or {@link CanvasManager#setStepAndSize(int,int,int)}.
     */
    public void moveRight()
    {
        moveRight(CM.getStep());
    }


    /***************************************************************************
     * Move the instance by the default amount of points to the left.
     * This default distance equals to the step of {@link CanvasManager}.
     * It can be obtained by calling its method {@link CanvasManager#getStep()}
     * and set by calling its method {@link CanvasManager#setStep(int)}
     * or {@link CanvasManager#setStepAndSize(int,int,int)}.
     */
    public void moveLeft()
    {
        moveRight(-CM.getStep());
    }


    /***************************************************************************
     * Move the instance by the specified amount of points down or
     * (by negative argument) up.
     *
     * @param distance Distance for move
     */
    public void moveDown(int distance)
    {
        setPosition(xPos, yPos+distance);
    }


    /***************************************************************************
     * Move the instance by the default amount of points down.
     * This default distance equals to the step of {@link CanvasManager}.
     * It can be obtained by calling its method {@link CanvasManager#getStep()}
     * and set by calling its method {@link CanvasManager#setStep(int)}
     * or {@link CanvasManager#setStepAndSize(int,int,int)}.
     */
    public void moveDown()
    {
        moveDown(CM.getStep());
    }


    /***************************************************************************
     * Move the instance by the default amount of points up.
     * This default distance equals to the step of {@link CanvasManager}.
     * It can be obtained by calling its method {@link CanvasManager#getStep()}
     * and set by calling its method {@link CanvasManager#setStep(int)}
     * or {@link CanvasManager#setStepAndSize(int,int,int)}.
     */
    public void moveUp()
    {
        moveDown(-CM.getStep());
    }


    /***************************************************************************
     * Move the instance to Line the given points.
     *
     * @param xStart  The horizontal coordinate of the start point
     * @param yStart  The vertical   coordinate of the start point
     * @param xEnd    The horizontal coordinate of the end   point
     * @param yEnd    The vertical   coordinate of the end   point
     */
    public void connect(int xStart, int yStart, int xEnd, int yEnd)
    {
        setPosition(xStart, yStart);
        this.xEnd   = xEnd;
        this.yEnd   = yEnd;
        CM.repaint();
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
