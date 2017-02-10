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
 * Luokka, joka hallitsee pelin kulkua ja yhdistää kaikki muut logiikan luokat
 * sekä käyttöliittymän
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

    /**
     * Vähentää yhden elämän Jos elämät loppuu peli päättyy
     */
    public void menetaElama() {

        elamat--;

        if (elamat < 0) {

        }

    }

    /**
     * Ensiksi arvoo monstereille uudet suunnat, jonka jälkeen liikuttaa
     * Pacmania. Jos Pacman saavuttaa tason voittoon vaadittavan pistemäärän
     * peli päättyy. Muussa tapauksessa monsterit liikkuu seuraavaksi.
     */
    public void liiku() {

        arvoSuunnat();

        liikkuvaLiikkuu(pacman);

        if (voitto()) {

        }

        for (Monsteri monsteri : monsterit) {
            liikkuvaLiikkuu(monsteri);
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
     */
    public void liikkuvaLiikkuu(Liikkuva l) {

        int x = l.getxKordinaatti();
        int y = l.getyKordinaatti();

        onkoPisteenPaalla(x, y, l);

        l.liiku();

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 0 || kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 3 && !l.onPacman()) {

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
    
    /**
     * Määrittää, mikä arvo laitetaan lähtöruutuun
     * @param x x koordinaatti
     * @param y y koordinaatti
     * @param l Liikkuva
     */

    public void onkoPisteenPaalla(int x, int y, Liikkuva l) {

        if (l.isPisteenPaalla()) {

            kentta.asetaUusiArvo(x, y, 2);

        } else {

            kentta.asetaUusiArvo(x, y, 1);

        }
    }

    /**
     * Katsoo törmääkö monsteri Pacmaniin, jolloin menetetään elämä ja 
     * resetoidaan peli. Katsoo myös törmääkö Monsteri pisteeseen, jotta se 
     * voidaan laitta takaisin.
     * @param l Monsteri, joka mahdollisesti törmää
     */
    
    public void tormaakoMonsteri(Liikkuva l) {

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 4) {

            menetaElama();

            reset();
        }

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 2) {

            l.setPisteenPaalla(true);

        } else {

            l.setPisteenPaalla(false);

        }
    }

    /**
     * Katsoo törmääkö Pacman Monsteriin, jolloin menetetään elämä ja 
     * resetoidaan peli. Katsoo myös törmätäänkö pisteeseen, jolloin piste
     * poistetaan ja Pacmanille lisätään piste.
     * @param l Pacman, joka mahdollisesti törmää
     */
    
    public void tormaakoPacman(Liikkuva l) {

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 3) {

            menetaElama();

            reset();
        }

        if (kentta.haePisteenArvo(l.getxKordinaatti(), l.getyKordinaatti()) == 2) {

            pacman.syoPiste();

        }
    }
    
    /**
     * Resetoi pelin alkuperäisasetelmaan paitsi pisteitä ei palauteta.
     */

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
    
    /**
     * Asettaa pelin Monsterien ja Pacmanien koordinaatteihin tyhjän ruudun tai
     * pisteen.
     */

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
     * Arvoo Monstereille uudet suunnat.
     * @see logiikka.Monsteri#arvoSuunta()
     */

    public void arvoSuunnat() {

        Random random = new Random();

        for (Monsteri monsteri : monsterit) {

            int satunnaismuuttuja = random.nextInt(101);

            if (satunnaismuuttuja < 50) {

                monsteri.arvoSuunta();

            }

        }

    }
    
    /**
     * Katsoo onko Pacmanillä tarpeeksi pisteitä voittoon.
     * @return True jos on tarpeeksi muulloin false.
     */

    public boolean voitto() {

        if (pacman.getPisteet() >= kentta.getPisteet()) {
            return true;
        }

        return false;
    }

    /**
     * Pyörittää peliä.
     * @param e ei käytetä
     */
    
    @Override
    public void actionPerformed(ActionEvent e) {

        liiku();

        alusta.paivita();

        setDelay(300);
    }
}
