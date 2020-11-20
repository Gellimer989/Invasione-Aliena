package it.unimol.file;

import it.unimol.record.Record;

import java.io.*;
import java.util.ArrayList;

/**
 * classe che permette il caricamento delle informazioni
 * dal file nella lista (Record)  usando la
 * serializzazione
 *
 * @author Francesco Chiacchiari
 */

public class FileInputRecord {
    private static FileInputRecord insatnce = null;
    private File file;

    private FileInputRecord() {
        this.file = new File("Record.txt");
    }

    /**
     * Gestione del singleton creato per assicurarsi che
     * di una determinata classe venga istanziata
     * soltanto una volta
     *
     * @return l' istanza sia nel caso sia stata creata precedentemente
     * sia se viene creata una nuova
     */

    public static FileInputRecord getInstance() {
        if (insatnce == null)
            insatnce = new FileInputRecord();
        return insatnce;
    }

    /**
     * il metodo, verifica se esiste il file con il nome specificato,se non
     * è presente lo crea , in seguito caricherà dal file l'intera lista salvata
     * (con serializzazione).
     *
     * @param listaRecord per evitare di creare una nuova lista gli passiamo la lista che
     *                    già abbiamo,la carichiamo con i file e la restituiamo.
     * @return la lista caricata di informazioni
     */

    public ArrayList<Record> leggiFile(ArrayList<Record> listaRecord) {
        try (
                FileInputStream fileInputStream = new FileInputStream(this.file);
                ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ) {
            if (!this.file.exists()) {
                file.createNewFile();
            } else {

                listaRecord = (ArrayList<Record>) objectInputStream. readObject();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return listaRecord;
    }
}
