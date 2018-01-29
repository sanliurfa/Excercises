
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Shape;

import java.awt.geom.Rectangle2D;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



/*******************************************************************************
 * The instance of class {@code Canvas} (singleton) serves as a virtual canvas,
 * on which the shapes can be painted.
 * <p>
 * The class doesn't offer the public constructor to others
 * because its instance should be a singleton
 * to ensure that all shapes will be painted on the same canvas.
 * The only way of getting the reference to canvas
 * is calling the static factory method {@link #getCanvas()}.</p>
 * <p>
 * To allow a simple painting
 * without some registration,
 * the rubbed out parts of the painted shapes are not restored.
 * If therefore is a part of another shape rubbed out as a side effect,
 * the damaged shape should be repainted explicitly.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public final class Canvas
{
    //== CONSTANT CLASS FIELDS =================================================

    /** The starting canvas title. */
    private static final String TITLE  = "Simple canvas";

    /** The stating width in points. */
    public static final int WIDTH_0 = 300;

    /** The starting height in points. */
    public static final int HEIGHT_0 = 300;

    /** The starting canvas color. */
    public static final NamedColor BACKGROUND_0 = NamedColor.CREAMY;



    //== VARIABLE CLASS FIELDS =================================================

    /** The only instance of the class Canvas. */
    private static volatile Canvas SINGLETON;



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================

    //Attributes which values are not directly adjustable by user

        /** The application window of the canvas. */
        private JFrame frame;

        /** Instance of a local class created
         *  for hiding the parents methods of the JPanel. */
        private JPanel canvasPanel;

        /** Everything is drawn on the picture,
         *  which can be easily repainted. */
        private Image canvasImage;

        /** The paint-tool needed for painting on the canvas. */
        private Graphics2D painter;


    //Attributes directly adjustable by user

        /** Color of canvas = background color of painting. */
        private NamedColor backgroundColor;

        /** Canvas width in points. */
        private int width;

        /** Canvas height in points. */
        private int height;

        /** Canvas position on the display; by using more monitors it is
         *  sometimes necessarry to refresh it after making window visible. */
        Point framePosition;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    /***************************************************************************
     * Clears the canvas, it means that it erases all the shapes on the canvas.
     * Rightly this method should be defined as instance method,
     * however, because the instance is defined as a singleton
     * the method is defined as static to allow to clear the canvas
     * without obtaining the reference to its instance.
     */
    static public void clearCanvas()
    {
        SINGLETON.clear();
    }



    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * The only method allowing to get reference to instance of canvas.
     * However, because the instance is defined as a singleton,
     * the method returns every time the reference to the same instance.
     *
     * @return The reference to the singleton instance of the class
     */
    public static Canvas getCanvas()
    {
        if (SINGLETON == null) {
            synchronized(Canvas.class) {
                if (SINGLETON == null) {
                    initialize();
                }
            }
        }
        SINGLETON.setVisible(true);
        return SINGLETON;
    }


    /***************************************************************************
     * The default (and only) constructor.
     * It is called only once in the {@link #SINGLETON} declaration.
     *
     * @param position The initial position of the application window
     */
    @SuppressWarnings("serial")     //Because of annonymous class
    private Canvas(Point position)
    {
        framePosition = position;
        frame         = new JFrame();
        frame.setLocation(position);
        frame.setTitle(TITLE);

        //By closing the window we close the whole application
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        canvasPanel = new JPanel()
        {   /** The obligatorily overridden method
             * of the class {@link JPanel}. */
            @Override
            public void paintComponent(Graphics g) {
                g.drawImage(canvasImage, 0, 0, null);
            }
        };
        frame.setContentPane(canvasPanel);
        backgroundColor = BACKGROUND_0;

        setSizePrivate(WIDTH_0, HEIGHT_0); //Prepares and paints an empty window
//        IO.Correction.windowLocation(frame);
        prepareImage();
        clear();

        IO.setDialogsPosition(framePosition.x,
                              framePosition.y + frame.getSize().height);
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Indicates whether the canvas application window is visible.
     * However even the visible windows can be hiden by another windows.
     *
     * @return If the window is visible, it returns <b>true</b>,
     *         otherwise it returns <b>false</b>
     */
    public boolean isVisible()
    {
        return frame.isVisible();
    }


    /***************************************************************************
     * Set the visibility of canvas application window.
     *
     * @param visible {@code true} if the application window should be visible,
     *                otherwise {@code false}
     */
    public void setVisible(boolean visible)
    {
        boolean change = (isVisible() != visible);
        if (change) {
            if (! visible) {
                frame.setVisible(false);
            }
            else {
                if (java.awt.EventQueue.isDispatchThread()) {
                    setVisibleInternal();
                    return;
                }
                Runnable run = new Runnable() {
                    @Override
                    public void run()
                    {
                        setVisibleInternal();
                    }
                };
                try {
                    java.awt.EventQueue.invokeAndWait(run);
                }
                catch (Exception ex) {
                    throw new RuntimeException(
                            "\nException by visibilty setting", ex);
                }
            }
        }
    }


    /***************************************************************************
     * Returns the current canvas color (= background color).
     *
     * @return Current background color
     */
    public NamedColor getBackgroundColor()
    {
        return backgroundColor;
    }


    /***************************************************************************
     * Set the current canvas color (= background color).
     *
     * @param color  The set canvas color
     */
    public void setBackgroundColor(NamedColor color)
    {
        this.backgroundColor = color;
        painter.setBackground(color.getAwtColor());
        clear();
    }


    /***************************************************************************
     * Set the color of painting.
     *
     * @param color Set painting color
     */
    public void setForegroundColor(NamedColor color)
    {
        painter.setColor(color.getAwtColor());
    }


    /***************************************************************************
     * Returns the canvas width in pixels.
     *
     * @return Pixel width of the canvas
     */
    public int getWidth()
    {
        return width;
    }


    /***************************************************************************
     * Returns the canvas height in pixels.
     *
     * @return Pixel height of the canvas
     */
    public int getHeight()
    {
        return height;
    }


    /***************************************************************************
     * Set the new size of the canvas.
     *
     * @param  width   The new canvas width in pixels
     * @param  height  The new canvas height in pixels
     */
    public void setSize(int width, int height)
    {
        setSizePrivate(width, height);
        setVisible(true);
        prepareImage();
        clear();
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Draws a line
     * with given starting and ending point and given color.
     *
     * @param  x1    The horizontal coordinate of the start of the drawn line
     * @param  y1    The vertical coordinate of the start of the drawn line
     * @param  x2    The horizontal coordinate of the end of the drawn line
     * @param  y2    The vertical coordinate of the end of the drawn line
     * @param  color The color of the drawn line
     */
    public void drawLine(int x1, int y1, int x2, int y2, NamedColor color)
    {
        setForegroundColor(color);
        painter.drawLine(x1, y1, x2, y2);
        canvasPanel.repaint();
    }


    /***************************************************************************
     * Draws the given text by current font and given color.
     *
     * @param text   The drawn text.
     * @param x      The horizontal coordinate of the drawn text
     * @param y      The vertical coordinate of the drawn text
     * @param color  The color of the drawn text
     */
    public void drawString(String text, int x, int y, NamedColor color)
    {
        setForegroundColor(color);
        painter.drawString(text, x, y);
        canvasPanel.repaint();
    }


    /***************************************************************************
     * Clears the canvas, it means that it erases all the shapes on the canvas.
     */
    public void clear()
    {
        erase(new Rectangle2D.Double(0, 0, width, height));
    }


    /***************************************************************************
     * Erases the given shape. However its instance still exist,
     * it is only not visible, because it is panted by background color.
     *
     * @param shape Shape which should be erased.
     */
    public void erase(Shape shape)
    {
        Color original = painter.getColor();
        painter.setColor(backgroundColor.getAwtColor());
        painter.fill(shape);
        painter.setColor(original);
        canvasPanel.repaint();
    }


    /***************************************************************************
     * Returns the string representation of canvas.
     * It is used mainly by debugging.
     *
     * @return The string representation of the canvas.
     */
    @Override
    public String toString()
    {
        return this.getClass().getName() +
            "(" + width + "x" + height +
            " points, background color=" + backgroundColor + ")";
    }


    /***************************************************************************
     * Paints the given shape and fiil it by the canvas color.
     *
     * @param shape Shape which should be painted.
     */
    public void fill(Shape shape)
    {
        painter.fill(shape);
        canvasPanel.repaint();
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================

    /***************************************************************************
     * Initialize some parameters from the configuration file.
     * This file is placed in the user home directory
     * in the folder {@code .rup} in the file {@code bluej.properties}.
     * It is meant primary for teachers to make easy placing the window
     * by working with several displays, but only one visible by students.
     *
     * @return The initial canvas position
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
     * Initialize a canvas manager by putting the initializing code
     * into the AWT Event Queue.
     */
    private static void initialize()
    {
        final Point  position = configurationFromFile();
        final Holder holder   = new Holder();

        Runnable prepareCanvas = new Runnable() {
            @Override public void run()
            {
                holder.canvas = new Canvas(position);
            }
        };
        try {
            java.awt.EventQueue.invokeAndWait(prepareCanvas);
        } catch (InterruptedException | InvocationTargetException ex) {
            StringWriter sw = new StringWriter();
            PrintWriter  pw = new PrintWriter(sw);

            sw.write("\nCreation of CanvasManager didn't succeed\n");
            ex.printStackTrace(pw);

            String msg = sw.toString();
            System.err.println(msg);
            JOptionPane.showMessageDialog(null, msg);

            System.exit(1);
        }

        //Canvas is made, we will place the dialogs
        Canvas canvas = holder.canvas;
        int x = canvas.frame.getX();
        int y = canvas.frame.getY() + canvas.frame.getHeight();
        IO.setDialogsPosition(x, y);

        //Everything is ready, we may initialize
        SINGLETON = canvas;

    }



    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * Prepares the image, on which the all shapes will be painted.
     */
    private void prepareImage()
    {
        canvasImage = canvasPanel.createImage(width, height);
        painter = (Graphics2D)canvasImage.getGraphics();
        painter.setColor(backgroundColor.getAwtColor());
        painter.fillRect(0, 0, width, height);
        painter.setColor(java.awt.Color.BLACK);
    }


    /***************************************************************************
     * Set only the size of the canvas.
     * It is a private version intended only for the constructor.
     * The public version add making the window visible and preparing the image.
     *
     * @param width  The set canvas width in points
     * @param height The set canvas height in points
     */
    private void setSizePrivate(int width, int height)
    {
        boolean toCorrect;
        Dimension dim;
        Insets    ins;
        do {
            this.width = width;
            this.height = height;
            frame.setResizable(true);
            canvasPanel.setPreferredSize(new Dimension(width, height));
            frame.pack();
            dim = frame.getSize();
            ins = frame.getInsets();
//            IO.inform(
//                   "I set : width=" + width + ", height=" + height +
//                 "\nI have: width=" + dim.width + ", height=" + dim.height +
//                 "\nleft=" + ins.left + ", right=" + ins.right +
//                 "\n top=" + ins.top + ", bottom=" + ins.bottom);
            toCorrect = false;
            if (width < (dim.width - ins.left - ins.right)) {
                width  = dim.width - ins.left - ins.right + 2;
                toCorrect= true;
            }
            if (height < (dim.height - ins.top - ins.bottom)) {
                height  = dim.height - ins.top - ins.bottom;
                toCorrect= true;
            }
        } while (toCorrect);

        frame.setResizable(false);    //Není možné měnit rozměr pomocí myši
//        IO.Correction.windowSize(frame);
    }


    /***************************************************************************
     * Method called from the event thread.
     */
    private void setVisibleInternal()
    {
        framePosition = frame.getLocation();
        frame.setVisible(true);

        //With more displays the window doesn't work well - it is
        frame.setLocation(framePosition);  //necessary to set position again
        frame.setAlwaysOnTop(true);
        frame.toFront();
        frame.setAlwaysOnTop(false);
    }



    //== EMBEDDED AND INNER CLASSES ============================================

    ////////////////////////////////////////////////////////////////////////////
    /***************************************************************************
     * Crate for the created canvas.
     */
    private static class Holder
    {
        volatile Canvas canvas;
    }
    ////////////////////////////////////////////////////////////////////////////



    //== TESTING CLASSES AND METHODS ===========================================
}
