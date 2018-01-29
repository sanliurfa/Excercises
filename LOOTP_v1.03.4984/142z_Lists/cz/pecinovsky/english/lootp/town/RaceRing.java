/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.town;
import cz.pecinovsky.english.lootp.manager.IControllable;
import cz.pecinovsky.english.lootp.manager.Controller;
import cz.pecinovsky.english.lootp.manager.CanvasManager;

import cz.pecinovsky.english.lootp.util.NamedColor;
import cz.pecinovsky.english.lootp.util.IO;
import cz.pecinovsky.english.lootp.util.Position;

import cz.pecinovsky.english.lootp.util.Direction8;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;


/*******************************************************************************
 * Instances of the {@code RaceRing} class represent races.
 * All races use rings created by the method
 * {@link Ring#newLShapeRing(Position, NamedColor)}.
 * Several racers can register to the race.
 * All these racers will then race together,
 * each on instance of the ring of his/her own.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public class RaceRing implements IRace
{
    //== CONSTANT CLASS FIELDS =================================================

    /** Manager of the canvas on which the instance will be painted. */
    private static final CanvasManager CM = CanvasManager.getInstance();



    //== VARIABLE CLASS FIELDS =================================================
    //== STATIC INITIALIZER (CLASS CONSTRUCTOR) ================================
    //== CONSTANT INSTANCE FIELDS ==============================================

    /** Mapa přiřazující jednotlivým závodníkům informace,
     * které si o nich instance závodu pamatuje. */
    Map<IRacer, Info> závodníci = new HashMap<>();

    /** Počet kol, na která se závod jede. */
    private final int početKol;

    /** Instance vytvářející okruhu, na nichž se závodí. */
    private final OShapeRingFactory továrna;

    /** Počet sloupců a řádků, které daný okruh zabrere. */
    private final int sloupcůOkruhu, řádkůOkruhu;

    /** Maximální přípustný maxZávodníků závodníků. */
    private final int maxZávodníků;

    /** Aktuálně nastavený module plátna. */
    private final int module;



    //== VARIABLE INSTANCE FIELDS ==============================================

    /** System time of the start. */
    private long čas0;

    /** Počet doposud registrovaných závodníků a tím i vytvořených okruhů. */
    private int last = 0;



    //== CLASS GETTERS AND SETTERS =============================================
    //== OTHER NON-PRIVATE CLASS METHODS =======================================

    //##########################################################################
    //== CONSTUCTORS AND FACTORY METHODS =======================================

    /***************************************************************************
     * Creates an instance that will be able to organize races on the rings
     * created by an instance of the {@link OShapeRingFactory} class.
     *
     * @param tnk          Továrna, která bude vytvářet zádní okruhy
     * @param maxZávodníků Maximální maxZávodníků současně závodícíh závodníků
     * @param module        Požadovaná délka strany jednoho pole plátna
     */
    public RaceRing(OShapeRingFactory tnk, int maxZávodníků, int module)
    {
        this(tnk, maxZávodníků, module, 1);
    }


    /***************************************************************************
     * Creates an instance that will be able to organize races on the rings
     * returned by the {@link Ring#newLShapeRing(Position,NamedColor)} method.
     *
     * @param tnk          Továrna, která bude vytvářet zádní okruhy
     * @param maxZávodníků Maximální maxZávodníků současně závodícíh závodníků
     * @param module        Požadovaná délka strany jednoho pole plátna
     * @param početKol      Počet kol, na která se závod jede
     */
    public RaceRing(OShapeRingFactory tnk, int maxZávodníků, int module, int početKol)
    {
        this.továrna      = tnk;
        this.sloupcůOkruhu= tnk.getColumnSize();
        this.řádkůOkruhu  = tnk.getRowSize();
        this.maxZávodníků = maxZávodníků;
        this.module        = module;
        this.početKol     = početKol;

        CM.setStepAndSize(module, maxZávodníků*(řádkůOkruhu+1) - 1, řádkůOkruhu);
    }



    //== ABSTRACT METHODS ======================================================
    //== INSTANCE GETTERS AND SETTERS ==========================================
    //== OTHER NON-PRIVATE INSTANCE METHODS ====================================

    /***************************************************************************
     * Otevře dialogové okno, v němž závodníkům oznámí, že je odstartováno,
     * a poté, co je zavřou, změří systémový čas.
     */
    public void start()
    {
        IO.inform("Po potvrzení tohoto okna se začne měřit čas");
        Collection<Info> infa = závodníci.values();
        for (Info info : infa) {
            info.controller.start();
        }
        čas0 = System.currentTimeMillis();
    }


    /***************************************************************************
     * Ukončí závod, čím zruší všechny registerFor a připraví se na nové.
     */
    public void stop()
    {
        závodníci.clear();
    }


    /***************************************************************************
     * Zaregistruje zadaného závodníka, umístí jej na start závodu,
     * zjistí si od uživatele potřebné klávesy
     * a přihlásí závodníka jako posluchače klávesnice.
     *
     * @param závodník Závodník registrující se pro daný závod
     */
    @Override
    public void register(IRacer závodník)
    {
        if (last >= maxZávodníků) {
            IO.inform("Je možno zaregistrovat pouze: " + maxZávodníků +
                      " závodníků");
            return;
        }
        if (závodníci.containsKey(závodník)) {
            IO.inform("Závodníka nelze zaregistrovat dvakrát: " + závodník);
            return;
        }
        Ring     okruh  = připravDalšíOkruh(); //Opraví i atribut poslední
        RoadField start  = okruh.getStartField();
        Position    pozice = start.getPosition();
        Controller     řadič  = Controller.createFor(závodník);
        RoadField cíl    = start.getNext();

        Info info = new Info(okruh, start, cíl, řadič, početKol);
        závodníci.put(závodník, info);

        závodník.setPosition(pozice);
        závodník.setModule(module);
        závodník.setDirection(start.getDirection());
    }


    /***************************************************************************
     * Prověří, že závodník dojel do správné průběžné cílové pozice.
     * Pokud dojel, připraví další průběžnou pozici, pokud nedojel, čeká dál.
     *
     * @param racer Závodník hlásící změnu své pozice
     */
    @Override
    public void checkpoint(IRacer racer)
    {
        Info info = závodníci.get(racer);
        if (info == null) {
            return;                      //==========>
        }
        Position pz = racer.getPosition();
        Position pc = info.target.getPosition();
        if (pz.equals(pc)) {
            if (info.target == info.start) {
                info.remains--;
                if (info.remains == 0) {
                    finishRace(racer, info);
                    return;                  //==========>
                }
            }
            info.target = info.target.getNext();
        }
    }


    /***************************************************************************
     * Ukončí závod pro zadaného závodníka.
     *
     * @param racer Závodník ukončivší závod
     * @param info  Informace o zadanném závodníkovi
     */
    private void finishRace(IRacer racer, Info info)
    {
        long nyní = System.currentTimeMillis();
        info.controller.stop();
        int čas = (int)(nyní - čas0 + 50) / 100;
        System.out.println("Závodík " + racer.getName() +
               " absolvoval okruh v čase " + čas/10 + "," + čas%10 + " sekund");
        závodníci.remove(racer);
        if (závodníci.isEmpty()) {
            System.out.println("Konec závodu");
//            IO.inform("Konec závodu" +
//                  "\n\nvýsledky najdete ve standardním výstupu");
        }
    }


    /***************************************************************************
     * Vrátí řetězec sloužící jako textový "podpis" instance
     * používaný především při ladění.
     */
    @Override
    public String toString()
    {
        return "Závod_L(ELKO, počet=" + maxZávodníků + ", module=" + module + ")";
    }



    //== PRIVATE AND AUXILIARY CLASS METHODS ===================================
    //== PRIVATE AND AUXILIARY INSTANCE METHODS ================================

    /***************************************************************************
     * Připraví další okruh a vrátí odkaz na něj.
     *
     * @return Odkaz na připravený okruh
     */
    private Ring připravDalšíOkruh()
    {
        int x = last * (sloupcůOkruhu+1) * module;
        Position pozice = new Position(x, 0);
        Ring okruh = továrna.createRing(pozice, NamedColor.getNamedColor(last));
        last++;
        return okruh;
    }



    //== MEMBER DATA TYPES =====================================================

    /***************************************************************************
     * Interní přepravka obsahující základní informace o závodníkovi
     * a průběžném stavu jeho závodu.
     */
    private static class Info
    {
        /** Ring, na němž je závoděno. */
        private final Ring ring;

        /** Pole, z nějž závod odstartuje. */
        private final RoadField start;

        /** Příští pole, na které má závodník dojet
         *  a na němž se bude kontrolovat, zda je skutečně projel.  */
        private RoadField target;

        /** Controller, zprostředkovávající ovládání závodníka z klávesnice. */
        private final Controller controller;

        /** Kontrolovaný závodník. */
        private int remains;


        /***********************************************************************
         * Definuje novou přepravku a inicializuje její atributy.
         *
         * @param ring
         * @param start
         * @param target
         * @param controller
         * @param rounds
         */
        Info(Ring ring, RoadField start, RoadField target,
             Controller controller, int rounds)
        {
            this.ring       = ring;
            this.start      = start;
            this.target     = target;
            this.controller = controller;
            this.remains    = rounds;
        }
    }



    //== TESTING CLASSES AND METHODS ===========================================

    /***************************************************************************
     * The test method.
     */
    public static void test()
    {
        OShapeRingFactory tnk = new OShapeRingFactory(2, 2, Direction8.SOUTH);
        RaceRing závod = new RaceRing(tnk, 1, 100, 3);

        Arrow  arrow = new Arrow(0, 0, NamedColor.WHITE);
        Vehicle_B v1 = new Vehicle_B(arrow);
        v1.setName("Jednička");
        v1.registerFor(závod);

        //Car  car = new Car(0, 0, NamedColor.WHITE);
        //Vehicle_B v2 = new Vehicle_B(car);
        //v2.setName("Dvojka");
        //v2.registerFor(závod);

        závod.start();
    }
    //    /** @param args Command line arguments - not used. */
    //    public static void main(String[] args)  {  test();  }
}
