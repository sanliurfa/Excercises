/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;


/*******************************************************************************
 * Instance rozhraní {@code IRace} představují závody
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IRace
{
    //== CONSTANTS =============================================================
    //== DECLARED METHODS ======================================================

    /***************************************************************************
     * Zaregistruje zadaného závodníka, umístí jej na start závodu
     * a přihlásí jej jako posluchače klávesnice.
     *
     * @param závodník Závodník registrující se pro daný závod
     */
//    @Override
    public void register(IRacer závodník);


    /***************************************************************************
     * Prověří, že závodník dojel do sprvávné průběžné cílové pozice.
     * Pokud dojel, připraví další průběžnou pozici, pokud nedojel, čeká dál.
     *
     * @param závodník Závodník hlásící změnu své pozice
     */
//    @Override
    public void checkpoint(IRacer závodník);



    //== INHERITED METHODS =====================================================
    //== EMBEDDED DATA TYPES ===================================================
}
