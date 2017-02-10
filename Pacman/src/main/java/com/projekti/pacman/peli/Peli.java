/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.peli;

import com.projekti.pacman.Suunta;
import com.projekti.pacman.gui.Piirtoalusta;
import com.projekti.pacman.logiikka.Liikkuva;
import com.projekti.pacman.logiikka.Monsteri;
import com.projekti.pacman.logiikka.Pacman;
import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.Timer;

/**
 *
 * @author langjimi
 */
public class Peli extends Timer implements ActionListener {

    private Kentta kentta;
    private int elamat;
    private ArrayList<Monsteri> monsterit;
    private Pacman pacman;
    private Piirtoalusta alusta;

    public Peli(Kentta kentta) {

        super(1000, null);

        this.kentta = kentta;
        this.pacman = kentta.pacmaninLahtokohta();
        this.monsterit = kentta.monsterienLahtokohdat();
        elamat = 3;

        addActionListener(this);
        setInitialDelay(2000);

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

    public void setAlusta(Piirtoalusta alusta) {
        this.alusta = alusta;
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

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 0 || kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 3 && !l.onPacman()) {

            l.setKoordinaatit(x, y);

            kentta.asetaUusiArvo(x, y, l.getKenttaNumero());
            return;
        }

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 2 && !l.onPacman()) {

            l.setPisteenPaalla(true);

        } else if (!l.onPacman()) {

            l.setPisteenPaalla(false);

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

        pacman.setKoordinaatit(kentta.getKoordinaatit().get(0)[1], kentta.getKoordinaatit().get(0)[0]);

        pacman.setPisteet(pisteet);

        pacman.setSuunta(Suunta.STOP);

        for (int i = 0; i < 4; i++) {
            monsterit.get(i).setKoordinaatit(kentta.getKoordinaatit().get(i + 1)[1], kentta.getKoordinaatit().get(i + 1)[0]);
        }

        asetaKaikilleOmaArvo();

        restart();

    }

    public void asetaKaikille1tai2() {

        kentta.asetaUusiArvo(pacman.getxKordinaatti(), pacman.getyKordinaatti(), 1);

        for (Monsteri monsteri : monsterit) {

            if (monsteri.isPisteenPaalla()) {
                kentta.asetaUusiArvo(monsteri.getxKordinaatti(), monsteri.getyKordinaatti(), 2);
                monsteri.setPisteenPaalla(false);
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

    @Override
    public void actionPerformed(ActionEvent e) {

        liiku();

        alusta.paivita();

        setDelay(300);
    }
}
