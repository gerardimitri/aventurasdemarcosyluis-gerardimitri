package com.example.aventurasdemarcoyluis.Items;

import com.example.aventurasdemarcoyluis.Players.Players;

/**
 * Interface for the usage of Items
 *
 *  @author Gerardo Trincado
 *  github: gerardimitri
 */
public interface Items {

    /**
     * Uses an Item
     * @param aPlayer represents the player that uses the item
     */
    void useItem(Players aPlayer);
}
