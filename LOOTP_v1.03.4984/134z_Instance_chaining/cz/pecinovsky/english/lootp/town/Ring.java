/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;
import cz.pecinovsky.english.lootp.manager.IModular;
import cz.pecinovsky.english.lootp.manager.IPaintable;
import cz.pecinovsky.english.lootp.manager.Multishape;
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
public class Ring implements IPaintable
{
    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** The road starting road-field. In case of closed road (ring)
     *  the starting field is the same as the final one. */
    private final RoadField startField;

    /** The shape representing the ring at a canvas. */
    private final Multishape shape;



    //== VARIABLE INSTANCE FIELDS ==============================================
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
     * @param shape       The multishape representing the ring at a canvas
     */
    public Ring(RoadField startField, Multishape shape)
    {
        this.startField = startField;
        this.shape      = shape;
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
        shape.paint(painter);
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


    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
