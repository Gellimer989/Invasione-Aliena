package it.unimol.caricatore;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

/**
 * classe utilizzata per effettuare il caricamento di immagini sul frame del gioco,
 *
 * @author Francesco Chiacchiari
 */

public class CaricatoreImmagini {
    BufferedImage image;


    /**
     * con ImageIo,classe contenente metodi di praticità statici per l'individuazione di ImageReader e ImageWriters
     * ed esecuzione di codifica e decodifica semplici;
     * utilizziamo ImageIO.read : restituisce un'immagine con buffer come risultato della decodifica di un file ,
     * fornito con un ImageReader scelto automaticamente tra quelli attualmente caricati.
     *
     * @param percorso la path dell' immagine
     * @return restituisce l' immagine corrispondente al path
     */
    public BufferedImage caricaImmagine(String percorso) {
        try {
            image = ImageIO.read(new File(percorso));
        } catch (IOException e) {
            System.out.println("immagine alla posizione" + percorso + " non è stata caricata correttamente");
            e.printStackTrace();
        }
        return image;
    }
}
