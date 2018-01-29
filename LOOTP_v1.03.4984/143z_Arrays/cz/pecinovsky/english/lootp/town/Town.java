/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.IPaintable;
import cz.pecinovsky.english.lootp.manager.Painter;
import cz.pecinovsky.english.lootp.manager.Rectangle;
import cz.pecinovsky.english.lootp.manager.CanvasManager;

import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.IO;
import cz.pecinovsky.english.lootp.util.Position;
import cz.pecinovsky.english.lootp.util.Size;



/*******************************************************************************
 * Instance of {@code Town}class is a singleton and represents a town
 * in which we will subsequently add objects.
 * The town can be bigger than the canvas and will place itself so that
 * the current field will be in the center of the canvas
 * where the relative position of the current field in the town can be set.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Town implements IPaintable
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Initial number of columns. */
    private static final int COLUMN_COUNT_0 = 10;

    /** Initial number of rows. */
    private static final int ROW_COUNT_0 = 10;

    /** Canvas manager painting the town. */
    private static final CanvasManager CM = CanvasManager.getInstance();

    /** The only instance of the town. */
    private static final Town SINGLETON = new Town(COLUMN_COUNT_0, ROW_COUNT_0);



    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================
    //== VARIABLE INSTANCE FIELDS ==============================================

    /** Current size of the canvas manager step. */
    private int module = CM.getStep();

    /** Rectangle representing the town area. */
    private Rectangle ground;

    /** Rectangle highlighting the current field. */
    private Rectangle current;

    /** Current number of the columns in the town. */
    private int columnSize;

    /** Current number of the rows in the town. */
    private int rowSize;

    /** Column of the current field. */
    private int currentColumn;

    /** Row of the current field. */
    private int currentRow;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Returns the (only) instance of the town.
     *
     * @return Instance of the town
     */
    public static Town getInstance()
    {
        return SINGLETON;
    }


    /***************************************************************************
     * Creates a new town with the given number of columns and rows.
     * It is not possible to change the size of the town.
     *
     * @param columnSize Number of columns
     * @param rowSize    Number of rows
     */
    private Town(int columnSize, int rowSize)
    {
        this.columnSize = columnSize;
        this.rowSize    = rowSize;

        currentColumn = this.columnSize / 2;
        currentRow    = this.rowSize / 2;

        ground  = new Rectangle(0, 0, 1, 1, NamedColor.SMOKY);
        current = new Rectangle(0, 0, 1, 1, NamedColor.MILKY);

        CM.add(this);
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns the module size, i.e. the size of the town field.
     *
     * @return Size of the module
     */
    public int getModule()
    {
        return module;
    }


    /***************************************************************************
     * Returns the town field-size, i.e. number of its columns and rows.
     *
     * @return The current town field-size
     */
    public Size getFieldSize()
    {
        return new Size(columnSize, rowSize);
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Moves the active field into another position in the town
     * and automatically moves also the town on the canvas.
     * The current field should be always in the center of the canvas.
     * If the set position is not inside the town throws
     * the IllegalArgumentException.
     *
     * @param column The set current field column
     * @param row    The set current field row
     */
    public void setCurrentAt(int column, int row)
    {
        if ((column < 0)  ||  (this.columnSize <= column)  ||
            (row    < 0)  ||  (this.rowSize    <= row   )  )
        {
            throw new IllegalArgumentException("\n" +
                  "Position outside the town border.\n" +
                  "Coordinates have to be >=0, column < " + columnSize +
                  ", row < " +  rowSize + '\n' +
                  "However the column=" + column + "and row=" + row +
                  "were entered.");
        }
        currentColumn = column;
        currentRow    = row;
        CM.repaint();
    }


    /***************************************************************************
     * Paints the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
    @Override
    public void paint(Painter painter)
    {
        module = CM.getStep();
        int canvasColumns = CM.getColumns();
        int canvasRows    = CM.getRows();

        //The current town field should be in the canvas centre
        int curColumn = canvasColumns / 2;
        int curRow    = canvasRows   / 2;

        //Position of town base has to be set up that way, so the actual
        //field is on the canvas in calculated coordinates
        int townX = (curColumn - currentColumn) * module;
        int townY = (curRow    - currentRow) * module;
        ground.setPosition(townX, townY);
        ground.setSize(columnSize*module, rowSize*module);

        ground.paint(painter);

        current.setPosition((2*curColumn - 1) * module / 2,
                            (2*curRow    - 1) * module / 2);
        current.setSize (2*module);
        current.paint(painter);
    }


    /***************************************************************************
     *
     */
    public void přidejVozidlo()
    {

    }


    /***************************************************************************
     * Přidá do města zadaný okruha na zadanou políčkovou pozici
     * a pokud se okruh do města nevejde, zvětší velikost města.
     * Kříží-li se přidávaný okruh s nějakým již existujícím okruhem,
     * umístí na danou křižovatku trafficLight.
     *
     * @param okruh   Přidávaný okruh
     * @param pPozice Políčková pozice přidávaného okruhu
     */
    public void přidejOkruh(Ring okruh, Position pPozice)
    {

    }


    /***************************************************************************
     * Vrací textovou reprezentaci (podpis) dané instance
     * používanou především k ladicím účelům.
     *
     * @return Požadovaná textová reprezentace
     */
    @Override
    public String toString()
    {
        return "Město_(" + new Size(columnSize, rowSize) +
               ", current-" + new Position(currentColumn, currentRow) + ")";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
