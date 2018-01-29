/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;

import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.Position;
import cz.pecinovsky.english.lootp.util.Direction8;



/*******************************************************************************
 * Instance of the {@code OShapeRingFactory} class represents factories
 * that can create a rectangular ring.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class OShapeRingFactory implements IRingFactory
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Manager of the canvas on which the instance will be painted. */
    CanvasManager CM = CanvasManager.getInstance();



    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** The number of columns needed for the ring. */
    private final int columnSize;

    /** The number of rows needed for the ring. */
    private final int rowSize;

    /** Starting direction determining, if the racer will run
     *  clockwise or counterclockwise. */
    private final Direction8 direction;



    //== VARIABLE INSTANCE FIELDS ==============================================

     /** Default color of the created rings. */
     private NamedColor defaultColor = NamedColor.BLACK;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a factory creating rectangular rings
     * with the given row and column size and given starting direction.
     * The start is always in the left upper corner of the created ring.
     *
     * @param columnSize Number of columns needed for the ring
     * @param rowSize    number of rows needed for the ring
     * @param direction  The starting direction. There are allowed only the
     *                   {@link Direction8#EAST} or the {@link Direction8#SOUTH}
     */
    public OShapeRingFactory(int columnSize, int rowSize, Direction8 direction)
    {
        this.columnSize = columnSize;
        this.rowSize    = rowSize;
        this.direction  = direction;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Sets the default color for the future rings-
     *
     * @param color The set default color
     * @return The default color before the new was set
     */
    @Override
    public NamedColor setDefaultColor(NamedColor color)
    {
        NamedColor old = defaultColor;
        defaultColor = color;
        return old;
    }


    /***************************************************************************
     * Return the number of columns needed for the ring.
     *
     * @return Number of needed columns
     */
    public int getColumnSize()
    {
        return columnSize;
    }


    /***************************************************************************
     * Return the number of rows needed for the ring.
     *
     * @return Number of needed rows
     */
    public int getRowSize()
    {
        return rowSize;
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Creates a ring with the default color and with the upper left corner
     * at the given field (row/column) position.
     *
     * @param startPosition Field (row/column) position of the upper left corner
     * @return The created ring
     */
    @Override
    public Ring createRing(Position startPosition)
    {
        return createRing(startPosition, defaultColor);
    }


    /***************************************************************************
     * Creates a ring with the given color and with the upper left corner
     * at the given field (row/column) position.
     *
     * @param startPosition Field (row/column) position of the upper left corner
     * @param color         Color of the created ring
     * @return The created ring
     */
    @Override
    public Ring createRing(Position startPosition, NamedColor color)
    {
        RingBuilder builder = new RingBuilder(startPosition, color);
        builder.startTo(direction);
        if (direction == Direction8.SOUTH) {
            completeRing(builder, rowSize-1, columnSize, rowSize, columnSize-1);
        }
        else {
            completeRing(builder, columnSize-1, rowSize, columnSize, rowSize-1);
        }
        return builder.getRing();
    }


    /***************************************************************************
     * Completes the ring with the given builder.
     * The turning direction of the ring is derived from the starting direction.
     *
     * @param builder Builder starting the creation of the ring
     * @param sizes   Number of fields that should be put
     *                in particular directions
     */
    private void completeRing(RingBuilder builder, int... sizes)
    {
        if (sizes.length != 4) {
            throw new IllegalArgumentException(
                    "\nFour sizes should be entered");
        }
        Direction8 currentDirection = direction;
        for (int size : sizes) {
            for (int i=1;   i < size;   i++) {
                builder.continueTo(currentDirection);
            }
            if (direction == Direction8.SOUTH) {
                currentDirection = currentDirection.leftTurn();
            } else {
                currentDirection = currentDirection.rightTurn();
            }
        }
        //The last direction should be turned back because I am
        //at the last but one field and so I should not turn yet
        if (direction == Direction8.SOUTH) {
            currentDirection = currentDirection.rightTurn();
        } else {
            currentDirection = currentDirection.leftTurn();
        }
        builder.closeTo(currentDirection);
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
    }
