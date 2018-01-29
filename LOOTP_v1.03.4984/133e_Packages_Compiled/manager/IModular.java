/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package manager;



/*******************************************************************************
 * Instances of interface {@code IChangeable} represents geometrical shapes
 * that can reveal and set their positions and module.
 * The object's module is the basic size from which we derive
 * all the gauges of the object. The module of a shape is mostly defined
 * as the size of its circumscribe square.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IModular extends IMovable
{
    //== CONSTANTS =============================================================
    //== DECLARED METHODS ======================================================

    /***************************************************************************
     * Returns the module &ndash; the basic size from which we derive
     * all the gauges of the object.
     *
     * @return The object's module
     */
//    @Override
    public int getModule();


    /***************************************************************************
     * Returns the module &ndash; the basic size from which we derive
     * all the gauges of the object.
     *
     * @param module  The set module
     */
//    @Override
    public void setModule(int module);



    //== INHERITED METHODS =====================================================
    //== EMBEDDED DATA TYPES ===================================================
}
