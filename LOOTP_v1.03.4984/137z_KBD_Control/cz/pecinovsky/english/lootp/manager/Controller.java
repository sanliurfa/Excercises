/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.manager;

import cz.pecinovsky.english.lootp.util.IO;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;



/*******************************************************************************
 * Instances of the {@code Controller} class mediates controlling
 * from a keyboard for objects implementing {@code IControllable} interface.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Controller extends KeyAdapter
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Object serving as a event broadcaster
     *  where the controlled object should be registered as a listener. */
    private static final CanvasManager CM = CanvasManager.getInstance();

    /** Default watched keys. */
    private static final int[] DEFAULT_KEYS =
                               {  KeyEvent.VK_LEFT,  KeyEvent.VK_RIGHT,
                                  KeyEvent.VK_UP,    KeyEvent.VK_DOWN,
                                  KeyEvent.VK_SPACE, KeyEvent.VK_ENTER,
                                  KeyEvent.VK_ESCAPE };

    /** Indexes of the particular events in a vector. */
    private static final int LEFT =0, RIGHT=1,  UP    =2,  DOWN=3,
                             SPACE=4, ENTER=5,  ESCAPE=6,  NUMBER=ESCAPE+1;

    /** Names of the particular events. */
    private static final String[] NAMES =
           { "LEFT", "RIGHT", "UP", "DOWN", "SPACE", "ENTER", "STOP" };



    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================

    static {
        if ((DEFAULT_KEYS.length != NAMES.length)  ||
            (DEFAULT_KEYS.length != NUMBER))
        {
            throw new RuntimeException(
                    "\nThe number of the requested keays doesn't correspond " +
                    "with the number of their names");
        }
    }



    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Controlled object. */
    private final IControllable controlled;

    /** Controlling keys. */
    private final int[] keys;

    /** Key listener registered at the canvas manager. */
    private final KeyListener listener;

    /** Queue of events waiting fo processing in the private thread
     *  {@link #EventControlThread}. */
    BlockingQueue<KeyEvent> eventQueue = new LinkedBlockingQueue<>();



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** The thread processing the coming event
     *  and ensuring a reasonable reaction even in the case
     *  when a next even occurs before the previous on is processed. */
    volatile EventControlThread eventControlThread;



    //== CLASS GETTERS AND SETTERS =============================================

    /***************************************************************************
     * Returns an array with the default key-codes ordered in the sequence
     * LEFT, RIGHT, UP, DOWN, SPACE, ENTER, ESCAPE.
     *
     * @return Array with the default key-codes
     */
    public static int[] getDefaultKeys()
    {
        return DEFAULT_KEYS.clone();
    }



    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    /***************************************************************************
     * Ask the user, which keys he/she want to use the particular functions
     * and returns an array with kea-codes of the entered keys.
     *
     * @param names Names of th particular functions
     * @return Array with kea-codes of the entered keys
     */
    public static int[] askForKeys(String[] names)
    {
        final String[] prompts = numberNames(names, true);
        promptDialog(prompts);
        final Thread waitingThread = new Thread("Waiting for a user") {
            @Override
            public void run()
            {
                try {
                    sleep(123456);
                }catch(InterruptedException ie) {
                    return;
                }
                System.out.println("No response - I am endinig");
            }
        };
        final int   numNames = names.length;
        final int[] entered  = new int[numNames];
        final int[] order    = new int[1];
        KeyListener kl = new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e)
            {
                int next    = ++order[0];
                int keyCode = e.getKeyCode();
                entered[next-1] = keyCode;

                if (next == numNames) {
                    System.out.println(KeyEvent.getKeyText(keyCode) +
                                       " - kód: " + keyCode);
                    CM.removeKeyboardListener(this);
                    waitingThread.interrupt();
                }
                else {
                    System.out.print(KeyEvent.getKeyText(keyCode) +
                                     " - code: " + keyCode + prompts[next]);
                }
            }
        };
        String text = "\nLet's begin:" + prompts[0];
        System.out.print(text);
        waitingThread.start();
        CM.addKeyboardListener(kl);
        try {
            waitingThread.join();
        } catch (InterruptedException ex) {
            //Whe I am interrupted, I end
        }
        if (order[0] == numNames) {
            return entered;
        }
        return null;
    }



    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Ask the user for entering the keys and create a controller,
     * which will react to pressing of these keys
     * and so control the given controlled object.
     *
     * @param controlled The object, which should be controlled
     * @return The requested controller
     */
    public static Controller createFor(IControllable controlled)
    {
        int[] entered = askForKeys(NAMES);
        Controller controller  = new Controller(controlled, entered, false);
        return controller;
    }


    /***************************************************************************
     * Creates new controller of the given controlled object
     * controlled by the default key set and register this controller
     * as a class listener.
     *
     * @param controlled Controlled object
     */
    public Controller(IControllable controlled)
    {
        this(controlled, DEFAULT_KEYS, true);
    }


    /***************************************************************************
     * Creates new controller of the given controlled object
     * controlled by the default key set and register this controller
     * if the last argument value is {@code true}.
     *
     * @param controlled Controlled object
     * @param register If the controller should be immediately registered
     */
    public Controller(IControllable controlled, boolean register)
    {
        this(controlled, DEFAULT_KEYS, register);
    }


    /***************************************************************************
     * Creates new controller of the given controlled object
     * controlled by the given key set and register this controller
     * if the last argument value is {@code true}.
     *
     * @param controlled Controlled object
     * @param keys       Array with codes of the controlling keys
     * @param register   If the controller should be immediately registered
     */
    public Controller(IControllable controlled, int[] keys, boolean register)
    {
        if (keys.length != DEFAULT_KEYS.length) {
            throw new RuntimeException(
                    "\nŠpatný počet ovládacích kláves -\nŘadič je připraven " +
                    "ovládat svěřené objekty prostřednictvím právě " +
                    DEFAULT_KEYS.length + " kláves");

        }
        this.controlled = controlled;
        this.keys       = keys;
        this.listener   = new ThreadListener(eventQueue);
        CM.add(controlled);
        if (register) {
            start();
        }
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================

    /***************************************************************************
     * Return the controlled object.
     *
     * @return Controlled object
     */
    public IControllable getControlled()
    {
        return controlled;
    }



    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Unregister the keyboard listener.
     * For next registering the {@link #start()} method should be called.
     */
    public void stop()
    {
        CM.removeKeyboardListener(listener);
        eventControlThread.interrupt();
        eventControlThread = null;
    }


    /***************************************************************************
     * Registers itself as a keyboard listener.
     */
    public final void start()
    {
        CM.addToFront(controlled);
        CM.addKeyboardListener(listener);
        if (eventControlThread == null) {
            synchronized(this) {
                if (eventControlThread == null) {
                    eventControlThread = new EventControlThread(eventQueue);
                    eventControlThread.start();
                }
            }
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
        return "Controller{" + "controlled=" + controlled + '}';
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================

    /***************************************************************************
     * Opens a window with descriptions of particular keys.
     *
     * @param texts Descriptions
     */
    private static void promptDialog(String[] texts)
    {
        int count = texts.length;
        StringBuilder sb = new StringBuilder(
                "Confirm reading of this message by pressing OK" +
                "\nThen activate the canvas manager window (e.g. click on it)" +
                "\nand then gradually press " +
                "\nwith the following meanings (keep the order):\n");
        sb.append(count)
          .append(" keys\nwith the following meanings (keep the order):\n");
        for (int i=0;   i < count;   i++) {
            sb.append(texts[i]);
        }
        sb.append("\n\nStandard output will navigate you");
        IO.inform(sb.toString());
    }


    /***************************************************************************
     * Returns an array, where the numbered text from the given array will be.
     * The numbering will start form 1.
     *
     * @param names    Texts, which should be numbered
     * @param newLine  If the new line should be entered at the beginning
     *                 of each numbered text
     * @return Array with the numbered texts
     */
    private static String[] numberNames(String[] names, boolean newLine)
    {
        int number = names.length;
        String nl = newLine  ?  "\n"  :  "";
        String[] numbered  = new String[number];
        for (int i=0;   i < number;   i++) {
            numbered[i] = nl + (i+1) + ". " + names[i] + ": ";
        }
        return numbered;
    }



    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================
    //== MEMBER DATA TYPES =====================================================

    /***************************************************************************
     * Instances of the {@code ThreadListener} class serves
     * as keyboard listeners. Their only duty is to put all incoming events
     * into the event queue, from which a special thread peek them
     * and run their handling.
     */
    private
    class ThreadListener extends KeyAdapter
    {
        private final BlockingQueue<KeyEvent> eventQueue;


        /***********************************************************************
         * Creates a new keyboard listener putting all incoming events
         * into the event queue
         *
         * @param eventQueue Queue, into which all incoming events
         *                   events will be put
         */
        ThreadListener(BlockingQueue<KeyEvent> eventQueue)
        {
            this.eventQueue = eventQueue;
        }


        /***********************************************************************
         * Event handler.
         *
         * @param event Handled event
         */
        @Override
        public void keyPressed(KeyEvent event)
        {
            try {
                eventQueue.put(event);
            }
            catch (InterruptedException ex) {
                throw new RuntimeException(
                          "\nSomebody interrupted the thread,"
                        + "which is taken for unbreakable.", ex);
            }
        }
    }



///#############################################################################
///#############################################################################
///#############################################################################

    /***************************************************************************
     * Instance třídy {@code EventControlThread} definuje vlákno,
     * které má na starosti reakce na všechny uálosti,
     * aby se v případě, že obsluha je delší,
     * nezastavilo překreslování a jiné důležité činnosti.
     */
    private
    class EventControlThread extends Thread
    {
        private final BlockingQueue<KeyEvent> eventQueue;


        /***********************************************************************
         * Vytvoří nové vlákno synchronizované zadanou frontou.
         *
         * @param eventQueue Fronta, do níž jsou vkládány události,
         *        které jsou pak ve vlákně ošetřovány
         */
        EventControlThread(BlockingQueue<KeyEvent> eventQueue)
        {
            this.eventQueue = eventQueue;
        }


        /***********************************************************************
         * Vlastní akci vlákna - jakmile se ve froně objeví událost,
         * tak spustí její ošetření a podívá se, jestli se tam mezi tím
         * neobjevila událost další.
         */
        @Override
        public void run()
        {

            for(;;) {
                try {
                    KeyEvent event = eventQueue.take();
                    int kc = event.getKeyCode();
                    if (kc == keys[LEFT]) {
                        controlled.left();
                    }
                    else if (kc == keys[RIGHT]) {
                        controlled.right();
                    }
                    else if (kc == keys[UP]) {
                        controlled.up();
                    }
                    else if (kc == keys[DOWN]) {
                        controlled.down();
                    }
                    else if (kc == keys[SPACE]) {
                        controlled.space();
                    }
                    else if (kc == keys[ENTER]) {
                        controlled.enter();
                    }
                    else if (kc == keys[ESCAPE]) {
                        controlled.escape();
                        Controller.this.stop();
                    }
                }
                catch (InterruptedException ex) {
                    return;
                }
                if (interrupted()) {
                    return;
                }
            }
        }
    }



    //== TESTING CLASSES AND METHODS ===========================================
}
