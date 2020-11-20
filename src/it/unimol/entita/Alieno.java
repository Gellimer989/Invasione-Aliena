package it.unimol.entita;

import it.unimol.gioco.Gioco;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;

/**
 * Classe che descrive e implementa i metodi e
 * gli attributi degli oggetti di tipo Alieno
 *
 * @author Francesco Chiacchiari
 */

public class Alieno extends Thread {
    private int x;
    private int y;
    private int larghezza;
    private int altezza;
    private BufferedImage image;
    private boolean attivo;
    private boolean destra = true;
    private boolean sinistra = false;
    private Gioco gioco;
    public static boolean shot = true;
    private int velocita;
    public static int difficolta = 1;
    private Random rnd;
    private int sparo;
    public static ArrayList<Bombe> bombe;

    BufferedImage proiettile;

    protected Alieno(BufferedImage img, BufferedImage bomba, int larghezza, int altezza, int x, int y, Gioco gioco, int velocita) {
        this.x = x;
        this.y = y;
        this.altezza = altezza;
        this.larghezza = larghezza;
        this.image = img;
        this.proiettile = bomba;
        attivo = true;
        this.velocita = velocita;
        this.gioco = gioco;
        bombe = new ArrayList<>();
        this.start();

    }

    /**
     * metodo richiamato dall'estensione Thread.
     * permette di aggiornare, la modifica della posizione
     * dell'oggetto Alieno
     * {@code aggiorna()}
     */
    @Override
    public void run() {
        attivo = true;
        while (attivo) {
            aggiornaAlieno();
            try {
                Thread.sleep(100);//100
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * metodo che permette lo sapro di un alieno
     * nel gioco aggiungendo una nuova istanza dell'
     * oggetto Bomba nella lista dei proiettili di un
     * iesimo Alieno
     */
    public void sganciaBomba() {
        if(bombe.size()<1){
            bombe.add(new Bombe(proiettile, 5, 10, x - larghezza / 2, y, gioco));
        }
    }

    private int rnd() {
        sparo = (int) (Math.random()*20);
        return sparo;
    }


    private void aggiornaAlieno() {

        if (sinistra) {
            x -= velocita;
        }
        if (destra) {
            x += velocita;
        }

        if (x > 450) {
            sinistra = true;
            destra = false;
            y += velocita + 10;
        }
        if (x < 0) {
            destra = true;
            sinistra = false;
            y += velocita + 10;
        }

        if (rnd() == 5) {
            sganciaBomba();
        }

    }

    /**
     * viene chiamato dalla classe {@link Gioco}
     * così da poter disegnare su schermo ogni singolo oggetto
     * @param g di tipo Graphics, oggetto che contiene i metodi
     * per disegnare su schermo
     */
    public void disegna(Graphics g) {
        g.drawImage(image, x, y, larghezza, altezza, gioco);
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

}
