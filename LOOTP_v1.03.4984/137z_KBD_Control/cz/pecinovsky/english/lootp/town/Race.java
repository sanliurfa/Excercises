/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;
import cz.pecinovsky.english.lootp.manager.Controller;
import cz.pecinovsky.english.lootp.manager.IControllable;

import cz.pecinovsky.english.lootp.util.Direction8;
import cz.pecinovsky.english.lootp.util.IO;
import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.Position;



/*******************************************************************************
 * Instances of the {@code Race} class represent races that can be attended.
 * The race is characterized by the ring where the vehicles run.
 * The racers can subsequently register at the race.
 * The next racer can register only after the previous one finished the race.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Race
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Manager of the canvas on which the instance will be painted. */
    private static final CanvasManager CM = CanvasManager.getInstance();



    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Ring, where the race takes place. */
    private final Ring ring;

    /** Road-field, which the racer starts from. */
    private final RoadField start;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** The checked racer that tries to run through the ring
     *  as quickly as possible. */
    private IRacer racer;

    /** Controller, mediating control from a keyboard. */
    private Controller controller;

    /** Next field, which the racer should reach
     *  and reaching of which will be checked. */
    private RoadField target;

    /** System time of the start. */
    private long time0;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates an instance that will be able to organize race at the given ring.
     *
     * @param ring Ring, where the race should be organized
     */
    public Race(Ring ring)
    {
        this.ring  = ring;
        this.start = ring.getStartField();
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Registers the given racer, places it at the race start
     * and registers it as a keyboard listener.
     *
     * @param racer Registering racer
     */
    public void register(IRacer racer)
    {
        if (this.racer != null) {
            IO.inform("At this race the racer\n" + this.racer +
                      "is already registered.\n" +
                      "You have to wait with your registration" +
                      "until this racer run to the finish.");
            return;                         //==========>
        }
        Position   position  = start.getPosition();
        int        module    = start.getModule();
        Direction8 direction = start.getDirection();

        racer.setPosition(position);
        racer.setModule(module);
        racer.setDirection(direction);

        this.controller = new Controller(racer);
        this.target     = start.getNext();
        this.racer      = racer;
        this.time0      = System.currentTimeMillis();

        //Ensure, that both, racer as well as its ring, will be visible
        CM.add(ring);
        CM.addAbove(ring, racer);
    }


    /***************************************************************************
     * Checks that the racer reaches the right running position (checkpoint).
     * If yes, prepare the next running position, if no, do nothing.
     *
     * @param racer Racer announcing reaching the next position
     */
    public void checkpoint(IRacer racer)
    {
        //Check, if it is the same racer - therefore the operator !=
        if (this.racer != racer) {
            return;                      //==========>
        }
        Position racerPosition  = racer .getPosition();
        Position targetPosition = target.getPosition();
        if (racerPosition.equals(targetPosition)) {
            if (target.equals(start)) {
                finishRace(racer);
                return;                  //==========>
            }
            target = target.getNext();
        }
    }


    /***************************************************************************
     * Returns a string representation of the object &ndash; its text signature.
     *
     * @return A string representation of the object
     */
    @Override
    public String toString()
    {
        return "Race_(ring=" + ring + ", racer=" + racer + ")";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * Finishes the race for the given racer.
     *
     * @param racer Racer finishing the race
     */
    private void finishRace(IRacer racer)
    {
        //Check, if it is the same racer - therefore the operator !=
        if (this.racer != racer) {
            return;                      //==========>
        }
        long now = System.currentTimeMillis();
        this.controller.stop();
        this.racer = null;
        int time = (int)(now - time0 + 50) / 100;
        System.out.println("\n\nThe racer " + racer.getName() +
               " ran the race in time " + time/10 + "," + time%10 + " second");
    }



    //== MEMBER DATA TYPES =====================================================
    //== TESTING CLASSES AND METHODS ===========================================

    /***************************************************************************
     * The test method.
     */
    public static void test()
    {
        Arrow  arrow = new Arrow(0, 0, NamedColor.WHITE);
        Vehicle_B vb = new Vehicle_B(arrow);

        //The racing ring can be selected by uncommenting appropriate line(s)
        Ring ring    = Ring.newLShapeRing(new Position(0,0), NamedColor.BROWN);
        //Ring ring    = Ring.newSquareRing(new Position(50,50));

        Race race    = new Race(ring);
        vb.setName("Racer");
        vb.registerFor(race);
    }
    //    /** @param args Command line arguments - not used. */
    //    public static void main(String[] args)  {  test();  }
}
