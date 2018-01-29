/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */


import java.util.HashMap;
import java.util.Map;



/*******************************************************************************
 * The instances of class {@code Direction8} represent
 * the 8 cardinal and intercardinal directions and "no direction" NULL.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public enum Direction8
{
    //== VALUES OF THE ENUMERATION TYPE ========================================

    /** East direction.       */  EAST       ("E",   1,  0),
    /** North-east direction. */  NORTH_EAST ("NE",  1, -1),
    /** North direction.      */  NORTH      ("N",   0, -1),
    /** North-west direction. */  NORTH_WEST ("NW", -1, -1),
    /** West direction.       */  WEST       ("W",  -1,  0),
    /** South-west direction. */  SOUTH_WEST ("SW", -1,  1),
    /** South direction.      */  SOUTH      ("S",   0,  1),
    /** South-east direction. */  SOUTH_EAST ("SE",  1,  1),
    /** No direction.         */  NOWHERE    ("",    0,  0),
    ;



    //== CONSTANT CLASS FIELDS =================================================

    /** The number of defined directions. */
    public  static final int NUM_DIRS = values().length;

    /** The mask used with logical operations insted of division modulo.
     *  The expression expect that the number of directions is a power of two
     *  plus 1 for the direction NOWHERE. */
    private static final int MASK = 7;

    /** The square root from one half for computing the diagonal distances. */
    private static final double SQR = Math.sqrt(0.5);

    /** The map converting direction names or shorcuts
     *  to the appropriate direction. */
    private static final Map<String, Direction8> name2direction =
                                                 new HashMap<>(NUM_DIRS*3);



    //== VARIABLE CLASS FIELDS =================================================

    /** Flag announcing if the use of the NOWHERE value is allowed. */
    private static boolean nowhereProhibited = false;



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================

    //Initialization of static fields is not feasible before definition
    //of all the values => we should perform it subsequently
    static
    {
        if (NUM_DIRS != 9) {
            throw new RuntimeException(
                "\nSource code damaged - the wrong number of directions");
        }
        for (Direction8 dir : values())  {
            name2direction.put(dir.name(),   dir);
            name2direction.put(dir.shortcut, dir);
        }
    }



    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Coordinate changes by movement
     *  to the next field in this direction. */
    private final int dx, dy;

    /** One or two-letter shorcut of this direction. */
    private final String shortcut;



    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    /***************************************************************************
     * Vrátí vektor se čtyřmi hlavními světovými stranami.
     *
     * @return  Požadovaný vektor.
     */
    public static Direction8[] values4()
    {
        return new Direction8[] { EAST, NORTH, WEST, SOUTH };
    }


    /***************************************************************************
     * Set if the operations with the direction {@link #NOWHERE}.
     * If these operations are prohibited, the methods throws by such an
     * attempt the {@link java.lang.IllegalStateException}.
     * If these operations are allowed any object "turned" to this direction
     * remains in this direction after any turn
     * and after any movement it remains in the origin position.
     *
     * @param prohibit {@code true} to prohibit the operations,
     *                 {@code false} to allow the operations
     * @return The previous setting of this property
     */
    public static boolean prohibitNowhere(boolean prohibit) {
        boolean original = nowhereProhibited;
        nowhereProhibited = prohibit;
        return original;
    }



    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Returns the direction with the given name or abbreviation.
     * Unfortunately it is not able to name this method {@code valueOf()},
     * because the compiler defines it in this class
     * and so it cannot be overridden by our version.
     *
     * @param  name  Name or abbreviation of asked direction;
     *               the name is not case sensitive
     * @return Asked direction
     * @throws IllegalArgumentException  If there is no direction with given
     *                                   name or abbreviation
     */
    public static Direction8 get(String name)
    {
        Direction8 dir = name2direction.get(name.toUpperCase());
        if (dir == null) {
            throw new IllegalArgumentException("\nThere is no direction " +
                                    "with this name or abbreviation: " + name);
        }
        return dir;
    }


    /**************************************************************************
     * Creates a new direction with given shortcut
     * and coordinate offsets to the next field in this direction.
     *
     * @param shortcut  One or two-letter shortcut
     * @param dx        The difference of horizontal coordinate
     *                  by movement to the adjacent field in this direction
     * @param dy        The difference of vertical coordinate
     *                  by movement to the adjacent field in this direction
     */
    private Direction8(String shortcut, int dx, int dy)
    {
        this.shortcut = shortcut;
        this.dx = dx;
        this.dy = dy;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns the shorctu of this direction.
     *
     * @return  The askec shortcut
     */
    public String getShortName()
    {
        return shortcut;
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /**************************************************************************
     * Gets the x-coordinate of the field and returns the x-cordinates of
     * the next field in this direction.
     *
     * @param  x Given x-coordinate
     * @return x-coordinate of the next field in this direction
     */
    public int nextX(int x)
    {
        verifyAllowed();
        return x + dx;
    }


    /**************************************************************************
     * Gets the x-coordinate of the field and returns the x-cordinate
     * of the field in the given distance in this direction.
     *
     * @param x         Given y-coordinate
     * @param distance  The distance to the asked field
     * @return x coordinate of the field in the given distance in this direction
     */
    public double nextX(int x, int distance)
    {
        verifyAllowed();
        if ((dx != 0)  &&  (dy != 0)) {
            return x + SQR*dx*distance;
        } else {
            return x + dx*distance;
        }
    }


    /**************************************************************************
     * Gets the y-coordinate of the field and returns the y-cordinate
     * of the next field in this direction.
     *
     * @param y Given x-coordinate
     * @return y-coordinate of the next field in this direction
     */
    public int nextY(int y)
    {
        verifyAllowed();
        return y + dy;
    }


    /**************************************************************************
     * Gets the y-coordinate of the field and returns the y-cordinate
     * of the field in the given distance in this direction.
     *
     * @param y         Given y-coordinate
     * @param distance  The distance to the asked field
     * @return y coordinate of the field in the given distance in this direction
     */
    public double nextY(int y, int distance)
    {
        verifyAllowed();
        if ((dx != 0)  &&  (dy != 0)) {
            return y + SQR*dy*distance;
        } else {
            return y + dy*distance;
        }
    }


    /**************************************************************************
     * Vrátí změnu vodorovné souřadnice při přesunu
     * na sousední pole v daném směru.
     *
     * @return Změna x-ové souřadnice při přesunu o jedno pole v daném směru
     */
    public int dx()
    {
        verifyAllowed();
        return dx;
    }


    /**************************************************************************
     * Vrátí změnu svislé souřadnice při přesunu
     * na sousední pole v daném směru.
     *
     * @return Změna y-ové souřadnice při přesunu o jedno pole v daném směru
     */
    public int dy()
    {
        verifyAllowed();
        return dy;
    }


    /***************************************************************************
     * Returns the direction turned by 90 degree left.
     *
     * @return Direction turned by 90 degree left
     */
    public Direction8 leftTurn()
    {
        return turnBy(2);
    }


    /***************************************************************************
     * Returns the direction turned by 90 degree right.
     *
     * @return Direction turned by 90 degree right
     */
    public Direction8 rightTurn()
    {
        return turnBy(-2);
    }


    /***************************************************************************
     * Returns the direction turned by 180 degree.
     *
     * @return Direction turned by 180 degree
     */
    public Direction8 aboutTurn()
    {
        return turnBy(4);
    }


    /***************************************************************************
     * Returns the direction turned by 45 degree left.
     *
     * @return Direction turned by 45 degree left
     */
    public Direction8 halfLeft()
    {
        return turnBy(1);
    }


    /***************************************************************************
     * Returns the direction turned by 45 degree right.
     *
     * @return Direction turned by 45 degree right
     */
    public Direction8 halfRight()
    {
        return turnBy(-1);
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /**************************************************************************
     * Vrátí směr otočený o zadaný počet osminek (45°) vlevo.
     *
     * @param eighths Počet osminek, o něž se má směr otočit,
     *                přičemž záporný počet označuje otočku vpravo
     * @return Směr objektu po vyplnění příkazu
     */
    public Direction8 turnBy(int eighths)
    {
        verifyAllowed();
        return (this == NOWHERE)
               ?  NOWHERE
               :  values()[MASK & (eighths + ordinal())];
    }


    /***************************************************************************
     * Verify that it is not an operation
     * prohibited for direction {@link #NOWHERE}.
     *
     * @throws IllegalStateException This operation is prohibited
     *                               for the direction {@link #NOWHERE}
     */
    private void verifyAllowed()
    {
        if (nowhereProhibited  &&  (this == NOWHERE)) {
            Throwable t = new Throwable();
            StackTraceElement[] aste = t.getStackTrace();
            StackTraceElement   ste  = aste[1];
            String method = ste.getMethodName();

            throw new IllegalStateException("\nThis operation is prohibited "
                                   + "for the direction NOWHERE: " + method);
        }
    }



    //== EMBEDDED AND INNER CLASSES ============================================
    //== TESTING CLASSES AND METHODS ===========================================
}
