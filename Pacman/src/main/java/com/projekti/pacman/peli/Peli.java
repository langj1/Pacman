package com.projekti.pacman.peli;

import com.projekti.pacman.Suunta;
import com.projekti.pacman.gui.Piirtoalusta;
import com.projekti.pacman.logiikka.Liikkuva;
import com.projekti.pacman.logiikka.Monsteri;
import com.projekti.pacman.logiikka.Pacman;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Timer;

/**
 * Luokka, joka hallitsee pelin kulkua ja yhdistää kaikki muut logiikan luokat
 * sekä käyttöliittymän.
 */
public class Peli extends Timer implements ActionListener {

    private Kentta kentta;
    private int elamat;
    private ArrayList<Monsteri> monsterit;
    private Pacman pacman;
    private Piirtoalusta alusta;
    private Tormaako tormaako;
    private Liikuttaja liikuttaja;
    private PowerUpAjastin ajastin;

    /**
     * Luo uuden pelin.
     *
     * @param kentta Määrittää mitä tasoa peli käyttää.
     */
    public Peli(Kentta kentta) {

        super(1000, null);

        this.kentta = kentta;
        this.pacman = kentta.pacmaninLahtokohta();
        this.monsterit = kentta.monsterienLahtokohdat();
        this.tormaako = new Tormaako(this.kentta, this);
        this.ajastin = null;
        this.liikuttaja = new Liikuttaja(this);
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

    public Tormaako getTormaako() {
        return tormaako;
    }

    public Liikuttaja getLiikuttaja() {
        return liikuttaja;
    }

    /**
     * Vähentää yhden elämän, jos elämät loppuu peli päättyy.
     *
     * @return palauttaa true, jos elämät loppuu
     */
    public boolean havio() {

        if (elamat < 1) {
            return true;
        }
        return false;
    }

    /**
     * Vähentää yhden elämän.
     */
    public void menetaElama() {
        elamat--;
    }

    /**
     * Resetoi pelin alkuperäisasetelmaan paitsi pisteitä ei palauteta.
     */
    public void reset() {

        liikuttaja.asetaKaikille1tai2();
        int pisteet = pacman.getPisteet();
        pacman.setKoordinaatit(kentta.getKoordinaatit().get(0)[1], kentta.getKoordinaatit().get(0)[0]);
        pacman.setPisteet(pisteet);
        pacman.setSuunta(Suunta.STOP);

        for (int i = 0; i < 4; i++) {
            monsterit.get(i).setKoordinaatit(kentta.getKoordinaatit().get(i + 1)[1], kentta.getKoordinaatit().get(i + 1)[0]);
        }

        liikuttaja.asetaKaikilleOmaArvo();
        monsteritNormaaleiksi();
        restart();

    }

    /**
     * Katsoo onko Pacmanillä tarpeeksi pisteitä voittoon.
     *
     * @return True jos on tarpeeksi muulloin false.
     */
    public boolean voitto() {

        boolean onkoMonsteriPisteenPaalla = false;
        for (Monsteri monsteri : monsterit) {
            if (monsteri.isPisteenPaalla()) {
                onkoMonsteriPisteenPaalla = true;
            }
        }
        if (kentta.laskePisteet() == 0 && !onkoMonsteriPisteenPaalla) {
            return true;
        }
        return false;
    }

    /**
     * Pyörittää peliä.
     *
     * @param e ei käytetä
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        Liikuttaja l = new Liikuttaja(this);
        l.liiku();

        alusta.paivita();

        setDelay(100);
    }

    /**
     * Tekee kaikista monstereista syötäviä.
     */
    public void monsteritSyotaviksi() {
        for (Monsteri monsteri : monsterit) {
            monsteri.setSyotava(true);
        }
        pacman.setSyotava(true);
    }

    /**
     * Tekee kaikista Monstereista normaaleja.
     */
    public void monsteritNormaaleiksi() {
        for (Monsteri monsteri : monsterit) {
            monsteri.setSyotava(false);
            monsteri.setValkkyy(0);
        }
        pacman.setSyotava(false);
    }

    /**
     * Tekee kaikista monstereista välkkyviä.
     */
    public void monsteritValkkyviksi() {
        for (Monsteri monsteri : monsterit) {
            monsteri.setValkkyy(1);
        }
    }

    public PowerUpAjastin getAjastin() {
        return ajastin;
    }

    /**
     * Asettaa uuden ajastimen ja nollaa vanhan.
     *
     * @param a Ajastin, joka asetetaan.
     */
    public void setAjastin(PowerUpAjastin a) {
        if (ajastin != null) {
            ajastin.cancel();
        }
        this.ajastin = a;
    }

}
