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
public class Peli {
    
    private Kentta kentta;
    private int elamat;
    
    public Peli(Kentta kentta){
        
        this.kentta = kentta;
        elamat = 3;
    }
    
    public void menetaElama(){
        
        elamat--;
        
        if(elamat < 0){
            
        }
    }
}
