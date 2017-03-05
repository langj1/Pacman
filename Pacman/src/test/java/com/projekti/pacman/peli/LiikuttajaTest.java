/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.peli;

import com.projekti.pacman.Suunta;
import com.projekti.pacman.logiikka.Monsteri;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author langjimi
 */
public class LiikuttajaTest {

    Liikuttaja liikuttaja;
    Peli peli;

    @Before
    public void setUp() {
        peli = new Peli(new Taso1());
        liikuttaja = new Liikuttaja(peli);
    }

    @Test
    public void aseta1tai2KaikilleToimiiPacmanille() {

        liikuttaja.asetaKaikille1tai2();

        assertEquals(1, peli.getKentta().haePisteenArvo(peli.getPacman().getxKordinaatti(), peli.getPacman().getyKordinaatti()));
    }

    @Test
    public void aseta1tai2KaikilleToimiiMonstereille() {

        liikuttaja.asetaKaikille1tai2();

        for (Monsteri m : peli.getMonsterit()) {
            assertEquals(1, peli.getKentta().haePisteenArvo(m.getxKordinaatti(), m.getyKordinaatti()));
        }

    }

    @Test
    public void asetaKaikilleKenttaArvoToimiiPacmanille() {

        liikuttaja.asetaKaikille1tai2();
        liikuttaja.asetaKaikilleOmaArvo();

        assertEquals(4, peli.getKentta().haePisteenArvo(peli.getPacman().getxKordinaatti(), peli.getPacman().getyKordinaatti()));
    }

    @Test
    public void asetaKaikilleKenttaArvoToimiiMonstereille() {

        liikuttaja.asetaKaikille1tai2();
        liikuttaja.asetaKaikilleOmaArvo();

        for (Monsteri m : peli.getMonsterit()) {
            assertEquals(3, peli.getKentta().haePisteenArvo(m.getxKordinaatti(), m.getyKordinaatti()));
        }

    }

    @Test
    public void onkoPisteenPaallaToimiiJosFalse() {

        liikuttaja.onkoPisteenPaalla(0, 0, peli.getMonsterit().get(0));
        assertEquals(1, peli.getKentta().haePisteenArvo(0, 0));
    }

    @Test
    public void onkoPisteenPaallaToimiiJosTrue() {

        peli.getMonsterit().get(0).setPisteenPaalla(true);
        liikuttaja.onkoPisteenPaalla(0, 0, peli.getMonsterit().get(0));
        assertEquals(2, peli.getKentta().haePisteenArvo(0, 0));
    }

    @Test
    public void liikuLiikuttaaPacmania() {

        int x = peli.getPacman().getxKordinaatti();
        peli.getPacman().setSuunta(Suunta.VASEN);
        liikuttaja.liiku();

        assertEquals(x - 1, peli.getPacman().getxKordinaatti());
    }

    @Test
    public void liikuEiLiikutaPacmaniaSeinaan() {

        int x = peli.getPacman().getxKordinaatti();
        peli.getPacman().setSuunta(Suunta.OIKEA);
        liikuttaja.liiku();

        assertEquals(x, peli.getPacman().getxKordinaatti());
    }
}
