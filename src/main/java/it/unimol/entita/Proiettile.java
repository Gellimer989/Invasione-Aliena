package it.unimol.entita;

import it.unimol.gioco.Gioco;

import java.awt.*;
import java.awt.image.BufferedImage;


/**
 * Classe che mette a disposizione i metodi
 * e gli attributi necessari alla creazione di
 * un oggetto di tipo Proiettile
 *
 * @author Francesco Chiacchairi
 */
public class Proiettile extends Thread {

    private int x;
    private int y;
    private int larghezza;
    private int altezza;
    private BufferedImage image;
    private boolean attivo;
    private Gioco gioco;
    private final int velocita = 10;

    protected Proiettile(BufferedImage img, int larghezza, int altezza, int x, int y, Gioco gioco) {
        this.x = x;
        this.y = y;
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.image = img;
        this.gioco = gioco;
        this.start();
    }

    /**
     * metodo chiamato dall' estensione di Thread.
     * permette di modificare la posizione dell'oggetto
     * con il metodo {@code aggiorna()}
     */
    @Override
    public void run() {
        attivo = true;
        while (attivo) {
            aggiornaProiettile();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void aggiornaProiettile() {
        y-=velocita;
        if(y+altezza<0){
            this.setAttivo(false);
            Giocatore.proiettili.remove(this);
        }
    }

    public void disegna(Graphics g) {
        g.drawImage(image, x, y, larghezza, altezza, gioco);
    }

    public Rectangle getBordo() {
        return new Rectangle(x, y, larghezza, altezza);
    }

    public void setAttivo(boolean stato) {
        attivo = stato;
    }
}


