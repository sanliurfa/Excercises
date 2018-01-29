/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.Position;



/*******************************************************************************
 * Instances of the {@code IRingFactory} interface represent factories
 * intended for creating rings, where various vehicles can run.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IRingFactory
{
    //== CONSTANTS =============================================================
    //== DECLARED METHODS ======================================================

    /***************************************************************************
     * Creates a ring with the default color and with the starting field
     * at the given starting position.
     *
     * @param startPosition Starting field position
     * @return The created ring
     */
//    @Override
    public Ring createRing(Position startPosition);


    /***************************************************************************
     * Creates a ring with the given color and with the starting field
     * at the given starting position.
     *
     * @param startPosition Starting field position
     * @param color         Color of the created ring
     * @return The created ring
     */
//    @Override
    public Ring createRing(Position startPosition, NamedColor color);


    /***************************************************************************
     * Sets the default color for the future rings-
     *
     * @param color The set default color
     * @return The default color before the new was set
     */
//    @Override
    public NamedColor setDefaultColor(NamedColor color);



    //== INHERITED METHODS =====================================================
    //== EMBEDDED DATA TYPES ===================================================
}
