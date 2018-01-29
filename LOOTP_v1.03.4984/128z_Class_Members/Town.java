/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */



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
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Moves the active field into another position in the town
     * and automatically moves also the town on the canvas.
     * The current field should be always in the center of the canvas.
     * As of this moment program does not control,
     * if the field will be in the city.
     *
     * @param column The set current field column
     * @param row    The set current field row
     */
    public void setCurrentAt(int column, int row)
    {
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

        //The town base position has to be set up in that way, so that
        //the current field would be on the canvas in the calculated position
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


    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
    //
    //    /***************************************************************************
    //     * The test method.
    //     */
    //    public static void test()
    //    {
    //        Town inst = new Town();
    //    }
    //    /** @param args Command line arguments - not used. */
    //    public static void main(String[] args)  {  test();  }
}
