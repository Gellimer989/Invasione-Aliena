package it.unimol.entita;

import it.unimol.gioco.Gioco;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Classe che mette a disposizione i metodi e attributi
 * per gestire gli oggetto di tipo Alieno
 *
 * @author Francesco Chiacchiari
 */

public class Alieni extends Thread {
    private int attesa;
    BufferedImage image;
    BufferedImage image2;
    BufferedImage imageBomba;
    private Gioco gioco;
    public static ArrayList<Alieno> alieni;

    public Alieni(BufferedImage image,BufferedImage image2,BufferedImage imageBomba, int attesa, Gioco gioco) {
        this.image = image;
        this.image2=image2;
        this.imageBomba= imageBomba;
        this.attesa = attesa;
        this.gioco = gioco;
        alieni = new ArrayList<>();
    }

    /**
     * metodo chiamato dall' estensione di Thread,
     * permette l' aggiunta di oggetti Alieno alla lista
     * {@code alieni}
     */

    @Override
    public void run() {
        for (int i = 0; i < 7; i++) {
            alieni.add(new Alieno(image2,imageBomba, 30, 50, 1 + (i * 60), 30, gioco, 10));
        }
        for (int i = 0; i < 7; i++) {
            alieni.add(new Alieno(image,imageBomba ,20, 50, 1 + (i * 60), 30 + 50, gioco, 10));
        }
        for (int i = 0; i < 7; i++) {
            alieni.add(new Alieno(image,imageBomba ,20, 50, 1 + (i * 60), 30 + 100, gioco, 10));
        }
        for (int i = 0; i < 7; i++) {
            alieni.add(new Alieno(image,imageBomba ,20, 50, 1 + (i * 60), 30 + 150, gioco, 10));
        }


    }

    /**
     * viene chiamato dalla classe {@link Gioco}
     * cosi da poter disegnare su schermo ogni singolo oggetto
     * @param g di tipo Graphics, oggetto che contiene i metodi
     * per disegnare su schermo
     */

    public void disegna(Graphics g) {
        for (int i = 0; i < alieni.size(); i++) {
            Alieno a = alieni.get(i);
            a.disegna(g);
        }
    }

    /**
     * Restituisce la lista di oggetti Alieno,
     * cosi che sia fruibile nella classe principale {@link Gioco}
     * @return restituisce l' intera lista di Alieno
     */

    public ArrayList<Alieno> getAlieni() {
        return alieni;
    }
}
