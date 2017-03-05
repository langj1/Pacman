/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.peli;

import com.projekti.pacman.Suunta;
import com.projekti.pacman.logiikka.Liikkuva;
import com.projekti.pacman.logiikka.Monsteri;
import com.projekti.pacman.logiikka.Pacman;
import java.util.ArrayList;

/**
 * Luokka, joka liikuttaa monstereita ja pacmania.
 *
 */
public class Liikuttaja {

    private Peli peli;
    private Kentta kentta;
    private Pacman pacman;
    private ArrayList<Monsteri> monsterit;
    private Tormaako tormaako;

    /**
     * Luo uuden liikuttajan saamansa pelin perusteella.
     *
     * @param peli Peli, jonka olioita liikutetaan.
     */
    public Liikuttaja(Peli peli) {
        this.peli = peli;
        this.kentta = peli.getKentta();
        this.monsterit = peli.getMonsterit();
        this.pacman = peli.getPacman();
        this.tormaako = peli.getTormaako();
    }

    /**
     * Ensiksi arvoo monstereille uudet suunnat, jonka jälkeen liikuttaa
     * Pacmania. Jos Pacman saavuttaa tason voittoon vaadittavan pistemäärän
     * peli päättyy. Muussa tapauksessa monsterit liikkuu seuraavaksi.
     */
    public void liiku() {

        arvoSuunnat();
        if (liikkuvaLiikkuu(pacman)) {
            return;
        }
        for (Monsteri monsteri : monsterit) {
            if (liikkuvaLiikkuu(monsteri)) {
                break;
            }
        }
        int pisteet = kentta.getPisteet() - kentta.laskePisteetOttaenMonsteritHuomioon(monsterit);

        if (pisteet > pacman.getPisteet() - pacman.getExtraPisteet()) {
            pacman.setPisteet(pisteet + pacman.getExtraPisteet());
        }
    }

    /**
     * Ottaa muistiin Liikkuvan alkuperäiset koordinaatit. Sitten asettaa
     * koordinaatteihin joista liikutaan pois joko pisteen tai tyhjän ruudun.
     * Seuraavaksi liikutetaan Liikkuvaa. Sitten katsotaan onko Liikkuva
     * liikkumassa muuriin, jolloin Liikkuva palaa alkuperäiseen ruutuun. Sitten
     * katsotaan törmätäänkö pisteeseen, Pacmaniin tai Monsteriin. Lopulta
     * asetetaan Liikkuvan oma arvo uuteen ruutuun.
     *
     * @param l Pacman tai Monsteri, jota liikutetaan
     * @return palauttaa true, jos peli resetoidaan
     */
    public boolean liikkuvaLiikkuu(Liikkuva l) {

        int x = l.getxKordinaatti();
        int y = l.getyKordinaatti();
        onkoPisteenPaalla(x, y, l);
        l.liiku();

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 0 || kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 3 && !l.onPacman()) {

            l.setKoordinaatit(x, y);

            kentta.asetaUusiArvo(x, y, l.getKenttaNumero());
            return false;
        }

        if (l.onPacman()) {

            if (tormaako.tormaakoPacman(l)) {
                return true;
            }
        } else {

            if (tormaako.tormaakoMonsteri(l)) {
                return true;
            }
        }

        kentta.asetaUusiArvo(l.getxKordinaatti(), l.getyKordinaatti(), l.getKenttaNumero());
        return false;
    }

    /**
     * Määrittää, mikä arvo laitetaan lähtöruutuun.
     *
     * @param x x koordinaatti
     * @param y y koordinaatti
     * @param l Liikkuva
     */
    public void onkoPisteenPaalla(int x, int y, Liikkuva l) {

        if (l.isPisteenPaalla()) {
            kentta.asetaUusiArvo(x, y, 2);
        } else if (l.isPowerUpinPaalla()) {
            kentta.asetaUusiArvo(x, y, 5);
        } else {
            kentta.asetaUusiArvo(x, y, 1);
        }
    }

    /**
     * Asettaa pelin Monsterien ja Pacmanien koordinaatteihin tyhjän ruudun tai
     * pisteen tai powerupin.
     */
    public void asetaKaikille1tai2() {

        kentta.asetaUusiArvo(pacman.getxKordinaatti(), pacman.getyKordinaatti(), 1);

        for (Monsteri monsteri : monsterit) {

            if (monsteri.isPisteenPaalla()) {
                kentta.asetaUusiArvo(monsteri.getxKordinaatti(), monsteri.getyKordinaatti(), 2);
                monsteri.setPisteenPaalla(false);
                continue;
            }

            if (monsteri.isPowerUpinPaalla()) {
                kentta.asetaUusiArvo(monsteri.getxKordinaatti(), monsteri.getyKordinaatti(), 5);
                monsteri.setPowerUpinPaalla(false);
                continue;
            }

            kentta.asetaUusiArvo(monsteri.getxKordinaatti(), monsteri.getyKordinaatti(), 1);
        }
    }

    /**
     * Asettaa pelin Monsterien ja Pacmanin koordinaatteihin heitä kuvaavat
     * arvot.
     */
    public void asetaKaikilleOmaArvo() {

        kentta.asetaUusiArvo(pacman.getxKordinaatti(), pacman.getyKordinaatti(), pacman.getKenttaNumero());

        for (Monsteri monsteri : monsterit) {
            kentta.asetaUusiArvo(monsteri.getxKordinaatti(), monsteri.getyKordinaatti(), monsteri.getKenttaNumero());
        }
    }

    /**
     * Asettaa yhdelle Liikkuvalle oikean kenttäarvon kenttään.
     *
     * @param l Liikkuva, jolle arvo asetetaan.
     */
    public void asetaLiikkuvalleOmaArvo(Liikkuva l) {
        kentta.asetaUusiArvo(l.getxKordinaatti(), l.getyKordinaatti(), l.getKenttaNumero());
    }

    /**
     * Arvoo Monstereille uudet suunnat. Tallentaa listaan kaikki suunnat jotka
     * ei johda seinään.
     *
     * @see com.projekti.pacman.logiikka.Monsteri#arvoSuunta()
     */
    public void arvoSuunnat() {

        for (Monsteri monsteri : monsterit) {

            ArrayList<Integer> suunnat = new ArrayList<>();
            int x = monsteri.getxKordinaatti();
            int y = monsteri.getyKordinaatti();

            if (kentta.haePisteenArvo(x - 1, y) != 0) {
                suunnat.add(1);
            }
            if (kentta.haePisteenArvo(x + 1, y) != 0) {
                suunnat.add(2);
            }
            if (kentta.haePisteenArvo(x, y - 1) != 0) {
                suunnat.add(3);
            }
            if (kentta.haePisteenArvo(x, y + 1) != 0) {
                suunnat.add(4);
            }
            monsteri.arvoSuunta(suunnat);
        }
    }
}
