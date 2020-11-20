package it.unimol.record;

import java.io.Serializable;

/**
 * classe utilizzata per descrivere
 * un oggetto di tipo Record che serivra
 * esser aggiunto nella propria lista della classe {@link ListaRecord}
 *
 * @author Francesco Chiacchiari
 */
public class Record implements Serializable  {
    private String nomeGiocatore;
    private int punteggioPartita;

    public String getNomeGiocatore() {
        return nomeGiocatore;
    }

    public void setNomeGiocatore(String nomeGiocatore) {
        this.nomeGiocatore = nomeGiocatore;
    }

    public int getPunteggioPartita() {
        return punteggioPartita;
    }

    public void setPunteggioPartita(int punteggioPartita) {
        this.punteggioPartita = punteggioPartita;
    }
}
