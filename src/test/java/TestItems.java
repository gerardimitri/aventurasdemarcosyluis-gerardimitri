import com.example.aventurasdemarcoyluis.Exceptions.ItemNotFoundException;
import com.example.aventurasdemarcoyluis.Items.*;
import com.example.aventurasdemarcoyluis.Players.Marco;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestItems {
    private Marco testMarco;

    private ItemRedMushroom testRedMushroom;
    private ItemHoneySyrup testHoneySyrup;
    private ItemStar testStar;
    private ItemVault testVault;



    @BeforeEach
    public void setUp(){
        testMarco=new Marco(17,16,100,15,1);
        testMarco.setHP(85);
        testMarco.setFP(10);

        testStar = new ItemStar();
        testHoneySyrup = new ItemHoneySyrup();
        testRedMushroom = new ItemRedMushroom();
        testVault = new ItemVault();
    }

    @Test
    public void constructorTest(){
        assertFalse(testMarco.checkKO());
    }

    @Test
    public void addItemTest(){

        testMarco.addItem(testVault, testStar, 1);
        assertTrue(testMarco.containsItem(testVault, testStar));

        testMarco.addItem(testVault, testHoneySyrup, 2);
        assertTrue(testMarco.containsItem(testVault, testHoneySyrup));

        testMarco.addItem(testVault, testRedMushroom, 3);
        assertTrue(testMarco.containsItem(testVault, testRedMushroom));

    }

    @Test
    public void useItemTest() throws ItemNotFoundException {

        testMarco.addItem(testVault, testStar, 1);
        testMarco.addItem(testVault, testHoneySyrup, 2);
        testMarco.addItem(testVault, testRedMushroom, 3);

        testMarco.useItem(testVault, testStar);
        assertEquals(0,testMarco.getItem(testVault, testStar));


        testMarco.useItem(testVault, testHoneySyrup);
        assertEquals(1,testMarco.getItem(testVault, testHoneySyrup));
        assertEquals(13, testMarco.getFP());
        testMarco.useItem(testVault, testHoneySyrup);
        assertEquals(15, testMarco.getFP());

        testMarco.useItem(testVault, testRedMushroom);
        assertEquals(2,testMarco.getItem(testVault, testRedMushroom));
        assertEquals(95, testMarco.getHP());
        testMarco.useItem(testVault, testRedMushroom);
        assertEquals(100, testMarco.getHP());
        testMarco.useItem(testVault, testRedMushroom);
        assertEquals(100, testMarco.getHP());

    }

    @Test
    public void ExceptionTest(){
        ItemNotFoundException error = assertThrows(ItemNotFoundException.class, () -> {
            testVault.useItem(testStar, testMarco);});

        Assertions.assertEquals("Item not found in the vault", error.getMessage());
    }
}
