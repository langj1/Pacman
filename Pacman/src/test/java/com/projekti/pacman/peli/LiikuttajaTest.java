package com.projekti.pacman.peli;

import com.projekti.pacman.tasot.Taso1;
import com.projekti.pacman.Suunta;
import com.projekti.pacman.logiikka.Monsteri;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

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
    public void aseta1tai2KaikilleToimiiJosPisteenPaalla() {

        peli.getMonsterit().get(0).setPisteenPaalla(true);
        liikuttaja.asetaKaikille1tai2();
        assertEquals(2, peli.getKentta().haePisteenArvo(peli.getMonsterit().get(0).getxKordinaatti(), peli.getMonsterit().get(0).getyKordinaatti()));
        assertFalse(peli.getMonsterit().get(0).isPisteenPaalla());
    }

    @Test
    public void aseta1tai2KaikilleToimiiJosPowerupinPaalla() {

        peli.getMonsterit().get(0).setPowerUpinPaalla(true);
        peli.getMonsterit().get(0).setPisteenPaalla(false);
        liikuttaja.asetaKaikille1tai2();
        assertEquals(5, peli.getKentta().haePisteenArvo(peli.getMonsterit().get(0).getxKordinaatti(), peli.getMonsterit().get(0).getyKordinaatti()));
        assertFalse(peli.getMonsterit().get(0).isPowerUpinPaalla());
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
    public void onkoPisteenPaallaToimiiJosPowerUpinPaalla() {

        Monsteri m = new Monsteri(0, 0, 1);
        m.setPowerUpinPaalla(true);
        liikuttaja.onkoPisteenPaalla(0, 0, m);
        assertEquals(5, peli.getKentta().haePisteenArvo(1, 1));
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

    @Test
    public void josPacmanTormaaEiLiikutaMonstereita() {
        peli.getKentta().asetaUusiArvo(peli.getPacman().getxKordinaatti(), peli.getPacman().getyKordinaatti() + 1, 3);
        peli.getPacman().setSuunta(Suunta.ALAS);
        liikuttaja.liiku();
        assertEquals(0, peli.getPacman().getPisteet());
    }

    @Test
    public void pisteetKasvaaKunLiikkuu() {
        peli.getPacman().setSuunta(Suunta.ALAS);
        liikuttaja.liiku();
        assertEquals(1, peli.getPacman().getPisteet());
    }

    @Test
    public void pisteetEiVaheneKunLiikkuu() {
        peli.getPacman().setPisteet(13);
        peli.getPacman().setSuunta(Suunta.ALAS);
        liikuttaja.liiku();
        assertEquals(13, peli.getPacman().getPisteet());
    }

    @Test
    public void liikkuvaLiikkuKutsuuOnkoPisteenPaalla() {
        int[] k = peli.getMonsterit().get(0).getKoordinaatit();
        liikuttaja.liikkuvaLiikkuu(peli.getMonsterit().get(0));
        boolean testi = false;
        if (peli.getKentta().haePisteenArvo(k[1], k[0]) == 1 || peli.getKentta().haePisteenArvo(k[1], k[0]) == 3) {
            testi = true;
        }
        assertTrue(testi);
    }

    @Test
    public void liikkuvaLiikkuuPalauttaaFalseJosTormaaSeinaan() {
        peli.getPacman().setSuunta(Suunta.OIKEA);
        assertFalse(liikuttaja.liikkuvaLiikkuu(peli.getPacman()));
    }

    @Test
    public void liikkuvaLiikkuuPalauttaaFalseJosEiTormaa() {
        peli.getPacman().setSuunta(Suunta.ALAS);
        assertFalse(liikuttaja.liikkuvaLiikkuu(peli.getPacman()));
    }

    @Test
    public void liikkuvaLiikkuuLiikuttaaJosEiTormaa() {
        int y = peli.getPacman().getyKordinaatti();
        peli.getPacman().setSuunta(Suunta.ALAS);
        liikuttaja.liikkuvaLiikkuu(peli.getPacman());
        assertEquals(y, peli.getPacman().getyKordinaatti() - 1);
    }

    @Test
    public void liikkuvaLiikkuuEiLiikutaJosTormaaSeinaan() {
        int x = peli.getPacman().getxKordinaatti();
        peli.getPacman().setSuunta(Suunta.OIKEA);
        liikuttaja.liikkuvaLiikkuu(peli.getPacman());
        assertEquals(x, peli.getPacman().getxKordinaatti());
    }

    @Test
    public void liikkuvaLiikkuuPalauttaaTrueJosMonsteriTormaaPacmaniin() {

        Monsteri m = new Monsteri(peli.getPacman().getxKordinaatti(), peli.getPacman().getyKordinaatti() - 1, 1);
        m.setSuunta(Suunta.ALAS);
        assertTrue(liikuttaja.liikkuvaLiikkuu(m));
    }

    @Test
    public void asetaLiikkuvalleOmaArvoToimii() {

        Monsteri m = new Monsteri(1, 1, 1);
        liikuttaja.asetaLiikkuvalleOmaArvo(m);
        assertEquals(3, peli.getKentta().haePisteenArvo(1, 1));
    }
}
