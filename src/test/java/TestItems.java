
import com.example.aventurasdemarcoyluis.Items.*;
import com.example.aventurasdemarcoyluis.Players.Marco;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestItems {
    private Marco testMarco;

    private ItemRedMushroom testRedMushroom;
    private ItemHoneySyrup testHoneySyrup;
    private ItemStar testStar = new ItemStar();

    @BeforeEach
    public void setUp(){
        testMarco=new Marco(17,16,100,15,1);
        testMarco.setHP(85);
        testMarco.setFP(10);

        testStar = new ItemStar();
        testHoneySyrup = new ItemHoneySyrup();
        testRedMushroom = new ItemRedMushroom();
    }

    @Test
    public void constructorTest(){
        assertFalse(testMarco.checkKO());
    }

    @Test
    public void addItemTest(){

        testMarco.addItem(testStar, 1);
        assertTrue(testMarco.armamento.containsKey(testStar));

        testMarco.addItem(testHoneySyrup, 2);
        assertTrue(testMarco.armamento.containsKey(testHoneySyrup));

        testMarco.addItem(testRedMushroom, 3);
        assertTrue(testMarco.armamento.containsKey(testRedMushroom));

    }

    @Test
    public void useItemTest(){
        testMarco.addItem(testStar, 1);
        testMarco.addItem(testHoneySyrup, 2);
        testMarco.addItem(testRedMushroom, 3);

        testMarco.useItem(testStar);
        assertEquals(0,testMarco.armamento.get(testStar));

        testMarco.useItem(testHoneySyrup);
        assertEquals(1,testMarco.armamento.get(testHoneySyrup));
        assertEquals(13, testMarco.getFP());
        testMarco.useItem(testHoneySyrup);
        assertEquals(15, testMarco.getFP());

        testMarco.useItem(testRedMushroom);
        assertEquals(2,testMarco.armamento.get(testRedMushroom));
        assertEquals(95, testMarco.getHP());
        testMarco.useItem(testRedMushroom);
        assertEquals(100, testMarco.getHP());
        testMarco.useItem(testRedMushroom);
        assertEquals(100, testMarco.getHP());


    }
}
