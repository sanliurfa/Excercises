/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.tests;

import java.util.Arrays;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testing class {@code ArrayTest} serves as a complex way to test
 * the class {@code Arrow}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class ArrayTest
{



    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    /***************************************************************************
     * Returns the index of the greatest number among the given numbers.
     *
     * @param ii Analyzed numbers
     * @return Index of the greatest number
     */
    public static int indexOfMax(int... ii)
    {
        int index = 0;
        int max   = ii[0];
        for (int i=1;   i < ii.length;   i++) {
            if (ii[i] > max) {
                index = i;
                max   = ii[i];
            }
        }
        return index;
    }


    /***************************************************************************
     * Returns the array which values are squares of the given numbers
     *
     * @param dd Given numbers
     * @return Array with the squares of the given numbers
     */
    public static double[] square(double[] dd)
    {
        double[] result = new double[dd.length];
        for (int i=0;   i < dd.length;   i++) {
            result[i] = dd[i] * dd[i];
        }
        return result;
    }



    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================
    //== PREPARATION AND CLEANING THE FIXTURE ==================================

    /***************************************************************************
     * Prepares the tested instances and performs the actions,
     * which should be performed before each test.
     */
    @Before
    public void setUp()
    {
    }


    /***************************************************************************
     * Cleans up after the ran test and performs the actions,
     * which should be performed after each test.
     */
    @After
    public void tearDown()
    {
    }


    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== THE TESTS =============================================================
    //
    //     /***************************************************************************
    //      *
    //      */
    //     @Test
    //     public void testXXX()
    //     {
    //     }
    //

    /***************************************************************************
     *
     */
    @Test
    public void testIndexOfMax()
    {
        int index = indexOfMax(1, 3, 2, 4, 3);
        System.out.println("Index = " + index);
        assertEquals(3, index);
    }


    /***************************************************************************
     *
     */
    @Test
    public void testSquare()
    {
        double[] source;
        double[] squares = square(source = new double[] {1, -1.5, 2, -2.5});
        System.out.println("Values  = " + Arrays.toString(source) +
                         "\nSquares = " + Arrays.toString(squares));
    }

}
