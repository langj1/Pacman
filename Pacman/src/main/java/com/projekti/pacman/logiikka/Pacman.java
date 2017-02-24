/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.logiikka;

import com.projekti.pacman.Suunta;

/**
 * Luokka kuvaa Pacmania, joka kerää pisteitä ja välttää monstereita Perii
 * luokan Liikkuva.
 */
public class Pacman extends Liikkuva {

    private int pisteet;
    private boolean suuAuki;

    public Pacman(int alkuX, int alkuY) {
        super(alkuX, alkuY);
        this.suuAuki = false;
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
}
