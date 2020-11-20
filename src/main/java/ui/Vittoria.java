package ui;

import it.unimol.file.FileOutputRecord;
import it.unimol.gestori.GestoreInterfaccia;
import it.unimol.record.ListaRecord;
import it.unimol.record.Record;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * classe utilizzata per far visualizzare al giocatore
 * la schermata di Vittoria nel caso di vittoria
 *
 * @author Francesco Chiacchiari
 */
public class Vittoria {
    private JPanel panel1;
    private JButton bottoneEsci;
    private JTextField campoNome;
    private JButton bottoneRigioca;
    private JLabel scoreLabel;
    private FileOutputRecord fileOutputRecord= FileOutputRecord.getInstance();

    public Vittoria(int punteggio, GestoreInterfaccia gestoreInterfaccia){
        scoreLabel.setText(String.valueOf(punteggio));

        bottoneRigioca.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gestoreInterfaccia.status=1;
                gestoreInterfaccia.sceltaInterfaccia();
            }
        });
        bottoneEsci.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!campoNome.getText().isEmpty()){
                    Record nuovoRecord = new Record();
                    nuovoRecord.setNomeGiocatore(campoNome.getText());
                    nuovoRecord.setPunteggioPartita(punteggio);
                    ListaRecord listaRecord = ListaRecord.getInstance();
                    listaRecord.aggiungiRecord(nuovoRecord);
                    fileOutputRecord.ScritturaSuFile(listaRecord.listaRecord);
                    System.out.println(nuovoRecord.getNomeGiocatore()+" "+nuovoRecord.getPunteggioPartita());
                }
                System.exit(0);
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }
}
