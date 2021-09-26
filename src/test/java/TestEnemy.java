
import com.example.aventurasdemarcoyluis.Enemies.Enemies;
import com.example.aventurasdemarcoyluis.Enemies.EnemyType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestEnemy {

    private Enemies testGoomba;
    private Enemies testBoo;
    private Enemies testSpiny;

    @BeforeEach
    public void setUp() {
        testGoomba= new Enemies(2,4,15,8, EnemyType.GOOMBA);
        testBoo = new Enemies(5,9,3,8, EnemyType.BOO);
        testSpiny = new Enemies(4,10,6,8, EnemyType.SPINY);
    }

    @Test
    public void constructorTest(){
        assertEquals(EnemyType.BOO,testBoo.getType());
        assertEquals(EnemyType.GOOMBA,testGoomba.getType());
        assertEquals(EnemyType.SPINY,testSpiny.getType());
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

}
