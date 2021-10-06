package com.example.aventurasdemarcoyluis.Items;

import com.example.aventurasdemarcoyluis.Players.Players;

/**
 * Class that represent an Item in the game
 *
 *  @author Gerardo Trincado
 *  github: gerardimitri
 */
public class ItemHoneySyrup implements Items {
    /**
     * Empty Constructor
     */
    public ItemHoneySyrup(){
    }

    /**
     * Uses the Item of type HoneySyrup
     * @param aPlayer represents the player that uses the item
     */
    @Override
    public void useItem(Players aPlayer){
            aPlayer.setFP(aPlayer.getFP()+3);
        }

}
