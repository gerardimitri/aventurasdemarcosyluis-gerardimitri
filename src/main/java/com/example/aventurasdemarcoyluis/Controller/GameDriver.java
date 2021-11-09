package com.example.aventurasdemarcoyluis.Controller;

import java.io.IOException;

//En teoria acá van los inputs -> tarea 3
public class GameDriver {
    public static void main(String[] args) {
        Battle battle = new Battle();
        doBattle(battle);
    }

    public static void doBattle(Battle battle) {
        while(battle.notOver()){
            int current = battle.getTurnid();
            battle.getEnemyTurn(current);
            //acá va la logica de batalla y los prints que no es para esta tarea
            battle.swapTurn();
        }
    }
}
