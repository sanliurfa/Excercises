/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */


/*******************************************************************************
 * Instance rozhraní {@code ISaucer} představují jsou jednou z částí UFO.
 * Talíře vytváří dipečer a předává je kontruktoru UFO jako parametr.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface ISaucer
{
    //== CONSTANTS =============================================================
    //== DECLARED METHODS ======================================================

    /***************************************************************************
     * Vrátí x-ovou souřadnici středu talíře.
     *
     * @return  x-ová souřadnice.
     */
//    @Override
    public double getX();


    /***************************************************************************
     * Vrátí y-ovou souřadnici středu talíře.
     *
     * @return  y-ová souřadnice.
     */
//    @Override
    public double getY();

    /***************************************************************************
     * Nastaví novou pozici středu talíře.
     *
     * @param x   Nová x-ová pozice instance
     * @param y   Nová y-ová pozice instance
     */
//    @Override
    public void setPosition(double x, double y);


    /***************************************************************************
     * Vykreslí obraz své instance ve vesmíru.
     */
//    @Override
    public void paint();



    //== INHERITED METHODS =====================================================
    //== EMBEDDED DATA TYPES ===================================================
}
