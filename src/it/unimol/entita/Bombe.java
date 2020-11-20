package it.unimol.entita;

import it.unimol.gioco.Gioco;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Classe che mette a disposizione i metodi e
 * gli attributi necessari alla creazione di un
 * oggetto di tipo Bombe
 *
 * @author Francesco Chiacchiari
 */

public class Bombe extends Thread {
    private int x;
    private int y;
    private int larghezza;
    private int altezza;
    private BufferedImage image;
    private boolean attivo;
    private Gioco gioco;
    private final int velocita = 10;

    protected Bombe(BufferedImage img, int larghezza, int altezza, int x, int y, Gioco gioco) {
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
            aggiorna();
            try {
                Thread.sleep(60);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void aggiorna() {
        y += velocita;
    }

    /**
     * viene chiamato dalla classe {@link Gioco}
     * così da poter disegnare su schermo ogni singolo oggetto
     * @param g di tipo Graphics, oggetto che contiene i metodi
     * per disegnare su schermo
     */

    public void disegna(Graphics g) {
        g.drawImage(image, x, y, larghezza, altezza, gioco);
        if (y - altezza > 600) {
            this.setAttivo(false);
            Alieno.bombe.remove(this);
        }
    }

    /**
     * restituisce i valori necessari per
     * essere utilizzate nella clasee {@link it.unimol.gestori.GestoreCollisioni}
     * per verificare se la collisione avviene
     * @return restituisce le coordinate x,y e la grandezza
     * dell' oggetto
     */
    public Rectangle getBordo() {
        return new Rectangle(x, y, larghezza, altezza);
    }

    /**
     * metodo che gestisce lo stato
     * dell' oggetto per settarne la visibilita
     * @param stato variabile che gestisce la
     * visibilità dell' oggetto
     */

    public void setAttivo(boolean stato) {
        attivo = stato;
    }
}
