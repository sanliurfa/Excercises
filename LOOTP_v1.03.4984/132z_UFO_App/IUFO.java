/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */


/*******************************************************************************
 * Instance rozhraní {@code IUFO} představují dopravní prostředeky mimozemšťanů,
 * pomocí nichž se pohybují vesmírem.
 * Úkolem hráče je dopravit všechna UFO ze startovní rampy do hangárů.
 * Cestopu musí dávat pozor, aby nenarazil do planet a jiných UFO.
 * Hráč může ovládat současně tolik UFO, na kolik si troufne.
 * <p>
 * Při první variantě hry žádá hráč o UFO dispečera
 * RDispečer (preferuje přímé ovládání Speedi).
 * Úkolem hráče je požádat dispečera postupně o jednotlivá UFO
 * a přímým zadáváním jejich rychlosti prostřednictvím volání metody
 * {@link #setSpeed(double,double)} je přesunout na přistávací rampy.
 * <p>
 * Při druhé variantě hry žádá hráč o UFO dispečera ZDispečer (preferue
 * ovládní pohybu přes Zrychlení). Úkolem hráče je opět převzít od dispečera
 * jednotlivá UFO a dopravit je do hangárů, avšak tentokrát ovlivňuje jejich
 * pohyb přímo klávesami. Stiskem kláves ale nenastavuje speed UFO,
 * ale tah jeho motorů a tím i velikost jeho zrychlení resp. zpomalení.
 * <p>
 * Druhá varianta lépe simuluje state ve vesmíru, kde neexistuje žádné tření,
 * takže při zapnutých motorech lod pořád zrychluje či brzdí a naopak
 * při vypnutých motorech si udržuje konstantní speed.
 * <p>
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IUFO
{
    //== CONSTANTS =============================================================

    /** Změna tahu (a tím i zrychlení) při posunutí plynu o jeden stupeň
     *  (a také při stisku šipky). */
    public static final double DIF_THRUST = 2;



    //== DECLARED METHODS ======================================================

    /***************************************************************************
     * Vrátí pořadové číslo UFO obdržené při konstrukci.
     *
     * @return Požadované pořadové číslo.
     */
//    @Override
    public int getOrder();


    /***************************************************************************
     * Vrátí aktuální velikost tahu motoru ve vodorovném směru
     * a tím i velikost vodorovného zrychlení, resp. zpomalení UFO.
     * Velikost tahu udává o kolik se změní speed UFO za jednu sekundu.
     *
     * @return  Aktuální velikost tahu. Pro zrychlování doprava je tah kladný,
     *          pro zrychlování doleva je tah záporný.
     */
//    @Override
    public double getXAcceleration();


    /***************************************************************************
     * Vrátí aktuální velikost tahu motoru ve svislém směru
     * a tím i velikost svislého zrychlení, resp. zpomalení UFO.
     * Velikost tahu udává o kolik se změní speed UFO za jednu sekundu.
     *
     * @return  Aktuální velikost tahu. Pro zrychlování down je tak kladný,
     *          pro zrychlování vzhůry je tah záporný.
     */
//    @Override
    public double getYAcceleration();


    /***************************************************************************
     * Vrátí aktuální velikost speed ve vodorovném směru,
     * tj. počet bodů, o které se UFO přesune za jednu sekundu.
     *
     * @return  Aktuální velikost rychlosti. Při pohybu doprava je speed
     *          kladná, při pohybu doleva je záporná.
     */
//    @Override
    public double getXSpeed();


    /***************************************************************************
     * Vrátí aktuální velikost speed ve svislém směru,
     * tj. počet bodů, o které se UFO přesune za jednu sekundu.
     *
     * @return  Aktuální velikost rychlosti. Při pohybu down je speed kladná,
     *          při pohybu up je záporná.
     */
//    @Override
    public double getYSpeed();


    /***************************************************************************
     * Nastaví speed jako počet bodů, o něž se UFO přesune za jednu sekundu.
     *
     * @param x  Požadovaná velikost rychlosti ve vodorovném směru
     *           (kladná čísla doprava, záporná doleva).
     * @param y  Požadovaná velikost rychlosti ve svislém směru
     *           (kladná čísla down, záporná up).
     */
//    @Override
    public void setSpeed(double x, double y);


    /***************************************************************************
     * Vrátí x-ovou souřadnici pozice instance.
     *
     * @return  x-ová souřadnice.
     */
//    @Override
    public double getX();


    /***************************************************************************
     * Vrátí y-ovou souřadnici pozice instance.
     *
     * @return  y-ová souřadnice.
     */
//    @Override
    public double getY();


    /***************************************************************************
     * Zvětší vodorovný tah motorů a tím i zrychlení (= přírustek rychlosti)
     * o jeden díl maximálního tahu, tj. o DIF_THRUST.
     */
//    @Override
    public void right();


    /***************************************************************************
     * Zmenší vodorovný tah motorů a tím i zrychlení (= přírustek rychlosti)
     * o jeden díl maximálního tahu, tj. o DIF_THRUST.
     */
//    @Override
    public void left();


    /***************************************************************************
     * Zvětší svislý tah motorů a tím i zrychlení (= přírustek rychlosti)
     * o jeden díl maximálního tahu, tj. o DIF_THRUST.
     */
//    @Override
    public void down();


    /***************************************************************************
     * Zmenší svislý tah motorů a tím i zrychlení (= přírustek rychlosti)
     * o jeden díl maximálního tahu, tj. o DIF_THRUST.
     */
//    @Override
    public void up();


    /***************************************************************************
     * Zastaví motory (zadá nulový tah) a tím nastaví nulové zrychlení.
     * Od tohoto okamžiku až do přístího zapnutí motorů se bude UFO pohybovat
     * stále stejně rychle.
     */
//    @Override
    public void stopEngine();


    /***************************************************************************
     * Nastaví nové souřadnice instance tak,
     * že k současné hodnotě souřadnic přičte aktuální speed.
     * Je-li nastavené nenulové zrychlení (tah motorů), musí nejprve
     * připočíst k rychlosti aktuální zrychlení a tak nastavit
     * její aktuální velikost. Teprve tu může přičíst k hodnotě souřadnic.
     * <p>
     * Při připočítávání zrychlení k rychlosti a rychlosti k pozici je třeba
     * počítat s tím, že Dispčer volá tuto metodu mnohokrát za sekundu.
     * Proto předává jako parametr počet volání za sekundu, aby program věděl,
     * čím má nastavenou velikost zrychlení či rychlosti podělit,
     * aby získal správnou velikost opakovaného přírůstku.
     *
     * @param frequency Frekvence překreslování
     */
//    @Override
    public void move(int frequency);


    /***************************************************************************
     * Vykreslí obraz své instance ve vesmíru.
     */
//    @Override
    public void paint();



    //== INHERITED METHODS =====================================================

    /***************************************************************************
     * Vrací textovou reprezentaci dané instance
     * používanou především k ladicím účelům.
     *
     * @return Název třídy následovnaý podtržítkem a číslem dané instance.
     */
    @Override
    public String toString();



    //== EMBEDDED DATA TYPES ===================================================
}
