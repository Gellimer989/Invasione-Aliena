package it.unimol.gestori;

import it.unimol.gioco.Gioco;
import ui.FinestraIniziale;
import ui.GameOver;
import ui.FinestraRecord;
import ui.Vittoria;

import javax.swing.*;

/**
 * classe creata per avere una verione pulita
 * del cambio inetrfaccia gestita con
 * uno status
 *
 * @author Francesco Chiacchiari
 */

public class GestoreInterfaccia {
    private JFrame finestra;
    private int punteggioFinale;
    public int status = 0;
    private FinestraIniziale finestraIniziale;
    private GameOver finestraGameOver;
    private FinestraRecord finestraRecord;
    private Vittoria finestraVittoria;


    public GestoreInterfaccia(JFrame frame) {
        this.finestra = frame;
        this.sceltaInterfaccia();
    }

    /**
     * metodo utilizzato per passare da un interfaccia ad
     * un altra dove tramite un controllo sullo status,
     * imposta in tipo di finestra da caricare
     */
    public void sceltaInterfaccia() {
        assert this.finestra != null;
        switch (status) {
            case 0:
                this.finestraIniziale = new FinestraIniziale(this);
                this.finestra.add(finestraIniziale.getPanel1());
                this.finestra.revalidate();
                break;
            case 1:
                this.finestra.setVisible(false);
                Gioco gioco = new Gioco(this);
                gioco.start(new JFrame());
                break;
            case 2:
                this.finestra.remove(finestraIniziale.getPanel1());
                this.finestraGameOver = new GameOver(this.punteggioFinale,this);
                this.finestra.add(finestraGameOver.getPanel1());
                this.finestra.revalidate();
                this.finestra.setVisible(true);
                break;
            case 3:
                this.finestra.remove(finestraIniziale.getPanel1());
                this.finestraVittoria = new Vittoria(this.punteggioFinale,this);
                this.finestra.add(finestraVittoria.getPanel1());
                this.finestra.revalidate();
                this.finestra.setVisible(true);
                break;
            case 4:
                this.finestra.remove(finestraIniziale.getPanel1());
                this.finestraRecord = new FinestraRecord(this);
                this.finestra.add(finestraRecord.getPannelloRecord());
                this.finestra.revalidate();
                this.finestra.setVisible(true);
                break;
            case 5:
                this.finestra.remove(this.finestraRecord.getPannelloRecord());
                this.finestraIniziale = new FinestraIniziale(this);
                this.finestra.add(finestraIniziale.getPanel1());
                this.finestra.revalidate();
                break;
            default:
        }


    }

    public void setPuteggioFinale(int punteggio) {
        this.punteggioFinale = punteggio;
    }
}
