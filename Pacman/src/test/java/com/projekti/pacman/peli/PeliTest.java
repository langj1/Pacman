/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.peli;

import com.projekti.pacman.Suunta;
import com.projekti.pacman.logiikka.Liikkuva;
import com.projekti.pacman.logiikka.Monsteri;
import com.projekti.pacman.logiikka.Pacman;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author langjimi
 */
public class PeliTest {

    Peli peli;

    @Before
    public void setUp() {
        peli = new Peli(new Taso1());
    }

    @Test
    public void menetaElamaPoistaaYhdenElaman() {

        peli.menetaElama();

        assertEquals(2, peli.getElamat());
    }

    @Test
    public void voittoToimiiKunTarpeeksiPisteita() {

        for (int i = 0; i < peli.getKentta().getLeveys(); i++) {
            for (int j = 0; j < peli.getKentta().getPituus(); j++) {
                peli.getKentta().asetaUusiArvo(i, j, 0);
            }
        }

        assertTrue(peli.voitto());
    }

    @Test
    public void voittoToimiiKunLiianVahanPisteita() {

        assertFalse(peli.voitto());
    }

    @Test
    public void resetEiMuutaPacmaninPisteita() {

        peli.getPacman().setPisteet(25);
        peli.reset();
        assertEquals(25, peli.getPacman().getPisteet());
    }

    @Test
    public void resetinJalkeenOikeaMaaraLiikkuvia() {

        int liikkuvat = 0;

        peli.reset();

        for (int i = 0; i < peli.getKentta().kentta[0].length; i++) {
            for (int j = 0; j < peli.getKentta().kentta.length; j++) {

                if (peli.getKentta().haePisteenArvo(j, i) == 4 || peli.getKentta().haePisteenArvo(j, i) == 3) {
                    liikkuvat++;
                }
            }
        }

        assertEquals(5, liikkuvat);
    }

    @Test
    public void resetSiirtaaPacmaninOikeaanPaikkaan() {

        peli.getPacman().setKoordinaatit(10, 10);
        peli.getKentta().asetaUusiArvo(10, 10, 4);
        peli.getKentta().asetaUusiArvo(13, 1, 0);
        peli.reset();

        assertEquals(4, peli.getKentta().haePisteenArvo(13, 4));
        assertEquals(1, peli.getKentta().haePisteenArvo(10, 10));
    }

    @Test
    public void havioToimiiKunElamiaJaljella() {
        assertFalse(peli.havio());
    }

    @Test
    public void havioToimiiKunElamatLoppu() {

        peli.menetaElama();
        peli.menetaElama();
        peli.menetaElama();

        assertTrue(peli.havio());
    }

}
