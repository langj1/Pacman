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
public interface Kentta {
    
    public int[][]getKentta();
    
    public void asetaUusiArvo(int x, int y, int uusiArvo);
    
    public int getPisteet();
}
