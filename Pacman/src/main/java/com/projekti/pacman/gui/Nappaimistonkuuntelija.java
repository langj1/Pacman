/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.gui;

import com.projekti.pacman.Suunta;
import com.projekti.pacman.logiikka.Pacman;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Ottaa näppäimistön painallukset vastaan.
 */
public class Nappaimistonkuuntelija implements KeyListener {

    private Pacman pacman;

    public Nappaimistonkuuntelija(Pacman pacman) {
        this.pacman = pacman;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        ; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Määrittää, mitä näppäimiä käytetään ja mitä ne tekee.
     *
     * @param e Näppäin, jota painettu.
     */
    @Override
    public void keyPressed(KeyEvent e) {

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            pacman.setSuunta(Suunta.OIKEA);
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            pacman.setSuunta(Suunta.VASEN);
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            pacman.setSuunta(Suunta.YLOS);
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            pacman.setSuunta(Suunta.ALAS);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        ; //To change body of generated methods, choose Tools | Templates.
    }

}
