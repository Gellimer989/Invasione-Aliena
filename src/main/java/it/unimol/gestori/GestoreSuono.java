package it.unimol.gestori;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * classe utilizzata per caricare il file di
 * audio nel gioco, riceve come path il percorso del file
 * che viene gestita da AudioInputStream
 *
 * @author Francesco Chiacchiari
 */

public class GestoreSuono {

    /**
     * metodo che carica il suono, dove verrifica se il file è
     * presente e in caso positivo viene caricato
     * tramite la calsse Clip, un tipo speciale
     * di linea di dati i cui dati audio possono essere
     * caricati prima della riproduzione, anziché essere trasmessi in streaming in tempo reale.
     *
     * @param path percorso relativo al file audio
     */
    public void caricasuono(String path) {
        try {
            File music = new File(path);

            if (music.exists()) {
                Clip clip;
                if (path.equals("D:/esercizi/InvasioneAliena/src/it/unimol/risorse/suoni/Duck song.wav")) {
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(music);
                    clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.start();
                    clip.loop(6);
                } else {
                    AudioInputStream audioInput = AudioSystem.getAudioInputStream(music);
                    clip = AudioSystem.getClip();
                    clip.open(audioInput);
                    clip.start();
                }
            }

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }

    }
}
