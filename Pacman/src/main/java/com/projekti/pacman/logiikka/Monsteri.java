/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.logiikka;

import com.projekti.pacman.Suunta;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;

/**
 * Luokka kuvaa Pacmania jahtaavia monstereita Perii luokan Liikkuva.
 */
public class Monsteri extends Liikkuva {

    private int suuntaArvo;
    private int vari;
    private int valkkyy;

    /**
     * SuuntaArvoa käytetään satunnaisen suunnan valinnassa.
     *
     * @param alkuX
     * @param alkuY
     */
    public Monsteri(int alkuX, int alkuY, int vari) {
        super(alkuX, alkuY);

        this.suuntaArvo = 0;
        this.vari = vari;
        this.valkkyy = 0;
    }

    /**
     * Metodi valitsee sattumanvaraisesti yhden suunnista, jotka sen parametrina
     * saama lista sisältää. VASEN = 1, OIKEA = 2, YLOS = 3, ALAS = 4
     *
     * @param suunnat lista mahdollisista suunnista
     */
    public void arvoSuunta(ArrayList<Integer> suunnat) {

        Random random = new Random();

        while (true) {
            int satunnaismuuttuja = random.nextInt(100);

            if (satunnaismuuttuja < 25) {

                setSuunta(suunta.ALAS);
                this.suuntaArvo = 4;

            } else if (satunnaismuuttuja < 50) {

                setSuunta(suunta.OIKEA);
                this.suuntaArvo = 2;

            } else if (satunnaismuuttuja < 75) {

                setSuunta(suunta.VASEN);
                this.suuntaArvo = 1;

            } else {

                setSuunta(suunta.YLOS);
                this.suuntaArvo = 3;
            }

            if (suunnat.contains(this.suuntaArvo)) {
                break;
            }
        }
    }

    @Override
    public int getKenttaNumero() {
        return 3;
    }

    public int getSuuntaArvo() {
        return suuntaArvo;
    }

    public int getVari() {
        return vari;
    }

    public void setVari(int vari) {
        this.vari = vari;
    }

    public void valkkyy() {
        if (valkkyy == 1) {
            valkkyy = 2;
        } else {
            valkkyy = 1;
        }
    }

    @Override
    public BufferedImage piirra() {
    
        BufferedImage ghostImg = null;
        try {
            if (vari == 1 && isSyotava()) {
                InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Evading Ghost.png");
                ghostImg = ImageIO.read(is);
            } else if (vari == 1) {
                InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Orange Ghost.png");
                ghostImg = ImageIO.read(is);
            }
            if (vari == 2 && isSyotava()) {
                InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Evading Ghost.png");
                ghostImg = ImageIO.read(is);
            } else if (vari == 2) {
                InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Teal Ghost.png");
                ghostImg = ImageIO.read(is);
            }
            if (vari == 3 && isSyotava()) {
                InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Evading Ghost.png");
                ghostImg = ImageIO.read(is);
            } else if (vari == 3) {
                InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Pink Ghost.png");
                ghostImg = ImageIO.read(is);
            }
            if (vari == 4 && isSyotava()) {
                InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Evading Ghost.png");
                ghostImg = ImageIO.read(is);
            } else if (vari == 4) {
                InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Red Ghost.png");
                ghostImg = ImageIO.read(is);
            }
        } catch (IOException e) {
        }
        return ghostImg;
    }

}
