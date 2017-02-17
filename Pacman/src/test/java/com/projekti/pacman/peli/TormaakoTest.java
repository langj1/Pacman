/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.peli;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author langjimi
 */
public class TormaakoTest {
    
    Peli peli;
    Tormaako tormaako;

    @Before
    public void setUp() {
        peli = new Peli(new Taso1());
        tormaako = new Tormaako(peli.getKentta(), peli);
    }
    
     @Test
    public void tormaakoMonsteriToimiiKunEiTormaa() {

        tormaako.tormaakoMonsteri(peli.getMonsterit().get(0));

        assertEquals(3, peli.getElamat());
        assertFalse(peli.getMonsterit().get(0).isPisteenPaalla());
    }

    @Test
    public void tormaakoMonsteriToimiiKunTormaaPacmaniin() {

        peli.getKentta().asetaUusiArvo(peli.getMonsterit().get(0).getxKordinaatti(), peli.getMonsterit().get(0).getyKordinaatti(), 4);
        tormaako.tormaakoMonsteri(peli.getMonsterit().get(0));

        assertEquals(2, peli.getElamat());
        assertFalse(peli.getMonsterit().get(0).isPisteenPaalla());
    }

    @Test
    public void tormaakoMonsteriToimiiKunTormaaPisteeseen() {

        peli.getKentta().asetaUusiArvo(peli.getMonsterit().get(0).getxKordinaatti(), peli.getMonsterit().get(0).getyKordinaatti(), 2);
        tormaako.tormaakoMonsteri(peli.getMonsterit().get(0));

        assertEquals(3, peli.getElamat());
        assertTrue(peli.getMonsterit().get(0).isPisteenPaalla());
    }

    @Test
    public void tormaakoPacmanToimiiKunEiTormaa() {

        tormaako.tormaakoPacman(peli.getPacman());

        assertEquals(3, peli.getElamat());
        assertEquals(0, peli.getPacman().getPisteet());
    }

    @Test
    public void tormaakoPacmanToimiiKunTormaaMonsteriin() {

        peli.getKentta().asetaUusiArvo(peli.getPacman().getxKordinaatti(), peli.getPacman().getyKordinaatti(), 3);
        tormaako.tormaakoPacman(peli.getPacman());

        assertEquals(2, peli.getElamat());
        assertEquals(0, peli.getPacman().getPisteet());
    }

    @Test
    public void tormaakoPacmanToimiiKunTormaaPisteeseen() {

        peli.getKentta().asetaUusiArvo(peli.getPacman().getxKordinaatti(), peli.getPacman().getyKordinaatti(), 2);
        tormaako.tormaakoPacman(peli.getPacman());

        assertEquals(3, peli.getElamat());
        assertEquals(1, peli.getPacman().getPisteet());
    }
}
