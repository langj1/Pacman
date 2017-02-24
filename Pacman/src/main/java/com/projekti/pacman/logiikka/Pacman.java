/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.logiikka;

import com.projekti.pacman.Suunta;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;

/**
 * Luokka kuvaa Pacmania, joka kerää pisteitä ja välttää monstereita Perii
 * luokan Liikkuva.
 */
public class Pacman extends Liikkuva {

    private int pisteet;
    private boolean suuAuki;
    private int extraPisteet;

    public Pacman(int alkuX, int alkuY) {
        super(alkuX, alkuY);
        this.suuAuki = false;
        this.extraPisteet = 0;
        this.pisteet = 0;
    }

    public int getPisteet() {
        return pisteet;
    }

    public void setPisteet(int pisteet) {
        this.pisteet = pisteet;
    }

    @Override
    public boolean onPacman() {
        return true;
    }

    public boolean isSuuAuki() {
        return suuAuki;
    }

    public void setSuuAuki(boolean suuAuki) {
        this.suuAuki = suuAuki;
    }

    public int getExtraPisteet() {
        return extraPisteet;
    }

    public void setExtraPisteet(int extraPisteet) {
        this.extraPisteet = extraPisteet;
    }

    @Override
    public BufferedImage piirra() {

        BufferedImage pacmanImg = null;
        try {
            if (getSuunta() == Suunta.VASEN) {
                InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Pacman Left.png");
                pacmanImg = ImageIO.read(is);
                setSuuAuki(false);
            }
            if (getSuunta() == Suunta.OIKEA) {
                InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Pacman Right.png");
                pacmanImg = ImageIO.read(is);
                setSuuAuki(false);
            }
            if (getSuunta() == Suunta.ALAS) {
                InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Pacman Down.png");
                pacmanImg = ImageIO.read(is);
                setSuuAuki(false);
            }
            if (getSuunta() == Suunta.YLOS) {
                InputStream is = getClass().getClassLoader().getResourceAsStream("Images/Pacman Up.png");
                pacmanImg = ImageIO.read(is);
                setSuuAuki(false);
            }
            if (getSuunta() == Suunta.STOP) {
                return null;
            }

        } catch (IOException e) {
        }
        return pacmanImg;
    }

}
