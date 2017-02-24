/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.peli;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author langjimi
 */
public class PowerUpAjastin {
    
    private Peli peli;
    private Timer ajastin;
    
    public PowerUpAjastin(Peli peli){
        this.peli = peli;
        ajastin = new Timer();
        aloitaPowerUpAjastin();
    }
    
    public void aloitaPowerUpAjastin(){
        ajastin.schedule(new TimerTask() {
            @Override
            public void run() {
                peli.monsteritNormaaleiksi(); //To change body of generated methods, choose Tools | Templates.
            }
        }, 10000);
    }
    
    public void cancel(){
        ajastin.cancel();
    }
}
