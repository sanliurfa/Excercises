/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */


/*******************************************************************************
 * Instance třídy {@code UFO} simulují dopravní prostředek mimozemšťanů,
 * pomocí nějž se pohybují vesmírem.
 * Úkolem hráče je dopravit všechna UFO ze startovní rampy do hangárů.
 * Cestopu musí dávat pozor, aby nenarazil do planet a jiných UFO.
 * Hráč může ovládat současně tolik UFO, na kolik si troufne.
 * <p>
 * Při první variantě hry žádá hráč o UFO dispečera RDispečer (preferuje
 * přímé ovládání Speedi). Úkolem hráče je požádat dispečera postupně
 * o jednotlivá UFO a přímým zadáváním jejich rychlosti prostřednictvím
 * volání metody setSpeed(int,int);
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
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class UFO implements IUFO
{
    //== CONSTANT CLASS FIELDS =================================================

//     /** Změna tahu při posunutí plynu o jeden stupeň
//      *  (a také při stisku šipky). */
//     public static final double DIF_THRUST = 2;



    //== VARIABLE CLASS FIELDS =================================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    private ISaucer saucer;
    private Number  number;
    private int     order;


    //== VARIABLE INSTANCE FIELDS ==============================================

    private double xThrust, yThrust;
    private double xSpeed,  ySpeed;
    private double xPos,    yPos;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OSTATNÍ METODY TŘÍDY ==================================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Sestaví UFO z talíře tvořícího jeho kostru, a čísla,
     * které odvodí z pořadí v rámci vytvořených UFO.
     *
     * @param saucer   Odkaz na talíř tvořící kostru UFO.
     * @param order  Pořadí konstruovaného UFO v rámci již vytvořených.
     */
    public UFO(ISaucer saucer, int order)
    {
        xPos = saucer.getX();
        yPos = saucer.getY();

        this.saucer                                                                                                                                                                                                                                                                                                                = saucer;
        this.order  = order;
        this.number = new Number(order, xPos, yPos);

        paint();
    }


    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Vrátí pořadové číslo UFO obdržené při konstrukci.
     *
     * @return Požadované pořadové číslo.
     */
    @Override
    public int getOrder()
    {
        return order;
    }


    /***************************************************************************
     * Vrátí aktuální velikost tahu motoru ve vodorovném směru
     * a tím i velikost vodorovného zrychlení, resp. zpomalení UFO.
     * Velikost tahu udává o kolik se změní speed UFO za jednu sekundu.
     *
     * @return  Aktuální velikost tahu. Pro zrychlování doprava je tah kladný,
     *          pro zrychlování doleva je tah záporný.
     */
    @Override
    public double getXAcceleration()
    {
        return xThrust;
    }


    /***************************************************************************
     * Vrátí aktuální velikost tahu motoru ve svislém směru
     * a tím i velikost svislého zrychlení, resp. zpomalení UFO.
     * Velikost tahu udává o kolik se změní speed UFO za jednu sekundu.
     *
     * @return  Aktuální velikost tahu. Pro zrychlování down je tak kladný,
     *          pro zrychlování vzhůry je tah záporný.
     */
    @Override
    public double getYAcceleration()
    {
        return yThrust;
    }


    /***************************************************************************
     * Vrátí aktuální velikost speed ve vodorovném směru,
     * tj. počet bodů, o které se UFO přesune za jednu sekundu.
     *
     * @return  Aktuální velikost rychlosti. Při pohybu doprava je speed
     *          kladná, při pohybu doleva je záporná.
     */
    @Override
    public double getXSpeed()
    {
        return xSpeed;
    }


    /***************************************************************************
     * Vrátí aktuální velikost speed ve svislém směru,
     * tj. počet bodů, o které se UFO přesune za jednu sekundu.
     *
     * @return  Aktuální velikost rychlosti. Při pohybu down je speed kladná,
     *          při pohybu up je záporná.
     */
    @Override
    public double getYSpeed()
    {
        return ySpeed;
    }


    /***************************************************************************
     * Nastaví speed jako počet bodů, o něž se UFO přesune za jednu sekundu.
     *
     * @param x  Požadovaná velikost rychlosti ve vodorovném směru
     *           (kladná čísla doprava, záporná doleva).
     * @param y  Požadovaná velikost rychlosti ve svislém směru
     *           (kladná čísla down, záporná up).
     */
    @Override
    public void setSpeed(double x, double y)
    {
        xSpeed = x;
        ySpeed = y;
    }


    /***************************************************************************
     * Vrátí x-ovou souřadnici pozice instance.
     *
     * @return  x-ová souřadnice.
     */
    @Override
    public double getX()
    {
        return xPos;
    }


    /***************************************************************************
     * Vrátí y-ovou souřadnici pozice instance.
     *
     * @return  y-ová souřadnice.
     */
    @Override
    public double getY()
    {
        return yPos;
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Vrací textovou reprezentaci dané instance
     * používanou především k ladicím účelům.
     *
     * @return Název třídy následovnaý podtržítkem a "rodným číslem" instance.
     */
    @Override
    public String toString()
    {
        return "UFO_"       + order   +
               "(pos["      + xPos    + "," + yPos    +
               "], speed["  + xSpeed  + "," + ySpeed  +
               "], thrust[" + xThrust + "," + yThrust + "])";
    }


    /***************************************************************************
     * Zvětší vodorovný tah motorů a tím i zrychlení (= přírustek rychlosti)
     * o jeden díl maximálního tahu, tj. o DIF_THRUST.
     */
    @Override
    public void right()
    {
        xThrust = xThrust + DIF_THRUST;
    }


    /***************************************************************************
     * Zmenší vodorovný tah motorů a tím i zrychlení (= přírustek rychlosti)
     * o jeden díl maximálního tahu, tj. o DIF_THRUST.
     */
    @Override
    public void left()
    {
        xThrust = xThrust - DIF_THRUST;
    }


    /***************************************************************************
     * Zvětší svislý tah motorů a tím i zrychlení (= přírustek rychlosti)
     * o jeden díl maximálního tahu, tj. o DIF_THRUST.
     */
    @Override
    public void down()
    {
        yThrust = yThrust + DIF_THRUST;
    }


    /***************************************************************************
     * Zmenší svislý tah motorů a tím i zrychlení (= přírustek rychlosti)
     * o jeden díl maximálního tahu, tj. o DIF_THRUST.
     */
    @Override
    public void up()
    {
        yThrust = yThrust - DIF_THRUST;
    }


    /***************************************************************************
     * Zastaví motory (zadá nulový tah) a tím nastaví nulové zrychlení.
     * Od tohoto okamžiku až do přístího zapnutí motorů se bude UFO pohybovat
     * stále stejně rychle.
     */
    @Override
    public void stopEngine()
    {
        xThrust = 0;
        yThrust = 0;
    }


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
     * @param frequency x
     */
    @Override
    public void move(int frequency)
    {
        //Musíme zvýšit speed o odpovídající zlomek velikosti tahu
        //Změní-li se za vteřinu speed o velikost tahu,
        //změní se za (1/frekvence) část vteřiny o (1/frekvence) část tahu
        xSpeed = xSpeed + (xThrust / frequency);
        ySpeed = ySpeed + (yThrust / frequency);

        //Musíme změnit pozici o odpovídající zlomek velikosti rychlosti
        //Změní-li se za vteřinu pozice o velikost rychlosti,
        //změní se za (1/frekvence) část vteřiny o (1/frekvence) část rychlosti
        xPos = xPos + (xSpeed / frequency);
        yPos = yPos + (ySpeed / frequency);

        //Pro talíř i číslo nastavíme novou pozici
        saucer.setPosition(xPos, yPos);
        number.setPosition(xPos, yPos);
    }


    /***************************************************************************
     * Vykreslí obraz své instance ve vesmíru.
     */
    @Override
    public void paint()
    {
        saucer.paint();
        number.paint();
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== VNOŘENÉ A VNITŘNÍ TŘÍDY ===============================================
    //== TESTING CLASSES AND METHODS ===========================================
}
