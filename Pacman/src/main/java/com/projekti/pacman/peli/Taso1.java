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
public class Taso1 extends Kentta {

    private ArrayList<int[]> koordinaatit;

    /**
     * Matriisi kuvaa tasoa. 0 = muuri, 1 = tyhjä ruutu, 2 = ruutu, jossa piste,
     * 3 = ruutu, jossa monsteri, 4 = ruutu, jossa Pacman.
     */
    public Taso1() {

        int[][] taso = new int[][]{{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},
            {0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0},
            {0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0},
            {0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0},
            {0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0},
            {0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0},
            {0, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 2, 2, 2, 2, 2, 2, 2, 0},
            {0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0},
            {0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0},
            {0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0},
            {0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0},
            {0, 2, 0, 0, 2, 0, 0, 2, 0, 0, 0, 0, 2, 0, 0, 2, 0, 0, 2, 0},
            {0, 4, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};

        setKentta(taso);

        setPisteet(laskePisteet());

        this.koordinaatit = laskeKoordinaatit();

    }

    /**
     * Laskee kaikkien matriisissa olevien pisteiden määrän
     *
     * @return Pisteiden summa
     */
    public int laskePisteet() {

        int pisteet = 0;

        for (int i = 0; i < kentta[0].length; i++) {
            for (int j = 0; j < kentta.length; j++) {

                if (kentta[j][i] == 2) {
                    pisteet++;
                }
            }
        }

        return pisteet;
    }

    /**
     * Laskee jokaisen Liikkuvan koordinaatit ja lisää ne listaan
     *
     * @return Palauttaa listan koordinaatteja
     */
    public ArrayList<int[]> laskeKoordinaatit() {

        ArrayList<int[]> lista = new ArrayList<>();

        lista.add(pacmaninLahtokohta().getKoordinaatit());

        for (Monsteri monsteri : monsterienLahtokohdat()) {

            lista.add(monsteri.getKoordinaatit());
        }

        return lista;
    }

    @Override
    public ArrayList<int[]> getKoordinaatit() {
        return koordinaatit;
    }
}
