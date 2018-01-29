/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */

import java.awt.geom.Ellipse2D;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


/*******************************************************************************
 * Třída {@code Dispatcher} má na starosti vedení hry,
 * při které má uživatel dopravit UFO ze startovní rampy do hangáru.
 * <p>
 * SPACE první variantě uživatel zadává speed UFO přímým voláním metody
 * setSpeed(double,double).
 * <p>
 * Při druhé varianty hry, uživatel zadává tah motorů a tím i zrychlení UFO
 * prostřednictvím kurzorových kláves a mezerníku, kterým motory vypíná.
 * Stiskem číselné klávesy může přepínat které UFO zrovna ovládá.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Dispatcher
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Velikost (=diameter) talíře je mírou všech rozměrů ve vesmíru. */
    public static final int DIAMETER = 20;
//
//    /** Náhrada za přepisování Saucer.DIAMETER pro lenochy. */
//    protected static final int TV = DIAMETER;

    /** Frekvence snímkování = počet překreslení Vesmíru za vteřinu. */
    public static final int FREQUENCY = 8;

    /** Odkaz na okno, ve kterém se všechno kreslí. */
    protected static final Space SPACE = Space.getSpace();

/** Vektor s možnými barvami planet. První tři ale nebudeme používat.
     *  Černá [0] je color vesmíru, takže by nebyla vidět,
     *  Modrá [1] bude color startovní rampy a hangárů a
     *  Červená [2] bude color létajících talířů. */
    public  static final NamedColor spaceColor;
    public  static final NamedColor rampColor;
    public  static final NamedColor ufoColor;



    //== VARIABLE CLASS FIELDS =================================================

    private static Dispatcher dispatcher;



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================

    static
    {
        spaceColor = NamedColor.BLACK;
        rampColor  = NamedColor.CYAN;
        ufoColor   = NamedColor.RED;
    }

    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Továrna, která bude vyrábět požadovaná UFO. */
    private final IUFOFactory ufoFactory;

    /** Počet hangárů, do nichž je třeba postupně umístit jednotlivá UFO. */
    private final int hangar;

    /** Startovací rampa (nultá položka) a přistávací rampy = hangáry. */
    private final Ramp[]   ramps;

    /** Seznam doposud vygenerovaných UFO. */
    private final List<IUFO> ufoList = new ArrayList<IUFO>();

    /** Časovač, který zabezpečí pravidelné, opakované vyvolání metody
     *  run() puštěného filmu. */
    private final Timer timer = new Timer("Dispečer UFO");

    /** Indikuje, zda je v provozu verze ovládané z klávesnice
     *  nebo verze ovládáná přímým voláním metody setSpeed(int,int) */
    private final boolean fromKeyboard;

    /** Svislá souřadnice hangárů. */
    private final int yHangar;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** Aktuální počet vygenerovaných UFO. */
    protected int ufoCount = 0;

    /** Objekt, který ma na starosti korektní zobrazování pohybujících se
     *  objektů. */
    private Film film = null;

    /** Proměnná registrující běh filmu -
     *  zabezpečuje, aby nebylo možno spustit právě běžící film. */
    private boolean filmStop = true;

    /** UFO, které je v danou chvíli ovládané klávesnicí. */
    private IUFO controlledUFO;

    /** Posluchač reagtující na stisky kláves. */
    private Listener listener;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Je-li již vytvořen vesmír s dispečerem, vrátí odkaz na dispečera;
     * není-li ještě vytvořen vesmír s dispečerem, vytvoří vesmír,
     * v němž se budou pohybovat UFO, u horního okraje plátna pro ně
     * připraví startovací rampu a u dolního okraje 5 hangárů
     * a odstartuje hru řízenou pomocí klávesnice.
     *
     * @param factory Továrna, která bude vyrábět požadovaná UFO
     * @return Odkaz na dispečera
     */
    public static Dispatcher getDispatcher(IUFOFactory factory)
    {
        if (dispatcher != null) {
            return dispatcher;
        }
        return getDispatcher(factory, 5, true);
    }


    /***************************************************************************
     * Je-li již vytvořen vesmír s dispečerem, vyvolá výjimku,
     * není-li ještě vytvořen vesmír s dispečerem, vytvoří vesmír,
     * v němž se budou pohybovat UFO a u horního okraje plátna pro ně
     * připraví startovací rampu a u dolního okraje zadaný počet hangárů,
     * zároveň nastaví, bude-li hra ovládaná z klávesnice.
     *
     * @param factory      Továrna, která bude vyrábět požadovaná UFO
     * @param hangars      Požadovaný počet hangárů.
     * @param fromKeyboard  {@code true} = hra bude ovládána z klávesnice
     * @return Odkaz na dispečera
     */
    static Dispatcher getDispatcher(IUFOFactory factory, int hangars,
                                boolean fromKeyboard)
    {
        if (dispatcher != null) {
            throw new IllegalStateException(
                "Může být vytvořen pouze jeden dispečer.");
        }
        dispatcher = new Dispatcher(factory, hangars, fromKeyboard, 0);
        return dispatcher;
    }


    /***************************************************************************
     * Vytvoří vesmír, v němž se budou pohybovat UFO a u spodního okraje plátna
     * pro ně připraví zadaný počet hangárů.
     * Požadovaný počet překážejících planet i cílových hangárů
     * může být omezen.
     *
     * @param hangars      Požadovaný počet hangárů.
     * @param fromKeyword  {@code true} = hra bude ovládána z klávesnice
     * @param planets       Počet náhodně rozmístěných planet.
     * @return Odkaz na dispečera
     */
    private Dispatcher(IUFOFactory factory,
                     int hangars, boolean fromKeyword, int planets)
    {
        this.ufoFactory     = factory;
        this.fromKeyboard = fromKeyword;

        hangar = hangars;
        int dimension = 3*hangar*DIAMETER;
        SPACE.setDimension(dimension, dimension);

        ramps   = new Ramp[hangar+1];

        /*# Vytvořit nový vesmír, v jehož levém horním rohu bude startovací
         *  rampa (čtverec), kam budou přistavována nová ufo, a podél dolního
         *  okraje bude sada očíslovaných hangárů (opět čtverce), kam budou
         *  ufo přistávat. */
        yHangar = SPACE.getHeight() - DIAMETER;
        ramps[0] = new Ramp(0, DIAMETER, DIAMETER);
        for (int h=1,  hx=3*DIAMETER/2;
             h <= hangar;
             h++, hx+=3*DIAMETER)
        {
            ramps[h] = new Ramp(h, hx, yHangar);
        }

        SPACE.repaint();
        start();
    }


    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Vytvoří instanci UFO, umístí jí na startovní rampu
     * v levém dolním rohu plátna zobrazujícího vesmír a vrátí odkaz na ni.
     *
     * @return Odkaz na vytvořené UFO připravené na startovací rampě.
     */
    public IUFO prepareUFO()
    {
        /*# Pro talíř je třeba spočítat správnou pozici na startovní rampě. */
        Saucer saucer = new Saucer(DIAMETER, DIAMETER);
        controlledUFO = ufoFactory.newUFO(saucer, ++ufoCount);
        /* Zařazení do seznamu musí být synchronizováno, aby k němu nemohlo
         * dojít uprostřed procházení seznamem při překreslování vesmíru. */
        synchronized(ufoList) {
            ufoList.add(controlledUFO);
        }
        SPACE.repaint();
        return controlledUFO;
    }


    /***************************************************************************
     * Ukončí multipřesun a tím uvolní procesor.
     */
    public void stop()
    {
        film.cancel();
        filmStop = true;
        if (listener != null)
        {
            SPACE.removeKeybordListener(listener);
            listener = null;
        }
    }


    /***************************************************************************
     * Spustí nový multipřesun.
     */
    public void start()
    {
        if (filmStop)
        {
            //perioda uchováv počet milisekund mezi dvěma snímky
            int period = 1000 / FREQUENCY;
            film = new Film();
            //timer.scheduleAtFixedRate(film, period, period);
            timer.schedule(film, period, period);
            filmStop = false;
            if (fromKeyboard)
            {
                listener = new Listener();
                SPACE.addKeyboardListener(listener);
            }
        }
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * Zkontroluje, je-li UFO v nějakém hangáru a
     * je-li jeho speed menší než 10, tak je v hangáru vystředí
     * a nastaví jeho speed i tah na nulu.
     *
     * @param ufo Kontrolované UFO.
     */
    private void checkout(IUFO ufo)
    {
        //Dostalo se UFO do oblasti hangárů?
        if (Math.abs(ufo.getY() - yHangar) > DIAMETER/2) {
            return;
        }
        //Letí dostatečně pomalu?
        if ((Math.abs(ufo.getXSpeed()) + Math.abs(ufo.getYSpeed())) > DIAMETER) {
            return;
        }
        //Nalétá-li do některého hangáru, požádej hangár, ať je zaparkuje
        double ux = ufo.getX();
        for (int ir=ramps.length;   --ir > 0;)
        {
            if (Math.abs(ramps[ir].getX() - ux) <= DIAMETER/2)
            {
                ramps[ir].park(ufo);
                break;
            }
        }
    }



    //== MEMBER DATA TYPES =====================================================

    //==========================================================================
    /***************************************************************************
     * Společný rodič všech čtverců a elips.
     */
    static abstract class Shape
    {
        double xPos;    //Bodová x-ová souřadnice instance
        double yPos;    //Bodová y-ová souřadnice instance
        int    size;  //velikost v bodech
        NamedColor  color;   //NamedColor instance

        Shape(double x, double y, int size, NamedColor color)
        {
            this.xPos   = x;
            this.yPos   = y;
            this.size = size;
            this.color  = color;
        }


        /***********************************************************************
         * Nakreslí svoji instanci.
         */
        public abstract void paint();


        /***********************************************************************
         * Vrátí x-ovou souřadnici pozice instance.
         *
         * @return  x-ová souřadnice.
         */
        public double getX()
        {
            return xPos;
        }


        /***********************************************************************
         * Vrátí y-ovou souřadnici pozice instance.
         *
         * @return  y-ová souřadnice.
         */
        public double getY()
        {
            return yPos;
        }


        /***********************************************************************
         * Nastaví novou pozici instance.
         *
         * @param x   Nová x-ová pozice instance
         * @param y   Nová y-ová pozice instance
         */
        public void setPosition(double x, double y)
        {
            xPos = x;
            yPos = y;
        }


        /***********************************************************************
         * Vrátí barvu instance.
         *
         * @return  Instance třídy NamedColor definující nastavenou barvu.
         */
        public NamedColor getColor()
        {
            return color;
        }


        /***********************************************************************
         * Nastaví novou barvu instance.
         *
         * @param nová  Požadovaná nová color.
         */
        public void setColor(NamedColor nová)
        {
            color = nová;
            paint();
        }

    }


    //==========================================================================
    /***************************************************************************
     * Ekvivalent třídy Ellipse, pouze s nejnutnějším počtem metod.
     *
     * @return Název třídy následovnaý podtržítkem a "rodným číslem" instance.
     */
    static class Saucer extends Shape implements ISaucer
    {
        Ellipse2D.Double ellipse;

        /***********************************************************************
         * Vytvoří instanci o zadaných parametrech.
         */
        Saucer(double x, double y)
        {
            super(x, y, DIAMETER, NamedColor.RED);
            int r2 = size >> 1;   //Poloviční size
            ellipse = new Ellipse2D.Double(
                (int)xPos-r2, (int)yPos-r2, size, size);
        }


        /***********************************************************************
         * Nakreslí svoji instanci.
         * Při kreslení považuje za svoji pozici střed kruhu.
         */
        @Override
        public void paint()
        {
            SPACE.setForegroungColor(color);
            SPACE.fill(ellipse);
        }


        /***********************************************************************
         * Nakreslí svoji instanci.
         * Při kreslení považuje za svoji pozici střed kruhu.
         */
        @Override
        public void setPosition(double x, double y)
        {
            super.setPosition(x, y);
            int r2 = size >> 1;   //Poloviční size
            ellipse.setFrame((int)xPos-r2, (int)yPos-r2, size,  size);
        }

    }//static class Saucer extends Shape



    //==========================================================================
    /***************************************************************************
     * Instance třídy Film jsou úlohy simulující život vesmíru.
     * Film je definván jako samostatná třída proto, aby jej bylo možno
     * snadno zapnout a vypnout.
     */
    private class Film extends TimerTask
    {
        /***********************************************************************
         * Metoda vyžadovaná rozhraním Runable implementovaným rodičovskou
         * třídou TimerTask - tuto metodu zavolá Timer pokaždé,
         * když se rozhodne spustit další provedení opakovaného úkolu
         * (Timertask) = multipřesunu.
         */
        @SuppressWarnings("empty-statement")
        @Override
        public void run()
        {
            SPACE.clear();
            for (int i=  ramps.length;  --i >= 0;    ramps[i].paint());
            //Při překreslování se nesmí měnit počet objektů v seznamu
            synchronized(ufoList)
            {
                for (int i=ufoList.size();      --i >= 0;)
                {
                    IUFO u = ufoList.get(i);
                    u.move(FREQUENCY);
                    u.paint();
                    checkout(u);
                }
            }//synchronized
            SPACE.repaint();
       }//public void run()

    }//private class Film extends TimerTask



    //==========================================================================
    /***************************************************************************
     * Instance třídy Posluchač slouží jako posluchač klávesnice
     * řídící pohyb UFO v druhé variantě hry.
     */
    private class Listener extends KeyAdapter
    {
        /***********************************************************************
         * Ošetření klávesnice.
         */
        @Override
        public void keyPressed(KeyEvent e)
        {
            //vypiš(e);
            int kc = e.getKeyChar();
            if (('1' <= kc)  &&  (kc <= '9'))
            {
                int iu = kc - '1';  //1. ufo bude v 0. prvku
                if (iu < ufoList.size()) {
                    controlledUFO = ufoList.get(iu);
                }
                return;
            }
            kc = e.getKeyCode();
            if (kc == KeyEvent.VK_ENTER)
            {
                prepareUFO();
                return;
            }
            if (controlledUFO == null) {
                return;
            }
            switch(kc)
            {
                case KeyEvent.VK_DOWN:
                    controlledUFO.down();
                    return;

                case KeyEvent.VK_LEFT:
                    controlledUFO.left();
                    return;

                case KeyEvent.VK_RIGHT:
                    controlledUFO.right();
                    return;

                case KeyEvent.VK_UP:
                    controlledUFO.up();
                    return;

                case KeyEvent.VK_SPACE:
                    controlledUFO.stopEngine();
                    return;
            }//switch
        }

    }//private class Posluchač extends KeyAdapter



    //== TESTING CLASSES AND METHODS ===========================================
}//public class Dispatcher
