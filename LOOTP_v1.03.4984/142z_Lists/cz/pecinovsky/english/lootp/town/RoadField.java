/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;
import cz.pecinovsky.english.lootp.manager.IModular;
import cz.pecinovsky.english.lootp.manager.Multishape;
import cz.pecinovsky.english.lootp.manager.Painter;
import cz.pecinovsky.english.lootp.manager.Rectangle;

import cz.pecinovsky.english.lootp.util.Direction8;
import cz.pecinovsky.english.lootp.util.IO;
import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.Position;



/*******************************************************************************
 * Instances of class {@code RoadField} represent parts,
 * from which the roads are built.
 * Each instance knows the direction in which it is driven through,
 * and its descendant that is a sibling, where the driven through cars arrive.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class RoadField implements IModular
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Canvas on which the instance will be painted. */
    private static final CanvasManager CM = CanvasManager.getInstance();



    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Rectangle representing the field's area at the canvas. */
    private final Rectangle area;

    /** Direction in which the field can be driven through. */
    private final Direction8 direction;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** Descendant is a {@code RoadField},
     *  where the driven through cars arrive. */
    private RoadField next;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates a starting field with the given position, direction and color.
     * <p>
     * Because a ring building starts with this constructor,
     * we call it the "<i>starting constructor</i>".
     *
     * @param position   Field position
     * @param direction  Direction in which the field will be driven through
     * @param color      Field color
     */
    public RoadField(Position position, Direction8 direction, NamedColor color)
    {
        int  module = CM.getStep();
        this.area   = new Rectangle(position.x, position.y,
                                    module,     module,     color);
        this.direction = direction;
    }


    /***************************************************************************
     * Creates a field following the field given as an argument
     * ({@code predecessor}), and being driven through in the given direction.
     * The created field borrows its size and color from the {@code predecessor}
     * and it also derives its position from the predecessor's
     * position, size and direction.
     * <p>
     * Because a ring building continues with these constructors,
     * we call it the "<i>continuing constructor</i>".
     *
     * @param predecessor Field, which will be followed by this field
     * @param direction   Direction in which the field will be driven through
     */
    public RoadField(RoadField predecessor, Direction8 direction)
    {
        int        module   = predecessor.getModule();
        Position   position = predecessor.direction.
                              nextPosition(predecessor.getPosition(), module);
        NamedColor color    = predecessor.area.getColor();

        this.area = new Rectangle(position.x, position.y,
                                  module,     module,     color);
        this.direction   = direction;
        /** Set itself as a successor of its predecessor */
        predecessor.next = this;
    }


    /***************************************************************************
     * Creates a field following the field given as an argument,
     * being driven through in the given direction,
     * and being followed by the given successor.
     * The created field borrows its size and color from this predecessor
     * and it also derives its position from the predecessor's
     * position, size and direction.
     * <p>
     * Because a ring building ends with these constructors
     * (it closes the created ring),
     * we call it the "<i>closing constructor</i>".
     *
     * @param predecessor Field, which will be followed by this field
     * @param direction   Direction in which the field will be driven through
     * @param successor   Field, which will follow this field
     */
    public RoadField(RoadField predecessor, Direction8 direction,
                     RoadField successor)
    {
        this(predecessor, direction);
        Position nextPosition = direction.nextPosition(getPosition(),
                                                       getModule());
        if (nextPosition.equals(successor.getPosition())) {
            this.next = successor;
        } else {
            IO.inform(
               "The first and the last ring fields are not correct neighbors");
        }
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Returns the size of the field &ndash; the length of its side.
     *
     * @return The length of the field's side
     */
    @Override
    public int getModule()
    {
        return area.getWidth();
    }


    /***************************************************************************
     * Sets the size of the field &ndash; the length of its side.
     *
     * @param module The new length of the field's side
     */
    @Override
    public void setModule(int module)
    {
        if (module <= 0) {
            throw new IllegalArgumentException(
                "\nVelikost modulu musí být nezáporná - zadáno " + module);
        }
        area.setSize(module);
    }


    /***************************************************************************
     * Returns the successor of the field.
     *
     * @return The field's successor
     */
    public RoadField getNext()
    {
        return next;
    }


    /***************************************************************************
     * Returns a crate with the pixel position of the field.
     *
     * @return  Pixel position of the field
     */
    @Override
    public Position getPosition()
    {
        return area.getPosition();
    }


    /***************************************************************************
     * Set the new field position.
     *
     * @param pozice  New field position
     */
    @Override
    public void setPosition(Position pozice)
    {
        area.setPosition(pozice);
    }


    /***************************************************************************
     * Set new field coordinates.
     *
     * @param x  New horizontal coordinate
     * @param y  New vertical coordinate
     */
    @Override
    public void setPosition(int x, int y)
    {
        area.setPosition(x, y);
    }


    /***************************************************************************
     * Returns the direction in which the field can be driven through.
     *
     * @return Direction in which the field can be driven through
     */
    public Direction8 getDirection()
    {
        return direction;
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Paints the instance by force of the specified painter.
     *
     * @param painter Painter drawing the instance
     */
    @Override
    public void paint(Painter painter)
    {
        area.paint(painter);
    }


    /***************************************************************************
     * Returns a string representation of the object &ndash; its text signature.
     * In general, the {@code toString} method returns a string
     * that "textually represents" this object.
     * The result should be a concise but informative representation
     * that is easy for a person to read.
     *
     * @return A string representation of the object
     */
    @Override
    public String toString()
    {
        return "RoadField_(" + area.getPosition() + ", Direction=" + direction +
               ", Module=" + area.getWidth() + ")";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================
}
