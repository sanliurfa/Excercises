/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.Position;


/*******************************************************************************
 * Instance of the {@code LShapeRingFactory} class represents factories
 * that can create an L-shape ring.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class LShapeRingFactory implements IRingFactory
{
    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================

     /** Default color of the created rings. */
     private NamedColor defaultColor = NamedColor.BLACK;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a factory for L-shape rings.
     */
    public LShapeRingFactory()
    {
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
        return Ring.newLShapeRing(startPosition, color);
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
    }
