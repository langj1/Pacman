/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projekti.pacman.logiikka;

import com.projekti.pacman.Suunta;
import java.util.ArrayList;
import java.util.Random;

/**
 * Luokka kuvaa Pacmania jahtaavia monstereita Perii luokan Liikkuva.
 */
public class Monsteri extends Liikkuva {

    private int suuntaArvo;

    public Monsteri(int alkuX, int alkuY) {
        super(alkuX, alkuY);

        this.suuntaArvo = 0;
    }

    /**
     * Metodi valitsee sattumanvaraisesti yhden suunnista, jotka sen parametrina
     * saama lista sisältää.
     * VASEN = 1, OIKEA = 2, YLOS = 3, ALAS = 4
     */
    public void arvoSuunta(ArrayList<Integer> suunnat) {

        Random random = new Random();

        while (true) {
            int satunnaismuuttuja = random.nextInt(100);

            if (satunnaismuuttuja < 25) {

                setSuunta(suunta.ALAS);
                this.suuntaArvo = 4;

            } else if (satunnaismuuttuja < 50) {

                setSuunta(suunta.OIKEA);
                this.suuntaArvo = 2;

            } else if (satunnaismuuttuja < 75) {

                setSuunta(suunta.VASEN);
                this.suuntaArvo = 1;

            } else {

                setSuunta(suunta.YLOS);
                this.suuntaArvo = 3;
            }

            if (suunnat.contains(this.suuntaArvo)) {
                break;
            }
        }
    }

    @Override
    public int getKenttaNumero() {
        return 3;
    }

    public int getSuuntaArvo() {
        return suuntaArvo;
    }
    
    
}
