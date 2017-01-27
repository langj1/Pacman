/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.logiikka;


import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author langjimi
 */
public class MonsteriTest {
    
    Monsteri monsteri;
    
    @Before
    public void setUp(){
        monsteri = new Monsteri(0,0);
    }
    
    @Test
    public void arvoSuuntaAsettaaUudenSuunnan() {
        
        monsteri.arvoSuunta();
        
        int y = 0;
        
        String x = monsteri.getSuunta() + "";
        
        if(x.equals("STOP")){
            y=1;
        }
        
        System.out.println(x);
        
        assertEquals(0, y);
    }
    
}
