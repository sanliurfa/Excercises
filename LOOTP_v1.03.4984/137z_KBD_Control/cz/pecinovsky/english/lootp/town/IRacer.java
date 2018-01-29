/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.IControllable;
import cz.pecinovsky.english.lootp.manager.IMovable;



/*******************************************************************************
 * Instances of the {@code IRacer} interface represents racers,
 * which register themselves at races and compete in them.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IRacer extends IDirectable, IControllable
{
    //== CONSTANTS =============================================================
    //== DECLARED METHODS ======================================================

    /***************************************************************************
     * Returns the instance name.
     *
     * @return  Instance name
     */
//    @Override
    public String getName();


    /***************************************************************************
     * Sets new instance name.
     *
     * @param name  New instance name
     */
//    @Override
    public void setName(String name);


    /***************************************************************************
     * Registers the racer at the given race.
     * The racer then should report the reached positions to this race.
     *
     * @param race Race, where the racer registers
     */
//    @Override
    public void registerFor(Race race);



    //== INHERITED METHODS =====================================================
    //== EMBEDDED DATA TYPES ===================================================
}
