/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.logiikka;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author langjimi
 */
public class PacmanTest {

    Pacman pacman;

    @Before
    public void setUp() {
        pacman = new Pacman(12, 31);
    }
    
    @Test
    public void onPacmanToimii() {
        assertTrue(pacman.onPacman());
    }
}
