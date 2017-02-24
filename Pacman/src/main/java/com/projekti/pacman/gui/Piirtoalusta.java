/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.gui;

import com.projekti.pacman.Suunta;
import com.projekti.pacman.logiikka.Monsteri;
import com.projekti.pacman.peli.Kentta;
import com.projekti.pacman.peli.Peli;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Piirtää tason.
 *
 * @author langjimi
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
     * Piirtää tasoon kaiken tarvittavan aina kun se päivitetään.
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

//                    gf.setColor(Color.RED);
//
//                    gf.fillOval(j * sivu, i * sivu, sivu, sivu);

                    int vari = 0;
                    boolean syotava = false;
                    
                    for (Monsteri n : peli.getMonsterit()) {
                        if (n.getxKordinaatti() == j && n.getyKordinaatti() == i) {
                            vari = n.getVari();
                            syotava = n.isSyotava();
                        }
                    }

                    BufferedImage ghostImg = null;
                    try {
                        if (vari == 1 && syotava) {
                            InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Evading Ghost.png");
                            ghostImg = ImageIO.read(is);
                        }else if (vari == 1) {
                            InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Orange Ghost.png");
                            ghostImg = ImageIO.read(is);
                        }
                        if (vari == 2 && syotava) {
                            InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Evading Ghost.png");
                            ghostImg = ImageIO.read(is);
                        }else if (vari == 2) {
                            InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Teal Ghost.png");
                            ghostImg = ImageIO.read(is);
                        }
                        if (vari == 3 && syotava) {
                            InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Evading Ghost.png");
                            ghostImg = ImageIO.read(is);
                        }else if (vari == 3) {
                            InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Pink Ghost.png");
                            ghostImg = ImageIO.read(is);
                        }
                        if (vari == 4 && syotava) {
                            InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Evading Ghost.png");
                            ghostImg = ImageIO.read(is);
                        }else if (vari == 4) {
                            InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Red Ghost.png");
                            ghostImg = ImageIO.read(is);
                        }
                    } catch (IOException e) {
                    }

                    gf.drawImage(ghostImg, j * sivu, i * sivu, sivu, sivu, this);
                }

                if (kentta[j][i] == 4) {

                    if (peli.getPacman().isSuuAuki()) {

                        BufferedImage pacmanImg = null;
                        try {
                            if (peli.getPacman().getSuunta() == Suunta.VASEN) {
                                InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Pacman Left.png");
                                pacmanImg = ImageIO.read(is);
                                peli.getPacman().setSuuAuki(false);
                            }
                            if (peli.getPacman().getSuunta() == Suunta.OIKEA) {
                                InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Pacman Right.png");
                                pacmanImg = ImageIO.read(is);
                                peli.getPacman().setSuuAuki(false);
                            }
                            if (peli.getPacman().getSuunta() == Suunta.ALAS) {
                                InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Pacman Down.png");
                                pacmanImg = ImageIO.read(is);
                                peli.getPacman().setSuuAuki(false);
                            }
                            if (peli.getPacman().getSuunta() == Suunta.YLOS) {
                                InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Pacman Up.png");
                                pacmanImg = ImageIO.read(is);
                                peli.getPacman().setSuuAuki(false);
                            }
                            if (peli.getPacman().getSuunta() == Suunta.STOP) {

                                gf.setColor(Color.YELLOW);
                                gf.fillOval(j * sivu, i * sivu, sivu, sivu);
                            }

                        } catch (IOException e) {
                        }

                        gf.drawImage(pacmanImg, j * sivu, i * sivu, sivu, sivu, this);

                    } else {

                        gf.setColor(Color.YELLOW);

                        gf.fillOval(j * sivu, i * sivu, sivu, sivu);

                        peli.getPacman().setSuuAuki(true);
                    }

                }

                if (kentta[j][i] == 5) {

                    gf.setColor(Color.MAGENTA);

                    gf.fillOval(j * sivu + sivu / 6, i * sivu + sivu / 6, sivu / 2 + sivu / 4, sivu / 2 + sivu / 4);

                }
            }
        }

        gf.setColor(Color.white);

        String pisteet = "" + peli.getPacman().getPisteet() * 10;

        gf.drawString(pisteet, (kentta.length - 3) * sivu, 15);

        for (int i = 0; i < peli.getElamat(); i++) {

            gf.setColor(Color.YELLOW);

            gf.fillOval(i * sivu, sivu / 4, sivu / 2, sivu / 2);
//            BufferedImage elama = null;
//            try {
//                elama = ImageIO.read(new File("Images/Pacman Right.png"));
//            } catch (IOException e) {
//            }
//            gf.drawImage(elama, i * sivu, 0 * sivu, sivu / 2, sivu / 2, this);
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
