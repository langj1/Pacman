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
    
    private Suunta suunta;
    private int xKordinaatti;
    private int yKordinaatti;

    public Liikkuva(int alkuX, int alkuY) {

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
}
