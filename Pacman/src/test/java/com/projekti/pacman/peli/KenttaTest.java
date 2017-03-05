package com.projekti.pacman.peli;

import com.projekti.pacman.tasot.Taso1;
import com.projekti.pacman.logiikka.Monsteri;
import com.projekti.pacman.logiikka.Pacman;
import java.util.ArrayList;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class KenttaTest {
    
    Kentta taso;
    
    @Before
    public void setUp(){
        taso = new Taso1();
    }
    
    @Test
    public void pisteenArvonHakuToimii() {
        assertEquals(5, taso.haePisteenArvo(13, 1));
    }
    
    @Test
    public void asetaUusiArvoToimii() {
        
        taso.asetaUusiArvo(2, 2, 120);
        
        assertEquals(120, taso.haePisteenArvo(2, 2));
    }
    
    @Test
    public void pacmaninLahtokohtaToimii() {
        
        Pacman pacman = taso.pacmaninLahtokohta();
        
        assertEquals(13, pacman.getxKordinaatti());
    }
    
    @Test
    public void monsterienLahtokohdatToimii() {
        
        ArrayList<Monsteri> monsterit = taso.monsterienLahtokohdat();
        
        assertEquals(7, monsterit.get(0).getxKordinaatti());
    }
    
    @Test
    public void getKenttaToimii() {
        assertEquals(0,taso.getKentta()[0][0]);
    }
    
    @Test
    public void pacmaninLahtokohtaEiNull() {
        int x = 0;
        if(taso.pacmaninLahtokohta() == null){
            x++;
        }
        assertEquals(0,x);
    }
    
    @Test
    public void monsteritEriVarisia() {
        assertEquals(3,taso.monsterienLahtokohdat().get(2).getVari());
    }
    
    @Test
    public void tietynMonsterinLahtoToimii() {
        int[] i = {8,7};
        assertArrayEquals(i,taso.tietynMonsterinLahto(1));
    }
}
