package it.unimol.record;

import java.util.ArrayList;

/**
 * classe che permette la creazione e gestione di una lista di Record
 * utilizzata per il salvataggio dei punteggi di ogni giocatore
 *
 * @author Francesco Chiacchiari
 */
public class ListaRecord {

    private static ListaRecord instance = null;
    public ArrayList<Record> listaRecord;

    private ListaRecord() {
        this.listaRecord = new ArrayList<>();
    }

    public static ListaRecord getInstance() {
        if (instance == null)
            instance = new ListaRecord();
        return instance;
    }


    public void aggiungiRecord( Record nuovoRecord ) {
        assert nuovoRecord != null;
        this.listaRecord.add(nuovoRecord);
    }

}
