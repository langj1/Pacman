package com.projekti.pacman.logiikka;

import com.projekti.pacman.Suunta;
import java.awt.image.BufferedImage;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class PacmanTest {

    Pacman pacman;

    @Before
    public void setUp() {
        pacman = new Pacman(12, 31);
    }

    @Test
    public void onPacmanToimii() {
        assertTrue(pacman.onPacman());
    }

    @Test
    public void isSuuaukiToimii() {
        assertFalse(pacman.isSuuAuki());
    }

    @Test
    public void setSuuaukiToimii() {
        pacman.setSuuAuki(true);
        assertTrue(pacman.isSuuAuki());
    }

    @Test
    public void getExtraPisteetToimii() {
        assertEquals(0, pacman.getExtraPisteet());
    }

    @Test
    public void setExtraPisteetToimii() {
        pacman.setExtraPisteet(12);
        assertEquals(12, pacman.getExtraPisteet());
    }

    @Test
    public void piirraPalauttaaNullKunSTOP() {
        assertEquals(null, pacman.piirra());
    }

    @Test
    public void piirraOikeaMuuttaaSuuAuki() {
        pacman.setSuuAuki(true);
        pacman.setSuunta(Suunta.OIKEA);
        pacman.piirra();
        assertFalse(pacman.isSuuAuki());
    }

    @Test
    public void piirraVasenMuuttaaSuuAuki() {
        pacman.setSuuAuki(true);
        pacman.setSuunta(Suunta.VASEN);
        pacman.piirra();
        assertFalse(pacman.isSuuAuki());
    }

    @Test
    public void piirraYLOSMuuttaaSuuAuki() {
        pacman.setSuuAuki(true);
        pacman.setSuunta(Suunta.YLOS);
        pacman.piirra();
        assertFalse(pacman.isSuuAuki());
    }

    @Test
    public void piirraAlasSuuAuki() {
        pacman.setSuuAuki(true);
        pacman.setSuunta(Suunta.ALAS);
        pacman.piirra();
        assertFalse(pacman.isSuuAuki());
    }

    @Test
    public void piirraStopMuuttaaSuuAuki() {
        pacman.setSuuAuki(true);
        pacman.setSuunta(Suunta.STOP);
        pacman.piirra();
        assertTrue(pacman.isSuuAuki());
    }
}
