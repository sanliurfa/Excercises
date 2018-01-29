


/*******************************************************************************
 * Instances of the class {@code Triangle} represents triangles
 * that are mind for work on a virtual canvas
 * during the first introduction to objects.
 * They are defined by their position, size, color and direction
 * to which the main vertex is turned.
 * The position of instance is defined as the position
 * of the upper left corner of the circumscribe rectangle
 * and its size is defined as the size of this rectangle.
 * The direction of the triangle is the direction
 * to which the main vertex of the triagle is turned
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Triangle implements IShape
{
    //== CONSTANT CLASS FIELDS =================================================

    /** The default named color of created instances for the case,
     *  when the caller doesn't set any -
     *  for triangles it is {@code NamedColor.GREEN}. */
    public static final NamedColor DEFAULT_COLOR = NamedColor.GREEN;

    /** The default direction of created triangle, which means the direction
     *  to which the main vertex of the triagle is turned
     *  when user doesnť define any preferred direction. */
    public static final Direction8 DEFAULT_DIRECTION = Direction8.NORTH;

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
    private final String name = "Triangle_" + ID;



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

    /** Direction, where the main vertex looks. */
    private Direction8 dir8;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a new instance with default position, size, color
     * and direction.
     * The instance will be placed in the upper left corner of the canvas,
     * it will have a default color,
     * height equals the width of the grid field and width equals twice of it
     * and its main vertex will be turned to the North.
     */
    public Triangle()
    {
        this(0, 0, 2*CM.getStep(), CM.getStep());
    }


    /***************************************************************************
     * Creates a new instance with given position and size
     * and with default color.
     * The position of an instance is defined as the position
     * of the upper left corner of the circumscribe rectangle
     * and its size is defined as the size of this rectangle.
     * The direction of the triangle is the direction
     * to which the main vertex of the triangle is turned
     *
     * @param x  The horizontal coordinate,
     *           left canvas border has x=0, coordinate increases to the right
     * @param y  The vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     * @param width  The width  of the instance - must be &gt; 0
     * @param height The height of the instance - must be &gt; 0
     */
    public Triangle(int x, int y, int width, int height)
    {
        this(x, y, width, height, DEFAULT_COLOR, DEFAULT_DIRECTION);
    }


    /***************************************************************************
     * Creates a new instance with given position, size and color
     * and with default direction for the main vertex.
     * The position of an instance is defined as the position
     * of the upper left corner of the circumscribe rectangle
     * and its size is defined as the size of this rectangle.
     * The direction of the triangle is the direction
     * to which the main vertex of the triangle is turned
     *
     * @param x  The horizontal coordinate,
     *           left canvas border has x=0, coordinate increases to the right
     * @param y  The vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     * @param width  The width  of the instance - must be &gt; 0
     * @param height The height of the instance - must be &gt; 0
     * @param color  The color of the instance
     */
    public Triangle(int x, int y, int width, int height, NamedColor color)
    {
        this(x, y, width, height, color, DEFAULT_DIRECTION);
    }


    /***************************************************************************
     * Creates a new instance with given position, size and direction
     * and with default color.
     * The position of instance is defined as the position
     * of the upper left corner of the circumscribe rectangle
     * and its size is defined as the size of this rectangle.
     * The direction of the triangle is the direction
     * to which the main vertex of the triangle is turned
     *
     * @param x  The horizontal coordinate,
     *           left canvas border has x=0, coordinate increases to the right
     * @param y  The vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     * @param width  The width  of the instance - must be &gt; 0
     * @param height The height of the instance - must be &gt; 0
     * @param direction The direction to which the main vertex will be turned
     */
    public Triangle(int x, int y, int width, int height, Direction8 direction)
    {
        this(x, y, width, height, DEFAULT_COLOR, direction);
    }


    /***************************************************************************
     * Creates a new instance with given position, size, color
     * and direction.
     * The position of instance is defined as the position
     * of the upper left corner of the circumscribe rectangle
     * and its size is defined as the size of this rectangle.
     * The direction of the triangle is the direction
     * to which the main vertex of the triagle is turned
     *
     * @param x  The horizontal coordinate,
     *           left canvas border has x=0, coordinate increases to the right
     * @param y  The vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     * @param width  The width  of the instance - must be &gt; 0
     * @param height The height of the instance - must be &gt; 0
     * @param color  The color of the instance
     * @param direction The direction to which the main vertex will be turned
    */
    public Triangle(int x, int y, int width, int height,
                    NamedColor color, Direction8 direction)
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
        this.dir8  = direction;
    }


    /***************************************************************************
     * Returns a copy of the instance, which means an triangle
     * with the same size, position and color, color and direction.
     *
     * @return The requested copy
     */
    @Override
    public Triangle copy()
    {
        return new Triangle(xPos, yPos, width, height, color, dir8);
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

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
        this.color = color;
        CM.repaint();
    }


    /***************************************************************************
     * Returns the current x coordinate of the instance,
     * which means the horizontal position of the upper left corner
     * of the circumscribe rectangle.
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
     * which means the vertical position of the upper left corner
     * of the circumscribe rectangle.
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
     * Sets new position of the instance (new values of its coordinates).
     * The position of instance is defined as the position
     * of the upper left corner of the circumscribe rectangle.
     *
     * @param x  The newly set horizontal coordinate,
     *           Left canvas border has x=0, coordinate increases to the right
     * @param y  The newly set vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     */
    @Override
    public void setPosition(int x, int y)
    {
        xPos = x;
        yPos = y;
        CM.repaint();
    }


    /***************************************************************************
     * Returns the current width of the instance.
     * The width of the instance is defined as the width
     * of the circumscribe rectangle.
     *
     * @return  The current width of the instance
     */
    @Override
     public int getWidth()
     {
         return width;
     }


    /***************************************************************************
     * Returns the current height of the instance.
     * The height of the instance is defined as the height
     * of the circumscribe rectangle.
     *
     * @return  The current height of the instance
     */
    @Override
     public int getHeight()
     {
         return height;
     }


    /***************************************************************************
     * Sets a new "square" size of the instance, which means
     * it set the specified size to its width as well as to its height.
     * The size of instance is defined as the size
     * of the circumscribe rectangle.
     * The set dimensions must be non-negative,
     * the zero value is substituted by one.
     *
     * @param size The new dimensions of the instance; size &gt;= 0
     */
    public void setSize(int size)
    {
        setSize(size, size);
    }


    /***************************************************************************
     * Sets a new dimensions of the instance.
     * The size of the instance is defined as the size
     * of the circumscribe rectangle.
     * The set dimensions must be non-negative,
     * the zero value is substituted by one.
     *
     * @param width  The new width of the instance;  width  &gt;= 0
     * @param height The new height of the instance; height &gt;= 0
     */
    @Override
    public void setSize(int width, int height)
    {
        if ((width < 0) || (height < 0)) {
            throw new IllegalArgumentException(
                            "The dimensions may not be negativ: width=" +
                            width + ", height=" + height);
        }
        this.width  = Math.max(1, width);
        this.height = Math.max(1, height);
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


    /***************************************************************************
     * Returns the current direction
     * to which the main vertex of the triagle is turned.
     *
     * @return The current direction of the shape
     */
    public Direction8 getDirection()
    {
        return dir8;
    }


    /***************************************************************************
     * Set the new direction to which the main vertex of the triagle is turned.
     *
     * @param newDir8  The requested direction
     */
    public void setDirection(Direction8 newDir8)
    {
        if (newDir8 != Direction8.NOWHERE) {
            dir8 = newDir8;
            CM.repaint();
        }
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
        return name + "[x=" + xPos + ", y=" + yPos +
               ", width=" + width + ", height=" + height +
               ", color=" + color + ", direction=" + dir8 + "]";
    }


    /***************************************************************************
     * Paint the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
    @Override
    public void paint(Painter painter)
    {
        int[][] points = getVertexes();
        painter.fillPolygon(points[0], points[1], color);
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



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * Returns a matrix with coordinates of particular vertexes of the triangle.
     *
     * @return A matrix with coordinates
     */
    private int[][] getVertexes()
    {
        int[] xpoints = null;
        int[] ypoints = null;

        switch(dir8)
        {
            case EAST:
                xpoints = new int[]{ xPos,  xPos + (width),    xPos };
                ypoints = new int[]{ yPos,  yPos + (height/2),  yPos + height };
                break;

            case NORTH_EAST:
                xpoints = new int[]{ xPos,  xPos + width,  xPos + width };
                ypoints = new int[]{ yPos,  yPos,          yPos + height };
                break;

            case NORTH:
                xpoints = new int[]{ xPos,          xPos + (width/2), xPos + width };
                ypoints = new int[]{ yPos + height, yPos,             yPos + height };
                break;

            case NORTH_WEST:
                xpoints = new int[]{ xPos,          xPos,  xPos + width };
                ypoints = new int[]{ yPos + height,  yPos,  yPos         };
                break;

            case WEST:
                xpoints = new int[]{ xPos,              xPos + width, xPos + width };
                ypoints = new int[]{ yPos + (height/2), yPos,         yPos + height };
                break;

            case SOUTH_WEST:
                xpoints = new int[]{ xPos,  xPos,           xPos + width };
                ypoints = new int[]{ yPos,  yPos + height,  yPos + height };
                break;

            case SOUTH:
                xpoints = new int[]{ xPos,  xPos + (width/2),  xPos + width };
                ypoints = new int[]{ yPos,  yPos + height,     yPos,        };
                break;

            case SOUTH_EAST:
                xpoints = new int[]{ xPos,           xPos +width,    xPos + width };
                ypoints = new int[]{ yPos + height,  yPos + height,  yPos         };
                break;

            default:
                throw new IllegalStateException(
                    "Instance points to a no existing direction");
        }
        return new int[][] { xpoints, ypoints };
    }



    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
