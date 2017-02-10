/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.peli;

import com.projekti.pacman.logiikka.Liikkuva;
import com.projekti.pacman.logiikka.Monsteri;
import com.projekti.pacman.logiikka.Pacman;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author langjimi
 */
public class Peli {

    private Kentta kentta;
    private int elamat;
    private ArrayList<Monsteri> monsterit;
    private Pacman pacman;

    public Peli(Kentta kentta) {

        this.kentta = kentta;
        this.pacman = kentta.pacmaninLahtokohta();
        this.monsterit = kentta.monsterienLahtokohdat();
        elamat = 3;
    }

    public int getElamat() {
        return elamat;
    }

    public Kentta getKentta() {
        return kentta;
    }

    public Pacman getPacman() {
        return pacman;
    }

    public ArrayList<Monsteri> getMonsterit() {
        return monsterit;
    }

    public void menetaElama() {

        elamat--;

        if (elamat < 0) {

        }

    }

    public void liiku() {

        arvoSuunnat();

        liikkuvaLiikkuu(pacman);

        if (voitto()) {

        }

        for (Monsteri monsteri : monsterit) {
            liikkuvaLiikkuu(monsteri);
        }

    }

    public void liikkuvaLiikkuu(Liikkuva l) {

        int x = l.getxKordinaatti();
        int y = l.getyKordinaatti();

        if (l.isPisteenPaalla()) {
            
           kentta.asetaUusiArvo(x, y, 2); 

        } else {
            
            kentta.asetaUusiArvo(x, y, 1);
            
        }
        
        l.liiku();

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 0) {

            l.setKoordinaatit(x, y);

            kentta.asetaUusiArvo(x, y, l.getKenttaNumero());
            return;
        }

        if (l.onPacman()) {

            tormaakoPacman(l);

        } else {

            tormaakoMonsteri(l);

        }

        kentta.asetaUusiArvo(l.getxKordinaatti(), l.getyKordinaatti(), l.getKenttaNumero());

    }

    public void tormaakoMonsteri(Liikkuva l) {

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 4) {

            menetaElama();

            reset();
        }
    }

    public void tormaakoPacman(Liikkuva l) {

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 3) {

            menetaElama();

            reset();
        }

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 2) {

            pacman.syoPiste();

        }
    }

    public void reset() {

        asetaKaikille1tai2();

        int pisteet = pacman.getPisteet();

        this.pacman = kentta.pacmaninLahtokohta();

        pacman.setPisteet(pisteet);

        this.monsterit = kentta.monsterienLahtokohdat();

        asetaKaikilleOmaArvo();

    }

    public void asetaKaikille1tai2() {

        kentta.asetaUusiArvo(pacman.getxKordinaatti(), pacman.getyKordinaatti(), 1);

        for (Monsteri monsteri : monsterit) {

            if (monsteri.isPisteenPaalla()) {
                kentta.asetaUusiArvo(monsteri.getxKordinaatti(), monsteri.getyKordinaatti(), 2);
                continue;
            }

            kentta.asetaUusiArvo(monsteri.getxKordinaatti(), monsteri.getyKordinaatti(), 1);
        }
    }

    public void asetaKaikilleOmaArvo() {

        kentta.asetaUusiArvo(pacman.getxKordinaatti(), pacman.getyKordinaatti(), pacman.getKenttaNumero());

        for (Monsteri monsteri : monsterit) {
            kentta.asetaUusiArvo(monsteri.getxKordinaatti(), monsteri.getyKordinaatti(), monsteri.getKenttaNumero());
        }
    }

    public void arvoSuunnat() {

        Random random = new Random();

        for (Monsteri monsteri : monsterit) {

            int satunnaismuuttuja = random.nextInt(101);

            if (satunnaismuuttuja < 50) {

                monsteri.arvoSuunta();

            }

        }

    }

    public boolean voitto() {

        if (pacman.getPisteet() >= kentta.getPisteet()) {
            return true;
        }

        return false;
    }
}
