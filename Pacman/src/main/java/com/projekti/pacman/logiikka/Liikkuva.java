/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.logiikka;

import com.projekti.pacman.Suunta;

/**
 *
 * @author langjimi
 */
public class Liikkuva {

    Suunta suunta;
    private int xKordinaatti;
    private int yKordinaatti;
    private boolean pisteenPaalla;

    public Liikkuva(int alkuX, int alkuY) {

        this.suunta = suunta.STOP;
        this.xKordinaatti = alkuX;
        this.yKordinaatti = alkuY;
        this.pisteenPaalla = false;

    }

    public void setPisteenPaalla(boolean pisteenPaalla) {
        this.pisteenPaalla = pisteenPaalla;
    }

    public boolean isPisteenPaalla() {
        return pisteenPaalla;
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

    public int[] getKoordinaatit() {

        int[] koordinaatit = {yKordinaatti, xKordinaatti};

        return koordinaatit;
    }

    public void setKoordinaatit(int x, int y) {
        this.xKordinaatti = x;
        this.yKordinaatti = y;
    }

    public void liiku() {

        if (suunta == suunta.VASEN) {
            this.xKordinaatti--;
        }
        if (suunta == suunta.OIKEA) {
            this.xKordinaatti++;
        }
        if (suunta == suunta.YLOS) {
            this.yKordinaatti--;
        }
        if (suunta == suunta.ALAS) {
            this.yKordinaatti++;
        }
    }

    public int getKenttaNumero() {
        return 4;
    }

    public boolean onPacman() {
        return false;
    }
}
