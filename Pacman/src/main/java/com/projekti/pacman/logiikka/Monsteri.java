/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.logiikka;

import com.projekti.pacman.Suunta;
import java.util.Random;

/**
 * Luokka kuvaa Pacmania jahtaavia monstereita Perii luokan Liikkuva.
 */
public class Monsteri extends Liikkuva {

    public Monsteri(int alkuX, int alkuY) {
        super(alkuX, alkuY);
    }

    /**
     * Metodi valitsee sattumanvaraisesti yhden neljästä mahdollisesta suunnasta.
     */
    public void arvoSuunta() {

        Random random = new Random();

        int satunnaismuuttuja = random.nextInt(101);

        if (satunnaismuuttuja < 25) {

            setSuunta(suunta.ALAS);

        } else if (satunnaismuuttuja < 50) {

            setSuunta(suunta.OIKEA);

        } else if (satunnaismuuttuja < 75) {

            setSuunta(suunta.VASEN);

        } else {

            setSuunta(suunta.YLOS);
        }
    }

    @Override
    public int getKenttaNumero() {
        return 3;
    }
}
