/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;



/*******************************************************************************
 * Instances of class {@code Painter} mediates the posibility
 * to paint the shapes on the canvas to the instances
 * managed by a {@link CanvasManager}.
 * The main task of the class si to facilitate komunication
 * of the graphics shapes with the graphics context &ndash;
 * instances of the class {@code java.awt.Graphics2D}.
 * The class {@code Painter} is constructed as an adapter for these instances.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Painter
{
    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** The adapted graphics context. */
    private Graphics2D g;



    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Create an instance wrapping the specified graphics object.
     * It supposes call only from a canvas manager
     * and so it is defined as package private.
     *
     * @param g The wrapped instance
     */
    Painter(Graphics2D g)
    {
        this.g = g;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns the currently used font.
     *
     * @return The current font
     */
    public Font getFont()
    {
        return g.getFont();
    }


    /***************************************************************************
     * Sets the specified font as the current.
     * All subsequent text operations use this font.
     * A null argument is silently ignored.
     *
     * @param font  The set font
     */
    public void setFont(Font font)
    {
        g.setFont(font);
    }


    /***************************************************************************
     * Set the background color of painting.
     *
     * @return The background color of painting
     */
    public NamedColor getBackground()
    {
        Color      awtColor   = g.getBackground();
        NamedColor namedColor = NamedColor.getNamedColor(
                                awtColor.getRed(),  awtColor.getGreen(),
                                awtColor.getBlue(), awtColor.getAlpha());
        return namedColor;
    }


    /***************************************************************************
     * Set the background color of painting.
     *
     * @param color The set background color
     */
    public void setBackground(NamedColor color)
    {
        g.setBackground(color.getAwtColor());
    }


    /***************************************************************************
     * Returns the wraped graphics context.
     *
     * @return The current font
     */
    public Graphics2D getGraphics()
    {
        return g;
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Draws the outline of an oval.
     * The result is a circle or ellipse that fits within the rectangle
     * specified by the x, y, width, and height arguments.
     * <p>
     * The oval covers an area that is
     * width + 1 pixels wide and height + 1 pixels tall.
     *
     * @param x      The x coordinate of the upper left corner
     *               of the oval to be drawn
     * @param y      The y coordinate of the upper left corner
     *               of the oval to be drawn
     * @param width  The width of the oval to be drawn
     * @param height The height of the oval to be drawn
     * @param color  The color of the oval to be drawn
     */
    public void drawEllipse(int x, int y, int width, int height,
                            NamedColor color)
    {
        g.setColor(color.getAwtColor());
        g.drawOval(x, y, width, height);
    }


    /***************************************************************************
     * Fills an oval bounded by the specified rectangle
     * with the specified color.
     *
     * @param x      The x coordinate of the upper left corner
     *               of the oval to be filled
     * @param y      The y coordinate of the upper left corner
     *               of the oval to be filled
     * @param width  The width  of the oval to be filled
     * @param height The height of the oval to be filled
     * @param color  The color  of the oval to be filled
     */
    public void fillEllipse(int x, int y, int width, int height, NamedColor color)
    {
        g.setColor(color.getAwtColor());
        g.fillOval(x, y, width, height);
    }


    /***************************************************************************
     * Draws the outline of the specified rectangle.
     * The left and right edges of the rectangle are at x and x + width.
     * The top and bottom edges are at y and y + height.
     * The rectangle is drawn using the specified color.
     *
     * @param x       The x coordinate of the rectangle to be drawn
     * @param y       The y coordinate of the rectangle to be drawn
     * @param width   The width  of the rectangle to be drawn
     * @param height  The height of the rectangle to be drawn
     * @param color   The color  of the rectangle to be drawn
     */
    public void drawRectangle(int x, int y, int width, int height,
                              NamedColor color)
    {
        g.setColor(color.getAwtColor());
        g.drawRect(x, y, width, height);
    }


    /***************************************************************************
     * Fills the specified rectangle.
     * The left and right edges of the rectangle are at x and x + width - 1.
     * The top and bottom edges are at y and y + height - 1.
     * The resulting rectangle covers an area
     * width pixels wide by height pixels tall.
     *
     * @param x       The x coordinate of the rectangle to be filled
     * @param y       The y coordinate of the rectangle to be filled
     * @param width   The width  of the rectangle to be filled
     * @param height  The height of the rectangle to be filled
     * @param color   The color  of the rectangle to be filled
     */
    public void fillRectangle(int x, int y, int width, int height,
                              NamedColor color)
    {
        g.setColor(color.getAwtColor());
        g.fillRect(x, y, width, height);
    }


    /***************************************************************************
     * Draws a closed polygon defined by arrays of x and y coordinates.
     * Each pair of (x, y) coordinates defines a point.
     * <p>
     * This method draws the polygon defined by {@code nPoint} line segments,
     * where {@code nPoint == min(x.length, y.length)} and where the first
     * {@code nPoint - 1} line segments are line segments from
     * {@code (x[i - 1], y[i - 1])} to {@code (x[i], y[i])}
     * for {@code 1 ≤ i ≤ nPoints}.
     * The figure is automatically closed by drawing a line
     * connecting the final point to the first point,
     * if those points are different.
     *
     * @param x     An array of x coordinates
     * @param y     An array of y coordinates
     * @param color The color of the polygon to be drawn
     */
    public void drawPolygon(int[] x, int[] y, NamedColor color)
    {
        g.setColor(color.getAwtColor());
        g.drawPolygon(x, y, Math.min(x.length, y.length));
    }


    /***************************************************************************
     * Fills a closed polygon defined by arrays of x and y coordinates.
     * <p>
     * This method draws the polygon defined by {@code nPoint} line segments,
     * where {@code nPoint == min(x.length, y.length)} and where the first
     * {@code nPoint - 1} line segments are line segments from
     * {@code (x[i - 1], y[i - 1])} to {@code (x[i], y[i])},
     * for {@code 1 ≤ i ≤ nPoints}.
     * The figure is automatically closed by drawing a line
     * connecting the final point to the first point,
     * if those points are different.
     * <p>
     * The area inside the polygon is defined using an even-odd fill rule,
     * also known as the alternating rule.
     *
     * @param x     An array of x coordinates
     * @param y     An array of y coordinates
     * @param color The color of the polygon to be drawn
     */
    public void fillPolygon(int[] x, int[] y, NamedColor color)
    {
        g.setColor(color.getAwtColor());
        g.fillPolygon(x, y, Math.min(x.length, y.length));
    }


    /***************************************************************************
     * Draws a line, using the specified color,
     * between the points {@code (x1, y1)} and {@code (x2, y2)}.
     *
     * @param x1    The first point's x coordinate
     * @param y1    The first point's y coordinate
     * @param x2    The second point's x coordinate
     * @param y2    The second point's x coordinate
     * @param color The color of the line to be drawn
     */
    public void drawLine(int x1, int y1, int x2, int y2, NamedColor color)
    {
        g.setColor(color.getAwtColor());
        g.drawLine(x1, y1, x2, y2);
    }


    /***************************************************************************
     * Draws the text given by the specified string,
     * using the current font and the specified color.
     * The baseline of the leftmost character is at position {@code (x, y)}.
     *
     * @param text  The text to be drawn
     * @param x     The x coordinate
     * @param y     The y coordinate
     * @param color The color of the text to be drawn
     */
    public void drawText(String text, int x, int y, NamedColor color)
    {
        g.setColor(color.getAwtColor());
        g.drawString(text, x, y);
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
