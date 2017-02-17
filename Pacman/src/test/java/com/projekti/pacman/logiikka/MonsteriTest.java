/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.logiikka;


import java.util.ArrayList;
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
        
        ArrayList<Integer> lista = new ArrayList<>();
        lista.add(1);
        lista.add(2);
        lista.add(3);
        
        monsteri.arvoSuunta(lista);
        
        int y = 0;
        
        String x = monsteri.getSuunta() + "";
        
        if(x.equals("STOP")){
            y=1;
        }
        
        assertEquals(0, y);
    }
    
}
