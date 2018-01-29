/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.manager;

import cz.pecinovsky.english.lootp.util.Position;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;



/*******************************************************************************
 * Instance třídy {@code Multimover} je jedináček sloužící
 * k přesunu několika grafických objektů zároveň.
 * Obdobně jako {@code CanvasManager} přijímá prostřednictvím
 * přesunových metod do správy objekty, kterými pak po plátně pohybuje.
 * <p>
 * Tyto objekty musí být typu {@link IMovable}. Je-li objekt dokonce typu
 * {@link IMultimovable}, tak poté, co objekt přesune do zadané cílové pozice,
 * zavolá jeho metodu {@link IMultimovable#moved()},
 * která může provést libovolnou akci (většinou znovu předá
 * objekt multipřesouvači, aby jej přesunul do další pozice).
 * <p>
 * Přesouvané objekty, které nebyly dosud zobrazovány,
 * budou jako vedlejší efekt metody přidány mezi zobrazované.
 *
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class Multimover
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Implicitní hodnota periody = počet milisekund, které uplynou mezi
     *  dvěma následnými překresleními přesouvaných objektů. */
    private static final int PERIOD_0 = 50;

    /** Tento atribut je tu pouze pro zjednodušení psaní. */
    private static final CanvasManager CM = CanvasManager.getInstance(false);

    /** Jediná existující instance multipřesouvače. */
    private static final Multimover singleton = new Multimover();



    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Časovač, který se postará o opakované vykreslování svěřených objektů.*/
    private final Timer timer = new Timer();

    /** Počet milisekund, které uplynou mezi dvěma následnými překresleními
     *  přesouvaných objektů. */
    private final int period = PERIOD_0;

    /** Seznam posouvaných objektů. Je deklarovaný jako mapa,
     *  aby v něm bylo možno rychle testovat přítomnost prvku.
     *  Linkovanou mapou je proto, protože bude při kreslení velice často
     *  procházen s vysokými požadavky na rychlost. */
    private final Map<IMovable, Animation> moveable2animation =
                                                         new LinkedHashMap<>();

    /** Tabulka dvojic [IMovable;Animace] reprezentovaná jako množina. */
    private final Set<Map.Entry<IMovable,Animation>> couples =
                                                 moveable2animation.entrySet();



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** Proměnná ovládající běh multipřesouvače. */
    private Multimove multimove = null;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Vytvoří nový multipřesouvač s implicitní periodou (50 ms).
     * @return Požadovaný multipřesouvač
     */
    public static Multimover getInstance()
    {
        return singleton;
    }


    /***************************************************************************
     * Vytvoří nový multipřesouvač - všechna potřebná nastavení
     * jsou součástí deklarací atributů.
     */
    private Multimover()
    {
    }



    //== ABSTRACT METHODS ======================================================
    //== PŘÍSTUPOVÉ METODY ATRIBUTU INSTANCÍ ===================================

    /***************************************************************************
     * Vrátí frekvenci překreslování, tj. počet překreslení za sekundu.
     * Frekvence překreslovnání může být i menší než 1.
     *
     * @return Frekvence překreslování.
     */
    public double getFrequency()
    {
        return 1000.0 / period;
    }


    /***************************************************************************
     * Vrátí pole se všemi právě přesouvanými objekty. Vrácený seznam je však
     * platný pouze v době volání. Vzápětí na to mohou být některé objekty
     * dovezeny do svých cílových pozic a mohou seznam "opustit".
     *
     * @return Pole právě přesouvaných objektů.
     */
    public IMovable[] getMoved()
    {
        synchronized(moveable2animation)
        {
            return moveable2animation.keySet().toArray(new IMovable[0]);
        }
    }


    /***************************************************************************
     * Vrátí hodnotu periody =  počet milisekund, které uplynou mezi dvěma
     * následnými překresleními přesouvaných objektů.
     *
     * @return Perioda překreslování v milisekundách.
     */
    public int getPeriod()
    {
        return period;
    }



    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Vrátí informaci o tom, je-li zadaný objekt mezi právě přesouvanými.
     *
     * @param object  Objekt, na nějž se ptáme
     * @return Byl-li mezi přesouvanými, vrátí {@code true},
     *         jinak vrátí {@code false}
     */
    public boolean isMoving(IMovable object)
    {
        synchronized(moveable2animation)
        {
            return moveable2animation.containsKey(object);
        }
    }


    /***************************************************************************
     * Za zadanou dobu
     * přesune zadaný posuvný objekt do zadané cílové pozice,
     * přičemž v případě, že přesouvaný objekt nebyl dosud zobrazován,
     * bude jako vedlejší efekt přidán mezi zobrazované.
     *
     * @param seconds   Doba, kterou bude přesun trvat, v sekundách
     * @param object    Přesouvaný objekt
     * @param position  Požadovaná cílové pozice
     */
    public void moveInTime(double seconds, IMovable object, Position position)
    {
        moveInTime(seconds, object, position.x, position.y);
    }


    /***************************************************************************
     * Za zadanou dobu
     * přesune zadaný posuvný objekt do zadané cílové pozice,
     * přičemž v případě, že přesouvaný objekt nebyl dosud zobrazován,
     * bude jako vedlejší efekt přidán mezi zobrazované.
     *
     * @param seconds  Doba v sekundách, po kterou bude přesun trvat
     * @param object   Přesouvaný objekt
     * @param xn       Vodorovná souřadnice cílové pozice
     * @param yn       Svislá souřadnice cílové pozice
     */
    public void moveInTime(double seconds, IMovable object, int xn, int yn)
    {
        if (seconds <= 0) {
            throw new IllegalArgumentException(
                "Doba přesunu musí být kladná!");
        }
        moveInternal(object, xn, yn, 0, seconds * 1000);
    }


    /***************************************************************************
     * Zadanou rychlostí
     * přesune zadaný posuvný objekt do zadané cílové pozice,
     * přičemž v případě, že přesouvaný objekt nebyl dosud zobrazován,
     * bude jako vedlejší efekt přidán mezi zobrazované.
     *
     * @param speed     Počet bodů, o které se objekt přesune za sekundu
     * @param object    Přesouvaný objekt
     * @param position  Požadovaná cílové pozice
     */
    public void moveWithSpeed(int speed, IMovable object, Position position)
    {
        moveWithSpeed(speed, object, position.x, position.y);
    }


    /***************************************************************************
     * Zadanou rychlostí
     * přesune zadaný posuvný objekt do zadané cílové pozice,
     * přičemž v případě, že přesouvaný objekt nebyl dosud zobrazován,
     * bude jako vedlejší efekt přidán mezi zobrazované.
     *
     * @param speed     Počet bodů, o které se objekt přesune za sekundu
     * @param object    Přesouvaný objekt
     * @param xn        Vodorovná souřadnice cílové pozice
     * @param yn        Svislá souřadnice cílové pozice
     */
    public void moveWithSpeed(int speed, IMovable object, int xn, int yn)
    {
        if (speed <= 0) {
            throw new IllegalArgumentException(
                "Rychlost přesunu musí být kladná!");
        }
        moveInternal(object, xn, yn, speed, 0);
    }


    /***************************************************************************
     * Zastaví požadovaný objekt, tj. vyjme jej ze seznamu objektů,
     * s nimiž pohybuje.
     * Pro příští rozpohybování tohoto objektu bude potřeba
     * znovu požádat multipřesouvač o jeho přesunutí.
     *
     * @param object  Zastavovaný objekt
     * @return Informace o tom, byl-li objekt mezi přesouvanými
     */
    public boolean stop(IMovable object)
    {
        synchronized(moveable2animation)
        {
            if (moveable2animation.containsKey(object))
            {
                moveable2animation.remove(object);
                return true;
            }
            return false;
        }
    }


   /***************************************************************************
    * Zastaví veškeré přesuny a zruší všechny plány dalších přesunů.
    */
    public void stopAll()
    {
        stop();
        synchronized(moveable2animation)
        {
            moveable2animation.clear();
        }
    }


    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * Přesune zadaný posuvný objekt do požadované cílové pozice
     * za zadanou dobu nebo zadanou rychlostí,
     * přičemž v případě, že přesouvaný objekt nebyl dosud zobrazován,
     * bude jako vedlejší efekt přidán mezi zobrazované.
     *
     * @param object Přesouvaný objekt
     * @param xn     Vodorovná souřadnice cílové pozice
     * @param yn     Svislá souřadnice cílové pozice
     * @param speed  Počet bodů, o které se objekt přesune za sekundu
     * @param milliseconds Doba, kterou bude přesun trvat, v sekundách
     */
    private void moveInternal(IMovable object, int xn, int yn,
                         int speed, double milliseconds)
    {
        if (object == null) {
            throw new NullPointerException(
                "Přesouvaný objekt nesmí být null!");
        }
        Animation a = new Animation(object, xn, yn, speed, milliseconds);
        synchronized(moveable2animation)
        {
            if (moveable2animation.get(object) != null) {
                throw new IllegalStateException(
                    "Přidávaný objekt již je mezi přesouvanými!");
            }
//            CM.add(object);
            moveable2animation.put(object, a);
            start();
        }//synchronized(přesouvané)
    }


    /***************************************************************************
     * Ukončí multipřesun a tím uvolní procesor.
     */
    private synchronized void stop()
    {
        if (multimove == null) {
            return;
        }
        multimove.cancel();
        multimove = null;
    }


    /***************************************************************************
     * Spustí nový multipřesun.
     */
    private synchronized void start()
    {
        if (multimove == null)
        {
            multimove = new Multimove();
            timer.scheduleAtFixedRate(multimove, period, period);
        }
    }



    //== MEMBER DATA TYPES =====================================================

    //##########################################################################
    //##########################################################################
    //##########################################################################

    /***************************************************************************
     * Soukromá vnitřní třída, jejíž instance sdružují všechny potřebné
     * informace o přesouvaném objektu. Funguje pouze jako přepravka.
     */
    private class Animation
    {
        double    x,  y;    //Aktuální souřadnice objektu
        double    dx, dy;   //Přírustek souřadnic v jednom kroku
        IMovable object;   //Animovaný objekt
        int       xt, yt;   //Souřadnice cíle
        int       numSteps; //Počet kroků potřebných pro přesun.


        /***********************************************************************
         * Vytvoří animaci na základě zadaného objektu, jeho cílových
         * souřadnic a doby, během níž má těchto souřadnic dosáhnout.
         * nebo rychlosti, s níž se má k tomuto cíli přesouvat.
         * Volající metoda musí zabezpečit, aby doba nebo speed byla nulová.
         *
         * @param object       Přesouvaný objekt
         * @param xt           Vodorovná souřadnice cíle
         * @param yt           Svislá souřadnice cíle
         * @param speed        Počet bodů "zdolaných" za sekundu
         * @param milliseconds Počet milisekund
         */
        Animation(IMovable object, int xt, int yt,
                  int speed, double milliseconds)
        {
            this.object = object;
            this.xt     = xt;
            this.yt     = yt;
            Position position = object.getPosition();
            dx = (xt - position.x);
            dy = (yt - position.y);
            if (speed > 0)
            {
                double distance = Math.hypot(dx, dy);
                numSteps = (int)(1000 * distance / (speed * period));
            }
            else
            {
                numSteps = (int)(milliseconds / period);
            }
            if (numSteps < 1) {
                numSteps = 1;
            }
            //Posunutí zlepšuje rozložení přesunu při malém počtu kroků
            x   = position.x + 0.4;
            y   = position.y + 0.4;
            dx /= numSteps;
            dy /= numSteps;
        }

    }//private class Animation



    //##########################################################################
    //##########################################################################
    //##########################################################################

    /***************************************************************************
     * Instance třídy jsou úlohy realizující vlastní multipřesun.
     * Multipřesun je definován jako samostatná třída proto, aby jej bylo možno
     * při ukončení všech zadaných přesunů vypnout a při vzniku nových
     * požadavků na přesun zase zapnout.
     */
    private class Multimove extends TimerTask
    {
        /***********************************************************************
         * Metoda vyžadovaná rozhraním {@link Runnable} implementovaným
         * rodičovskou třídou {@link TimerTask} - tuto metodu zavolá
         * {@link Timer} pokaždé, když se rozhodne spustit další provedení
         * opakovaného úkolu ({@link TimerTask}) - u nás multipřesunu.
         */
        @Override
        public void run()
        {
            //Při překreslování se nesmí měnit počet objektů v seznamu
            synchronized(moveable2animation)
            {
                //Potřebuji cyklus s iterátorem, protože se bude vyhazovat
                Iterator<Map.Entry<IMovable,Animation>> it =couples.iterator();
                CM.stopPainting(); {
                    while (it.hasNext()) {
                        Animation a = it.next().getValue();
                        a.x += a.dx;
                        a.y += a.dy;
                        a.object.setPosition((int)a.x, (int)a.y);
                        if (--a.numSteps == 0) {
                            //Dorovnání pozice pro případ zaokrouhlovací chyby
                            a.object.setPosition(a.xt, a.yt);
                            it.remove();

                            if (a.object instanceof IMultimovable)
                            {
                                final IMultimovable aa =
                                                    (IMultimovable)(a.object);
                                //Oznámení spouštím v novém vlákně,
                                //  abych na něj nemusel čekat
                                Thread t = new Thread(a.toString()) {
                                    @Override
                                    public void run() {
                                        aa.moved();
                                    }
                                };
                                t.start();
                            }
                        }
                    }//while
                    //Při vyprázdnění seznamu zruš úlohu
                    if (moveable2animation.size() <= 0) {
                        stop();
                    }
                } CM.returnPainting();
            }//synchronized(moveable2animation)
       }//public void run()

    }//private class Multimove extends TimerTask



    //##########################################################################
    //##########################################################################
    //##########################################################################

    //== TESTING CLASSES AND METHODS ===========================================
}
