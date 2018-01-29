


/*******************************************************************************
 * Instances of the class {@code Rectangle} represents rectangles
 * that are mind for work on a virtual canvas
 * during the first introduction to objects.
 * They are defined by their position, size and color.
 * The position of instance is defined as the position
 * of its upper left corner.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Rectangle
       implements IShape
{
    //== CONSTANT CLASS FIELDS =================================================

    /** The default named color of created instances for the case,
     *  when the caller doesn't set any -
     *  for rectangles it si {@code NamedColor.RED}. */
    public static final NamedColor DEFAULT_COLOR = NamedColor.RED;

    /** Maximal allowed size of the step. */
    public static final int MAX_STEP = 100;

    /** The canvas, where the instance will be painted. */
    private static final Canvas CANVAS = Canvas.getCanvas();



    //== VARIABLE CLASS FIELDS =================================================

    /** The default distance of movement
     *  used in parameterless movement commands. */
    private static int step = 50;

    /** The number of created instances. */
    private static int count = 0;



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Instance ID = the order of the created instance inside its class. */
    private final int ID = ++count;

    /** The name constructed from simple class name and instance ID. */
    private final String name = "Rectangle_" + ID;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** The x-coordinate of the instance. */
    private int xPos;

    /** The y-coordinate of the instance. */
    private int yPos;

    /** The instance width. */
    protected int width;

    /** The instance height. */
    protected int height;

    /** The instance color. */
    private NamedColor color;



    //== CLASS GETTERS AND SETTERS =============================================

    /***************************************************************************
     * Returns the default distance (step) of movement
     * used in parameterless movement commands.
     *
     * @return The default distance of movement in points
     */
     public static int getStep()
     {
         return step;
     }


    /***************************************************************************
     * Sets the default distance (step) of movement
     * used in parameterless movement commands.
     *
     * @param distance The default distance of movement;<br>
     *                 0 &lt;= distance &lt;= {@link #MAX_STEP} must be true
     */
    public static void setStep(int distance)
    {
        if ((distance < 0)  || (distance > MAX_STEP)) {
            throw new IllegalArgumentException(
                "\nThe distance must be from inteval <0; " + MAX_STEP + ">.");
        }
        step = distance;
    }



    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a new instance with default position, size and color.
     * The instance will be placed in the upper left corner of the canvas,
     * it will have a default color,
     * height equals the step and width equals twice the step (default 50×100).
     */
    public Rectangle()
    {
        this(0, 0, 2*step, step);
    }


    /***************************************************************************
     * Creates a new instance with given position and size
     * and with default color.
     * The position of instance is defined as the position
     * of its upper left corner.
     *
     * @param x  The horizontal coordinate,
     *           left canvas border has x=0, coordinate increases to the right
     * @param y  The vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     * @param width  The width  of the instance - must be &gt; 0
     * @param height The height of the instance - must be &gt; 0
     */
    public Rectangle(int x, int y, int width, int height)
    {
        this(x, y, width, height, DEFAULT_COLOR);
    }


    /***************************************************************************
     * Creates a new instance with given position, size and color.
     * The position of instance is defined as the position
     * of its upper left corner.
      *
     * @param x  The horizontal coordinate,
     *           left canvas border has x=0, coordinate increases to the right
     * @param y  The vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     * @param width  The width  of the instance - must be &gt; 0
     * @param height The height of the instance - must be &gt; 0
     * @param color  The color of the instance
     */
    public Rectangle(int x, int y, int width, int height, NamedColor color)
    {
        //Verification of arguments
        if ((width<=0) || (height<=0)) {
            throw new IllegalArgumentException(
                "\nThe argument have illegal values: x="
                + x + ", y=" + y + ", width=" + width + ", height=" + height);
        }

        //Arguments accepted, we can work
        this.xPos  = x;
        this.yPos  = y;
        this.width = width;
        this.height= height;
        this.color = color;
        repaintPrivate();
    }


    /***************************************************************************
     * Returns a copy of the ellipse, which means an ellipse
     * with the same size, position and color.
     *
     * @return The requested copy
     */
    public IShape copy()
    {
        if (this instanceof IShape) {
            return (IShape)new Rectangle(xPos, yPos, width, height, color);
        } else {
            //Auxiliary class ensuring the right function even in the case
            //when the class do not implement the interface IShape
            class TT extends Rectangle implements IShape {
                TT(int x, int y, int s, int v, NamedColor b) {
                    super(x, y, s, v, b);
                }
            }
            return new TT(xPos, yPos, width, height, color);
        }
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns the current x coordinate of the instance,
     * which means the horizontal position of the its upper left corner.
     * &nbsp;
     *
     * @return  The horizontal coordinate,
     *          left canvas border has x=0, coordinate increases to the right
     */
    public int getX()
    {
        return xPos;
    }


    /***************************************************************************
     * Returns the current y coordinate of the instance,
     * which means the vertical position of the its upper left corner.
     * &nbsp;
     *
     * @return  The vertical coordinate,
     *          upper canvas border has y=0, coordinate increases down
     */
    public int getY()
    {
        return yPos;
    }


    /***************************************************************************
     * Sets a position of the instance (new values of its coordinates)
     * and moves the instance to this position.
     * The position of instance is defined as the position
     * of its upper left corner.
     *
     * @param x  The newly set horizontal coordinate,
     *           Left canvas border has x=0, coordinate increases to the right
     * @param y  The newly set vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     */
    public void setPosition(int x, int y)
    {
        rubOut();
        xPos = x;
        yPos = y;
        paint();
    }


    /***************************************************************************
     * Returns the current width of the instance.
     *
     * @return  The current width of the instance
     */
     public int getWidth()
     {
         return width;
     }


    /***************************************************************************
     * Returns the current height of the instance.
     *
     * @return  The current height of the instance
     */
     public int getHeight()
     {
         return height;
     }


    /***************************************************************************
     * Sets a new "square" size of the instance, which means
     * it set the specified size to its width as well as to its height.
     * The set dimensions must be non-negative,
     * the zero value is substituted by one.
     *
     * @param size The new dimensions of the instance; dimension &gt;= 0
     */
    public void setSize(int size)
    {
        setSize(size, size);
    }


    /***************************************************************************
     * Sets a new dimensions of the instance.
     * The set dimensions must be non-negative,
     * the zero value is substituted by one.
     *
     * @param width  The new width of the instance;  width  &gt;= 0
     * @param height The new height of the instance; height &gt;= 0
     */
    public void setSize(int width, int height)
    {
        if ((width < 0) || (height < 0)) {
            throw new IllegalArgumentException(
                            "The dimensions may not be negativ: width=" +
                            width + ", height=" + height);
        }
        rubOut();
        this.width = width;
        this.height = height;
        paint();
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
     * @param color The new color of the instance
     */
    public void setColor(NamedColor color)
    {
        if (color != NamedColor.NO) {
            this.color = color;
            paint();
        }
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
     * Returns a string representation of the object (object's signature).
     * It is used mainly by the debugging.
     *
     * @return Name of the instance followed by its coordinates,
     *         dimensions and color
     */
    @Override
    public String toString()
    {
        return name + "[x=" + xPos + ", y=" + yPos +
               ", width=" + width + ", height=" + height +
               ", color=" + color + "]";
    }


    /***************************************************************************
     * Paints the instance on the canvas.
     */
    public void paint()
    {
        repaintPrivate();
    }


    /***************************************************************************
     * Rubs out the instance from the canvas
     * (repaints it by the background color).
     */
    public void rubOut()
    {
        CANVAS.setForegroundColor(CANVAS.getBackgroundColor());
        CANVAS.fill(new java.awt.geom.Rectangle2D.Double
                         (xPos, yPos, width, height));
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


    /***************************************************************************
     * Move the instance by the default amount of points to the right.
     * This number can be obtained by call the static method {@link #getStep()}
     * and set by call the static method {@link #setStep(int)}.
     */
    public void moveRight()
    {
        moveRight(step);
    }


    /***************************************************************************
     * Move the instance by the default amount of points to the left.
     * This number can be obtained by call the static method {@link #getStep()}
     * and set by call the static method {@link #setStep(int)}.
     */
    public void moveLeft()
    {
        moveRight(-step);
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
     * This number can be obtained by call the static method {@link #getStep()}
     * and set by call the static method {@link #setStep(int)}.
     */
    public void moveDown()
    {
        moveDown(step);
    }


    /***************************************************************************
     * Move the instance by the default amount of points up.
     * This number can be obtained by call the static method {@link #getStep()}
     * and set by call the static method {@link #setStep(int)}.
     */
    public void moveUp()
    {
        moveDown(-step);
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * Paints the instance on the canvas.
     */
    private void repaintPrivate()
    {
        CANVAS.setForegroundColor(color);
        CANVAS.fill(new java.awt.geom.Rectangle2D.Double
                         (xPos, yPos, width, height));
    }



    //== EMBEDDED AND INNER CLASSES ============================================
    //== TESTING CLASSES AND METHODS ===========================================
}
