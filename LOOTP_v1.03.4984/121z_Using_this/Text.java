/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */

import java.awt.Font;



/*******************************************************************************
 * Instances of the class {@code Text} represents texts
 * that are mind for work on a virtual canvas
 * during the first introduction to objects.
 * They are defined by their text, position and color.
 * The position of an instance is defined as the position
 * of the upper left corner of the circumscribe rectangle
 * and its size is determined by the text and font in use.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Text implements IMovable, ICopyable
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Constant denoting plain (not-bold and not-italic) font. */
    public static final int PLAIN = Font.PLAIN;

    /** Constant denoting bold and not-italic font. */
    public static final int BOLD    = Font.BOLD;

    /** Constant denoting not-bolditalic) font. */
    public static final int ITALIC  = Font.ITALIC;

    /** The default named color of created instances for the case,
     *  when the caller doesn't set any -
     *  for texts it is {@code NamedColor.BLACK}. */
    public static final NamedColor DEFAULT_COLOR = NamedColor.BLACK;

    /** The canva manager controlling painting of the instance. */
    private static final CanvasManager CM = CanvasManager.getInstance(false);



    //== VARIABLE CLASS FIELDS =================================================

    /** The number of created instances. */
    private static int count = 0;



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Instance ID = the order of the created instance inside its class. */
    private final int ID = ++count;

    /** The name constructed from simple class name and instance ID. */
    private final String name = "Text_" + ID;


    /** The represented text. */
    private final String text;

    //== VARIABLE INSTANCE FIELDS ==============================================

    /** The x-coordinate of the instance. */
    private int xPos;

    /** The y-coordinate of the instance. */
    private int yPos;

    /** The instance color. */
    private NamedColor color;

    /** Písmo, jímž se zobrazuje reprezentovaný text. */
    private Font font;

    /** The font set for painter. */
    private Font painterFont;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a new instance with default position, size and color.
     * The instance will be placed in the upper left corner of the canvas,
     * it will have a default color
     * and it will use the bold dialog font.
     *
     * @param text  The represented text
     */
    public Text(String text)
    {
        this(text, 0, 0);
    }


    /***************************************************************************
     * Creates a new instance with given position and size
     * and with default color.
     * The position of an instance is defined as the position
     * of the upper left corner of the circumscribe rectangle
     * and its size is determined by the text and font in use.
     *
     * @param text  The represented text
     * @param x  The horizontal coordinate,
     *           left canvas border has x=0, coordinate increases to the right
     * @param y  The vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     */
    public Text(String text, int x, int y)
    {
        this(x, y, DEFAULT_COLOR, text);
    }


    /***************************************************************************
     * Creates a new instance with given position and size
     * and with default color.
     * The position of an instance is defined as the position
     * of the upper left corner of the circumscribe rectangle
     * and its size is determined by the text and font in use.
     *
     * @param x  The horizontal coordinate,
     *           left canvas border has x=0, coordinate increases to the right
     * @param y  The vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     * @param text  The represented text
     */
    public Text(int x, int y, String text)
    {
        this(x, y, DEFAULT_COLOR, text);
    }


    /***************************************************************************
     * Creates a new instance with given position and size
     * and with a specified color.
     * The position of an instance is defined as the position
     * of the upper left corner of the circumscribe rectangle
     * and its size is determined by the text and font in use.
     *
     * @param x  The horizontal coordinate,
     *           left canvas border has x=0, coordinate increases to the right
     * @param y  The vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     * @param color  The color of the instance
     * @param text  The represented text
     */
    public Text(int x, int y, NamedColor color, String text)
    {
        this.xPos  = x;
        this.yPos  = y;
        this.text  = text;
        this.color = color;
        this.font  = new Font("Dialog", Font.BOLD, 12);
    }


    /***************************************************************************
     * Returns a copy of the instance, which means a the same text
     * with the same size, font, position and color.
     *
     * @return The requested copy
     */
    @Override
    public Text copy()
    {
        Text ret = new Text(xPos, yPos, color, name);
        ret.font        = font;
        ret.painterFont = painterFont;
        return ret;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns the current color of the instance.
     *
     * @return The current color of the instance
     */
    public NamedColor getColor()
    {
        return color;
    }


    /***************************************************************************
     * Sets a new color of the instance.
     *
     * @param color The new color of the instance
     */
    public void setColor(NamedColor color)
    {
        this.color = color;
        CM.repaint();
    }


    /***************************************************************************
     * Returns the current x coordinate of the instance,
     * which means the horizontal position of the upper left corner
     * of the circumscribe rectangle.
     *
     * @return  The horizontal coordinate,
     *          left canvas border has x=0, coordinate increases to the right
     */
    @Override
    public int getX()
    {
        return xPos;
    }


    /***************************************************************************
     * Returns the current y coordinate of the instance,
     * which means the vertical position of the upper left corner
     * of the circumscribe rectangle.
     *
     * @return  The vertical coordinate,
     *          upper canvas border has y=0, coordinate increases down
     */
    @Override
    public int getY()
    {
        return yPos;
    }


    /***************************************************************************
     * Sets a position of the instance (new values of its coordinates)
     * and moves the instance to this position.
     * The position of instance is defined as the position
     * of the upper left corner of the circumscribe rectangle.
     *
     * @param x  The newly set horizontal coordinate,
     *           Left canvas border has x=0, coordinate increases to the right
     * @param y  The newly set vertical coordinate,
     *           upper canvas border has y=0, coordinate increases to the down
     */
    @Override
    public void setPosition(int x, int y)
    {
        xPos = x;
        yPos = y;
        CM.repaint();
    }


    /***************************************************************************
     * Returns the name of the instance, which is the painted text.
     *
     * @return  The painted text
     */
    public String getName()
    {
        return name;
    }


    /***************************************************************************
     * Returns the font used by painting the text on the canvas.
     *
     * @return The font used by painting the text on the canvas
     */
    public Font getFont()
    {
        return font;
    }


    /***************************************************************************
     * Set the font used by painting the text on the canvas.
     *
     * @param name  Font name - one of following can be used:
     *              {@code Dialog, DialogInput, Monospaced,
     *                     Serif,  SansSerif}
     * @param style Font style - one of following can be used:
     *              {@code Text.PLAIN, Text.BOLD, Text.ITALIC,
     *                     Text.BOLD|Text.ITALIC}
     * @param size  Fon size in points
     */
    public void setFont(String name, int style, int size)
    {
        font = new Font(name, style, size);
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Returns a string representation of the object (objects's signture).
     * It is used mainly by the debugging.
     *
     * @return Name of the instance followed by its coordinates,
     *         dimensons and color
     */
    @Override
    public String toString()
    {
        return name + "[x=" + xPos + ", y=" + yPos +
               ", color=" + color + ", font=" + font +
               ", text=" + text + "]";
    }


    /***************************************************************************
     * Paint the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
    @Override
    public void paint(Painter painter)
    {
        if (font != painterFont) {
            painter.setFont(font);
            painterFont = font;
        }
        painter.drawText(name, xPos, yPos + font.getSize(), color);
    }


    /***************************************************************************
     * Registers the instance at the canvas manager
     * and so force painting the instance on the canvas.
     */
    public void paint()
    {
        CM.add(this);
    }


    /***************************************************************************
     * Unregisters the instance at the canvas manager
     * which is equal to rub out the instance from the canvas.
     */
    public void rubOut()
    {
        CM.remove(this);
    }


    /***************************************************************************
     * Move the instance by the specified amount of points to the right or
     * (by negative argument) left.
     *
     * @param distance Distance for move
     */
    public void moveRight(int distance)
    {
        setPosition(xPos+distance, yPos);
    }


    /**************************************************************************
     * Move the instance by the default amount of points to the right.
     * This default distance equals to the step of {@link CanvasManager}.
     * It can be obtained by calling its method {@link CanvasManager#getStep()}
     * and set by calling its method {@link CanvasManager#setStep(int)}
     * or {@link CanvasManager#setStepAndSize(int,int,int)}.
     */
    public void moveRight()
    {
        moveRight(CM.getStep());
    }


    /***************************************************************************
     * Move the instance by the default amount of points to the left.
     * This default distance equals to the step of {@link CanvasManager}.
     * It can be obtained by calling its method {@link CanvasManager#getStep()}
     * and set by calling its method {@link CanvasManager#setStep(int)}
     * or {@link CanvasManager#setStepAndSize(int,int,int)}.
     */
    public void moveLeft()
    {
        moveRight(-CM.getStep());
    }


    /***************************************************************************
     * Move the instance by the specified amount of points down or
     * (by negative argument) up.
     *
     * @param distance Distance for move
     */
    public void moveDown(int distance)
    {
        setPosition(xPos, yPos+distance);
    }


    /***************************************************************************
     * Move the instance by the default amount of points down.
     * This default distance equals to the step of {@link CanvasManager}.
     * It can be obtained by calling its method {@link CanvasManager#getStep()}
     * and set by calling its method {@link CanvasManager#setStep(int)}
     * or {@link CanvasManager#setStepAndSize(int,int,int)}.
     */
    public void moveDown()
    {
        moveDown(CM.getStep());
    }


    /***************************************************************************
     * Move the instance by the default amount of points up.
     * This default distance equals to the step of {@link CanvasManager}.
     * It can be obtained by calling its method {@link CanvasManager#getStep()}
     * and set by calling its method {@link CanvasManager#setStep(int)}
     * or {@link CanvasManager#setStepAndSize(int,int,int)}.
     */
    public void moveUp()
    {
        moveDown(-CM.getStep());
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== EMBEDDED AND INNER CLASSES ============================================
    //== TESTING CLASSES AND METHODS ===========================================
}
