/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.peli;

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
                 {0,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,4,0},
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
    public int getPisteet() {
        
        return pisteet;
    }
    
    
    
    
    
}
