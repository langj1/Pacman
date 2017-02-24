/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.gui;

import com.projekti.pacman.peli.Peli;
import java.awt.Container;
import java.awt.Cursor;
import static java.awt.Cursor.CROSSHAIR_CURSOR;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 * Huolehtii pelin grafiikoista.
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Peli peli;
    private Piirtoalusta alusta;
    private int sivu;

    public Kayttoliittyma(Peli peli, int sivu) {

        this.peli = peli;
        this.sivu = sivu;
    }

    /**
     * Luo uuden ikkunan ja asetta sille arvot ja sisällön.
     */
    @Override
    public void run() {

        frame = new JFrame("Pacman");

        int leveys = (peli.getKentta().getLeveys()) * sivu + sivu / 2;
        int pituus = (peli.getKentta().getPituus() + 1) * sivu + sivu / 2;

        frame.setPreferredSize(new Dimension(leveys, pituus));

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(frame.getContentPane());

        Cursor cursor = new Cursor(CROSSHAIR_CURSOR);

        frame.setCursor(cursor);

        frame.pack();
        frame.setLocationRelativeTo(null);

        frame.setVisible(true);
    }

    /**
     * Yhdistää Näppäimistönkuuntelijan ja Piirtoalustan Käyttöliittymään.
     *
     * @param container
     */
    public void luoKomponentit(Container container) {

        alusta = new Piirtoalusta(peli, sivu);

        container.add(alusta);

        Nappaimistonkuuntelija kuuntelija = new Nappaimistonkuuntelija(peli.getPacman());

        frame.addKeyListener(kuuntelija);
    }

    public Piirtoalusta getAlusta() {
        return alusta;
    }

    public JFrame getFrame() {
        return frame;
    }

}
