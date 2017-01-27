/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.peli;

import com.projekti.pacman.logiikka.Monsteri;
import com.projekti.pacman.logiikka.Pacman;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author langjimi
 */
public class Peli {
    
    private Kentta kentta;
    private int elamat;
    private ArrayList<Monsteri> monsterit;
    private Pacman pacman;
    
    public Peli(Kentta kentta){
        
        this.kentta = kentta;
        this.pacman = kentta.pacmaninLahtokohta();
        this.monsterit = kentta.monsterienLahtokohdat();
        elamat = 3;
    }
    
    public void menetaElama(){
        
        elamat--;
        
        if(elamat < 0){
            
        }
        
        
    }
    
    public void liiku(){
        
        arvoSuunnat();
        pacman.liiku();
        
        for (Monsteri monsteri : monsterit) {
            monsteri.liiku();
        }
        
    }
    
    public void arvoSuunnat(){
        
        Random random = new Random();
        
        for (Monsteri monsteri : monsterit) {
            
            int satunnaismuuttuja = random.nextInt(101);
            
            if(satunnaismuuttuja < 50 ){
                
                monsteri.arvoSuunta();
                
            } 
            
        }
        
    }
}
