/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.gui;

import com.projekti.pacman.logiikka.Monsteri;
import com.projekti.pacman.peli.Kentta;
import com.projekti.pacman.peli.Peli;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author langjimi
 */
public class Piirtoalusta extends JPanel {

    private Peli peli;
    private int sivu;
    

    public Piirtoalusta(Peli peli, int sivu) {

        this.peli = peli;
        this.sivu = sivu;
        ;
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        
        int[][] kentta = peli.getKentta().getKentta();

        for (int i = 0; i < kentta[0].length; i++) {
            for (int j = 0; j < kentta.length; j++) {

                if(kentta[j][i] == 0){
                    
                    g.setColor(Color.BLUE);
                    
                    g.fillRect(j*sivu, i*sivu, sivu, sivu);
                    
                }
                
                if(kentta[j][i] == 2){
                    
                    g.setColor(Color.PINK);
                    
                    g.fillOval(j*sivu+sivu/4, i*sivu+sivu/4, sivu/2, sivu/2);
                    
                }
                
                if(kentta[j][i] == 3){
                    
                    g.setColor(Color.RED);
                    
                    g.fillOval(j*sivu, i*sivu, sivu, sivu);
                }
                
                if(kentta[j][i] == 4){
                    
                    g.setColor(Color.YELLOW);
                    
                    g.fillOval(j*sivu, i*sivu, sivu, sivu);
                }
            }
        }

    }
    
    public void paivita(){
        repaint();
    }
}
