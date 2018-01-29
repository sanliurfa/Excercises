/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;
import cz.pecinovsky.english.lootp.manager.Painter;
import cz.pecinovsky.english.lootp.manager.Rectangle;
import cz.pecinovsky.english.lootp.manager.Triangle;

import cz.pecinovsky.english.lootp.util.Area;
import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.Position;
import cz.pecinovsky.english.lootp.util.Direction8;



/*******************************************************************************
 * Instances of class {@code Arrow} represent arrows pointing towards east.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Arrow implements IDirectable
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Default horizontal coordinate. */
    private static final int DEFAULT_X = 0;

    /** Default vertical coordinate. */
    private static final int DEFAULT_Y = 0;

    /** Default module = size of the circumscribed square = arrow length. */
    private static final int DEFAULT_MODULE = 50;

    /** Default color. */
    private static final NamedColor DEFAULT_COLOR = NamedColor.BLACK;

    /** Default direction. */
    private static final Direction8 DEFAULT_DIRECTION = Direction8.EAST;

    /** Canvas on which the instance will be painted. */
    private static final CanvasManager CM = CanvasManager.getInstance();



    //== VARIABLE CLASS FIELDS =================================================

     /** Number of so far created instances. */
     private static int countCreated = 0;



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Identification number of the instance. */
    private final int ID;

    /** Rectangular part representing body of the arrow. */
    private final Rectangle body;

    /** Triangular part representing the head of the arrow. */
    private final Triangle head;

    /** Color of the whole arrow. */
    private final NamedColor color;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** Instance name consisting by default from the class name
     *  and the instance ID. */
    private String name;

    /** Pixel horizontal coordinate of the instance. */
    private int xPos;

    /** Pixel vertical coordinate of the instance. */
    private int yPos;

    /** Pixel size of the circumscribed square of an arrow.
     *  that means a square that just fits the arrow. */
    private int module;

    /** Direction of the arrow. */
    private Direction8 direction;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates an arrow of default size and color
     * which will be placed at the upper left corner.
     */
    public Arrow()
    {
        this(DEFAULT_X, DEFAULT_Y);
    }


    /***************************************************************************
     * Creates an arrow with the  default size and color
     * which will be placed at the given coordinates.
     *
     * @param x  Horizontal coordinate
     * @param y  Vertical coordinate
     */
    public Arrow(int x, int y)
    {
        this(x, y, DEFAULT_COLOR);
    }


    /***************************************************************************
     * Creates an arrow with the default size and the given color
     * which will be placed at the given coordinates.
     *
     * @param x      Horizontal coordinate
     * @param y      Vertical coordinate
     * @param color  The color of the arrow
     */
    public Arrow(int x, int y, NamedColor color)
    {
        this(x, y, DEFAULT_MODULE, color);
    }


    /***************************************************************************
     * Creates an arrow with the given size and the default color
     * which will be placed at the given coordinates.
     *
     * @param x      Horizontal coordinate
     * @param y      Vertical coordinate
     * @param module The size of the created arrow
     */
    public Arrow(int x, int y, int module)
    {
        this(x, y, module, DEFAULT_COLOR);
    }


    /***************************************************************************
     * Creates an arrow with the given size and color
     * which will be placed at the given coordinates.
     *
     * @param x      Horizontal coordinate
     * @param y      Vertical coordinate
     * @param module The size of the created arrow
     * @param color  Arrow color
     */
    public Arrow(int x, int y, int module, NamedColor color)
    {
        this(x, y, module, color, DEFAULT_DIRECTION);
    }


    /***************************************************************************
     * Creates an arrow with the given size and the default color
     * which will be placed at the given coordinates
     * and which point to the given direction.
     *
     * @param x         Horizontal coordinate
     * @param y         Vertical coordinate
     * @param module    The size of the created arrow
     * @param direction Direction to which the arrow points
     */
    public Arrow(int x, int y, int module, Direction8 direction)
    {
        this(x, y, module, DEFAULT_COLOR, direction);
    }


    /***************************************************************************
     * Creates an arrow with the given size and color
     * which will be placed at the given coordinates
     * and which point to the given direction.
     *
     * @param x         Horizontal coordinate
     * @param y         Vertical coordinate
     * @param module    The size of the created arrow
     * @param color     Arrow color
     * @param direction Direction to which the arrow points
     */
    public Arrow(int x, int y, int module, NamedColor color,
                                           Direction8 direction)
    {
        Arrow.countCreated = Arrow.countCreated + 1;
        this.ID = countCreated;

        this.xPos      = x;
        this.yPos      = y;
        this.module    = module;
        this.color     = color;
        this.direction = direction;

        int m2 = module / 2;
        int m3 = module / 3;

        Area ref = new Area(x, y, module, module);
        Area part;

        //Body = Rectangle
        part = new Area(0, m3, m2, m3);
        part = direction.turnInArea(ref, part);
        this.body = new Rectangle(part, color);

        //Head = Triangle
        part = new Area(m2, 0, m2, module);
        part = direction.turnInArea(ref, part);
        this.head = new Triangle(part, color, direction);
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Sets new color of the arrow; it still remembers its previous color.
     *
     * @param color The set color
     */
    public void setColor(NamedColor color)
    {
        body.setColor(color);
        head.setColor(color);
    }


    // Sada přístupových metod vlastnosti: Position ******************************

    /***************************************************************************
     * Returns horizontal coordinate of the instance.
     *
     * @return  Horizontal coordinate
     */
    public int getX()
    {
        return xPos;
    }


    /***************************************************************************
     * Returns vertical coordinate of the instance.
     *
     * @return  Vertical coordinate
     */
    public int getY()
    {
        return yPos;
    }


    /***************************************************************************
     * Returns the current position.
     *
     * @return The current position
     */
    @Override
    public Position getPosition()
    {
        return new Position(getX(), getY());
    }


    /***************************************************************************
     * Sets the new position.
     *
     * @param p The set position
     */
    @Override
    public void setPosition(Position p)
    {
        this.setPosition(p.x, p.y);
    }


    /***************************************************************************
     * Sets the given coordinates.
     *
     * @param x  Horizontal coordinate
     * @param y  Vertical coordinate
     */
    @Override
    public void setPosition(int x, int y)
    {
        int dx = x - getX();
        int dy = y - getY();
        CM.stopPainting(); {
            body.moveRight(dx);
            body.moveDown (dy);
            head.moveRight(dx);
            head.moveDown (dy);
        } CM.returnPainting();
        xPos = x;
        yPos = y;
    }


    /***************************************************************************
     * Returns the basic size from which we will derive all the gauges
     * of the object &ndash; in the case of the arrow it is
     * its length.
     *
     * @return The module (the arrow length)
     */
    @Override
    public int getModule()
    {
        return module;
    }


    /***************************************************************************
     * Sets the basic size from which we will derive all the gauges
     * of the object &ndash; in the case of the arrow it is
     * its length.
     *
     * @param module The set module (the arrow length)
     */
    @Override
    public void setModule(int module)
    {
        int x  = getX();
        int y  = getY();
        int m  = module;
        int m2 = m / 2;
        int m3 = m / 3;

        Area ref = new Area(x, y, m, m);
        Area part;

        CM.stopPainting(); {
            //Body - Rectangle
            part = new Area(0, m3, m2, m3);
            part = direction.turnInArea(ref, part);
            this.body.setArea(part);

            //Head - Triangle
            part = new Area(m2, 0, m2, module);
            part = direction.turnInArea(ref, part);
            this.head.setArea(part);
        } CM.returnPainting();
        this.module = module;
    }


    /***************************************************************************
     * Returns the direction of the arrow.
     *
     * @return Direction of the arrow
     */
    @Override
    public Direction8 getDirection()
    {
//        return head.getDirection();
        return direction;
    }


    /***************************************************************************
     * Turns the arrow in given direction.
     *
     * @param direction  New direction of the arrow
     */
    @Override
    public void setDirection(Direction8 direction)
    {
        this.direction = direction;
        this.head.setDirection(direction);
        this.setModule(module);
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Makes the arrow more transparent.
     */
    public void translucent()
    {
        body.setColor(color.translucent());
        head.setColor(color.translucent());
    }


    /***************************************************************************
     * Restores the original color of the arrow.
     */
    public void restoreColor()
    {
        setColor(color);
    }


    /***************************************************************************
     * Paint the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
    @Override
    public void paint(Painter painter)
    {
        body.paint(painter);
        head.paint(painter);
    }


    /***************************************************************************
     * Returns a text representation (signature) of the instance
     * used especially for debug purpose.
     *
     * @return The asked text representation
     */
    @Override
    public String toString()
    {
        return "Arrow" + ID + "(" + getPosition() + ", module=" + getModule() +
               ", color=" + color + ")";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
