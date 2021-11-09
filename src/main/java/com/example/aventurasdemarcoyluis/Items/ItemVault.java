package com.example.aventurasdemarcoyluis.Items;

import com.example.aventurasdemarcoyluis.Players.Players;

import java.util.HashMap;

/**
 * Class that represent a shared ItemVault
 *
 *  @author Gerardo Trincado
 *  github: gerardimitri
 */
public class ItemVault {
    private HashMap<Items, Integer> armamento;

    /**
     * Constructor
     */
    public ItemVault(){
        armamento = new HashMap<>();
    }

    /**
     * Adds an item to the armament bag
     * @param a represents the item
     * @param b represents the quantity
     */
    public void addItem(Items a, int b){
        if (armamento.containsKey(a)) {
            armamento.replace(a, armamento.get(a) + b);
        } else {
            armamento.put(a, b);
        }
    }

    /**
     * Uses an Item that's in bag
     * @param anItem represents the item to use
     * @param aPlayer represents the players who uses the Item
     */
    public void useItem(Items anItem, Players aPlayer){
        if(armamento.containsKey(anItem) && armamento.get(anItem)>0){
            anItem.useItem(aPlayer);
            this.armamento.replace(anItem, armamento.get(anItem)-1);
        }
    }

    /**
     * Gets the quantity of an Item
     * @param anItem the item that's being checked
     * @return the quantity
     */
    public int getItemQuantity(Items anItem){
        return armamento.get(anItem);
    }

    /**
     * Checks if the item vault contains the key of an Item
     * @param anItem represents the item
     * @return true if it contains the key
     */
    public boolean containsKey(Items anItem){
        return armamento.containsKey(anItem);
    }

}
