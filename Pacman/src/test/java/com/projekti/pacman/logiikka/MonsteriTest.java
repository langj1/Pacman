/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.logiikka;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author langjimi
 */
public class MonsteriTest {

    Monsteri monsteri;
    ArrayList<Integer> lista;

    @Before
    public void setUp() {
        monsteri = new Monsteri(0, 0, 0);
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

}
