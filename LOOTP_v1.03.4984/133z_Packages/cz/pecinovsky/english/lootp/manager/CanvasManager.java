/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.manager;

import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.IO;
import cz.pecinovsky.english.lootp.util.Position;
import cz.pecinovsky.english.lootp.util.Size;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Toolkit;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;

import java.lang.reflect.InvocationTargetException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Properties;

import javax.imageio.ImageIO;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



/*******************************************************************************
 * Třída <b>{@code CanvasManager}</b> slouží k jednoduchému kreslení
 * na virtuální plátno a případné následné animaci nakreslených obrázků.
 * <p>
 * Třída neposkytuje veřejný konstruktor, protože chce, aby její instance
 * byla jedináček, tj. aby se všechno kreslilo na jedno a to samé plátno.
 * Jediným způsobem, jak získat odkaz na instanci třídy
 * {@code CanvasManager},
 * je volaní její statické metody {@code getInstance()}.
 * </p><p>
 * Třída {@code CanvasManager} funguje jako manažer, který dohlíží
 * na to, aby se po změně zobrazení některého z tvarů všechny ostatní tvary
 * řádně překreslily, aby byly správně zachyceny všechny překryvy
 * a aby se při pohybu jednotlivé obrazce vzájemně neodmazávaly.
 * Aby vše správně fungovalo, je možno použít jeden ze dvou přístupů:</p>
 * <ul>
 *   <li>Manažer bude obsah plátna překreslovat
 *     <b>v pravidelných intervalech</b>
 *     bez ohledu na to, jestli se na něm udála nějaká změna či ne.
 *     <ul>
 *       <li><b>Výhodou</b> tohoto přístupu je to,
 *         že se zobrazované objekty nemusí starat o to,
 *         aby se manažer dozvěděl, že se jejich stav změnil.
 *         </li>
 *       <li><b>Nevýhodou</b> tohoto přístupu je naopak to,
 *         že na neustálé (a často zbytečné) překreslování
 *         manažer spotřebovává jistou část výkonu procesoru,
 *         což může u pomalejších počítačů působit problémy.
 *         <br>&nbsp;
 *       </li>
 *     </ul>
 *   </li>
 *   <li>Manažer překresluje plátno <b>pouze na výslovné požádání</b>.
 *     <ul>
 *       <li><b>Výhodou</b> tohoto přístupu je úspora spotřebovaného výkonu
 *         počítače v období, kdy se na plátně nic neděje.
 *       </li>
 *       <li><b>Nevýhodou</b> tohoto přístupu je naopak to, že kreslené
 *         objekty musí na každou změnu svého stavu upozornit manažera,
 *         aby věděl, že má plátno překreslit.
 *       </li>
 *     </ul>
 *   </li>
 * </ul>
 * <p>
 * Třída {@code CanvasManager} požívá druhou z uvedených strategií,
 * tj. <b>překresluje plátno pouze na požádání</b>.
 * </p><p>
 * Obrazec, který chce být zobrazován na plátně, se musí nejprve přihlásit
 * u instance třídy {@code CanvasManager}, aby jej tato zařadila
 * mezi spravované obrazce (sada metod {@code add&hellip;}).
 * Přihlásit se však mohou pouze instance tříd, které implementují
 * rozhraní {@code IPaintable}.
 * </p><p>
 * Nepřihlášený obrazec nemá šanci býti zobrazen, protože na plátno
 * se může zobrazit pouze za pomoci kreslítka, jež může získat jedině od
 * instance třídy {@code CanvasManager}, ale ta je poskytuje pouze
 * instancím, které se přihlásily do její správy.
 * </p><p>
 * Obrazec, který již dále nemá byt kreslen, se muže odhlásit zavoláním
 * metody {@code remove(IPaintable)}.Zavoláním metody
 * {@code removeAll()} se ze seznamu spravovaných (a tím i z plátna)
 * odstraní všechny vykreslované obrazce.
 * </p><p>
 * Efektivitu vykreslování je možné ovlivnit voláním metody
 * {@code stopPainting()}, která pozastaví překreslování plátna po nahlášených
 * změnách. Její volání je výhodné např. v situaci, kdy je třeba vykreslit
 * obrazec složený z řady menších obrazců a bylo by nevhodné překreslovat
 * plátno po vykreslení každého z nich.
 * </p><p>
 * Do původního stavu převedeme plátno voláním metody {@code returnPainting()},
 * která vrátí vykreslování do stavu před posledním voláním metody
 * {@code stopPainting()}. Nemůže se tedy stát, že by se při zavolání metody
 * {@code stopPainting()} v situaci, kdy je již vykreslování pozastaveno,
 * začalo po následném zavolání {@code returnPainting()} hned vykreslovat.
 * Po dvou voláních {@code returnPainting()} se začne vykreslovat až po
 * dvou zavoláních {@code returnPainting()}.
 * </p><p>
 * Proto plátno pouze žádáme, aby se vrátilo do toho kreslícího stavu,
 * ve kterém bylo v okamžiku, kdy jsme je naposledy žádali o to,
 * aby se přestalo překreslovat. Nemůže se tedy stát, že by se při zavolání
 * metody {@code stopPainting()} v situaci, kdy je již vykreslování
 * pozastaveno, začalo po následném zavolání {@code returnPainting()} hned
 * vykreslovat.
 * </p><p>
 * Každé zavolání metody {@code stopPainting()} musí být doplněno
 * odpovídajícím voláním {@code returnPainting()}. Teprve když poslední
 * {@code returnPainting()} odvolá první {@code stopPainting()}, bude
 * překreslování opět obnoveno.
 * </p>
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public final class CanvasManager
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Application window title. */
    private static final String TITLE_0  = "Managed canvas";

    /** Starting canvas field width. */
    private static final int WIDTH_0 = 6;

    /** Starting canvas field height. */
    private static final int HEIGHT_0 = 6;

    /** Starting canvas background color. */
    private static final NamedColor BACKGROUNG_0 = NamedColor.CREAMY;

    /** Starting grid color. */
    private static final NamedColor GRID_COLOR_0 = NamedColor.BLACK;

    /** Default grid-lines spacing (field siza). */
    private static final int STEP_0 = 50;

    /** Maximal allowed grid-lines spacing (field size). */
    private static final int MAX_FIELD_SIZE = 200;



    //== VARIABLE CLASS FIELDS =================================================

    /** The only instance of the class - singleton. */
    private static volatile CanvasManager CM;



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Application window of the canvas manager. */
    private final JFrame window;

    /** Panel containing the image representing the canvas. */
    private final JPanel canvas;

    /** List of the managed shapes. */
    private final List<IPaintable> paintedObjects = new ArrayList<>();

    /** Velikosti okrajů aplikačního okna. */
    private final Insets insets;



    //== VARIABLE INSTANCE FIELDS ==============================================

    //Fields that cannot be modified from outside

        /**Everything is painted at an image,
         * because it is easier to repaint. */
        private Image canvasImage;

        /**Painter obtained from the image. */
        private Painter painter;

        /**Semaphore protecting from too often repainting.
         * The canvas is repainted only when {@code drawLevel==0}. */
        private int drawLevel = 0;

        /**Flag symbolizing, if the canvas is just painted,
         * and therefor the {@link #stopPainting()} does not work. */
        private boolean drawing = false;

        /**Lines representing the grid. */
        private Line[] horizontals,   verticals;


    //Fields, which values are directly modifiable.

        /**The grid spacing. */
        private int step = STEP_0;

        /**1 = the grid is painted as the last (over shapes),
         * 0 = the grid is not painted,
         * 1 = the grid is painted as the first (under shapes). */
        private int showGrid = -1;

        /**Background color = color of the canvas. */
        private NamedColor backgroundColor = BACKGROUNG_0;

        /**Color of the grid lines. */
        private NamedColor gridColor = GRID_COLOR_0;

        /** Šířka aktivní plochy plátna v udávaná v polích. */
        private int columns = WIDTH_0;

        /** Výška aktivní plochy plátna v udávaná v polích. */
        private int rows = HEIGHT_0;

        /** Šířka aktivní plochy plátna v bodech. */
        private int width = WIDTH_0 * step;

        /** Výška aktivní plochy plátna v bodech. */
        private int height = HEIGHT_0 * step;

        /** Vlastník povolení změny kroku -- není-li {@code null},
         *  je to jediný objekt, který může změnit krok a rozměr plátna. */
        private Object sizeOwner = null;

        /** Pozice plátna na obrazovce - při používání více obrazovek
         *  je občas třeba ji po zviditelnění obnovit. */
        Point position;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS========================================

    /***************************************************************************
     * Metoda umožnující získat odkaz na instanci správce plátna
     * a případně zviditelnit jeho aplikační okno.
     * Vrací vsak pokaždé odkaz na stejnou instanci,
     * protože instance plátna je jedináček.
     * <p>
     * Pokud instance při volaní metody ještě neexistuje,
     * metoda instanci vytvoří.</p>
     *
     * @return Instance třídy {@code CanvasManager}
     */
    public static CanvasManager getInstance()
    {
        return getInstance(true);
    }


    /***************************************************************************
     * Metoda umožnující získat odkaz na instanci správce plátna
     * a současně nastavit, zda má být jeho aplikační okno viditelné.
     * Vrací vsak pokaždé odkaz na stejnou instanci,
     * protože instance plátna je jedináček.
     * <p>
     * Pokud instance při volaní metody ještě neexistuje,
     * metoda instanci vytvoří.</p>
     *
     * @param visible Má-li se zajistit viditelnost instance;
     *                {@code false} aktuálně nastavenou viditelnost nemění
     * @return Instance třídy {@code CanvasManager}
     */
    public static CanvasManager getInstance(boolean visible)
    {
        if (CM == null) {
            synchronized(CanvasManager.class) {
                if (CM == null) {
                    initialize();
                    //TODO Ověřit nutnost následujícího příkazu
                    if (visible) { CM.repaint(); }
                }
            }
        }
        if (visible) {
            CM.setVisible(true);
            //TODO Ověřit nutnost následujícího příkazu
            CM.repaint();
        }
        return CM;
    }


    /***************************************************************************
     * Vytvoří instanci třídy - jedináčka => je volán pouze jednou.
     */
    @SuppressWarnings("serial")
    private CanvasManager()
    {
        window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvas = new JPanel()
        {   /** Overrides parent's abstract method. */
            @Override
            public void paintComponent(Graphics g)
            {
                g.drawImage(canvasImage, 0, 0, null);
            }
        };
        window.setContentPane(canvas);
        window.pack();
        insets = window.getInsets();
//        okno.setVisible(true);
//        okno.setAlwaysOnTop(true);
//        okno.setAlwaysOnTop(false);
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Vrátí maximální možnou bodovou velikost políčka
     * vzhledem k aktuálnímu počtu sloupců a řádků a velikosti obrazovky.
     *
     * @return Maximální možná bodová velikost políčka
     */
    public int getMaxStep()
    {
        return getMaxStepFor(columns, rows);
    }


    /***************************************************************************
     * Vrátí maximální možnou bodovou velikost políčka
     * vzhledem k požadovanému počtu sloupců a řádků a velikosti obrazovky.
     *
     * @param  columns   Požadovan počet sloupců
     * @param  rows      Požadovan počet řádků
     * @return Maximální možná bodová velikost políčka
     */
    public int getMaxStepFor(int columns, int rows)
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int availableWidth   = (screenSize.width - insets.left - insets.right)
                               / columns;
        int availableHeight  = (screenSize.height- insets.top - insets.bottom)
                               / rows;
        return (Math.min(availableWidth, availableHeight));
    }


    /***************************************************************************
     * Vrátí maximální možný počet sloupců plátna
     * vzhledem k aktuálnímu velikosti kroku a obrazovky.
     *
     * @return  Maximální možný počet sloupců plátna
     */
    public int getMaxcColumns()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int availableWidth = screenSize.width - insets.left - insets.right;
        return (availableWidth / step);
    }


    /***************************************************************************
     * Vrátí maximální možný počet řádků plátna
     * vzhledem k aktuálnímu velikosti kroku a obrazovky.
     *
     * @return  Maximální možný počet řádků plátna
     */
    public int getMaxRows()
    {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int availableHeight  = screenSize.height - insets.top - insets.bottom;
        return (availableHeight / step);
    }


    /***************************************************************************
     * Nastaví rozměr plátna zadáním bodové velikosti políčka a
     * počtu políček ve vodorovném a svislém směru.
     * Při velikosti políčka = 1 se vypíná zobrazování mřížky.
     *
     * @param  fieldSize Nová bodová velikost políčka
     * @param  colCount  Nový počet políček vodorovně
     * @param  rowCount  Nový počet políček svisle
     */
    public void setStepAndSize(int fieldSize, int colCount, int rowCount)
    {
        setStepAndSize(fieldSize, colCount, rowCount, null);
    }


    /***************************************************************************
     * Nastaví rozměr plátna zadáním bodové velikosti políčka a
     * počtu políček ve vodorovném a svislém směru.
     * Při velikosti políčka = 1 se vypíná zobrazování mřížky.
     *
     * @param  fieldSize Nová bodová velikost políčka
     * @param  colCount  Nový počet políček vodorovně
     * @param  rowCount  Nový počet políček svisle
     * @param  changer   Objekt, který žádá o změnu rozměru. Jakmile je jednou
     *                   tento objekt nastaven, nesmí již rozměr plátna
     *                   měnit nikdo jiný.
     */
    private synchronized void setStepAndSize(
                                     final int fieldSize,
                                     final int colCount, final int rowCount,
                                     Object changer)
    {
        setStepAndSizeCheckArgs(fieldSize, colCount, rowCount, changer);

        stopPainting(); {
            int oldStep = this.step;
            invokeAndWait(new Runnable() {
                @Override
                public void run()
                {
                    setStepAndSizeInternal(fieldSize, colCount, rowCount);
                }
            }, "setStepAndSizeInternal from setStepAndSize");
            prepareGrid();
        } returnPainting();
//        setVisible(true);
    }


    /***************************************************************************
     * Vrátí vzdálenost čar mřížky = bodovou velikost políčka.
     *
     * @return Bodová velikost políčka
     */
    public int getStep()
    {
        return step;
    }


    /***************************************************************************
     * Nastaví vzdálenost čar mřížky = bodovou velikost políčka.
     * Při velikosti políčka = 1 se vypíná zobrazování mřížky.
     *
     * @param size  Nová bodová velikost políčka
     */
    private void setStep(int size)
    {
        setStepAndSize(size, columns, rows);
    }


    /***************************************************************************
     * Nastaví maximální možnou velikost kroku,
     * aby se plátno ještě vešlo na obrazovku.
     */
    public void setStepToMax()
    {
        setStepAndSize(getMaxStep(), columns, rows);
    }


    /***************************************************************************
     * Vrátí počet sloupců plátna, tj. jeho políčkovou šířku.
     *
     * @return  Aktuální políčková šířka plátna (počet políček vodorovně)
     */
    public int getColumns()
    {
        return columns;
    }


    /***************************************************************************
     * Vrátí bodovou šířku plátna.
     *
     * @return  Aktuální bodová šířka plátna (počet bodů vodorovně)
     */
    public int getWidth()
    {
        return width;
    }


    /***************************************************************************
     * Vrátí počet řádků plátna, tj. jeho políčkovou výšku.
     *
     * @return  Aktuální políčková výška plátna (počet políček svisle)
     */
    public int getRows()
    {
        return rows;
    }


    /***************************************************************************
     * Vrátí bodovou výšku plátna.
     *
     * @return  Aktuální bodová výška plátna (počet bodů svisle)
     */
    public int getHeight()
    {
        return height;
    }


    /***************************************************************************
     * Nastaví rozměr plátna zadáním jeho políčkové výsky a šířky.
     *
     * @param  columns   Nový počet políček vodorovně
     * @param  rows      Nový počet políček svisle
     */
    private void setSize(int columns, int rows)
    {
        setStepAndSize(step, columns, rows);
    }


    /***************************************************************************
     * Vrátí informaci o tom, je-li zobrazována mřížka.
     *
     * @return Mřížka je zobrazována = true, není zobrazována = false.
     */
    public boolean isGridVisible()
    {
    	return (showGrid != 0);
    }


    /***************************************************************************
     * V závislosti na hodnotě parametru nastaví nebo potlačí
     * zobrazování čar mřížky.
     *
     * @param visible  Jestli mřížku zobrazovat.
     */
    public synchronized void setGridVisible(boolean visible)
    {
        setGridVisible(visible, false);
    }


    /***************************************************************************
     * Nastaví má-li se na plátně nastavovat mřížka a pokud ano, tak
     * zda se čáry mřížky budou zobrazovat nad nebo pod zobrazovanými tvary.
     *
     * @param visible  Jestli mřížku zobrazovat.
     * @param over {@code true} má-li se mřížka zobrazovat nad zobrazenými tvary,
     *             {@code false} má-li se zobrazovat pod nimi.
     */
    public synchronized void setGridVisible(boolean visible, boolean over)
    {
        if (visible) {
            if (over) {
                showGrid = 1;
            }
            else {
                showGrid = -1;
            }
        }
        else {
            showGrid = 0;
        }
        prepareGrid();
        repaint();
    }


    /***************************************************************************
     * Poskytuje informaci o aktuální viditelnosti okna.
     *
     * @return Je-li okno viditelné, vrací {@code true},
     *         jinak vrací {@code false}
     */
    private boolean isVisible()
    {
        return window.isVisible();
    }


    /***************************************************************************
     * V závislosti na hodnotě svého parametru
     * nastaví nebo potlačí viditelnost plátna na displeji.
     *
     * @param visible logická hodnota požadované viditelnost (true=viditelné)
     */
    private synchronized void setVisible(final boolean visible)
    {
        boolean repainted = false;
        boolean change    = (isVisible() != visible);
        if (! change) {
            return;                 //==========>
        }
        if (! visible) {
            window.setVisible(false);
            return;                 //==========>
        }

        //Should change to visible
        position = window.getLocation();
        if (EventQueue.isDispatchThread()) {
            setVisibleInternal(visible);
        }
        else {
            Runnable runnable = new Runnable()
            {
                @Override
                public void run()
                {
                    setVisibleInternal(visible);
                }
            };
            EventQueue.invokeLater(runnable);
        }
    }


    /***************************************************************************
     * Vrátí aktuální barvu pozadí.
     *
     * @return  Nastavená barva pozadí
     */
    public NamedColor getBackgroundColor()
    {
        return backgroundColor;
    }


    /***************************************************************************
     * Nastaví pro plátno barvu pozadí.
     *
     * @param  color  Nastavovaná barva pozadí
     */
    public synchronized void setBackgroundColor(NamedColor color)
    {
        backgroundColor = color;
        painter.setBackground(backgroundColor);
        repaint();
    }


    /***************************************************************************
     * Pomocná metoda pro účely ladění aby bylo možno zkontrolovat,
     * ze na konci metody má semafor stejnou hodnotu, jako měl na počátku.
     *
     * @return  Stav vnitřního semaforu: <br>
     *          &gt;0 - nebude se kreslit,<br>
     *             =0 - kreslí se,<br>
     *          &lt;0 - chyba
     */
    private int getDrawLevel()
    {
        return drawLevel;
    }


    /***************************************************************************
     * Vrátí aktuální název v titulkové liště okna plátna.
     *
     * @return  Aktuální název okna
     */
    public String getName()
    {
        return window.getTitle();
    }


    /***************************************************************************
     * Nastaví název v titulkové liště okna plátna.
     *
     * @param name  Nastavovaný název
     */
    public void setName(String name)
    {
        window.setTitle(name);
    }


    /***************************************************************************
     * Nastaví pozici aplikačního okna aktivního plátna na obrazovce.
     *
     * @param x  Vodorovná souřadnice aplikačního okna plátna
     * @param y  Svislá souřadnice aplikačního okna plátna
     */
    public synchronized void setPosition(int x, int y)
    {
        window.setLocation(x, y);
        //TODO Ověřit nutnost následujícího příkazu
        IO.Correction.windowLocation(window);
        position = new Point(x, y);
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Převede instanci na řetězec. Používá se především při ladění.
     *
     * @return Řetězcová reprezentace dané instance.
     */
    @Override
    public String toString()
    {
        return getClass().getName() + "(step=" + step +
                ", width="  + columns   + ", height=" + rows +
                ", background=" + backgroundColor + ")";
    }


    /***************************************************************************
     * Vykreslí všechny elementy.
     */
    public void repaint()
    {
        if (drawing) {    //Právě překresluji - volám nepřímo sám sebe
            return;
        }
        if ((drawLevel == 0)  &&  isVisible())   //Mám kreslit a je proč
        {
            drawing = true;
            synchronized(canvas) {
                painter.fillRectangle(0, 0, width, height,
                                      backgroundColor);
                if ((showGrid < 0)  &&    //Má-li se kreslit pod obrazci
                    (gridColor != backgroundColor))
                {
                    drawGrid();
                }
                for (IPaintable shape : paintedObjects) {
                    shape.paint(painter);
                }
                if (showGrid > 0) {       //Má-li se kreslit nad obrazci
                    drawGrid();
                }
            }

            //Calls to repaint() don’t need to be done
            //from the event-dispatch thread
            canvas.repaint();

            drawing = false;        //Už nekreslím
        }
    }


    /***************************************************************************
     * Potlačí překreslování plátna, přesněji zvýší hladinu potlačení
     * překreslování o jedničku. Návratu do stavu před voláním této metody
     * se dosáhne zavoláním metody {@code returnPainting()}.
     * <p>
     * Metody {@code stopPainting()} a {@code returnPainting()}
     * se tak chovají obdobně jako závorky, mezi nimiž je vykreslování
     * potlačeno.</p>
     */
    public synchronized void stopPainting()
    {
        drawLevel++;
    }


    /***************************************************************************
     * Vrátí překreslování do stavu před posledním voláním metody
     * {@code stopPainting()}. Předcházelo-li proto více volání metody
     * {@code stopPainting()}, začne se překreslovat až po odpovídajím počtu
     * zavolání metody {@code returnPainting()}.
     *
     * @throws IllegalStateException
     *         Je-li metoda volána aniž by předcházelo odpovídající volání
     *         {@code stopPainting()}.
     */
    public synchronized void returnPainting()
    {
        if (drawLevel == 0) {
            throw new IllegalStateException(
                "Vrácení do stavu kreslení musí přecházet zákaz!");
        }
        drawLevel--;
        if (drawLevel == 0)  {
            repaint();
        }
    }


    /***************************************************************************
     * Odstraní zadaný obrazec ze seznamu malovaných.
     * Byl-li obrazec v seznamu, překreslí plátno.
     *
     * @param shape  Odstraňovaný obrazec
     *
     * @return  Byl-li obrazec v seznamu, vrátí {@code true},
     *          nebylo-li do odstraňovat, vrátí {@code false}
     */
    public synchronized boolean remove(IPaintable shape)
    {
        boolean ret = paintedObjects.remove(shape);
        if (ret) {
            repaint();
        }
        return ret;
    }


    /***************************************************************************
     * Vyčisti plátno, tj. vyprázdní seznam malovaných
     * (odstraní z něj všechny obrazce).
     */
    public void removeAll()
    {
        stopPainting(); {
            ListIterator<IPaintable> it = paintedObjects.listIterator();
            while (it.hasNext()) {
                it.next();
                it.remove();
            }
        } returnPainting();
    }


    /***************************************************************************
     * Není-li zadaný obrazec v seznamu malovaných, přidá jej na konec
     * (bude se kreslit jako poslední, tj. na vrchu.
     * Byl-li obrazec opravdu přidán, překreslí plátno.
     * Objekty budou vždy kresleny v getIndexOf, v němž byly přidány do správy,
     * tj. v seznamu parametrů zleva doprava
     * a dříve zaregistrované objekty před objekty zaregistrovanými později.
     *
     * @param  shapes  Přidávané obrazce
     * @return  Počet skutečně přidaných obrazců
     */
    public synchronized int add(IPaintable... shapes)
    {
        int count = 0;
        stopPainting(); {
            for (IPaintable ip : shapes)
            {
                if (! paintedObjects.contains(ip)) {
                    paintedObjects.add(ip);
                    count++;
                }
            }
        } returnPainting();
        setVisible(true);
        return count;
    }


    /***************************************************************************
     * Přidá obrazec do seznamu malovaných tak, aby byl kreslen
     * nad zadaným obrazcem.
     * Pokud již v seznamu byl, jenom jej přesune do zadané pozice.
     *
     * @param  presentShape  Obrazec, který má byt při kreslení pod
     *                       přidávaným obrazcem
     * @param  addedShape    Přidávaný obrazec
     *
     * @return  {@code true} v případě, když byl obrazec opravdu přidán,
     *          {@code false} v případě, když již mezi zobrazovanými byl
     *          a pouze se přesunul do jiné urovné
     */
    public synchronized boolean addAbove(IPaintable presentShape,
                                         IPaintable addedShape)
    {
        boolean newMember = ! paintedObjects.remove(addedShape);
        int where = paintedObjects.indexOf(presentShape);
        if (where < 0)
        {
            throw new IllegalArgumentException(
                "Referenční objekt není na plátně zobrazován!");
        }
        paintedObjects.add(where+1, addedShape);
        repaint();
        setVisible(true);
        return newMember;
    }


    /***************************************************************************
     * Přidá obrazec do seznamu malovaných tak, aby byl kreslen
     * pod zadaným obrazcem.
     * Pokud již v seznamu byl, jenom jej přesune do zadané pozice.
     *
     * @param  presentShape  Obrazec, který má byt při kreslení nad
     *                   přidávaným obrazcem
     * @param  addedShape   Přidávaný obrazec
     *
     * @return  {@code true}  v případě, když byl obrazec opravdu přidán,
     *          {@code false} v případě, když již mezi zobrazovanými byl
     *                        a pouze se přesunul do jiné urovné
     */
    public synchronized boolean addBehind(IPaintable presentShape,
                                          IPaintable addedShape)
    {
        boolean newMember = ! paintedObjects.remove(addedShape);
        int where = paintedObjects.indexOf(presentShape);
        if (where < 0)
        {
            throw new IllegalArgumentException(
                "Referenční objekt není na plátně zobrazován!");
        }
        paintedObjects.add(where, addedShape);
        repaint();
        setVisible(true);
        return newMember;
    }


    /***************************************************************************
     * Přidá obrazec do seznamu malovaných tak, aby byl kreslen
     * nad všemi obrazci.
     * Pokud již v seznamu byl, jenom jej přesune do požadované pozice.
     *
     * @param  addedShape   Přidávaný obrazec
     *
     * @return  {@code true}  v případě, když byl obrazec opravdu přidán,
     *          {@code false} v případě, když již mezi zobrazovanými byl
     *                        a pouze se přesunul do jiné urovné
     */
    private synchronized boolean addToFront(IPaintable addedShape)
    {
        boolean didntContain = ! paintedObjects.remove(addedShape);
        paintedObjects.add(addedShape);
        repaint();
        setVisible(true);
        return didntContain;
    }


    /***************************************************************************
     * Přidá obrazec do seznamu malovaných tak, aby byl kreslen
     * pod zadaným obrazcem.
     * Pokud již v seznamu byl, jenom jej přesune do zadané pozice.
     *
     * @param  addedShape   Přidávaný obrazec
     *
     * @return  {@code true}  v případě, když byl obrazec opravdu přidán,
     *          {@code false} v případě, když již mezi zobrazovanými byl
     *          a pouze se přesunul do jiné urovné
     */
    private synchronized boolean addToBack(IPaintable addedShape)
    {
        boolean didntContain = ! paintedObjects.remove(addedShape);
        paintedObjects.add(0, addedShape);
        repaint();
        setVisible(true);
        return didntContain;
    }


    /***************************************************************************
     * Vrátí getIndexOf zadaného prvku v seznamu kreslených prvků.
     * Prvky se přitom kreslí v rostoucím getIndexOf, takže obrazec
     * s větším poradím je kreslen nad obrazcem s menším poradím.
     * Není-li zadaný obrazec mezi kreslenými, vrátí -1.
     *
     * @param  shape  Objekt, na jehož kreslicí pořadí se dotazujeme
     *
     * @return  Pořadí obrazce; prvý kresleny obrazec má pořadí 0.
     *          Není-li zadaný obrazec mezi kreslenými, vrátí -1.
     */
    private int getIndexOf(IPaintable shape)
    {
        return paintedObjects.indexOf(shape);
    }


    /***************************************************************************
     * Vrátí nemodifikovatelný seznam všech spravovaných obrázků.
     *
     * @return  Požadovaný seznam
     */
    private List<IPaintable> listOfShapes()
    {
        return Collections.unmodifiableList(paintedObjects);
    }


    /***************************************************************************
     * Přihlásí posluchače událostí klávesnice.
     *
     * @param listener  Přihlašovaný posluchač
     */
    private void addKeyboardListener(KeyListener listener)
    {
        window.addKeyListener(listener);
    }


    /***************************************************************************
     * Odhlásí posluchače klávesnice.
     *
     * @param listener  Odhlašovaný posluchač
     */
    private void removeKeyboardListener(KeyListener listener)
    {
        window.removeKeyListener(listener);
    }


    /***************************************************************************
     * Přihlásí posluchače událostí myši.
     *
     * @param listener  Přihlašovaný posluchač
     */
    private void addMouseListener(MouseListener listener)
    {
        window.addMouseListener(listener);
    }


    /***************************************************************************
     * Odhlásí posluchače myši.
     *
     * @param listener  Odhlašovaný posluchač
     */
    private void removeMouseListener(MouseListener listener)
    {
        window.removeMouseListener(listener);
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================

    /***************************************************************************
     * Běží-li ve vlákně událostí, vykoná zadanou akci,
     * v opačném případě ji zařadí do vlákna a počká na její dokončení.
     *
     * @param action Spuštěná akce
     * @param name   Název akce pro kontrolní tisky
     */
    private static void invokeAndWait(Runnable action, String name)
    {
        if (EventQueue.isDispatchThread()) {
            action.run();
            return;
        }
        try {
            EventQueue.invokeAndWait(action);
        }
        catch (InterruptedException | InvocationTargetException ex) {
            throw new RuntimeException( "\nSpuštění akce «" + name +
                      "» ve frontě událostí se nezdařilo", ex);
        }
    }


    /***************************************************************************
     * Přečte parametry z konfiguračního souboru.
     * Tento soubor je umístěn v domovském adresáři uživatele
     * ve složce {@code .rup} v souboru {@code bluej.properties}.
     *
     * @return Pozice, na kterou se má umístit aplikační okno
     */
    private static Point configurationFromFile()
    {
        Point position;

        Properties sysProp = System.getProperties();
        String     userDir = sysProp.getProperty("user.home");
        File       rupFile = new File(userDir, ".rup/bluej.win.setting.properties");
        Properties rupProp = new Properties();
        try {
            try (Reader reader = new FileReader(rupFile)) {
                rupProp.load(reader);
            }
            String sx = rupProp.getProperty("canvas.x");
            String sy = rupProp.getProperty("canvas.y");
            int x = Integer.parseInt(rupProp.getProperty("canvas.x"));
            int y = Integer.parseInt(rupProp.getProperty("canvas.y"));
            position = new Point(x, y);
        }catch(IOException | NumberFormatException e)  {
            position = new Point(0, 0);
        }
        return position;
    }


    /***************************************************************************
     * Inicializuje správce plátna umístěním inicializačního kódu
     * do fronty událostí AWt (AWT Event Queue).
     */
    private static void initialize()
    {
        final Point  position = configurationFromFile();
        final Holder holder   = new Holder();

        Runnable prepCM = new Runnable() {
            @Override public void run()
            {
                prepareCM(position, holder);
            }
        };
        try {
            EventQueue.invokeAndWait(prepCM);
        } catch (InterruptedException | InvocationTargetException ex) {
            StringWriter sw = new StringWriter();
            PrintWriter  pw = new PrintWriter(sw);

            sw.write("\nCreation of CanvasManager doesn't succeed\n");
            ex.printStackTrace(pw);

            String msg = sw.toString();
            System.err.println(msg);
            JOptionPane.showMessageDialog(null, msg);

            System.exit(1);
        }

        //CM is created, we can, we can locate dialogs
        CanvasManager manager = holder.manager;
        int x = manager.window.getX();
        int y = manager.window.getY() + manager.window.getHeight();
        IO.setDialogsPosition(x, y);

        //Vše je hotovo, můžeme atribut inicializovat
        CM = manager;
        //Čáry se mohou vytvořit až po inicializaci správce,
        //protože si o něj třída čar řekne
        CM.prepareGrid();

    }


    /***************************************************************************
     * Prepares a canvas manager and its application window
     * while running in AWT Event Queue.
     *
     * @param position Position of the created application window
     * @param holder   Přepravka pro umístění vraceného odkazu na správce
     */
    private static void prepareCM(Point position, Holder holder)
    {
        CanvasManager manager = new CanvasManager();
        manager.setName(TITLE_0);
        manager.setPosition(position.x, position.y);
        manager.setStepAndSizeInternal(STEP_0, WIDTH_0, HEIGHT_0);

        holder.manager = manager;
    }



    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * Byly-li by čáry mřížky vidět, nakreslí je.
     * Čáry mřížky mají šanci být viděny pokud se mřížka kreslí nad obrazci,
     * anebo pokud se kreslí pod nimi
     * a barva jejích čar se liší od barvy pozadí.
     */
    private void drawGrid()
    {
        if (step > 1) {
            for (int i=0;   i < columns;  ) {
                verticals[i++].paint(painter);
            }
            for (int i=0;   i < rows;  ) {
                horizontals[i++].paint(painter);
            }
        }
    }


    /***************************************************************************
     * Připraví čáry vyznačující jednotlivá pole aktivního plátna.
     * Pokud se čáry kreslit nemají, vyprázdní odkazy na ně.
     */
    private void prepareGrid()
    {
        if ((showGrid != 0)  &&  (step > 1))
        {
            if ((verticals == null)  ||  (verticals.length != columns)) {
                verticals = new Line[columns];
            }
            if ((horizontals == null)  ||
                (horizontals.length != rows))
            {
                horizontals = new Line[rows];
            }
            for (int i=0, x=step;   i < columns;      i++, x+=step) {
                verticals[i] = new Line(x, 0, x, height, gridColor);
            }
            for (int i=0, y=step;   i < rows;   i++, y+=step) {
                horizontals[i] = new Line(0, y, width, y, gridColor);
            }
        }
        else
        {
            //Uvolnění doposud používaných instancí
            verticals   = null;
            horizontals = null;
        }
    }


    /***************************************************************************
     * Zkontroluje, zde se okno po požadovaném nastavení vejde na obrazovku
     * a pokud by mělo vyčuhovat, zeptá se, zda jej má posunout tak,
     * aby bylo celé vidět.
     *
     * @param fieldSize Požadovaná velikost pole
     * @param colCount  Požadovaný počet sloupců
     * @param rowCount  Požadovaný počet řádků
     * @param changer   Objekt požadující změnu
     * @throws IllegalArgumentException Pokud se okno nevejde na obrazovku
     *                                  nebo jsou zadané argumenty nepovolené
     * @throws IllegalStateException Nesmí-li daný objekt měnit rozměr a krok
     */
    private void setStepAndSizeCheckArgs(int fieldSize,
                                         int colCount, int rowCount,
                                         Object changer)
            throws IllegalArgumentException,
                   IllegalStateException
    {
        //Kontrola, jestli rozměry mění ten, kdo je měnit smí
        if ((changer != null)  &&
            (changer != sizeOwner))
        {
            if (sizeOwner == null) {
                sizeOwner = changer;
            } else {
                throw new IllegalStateException(
                    "Změna kroku a rozměru není danému objektu povolena");
            }
        }
        //Ověření korektnosti zadaných parametrů
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int availableWidth   = screenSize.width  - insets.left - insets.right;
        int availableHeight  = screenSize.height - insets.top  - insets.bottom;
        int askedWidth       = fieldSize * colCount;
        int askedHeight      = fieldSize * rowCount;
        if ((fieldSize < 1)  ||
            (colCount  < 2)  ||  (availableWidth  < askedWidth)  ||
            (rowCount  < 2)  ||  (availableHeight < askedHeight))
        {
            throw new IllegalArgumentException(
                "\nWrong size specification: " +
                "\n  step  =" + fieldSize  + " points," +
                "\n  width =" + colCount   +
                   " fields=" + colCount*fieldSize + " points," +
                "\n  height=" + rowCount +
                   " fields=" + rowCount*fieldSize + " points," +
                "\n  screen=" + screenSize.width  + "×" +
                                screenSize.height + " points\n");
        }
        boolean changePosition = false;
        int x = window.getX();
        int y = window.getY();
        if ((x + askedWidth) > availableWidth) {
            changePosition = true;
            x = availableWidth - askedWidth;
        }
        if ((y + askedHeight) > availableHeight) {
            changePosition = true;
            x = availableHeight - askedHeight;
        }
        if (changePosition) {
            window.setLocation(x, y);
        }
    }


    /***************************************************************************
     * Nastaví velikost kroku a políčkové rozměry plátna.
     *
     * @param step      Velikost kroku
     * @param colCount  Počet sloupců
     * @param rowCount  Počet řádků
     */
    private void setStepAndSizeInternal(int step, int colCount, int rowCount)
    {
        width  = colCount * step;
        height = rowCount * step;

        window.setResizable(true);
        canvas.setPreferredSize(new Dimension(width, height));
        window.pack();
        window.setResizable(false);

        canvasImage = canvas.createImage(width, height);
        painter     = new Painter((Graphics2D)canvasImage.getGraphics());
        painter.setBackground(backgroundColor);

        this.step    = step;
        this.columns = colCount;
        this.rows    = rowCount;
        IO.Correction.windowSize(window);
        IO.Correction.windowLocation(window);
    }


    /***************************************************************************
     *
     * @param visible
     */
    private void setVisibleInternal(final boolean visible)
    {
        window.setVisible(visible);
        if (visible)
        {
            //Na WinXP při více obrazovkách po zviditelnění blblo
            //=> bylo třeba znovu nastavit pozici
            window.setLocation(position);

            window.setAlwaysOnTop(true);
            window.toFront();
            repaint();
            window.pack();
            window.setAlwaysOnTop(false);
        }
    }


    /***************************************************************************
     *
     */
    private void setVisible_IWait()
    {
        if (EventQueue.isDispatchThread()) {
            window.setVisible(true);
            window.pack();
            window.setAlwaysOnTop(true);
            window.setAlwaysOnTop(false);
            return;
        }
        Runnable runnable = new Runnable()
        {
            @Override
            public void run()
            {
                window.setVisible(true);
                repaint();
                window.pack();
                window.setAlwaysOnTop(true);
                window.setAlwaysOnTop(false);
            }
        };
        try {
            EventQueue.invokeAndWait(runnable);
        }
        catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            return;
        }
        catch (InvocationTargetException ex) {
            throw new RuntimeException(
                "\nVýjimka vyhozená během nastavování kroku a rozměru", ex);
        }
    }



    //== MEMBER DATA TYPES =====================================================

    /***************************************************************************
     * Přepravka, v níž uzávěr předává vytvořeného správce.
     */
    private static class Holder
    {
        volatile CanvasManager manager;
    }



    //== TESTING CLASSES AND METHODS ===========================================
}
