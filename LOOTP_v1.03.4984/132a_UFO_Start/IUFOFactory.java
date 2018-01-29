/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */


/*******************************************************************************
 * Instance rozhraní {@code IUFOFactory} představují továrny,
 * které na požádání vyrobí nové UFO se zadanými parametry.
 * Vyráběná UFO musejí být instancí třídy implementující rozhraní {@link IUFO}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IUFOFactory
{
    //== CONSTANTS =============================================================
    //== DECLARED METHODS ======================================================

    /***************************************************************************
     * Metoda je vyvolána dipečerem poté,
     * co dispečera někdo požádá o přistavení nového UFO.
     * Dispečer vytvoří talíř, umístí jej na startovní rampu a
     * předá jej metodě jako parametr
     * spolu s pořadím vytvářeného UFO v rámci všech dosud vytvořených UFO.
     *
     * @param saucer   Odkaz na talíř tvořící kostru UFO
     * @param order  Pořadí konstruovaného UFO v rámci již vytvořených
     * @return Nová instance rozhraní {@link IUFO}
     */
//    @Override
    public IUFO newUFO(ISaucer saucer, int order);



    //== INHERITED METHODS =====================================================
    //== EMBEDDED DATA TYPES ===================================================
}
