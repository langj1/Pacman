/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.peli;

import com.projekti.pacman.logiikka.Monsteri;
import com.projekti.pacman.logiikka.Pacman;
import java.util.ArrayList;

/**
 * Yksi mahdollisista tasoista. Perii luokan Kentta.
 */
public class Taso2 extends Kentta {

    /**
     * Matriisi kuvaa tasoa. 0 = muuri, 1 = tyhjä ruutu, 2 = ruutu, jossa piste,
     * 3 = ruutu, jossa monsteri, 4 = ruutu, jossa Pacman, 5 = power up.
     */
    public Taso2() {

        int[][] taso = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 5, 2, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 2, 5, 0},
            {0, 2, 0, 2, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 2, 0, 2, 0},
            {0, 2, 2, 2, 2, 2, 0, 0, 2, 0, 0, 2, 0, 0, 2, 2, 2, 2, 2, 0},
            {0, 2, 0, 2, 0, 2, 2, 2, 2, 0, 0, 2, 2, 2, 2, 0, 2, 0, 2, 0},
            {0, 2, 0, 2, 2, 2, 0, 0, 2, 0, 0, 2, 0, 0, 2, 2, 2, 0, 2, 0},
            {0, 2, 0, 0, 0, 2, 0, 0, 2, 2, 2, 2, 0, 0, 2, 0, 0, 0, 2, 0},
            {0, 2, 0, 0, 0, 2, 0, 2, 2, 0, 0, 2, 2, 0, 2, 0, 0, 0, 2, 0},
            {0, 2, 0, 0, 2, 2, 2, 2, 0, 0, 0, 0, 2, 2, 2, 2, 0, 0, 2, 0},
            {0, 2, 2, 2, 2, 0, 0, 2, 3, 3, 3, 3, 2, 0, 0, 2, 2, 2, 2, 0},
            {0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0},
            {0, 2, 0, 2, 2, 2, 2, 2, 2, 0, 0, 2, 2, 2, 2, 2, 2, 0, 2, 0},
            {0, 2, 0, 2, 0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, 2, 0, 2, 0},
            {0, 2, 0, 2, 0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, 2, 0, 2, 0},
            {0, 2, 2, 2, 0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0, 2, 2, 2, 0},
            {0, 2, 0, 0, 0, 2, 0, 2, 2, 0, 0, 2, 2, 0, 2, 0, 0, 0, 2, 0},
            {0, 2, 2, 2, 2, 2, 2, 2, 0, 0, 0, 0, 2, 2, 4, 2, 2, 2, 2, 0},
            {0, 2, 0, 2, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 2, 0, 2, 0},
            {0, 5, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
        

        setKentta(taso);

        setPisteet(laskePisteet());

        setKoordinaatit(laskeKoordinaatit());

    }

}
