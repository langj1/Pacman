/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.peli;

import com.projekti.pacman.logiikka.Liikkuva;
import com.projekti.pacman.logiikka.Monsteri;

/**
 * Luokka tarkistaa Pacmanin ja Monsterien mahdolliset tormaykset toistensa tai
 * pisteiden kanssa.
 *
 * @author langjimi
 */
public class Tormaako {

    private Kentta kentta;
    private Peli peli;

    /**
     * Asettaa oliolle Kentän ja Pelin.
     *
     * @param kentta
     * @param peli
     */
    public Tormaako(Kentta kentta, Peli peli) {
        this.kentta = kentta;
        this.peli = peli;
    }

    /**
     * Katsoo törmääkö Pacman Monsteriin, jolloin menetetään elämä ja
     * resetoidaan peli. Katsoo myös törmätäänkö pisteeseen, jolloin piste
     * poistetaan ja Pacmanille lisätään piste.
     *
     * @param l Pacman, joka mahdollisesti törmää
     * @return palautta true, jos peli resetoidaan
     */
    public boolean tormaakoPacman(Liikkuva l) {

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 3 && l.isSyotava()) {

            for (Monsteri monsteri : peli.getMonsterit()) {
                if (monsteri.getxKordinaatti() == l.getxKordinaatti() && monsteri.getyKordinaatti() == l.getyKordinaatti()) {
                    monsteri.setKoordinaatit(kentta.tietynMonsterinLahto(monsteri.getVari())[1], kentta.tietynMonsterinLahto(monsteri.getVari())[0]);
                    peli.asetaLiikkuvalleOmaArvo(monsteri);

                    if (monsteri.isPisteenPaalla()) {
                        monsteri.setPisteenPaalla(false);
                    }
                    monsteri.setSyotava(false);
                    peli.getPacman().setPisteet(peli.getPacman().getPisteet() + 100);
                }

            }

        } else if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 3) {

            peli.menetaElama();

            peli.reset();

            return true;
        }

//        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 2) {
//
//            peli.getPacman().syoPiste();
//
//        }

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 5) {

            peli.monsteritSyotaviksi();
            peli.setAjastin(new PowerUpAjastin(peli));

        }
        return false;
    }

    /**
     * Katsoo törmääkö monsteri Pacmaniin, jolloin menetetään elämä ja
     * resetoidaan peli. Katsoo myös törmääkö Monsteri pisteeseen, jotta se
     * voidaan laitta takaisin.
     *
     * @param l Monsteri, joka mahdollisesti törmää
     * @return palautta true, jos peli resetoidaan
     */
    public boolean tormaakoMonsteri(Liikkuva l) {

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 4 && l.isSyotava()) {

            for (Monsteri monsteri : peli.getMonsterit()) {
                if (monsteri.getxKordinaatti() == l.getxKordinaatti() && monsteri.getyKordinaatti() == l.getyKordinaatti()) {
                    monsteri.setKoordinaatit(kentta.tietynMonsterinLahto(monsteri.getVari())[1], kentta.tietynMonsterinLahto(monsteri.getVari())[0]);
                    peli.asetaLiikkuvalleOmaArvo(monsteri);

                    if (monsteri.isPisteenPaalla()) {
                        monsteri.setPisteenPaalla(false);
                    }
                    monsteri.setSyotava(false);
                    peli.getPacman().setPisteet(peli.getPacman().getPisteet() + 100);
                }

            }

        } else if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 4) {

            peli.menetaElama();

            peli.reset();

            return true;
        }

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 2) {

            l.setPisteenPaalla(true);

        } else {

            l.setPisteenPaalla(false);

        }

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 5) {

            l.setPowerUpinPaalla(true);

        } else {

            l.setPowerUpinPaalla(false);

        }

        return false;
    }
}
