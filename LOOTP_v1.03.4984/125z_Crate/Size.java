/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */



/*******************************************************************************
 * Instances of class {@code Position} are trasport objects (crates)
 * containing dimensions.
 * Their attributes are therefore defined as public constants.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Size
{
    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Object width. */
    public final int width;

    /** Object height. */
    public final int height;



    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS========================================

    /***************************************************************************
     * Creates a crate containing given dimensions.
     *
     * @param width  Object width
     * @param height Object height
     */
    public Size(int width, int height)
    {
        this.width  = width;
        this.height = height;
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns the object width.
     *
     * @return  Object width
     */
    public int getWidth()
    {
        return width;
    }


    /***************************************************************************
     * Returns the object height.
     *
     * @return  Object height
     */
    public int getHeight()
    {
        return height;
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
//        Size inst = new Size();
//    }
//    /** @param args Command line arguments - they are not used. */
//    public static void main(String[] args)  {  test();  }
}
