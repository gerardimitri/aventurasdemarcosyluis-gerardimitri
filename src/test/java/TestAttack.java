import com.example.aventurasdemarcoyluis.Enemies.Enemies;
import com.example.aventurasdemarcoyluis.Enemies.EnemyType;
import com.example.aventurasdemarcoyluis.Players.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestAttack {
    private Marco testMarco;
    private Luis testLuis;
    private Enemies testGoomba;
    private Enemies testBoo;
    private Enemies testSpiny;

    @BeforeEach
    public void setUp(){
        testMarco=new Marco(17,16,100,15,1);
        testLuis=new Luis(15,15,100,15,1);
        testGoomba= new Enemies(2,4,15,8, EnemyType.GOOMBA);
        testBoo = new Enemies(5,9,3,8, EnemyType.BOO);
        testSpiny = new Enemies(4,10,6,8, EnemyType.SPINY);
    }

    @Test
    public void attackTest(){
        testLuis.attackEnemy(testGoomba, AttackType.SALTO);
        testLuis.attackEnemy(testGoomba, AttackType.MARTILLO);
        testMarco.attackEnemy(testBoo, AttackType.MARTILLO);
        testMarco.attackEnemy(testSpiny, AttackType.SALTO);

        assertEquals(95, testMarco.getHP());
        assertEquals(3, testBoo.getHp());
        assertEquals(12, testLuis.getFP());

        testLuis.setFP(0);
        testLuis.attackEnemy(testGoomba, AttackType.MARTILLO);
    }
}
