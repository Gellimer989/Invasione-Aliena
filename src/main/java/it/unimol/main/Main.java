package it.unimol.main;

import it.unimol.gestori.GestoreInterfaccia;


import javax.swing.*;

public class Main {

    public static void main( String args[] ) {
        JFrame FinestrIniziale = new JFrame();
        FinestrIniziale.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        FinestrIniziale.setSize(500, 600);
        FinestrIniziale.setVisible(true);
        new GestoreInterfaccia(FinestrIniziale);
    }
}
