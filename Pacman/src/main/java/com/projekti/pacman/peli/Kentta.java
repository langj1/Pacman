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
public interface Kentta {
    
    public int[][]getKentta();
    
    public void asetaUusiArvo(int x, int y, int uusiArvo);
    
    public int haePisteenArvo(int x, int y);
    
    public int getPisteet();
    
    public Pacman pacmaninLahtokohta();
    
    public ArrayList<Monsteri> monsterienLahtokohdat();
}
