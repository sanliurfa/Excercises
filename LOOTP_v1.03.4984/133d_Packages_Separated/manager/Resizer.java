/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package manager;




/*******************************************************************************
 * Instances of class {@code Resizer} works as servants
 * continuously resizing the served instances implementing the interface
 * {@code IResizable}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Resizer
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Time between particular jerks.*/
    private final static int PERIOD = 30;



    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================

    /** Specify the power of the jerk, which means
     *  how much the size increases or decreases by one jerk. */
    private int power;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a resizer with power = 1 (power defines how much
     * the size increases or decreases by one jerk.
     */
    public Resizer()
    {
        this(1);
    }


    /***************************************************************************
     * Creates a resizer with the specified power (power defines how much
     * the size increases or decreases by one jerk.
     *
     * @param power  Size change after one jerk
     */
    public Resizer(int power)
    {
        this.power = power;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Metoda zvětší zadanou instanci na zadaný násobek její velikosti.
     *
     * @param times  Kolikrát se má zvětšit velikost daného objektu
     * @param object Objekt, jehož velikost je upravována
     */
    public void resizeByMultipleOf(double times, IModular object)
    {
        resizeByMultipleOf(times, object, Direction8.NORTH_WEST);
    }


    /***************************************************************************
     * Metoda zvětší zadanou instanci na zadaný násobek její velikosti.
     *
     * @param times  Kolikrát se má zvětšit velikost daného objektu
     * @param object Objekt, jehož velikost je upravována
     * @param fixed  Směr od středu obrazce, v němž se nachází pevný bod,
     *               který při změně rozměru nemění svoji pozici.
     *               Směry {@link Direction8#NOWHERE} a {@code null} označují
     *               symetrickou změnu vůči středu obrazce.
     */
    public void resizeByMultipleOf(double times, IModular   object,
                                                 Direction8 fixed)
    {
        int module = (int)(object.getModule() * times);
        resize(object, module, fixed);
    }


    /***************************************************************************
     * Changes the size of the specified instance to the specified multiple.
     * By thich resize the aspect ratio doesn't change.
     *
     * @param multiple  How many times should the object increase or decrease
     *                  its size
     * @param object    Object with the changed size
     */
    public void resizeByMultipleOf(double multiple, IResizable object)
    {
        Size size  = object.getSize();
        int width  = (int)Math.round(size.width  * multiple);
        int height = (int)Math.round(size.height * multiple);
        resize(object, width, height, Direction8.NORTH_WEST);
    }


    /***************************************************************************
     * Changes the size of the specified instance to the specified multiple
     * with the specified point at the perimeter of the circumscribe rectangle
     * which doesn't move during the size change.
     * By which resize the aspect ratio doesn't change.
     *
     * @param multiple   How many times should the object increase or decrease
     *                   its size
     * @param object Object with the changed size
     * @param fixed  Direction from the center of the shape where is the point,
     *               which position doesn't change during resizing.
     *               Directions {@link Direction8#NOWHERE} a {@code null}
     *               specifies the point in the shape's center
     */
    public void resizeByMultipleOf(double multiple, IChangeable object,
                                   Direction8 fixed)
    {
        Size size  = object.getSize();
        int width  = (int)Math.round(size.width  * multiple);
        int height = (int)Math.round(size.height * multiple);
        resize((IResizable)object, width, height, fixed);
    }


    /***************************************************************************
     * Nafoukne či vyfoukne zadaný objekt na požadovanou velikost.
     * Nejprve ale zabezpečí, aby byl objekt zobrazen na plátně.
     *
     * @param module   Požadovaný výsledný rozměr objektu
     * @param object Objekt, jehož velikost je upravována
     */
    public void resizeTo(int module, IModular object)
    {
        resize(object, module, Direction8.NORTH_WEST);
    }


    /***************************************************************************
     * Nafoukne či vyfoukne zadaný objekt na požadovanou velikost.
     * Nejprve ale zabezpečí, aby byl objekt zobrazen na plátně.
     *
     * @param module Požadovaný výsledný rozměr objektu
     * @param object Objekt, jehož velikost je upravována
     * @param fixed  Směr od středu obrazce, v němž se nachází pevný bod,
     *               který při změně rozměru nemění svoji pozici.
     *               Směry {@link Direction8#NOWHERE} a {@code null} označují
     *               symetrickou změnu vůči středu obrazce.
     */
    public void resizeTo(int module, IModular object, Direction8 fixed)
    {
        resize(object, module, fixed);
    }


    /***************************************************************************
     * Nafoukne či vyfoukne zadaný objekt na požadovanou velikost.
     * Nejprve ale zabezpečí, aby byl objekt zobrazen na plátně.
     *
     * @param size   Požadovaný výsledný rozměr objektu
     * @param object Objekt, jehož velikost je upravována
     */
    public void resizeTo(Size size, IResizable object)
    {
        resize(object, size.width, size.height, Direction8.NORTH_WEST);
    }


    /***************************************************************************
     * Changes the size of the specified instance to the specified sizes.
     *
     * @param width  The new width of the resized object
     * @param height The new height of the resized object
     * @param object Object with the changed size
     */
    public void resizeTo(int width, int height, IResizable object)
    {
        resize(object, width, height, Direction8.NORTH_WEST);
    }


    /***************************************************************************
     * Nafoukne či vyfoukne zadaný objekt na požadovanou velikost.
     * Nejprve ale zabezpečí, aby byl objekt zobrazen na plátně.
     *
     * @param size   Požadovaný výsledný rozměr objektu
     * @param object Objekt, jehož velikost je upravována
     * @param fixed  Směr od středu obrazce, v němž se nachází pevný bod,
     *               který při změně rozměru nemění svoji pozici.
     *               Směry {@link Direction8#NOWHERE} a {@code null} označují
     *               symetrickou změnu vůči středu obrazce.
     */
    public void resizeTo(Size size, IChangeable object, Direction8 fixed)
    {
        resize((IResizable)object, size.width, size.height, fixed);
    }


    /***************************************************************************
     * Changes the size of the specified instance to the specified sizes
     * with the specified point at the perimeter of the circumscribe rectangle
     * which doesn't move during the size change.
     *
     * @param width  The new width of the resized object
     * @param height The new height of the resized object
     * @param object Object with the changed size
     * @param fixed  Direction from the center of the shape where is the point,
     *               which position doesn't change during resizing.
     *               Directions {@link Direction8#NOWHERE} a {@code null}
     *               specifies the point in the shape's center
     */
    public void resizeTo(int width, int height, IChangeable object,
                         Direction8 fixed)
    {
        resize((IResizable)object, width, height, fixed);
    }


    /***************************************************************************
     * Metoda zvětší zadanou instanci o zadaný násobek síly svého kompresoru.
     * Při změně velikosti se zachovává poměr stran.
     * Nejprve ale zabezpečí, aby byl objekt zobrazen na plátně.
     *
     * @param resizing Požadovaná změna rozměru
     * @param object   Objekt, jehož velikost je upravována
     */
    public void resizeBy(int resizing, IModular object)
    {
        resizeBy(resizing, object, Direction8.NORTH_WEST);
    }


    /***************************************************************************
     * Metoda zvětší zadanou instanci o zadaný násobek síly svého kompresoru.
     * Při změně velikosti se zachovává poměr stran.
     * Nejprve ale zabezpečí, aby byl objekt zobrazen na plátně.
     *
     * @param resizing Požadovaná změna rozměru
     * @param object   Objekt, jehož velikost je upravována
     * @param fixed    Směr od středu obrazce, v němž se nachází pevný bod,
     *                 který při změně rozměru nemění svoji pozici.
     *                 Směry {@link Direction8#NOWHERE} a {@code null} označují
     *                 symetrickou změnu vůči středu obrazce.
     */
    public void resizeBy(int resizing, IModular object, Direction8 fixed)
    {
        resize(object, object.getModule() + resizing, fixed);
    }


    /***************************************************************************
     * Metoda zvětší zadanou instanci o zadaný násobek síly svého kompresoru.
     * Při změně velikosti se zachovává poměr stran.
     * Nejprve ale zabezpečí, aby byl objekt zobrazen na plátně.
     *
     * @param resizing Požadovaná změna rozměru
     * @param object   Objekt, jehož velikost je upravována
     */
    public void resizeBy(Size resizing, IResizable object)
    {
        resizeBy(resizing.width, resizing.height, object);
    }


    /***************************************************************************
     * Changes the size of the specified instance by the specified sizes.
     *
     * @param dx     The change of the size in the horizontal direction
     * @param dy     The change of the size in the vertical direction
     * @param object Object with the changed size
     */
    public void resizeBy(int dx, int dy, IResizable object)
    {
        Size size  = object.getSize();
        int width  = size.width  + dx;
        int height = size.height + dy;
        resize(object, width, height, Direction8.NORTH_WEST);
    }


    /***************************************************************************
     * Metoda zvětší zadanou instanci o zadaný násobek síly svého kompresoru.
     * Při změně velikosti se zachovává poměr stran.
     * Nejprve ale zabezpečí, aby byl objekt zobrazen na plátně.
     *
     * @param resizing Požadovaná změna rozměru
     * @param object   Objekt, jehož velikost je upravována
     * @param fixed    Směr od středu obrazce, v němž se nachází pevný bod,
     *                 který při změně rozměru nemění svoji pozici.
     *                 Směry {@link Direction8#NOWHERE} a {@code null} označují
     *                 symetrickou změnu vůči středu obrazce.
     */
    public void resizeBy(Size resizing, IChangeable object, Direction8 fixed)
    {
        resizeBy(resizing.width, resizing.height, object, fixed);
    }


    /***************************************************************************
     * Changes the size of the specified instance by the specified sizes
     * with the specified point at the perimeter of the circumscribe rectangle
     * which doesn't move during the size change.
     *
     * @param dx     The change of the size in the horizontal direction
     * @param dy     The change of the size in the vertical direction
     * @param object Object with the changed size
     * @param fixed  Direction from the center of the shape where is the point,
     *               which position doesn't change during resizing.
     *               Directions {@link Direction8#NOWHERE} a {@code null}
     *               specifies the point in the shape's center
     */
    public void resizeBy(int dx, int dy, IChangeable object, Direction8 fixed)
    {
        Size size  = object.getSize();
        int width  = size.width  + dx;
        int height = size.height + dy;
        resize((IResizable)object, width, height, fixed);
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * Nafoukne či vyfoukne zadaný objekt na požadovanou velikost.
     * Nejprve ale zabezpečí, aby byl objekt zobrazen na plátně.
     *
     * @param object Objekt, jehož velikost je upravována
     * @param module Požadovaný výsledný modul objektu
     * @param fixed  Směr od středu obrazce, v němž se nachází pevný bod,
     *               který při změně rozměru nemění svoji pozici.
     *               Směry {@link Direction8.NOWHERE} a {@code null} označují
     *               symetrickou změnu vůči středu obrazce.
     */
    private void resize(IModular object, int module, Direction8 fixed)
    {
        resize(new Modular2Changeable(object), module, module, fixed);
    }


    /***************************************************************************
     * Changes the size of the specified instance to the specified size
     * with the specified point at the perimeter of the circumscribe rectangle
     * which doesn't move during the size change.
     * If the direction to the fixed point is not specified,
     * the NORTHWEST (upper left corner) is set.
     *
     * @param object Object with the changed size
     * @param width  The new width of the resized object
     * @param height The new height of the resized object
     * @param fixed  Direction from the center of the shape where is the point,
     *               which position doesn't change during resizing.
     *               Directions {@link Direction8.NOWHERE} a {@code null}
     *               specifies the point in the shape's center
     */
    private void resize(IResizable object, int width, int height,
                        Direction8 fixed)
    {
        Size size  = object.getSize();
        int    ow  = size.width;
        int    oh  = size.height;
        int    horizontal = width  - ow;
        int    vertical   = height - oh;
        int    steps      = (int)(Math.hypot(horizontal, vertical) / power);
        double dx = (double)horizontal / steps;
        double dy = (double)vertical   / steps;
        execute(object, steps, dx, dy, fixed);
    }


    /***************************************************************************
     * Execution method performing the resizing.
     *
     * @param object    Object with the changed size
     * @param jerkCount Count of jerks using for resizing
     * @param dx        Horizontal change in one jerk
     * @param dy        Vertical change in one jerk
     * @param fixed     Direction to the fixed point
     */
    private void execute(IResizable object, int jerkCount,
                         double dx, double dy, Direction8 fixed)
    {
        if (fixed == null) {
            fixed = Direction8.NOWHERE;
        }
        IChangeable icho = null;    //Object casted to IChangeable
        double dxx = 0, dyy = 0;    //Position change in each jerk
        double x   = 0, y   = 0;    //Coordinates after jerk
        if (fixed != Direction8.NORTH_WEST)
        {
            if (! (object instanceof IChangeable)) {
                throw new IllegalArgumentException(
                      "\nOnly the instances of IChangeable can be resized " +
                        "with the fixed point in the direction " + fixed);
            }
            icho = (IChangeable)object;
            Position ihp = icho.getPosition();
            x  = ihp.x + .4;
            y  = ihp.y + .4;
            if (     (fixed == Direction8.SOUTH_EAST) ||
                     (fixed == Direction8.EAST)       ||
                     (fixed == Direction8.NORTH_EAST))
            {
                dxx = -dx;
            }
            else if ((fixed == Direction8.NORTH)  ||
                     (fixed == Direction8.SOUTH)  ||
                     (fixed == Direction8.NOWHERE))
            {
                dxx = -dx/2;
            }
            if (     (fixed == Direction8.SOUTH_WEST)  ||
                     (fixed == Direction8.SOUTH)       ||
                     (fixed == Direction8.SOUTH_EAST))
            {
                dyy = -dy;
            }
            else if ((fixed == Direction8.EAST)  ||
                     (fixed == Direction8.WEST)  ||
                     (fixed == Direction8.NOWHERE))
            {
                dyy = -dy/2;
            }
        }
        //We add the constant to make the jerks more equal
        Size   oldSize   = object.getSize();
        int    oldWidth  = oldSize.width;
        int    oldHeight = oldSize.height;
        double width     = oldWidth  + .4;
        double height    = oldHeight + .4;

        while (jerkCount-- > 0) {
            IO.pause(PERIOD);
            width  += dx;
            height += dy;
            object.setSize((int)width, (int)height);
            if (fixed != Direction8.NORTH_WEST) {
                x += dxx;
                y += dyy;
                icho.setPosition((int)x, (int)y);
            }
        }
    }



    //== MEMBER DATA TYPES =====================================================

    /*******************************************************************************
     * Instances of class {@code Modular2Changeable} adapt
     * the instances of the interface {@link IModular}
     * to instances of the interface {@link IChangeable}.
     */
    public class Modular2Changeable implements IChangeable
    {
        private final IModular delegate;

        public Modular2Changeable(IModular delegate) {
            this.delegate = delegate;
        }
        @Override public Size getSize() {
            int module = delegate.getModule();
            return new Size(module, module);
        }
        @Override public void setSize(int width, int height) {
            if (width != height) {
                throw new IllegalArgumentException(
                      "\nThe width and height of a modular object should " +
                        "be the same: width=" + width + ", height=" + height);
            }
            delegate.setModule(width);
        }
        @Override public void setSize(Size size) {
            setSize(size.width, size.height);
        }
        @Override public Position getPosition() {
            return delegate.getPosition();
        }
        @Override public void setPosition(Position pozice) {
            delegate.setPosition(pozice);
        }
        @Override public void setPosition(int x, int y) {
            delegate.setPosition(x, y);
        }
        @Override public void paint(Painter painter) {
            delegate.paint(painter);
        }
    }



    //== TESTING CLASSES AND METHODS ===========================================
}
