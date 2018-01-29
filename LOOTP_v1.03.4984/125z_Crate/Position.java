/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */



/*******************************************************************************
 * Instances of class {@code Position} are transport objects (crates)
 * containing coordinates.
 * Their attributes are therefore defined as public constants.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Position
{
    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Horizontal coordinate. */
    public final int x;

    /** Vertical coordinate. */
    public final int y;



    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS========================================

    /***************************************************************************
     * Creates a crate containing given coordinates.
     *
     * @param x Horizontal coordinate
     * @param y Vertical coordinate
     */
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns the horizontal coordinate.
     *
     * @return  The horizontal coordinate
     */
    public int getX()
    {
        return x;
    }


    /***************************************************************************
     * Returns the vertical coordinate.
     *
     * @return  The vertical coordinate
     */
    public int getY()
    {
        return y;
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================
    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== EMBEDDED AND INNER CLASSES ============================================
    //== TESTING CLASSES AND METHODS ===========================================
//
//    /***************************************************************************
//     * The test method.
//     */
//    public static void test()
//    {
//        Position inst = new Position();
//    }
//    /** @param args Command line arguments - they are not used. */
//    public static void main(String[] args)  {  test();  }
}
