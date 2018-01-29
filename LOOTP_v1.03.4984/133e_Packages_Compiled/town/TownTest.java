/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package town;

import manager.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.*;



/*******************************************************************************
 * Testing class {@code TownTest} serves as a complex way to test
 * the class {@link Town}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class TownTest
{
	private CanvasManager CM;
	private Town town;

    //== CONSTANT CLASS FIELDS =================================================
    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================

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
        CM    = CanvasManager.getInstance();
        town = Town.getInstance();
        CM.setStepAndSize(20, 12, 12);
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
    //     /********************************************************************
    //      *
    //      */
    //     @Test
    //     public void testXXX()
    //     {
    //     }
    //
}
