import com.example.aventurasdemarcoyluis.Controller.Battle;
import com.example.aventurasdemarcoyluis.Exceptions.InvalidInputException;
import com.example.aventurasdemarcoyluis.NullOutputStream;
import com.example.aventurasdemarcoyluis.View.View;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.io.StringReader;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ViewTest {

    private View testView;
    private Battle testBattle;

    @BeforeEach
    public void setUp(){
        testBattle = new Battle();
        testView = testBattle.getView();
        testView.setOut(new PrintStream(new NullOutputStream()));
    }

    @Test
    public void viewTest1(){
        testView.setReader(new BufferedReader(
                new StringReader("JAJAJA\n")));
        InvalidInputException error = assertThrows(InvalidInputException.class, () -> {
            testView.SelectAction(testBattle);});

        Assertions.assertEquals("Opción no valida", error.getMessage());
    }

    @Test
    public void viewTest2(){
        testView.setReader(new BufferedReader(
                new StringReader("1\nJAJAJA\n")));
        InvalidInputException error = assertThrows(InvalidInputException.class, () -> {
            testView.ActionAttack(testBattle);});

        Assertions.assertEquals("Opción no valida", error.getMessage());
    }

    @Test
    public void viewTest3(){
        testView.setReader(new BufferedReader(
                new StringReader("JAJAJA\n")));
        InvalidInputException error = assertThrows(InvalidInputException.class, () -> {
            testView.ActionItem(testBattle);});

        Assertions.assertEquals("Opción no valida", error.getMessage());
    }

}
