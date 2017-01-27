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
public class Taso1 implements Kentta {
    
    private int[][] kentta;
    private int pisteet;
    
    //0=muuri, 1=tyhja, 2=piste, 3=monsteri, 4=pacman
    
    public Taso1(){
        int[][] kentta = {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                 {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
                 {0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0},
                 {0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0},
                 {0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0},
                 {0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0},
                 {0,2,0,0,2,0,0,1,1,1,1,1,1,0,0,2,0,0,2,0},
                 {0,2,2,2,2,2,2,1,3,3,3,3,1,2,2,2,2,2,2,0},
                 {0,2,0,0,2,0,0,1,1,1,1,1,1,0,0,2,0,0,2,0},
                 {0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0},
                 {0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0},
                 {0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0},
                 {0,2,0,0,2,0,0,0,0,0,0,0,0,0,0,2,0,0,2,0},
                 {0,4,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,0},
                 {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
        
        pisteet = 87;
            
        
    }

    @Override
    public int[][] getKentta() {
        return kentta;
    }

    @Override
    public void asetaUusiArvo(int x, int y, int uusiArvo) {
         
        kentta[x][y] = uusiArvo;  
    }
    
    @Override
    public int haePisteenArvo(int x, int y){
        return kentta[x][y];
    }

    @Override
    public int getPisteet() {
        
        return pisteet;
    }
    
    public Pacman pacmaninLahtokohta(){
        return new Pacman(1,0);
    }
    
    public ArrayList<Monsteri> monsterienLahtokohdat(){
        
        ArrayList<Monsteri> monsterit = new ArrayList<>();
        
        for (int i = 0; i < 4; i++) {
            monsterit.add(new Monsteri(8+i,7));
        }
        
        return monsterit;
    }
    
    //Kun menettää elämän, pacman ja monsterit siirtyy aloituskohtiin, mutta 
    //pisteet ei resetoidu
    public void reset(){
        
    }
    
    
    
}
