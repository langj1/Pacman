package com.projekti.pacman;

import com.projekti.pacman.gui.Kayttoliittyma;
import com.projekti.pacman.peli.Kentta;
import com.projekti.pacman.peli.Peli;
import com.projekti.pacman.tasot.Taso1;
import com.projekti.pacman.tasot.Taso2;
import javax.swing.SwingUtilities;

/**
 * Käynnistää sovelluksen.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Kentta kentta = new Taso2();

        Peli peli = new Peli(kentta);

        Kayttoliittyma gui = new Kayttoliittyma(peli, 20);
        SwingUtilities.invokeLater(gui);

        while (gui.getAlusta() == null) {

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Lataa");
            }
        }

        peli.setAlusta(gui.getAlusta());
        peli.start();
    }

}
