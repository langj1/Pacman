/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.peli;

import com.projekti.pacman.tasot.Taso1;
import com.projekti.pacman.Suunta;
import com.projekti.pacman.gui.Piirtoalusta;
import com.projekti.pacman.logiikka.Monsteri;
import static org.junit.Assert.assertArrayEquals;
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
        peli.menetaElama();
        peli.menetaElama();
        assertFalse(peli.havio());
    }

    @Test
    public void havioToimiiKunElamatLoppu() {

        peli.menetaElama();
        peli.menetaElama();
        peli.menetaElama();

        assertTrue(peli.havio());
    }

    @Test
    public void pacmaninPisteetSailyyResetinJalkeen() {
        peli.getPacman().setPisteet(123);
        peli.reset();
        assertEquals(123, peli.getPacman().getPisteet());
    }

    @Test
    public void pacmaninSuuntaSTOPResetinJalkeen() {

        peli.reset();
        assertEquals(Suunta.STOP, peli.getPacman().getSuunta());
    }

    @Test
    public void monstereillaAlkuKoordinaatitResetinJalkeen() {
        peli.reset();
        for (int i = 0; i < 4; i++) {
            assertArrayEquals(peli.getKentta().monsterienLahtokohdat().get(i).getKoordinaatit(), peli.getMonsterit().get(i).getKoordinaatit());
        }
    }

    @Test
    public void monsteritEiSyotaviaResetinJalkeen() {
        boolean testi = true;
        for (Monsteri m : peli.getMonsterit()) {
            if (m.isSyotava()) {
                testi = false;
            }
        }
        assertTrue(testi);
    }

    @Test
    public void monsteritSyotaviksiToimii() {

        peli.monsteritSyotaviksi();
        for (Monsteri m : peli.getMonsterit()) {
            assertTrue(m.isSyotava());
        }
        assertTrue(peli.getPacman().isSyotava());
    }

    @Test
    public void monsteritNormaaleiksiToimii() {

        peli.monsteritSyotaviksi();
        peli.monsteritNormaaleiksi();
        for (Monsteri m : peli.getMonsterit()) {
            assertFalse(m.isSyotava());
        }
        assertFalse(peli.getPacman().isSyotava());
    }

    @Test
    public void monsteritValkkyviksiToimii() {

        peli.monsteritValkkyviksi();
        for (Monsteri m : peli.getMonsterit()) {
            assertEquals(1, m.getValkkyy());
        }
    }

    @Test
    public void getAjastinToimii() {
        assertEquals(null, peli.getAjastin());
    }

}
