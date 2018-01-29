/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */

import java.awt.geom.Rectangle2D;


/*******************************************************************************
 * Instance třídy představují startovací a přistávací rampy.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Ramp extends Dispatcher.Shape
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Odkaz na okno, ve kterém se všechno kreslí. */
    protected static final Space SPACE = Space.getSpace();



    //== VARIABLE CLASS FIELDS =================================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    Rectangle2D.Double square;
    Number number;



    //== VARIABLE INSTANCE FIELDS ==============================================
    //== CLASS GETTERS AND SETTERS =============================================
    //== OSTATNÍ METODY TŘÍDY ==================================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Vytvoří na zadaných souřadnicích rampu se zadaným číslem.
     *
     * @param number  Number konstruované rampy
     * @param x      Vodorovná souřadnice konstruované rampy
     * @param y      Svislá souřadnice konstruované rampy
     */
    public Ramp(int number, double x, double y)
    {
        super(x, y, 2*Dispatcher.DIAMETER, Dispatcher.rampColor);
        this.number = new Number(number, x, y);
        int r2 = size >> 1;   //Poloviční size
        square = new Rectangle2D.Double(
            (int)xPos-r2, (int)yPos-r2, size, size);
        paint();
    }



    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== PŘEKRYTÉ METODY IMPLEMENTOVANÝCH ROZHRANÍ =============================

    /***********************************************************************
     * Nakreslí svoji instanci.
     * Při kreslení považuje za svoji pozici střed čtverce.
     */
    @Override
    public void paint()
    {
        SPACE.setForegroungColor(color);
        SPACE.fill(square);
        number.paint();
    }



    //== PŘEKRYTÉ ABSTRAKTNÍ METODY RODIČOVSKÉ TŘÍDY ===========================
    //== PŘEKRYTÉ KONKRÉTNÍ METODY RODIČOVSKÉ TŘÍDY ============================
    //== NOVĚ ZAVEDENÉ METODY INSTANCÍ =========================================

    /***********************************************************************
     * Zaparkuje zadané UFO nad svým středem.
     *
     * @param ufo  UFO, které je třeba zaparkovat.
     */
    public void park(IUFO ufo)
    {
        ufo.stopEngine();
        ufo.setSpeed(xPos - ufo.getX(),  yPos - ufo.getY());
        ufo.move(1);
        ufo.setSpeed(0, 0);
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== VNOŘENÉ A VNITŘNÍ TŘÍDY ===============================================
    //== TESTING CLASSES AND METHODS ===========================================
}
