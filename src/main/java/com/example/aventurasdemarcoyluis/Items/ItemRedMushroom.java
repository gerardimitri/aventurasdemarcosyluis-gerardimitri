package com.example.aventurasdemarcoyluis.Items;

import com.example.aventurasdemarcoyluis.Players.Players;

/**
 * Class that represent an Item in the game
 *
 *  @author Gerardo Trincado
 *  github: gerardimitri
 */
public class ItemRedMushroom implements Items {
    /**
     * Empty Constructor
     */
    public ItemRedMushroom(){
    }

    /**
     * Uses the item of type RedMushroom
     * @param aPlayer represents the player that uses the item
     */
    @Override
    public void useItem(Players aPlayer){
            aPlayer.setHP((int)(aPlayer.getHP()+aPlayer.getMaxHP()*0.1));
    }
}
