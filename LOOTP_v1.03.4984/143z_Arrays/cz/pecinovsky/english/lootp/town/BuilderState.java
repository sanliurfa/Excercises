/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;


/*******************************************************************************
 * Instances of the {@code BuilderState} represent particular states,
 * in which an object can be.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public enum BuilderState
{
    /** Ready for start ring building.  */  READY,
    /** Building started, we can add.   */  BUILDING,
    /** The ring was finished (closed). */  FINISHED;
}
