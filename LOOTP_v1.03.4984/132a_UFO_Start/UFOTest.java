/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;


/*******************************************************************************
 * Testovací třída UFOTest slouží ke komplexnímu otestování
 * třídy ...
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class UFOTest
{
    private IUFOFactory factory;
    private Dispatcher  dispatcher;
    private IUFO        ufo;



    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================

    //##########################################################################
    //== KONSTRUKTORY A METODY VRACEJÍCÍ INSTANCE VLASTNÍ TŘÍDY ================
    //##########################################################################
    //== PREPARATION AND CLEANING THE FIXTURE ==================================

    /***************************************************************************
     * Vytvoření přípravku (fixture), tj. sady objektů, s nimiž budou všechny
     * testy pracovat a která se proto vytvoří před spuštěním každého testu.
     */
    @Before
    public void setUp()
    {
        factory = new UFOFactory();
    }


    /***************************************************************************
     * Úklid po testu - tato metoda se spustí po vykonání každého testu.
     */
    @After
    public void tearDown()
    {
    }


    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== VNOŘENÉ A VNITŘNÍ TŘÍDY ===============================================
    //== THE TESTS =============================================================

    /***************************************************************************
     * Testuje základní funkcionalitu vytvořeného UFO.
     * Při spuštění tohoto testu stačí, aby prošel.
     */
    @Test
    public void testUFO()
    {
        final int    TV   = Dispatcher.DIAMETER;
        final double DTAH = IUFO.DIF_THRUST;
        final int    f    = 4;  //frekvence

        double px=TV,  py=TV;   //Pozice
        double rx=0,   ry=0;    //rychlsot
        double tx=0,   ty=0;    //tah

        dispatcher = Dispatcher.getDispatcher(factory, 1, false);
        ufo = dispatcher.prepareUFO();
        //----------------------------------------------------------------------
        Assert.assertEquals("Špatně nastavená vodorovná počáteční souřadnice",
                      px, ufo.getX(), .01);
        Assert.assertEquals("Špatně nastavená svislá počáteční souřadnice",
                      py, ufo.getY(), .01);
        Assert.assertEquals("Špatně nastavená počáteční vodorovná speed",
                      rx, ufo.getXSpeed(), .01);
        Assert.assertEquals("Špatně nastavená počáteční svislá speed",
                      ry, ufo.getYSpeed(), .01);
        Assert.assertEquals("Špatně nastavený počáteční vodorovný tah",
                      tx, ufo.getXAcceleration(), .01);
        Assert.assertEquals("Špatně nastavený počáteční svislý tah",
                      ty, ufo.getXAcceleration(), .01);
        //----------------------------------------------------------------------
        rx = 16;
        ry = 32;
        ufo.setSpeed(rx, ry);
        Assert.assertEquals("Metoda setSpeed špatně nastavuje vodorovnou speed",
                      rx, ufo.getXSpeed(), .01);
        Assert.assertEquals("Metoda setSpeed špatně nastavuje svislou speed",
                      ry, ufo.getYSpeed(), .01);
        ufo.move(1);
        Assert.assertEquals("Metoda Popojeď špatně nastavuje vodorovnou souřadnici" +
                      " při nulovém tahu motorů a jednotkové frekvenci",
                      px+=rx, ufo.getX(), .01);
        Assert.assertEquals("Metoda Popojeď špatně nastavuje svislou souřadnici" +
                      " při nulovém tahu motorů a jednotkové frekvenci",
                      py+=ry, ufo.getY(), .01);
        //----------------------------------------------------------------------
        ufo.left();
        Assert.assertEquals("Metoda vlevo špatně nastavuje vodorovný tah",
                      tx-=DTAH, ufo.getXAcceleration(), .01);
        ufo.left();
        Assert.assertEquals("Metoda vlevo špatně nastavuje vodorovný tah",
                      tx-=DTAH, ufo.getXAcceleration(), .01);
        Assert.assertEquals("Metoda vlevo špatně nastavuje svislý tah",
                      ty, ufo.getYAcceleration(), .01);
        //----------------------------------------------------------------------
        ufo.up();
        Assert.assertEquals("Metoda vzhůru špatně nastavuje svislý tah",
                      ty-=DTAH, ufo.getYAcceleration(), .01);
        ufo.up();
        Assert.assertEquals("Metoda vzhůru špatně nastavuje svislý tah",
                      ty-=DTAH, ufo.getYAcceleration(), .01);
        Assert.assertEquals("Metoda vzhůru špatně nastavuje vodorovný tah",
                      tx, ufo.getXAcceleration(), .01);
        //----------------------------------------------------------------------
        ufo.stopEngine();
        Assert.assertEquals("Metoda vypniMotory nevypíná vodorovný tah",
                      tx=0, ufo.getXAcceleration(), .01);
        Assert.assertEquals("Metoda vypniMotory nevypíná svislý tah",
                      ty=0, ufo.getYAcceleration(), .01);
        //----------------------------------------------------------------------
        ufo.right();
        Assert.assertEquals("Metoda vpravo špatně nastavuje vodorovný tah",
                      tx+=DTAH, ufo.getXAcceleration(), .01);
        ufo.right();
        Assert.assertEquals("Metoda vpravo špatně nastavuje vodorovný tah",
                      tx+=DTAH, ufo.getXAcceleration(), .01);
        ufo.right();
        Assert.assertEquals("Metoda vpravo špatně nastavuje vodorovný tah",
                      tx+=DTAH, ufo.getXAcceleration(), .01);
        Assert.assertEquals("Metoda vpravo špatně nastavuje svislý tah",
                      ty, ufo.getYAcceleration(), .01);
        //----------------------------------------------------------------------
        ufo.down();
        Assert.assertEquals("Metoda dolů špatně nastavuje svislý tah",
                      ty+=DTAH, ufo.getYAcceleration(), .01);
        ufo.down();
        Assert.assertEquals("Metoda dolů špatně nastavuje svislý tah",
                      ty+=DTAH, ufo.getYAcceleration(), .01);
        Assert.assertEquals("Metoda dolů špatně nastavuje vodorovný tah",
                      tx, ufo.getXAcceleration(), .01);
        //----------------------------------------------------------------------
        ufo.move(1);
        Assert.assertEquals("Metoda popojeď ovlivňuje vodorovný tah",
                      tx, ufo.getXAcceleration(), .01);
        Assert.assertEquals("Metoda popojeď ovlivňuje svislý tah",
                      ty, ufo.getYAcceleration(), .01);
        Assert.assertEquals("Metoda Popojeď špatně nastavuje vodorovnou speed" +
                      " při NEnulovém tahu motorů a jednotkové frekvenci",
                      rx+=tx, ufo.getXSpeed(), .01);
        Assert.assertEquals("Metoda Popojeď špatně nastavuje svislou speed" +
                      " při NEnulovém tahu motorů a jednotkové frekvenci",
                      ry+=ty, ufo.getYSpeed(), .01);
        Assert.assertEquals("Metoda Popojeď špatně nastavuje vodorovnou souřadnici" +
                      " při NEnulovém tahu motorů a jednotkové frekvenci",
                      px+=rx, ufo.getX(), .01);
        Assert.assertEquals("Metoda Popojeď špatně nastavuje svislou souřadnici" +
                      " při NEnulovém tahu motorů a jednotkové frekvenci",
                      py+=ry, ufo.getY(), .01);
        //----------------------------------------------------------------------
        ufo.move(f);
        Assert.assertEquals("Metoda Popojeď špatně nastavuje vodorovnou speed" +
                      " při NEnulovém tahu motorů a NEjednotkové frekvenci",
                      rx+=tx/f, ufo.getXSpeed(), .01);
        Assert.assertEquals("Metoda Popojeď špatně nastavuje svislou speed" +
                      " při NEnulovém tahu motorů a NEjednotkové frekvenci",
                      ry+=ty/f, ufo.getYSpeed(), .01);
        Assert.assertEquals("Metoda Popojeď špatně nastavuje vodorovnou souřadnici" +
                      " při NEnulovém tahu motorů a NEjednotkové frekvenci",
                      px+=rx/f, ufo.getX(), .01);
        Assert.assertEquals("Metoda Popojeď špatně nastavuje svislou souřadnici" +
                      " při NEnulovém tahu motorů a NEjednotkové frekvenci",
                      py+=ry/f, ufo.getY(), .01);
    }



    /***************************************************************************
     * Testuje správné nastavení rychlosti UFO.
     */
    @Test
    public void testSpeed()
    {
        Dispatcher disp = Dispatcher.getDispatcher(factory);
        IUFO u1 = disp.prepareUFO();
             u1.setSpeed(10,10);
        IUFO u2 = disp.prepareUFO();
             u2.setSpeed(8,12);
        IUFO u3 = disp.prepareUFO();
             u3.setSpeed(6,12);
        IUFO u4 = disp.prepareUFO();
             u4.setSpeed(4,15);
        IUFO u5 = disp.prepareUFO();
             u5.setSpeed(0,20);
    }


    /***************************************************************************
     * Vytvoří standardnío dispečera a spustí tak hru.
     */
    public void testHra()
    {
        Dispatcher.getDispatcher(factory);
    }

}
