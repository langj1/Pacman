/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.logiikka;

import com.projekti.pacman.Suunta;

public class Pacman extends Liikkuva {

    private int pisteet;

    public Pacman(int alkuX, int alkuY) {
        super(alkuX, alkuY);
    }

    public int getPisteet() {
        return pisteet;
    }

    public void setPisteet(int pisteet) {
        this.pisteet = pisteet;
    }

    public void syoPiste() {
        pisteet++;
    }
    
    @Override
    public boolean onPacman(){
        return true;
    }

}
