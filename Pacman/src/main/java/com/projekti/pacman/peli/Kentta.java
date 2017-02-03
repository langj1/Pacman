/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.peli;

import com.projekti.pacman.logiikka.Monsteri;
import com.projekti.pacman.logiikka.Pacman;
import java.util.ArrayList;

/**
 *
 * @author langjimi
 */
public abstract class Kentta {

    int[][] kentta;
    private int pisteet;

    public Kentta() {
        kentta = new int[111][111];
        pisteet = 0;
    }

    public void setKentta(int[][] kentta) {
        this.kentta = kentta;
    }

    public int[][] getKentta() {
        return kentta;
    }

    public void asetaUusiArvo(int x, int y, int uusiArvo) {

        kentta[x][y] = uusiArvo;
    }

    public int haePisteenArvo(int x, int y) {
        return kentta[x][y];
    }

    public int getPisteet() {

        return pisteet;
    }

    public void setPisteet(int pisteet) {
        this.pisteet = pisteet;
    }
    
    public Pacman pacmaninLahtokohta() {
        
        for (int i = 0; i < kentta.length; i++) {
            for (int j = 0; j < kentta[0].length; j++) {

                if (kentta[j][i] == 4) {
                    return new Pacman(j, i);
                }
            }
        }
        
        return null;
    }

    public ArrayList<Monsteri> monsterienLahtokohdat() {

        ArrayList<Monsteri> monsterit = new ArrayList<>();

        for (int i = 0; i < kentta.length; i++) {
            for (int j = 0; j < kentta[0].length; j++) {

                if (kentta[j][i] == 3) {
                    monsterit.add(new Monsteri(j, i));
                }
            }
        }

        return monsterit;
    }

    public void reset() {

    }

}
