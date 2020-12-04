package it.unimol.gestori;

import it.unimol.entita.*;

/**
 * claase creata per la gestione delle collisioni,
 * verifica se due oggetti entrano in contatto
 * fra loro
 *
 * @author Francesco Chiacchiari
 */

public class GestoreCollisioni{

    public static boolean controllaCollisioni(Giocatore giocatore, Alieno alieno) {
        return giocatore.getBordo().intersects(alieno.getBordo());
    }

    public static boolean controllaCollisioniBonus(Proiettile proiettile, Bonus bonus) {
        return proiettile.getBordo().intersects(bonus.getBordo());
    }

    public static boolean controllaProiettileNave(Proiettile proiettile, Alieno alieno) {
        return proiettile.getBordo().intersects(alieno.getBordo());
    }

    public static boolean controllaProiettiliNemici(Bombe bomba, Giocatore giocatore) {
        return bomba.getBordo().intersects(giocatore.getBordo());
    }
}
