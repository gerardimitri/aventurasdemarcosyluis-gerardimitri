
import com.example.aventurasdemarcoyluis.Players.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestPlayers {
    private Marco testMarco;
    private Luis testLuis;

    @BeforeEach
    public void setUp(){
        testMarco=new Marco(17,16,100,15,1);
        testLuis=new Luis(15,15,100,15,1);
    }

    @Test
    public void constructorTest(){
        assertFalse(testMarco.checkKO());
        assertFalse(testLuis.checkKO());

    }

    @Test
    public void hpTest(){
        assertEquals(100, testMarco.getMaxHP());
        assertEquals(100, testLuis.getMaxHP());

        testLuis.setHP(testLuis.getHP()-2);
        testMarco.setHP(testMarco.getHP()-2);

        assertEquals(100, testMarco.getMaxHP());
        assertEquals(100, testLuis.getMaxHP());

        assertEquals(98, testMarco.getHP());
        assertEquals(98, testLuis.getHP());
    }

    @Test
    public void KOTest(){
        testLuis.setHP(-1);
        testMarco.setHP(0);

        assertEquals(0, testMarco.getHP());
        assertEquals(0, testLuis.getHP());

        assertTrue(testMarco.checkKO());
        assertTrue(testLuis.checkKO());
    }

    @Test
    public void setterTest() {
        testLuis.setAtk(6);
        testMarco.setDef(9);
        assertEquals(9, testMarco.getDef());
        assertEquals(6, testLuis.getAtk());

        testMarco.setLvl(testMarco.getLvl()+1);
        assertEquals(2, testMarco.getLvl());

    }

}
