package ui;

import it.unimol.gestori.GestoreInterfaccia;
import it.unimol.record.ListaRecord;
import it.unimol.record.Record;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * classe utilizzata per far visualizzare al giocatore i record,
 * ordinati da una classe anonima ,
 * precedentemente sostenuti da altri giocatori.
 *
 * @author Francesco Chiacchiari
 */
public class FinestraRecord {
    private JButton bottoneIndietro;
    private JTextArea areaTesto;
    private JPanel pannelloRecord;
    private ListaRecord listaRecord = ListaRecord.getInstance();

    public FinestraRecord(GestoreInterfaccia gestoreInterfaccia) {
        areaTesto.setEditable(false);

        for (Record record : listaRecord.listaRecord) {
            areaTesto.append("Player: " + record.getNomeGiocatore() + " Score: " + String.valueOf(record.getPunteggioPartita()) + "\n");

        }
        bottoneIndietro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestoreInterfaccia.status = 5;
                gestoreInterfaccia.sceltaInterfaccia();
            }
        });
    }


    public JPanel getPannelloRecord() {
        return pannelloRecord;
    }

}
