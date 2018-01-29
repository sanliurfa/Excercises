/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.tests;

import cz.pecinovsky.english.lootp.util.IO;


/*******************************************************************************
 * The class {@literal Xcrements} should demonstrate the behavior
 * of the increment and decrement operators.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Xcrements
{
    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================

    /** i, j, k are defined as static fields,
     *  to allow their sharing with the method show(String). */
    private static int i, j, k;

    /** Serves as an accumulator of the created string. */
    private static String  all = "";



    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    /***************************************************************************
     * Demonstrates that the operators behave as was explained.
     */
    public static void test()
    {
        //Static fields are zeroed at start => it suffices to set the "i"
        i = 1;              show("Initial values:");
        j = i++;            show("After (j = i++)");
        k = ++i;            show("After (k = ++i)");
        k = i-- + j--;      show("After (k = i-- + j--)");
        k = --i + --j;      show("After (k = --i + --j)");
        IO.inform(all);
        System.out.println(all);
    }



    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /* Blocks a constructor usage. */ private Xcrements() {}


    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================
    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================

    /***************************************************************************
     * Auxiliary method showing the last action and printing
     * through the method {@link IO.inform()} values of all numeric fields.
     * In addition the printed text is added to accumulator
     * that will be printed at the end.
     *
     * @param text Describing text starting the line
     */
    private static void show(String text)
    {
        text = text + ":  i=" + i + ",  j=" + j + ",  k=" + k;
//        IO.inform(text);
        all = all + "\n" + text;
    }



    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
