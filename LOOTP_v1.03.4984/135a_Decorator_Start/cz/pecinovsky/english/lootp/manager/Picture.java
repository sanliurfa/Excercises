/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.manager;

import cz.pecinovsky.english.lootp.util.Area;
import cz.pecinovsky.english.lootp.util.Direction8;
import cz.pecinovsky.english.lootp.util.Position;
import cz.pecinovsky.english.lootp.util.Size;

import java.awt.Image;
import java.awt.Toolkit;

import java.net.MalformedURLException;
import java.net.URL;
import java.awt.geom.AffineTransform;

//import odkladky.TestObrázek;



/*******************************************************************************
 * Instance třídy {@code Picture} představují obrázky,
 * které je možné načíst ze souborů nebo vytvořit z oblasti plátna.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */

public class Picture implements IChangeable, ICopyable
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Instance třídy {@link CanvasManager} spravující plátno,
     *  na které se všechny tvary kreslí. */
    protected static final CanvasManager CM = CanvasManager.getInstance(false);



    //== VARIABLE CLASS FIELDS =================================================

    /** Celkový počet vytvořených instancí. */
    private static int countCreated = 0;



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Rodné číslo instance (její identifikátor v rámci třídy) je odvozeno
     *  z getIndexOf jejího vytvoření. */
    protected final int ID = ++countCreated;

    /** Obalený obrázek. */
    private final Image image;

    /** Rozměry originálního obrázku. */
    private final int origWidth, origHeight;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** Afinní transformace zodpovědná za změny velikosti a pozice obrázku.
     *  Nastavuje se při změnách pozice, rozměru a natočení
     *  a používá se při překreslování objektu. */
    AffineTransform aft;

    /** Název instance sestávající implicitně z jednoduchého názvu třídy
     *  následovaným potržítkem a {@code ID} instance */
    private String name = "Obrázek_" + ID;

    /** Směr, do nějž je daný mnohotvar natočen. */
    private Direction8 initialDirection = Direction8.NORTH;

    /** Směr, do nějž je daný mnohotvar natočen. */
    private Direction8 direction = initialDirection;

    /** Příznak toho, že je již výchozí směr nastaven či použit. */
    private boolean directionSet;

    /** Bodová x-ová souřadnice instance. */
    private int xPos;

    /** Bodová y-ová souřadnice instance. */
    private int yPos;

    /** Šířka v bodech. */
    protected int width;

    /** Výška v bodech. */
    protected int height;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Přečte ze zadaného souboru obrázek, který bude kreslit
     * na zadaných souřadnicích; pomocí úvodních hvězdiček
     * je možno zadat, zda se daný soubor bude hledat ve složce
     * balíčku třídy volající metody (pak musí jméno předcházet *&#47;),
     * nebo ve složce kořenového balíčku (pak musí předcházet **&#47;);
     *
     * @param x    Vodorovná souřadnice levého horního rohu obrázku
     * @param y    Svislá souřadnice levého horního rohu obrázku
     * @param file Název souboru, v němž je obrázek uložen
     */
    public Picture(int x, int y, String file)
    {
        this(x, y, file, null);
    }


    /***************************************************************************
     * Přečte ze zadané URL adresy obrázek, který bude kreslit
     * na zadaných souřadnicích; pomocí úvodních hvězdiček
     * je možno zadat, zda se daný soubor bude hledat ve složce
     * balíčku třídy volající metody (pak musí jméno předcházet *&#47;),
     * nebo ve složce kořenového balíčku (pak musí předcházet **&#47;);
     *
     * @param x    Vodorovná souřadnice levého horního rohu obrázku
     * @param y    Svislá souřadnice levého horního rohu obrázku
     * @param url  URL adresa obrázku
     */
    public Picture(int x, int y, URL url)
    {
        this(x, y, null, Toolkit.getDefaultToolkit().getImage(url));
    }


    /***************************************************************************
     * Vytvoří nový obrázek ze zadaného obrázku - instance třídy
     * {@code java.awt.Image} a umístí jej do počátku.
     *
     * @param x      Vodorovná souřadnice levého horního rohu obrázku
     * @param y      Svislá souřadnice levého horního rohu obrázku
     * @param image  Instance třídy {@code java.awt.Image},
     *               která bude základem obrázku.
     */
    public Picture(int x, int y, Image image)
    {
        this(x, y, null, image);
    }


    /***************************************************************************
     * Přečte ze zadaného souboru obrázek, který bude kreslit
     * na zadaných souřadnicích; pomocí úvodních hvězdiček
     * je možno zadat, zda se daný soubor bude hledat ve složce balíčku třídy
     * volající metody (pak musí jméno předcházet *&#47;),
     * nebo ve složce kořenového balíčku (pak musí předcházet **&#47;);
     *
     * @param x         Vodorovná souřadnice levého horního rohu obrázku
     * @param y         Svislá souřadnice levého horního rohu obrázku
     * @param fileName  Název souboru, v němž je obrázek uložen
     * @param image     Instance třídy {@code java.awt.Image},
     *                  která bude základem obrázku.
     */
    private Picture(int x, int y, String fileName, Image image)
    {
        //Test platnosti parametru
        if ((x<0) || (y<0)) {
            throw new IllegalArgumentException(
                "\nParametry nemají povolené hodnoty: x=" + x + ", y=" + y);
        }
        //Parametry akceptovány --> můžeme tvořit
        this.xPos  = x;
        this.yPos  = y;
        if (image != null) {
            this.image = image;
        } else {
            URL url;
            if (fileName.charAt(0) == '*') {
                if (fileName.charAt(1) == '*') {
                    String jméno = fileName.substring(3);
                    url = getClass().getClassLoader().getResource(jméno);
                } else {
                    Throwable t = new Throwable();
                    StackTraceElement ste = t.getStackTrace()[1];
                    String clsn = ste.getClassName();
                    Class<?> clss;
                    try{ clss = Class.forName(clsn);
                    } catch(ClassNotFoundException exc) {
                        throw new RuntimeException(
                            "\nNěco se podělalo - nenašel existující třídu " +
                            clsn, exc);
                    }
                    String fileNameString = fileName.substring(2);
                    url = clss.getResource(fileNameString);
                }
            }else {
                try {
                    url = new URL(fileName);
                } catch(MalformedURLException exc) {
                    throw new RuntimeException(
                            "\nNepodařilo se načíst obrázek v souboru " +
                            fileName, exc);
                }
            }
            this.image = Toolkit.getDefaultToolkit().getImage(url);
        }
        origWidth   = this.image.getWidth (Painter.IMG_OBSERVER);
        origHeight  = this.image.getHeight(Painter.IMG_OBSERVER);
        this.width  = origWidth;
        this.height = origHeight;
    }


    /***************************************************************************
     * Vrátí kopii daného tvaru,
     * tj. stejný obrázek, stejně velký a stejně umístěný.
     *
     * @return Požadovaná kopie
     */
    @Override
    public Picture copy()
    {
        Picture picture = new Picture(getX(), getY(), image);
        picture.setInitialDirection(initialDirection);
        picture.setSize(getWidth(), getHeight());
        picture.setDirection(direction);
        return picture;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Vrátí směr, do nějž je daná instance natočena.
     *
     * @return Směr, do nějž je daná instance natočena
     */
//    @Override
    public Direction8 getDirection()
    {
        directionSet = true;
        return direction;
    }


    /***************************************************************************
     * Zadá výchozí směr, do nějž je instance natočena.
     * Tato metoda obrázkem neotáčí, pouze nastavují výchozí směr.
     * Smí se zavolat pouze jednou a musí to být před tím,
     * než bude poprvé zavolána metoda {@link #setDirection(Direction8)}.
     *
     *
     * @param initialDirection Nastavovaný výchozí směr instance
     * @return Odkaz na instanci, aby bylo možno metodu zavolat
     *         jakou součást volání konstruktoru, což je doporučovaný postup
     * @throws IllegalStateException Pokud byl počáteční směr již nastaven
     *                               nebo použit
     */
    public synchronized Picture setInitialDirection(Direction8 initialDirection)
    {
        if (directionSet) {
            throw new IllegalStateException(
                      "\nPočáteční směr už byl nastaven nebo použit");
        }
        verifyRequest(initialDirection);
        this.direction = this.initialDirection = initialDirection;
        return this;
    }


    /***************************************************************************
     * Otočí instanci do zadaného směru.
     * Souřadnice obrázku se otočením nezmění.
     *
     * @param direction Směr, do nějž má být obrázek otočen
     */
//    @Override
    public void setDirection(Direction8 direction)
    {
        directionSet = true;
        if (this.direction == direction) {
            return;
        }
        else {
            verifyRequest(direction);
            setDirSize(direction, getWidth(), getHeight());
            CM.repaint();
        }
    }


    /***************************************************************************
     * Vrátí název instance - implicitně name třídy následovaný ID instance.
     *
     * @return  Řetězec s názvem instance
     */
     public String getName()
     {
        return name;
     }


    /***************************************************************************
     * Nastaví nový name instance.
     *
     * @param name  Řetězec s novým názvem instance
     */
    public void setName(String name)
    {
        this.name = name;
    }


    /***************************************************************************
     * Vrátí x-ovou souřadnici pozice instance.
     *
     * @return  x-ová souřadnice
     */
    public int getX()
    {
        return xPos;
    }


    /***************************************************************************
     * Vrátí y-ovou souřadnici pozice instance.
     *
     * @return  y-ová souřadnice
     */
    public int getY()
    {
        return yPos;
    }


    /***************************************************************************
     * Vrátí instanci třídy Position s pozicí instance.
     *
     * @return   Position s pozicí instance
     */
    @Override
    public Position getPosition()
    {
        return new Position(getX(), getY());
    }


    /***************************************************************************
     * Nastaví novou pozici instance.
     *
     * @param x  Nově nastavovaná vodorovná (x-ová) souřadnice instance,
     *           x=0 má levý okraj plátna, souřadnice roste doprava
     * @param y  Nově nastavovaná svislá (y-ová) souřadnice instance,
     *           y=0 má horní okraj plátna, souřadnice roste dolů
     */
    @Override
    public void setPosition(int x, int y)
    {
        if (aft != null) {
            aft = new AffineTransform(aft.getScaleX(), aft.getShearY(),
                                      aft.getShearX(), aft.getScaleY(), x, y);
        }
        xPos = x;
        yPos = y;
        CM.repaint();
    }


    /***************************************************************************
     * Nastaví novou pozici instance.
     *
     * @param pozice   Nová pozice instance
     */
    @Override
    public void setPosition(Position pozice)
    {
        setPosition(pozice.x, pozice.y);
    }


    /***************************************************************************
     * Vrátí šířku instance.
     *
     * @return  width instance v bodech
     */
     public int getWidth()
     {
         return width;
     }


    /***************************************************************************
     * Vrátí výšku instance.
     *
     * @return  height instance v bodech
     */
     public int getHeight()
     {
         return height;
     }


    /***************************************************************************
     * Vrátí instanci třídy Size s rozměry instance.
     *
     * @return   Size s rozměry instance.
     */
    @Override
    public Size getSize()
    {
        return new Size(getWidth(), getHeight());
    }


    /***************************************************************************
     * Nastaví nový "čtvercový" rozměr instance -
     * na zadaný rozměr se nastaví height i width.
     *
     * @param rozměr  Nově nastavovaný rozměr v obou směrech; rozměr&gt;0
     */
    public void setSize(int rozměr)
    {
        setSize(rozměr, rozměr);
    }


    /***************************************************************************
     * Nastaví nové rozměry instance.
     *
     * @param rozměr    Nově nastavovaný rozměr.
     */
    @Override
    public void setSize(Size rozměr)
    {
        setSize(rozměr.width, rozměr.height);
    }


    /***************************************************************************
     * Nastaví nové rozměry instance. Nastavované rozměry musí být nezáporné,
     * místo nulového rozměru se nastaví rozměr rovný jedné.
     *
     * @param width   Nově nastavovaná šířka; šířka &gt;= 0
     * @param height  Nově nastavovaná výška; výška &gt;= 0
     */
    @Override
    public void setSize(int width, int height)
    {
        setDirSize(getDirection(), width, height);
        this.width = width;
        this.height = height;
        CM.repaint();
    }


    /***************************************************************************
     * Vrátí instanci třídy Area s informacemi o pozici a rozměrech instance.
     *
     * @return   Area s informacemi o pozici a rozměre instance.
     */
    public Area getArea()
    {
        return new Area(getX(), getY(), getWidth(), getHeight());
    }


    /***************************************************************************
     * Nastaví novou polohu a rozměry instance.
     *
     * @param oblast Nově nastavovaná oblast zaujímaná instancí.
     */
    public void setArea(Area oblast)
    {
        setArea(oblast.x, oblast.y, oblast.width, oblast.height);
    }


    /***************************************************************************
     * Nastaví pozici a rozměr objektu.
     *
     * @param pozice  Position objektu
     * @param rozměr   Size objektu
     */
    public void setArea(Position pozice, Size rozměr)
    {
        setArea(pozice.x, pozice.y, rozměr.width, rozměr.height);
    }


    /***************************************************************************
     * Nastaví novou pozici a rozměr objektu.
     *
     * @param x       x-ová souřadnice počátku, x&gt;=0, x=0 má levý okraj plátna
     * @param y       y-ová souřadnice počátku, y&gt;=0, y=0 má horní okraj plátna
     * @param width   Šířka vytvářeného objektu v bodech
     * @param height   Výška vytvářeného objektu v bodech
     */
    public void setArea(int x, int y, int width, int height)
    {
        CM.stopPainting();{
            setPosition(x,     y   );
            setSize(width, height);
        } CM.returnPainting();
    }


    /***************************************************************************
     * Vrátí obrázek představovaný danou instancí.
     *
     * @return Obrázek představovaný danou instancí
     */
    public Image getImage()
    {
        return image;
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Prostřednictvím dodaného kreslítka vykreslí obraz své instance.
     *
     * @param painter Kreslítko, které nakreslí instanci
     */
    @Override
    public void paint(Painter painter)
    {
        if (aft == null) {
            painter.drawPicture(getX(), getY(), this, null);
        }
        else {
            painter.drawPicture(0, 0, this, aft);
        }
    }


    /***************************************************************************
     * Převede instanci na řetězec.
     *
     * @return Řetězcová reprezentace dané instance.
     */
    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() + "#" + (100 + hashCode() % 900);
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * Otočí instanci do zadaného směru
     * a přitom jí nastaví požadovanou výšku a šířku.
     *
     * @param direction Nově nastavovaný směr
     * @param width     Nově nastavovaná šířka; šířka &gt;= 0
     * @param height    Nově nastavovaná výška; výška &gt;= 0
     */
    public void setDirSize(Direction8 direction, int width, int height)
    {
        this.direction  = direction;
        int dirDistance = direction.ordinalDistanceTo(initialDirection);
        double xx, xy, xd, yx, yy, yd;
        switch(dirDistance)
        {
            case 0:
                if ((width == origWidth)  &&  (height == origHeight)) {
                    aft = null;
                    return;
                }
                xx = +((double)width / origWidth);
                xy = 0;
                xd = getX();
                yx = 0;
                yy = +((double)height / origHeight);
                yd = getY();
                break;

            case -6:    //O 90°doprava
            case +2:
                xx = 0;
                xy = -((double)height / origHeight);
                xd = getX() + height;
                yx = +((double)width / origWidth);
                yy = 0;
                yd = getY();
                break;

            case -4:    //0 180°
            case +4:
                xx = -((double)width / origWidth);
                xy = 0;
                xd = getX() + width;
                yx = 0;
                yy = -((double)height / origHeight);
                yd = getY() + height;
                break;

            case -2:    //O 90°doleva
            case +6:
                xx = 0;
                xy = +((double)height / origHeight);
                xd = getX();
                yx = -((double)width / origWidth);
                yy = 0;
                yd = getY() + width;
                break;

            default:
                throw new RuntimeException("\nNepovolené otočení");
        }
        this.aft       = new AffineTransform(xx, yx, xy, yy, xd, yd);
    }


    /***************************************************************************
     * Zkontroluje, že volající metoda otáčí obrázek do některého
     * z hlavních směrů. Obrázek nesmí být natáčen šikmo.
     *
     * @param direction Směr, do nějž je obrázek otáčen
     */
    private void verifyRequest(Direction8 direction)
    {
        if (! direction.isMain()) {
            throw new IllegalArgumentException(
                "\nObrázek lze natočit pouze do jednoho ze čtyř hlavních " +
                "směrů, požadováno: " + direction);
        }
//        if (getWidth() != getHeight()) {
//            throw new IllegalStateException(
//                "\nNastavovat směr je možno pouze pro čtvercový obrázek: "
//                + this);
//        }
    }



    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
