package it.unimol.file;

import it.unimol.record.Record;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * classe che permette il salvataggio della lista del programma
 * su file usando la serializzazione
 *
 * @author Francesco Chiacchiari
 */

public class FileOutputRecord {
    private static FileOutputRecord instance = null;

    private FileOutputRecord() {

    }

    /**
     * Gestione del singleton creato per assicurarsi che di una
     * determinata classe venga creata una sola istanza
     *
     * @return l'istanza,sia nel caso sia stata creata precedentemente
     * sia se ne viene creata una nuova.
     */

    public static FileOutputRecord getInstance() {
        if (instance == null)
            instance = new FileOutputRecord();
        return instance;
    }

    /**
     * il metodo verifica la presenza del file chiamato, in seguito salverà
     * l'intera lista sul file, può generare l'eccezione se il file non e' stato trovato
     *
     * @param listaRecord la lista del programma che verrà scritta
     *                    su file
     */
    public void ScritturaSuFile(ArrayList<Record> listaRecord) {
        try (FileOutputStream fileOuputStream = new FileOutputStream("Record.txt");
             ObjectOutputStream objectOnputStream = new ObjectOutputStream(fileOuputStream);) {

            objectOnputStream.writeObject(listaRecord);
            objectOnputStream.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
