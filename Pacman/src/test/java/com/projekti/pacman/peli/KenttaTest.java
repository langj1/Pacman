/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.peli;

import com.projekti.pacman.logiikka.Monsteri;
import com.projekti.pacman.logiikka.Pacman;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author langjimi
 */
public class KenttaTest {
    
    Kentta taso;
    
    @Before
    public void setUp(){
        taso = new Taso1();
    }
    
    @Test
    public void pisteenArvonHakuToimii() {
        assertEquals(5, taso.haePisteenArvo(13, 1));
    }
    
    @Test
    public void asetaUusiArvoToimii() {
        
        taso.asetaUusiArvo(2, 2, 120);
        
        assertEquals(120, taso.haePisteenArvo(2, 2));
    }
    
    @Test
    public void pacmaninLahtokohtaToimii() {
        
        Pacman pacman = taso.pacmaninLahtokohta();
        
        assertEquals(13, pacman.getxKordinaatti());
    }
    
    @Test
    public void monsterienLahtokohdatToimii() {
        
        ArrayList<Monsteri> monsterit = taso.monsterienLahtokohdat();
        
        assertEquals(7, monsterit.get(0).getxKordinaatti());
    }
}
