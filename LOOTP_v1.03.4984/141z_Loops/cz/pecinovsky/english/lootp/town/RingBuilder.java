/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;
import cz.pecinovsky.english.lootp.manager.Multishape;

import cz.pecinovsky.english.lootp.util.Direction8;
import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.Position;



/*******************************************************************************
 * Instances of class {@code RingBuilder} represent builders
 * that are able to build ring compound from the {@link RoadField} instances.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class RingBuilder
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Canvas on which the instance will be painted. */
    CanvasManager CM = CanvasManager.getInstance();

    /** The default road color. */
    private static final NamedColor DEFAULT_COLOR = NamedColor.GRAY;



    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Position, where the first road field will be placed. */
    private final Position startPosition;

    /** Color of the created ring. */
    private final NamedColor color;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** The ring starting field.
     *  When the ring is closed, it is also the last field. */
    private RoadField startField;

    /** The ring end field.
     *  When the ring is closed, it is also the starting field. */
    private RoadField lastField;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a builder that will build the ring
     * with the default color starting at the given position.
     *
     * @param startPosition Starting field position
     */
    public RingBuilder(Position startPosition)
    {
        this(startPosition, DEFAULT_COLOR);
    }


    /***************************************************************************
     * Creates a builder that will build the ring
     * with the given color starting at the given position.
     *
     * @param startPosition Starting field position
     * @param color         Road color
     */
    public RingBuilder(Position startPosition, NamedColor color)
    {
        this.startPosition = startPosition;
        this.color         = color;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns the just created ring.
     *
     * @return Created ring
     */
    public Ring getRing()
    {
        return new Ring(startField);
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Adds the first road-field of the created ring.
     *
     * @param direction Direction in which the field will be driven through
     * @return This instance for chaining the calls
     */
    public RingBuilder startTo(Direction8 direction)
    {
        lastField  = new RoadField(startPosition, direction, color);
        startField = lastField;

        return this;
    }


    /***************************************************************************
     * Adds a next road-field to the created ring.
     *
     * @param direction Direction in which the field will be driven through
     * @return This instance for chaining the calls
     */
    public RingBuilder continueTo(Direction8 direction)
    {
        lastField = new RoadField(lastField, direction);

        return this;
    }


    /***************************************************************************
     * Adds the last, closing road-field to the created ring.
     *
     * @param direction Direction in which the field will be driven through
     * @return This instance for chaining the calls
     */
    public RingBuilder closeTo(Direction8 direction)
    {
        lastField = new RoadField(lastField, direction, startField);

        return this;
    }


    /***************************************************************************
     * Returns a string representation of the object &ndash; its text signature.
     *
     * @return A string representation of the object
     */
    @Override
    public String toString()
    {
        return "StringBuilder_(start=" + startPosition + ", color=" + color +
               ", first=" + startField + ", last=" + lastField + ")";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
