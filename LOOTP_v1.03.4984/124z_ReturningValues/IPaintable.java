/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */



/*******************************************************************************
 * Interface {@code IPaintable} must be implemented by all classes,
 * which want their instances be accepted as manageable
 * by an instance of the class {@link CanvasManager}.
 * It is the only way, how to reach the painting the instance
 * on display.
 * <p>
 * This interface requires the instances have a method {@link #paint(Painter)}
 * that paint the instance by force of the obtained painter.
 * <p>
 * In addition the implementing class promises,
 * that their instances will immediately inform canvas
 * about any change of their appearance by calling the method
 * {@link CanvasManager#repaint()}.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IPaintable
{
    //== CONSTANTS =============================================================
    //== DECLARED METHODS ======================================================

    /***************************************************************************
     * Paints the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
//     @Override
    public void paint(Painter painter);


    //== INHERITED METHODS =====================================================
    //== EMBEDDED DATA TYPES ===================================================
}
