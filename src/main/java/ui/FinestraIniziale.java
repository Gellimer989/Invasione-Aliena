package ui;

import it.unimol.file.FileInputRecord;
import it.unimol.gestori.GestoreInterfaccia;

import it.unimol.record.ListaRecord;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * classe utilizzata per far visualizzare al giocatore
 * la finestra iniziale del gioco
 *
 * @author Francesco Chiacchiari
 */
public class FinestraIniziale {
    private JPanel panel1;
    private JButton bottoneClassifica;
    private JButton bottoneEsci;
    private JButton bottoneGioca;
    private FileInputRecord fileInputRecord = FileInputRecord.getInstance();
    private ListaRecord listaRecord = ListaRecord.getInstance();

    public FinestraIniziale(GestoreInterfaccia gestoreInterfaccia) {
        listaRecord.listaRecord = fileInputRecord.leggiFile(listaRecord.listaRecord);
        bottoneGioca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestoreInterfaccia.status = 1;
                gestoreInterfaccia.sceltaInterfaccia();
            }
        });
        bottoneEsci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        bottoneClassifica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestoreInterfaccia.status = 4;
                gestoreInterfaccia.sceltaInterfaccia();

            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

}
