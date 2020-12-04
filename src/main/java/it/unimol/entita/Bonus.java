package it.unimol.entita;

import it.unimol.gioco.Gioco;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Classe che descrive e implementa i metodi e
 * gli attributi degli oggetti di tipo Bonus
 *
 * @author Francesco Chiacchiari
 */

public class Bonus extends Thread {
    private int x;
    private int y;
    private int larghezza;
    private int alezza;
    private final int velocita = 10;
    Gioco gioco;
    private boolean attivo;
    BufferedImage img;


    public Bonus(BufferedImage img, int x, int larghezza, int altezza, Gioco gioco) {
        this.x = x;
        this.alezza = altezza;
        this.larghezza = larghezza;
        this.img = img;
        y = 30;
        this.gioco = gioco;

    }

    /**
     * metodo richiamato dall'estensione Thread.
     * permette di aggiornare, la modifica della posizione
     * dell'oggetto Bonus
     * {@code aggiorna()}
     */
    @Override
    public void run() {
        attivo = true;
        while (attivo) {

            aggiorna();
            try {
                Thread.sleep(80);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void aggiorna() {
        x -= velocita;
        if (x <= -40) {
            this.setAttivo(false);
        }

    }

    /**
     * restituisce i valori necessari per
     * essere utilizzate nella clasee {@link it.unimol.gestori.GestoreCollisioni}
     * per verificare se la collisione avviene
     *
     * @return restituisce le coordinate x,y e la grandezza
     * dell' oggetto
     */

    public Rectangle getBordo() {
        return new Rectangle(x, y, larghezza, alezza);
    }

    public boolean getStato() {
        return attivo;
    }

    public void disegna(Graphics g) {
        g.drawImage(img, x, y, larghezza, alezza, null);
    }

    /**
     * metodo che gestisce lo stato
     * dell' oggetto per settarne la visibilita
     *
     * @param stato variabile che gestisce la
     *              visibilità dell' oggetto
     */
    public void setAttivo(boolean stato) {
        attivo = stato;
    }


}
