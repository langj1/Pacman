/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.gui;

import com.projekti.pacman.peli.Peli;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author langjimi
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

    @Override
    public void run() {
        
        frame = new JFrame("Pacman");
        
        int leveys = (peli.getKentta().getLeveys()+1)*sivu+10;
        int pituus = (peli.getKentta().getPituus()+1)*sivu+10;
        
        frame.setPreferredSize(new Dimension(leveys, pituus));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }
    
    public void luoKomponentit(Container container){
        
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
