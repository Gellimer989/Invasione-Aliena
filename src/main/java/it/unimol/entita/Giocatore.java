package it.unimol.entita;

import it.unimol.gioco.Gioco;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Classe che mette a disposizione i metodi e
 * gli attributi necessari alla creazione di un
 * oggetto di tipo Giocatore
 *
 * @author Francesco Chiacchiari
 */


public class Giocatore {
    private int x;
    private int y;
    private int larghezza;
    private int alezza;
    private final int velocita = 10;
    Gioco gioco;
    public int vita;
    public static ArrayList<Proiettile> proiettili;

    BufferedImage proiettile;
    BufferedImage img;

    public Giocatore(BufferedImage img, BufferedImage proiettile, int x, int larghezza, int altezza, Gioco gioco) {
        this.x = x;
        this.alezza = altezza;
        this.larghezza = larghezza;
        this.img = img;
        this.proiettile = proiettile;
        this.y = 520;
        this.gioco = gioco;
        this.vita = 1;
        proiettili = new ArrayList<>();

    }

    /**
     * metodo che gestisce i Proiettili del Giocatore,
     * aggiungendo una nuova istanza di Proiettile
     */
    public void spara() {
        if (proiettili.isEmpty()) {
            proiettili.add(new Proiettile(proiettile, 5, 10, x + larghezza / 2, y, gioco));
        }
    }

    public void spostaDestra() {
        if (x + larghezza < Gioco.getLarghezza())
            x += velocita;
    }

    public void spostaSinistra() {
        if (x > 0) {
            x -= velocita;
        }
    }

    public Rectangle getBordo() {
        return new Rectangle(x, y, larghezza, alezza);
    }

    public void disegna(Graphics g) {
        g.drawImage(img, x, y, larghezza, alezza, null);
    }


}
