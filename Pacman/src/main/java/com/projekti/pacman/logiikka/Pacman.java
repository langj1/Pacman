/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.logiikka;

import com.projekti.pacman.Suunta;

public class Pacman {

    private Suunta suunta;
    private int xKordinaatti;
    private int yKordinaatti;

    public Pacman(int alkuX, int alkuY) {

        this.suunta = suunta.STOP;
        this.xKordinaatti = alkuX;
        this.yKordinaatti = alkuY;

    }

    public Suunta getSuunta() {
        return suunta;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    public int getxKordinaatti() {
        return xKordinaatti;
    }

    public int getyKordinaatti() {
        return yKordinaatti;
    }

    public void liiku() {

        if (suunta == suunta.VASEN) {

        }
        if (suunta == suunta.OIKEA) {

        }
        if (suunta == suunta.YLOS) {

        }
        if (suunta == suunta.ALAS) {

        }
    }

}
