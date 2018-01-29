/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */

import java.awt.Color;


import java.text.Collator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



/*******************************************************************************
 * The class {@code NamedColor} defines
 * a set of basic colors for shape painting.
 * It is not defined as enum to allow users
 * to arbitrarily add colors of their own.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class NamedColor
{
    /** Count of named colors is increased in the construction of the following
     *  instances therefore it must be declared before them.*/
    private static int count = 0;



    //== CONSTANT CLASS FIELDS =================================================

    /** Alpha attribute of the transluent color. */
    private static final int TRANSLUCENCE = 96;

    /** Minimal value of component when changing brightness and translucency. */
    private static final int MINC = 32;

    /** Maximal value of component when changing brightness and translucency. */
    private static final int MAXC = 255;

    /** Coeficient for changing brightness and translucency.*/
    private static final double CHANGE_KOEF = 0.7;

    /** The map of all currently created named colors keyed by their names. */
    private static final Map<String,NamedColor> name2namedColor =
                                                new LinkedHashMap<>();

    /** The map of all created named colors keyed by their names
     *  with removed accents. */
    private static final Map<String,NamedColor> nameRA2namedColor =
                                                new LinkedHashMap<>();

    /** The map of all created named colors keyed by their awt color. */
    private static final Map<Color,NamedColor>  color2namedColor =
                                                new LinkedHashMap<>();

    /** The list of all defined named colors. */
    private static final List<NamedColor> namedColorList = new ArrayList<>(32);



    //########## COLORS ########################################################

    //########## Colors with equivalent constant in java.awt.Color

    /** Black = RGBA(0, 0, 0, 255); */         public static final NamedColor
    BLACK      = new NamedColor(Color.BLACK,        "black"     );

    /** Blue = RGBA(0, 0, 255, 255); */        public static final NamedColor
    BLUE       = new NamedColor(Color.BLUE,         "blue"      );

    /** Red = RGBA(255, 0, 0, 255); */         public static final NamedColor
    RED        = new NamedColor(Color.RED,          "red"       );

    /** Magenta = RGBA(255, 0, 255, 255); */   public static final NamedColor
    MAGENTA    = new NamedColor(Color.MAGENTA,      "magenta"   );

    /** Green = RGBA(0, 255, 0, 255); */       public static final NamedColor
    GREEN      = new NamedColor(Color.GREEN,        "green"     );

    /** Cyan = RGBA(0, 255, 255, 255); */      public static final NamedColor
    CYAN       = new NamedColor(Color.CYAN,         "cyan"      );

    /** Yellow = RGBA(255, 255, 0, 255); */    public static final NamedColor
    YELLOW     = new NamedColor(Color.YELLOW,       "yellow"    );

    /** White = RGBA(255, 255, 255, 255); */   public static final NamedColor
    WHITE      = new NamedColor(Color.WHITE,        "white"     );

    /** Light gray = RGBA(192,192,192,255); */ public static final NamedColor
    LIGHT_GRAY = new NamedColor(Color.LIGHT_GRAY,   "lightgray" );//192 = 0xC0

    /** Gray = RGBA(128, 128, 128, 255); */    public static final NamedColor
    GRAY       = new NamedColor(Color.GRAY,         "gray"      );//128 = 0x80

    /** Dark gray = RGBA(64, 64, 64, 255); */  public static final NamedColor
    DARK_GRAY  = new NamedColor(Color.DARK_GRAY,    "darkgray"  );//64 = 0x40

    /** Pink = RGBA(255, 175, 175, 255); */    public static final NamedColor
    PINK       = new NamedColor(Color.PINK,         "pink"      );//175 = 0xAF

    /** Orange = RGBA(255, 200, 0, 255); */    public static final NamedColor
    ORANGE     = new NamedColor(Color.ORANGE,       "orange"    );


    //########## Colors without equivalent constant in java.awt.Color

    /** Amber = RGBA(255, 204, 000, 255);*/ public static final NamedColor
    AMBER  = new NamedColor(0xFF, 0xCC, 0x00, 0xFF, "amber");

    /** Brick = RGBA(255, 102, 0, 255); */     public static final NamedColor
    BRICK  = new NamedColor(0xFF, 0x66, 0x00, 0xFF, "brick"     );

    /** Brown = RGBA(153, 51, 0, 255); */      public static final NamedColor
    BROWN  = new NamedColor(0x99, 0x33, 0x00, 0xFF,  "brown"    );

    /** Creamy = RGBA(255, 255, 204, 255); */  public static final NamedColor
    CREAMY = new NamedColor(0xFF, 0xFF, 0xCC, 0xFF,  "creamy"   );

    /** Gold = RGBA(255, 224,  0, 255); */     public static final NamedColor
    GOLD   = new NamedColor(0xFF, 0xE0, 0x00, 0xFF, "gold"      );

    /** Khaki = RGBA(153, 153, 0, 255); */     public static final NamedColor
    KHAKI  = new NamedColor(0x99, 0x99, 0x00, 0xFF,  "khaki"    );

    /** Ochre  = RGBA(255, 153, 000, 255); */  public static final NamedColor
    OCHRE  = new NamedColor(0xFF, 0x99, 0x00,  0xFF, "ochre" );

    /** Silver = RGBA(216, 216, 216, 255); */  public static final NamedColor
    SILVER = new NamedColor(0xD8, 0xD8, 0xD8, 0xFF, "silver"    );

    /** Steely = RGBA(0, 153, 204, 255); */    public static final NamedColor
    STEELY = new NamedColor(0x00, 0x99, 0xCC, 0xFF,  "steely"   );


    //########## Translucent colors

    /** Milky = RGBA(255, 255, 255, 128) - half translucent white! */
    public static final NamedColor
    MILKY  = new NamedColor(0xFF, 0xFF, 0xFF, 0x80,  "milky"    );

    /** Smoky = RGBA(128, 128, 128, 128) - half translucent gray! */
    public static final NamedColor
    SMOKY  = new NamedColor(0x80, 0x80, 0x80, 0x80,  "smoky"    );

    /** NO = RGBA(0, 0, 0, 0) - transparent invisible color */
    public static final NamedColor
    NO     = new NamedColor(0x0, 0x0, 0x0, 0x0,      "no"       );



    //== VARIABLE CLASS FIELDS =================================================

    /** Flag remembering if the names are written in uppercase. */
    private static boolean inUpperCase = false;



    //== STATIC INICIALIZATION BLOCK - STATIC CONSTRUCTOR ======================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** The name of the color defined in constructor parameters. */
    private final String name;

    /** Instance of {@link java.awt.Color} representing the same color. */
    private final Color awtColor;

    /** Index of a color in the list of already created colors. */
    private final int index = count++;



    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================

    /***************************************************************************
     * Returns collection of defined named colors.
     *
     * @return  Collection of defined named colors.
     */
    private
    static List<NamedColor> getListOfNamedColors()
    {
        return Collections.unmodifiableList(namedColorList);
    }


    /***************************************************************************
     * Returns list of names of defined colors.
     *
     * @return Collection of names of defined colors
     */
    private
    static List<String> getListOfNames()
    {
        return Arrays.asList(getArrayOfNames());
    }


    /***************************************************************************
     * Returns array of defined named colors.
     *
     * @return  Array of defined named colors
     */
    public static NamedColor[] getArrayOfNamedColors()
    {
        return namedColorList.toArray(new NamedColor[namedColorList.size()]);
    }


    /***************************************************************************
     * Returns array of names of defined colors.
     *
     * @return  Array of names of defined colors.
     */
    public static String[] getArrayOfNames()
    {
        String[] names = name2namedColor.keySet()
                         .toArray(new String[name2namedColor.size()]);
        if (inUpperCase) {
            for (int i = 0;   i < names.length;   i++) {
                names[i] = names[i].toUpperCase();
            }
        }
        Arrays.sort(names, Collator.getInstance());
        return names;
    }


    /***************************************************************************
     * Sets if the names should be written in uppercase.
     *
     * @param inUpperCase {@code true} if names should be written in uppercase,
     *                    {@code false} otherwise
     * @return            Original setting
     */
    public static boolean setInUppercase(boolean inUpperCase)
    {
        boolean originalSetting = NamedColor.inUpperCase;
        NamedColor.inUpperCase = inUpperCase;
        return originalSetting;
    }



    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    /***************************************************************************
     * Opens a dialog box with all defined names separated by commas.
     * The names are alphabetically sorted.
     */
    public static void showDefinedNames()
    {
        final int LINE_LENGTH = 64;
        String[] names = getArrayOfNames();
        StringBuilder sb = new StringBuilder();
        for (int i=0, inLine=0;   i < names.length;   i++) {
            String text = names[i];
            int textLength = text.length();
            if ((inLine + textLength)  >=  LINE_LENGTH) {
                sb.append('\n');
                inLine = 0;
            }
            sb.append(text);
            inLine += textLength + 2;
            if (i < names.length) {
                sb.append(", ");
            }
        }
//        System.out.println("Colors:\n" + sb);
        IO.inform(sb);
    }



    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a new color with given values of its componnents
     * with transparency level set in alpha channel and
     * with the provided name.
     *
     * @param red     The red component
     * @param green   The green component
     * @param blue    The blue component
     * @param alpha   The alpha component = transparency level
     *                0=transparent, 255=opaque
     * @param name    Name of the created color
     */
    private NamedColor(int red, int green, int blue, int alpha, String name)
    {
        this(new Color(red, green, blue, alpha),  name);
    }


    /***************************************************************************
     * Creates an instance wrapping the given instance of class
     * {@link java.awt.Color} and having the given name.
     * The purpose of this constructor is simple passing component values
     * of the equally named colors defined as named constants
     * in the class {@link java.awt.Color}.
     *
     * @param color     The {@link java.awt.Color} to be wraped
     * @param colorName The name of the color to be created;
     *                  {@code null} is a request to create generic name
     */
    private NamedColor(Color color, String colorName)
    {
        colorName = colorName.toLowerCase();
        this.awtColor = color;
        this.name = colorName;
        if (name2namedColor.containsKey(colorName)    ||
            color2namedColor.containsKey(color))
        {
            throw new IllegalArgumentException(
                "\nInternal error - the color " + getNamePrivate() +
                " and/or " + getCharacteristicsHexPrivate() +
                " already exists");
        }

        NamedColor me = this;
        name2namedColor.put(colorName, me);
        color2namedColor.put(awtColor, me);
        namedColorList.add(me);

        addNameWithoutAccents();
    }


    /***************************************************************************
     * Converts the color name to its respective {@code NamedColor} instance
     *
     * @param colorName The name of the requested color. The list of existing
     *         names returns the method <b>{@link #getListOfNames()}</b>
     * @return Instance of {@code NamedColor} representing the given name
     * @throws IllegalArgumentException
     *         If the color of the given name is not defined yet
     */
    public static NamedColor getNamedColor(String colorName)
    {
        NamedColor namedColor = name2namedColor.get(colorName.toLowerCase());
        if (namedColor != null) {
            return namedColor;
        }
        else {
            throw new IllegalArgumentException(
                    "\nI do not know color with name: " + colorName);
        }
    }


    /***************************************************************************
     * Returns opaque color with given values of its components.
     * If the color is not yet defined, creates it and
     * assignes it a generic name according to its component values.
     *
     * @param red   The red component
     * @param green The green component
     * @param blue  The blue component
     * @return      NamedColor with given values of its components
     */
    private
    static NamedColor getNamedColor(int red, int green, int blue)
    {
        return getNamedColor(red, green, blue, 0xFF);
    }


    /***************************************************************************
     * Returns color with given values of its components and translucency.
     * If the color is not yet defined, creates it and
     * assigns it a generic name according to its component values.
     *
     * @param red   The red component
     * @param green The green component
     * @param blue  The blue component
     * @param alpha The alpha component = transparency level
     *              0=transparent, 255=opaque
     * @return      NamedColor with given values of its components
     */
    public
    static NamedColor getNamedColor(int red, int green, int blue, int alpha)
    {
        Color color = new Color(red, green, blue, alpha);
        NamedColor namedColor = color2namedColor.get(color);
        if (namedColor != null) {
            return namedColor;
        }
        String colorName = "Color(r=" + red + ",g=" + green +
                       ",b=" + blue + ",a=" + alpha + ")" ;
        return getNamedColor(red, green, blue, alpha, colorName);
    }


    /***************************************************************************
     * Returns opaque color with given values of its color components
     * and given name. If the color is not yet defined, it creates it.
     * If the color with given name exists and has other values of components
     * or if the color with given values of components exists and has another
     * name, the {@link IllegalArgumentException} is thrown.
     *
     * @param red   The red component
     * @param green The green component
     * @param blue  The blue component
     * @param name  Name of asked color
     *
     * @return NamedColor with given name and values of its components
     * @throws IllegalArgumentException If the color with given name exist
     *              but has another values of components or if the color with
     *              given values of components exists but has another name.
     */
    public static NamedColor getNamedColor(int red, int green, int blue,
                                           String name)
    {
        return getNamedColor(red, green, blue, 0xFF, name);
    }


    /***************************************************************************
     * Returns color with given values of its color components, transparency
     * and given name. If the color is not yet defined, creates it.
     * If the color with given name exist and has another values of components
     * or if the color with given values of components exists and has another
     * name, the {@link IllegalArgumentException} is thrown.
     *
     * @param red   The red component
     * @param green The green component
     * @param blue  The blue component
     * @param alpha The alpha component = transparency level
     *              0=transparent, 255=opaque
     * @param colorName Name of asked color
     * @return NamedColor with given name and values of its components
     * @throws IllegalArgumentException If the color with given name exist
     *              but has another values of components or if the color with
     *              given values of components exists but has another name.
     *              Or if the {@code name} is empty.
     * @throws NullPointerException  If the {@code name} is {@code null}.
     */
    public static NamedColor getNamedColor(int red,   int green, int blue,
                                           int alpha, String colorName)
    {
        colorName = colorName.trim().toLowerCase();
        if ((colorName == null)  ||  colorName.isEmpty())  {
            throw new IllegalArgumentException(
                "\nThe color must have nonempty name");
        }
        Color color = new Color(red, green, blue, alpha);
        NamedColor fromName = namedColor(colorName);
        NamedColor fromColor = color2namedColor.get(color);

        if ((fromName != null)  &&  (fromName == fromColor)) {
            //The requested color already exists
            return fromName;
        }
        if ((fromName == null)  &&  (fromColor == null)) {
            //The requested color doesn't exist yet
            return new NamedColor(red, green, blue, alpha, colorName);
        }
        //What color doesn't aloow adding the requested one?
        NamedColor b = (fromColor != null)  ?  fromColor  :  fromName;
        Color c = b.awtColor;
        throw new IllegalArgumentException(
            "\nThe given arguments collide with an existing color"+
            "[existing × given]:" +
            "\nName :        " + b.getName()  + " × " + colorName +
            "\nRed:          " + c.getRed()    + " × " + red       +
            "\nGreen:        " + c.getGreen()  + " × " + green     +
            "\nBlue:         " + c.getBlue()   + " × " + blue      +
            "\nTransparency: " + c.getAlpha()  + " × " + alpha
           );
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Converts the {@code NamedColor} to type used by the painter.
     * This method is used in the class {@code Space}.
     *
     * @return Instance of {@code Color} representing the given color
     */
    public Color getAwtColor()
    {
        return awtColor;
    }


    /***************************************************************************
     * Returns the internal index of the color.
     *
     * @return Index of the color
     */
    public int getIndex()
    {
        return index;
    }


    /***************************************************************************
     * Returns the name of the color.
     *
     * @return The name of the color
     */
    public String getName()
    {
        return getNamePrivate();
    }


    private String getNamePrivate()
    {
        return (inUpperCase  ?  name.toUpperCase()  :  name);
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Returns translucent version of the color, which means a color
     * with the same color components and alpha value 0.5.
     *
     * @return Translucent version of the color
     */
    public NamedColor translucent()
    {
        Color newColor = new Color (awtColor.getRed(),  awtColor.getGreen(),
                                    awtColor.getBlue(), TRANSLUCENCE);
        NamedColor namedColor = color2namedColor.get(newColor);
        if (namedColor == null) {
            String name2 = "translucent_" + this.name;
            namedColor = name2namedColor.get(name2);
            if (namedColor == null) {
                namedColor = getNamedColor(
                             awtColor.getRed(),  awtColor.getGreen(),
                             awtColor.getBlue(), TRANSLUCENCE, name2);
            }
        }
        return namedColor;
    }


    /***************************************************************************
     * Returns color inverse to this one, which means the color with
     * inverse values of components but with the same transparency.
     *
     * @return Inverse color
     */
    private
    NamedColor inverse()
    {
        return getNamedColor(MAXC - awtColor.getRed(),
                              MAXC - awtColor.getGreen(),
                              MAXC - awtColor.getBlue(), awtColor.getAlpha());
    }


    /***************************************************************************
     * Return a less transparent version of the color.
     * Mind that the operation is not fully reversible during the rounding.
     *
     * @return Less transparent color
     */
    private
    NamedColor lessTransparent()
    {
        int a = Math.max(Math.min((int)(awtColor.getAlpha()/CHANGE_KOEF), MAXC), MINC);
        return getNamedColor(
            new Color(awtColor.getRed(), awtColor.getGreen(),
                      awtColor.getBlue(), a));
    }


    /***************************************************************************
     * Return a more transparent version of the color.
     * Mind that the operation is not fully reversible during the rounding.
     *
     * @return Less transparent color
     */
    private
    NamedColor moreTransparent()
    {
        int a = (int)(awtColor.getAlpha() * CHANGE_KOEF);
        return getNamedColor(
            new Color(awtColor.getRed(), awtColor.getGreen(),
                      awtColor.getBlue(), a));
    }


    /***************************************************************************
     * Return a brighter version of the color.
     * Mind that the operation is not fully reversible during the rounding.
     *
     * @return Brighter color
     */
    private
    NamedColor brighter()
    {
        Color c = awtColor.brighter();
        if (c.equals(awtColor)) {
            c = new Color(Math.max(c.getRed(),   MINC),
                           Math.max(c.getGreen(), MINC),
                           Math.max(c.getBlue(),  MINC),  c.getAlpha());
        }
        return getNamedColor(c);
    }


    /***************************************************************************
     * Return a darker version of the color.
     * Mind that the operation is not fully reversible during the rounding.
     *
     * @return Darker color
     */
    private
    NamedColor darker()
    {
        return getNamedColor(awtColor.darker());
    }


    /***************************************************************************
     * Returns the name of the color.
     *
     * @return  Name of the color
     */
    @Override
    public String toString()
    {
        return getName();
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================

    /***************************************************************************
     * Returns the string with values of particular components
     * shown in the hexadecimal radix.
     *
     * @return String with the requested characteristic
     */
    private String getCharacteristicsHexPrivate()
    {
        return String.format("%s(Hex:R=%02X,G=%02X,B=%02X,A=%02X)", name,
                             awtColor.getRed(), awtColor.getGreen(),
                             awtColor.getBlue(), awtColor.getAlpha()
                            );
    }


    /***************************************************************************
     * Returns the color with the given name ignoring accents.
     *
     * @param name Name of the searched color
     * @return Color with the given name or {@code null}.
     */
    private static NamedColor namedColor(String name) {
        name = name.toLowerCase();
        NamedColor color = name2namedColor.get(name);
        if (color == null) {
            color = nameRA2namedColor.get(name);
        }
        return color;
    }


    /***************************************************************************
     * Returns a named color wrapping the given awt color.
     * If the color is not yet defined, it creates it and
     * assignes it a generic name according to its component values.
     *
     * @param c The "parent" awt color
     * @return A named color wrapping the given awt color
     */
    private static NamedColor getNamedColor(Color c)
    {
        NamedColor b = color2namedColor.get(c);
        if (b != null) {
            return b;
        }
        else {
            return getNamedColor(c.getRed(),  c.getGreen(),
                                 c.getBlue(), c.getAlpha());
        }
    }



    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * If the name contans characters with accent,
     * it add into the appropriate map this name without accents.
     */
    private void addNameWithoutAccents() {
        String bhc = IO.removeAccents (name);
        if (! name.equals(bhc)) {
            nameRA2namedColor.put(bhc, this);
        }
    }



    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
