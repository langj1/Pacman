/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman;

import com.projekti.pacman.peli.Peli;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Määrittää kauan Monsterit pysyy syötävänä.
 *
 * @author langjimi
 */
public class PowerUpAjastin {

    private Peli peli;
    private Timer ajastin;

    /**
     * Saa pelin parametrina sekä luo ja käynnistää ajastimen.
     *
     * @param peli Peli, jolle ajastin luodaan.
     */
    public PowerUpAjastin(Peli peli) {
        this.peli = peli;
        ajastin = new Timer();
        kaynnistaPowerUpAjastin();
        kaynnistaValkkyyAjastin();
    }

    /**
     * Ajastimen päättyessä Monsterit asetetaan normaaleiksi.
     */
    public void kaynnistaPowerUpAjastin() {
        ajastin.schedule(new TimerTask() {
            @Override
            public void run() {
                peli.monsteritNormaaleiksi(); //To change body of generated methods, choose Tools | Templates.
            }
        }, 8000);
    }

    /**
     * Ajastimen päättyessä monsterit välkkyy.
     */
    public void kaynnistaValkkyyAjastin() {
        ajastin.schedule(new TimerTask() {
            @Override
            public void run() {
                peli.monsteritValkkyviksi(); //To change body of generated methods, choose Tools | Templates.
            }
        }, 5000);
    }

    /**
     * Nollaa ajastimen.
     */
    public void cancel() {
        ajastin.cancel();
    }
}
