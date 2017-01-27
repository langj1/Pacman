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
public class Monsteri {
    
    private int xKoordinaatti;
    private int yKoordinaatti;
    private Suunta suunta;
    
    public Monsteri(int alkuX, int alkuY){
        
        this.xKoordinaatti = alkuX;
        this.yKoordinaatti = alkuY;
        this.suunta = suunta.STOP;
        
    }

    public Suunta getSuunta() {
        return suunta;
    }

    public int getxKoordinaatti() {
        return xKoordinaatti;
    }

    public int getyKoordinaatti() {
        return yKoordinaatti;
    }

    public void liiku(){
        
    }
    
    
}
