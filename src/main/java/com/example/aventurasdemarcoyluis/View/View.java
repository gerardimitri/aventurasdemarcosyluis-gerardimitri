package com.example.aventurasdemarcoyluis.View;

import com.example.aventurasdemarcoyluis.Controller.Battle;
import com.example.aventurasdemarcoyluis.Enemies.Enemies;
import com.example.aventurasdemarcoyluis.Exceptions.InvalidInputException;
import com.example.aventurasdemarcoyluis.Exceptions.ItemNotFoundException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * Viewer for the Model View Controller Pattern
 */
public class View {

    private PrintStream out;
    private BufferedReader reader;

    /**
     * Constructor
     */
    public View() {
        out = System.out;
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Function if we want to change the Output
     *
     * @param anOut represents the new output
     */
    public void setOut(PrintStream anOut) {
        out = anOut;
    }

    /**
     * Function in case we want to change the reader
     *
     * @param aReader represents the new reader
     */
    public void setReader(BufferedReader aReader) {
        reader = aReader;
    }


    /**
     * Lets the User select the Action
     *
     * @param battle represents the current battle
     * @throws InvalidInputException if the String is not an option
     */
    public void SelectAction(Battle battle) throws InvalidInputException, IOException, ItemNotFoundException {
        out.println("¿Que desea hacer?(ATTACK, ITEM, PASS)");
        String action = reader.readLine();
        if (action == "ATTACK") {
            battle.ActionAttack();
        } else if (action == "ITEM") {
            battle.ActionItem();
        } else if (action == "PASS") {
            battle.ActionPass();
        } else {
            throw new InvalidInputException("Opción no valida");
        }

    }

    /**
     * What happens when an ATTACK is chosen as an action.
     *
     * @throws InvalidInputException if the input isn't valid.
     */
    public void ActionAttack(Battle battle) throws InvalidInputException, IOException {
        out.println("¿A que enmigo desea atacar? indique numero");
        PrintEnemies(battle);
        String index = reader.readLine();
        int enemy_i = Integer.valueOf(index);
        out.println("¿Qué ataque desea usar?(SALTO/MARTILLO)");
        String input = reader.readLine();
        if (input == "SALTO") {
            battle.AttackSalto(enemy_i);
        } else if (input == "MARTILLO") {
            battle.AttackMartillo(enemy_i);
        } else {
            throw new InvalidInputException("Opción no valida");
        }
        battle.swapTurn();
    }

    /**
     * What happens when an ITEM is chosen as an action.
     *
     * @throws InvalidInputException if the string is not an option.
     */
    public void ActionItem(Battle battle) throws InvalidInputException, IOException, ItemNotFoundException {
        out.println("¿Qué item desea usar?(STAR, REDMUSHROOM, HONEYSYRUP)");
        String input = reader.readLine();

        if (input == "STAR") {
            battle.UseItemStar();
        } else if (input == "REDMUSHROOM") {
            battle.UseItemRedMushroom();
        } else if (input == "HONEYSYRUP") {
            battle.UseItemHoneySyrup();
        }
        else{
            throw new InvalidInputException("Opción no valida");
        }
        battle.swapTurn();
    }

    /**
     * Prints the enemies in battle.
     *
     * @param battle represents the current battle.
     */
    public void PrintEnemies(Battle battle) {
        ArrayList<Enemies> enemies = battle.getEnemies();
        for (int i = 0; i < enemies.size(); i++) {
            out.println(i + 1 + battle.getEnemy(i).toString());
        }
    }


}
