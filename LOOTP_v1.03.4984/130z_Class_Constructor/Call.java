/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */


/*******************************************************************************
 * Library class {@code Call} serves for demonstration of behavior
 * of class KTI when used for the first time and afterwards and for
 * demonstration of behavior of its constructors.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Call
{
    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    /***************************************************************************
     * Method does not use class CCI
     */
    public static void nothingNeeded()
    {
        window("nothingNeeded", "I was executed\nand I need nothing.");
    }


    /***************************************************************************
     * Method uses only class CCI, not its instances.
     */
    public static void classNeeded()
    {
        window("classNeeded", "I require a class-object.");
        Object clso = CCI.CLASS_OBJECT;
        window("classNeeded", "I recieved the object\n\n" + clso);
    }


    /***************************************************************************
     * Method needs instance of class CCI.
     */
    public static void instanceNeeded()
    {
        window("instanceNeeded", "I require an instance.");
        Object inst = new CCI();
        window("instanceNeeded", "I recieved the instance\n   " + inst);
    }


    /***************************************************************************
     * Method calls one-parametric constructor of CCI and knows,
     * that it will call the 2-parametric one,
     * that will call the 3-parametric one.
     * Method serves for explanation and demonstration of work with a debugger.
     */
    public static void testInvocation()
    {
        CCI inst = new CCI("Experiment");
        System.out.println("\n=================================" +
                           "\nCreated instance: " + inst +
                           "\n=================================");
    }



    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /** Library class without accessible constructor. */
    private Call() {}

    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================
    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================

    /***************************************************************************
     * Prints the given text to standard output and afterwards also in a dialog.
     *
     * @param method Calling method name
     * @param text   The additional text
     */
    private static void window(String method, String text)
    {
        System.out.println("\nvvvvvvvvvvvvvvvvvvvvv" +
                           "\nMethod: " + method + " - " + text +
                           "\n^^^^^^^^^^^^^^^^^^^^^");
        IO.inform(text);
    }



    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
