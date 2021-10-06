import com.example.aventurasdemarcoyluis.Enemies.*;
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
        testGoomba= new Goomba(2,4,15,8);
        testBoo = new Boo(5,9,3,8);
        testSpiny = new Spiny(4,10,6,8);
    }

    @Test
    public void attackTest(){
        //GOOMBA
        testLuis.setFP(0);
        testLuis.attackEnemy(testGoomba, AttackType.MARTILLO);
        assertEquals(15, testGoomba.getHp());

        testLuis.setFP(testLuis.getMaxFP());

        testLuis.attackEnemy(testGoomba, AttackType.SALTO);
        assertEquals(11, testGoomba.getHp());

        testMarco.setHP(0);

        testMarco.attackEnemy(testGoomba, AttackType.MARTILLO);
        assertEquals(11, testGoomba.getHp());

        testMarco.setHP(testMarco.getMaxHP());

        testMarco.attackEnemy(testGoomba, AttackType.SALTO);
        assertEquals(7, testGoomba.getHp());

        //SPINY
        testMarco.attackEnemy(testSpiny, AttackType.SALTO);
        assertEquals(6,testSpiny.getHp());
        assertEquals(95, testMarco.getHP());

        testLuis.attackEnemy(testSpiny, AttackType.SALTO);
        assertEquals(95, testLuis.getHP());

        testLuis.attackEnemy(testSpiny,AttackType.MARTILLO);
        assertTrue((testSpiny.getHp()==testSpiny.getMaxHP() || testSpiny.getHp()==testSpiny.getMaxHP()-2));

        testSpiny.setHp(testSpiny.getMaxHP());
        testMarco.attackEnemy(testSpiny,AttackType.MARTILLO);
        assertTrue((testSpiny.getHp()==testSpiny.getMaxHP() || testSpiny.getHp()==testSpiny.getMaxHP()-3));

        //BOO
        testLuis.attackEnemy(testBoo, AttackType.SALTO);
        assertEquals(3, testBoo.getHp());

        testMarco.attackEnemy(testBoo, AttackType.SALTO);
        assertEquals(1, testBoo.getHp());

        //PLAYERS
        testGoomba.attackPlayer(testLuis);
        assertEquals(94,testLuis.getHP());

    }
}
