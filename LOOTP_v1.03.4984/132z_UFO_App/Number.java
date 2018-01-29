/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */


/*******************************************************************************
 * Třída Number k zobrazení poohybujícícho se čísla ve vesmíru.
 * Předpokládá se přitom, že toto number bude identifikovat UFO.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Number
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Posunutí vodorovné souřadnice čísla oproti souřadnici jeho středu. */
    public static final int DX = -3;

    /** Posunutí svislé souřadnice čísla oproti souřadnici jeho středu. */
    public static final int DY = 5;


    //== VARIABLE CLASS FIELDS =================================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /* Oba atributy by měli být konstantní a pak už je jedno,
     * že jsou veřejné. */

    /** Number, které daná instnce představuje. */
    public final int    number;  //Uchovávané number

    /** Textová podoba čísla po převodu na řetězec. Bude se používat tak často,
     *  že je výhodné ji mít uloženou v atributu. */
    public final String cipher;  //Řetězcová podoba čísla



    //== VARIABLE INSTANCE FIELDS ==============================================

    private double x;  //Vodorovná pozice zobrazeného čísla
    private double y;  //Svislá pozice zobrazeného čísla



    //== CLASS GETTERS AND SETTERS =============================================
    //== OSTATNÍ METODY TŘÍDY ==================================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Vytvoří instanci představující zadané number.
     * Instance je se schopna na požádání nakreslit.
     *
     * @param number Number reprezentované danou istancí
     * @param x     Počáteční vodorovná souřadnice
     * @param y     Počáteční svislá souřadnice
     */
    public Number(int number, double x, double y)
    {
        this.number = number;
        this.cipher = "" + number;
        this.x = x + DX;
        this.y = y + DY;
    }


    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Vrátí number reprezentvané danou instancí.
     *
     * @return Number reprezentvané danou instancí
     */
    public int getNumber()
    {
        return number;
    }


    /***************************************************************************
     * Vrátí x-ovou souřadnici pozice instance.
     *
     * @return  x-ová souřadnice.
     */
    public double getX()
    {
        return x - DX;
    }


    /***************************************************************************
     * Vrátí y-ovou souřadnici pozice instance.
     *
     * @return  y-ová souřadnice.
     */
    public double getY()
    {
        return y - DY;
    }


    /***************************************************************************
     * Nastaví novou pozici instance.
     *
     * @param x   Nová x-ová pozice instance
     * @param y   Nová y-ová pozice instance
     */
    public void setPosition(double x, double y)
    {
        this.x = x + DX;
        this.y = y + DY;
    }



    //== PŘEKRYTÉ METODY IMPLEMENTOVANÝCH ROZHRANÍ =============================
    //== PŘEKRYTÉ ABSTRAKTNÍ METODY RODIČOVSKÉ TŘÍDY ===========================
    //== PŘEKRYTÉ KONKRÉTNÍ METODY RODIČOVSKÉ TŘÍDY ============================

    /***************************************************************************
     * Vrací textovou reprezentaci dané instance.
     *
     * @return Textový řetězec představující uchovávané number.
     */
    @Override
    public String toString()
    {
        return cipher;
    }


    //== NOVĚ ZAVEDENÉ METODY INSTANCÍ =========================================

    /***************************************************************************
     * Bezparametrický konstruktor ...
     */
    public void paint()
    {
        Space.SPACE.paintString(cipher, (int)x, (int)y);
    }


    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== VNOŘENÉ A VNITŘNÍ TŘÍDY ===============================================
    //== TESTING CLASSES AND METHODS ===========================================
}
