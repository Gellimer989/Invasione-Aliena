package it.unimol.gioco;

import it.unimol.caricatore.CaricatoreImmagini;
import it.unimol.entita.*;
import it.unimol.gestori.GestoreCollisioni;
import it.unimol.gestori.GestoreInterfaccia;
import it.unimol.gestori.GestoreSuono;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;


/**
 * classe principale del gioco,
 * contiene i metodi principali, che
 * permettono il funzionamento del gioco.
 *
 * @author Francesco Chiacchiari
 */
public class Gioco extends Canvas implements KeyListener, Runnable {

    private static final int larghezza = 500;
    private static final int altezza = 600;
    private static final String titolo = "Invasione Aliena";
    private Giocatore giocatore;
    private Bonus naveBonus;
    private int nAlieni = 28;
    private long tempo;
    private boolean bonus = true;
    private JFrame finestraGioco;

    private GestoreInterfaccia gestoreFaccia;

    private Alieni alieni;
    private boolean giocoAttivo = false;
    private boolean vittoria = false;
    private int punteggio;

    public GestoreSuono gestoreSuono = new GestoreSuono();

    BufferedImage fine = null;
    BufferedImage sfondo = null;
    BufferedImage nave = null;
    BufferedImage naveBonusimg = null;
    BufferedImage nemici = null;
    BufferedImage nemici2 = null;
    BufferedImage bombaAlieno = null;
    BufferedImage proiettileNavicella = null;


    public Gioco(GestoreInterfaccia gestoreInterfaccia) {
        this.gestoreFaccia = gestoreInterfaccia;
        this.tempo = System.currentTimeMillis();
        caricaRisorse();
        //gestoreSuono.caricasuono("D:/esercizi/InvasioneAliena/src/it/unimol/risorse/suoni/Duck song.wav");
        iniziaGioco();
    }

    private void iniziaGioco() {
        this.punteggio = 0;
        giocatore = new Giocatore(nave, proiettileNavicella, 200, 50, 40, this);
        alieni = new Alieni(nemici, nemici2, bombaAlieno, 500, this);
        naveBonus = new Bonus(naveBonusimg, 550, 50, 40, this);
        alieni.start();
    }

    /**
     * Metodo che preimposta il gioco: fa partire il gioco impostando la finestra,
     * settando a 0 il punteggio e starta il thread principale per
     * iniziare effettivamente il gioco
     *
     * @param finestra
     */

    public void start(JFrame finestra) {
        this.finestraGioco = finestra;
        Dimension dimensioneFinestra = new Dimension(larghezza, altezza);
        this.finestraGioco.setPreferredSize(dimensioneFinestra);
        this.finestraGioco.setMaximumSize(dimensioneFinestra);
        this.finestraGioco.setResizable(false);

        this.finestraGioco.add(this);
        this.finestraGioco.addKeyListener(this);

        this.finestraGioco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.finestraGioco.pack();
        this.finestraGioco.setVisible(true);
        System.out.println(this.finestraGioco);

        Thread thread = new Thread(this);

        thread.start();
    }

    private void caricaRisorse() {
        CaricatoreImmagini carica = new CaricatoreImmagini();

        fine = carica.caricaImmagine("spaceVictory.jpg");
        sfondo = carica.caricaImmagine("sfondo.png");
        nave = carica.caricaImmagine("navicella 1..png");
        naveBonusimg = carica.caricaImmagine("alieno 2.png");
        nemici = carica.caricaImmagine("navicella n 2..png");
        nemici2 = carica.caricaImmagine("alieno2.png");
        bombaAlieno = carica.caricaImmagine("alienProiettile.jpg");
        proiettileNavicella = carica.caricaImmagine("naveproiettile.jpg");
        System.out.println("risorse caricate");
    }

    private void aggironaFrame() {
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if (bufferStrategy == null) {
            createBufferStrategy(2);
            return;
        }

        Graphics g = bufferStrategy.getDrawGraphics();
        g.drawImage(sfondo, 0, 0, larghezza, altezza, this);
        bonus();

        giocatore.disegna(g);
        alieni.disegna(g);

        if (naveBonus.getStato())
            naveBonus.disegna(g);

        g.setColor(Color.red);
        g.drawString("Vite: " + giocatore.vita, 25, 25);

        g.setColor(Color.red);
        g.drawString("Punteggio: " + punteggio, 350, 25);

        if (Giocatore.proiettili != null) {
            for (Proiettile p : Giocatore.proiettili) {
                p.disegna(g);
            }
        }
        if (Alieno.bombe != null) {
            //this.gestoreSuono.caricasuono("D:/esercizi/InvasioneAliena/src/it/unimol/risorse/suoni/smb_fireworks.wav");
            if (!Alieno.bombe.isEmpty()) {
                for (int i = 0; i < Alieno.bombe.size(); i++) {
                    Alieno.bombe.get(i).disegna(g);
                }
            }
        }
        g.dispose();
        bufferStrategy.show();
    }

    private void bonus() {
        if (bonus) {
            if (tempo + 20000 <= System.currentTimeMillis()) {
                if (!naveBonus.isAlive()) {
                    naveBonus.start();
                    bonus = false;
                }
            }
        }

    }


    private boolean controllaSconfitta() {
        return giocatore.vita <= 0;
    }

    private boolean controllaVittoria() {
        return nAlieni <= 0;
    }

    private void collisioneAlienoProiettile(Proiettile p) {
        ArrayList<Alieno> alien = alieni.getAlieni();
        for (Alieno a : alien) {
            if (GestoreCollisioni.controllaProiettileNave(p, a)) {
                Giocatore.proiettili.remove(p);
                alien.remove(a);
                nAlieni -= 1;
                this.punteggio += 100;
                break;
            }
        }
    }

    private void collisioneBonus(Proiettile p) {
        if (GestoreCollisioni.controllaCollisioniBonus(p, naveBonus)) {
            naveBonus.setAttivo(false);
            this.punteggio += 500;
        }
    }

    private void collisioneBombaNavicella() {
        ArrayList<Bombe> bombe = Alieno.bombe;
        for (Bombe b : bombe) {
            if (GestoreCollisioni.controllaProiettiliNemici(b, giocatore)) {
                giocatore.vita -= 1;
                bombe.remove(b);
                this.punteggio -= 100;
                break;
            }
        }
    }

    private void collisioneAlienoNavicella() {
        ArrayList<Alieno> alien = alieni.getAlieni();
        for (Alieno a : alien) {
            if (GestoreCollisioni.controllaCollisioni(giocatore, a)) {
                giocatore.vita -= 1;
                alien.remove(a);
                break;
            }
        }

    }

    private void controlloCollisioniGioco() {
        ArrayList<Proiettile> proiettili = Giocatore.proiettili;

        for (Proiettile p : proiettili) {
            collisioneAlienoProiettile(p);
            collisioneBonus(p);
            break;
        }
        collisioneAlienoNavicella();
        collisioneBombaNavicella();
        if (controllaSconfitta()) {
            this.giocoAttivo = false;
        }
        if (controllaVittoria()) {
            this.giocoAttivo = false;
            this.vittoria = true;
        }

    }

    /**
     * metodo richiamato dall' estensione Thread,
     * permette di ridisegnare le entita tramite il metodo {@code disegna()},
     * controlla inoltre le collisioni con il metodo {@code aggiorna},
     * e chiama il metodo {@code controlloVittoria()} per
     * controllare se il giocatore ha perso o vinto!
     */

    @Override
    public void run() {
        giocoAttivo = true;
        while (giocoAttivo) {
            controlloCollisioniGioco();
            aggironaFrame();
        }
        controlloFineGioco();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keycode = e.getKeyCode();
        switch (keycode) {
            default:
                break;
            case KeyEvent.VK_LEFT:
                giocatore.spostaSinistra();
                break;
            case KeyEvent.VK_RIGHT:
                giocatore.spostaDestra();
                break;
            case KeyEvent.VK_SPACE:
                giocatore.spara();
                this.gestoreSuono.caricasuono("D:/esercizi/InvasioneAliena/src/it/unimol/risorse/suoni/smb_fireworks.wav");
                break;

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    private void controlloFineGioco() {
        if (vittoria) {
            //gestoreSuono.clip.stop();
            //gestoreSuono.caricasuono("D:/esercizi/InvasioneAliena/src/it/unimol/risorse/suoni/Game Over.wav");
            caricaVittoria();
        } else if (!giocoAttivo) {
            assert false;
            //gestoreSuono.clip.stop();
            //gestoreSuono.caricasuono("D:/esercizi/InvasioneAliena/src/it/unimol/risorse/suoni/Game Over.wav");
            caricaGameOver();
        }

    }

    private void caricaGameOver() {
        this.finestraGioco.setVisible(false);
        this.gestoreFaccia.status = 2;
        this.gestoreFaccia.setPuteggioFinale(this.punteggio);
        this.gestoreFaccia.sceltaInterfaccia();
        System.out.println(this.punteggio);
    }

    private void caricaVittoria() {
        this.finestraGioco.setVisible(false);
        this.gestoreFaccia.status = 3;
        this.gestoreFaccia.setPuteggioFinale(this.punteggio);
        this.gestoreFaccia.sceltaInterfaccia();
    }

    /**
     * metodo statico, quindi non associato ad alcuna istanza,
     * ùrichiamato per recuparare la larghezza del frame di gioco
     * @return larghezza del frame di gioco
     */
    public static int getLarghezza() {
        return larghezza;
    }

}
