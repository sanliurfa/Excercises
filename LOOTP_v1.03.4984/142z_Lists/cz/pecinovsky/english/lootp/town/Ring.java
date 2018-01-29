/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;
import cz.pecinovsky.english.lootp.manager.IModular;
import cz.pecinovsky.english.lootp.manager.Painter;

import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.Position;
import cz.pecinovsky.english.lootp.util.Size;


import static cz.pecinovsky.english.lootp.util.Direction8.*;



/*******************************************************************************
 * Instances of class {@code Ring} represent road rings,
 * where the players can travel or race.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Ring implements IModular
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Manager of the canvas on which the instance will be painted. */
    private static final CanvasManager CM = CanvasManager.getInstance();



    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** The road starting road-field. In case of closed road (ring)
     *  the starting field is the same as the final one. */
    private final RoadField startField;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** Ring position, which is the position of the circumscribed rectangle. */
    private Position ringPosition = null;

    /** Relative field position (field offset) of the starting road-field.
     *  This means the position measured relatively to the left top corner
     *  of the circumscribed rectangle. */
    private Position startFieldOffset = null;

    /** Ring field size (size measured in fields),
     *  which is the field size of the circumscribed rectangle. */
    private Size ringFieldSize = null;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    /***************************************************************************
     * Creates the smallest possible ring at the given position.
     * The ring has the square shape, it will have the default, gray color
     * and it will start from its left upper corner to the east (right).
     *
     * @param  startPosition Position of the ring start field
     * @return The created ring
     */
    public static Ring newSquareRing(Position startPosition)
    {
        return new RingBuilder(startPosition)
                   .startTo   (EAST)
                   .continueTo(SOUTH)
                   .continueTo(WEST)
                   .closeTo   (NORTH)
                   .getRing();
    }


    /***************************************************************************
     * Creates an L-shape ring at the given position.
     * The ring will have the given color
     * and it will start from its left upper corner to the south (down).
     *
     * @param  startPosition Position of the ring start field
     * @param  color         Color of the created ring
     * @return The created ring
     */
    public static Ring newLShapeRing(Position startPosition, NamedColor color)
    {
        RingBuilder builder = new RingBuilder(startPosition, color);
        builder.startTo   (SOUTH).continueTo(SOUTH).continueTo(SOUTH)
               .continueTo(EAST ).continueTo(EAST ).continueTo(EAST)
               .continueTo(NORTH).continueTo(NORTH)
               .continueTo(WEST )
               .continueTo(NORTH)
               .continueTo(WEST ).closeTo   (WEST);
        return builder.getRing();
    }



    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a new ring-road beginning at the given road-field.
     *
     * @param startField  The start field of the future road
     */
    public Ring(RoadField startField)
    {
        this.startField = startField;
        int  module       = startField.getModule();
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns the starting block of the ring.
     *
     * @return Ring starting block
     */
    public RoadField getStartField()
    {
        return startField;
    }


    /***************************************************************************
     * Returns the field size of the ring (size measured in fields),
     * which is the field size of the smallest circumscribed rectangle.
     * If it is not yet counted, it counts it,
     * otherwise it returns the previously counted value.
     *
     * @return Field size of the ring
     */
    public Size getFieldSize()
    {
        if (ringFieldSize == null) {
            RoadField field   = startField;
            Position position = startField.getPosition();
            int minx = position.x;
            int miny = position.y;
            int maxx = minx;
            int maxy = miny;
            for (;;) {
                field    = field.getNext();
                position = field.getPosition();
                if (field == startField) {  //All fields were used
                    break;                  //---------->
                }
                //Tests horizontal coordinate
                if (position.x < minx) {
                    minx = position.x;
                } else if (position.x > maxx) {
                    maxx = position.x;
                }
                //Tests vertical coordinate
                if (position.y < miny) {
                    miny = position.y;
                } else if (position.y > maxy) {
                    maxy = position.y;
                }
            }
            //Pixel coordinates are counted, we may count the field coordinates
            int module       = field.getModule();
            ringPosition     = new Position(minx, minx);
            ringFieldSize    = new Size((maxx - minx) / module + 1,
                                        (maxy - miny) / module + 1);
            startFieldOffset = new Position((position.x - minx) / module,
                                            (position.y - miny) / module);
        }
        return ringFieldSize;
    }


    /***************************************************************************
     * Returns the relative field position (offset counted in fields)
     * of the starting road-field.
     * This means the position measured relatively to the left top corner
     * of the circumscribed rectangle.
     *
     * @return Relative field position of the starting road-field
     */
    public Position getStartRelFieldPosition()
    {
        if (startFieldOffset == null) {
            getFieldSize(); //Method counting both the field size and the offset
        }
        return startFieldOffset;
    }


    /***************************************************************************
     * Returns instance of the class {@code Position} with current position.
     * The position of a shape is defined as the position
     * of the upper left corner of its circumscribe rectangle.
     *
     * @return Instance of the class {@code Position} with current position
     */
    @Override
    public Position getPosition()
    {
        if (ringPosition == null) {
            getFieldSize();   //Method counting together field size and offset
        }
        return ringPosition;
    }


    /***************************************************************************
     * Sets a new position of the instance.
     * The position of a shape is defined as the position
     * of the upper left corner of its circumscribe rectangle.
     *
     * @param position The set position
     */
    @Override
    public void setPosition(Position position)
    {
        setPosition(position.x, position.y);
    }


    /***************************************************************************
     * Sets a new position of the instance.
     * The position of a shape is defined as the position
     * of the upper left corner of its circumscribe rectangle.
     *
     * @param x  The newly set horizontal coordinate,
     *           left canvas border has x=0, coordinate increases to the right
     * @param y  The newly set vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     */
    @Override
    public void setPosition(int x, int y)
    {
        Position position = getPosition();
        int dx = x - position.x;
        int dy = y - position.x;
        ringPosition = new Position(position.x + dx, position.y + dy);
        RoadField field = startField;
        CM.stopPainting(); {
            do {
                position = field.getPosition();
                field.setPosition(position.x + dx, position.y + dy);
                field = field.getNext();
            } while(field != startField);
        } CM.returnPainting();
    }


    /***************************************************************************
     * Returns the basic size,
     * from which all the remaining instance sizes are derived.
     *
     * @return Size of the module
     */
    @Override
    public int getModule() {
        return startField.getModule();
    }


    /***************************************************************************
     * Sets the module &ndash; the basic size,
     * from which all the remaining instance sizes are derived.
     *
     * @param newModule The newly set module
     */
    @Override
    public void setModule(int newModule)
    {
        double oldModule = getModule();
        double ratio     = newModule / oldModule;

        CM.stopPainting(); {
            RoadField field = startField;
            //Set the new module and positions to all road fields
            do {
                Position pixelPosition = field.getPosition();

                //Derive its relative position
                double relX = (pixelPosition.x - ringPosition.x);
                double relY = (pixelPosition.y - ringPosition.y);

                //Derive the pixel position from the field position
                field.setPosition(ringPosition.x + (int)(relX * ratio  +  .5),
                                  ringPosition.y + (int)(relY * ratio  +  .5));
                field.setModule(newModule);
                field = field.getNext();
            } while (field != startField);
        } CM.returnPainting();
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    private static final int DO_WHILE=0, FOR=1, WHILE=2;
    /***************************************************************************
     * Paints the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
    @Override
    public void paint(Painter painter)
    {
        int index = DO_WHILE;

        switch (DO_WHILE)
        {
        case DO_WHILE:  paintUsingDoWhile(painter);     return;
        case FOR:       paintUsingFor(painter);         return;
        case WHILE:     paintUsingWhile(painter);       return;

            default:
                throw new RuntimeException("\nUnknown method type: " + index);
        }

//        if (index == DO_WHILE) {
//            paintUsingDoWhile(painter);
//        }
//        else if (index == FOR) {
//            paintUsingFor(painter);
//        }
//        else if (index == WHILE) {
//            paintUsingWhile(painter);
//        }
//        else {
//            throw new RuntimeException("\nUnknown method type: " + index);
//        }
//        return;
    }


    /***************************************************************************
     * Returns a string representation of the object &ndash; its text signature.
     *
     * @return A string representation of the object
     */
    @Override
    public String toString()
    {
        return "Ring_(start=" + startField + ")";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

/***************************************************************************
 * Paints the instance by force of the specified painter.
 * This method uses the do-while loop.
 *
 * @param painter Painter drawing the instance
 */
private void paintUsingDoWhile(Painter painter)
{
    RoadField field = startField;
    do {
        field.paint(painter);
        field = field.getNext();
    } while(field != startField);
}


/***************************************************************************
 * Paints the instance by force of the specified painter.
 * This method uses the for loop.
 *
 * @param painter Painter drawing the instance
 */
private void paintUsingFor(Painter painter)
{
    RoadField field = startField;
    for (;
         field.getNext() != startField;
         field = field.getNext())
    {
        field.paint(painter);
    }
    field.paint(painter);
}


/***************************************************************************
 * Paints the instance by force of the specified painter.
 * This method uses the while loop.
 *
 * @param painter Painter drawing the instance
 */
private void paintUsingWhile(Painter painter)
{
    RoadField field = startField;
    field.paint(painter);
    field = field.getNext();
    while(field != startField) {
        field.paint(painter);
        field = field.getNext();
    }
}



    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
