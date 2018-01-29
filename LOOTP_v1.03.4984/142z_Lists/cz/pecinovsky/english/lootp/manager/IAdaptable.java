/* The file is saved in UTF-8 codepage.
 * Check: «Stereotype», Section mark-§, Copyright-©, Alpha-α, Beta-β, Smile-☺.
 */
package cz.pecinovsky.english.lootp.manager;



/*******************************************************************************
 * Rozhraní {@code IAdaptable} je určeno pro instance, které chtějí být schopny
 * reagovat na velikosti kroku (a tím i políčka) plátna po svém.
 * Kdykoliv se změní velikost pole aktivního plátna, správce plátna to oznámí
 * všem přihlášeným přizpůsobivým ({@code IAdaptable}) objektům.
 * <p>
 * Objekt, který má reagovat na změny velikosti kroku plátna,
 * nemusí být nutně instancí tohoto interfejsu.
 * Správce plátna zabezpečí, že se změně kroku přizpůsobí i všechny instance
 * interfejsů {@link IModular}, {@link IChangeable} nebo {@link IMovable},
 * protože jejich pozici (a jde-li to i rozměr) upraví sám.
 * Implementuje-li registrovaný objekt rozhraní {@code IAdaptable},
 * dostane jeho metoda {@link #stepChanged(int, int)} přednost
 * před úpravovací metodou spouštěnou správcem plátna.
 *
 * @author  Rudolf PECINOVSKÝ
 * @version 1.01.4240 — 2012-10-13
 */
public interface IAdaptable extends IPaintable
{
    //== CONSTANTS =============================================================
    //== GETTERS AND SETTERS ===================================================
    //== OTHER METHODS =========================================================

    /***************************************************************************
     * Změní pozici a rozměr instance v závislosti na zadané změně kroku plátna.
     *
     * @param oldStep  Původní velikost kroku.
     * @param newStep  Nově nastavená velikost kroku.
     */
//    @Override
    public void stepChanged(int oldStep, int newStep);



    //== EMBEDDED DATA TYPES ===================================================
}
