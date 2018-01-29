/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */

import java.util.ArrayList;
import java.util.List;



/*******************************************************************************
 * Instances of the class {@code Multishape} represents
 * complexes of geometric shapes
 * that are mind for work on a virtual canvas
 * during the first introduction to objects.
 * These shapes can be compound from several simpler shapes
 * that are instances of the interface {@link IShape}.
 * The position of an instance is defined as the position
 * of the upper left corner of the circumscribe rectangle
 * and its size is defined as the size of this rectangle.
 * <p>
 * The multishape is successively composed from the simpler shapes
 * that must be instances of the interface {@link IShape}.
 * There are no other requirements for them.
 * During composition the multishape automatically correct
 * its internal information about its position and size in such a way,
 * that the position steadily points to the upper left corner of the
 * circumscribe rectangle and size corresponds with the size of this rectangle.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Multishape implements IShape
{
    //== CONSTANT CLASS FIELDS =================================================

    /** The canvas manager controlling painting of the instance. */
    private static final CanvasManager CM = CanvasManager.getInstance(false);



    //== VARIABLE CLASS FIELDS =================================================

    /** The number of created instances. */
    private static int count = 0;



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Instance ID = the order of the created instance inside its class. */
    private final int ID = ++count;

    /** Name entered by object construction.
     *  This name allows to specify the particular {@code Multishape}. */
    private final String name;

    /** List of multishape's parts. */
    private final List<Part> parts = new ArrayList<>();



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** While the attribute is {@code true} it is possible
     *  to add another part into the multishape. */
    private boolean creationDone = false;

    /** The x-coordinate of the instance. */
    private int xPos;

    /** The y-coordinate of the instance. */
    private int yPos;

    /** The instance width. */
    protected int width;

    /** The instance height. */
    protected int height;

    /** Příznak kopírovatelnosti daného mnohotvaru. */
    private boolean copyable = true;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates an empty multishape with default name expecting
     * that it parts will be added by calling the method
     * {@link #addShapes(IShape...)}.
     * <p>
     * The completion should be announced by calling the method
     * {@link #creationDone()}.
     * Until the creation is not finished
     * it is not possible to set position and/or size of the created multishape.
     * However it is possible to ask for them
     * and simultaneously to paint the created shape.
     */
    public Multishape()
    {
        this("");
    }


    /***************************************************************************
     * Creates an empty multishape with given name expecting
     * that it parts will be added by calling the method
     * {@link #addShapes(IShape...)}
     * <p>
     * The completion should be announced by calling the method
     * {@link #creationDone()}.
     * Until the creation is not finished
     * it is not possible to set position and/or size of the created multishape.
     * However it is possible to ask for them
     * and simultaneously to paint the created shape.
     *
     * @param name  Name of created multishape.
     *              If an empty string or {@code null} is entered,
     *              the constructor assigns it the name in the form
     *              {@code Multishape#}<i>i</i>, where <i>i</i> is an integer
     */
    public Multishape(String name)
    {
        this(name, null);
    }


    /***************************************************************************
     * Creates a multishape with a default name
     * and consisting from given objects;
     * it is not possible to add other objects to this multishape in the future.
     *
     * @param part1 The first part of the created multishape
     * @param parts Particular parts of the created multishape
     */
    public Multishape(IShape part1, IShape... parts)
    {
        this("", part1, parts);
    }


    /***************************************************************************
     * Creates a multishape with the given name
     * and possibly consisting from given objects;
     * it there are passed creating objects,
     * it is not possible to add other objects to this multishape in the future.
     *
     * @param name  Name of created multishape.
     *              If an empty string or {@code null} is entered,
     *              the constructor assigns it the name in the form
     *              {@code Multishape#}<i>i</i>, where <i>i</i> is an integer
     * @param part1 The first part of the created multishape
     * @param parts Particular parts of the created multishape
     */
    public Multishape(String name, IShape part1, IShape... parts)
    {
        if ((name == null)  ||  name.isEmpty()) {
            name = "Multishape_" + ID;
        }
        this.name = name;

        //If the parts were given, it closes the creation
        if (part1 != null) {
            addShapes(part1);
            addShapes(parts);
            creationDone = true;
        }
    }


    /***************************************************************************
     * Creates a deep copy of the multishape with the same size and position
     * and set it a name in the form {@code OriginalName#?}
     * where the question mark stays for a smallest positive integer
     * making the name unique among multishapes.
     * <p>
     * The term "deep copy" denotes a multishape
     * with the same size and position and with parts
     * that are deep copies of the parts of the original shape.
     *
     * @return The created copy
     */
    @Override
    public Multishape copy()
    {
        if (! copyable) {
            throw new IllegalStateException(
                    "\nDaný mnohotvar není kopírovatelný");
        }
        IShape[] shapeArray = new IShape[parts.size()-1];
        IShape shape1 = (IShape)parts.get(0).shape;
        for (int i = 0; i < shapeArray.length; i++) {
            Part part = parts.get(i+1);
            shapeArray[i] = (IShape)part.shape;
        }
        Multishape copy = new Multishape(getName()+"C", shape1, shapeArray);
        return copy;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Vrátí informaci o tom, je-li daný mnohotvar kopírovatelný.
     *
     * @return Je-li kopírovatelný, vrátí {@code true},
     *         jinak vrátí {@code false}
     */
    public boolean isCopyable()
    {
        return copyable;
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
     * Sets a position of the instance (new values of its coordinates)
     * and moves the instance to this position.
     * All parts are moved at once as one object.
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
        verifyDone();
        int dx = x - getX();
        int dy = y - getY();
        CM.stopPainting(); {
            for (Part part : parts) {
                IChangeable shape = part.shape;
                shape.setPosition(dx + shape.getX(), dy + shape.getY());
            }
            this.xPos = x;    //Position of the whole shape
            this.yPos = y;
        } CM.returnPainting();
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
     * Modifies positions and sizes of all its parts in such a way
     * that despite the new size and position
     * the multishape will keep its look.
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
        verifyDone();
        if ((width < 0) || (height < 0)) {
            throw new IllegalArgumentException(
                            "The dimensions may not be negativ: width=" +
                            width + ", height=" + height);
        }
        CM.stopPainting();{
            //Correct the sizes and positions of particular parts
            for (Part part : parts) {
                part.afterResizing(width, height);
            }
            //Set attributes of the whole multishape
            this.width = Math.max(1, width);
            this.height = Math.max(1, height);
        } CM.returnPainting();
    }


    /***************************************************************************
     * Returns the instance name enterred by construction of the object.
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
               ", ID=" + ID + "]";
    }


    /***************************************************************************
     * Paint the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
    @Override
    public void paint(Painter painter)
    {
        CM.stopPainting(); {
            for (Part part : parts)
            {
                part.shape.paint(painter);
            }
        } CM.returnPainting();
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
     * Finishes the creation of the multishape. After calling this method
     * it will be not possible to add another part in this multishape.
     */
    public void creationDone()
    {
        if (parts.size() < 1) {
            throw new IllegalStateException(
                    "\nThe multishape has to have at least one part");
        }
        creationDone = true;
    }


    /***************************************************************************
     * Adds to this multishape the given shapes and appropriately modifies
     * the internal position and size of this multishape.
     *
     * @param shapes  The added shapes
     */
    public final void addShapes(IShape... shapes)
    {
        if (creationDone) {
            throw new IllegalStateException("\nAttempt to add a shape " +
                    "after finishing the creation of the mutlishape " + name);
        }
        for (IShape shape : shapes) {
            IShape ish = shape.copy();
            addTheShape(ish);
        }
        CM.repaint();
    }


    /***************************************************************************
     * Adds the given shape in the multishape
     * and appropriately modifies the position and size of the multishape.
     *
     * @param shape  The added shape
     */
    public final void addTheShape(IShape shape)
    {
        //asx, asy, asw, ash = x, y, width height of the added shape
        int asx = shape.getX();
        int asy = shape.getY();
        int asw = shape.getWidth();
        int ash = shape.getHeight();

        if (! (shape instanceof ICopyable)) {
            copyable = false;
        }
        if (parts.isEmpty())  //The added shape is the first one
        {
            xPos   = asx;
            yPos   = asy;
            width  = asw;
            height = ash;
            parts.add(new Part(shape));
            return;                     //==========>
        }

        //The added shape is not the first one
        //Remeber the original information for later comparision
        //with the modified one after including the new shape
        int mx = xPos;
        int my = yPos;
        int ms = width;
        int mv = height;
        boolean change = false;

        if (asx < xPos)
        {   //The added shape reach behind the lef border
            width += getX() - asx;
            xPos   = asx;
            change = true;
        }
        if (asy < yPos)
        {   //The added shape reach behind the upper border
            height += yPos - asy;
            yPos   = asy;
            change = true;
        }
        if ((xPos + width) < (asx + asw))
        {   //The added shape reach behind the right border
            width = asx + asw - xPos;
            change = true;
        }
        if ((yPos + height) < (asy + ash))
        {   //The added shape reach behind the bottom border
            height = asy + ash - yPos;
            change = true;
        }
        //Now the attributes xPos, yPos, width a height have values
        //corresponding to the multishape included the added shape

        //If something have changed, I have to recompute all the parts
        if (change) {
            for (Part č : parts) {
                č.afterAddition(mx, my, ms, mv);
            }
        }
        parts.add(new Part(shape));
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * Verify that the creation of shape is finished;
     * if not, it throws the {@code IllegalStateException}.
     *
     * @throws IllegalStateException The creation of the shape is not finished
     */
    private void verifyDone()
    {
        if (creationDone) {
            return;
        }
        Throwable ex = new Throwable();
        StackTraceElement[] aste = ex.getStackTrace();
        String method = aste[1].getMethodName();
        throw new IllegalStateException(
            "\nUnfinished shape cannot run method: " + method);
    }



    //== EMBEDDED AND INNER CLASSES ============================================

    /***************************************************************************
     * Instances of the class serves as crates for auxiliray information
     * for the best change of the multishape size.
     */
    private final class Part
    {
    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================

        /** Part of the multishape. */
        IChangeable shape;

        /** The share of the distance from the left border
         *  in the whole width.*/
        double dx;

        /** The share of the distance from the upper border
         *  in the whole height.*/
        double dy;

        /** The share of the part width in the width of the multishape. */
        double dw;

        /** The share of the part height in the height of the multishape. */
        double dh;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

        /***********************************************************************
         * Creates the crate and remembers current shares of the given shape
         * in the current state of the multishape.
         *
         * @param part Wrapped shape
         */
        Part(IChangeable part)
        {
            this.shape = part;
            int partX      = part.getX();
            int partY      = part.getY();
            int partWidth  = part.getWidth();
            int partHeight = part.getHeight();

            dx = (partX - xPos) / (double)width;
            dy = (partY - yPos) / (double)height;
            dw = partWidth      / (double)width;
            dh = partHeight     / (double)height;
        }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

        /***********************************************************************
         * Updates the saved relative position and size of the part
         * in the whole multishape after adding a new part
         * causing change of the position and/or size of the multishape.
         *
         * @param ox  Original (old) x
         * @param oy  Original (old) y
         * @param ow  Original (old) width
         * @param oh  Original (old) height
         */
        void afterAddition(int ox, int oy, int ow, int oh)
        {
            //Souřadnice se mohou pouze zmenšovat
            dx = (ox - xPos + dx*ow) / width;
            dy = (oy - yPos + dy*oh) / height;

            dw = dw * ow / width;
            dh = dh * oh / height;
        }


        /***********************************************************************
         * Updates the saved relative positions and sizes of this part
         * in the whole multishape after change of its size.
         *
         * @param width  The set width  of whole multishape
         * @param height The set height of whole multishape
         */
        void afterResizing(int width, int height)
        {
            shape.setPosition(
                  (int)Math.round(Multishape.this.xPos + dx*width),
                  (int)Math.round(Multishape.this.yPos + dy*height));
            shape.setSize((int)Math.round(dw*width),
                          (int)Math.round(dh*height));
        }


        /***********************************************************************
         * Returns a string representation of the object.
         *
         * @return A string representation of the object
         */
        @Override
        public String toString()
        {
            return "Part[shape=" + shape + ", dx=" + dx + ", dy=" + dy +
                   ", dw=" + dw + ", dh=" + dh + "]";
        }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
    }



    //== TESTING CLASSES AND METHODS ===========================================
}
