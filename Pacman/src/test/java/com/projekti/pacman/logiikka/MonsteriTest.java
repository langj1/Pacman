package com.projekti.pacman.logiikka;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MonsteriTest {

    Monsteri monsteri;
    ArrayList<Integer> lista;

    @Before
    public void setUp() {
        monsteri = new Monsteri(0, 0, 1);
        lista = new ArrayList<>();
    }

    @Test
    public void arvoSuuntaAsettaaUudenSuunnan() {

        lista.add(1);
        lista.add(2);
        lista.add(3);

        monsteri.arvoSuunta(lista);

        int y = 0;

        String x = monsteri.getSuunta() + "";

        if (x.equals("STOP")) {
            y = 1;
        }

        assertEquals(0, y);
    }

    @Test
    public void arvoSuuntaVasenToimii() {
        lista.add(1);
        monsteri.arvoSuunta(lista);

        assertEquals(1, monsteri.getSuuntaArvo());
    }

    @Test
    public void arvoSuuntaOikeaToimii() {
        lista.add(2);
        monsteri.arvoSuunta(lista);

        assertEquals(2, monsteri.getSuuntaArvo());
    }

    @Test
    public void arvoSuuntaYlosToimii() {
        lista.add(3);
        monsteri.arvoSuunta(lista);

        assertEquals(3, monsteri.getSuuntaArvo());
    }

    @Test
    public void arvoSuuntaAlasToimii() {
        lista.add(4);
        monsteri.arvoSuunta(lista);

        assertEquals(4, monsteri.getSuuntaArvo());
    }

    @Test
    public void getVariToimii() {
        assertEquals(1, monsteri.getVari());
    }

    @Test
    public void setVariToimii() {
        monsteri.setVari(123);
        assertEquals(123, monsteri.getVari());
    }

    @Test
    public void getValkkyyToimii() {
        assertEquals(0, monsteri.getValkkyy());
    }

    @Test
    public void valkkyyToimii() {
        monsteri.setSyotava(true);
        monsteri.setValkkyy(2);
        monsteri.piirra();
        assertEquals(1, monsteri.getValkkyy());
    }

    @Test
    public void valkkyyToimii2() {
        monsteri.setSyotava(true);
        monsteri.setValkkyy(1);
        monsteri.piirra();
        assertEquals(2, monsteri.getValkkyy());
    }

    @Test
    public void valkkyyToimii3() {
        monsteri.setVari(2);
        monsteri.setSyotava(true);
        monsteri.setValkkyy(2);
        monsteri.piirra();
        assertEquals(1, monsteri.getValkkyy());
    }

    @Test
    public void valkkyyToimii4() {
        monsteri.setVari(2);
        monsteri.setSyotava(true);
        monsteri.setValkkyy(1);
        monsteri.piirra();
        assertEquals(2, monsteri.getValkkyy());
    }

    @Test
    public void valkkyyToimii5() {
        monsteri.setVari(3);
        monsteri.setSyotava(true);
        monsteri.setValkkyy(2);
        monsteri.piirra();
        assertEquals(1, monsteri.getValkkyy());
    }

    @Test
    public void valkkyyToimii6() {
        monsteri.setVari(3);
        monsteri.setSyotava(true);
        monsteri.setValkkyy(1);
        monsteri.piirra();
        assertEquals(2, monsteri.getValkkyy());
    }

    @Test
    public void valkkyyToimii7() {
        monsteri.setVari(4);
        monsteri.setSyotava(true);
        monsteri.setValkkyy(2);
        monsteri.piirra();
        assertEquals(1, monsteri.getValkkyy());
    }

    @Test
    public void valkkyyToimii8() {
        monsteri.setVari(4);
        monsteri.setSyotava(true);
        monsteri.setValkkyy(1);
        monsteri.piirra();
        assertEquals(2, monsteri.getValkkyy());
    }
}
