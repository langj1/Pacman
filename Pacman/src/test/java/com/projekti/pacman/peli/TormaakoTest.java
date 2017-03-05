package com.projekti.pacman.peli;

import com.projekti.pacman.logiikka.Monsteri;
import com.projekti.pacman.logiikka.Pacman;
import com.projekti.pacman.tasot.Taso1;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

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
    public void tormaakoMonsteriToimiiKunEiTormaaPisteeseen() {

        peli.getKentta().asetaUusiArvo(peli.getMonsterit().get(0).getxKordinaatti(), peli.getMonsterit().get(0).getyKordinaatti(), 1);
        tormaako.tormaakoMonsteri(peli.getMonsterit().get(0));

        assertEquals(3, peli.getElamat());
        assertFalse(peli.getMonsterit().get(0).isPisteenPaalla());
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
    public void tormaakoPacmanToimiiKunTormaaPowerUppiin() {
        peli.getKentta().asetaUusiArvo(peli.getPacman().getxKordinaatti(), peli.getPacman().getyKordinaatti(), 5);
        tormaako.tormaakoPacman(peli.getPacman());
        assertTrue(peli.getPacman().isSyotava());
    }

    @Test
    public void tormaakoMonsteriToimiiKunTormaaPowerUppiin() {
        peli.getKentta().asetaUusiArvo(peli.getMonsterit().get(0).getxKordinaatti(), peli.getMonsterit().get(0).getyKordinaatti(), 5);
        tormaako.tormaakoPacman(peli.getMonsterit().get(0));
        assertTrue(peli.getMonsterit().get(0).isPowerUpinPaalla());
    }

    @Test
    public void tormaakoPowerUppiintoimiiPacmanille() {
        Pacman p = peli.getPacman();
        peli.monsteritValkkyviksi();
        peli.getKentta().asetaUusiArvo(p.getxKordinaatti(), p.getyKordinaatti(), 5);
        tormaako.tormaakoPowerUppiin(p);

        for (Monsteri m : peli.getMonsterit()) {
            assertEquals(0, m.getValkkyy());
            assertTrue(m.isSyotava());
        }
        assertTrue(p.isSyotava());
    }

    @Test
    public void tormaakoPowerUppiintoimiiMonsterille() {

        Monsteri m = peli.getMonsterit().get(0);
        peli.getKentta().asetaUusiArvo(m.getxKordinaatti(), m.getyKordinaatti(), 5);
        tormaako.tormaakoPowerUppiin(m);
        assertTrue(m.isPowerUpinPaalla());
    }

    @Test
    public void tormaakoPowerUppiintoimiiMonsterille2() {

        Monsteri m = peli.getMonsterit().get(0);
        peli.getKentta().asetaUusiArvo(m.getxKordinaatti(), m.getyKordinaatti(), 2);
        tormaako.tormaakoPowerUppiin(m);
        assertFalse(m.isPowerUpinPaalla());
    }
    
    @Test
    public void tormaaMonsteriinKunPowerUpToimii() {
        Monsteri m = peli.getMonsterit().get(0);
        m.setPisteenPaalla(true);
        Pacman p = peli.getPacman();
        m.setKoordinaatit(p.getxKordinaatti(), p.getyKordinaatti());
        tormaako.tormaaMonsteriinKunPowerUp(p);
        
        assertFalse(m.isPisteenPaalla());
        assertEquals(7,m.getxKordinaatti());
        assertFalse(m.isSyotava());
        assertEquals(10,p.getExtraPisteet());
    }
}
