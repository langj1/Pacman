package com.projekti.pacman.logiikka;

import com.projekti.pacman.Suunta;
import com.projekti.pacman.peli.Peli;
import java.awt.image.BufferedImage;

/**
 * Luokka luo pohjan, jonka Pacman ja monsterit perii.
 */
public abstract class Liikkuva {

    Suunta suunta;
    private int xKordinaatti;
    private int yKordinaatti;
    private boolean pisteenPaalla;
    private boolean powerUpinPaalla;
    private boolean syotava;

    /**
     * Saa parametreina alkukordinaatit, jotka asetetaan Liikkuvalle.
     *
     * @param alkuX Aloitus x koordinaatti.
     * @param alkuY Aloitus y koordinaatti.
     */
    public Liikkuva(int alkuX, int alkuY) {

        this.suunta = suunta.STOP;
        this.xKordinaatti = alkuX;
        this.yKordinaatti = alkuY;
        this.pisteenPaalla = false;
        this.powerUpinPaalla = false;
        this.syotava = false;
    }

    public void setPisteenPaalla(boolean pisteenPaalla) {
        this.pisteenPaalla = pisteenPaalla;
    }

    public boolean isPisteenPaalla() {
        return pisteenPaalla;
    }

    public Suunta getSuunta() {
        return suunta;
    }

    public void setSuunta(Suunta suunta) {
        this.suunta = suunta;
    }

    /**
     * Palautta x koordinaatin.
     * @return Koordinaatin arvo.
     */
    public int getxKordinaatti() {
        return xKordinaatti;
    }

    /**
     * Palautta y koordinaatin.
     * @return koordinaatin arvo.
     */
    public int getyKordinaatti() {
        return yKordinaatti;
    }

    /**
     * Palauttaa molemmat koordinaatit tauluna.
     *
     * @return X ja y koordinaatit taulussa.
     */
    public int[] getKoordinaatit() {

        int[] koordinaatit = {yKordinaatti, xKordinaatti};

        return koordinaatit;
    }

    /**
     * Asettaa uudet x ja y koordinaatit.
     *
     * @param x Uusi x koordinaatin arvo.
     * @param y Uusi y koordinaatin arvo.
     */
    public void setKoordinaatit(int x, int y) {
        this.xKordinaatti = x;
        this.yKordinaatti = y;
    }

    /**
     * Liikkuva liikkuu yhden askeleen tiettyyn suuntaan, jonka märittää suunta
     * attribuutti.
     */
    public void liiku() {

        if (suunta == suunta.VASEN) {
            this.xKordinaatti--;
        }
        if (suunta == suunta.OIKEA) {
            this.xKordinaatti++;
        }
        if (suunta == suunta.YLOS) {
            this.yKordinaatti--;
        }
        if (suunta == suunta.ALAS) {
            this.yKordinaatti++;
        }
    }

    /**
     * Palauttaa Liikkuvan kenttä arvon.
     *
     * @return 4 tarkoittaa Pacmania ja 3 Monsteria.
     */
    public int getKenttaNumero() {
        return 4;
    }

    /**
     * Kertoo onko Liikkuva monsteri vai Pacman.
     * @return False, jos Monsteri.
     */
    public boolean onPacman() {
        return false;
    }

    public boolean isPowerUpinPaalla() {
        return powerUpinPaalla;
    }

    public void setPowerUpinPaalla(boolean powerUpinPaalla) {
        this.powerUpinPaalla = powerUpinPaalla;
    }

    public boolean isSyotava() {
        return syotava;
    }

    public void setSyotava(boolean syotava) {
        this.syotava = syotava;
    }

    /**
     * Metodi piirtää Liikkuvan. Määritetään perivissä luokissa.
     *
     * @return Palauttaa bufferoidun kuvan Liikkuvasta.
     */
    public BufferedImage piirra() {
        return null;
    }
}
