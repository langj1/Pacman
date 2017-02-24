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
 *
 * @author langjimi
 */
public class Peli extends Timer implements ActionListener {

    private Kentta kentta;
    private int elamat;
    private ArrayList<Monsteri> monsterit;
    private Pacman pacman;
    private Piirtoalusta alusta;
    private Tormaako tormaako;
    private PowerUpAjastin ajastin;

    public Peli(Kentta kentta) {

        super(1000, null);

        this.kentta = kentta;
        this.pacman = kentta.pacmaninLahtokohta();
        this.monsterit = kentta.monsterienLahtokohdat();
        this.tormaako = new Tormaako(this.kentta, this);
        this.ajastin = null;
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

        int pisteet = kentta.getPisteet() - kentta.laskePisteet();

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

        monsteritNormaaleiksi();

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

        liiku();

        alusta.paivita();

        setDelay(100);
    }

    public void monsteritSyotaviksi() {
        for (Monsteri monsteri : monsterit) {
            monsteri.setSyotava(true);
        }
        pacman.setSyotava(true);
    }

    public void monsteritNormaaleiksi() {
        for (Monsteri monsteri : monsterit) {
            monsteri.setSyotava(false);
        }
        pacman.setSyotava(false);
    }

    public PowerUpAjastin getAjastin() {
        return ajastin;
    }

    public void setAjastin(PowerUpAjastin a) {
        if (ajastin != null) {
            ajastin.cancel();
        }
        this.ajastin = a;
    }

}
