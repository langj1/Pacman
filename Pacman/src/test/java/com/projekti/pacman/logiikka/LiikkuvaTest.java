package com.projekti.pacman.logiikka;

import com.projekti.pacman.Suunta;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class LiikkuvaTest {

    Liikkuva liikkuva;

    @Before
    public void setUp() {
        liikkuva = new Pacman(12, 324);
    }

    @Test
    public void konstruktoriAsettaaOikeanXArvon() {;

        assertEquals(12, liikkuva.getxKordinaatti());
    }

    @Test
    public void konstruktoriAsettaaOikeanYArvon() {

        assertEquals(324, liikkuva.getyKordinaatti());
    }

    @Test
    public void liikuToimiiJosSuuntaOikea() {

        liikkuva.setSuunta(Suunta.OIKEA);
        liikkuva.liiku();

        assertEquals(13, liikkuva.getxKordinaatti());
    }

    @Test
    public void liikuToimiiJosSuuntaVasen() {

        liikkuva.setSuunta(Suunta.VASEN);
        liikkuva.liiku();

        assertEquals(11, liikkuva.getxKordinaatti());
    }

    @Test
    public void liikuToimiiJosSuuntaYlos() {

        liikkuva.setSuunta(Suunta.YLOS);
        liikkuva.liiku();

        assertEquals(323, liikkuva.getyKordinaatti());
    }

    @Test
    public void liikuToimiiJosSuuntaAlas() {

        liikkuva.setSuunta(Suunta.ALAS);
        liikkuva.liiku();

        assertEquals(325, liikkuva.getyKordinaatti());
    }

    @Test
    public void liikuToimiiJosSuuntaStop() {

        liikkuva.setSuunta(Suunta.STOP);
        liikkuva.liiku();

        assertEquals(324, liikkuva.getyKordinaatti());
        assertEquals(12, liikkuva.getxKordinaatti());
    }

    @Test
    public void getKoordinaatitToimii() {

        int[] taulu = liikkuva.getKoordinaatit();

        assertEquals(324, taulu[0]);
        assertEquals(12, taulu[1]);

    }

    @Test
    public void isPisteenPaallaToimii() {
        assertFalse(liikkuva.isPisteenPaalla());
    }

    @Test
    public void setPisteenPaallaToimii() {

        liikkuva.setPisteenPaalla(true);

        assertTrue(liikkuva.isPisteenPaalla());
    }

    @Test
    public void getSuuntaToimii() {

        int x = 0;
        if (liikkuva.getSuunta() == null) {
            x++;
        }

        assertEquals(0, x);
    }

    @Test
    public void onPacmanToimiiJosEiPacman() {
        Monsteri m = new Monsteri(1, 2, 3);
        assertFalse(m.onPacman());
    }

    @Test
    public void onPacmanToimiiJosPacman() {
        assertTrue(liikkuva.onPacman());
    }
}
