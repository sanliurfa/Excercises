/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Shape;

import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.awt.geom.Rectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


/*******************************************************************************
 * Třída {@code SPACE} slouží jako zdroj pomocných tříd pro hru UFO.
 * Sama o sobě pak představuje ekvivalent plátna.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Space
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Počáteční šířka plátna v bodech. */
    public static final int WIDTH_0 = 300;

    /** Počáteční výška plátna v bodech. */
    public static final int HEIGHT_0 = 300;

    /** Počáteční color pozadí plátna. */
    public static final NamedColor BACKGROUND_COLOR = NamedColor.BLACK;

    /** Titulek v záhlaví okna plátna. */
    private static final String TITLE  = "Vesmír s UFO";

    /** Jediná instance třídy Canvas. */
    public static final Space SPACE = new Space();



    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================

    //Z venku neovlivnitelné Atributy pro zobrazeni plátna v aplikačním okně

        /** Aplikační okno animacniho plátna. */
        private JFrame frame;

        /** Instance lokální třídy, která je zřízena proto, aby odstínila
         *  metody svého rodiče JPanel. */
        private JPanel canvasPanel;

        /** Vše se kreslí na obraz - ten se snadněji překreslí. */
        private Image canvasImage;

//        private Image[] obraz   = new Image[2];
//        private int     aktivní = 0;

        /** Kreslítko získané od obrazu plátna, na nějž se vlastně kreslí. */
        private Graphics2D painter;


    //Přímo ovlivnitelné atributy
        private int width;
        private int height;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Jediná metoda umožnující získat odkaz na instanci plátna.
     * Vrací vsak pokaždé odkaz na stejnou instanci, protože tato instance
     * je SPACE. Pokud instance při volaní metody ještě neexistuje,
     * metoda instanci vytvoří.
     *
     * @return Odkaz na instanci třídy Canvas.
     */
    public static Space getSpace()
    {
        SPACE.frame.setVisible(true);
        return SPACE;
    }


    /***************************************************************************
     * Implicitní (a jediný) konstruktor - je volán pouze jednou.
     */
    @SuppressWarnings("serial")
    private Space()
    {
        frame  = new JFrame();          //Vytvoří nové aplikační okno
        frame.setTitle(TITLE);
        frame.setResizable(false);    //Není možné měnit rozměr myši
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent evt) {
                System.exit(0);
            }
        });
        canvasPanel = new JPanel()
        {
            /** Povinně překrývaná abstraktní metoda třídy JPanel. */
            @Override
            public void paint(Graphics g)
            {
                g.drawImage(canvasImage, 0, 0, null);
            }

        };
        frame.setContentPane(canvasPanel);
        setDimension(WIDTH_0, HEIGHT_0);        //Připraví a vykreslí prázdné plátno
    }



    //== ABSTRACT METHODS ======================================================
    //== PŘÍSTUPOVÉ METODY ATRIBUTU INSTANCÍ ===================================

    /***************************************************************************
     * Nastaví viditelnost okna s vesmírem.
     */
    public void setVisible()
    {
        frame.setVisible(true);
        frame.toFront();
    }


    /***************************************************************************
     * Nastaví pro plátno barvu popředí.
     *
     * @param  color  Nastavovaná color popředí
     */
    public void setForegroungColor(NamedColor color)
    {
        painter.setColor(color.getAwtColor());
    }


    /***************************************************************************
     * Vrátí šířku plátna.
     *
     * @return  Aktuální šířka plátna v bodech
     */
    public int getWidth()
    {
        return width;
    }


    /***************************************************************************
     * Vrátí výšku plátna.
     *
     * @return  Aktuální výška plátna v bodech
     */
    public int getHeight()
    {
        return height;
    }


    /***************************************************************************
     * Nastaví nový rozměr plátna zadáním jeho výsky a šířky.
     *
     * @param  width  Nova šířka plátna v bodech
     * @param  height  Nová výška plátna v bodech
     */
    public void setDimension(int width, int height)
    {
        boolean modify;
        do
        {
            this.width = width;
            this.height = height;
            frame.setResizable(true);
            canvasPanel.setPreferredSize(new Dimension(width, height));
            frame.setMaximizedBounds(new Rectangle (width, height));
            frame.pack();
            java.awt.Dimension dim = frame.getSize(null);
            java.awt.Insets    ins = frame.getInsets();
            modify = false;
            if (width < (dim.width - ins.left - ins.right))
            {
                width = dim.width - ins.left - ins.right + 2;
                modify = true;
            }
            if (height < (dim.height - ins.top - ins.bottom))
            {
                height = dim.height - ins.top - ins.bottom;
                modify = true;
            }
        }while (modify);
        canvasImage = canvasPanel.createImage(width+2, height+2);
        painter = (Graphics2D)canvasImage.getGraphics();
        painter.setBackground(BACKGROUND_COLOR.getAwtColor());
        frame.setResizable(false);
        frame.setVisible(true);
        frame.toFront();
        preparePicture();
        clear();
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Vypíše text aktuálním písmem a aktuální barvou pozadí.
     *
     * @param  text   Zobrazovaný text
     * @param  x      x-ová souřadnice textu
     * @param  y      y-ová souřadnice textu
     */
    public void paintString(String text, int x, int y)
    {
        painter.setColor(BACKGROUND_COLOR.getAwtColor());
        painter.drawString(text, x, y);
        //canvasPanel.repaint();
    }


    /***************************************************************************
     * Nakreslí zadaný obrazec a vybarví jej barvou popředí plátna.
     *
     * @param  shape  Kreslený obrazec
     */
    public void fill(Shape shape)
    {
        painter.fill(shape);
        //canvasPanel.repaint();
    }


    /***************************************************************************
     * Překreslí plátno.
     */
    public void repaint()
    {
        canvasPanel.repaint();
    }


    /***************************************************************************
     * Smaže plátno, přesněji smaže všechny obrazce na plátně.
     * Tato metoda by měla býr definována jako metodoa instance,
     * protože je instance singleton,
     * byla metoda pro snazší dostupnost definovaná jako metoda třídy.
     * Jinak by totiž bylo potřeba vytvořit před smazáním plátna jeho instanci.
     */
    public void clear()
    {
        if (SPACE == null) {
            return;
        }
        Color original = painter.getColor();
        painter.setColor(BACKGROUND_COLOR.getAwtColor());
        Shape sh = new Rectangle2D.Double(0, 0, SPACE.width, SPACE.height);
        painter.fill(sh);
        painter.setColor(original);
        //canvasPanel.repaint();
    }


    /***************************************************************************
     * Přihlásí posluchače událostí klávesnice.
     *
     * @param listener Přihlašovaný posluchač
     */
    public void addKeyboardListener(KeyListener listener)
    {
        frame.addKeyListener(listener);
    }



    /***************************************************************************
     * Odhlásí posluchače klávesnice
     *
     * @param listener Odhlašovaný posluchač
     */
    public void removeKeybordListener(KeyListener listener)
    {
        frame.removeKeyListener(listener);
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * Nastaví viditelnost plátna.
     * Při nastavení viditelného plátna je přesune do popředí.
     * Lze ji proto použit i pro přesun již viditelného plátna do popředí.
     *
     * @param visible logická hodnota požadované viditelnost (true=viditelné)
     */
    private void preparePicture()
    {
        canvasImage = canvasPanel.createImage(width, height);
        painter = (Graphics2D)canvasImage.getGraphics();
        painter.setColor(BACKGROUND_COLOR.getAwtColor());
        painter.fillRect(0, 0, width, height);
        painter.setColor(Color.black);
    }



    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
