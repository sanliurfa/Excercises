/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;

import cz.pecinovsky.english.lootp.manager.CanvasManager;
import cz.pecinovsky.english.lootp.manager.Controller;
import cz.pecinovsky.english.lootp.manager.IControllable;

import cz.pecinovsky.english.lootp.util.IO;
import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.Position;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;



/*******************************************************************************
 * Instances of the {@code RaceLShape} class represents races that can be run.
 * All such races are taken at an L-shape ring, which means a ring created
 * by the {@link Ring#newLShapeRing(Position, NamedColor)} method.
 * Several racers can be registered at one race and all will be run
 * simultaneously, each at its own instance of the ring.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class RaceLShape implements IRace
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Manager of the canvas on which the instance will be painted. */
    private static final CanvasManager CM = CanvasManager.getInstance();

    /**Following three constants depends on the ring,
     * where the race will be organized.
     * This version assumes that it will be an L-shape ring. */

    /** The width of the needed place counted in fields -
     * it is the ring "field width" increase by one column.
     * It is needed for placing the rings one beside another. */
    private static final int RING_WIDTH = 5;

    /** The ring "field-height" needed for ordering of the canvas height. */
    private static final int RING_HEIGHT = 4;



    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Map assigning the needed information to particular racers. */
    Map<IRacer, Info> racer2info = new HashMap<>();

    /** Maximal allowed number of racers. */
    private final int maxRacers;

    /** The current step on the canvas. */
    private final int module;

    /** Number of rounds of the race. */
    private final int roundNumber;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** System time of the start. */
    private long time0;

    /** Number of till now registered racers
     *  and thus also number of created rings. */
    private int registered = 0;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Create an instance for organizing races on rings
     * returned by the {@link Ring#newLShapeRing(Position,NamedColor)} method.
     *
     * @param maxRacers Maximal allowed number of simultaneously racing racers
     * @param module    The required step of the canvas
     */
    public RaceLShape(int maxRacers, int module)
    {
        this(maxRacers, module, 1);
    }


    /***************************************************************************
     * Create an instance for organizing races on rings
     * returned by the {@link Ring#newLShapeRing(Position,NamedColor)} method.
     *
     * @param maxRacers Maximal allowed number of simultaneously racing racers
     * @param module    The required step of the canvas
     * @param roundNumber Number of rings of the race
     */
    public RaceLShape(int maxRacers, int module, int roundNumber)
    {
        this.maxRacers   = maxRacers;
        this.module      = module;
        this.roundNumber = roundNumber;
        CM.setStepAndSize(module, maxRacers*RING_WIDTH - 1, RING_HEIGHT);
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Open a dialog announcing start
     * and after closing it start measure the time.
     */
    public void start()
    {
        IO.inform("Press OK to start measure the time");
        Collection<Info> infos = racer2info.values();
        for (Info info : infos) {
            info.controller.start();
        }
        time0 = System.currentTimeMillis();
    }


    /***************************************************************************
     * Finish the race, terminates all registrations
     * and prepares for the new ones.
     */
    public void stop()
    {
        racer2info.clear();
    }


    /***************************************************************************
     * Register the given racer, place it at the race start,
     * learn its needed keys and rester it as a keyboard listener.
     *
     * @param racer Racer registering for the race
     */
    @Override
    public void register(IRacer racer)
    {
        if (registered >= maxRacers) {
            IO.inform("It is possible to register only : " + maxRacers +
                      " racers");
            return;
        }
        if (racer2info.containsKey(racer)) {
            IO.inform("The racer cannot be registered twice: " + racer);
            return;
        }
        Ring       ring       = prepareNextRing();
        RoadField  start      = ring.getStartField();
        Position   position   = start.getPosition();
        Controller controller = Controller.createFor(racer);
        RoadField  target     = start.getNext();

        Info info = new Info(ring, start, target, controller, roundNumber);
        racer2info.put(racer, info);

        racer.setPosition(position);
        racer.setModule(module);
        racer.setDirection(start.getDirection());

        //Ensure, that both, racer as well as its ring, will be visible
        CM.add(ring);
        CM.addAbove(ring, racer);
    }


    /***************************************************************************
     * Check that the racer reach the right running target (checkpoint).
     * If yes, prepare the next running position, if no, do nothing.
     *
     * @param racer Racer announcing reaching the next position
     */
    @Override
    public void checkpoint(IRacer racer)
    {
        Info info = racer2info.get(racer);
        if (info == null) {
            return;                      //==========>
        }
        Position racerPosition  = racer.getPosition();
        Position targetPosition = info.targetField.getPosition();
        if (racerPosition.equals(targetPosition)) {
            if (info.targetField == info.startField) {
                info.roundsLeft --;
                if (info.roundsLeft  > 0) {
                    finishRace(racer, info);
                    return;                  //==========>
                }
            }
            info.targetField = info.targetField.getNext();
        }
    }


    /***************************************************************************
     * Finish the race for the given racer.
     *
     * @param racer Racer finishing the race
     * @param info  Crate with information about racer
     */
    private void finishRace(IRacer racer, Info info)
    {
        long now = System.currentTimeMillis();
        info.controller.stop();
        int time = (int)(now - time0 + 50) / 100;
        System.out.println("Racer " + racer.getName() +
               " completed the ring in the time " + time/10 + "," + time%10 +
               " second");
        racer2info.remove(racer);
        if (racer2info.isEmpty()) {
            System.out.println("Race finished");
//            IO.inform("Race finished" +
//                  "\n\nYou find the results at standard output");
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
        return "Race_L(L-shape ring, maxRacers=" + maxRacers +
               ", module=" + module + ")";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * Prepare next (and return) ring.
     *
     * @return Next ring
     */
    private Ring prepareNextRing()
    {
        int x = registered * RING_WIDTH * module;
        Position position = new Position(x, 0);
        Ring ring = Ring.newLShapeRing(position,
                                       NamedColor.getNamedColor(registered));
        registered = registered + 1;
        return ring;
    }



    //== MEMBER DATA TYPES =====================================================

    /***************************************************************************
     * Internal crate containing the basic needed information
     * about racer and its current state.
     */
    private static class Info
    {
        /** Ring, where the race takes place. */
        private final Ring ring;

        /** The starting field and thus also the finish field. */
        private final RoadField startField;

        /** Current running target.  */
        private RoadField targetField;

        /** Controller, mediating control from a keyboard. */
        private final Controller controller;

        /** Number of remaining rounds. */
        private int roundsLeft ;


        /***********************************************************************
         * Define a new crate and initialize its fields.
         *
         * @param ring         Ring, where the race takes place
         * @param startField   The starting field and thus also the finish field
         * @param targetField  The first checkpoint
         * @param controller   Controller, mediating control from a keyboard
         * @param roundsNumber Number of rounds
         */
        Info(Ring ring, RoadField startField, RoadField targetField,
             Controller controller, int roundsNumber)
        {
            this.ring        = ring;
            this.startField  = startField;
            this.targetField = targetField;
            this.controller  = controller;
            this.roundsLeft  = roundsNumber;
        }
    }



    //== TESTING CLASSES AND METHODS ===========================================

    /***************************************************************************
     * The test method.
     */
    public static void test()
    {
        RaceLShape závod = new RaceLShape(3, 100);

        Arrow  arrow = new Arrow(0, 0, NamedColor.WHITE);
        Vehicle_B v1 = new Vehicle_B(arrow);
        v1.setName("Jednička");
        v1.registerFor(závod);

        Car  car = new Car(0, 0, NamedColor.WHITE);
        Vehicle_B v2 = new Vehicle_B(car);
        v2.setName("Dvojka");
        v2.registerFor(závod);

        závod.start();
    }
    //    /** @param args Command line arguments - not used. */
    //    public static void main(String[] args)  {  test();  }
}
