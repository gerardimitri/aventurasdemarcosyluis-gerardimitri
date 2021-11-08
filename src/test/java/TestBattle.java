import com.example.aventurasdemarcoyluis.Controller.*;
import com.example.aventurasdemarcoyluis.Enemies.Boo;
import com.example.aventurasdemarcoyluis.Enemies.Enemies;
import com.example.aventurasdemarcoyluis.Enemies.Goomba;
import com.example.aventurasdemarcoyluis.Enemies.Spiny;
import com.example.aventurasdemarcoyluis.Items.ItemVault;
import com.example.aventurasdemarcoyluis.Players.Luis;
import com.example.aventurasdemarcoyluis.Players.Marco;
import com.example.aventurasdemarcoyluis.Players.Players;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestBattle {
    private Battle testBattle;


    @BeforeEach
    public void setUp() {
        testBattle = new Battle();
    }

    @Test
    public void BattleTest() {
        assertTrue(testBattle.getVault() instanceof ItemVault);

        assertTrue(testBattle.generateBOO() instanceof Boo);
        assertTrue(testBattle.generateSPINY() instanceof Spiny);
        assertTrue(testBattle.generateGOOMBA() instanceof Goomba);

        assertEquals(0, testBattle.getTurnid());
        testBattle.swapTurn();
        assertEquals(1, testBattle.getTurnid());
        assertTrue(testBattle.getTurn() instanceof Luis);
        assertTrue(testBattle.getNextTurn() instanceof Enemies);
        assertEquals(testBattle.getEnemyArrayNumber(), testBattle.getEnemynumber());
        testBattle.swapTurn();
        assertTrue(testBattle.getTurn() instanceof Enemies);
        assertEquals(testBattle.getTurn(), testBattle.getEnemy(testBattle.getTurnid() - 2));
        testBattle.swapTurn();
        testBattle.swapTurn();
        assertTrue(testBattle.getNextTurn() instanceof Marco);
        testBattle.swapTurn();
        assertEquals(0, testBattle.getTurnid());

        assertTrue(testBattle.notOver());

        assertTrue(testBattle.getPlayer(0) instanceof Marco);
        assertTrue(testBattle.getPlayer(1) instanceof Luis);
    }
}

