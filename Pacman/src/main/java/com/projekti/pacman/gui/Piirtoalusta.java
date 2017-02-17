/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.gui;

import com.projekti.pacman.logiikka.Monsteri;
import com.projekti.pacman.peli.Kentta;
import com.projekti.pacman.peli.Peli;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;

/**
 * Piirtää tason.
 */
public class Piirtoalusta extends JPanel {

    private Peli peli;
    private int sivu;
    private BufferedImage img;
    private Graphics gf;

    public Piirtoalusta(Peli peli, int sivu) {

        super.setBackground(Color.black);
        this.peli = peli;
        this.sivu = sivu;
        this.img = new BufferedImage((peli.getKentta().getLeveys()) * sivu, (peli.getKentta().getPituus() + 1) * sivu, BufferedImage.TYPE_BYTE_INDEXED);
        this.gf = this.img.createGraphics();

    }

    /**
     * Piirtää tasoon kaiken tarvittavan aina kun päivitetään.
     *
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(gf);

        int[][] kentta = peli.getKentta().getKentta();

        for (int i = 0; i < kentta[0].length; i++) {
            for (int j = 0; j < kentta.length; j++) {

                if (kentta[j][i] == 0) {

                    gf.setColor(Color.BLUE);

                    gf.fillRect(j * sivu, i * sivu, sivu, sivu);

                }

                if (kentta[j][i] == 2) {

                    gf.setColor(Color.PINK);

                    gf.fillOval(j * sivu + sivu / 4, i * sivu + sivu / 4, sivu / 2, sivu / 2);

                }

                if (kentta[j][i] == 3) {

                    gf.setColor(Color.RED);

                    gf.fillOval(j * sivu, i * sivu, sivu, sivu);
                }

                if (kentta[j][i] == 4) {

                    gf.setColor(Color.YELLOW);

                    gf.fillOval(j * sivu, i * sivu, sivu, sivu);

                }
            }
        }
        
        gf.setColor(Color.white);
        
        String pisteet = "" + peli.getPacman().getPisteet()*10;
        
        gf.drawString(pisteet, (kentta.length-3)*sivu, 15);
        
        

        for (int i = 0; i < peli.getElamat(); i++) {

            gf.setColor(Color.YELLOW);

            gf.fillOval(i * sivu, 0 * sivu, sivu / 2, sivu / 2);
        }

        g.drawImage(img, 0, 0, this);

        if (peli.voitto()) {
            g.setColor(Color.WHITE);
            g.drawString("Victory!", kentta.length * sivu / 2 - 20, kentta[0].length * sivu / 2);
            peli.stop();
            return;
        }

        if (peli.havio()) {
            g.setColor(Color.WHITE);
            g.drawString("Game Over", kentta.length * sivu / 2 - 38, kentta[0].length * sivu / 2);
            peli.stop();
            return;
        }

    }

    /**
     * Piirtää kentän uudestaan.
     */
    public void paivita() {
        repaint();
    }
}
