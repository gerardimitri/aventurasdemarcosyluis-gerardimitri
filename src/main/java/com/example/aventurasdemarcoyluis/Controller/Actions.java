package com.example.aventurasdemarcoyluis.Controller;

import com.example.aventurasdemarcoyluis.Players.Players;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Esto no es de esta tarea jeje

public enum Actions {
    ATTACK,
    ITEM,
    PASS;
    /*
    public void Action(Battle aBattle, Actions anAction) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        switch(anAction){
            case ITEM -> {
                aBattle.ActionItem(reader);
            }
            case ATTACK -> {
                aBattle.ActionAttack(reader);
            }
            case PASS -> {
                aBattle.ActionPass();
            }
        }
    }
     */
}
