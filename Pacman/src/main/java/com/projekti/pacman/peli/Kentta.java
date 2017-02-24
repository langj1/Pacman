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
 * Luokka luo yleisen pohjan pelin tasoille.
 */
public abstract class Kentta {

    int[][] kentta;
    private int pisteet;
    private ArrayList<int[]> koordinaatit;

    /**
     * Asettaa pisteet oletuksena nollaan.
     */
    public Kentta() {
        kentta = new int[111][111];
        pisteet = 0;
    }

    public void setKentta(int[][] kentta) {
        this.kentta = kentta;
    }

    public int[][] getKentta() {
        return kentta;
    }

    /**
     * Asettaa uuden arvon annettuihin koordinaatteihin.
     *
     * @param x x koordinaatti
     * @param y y koordinaatti
     * @param uusiArvo matriisiin sijoitettava uusi arvo
     */
    public void asetaUusiArvo(int x, int y, int uusiArvo) {

        kentta[x][y] = uusiArvo;
    }

    /**
     * Kertoo koordinaateissa olevan arvon.
     *
     * @param x x koordinaatti
     * @param y y koordinaatti
     * @return palauttaa koordinaateissa olevan arvon matriisista
     */
    public int haePisteenArvo(int x, int y) {
        return kentta[x][y];
    }

    public int getPisteet() {

        return pisteet;
    }

    public void setPisteet(int pisteet) {
        this.pisteet = pisteet;
    }

    /**
     * Etsii matriisista Pacmanin koordinaatit.
     *
     * @return Luo uuden Pacmanin koordinaateilla
     */
    public Pacman pacmaninLahtokohta() {

        for (int i = 0; i < kentta[0].length; i++) {
            for (int j = 0; j < kentta.length; j++) {

                if (kentta[j][i] == 4) {
                    return new Pacman(j, i);
                }
            }
        }

        return null;
    }

    /**
     * Etsii matriisista monsterien koordinaatit.
     *
     * @return Luo neljä monsteria koordinaateilla
     */
    public ArrayList<Monsteri> monsterienLahtokohdat() {

        ArrayList<Monsteri> monsterit = new ArrayList<>();

        int vari = 1;

        for (int i = 0; i < kentta[0].length; i++) {
            for (int j = 0; j < kentta.length; j++) {

                if (kentta[j][i] == 3) {
                    monsterit.add(new Monsteri(j, i, vari));
                    vari++;
                }
            }
        }

        return monsterit;
    }

    public int getLeveys() {
        return kentta.length;
    }

    public int getPituus() {
        return kentta[0].length;
    }

    /**
     * Laskee jokaisen Liikkuvan koordinaatit ja lisää ne listaan.
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

    /**
     * Jätetään tasojen täsmennettäväksi.
     *
     * @return palauttaa jokaisen Liikkuvan koordinaatit
     */
    public ArrayList<int[]> getKoordinaatit() {
        return koordinaatit;
    }

    public void setKoordinaatit(ArrayList<int[]> koordinaatit) {
        this.koordinaatit = koordinaatit;
    }
    
    public int[] tietynMonsterinLahto(int vari){
        return koordinaatit.get(vari);
    }

    /**
     * Laskee kaikkien matriisissa olevien pisteiden määrän.
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
}
