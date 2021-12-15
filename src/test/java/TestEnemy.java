
import com.example.aventurasdemarcoyluis.Enemies.Boo;
import com.example.aventurasdemarcoyluis.Enemies.Enemies;
import com.example.aventurasdemarcoyluis.Enemies.Goomba;
import com.example.aventurasdemarcoyluis.Enemies.Spiny;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestEnemy {

    private Enemies testGoomba;
    private Enemies testBoo;
    private Enemies testSpiny;

    @BeforeEach
    public void setUp() {
        testGoomba= new Goomba(2,4,15,8);
        testBoo = new Boo(5,9,3,8);
        testSpiny = new Spiny(4,10,6,8);
    }

    @Test
    public void constructorTest(){
        assertNotEquals(testBoo, testGoomba);
    }

    @Test
    public void getterTest(){
        assertEquals(5,testBoo.getAtk());
        assertEquals(4,testGoomba.getDef());
        assertEquals(8,testSpiny.getLvl());
        assertEquals(6,testSpiny.getHp());
        assertEquals(15,testGoomba.getMaxHP());
    }

    @Test
    public void setterTest(){
        testBoo.setAtk(3);
        testGoomba.setDef(10);
        testSpiny.setLvl(9);
        testGoomba.setHp(6);

        assertEquals(3,testBoo.getAtk());
        assertEquals(10,testGoomba.getDef());
        assertEquals(9,testSpiny.getLvl());
        assertEquals(6,testGoomba.getHp());
        assertEquals(15,testGoomba.getMaxHP());

        testGoomba.setHp(100);
        testBoo.setHp(-1);
        assertEquals(testGoomba.getHp(),testGoomba.getMaxHP());
        assertEquals(0,testBoo.getHp());
    }

    @Test
    public void StringTest(){
        assertTrue(testGoomba.toString() instanceof String);
        assertTrue(testBoo.toString() instanceof String);
        assertTrue(testSpiny.toString() instanceof String);

    }

}
