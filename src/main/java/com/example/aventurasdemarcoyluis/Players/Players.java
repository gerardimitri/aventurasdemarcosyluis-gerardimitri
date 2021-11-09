package com.example.aventurasdemarcoyluis.Players;

import com.example.aventurasdemarcoyluis.Enemies.Enemies;
import com.example.aventurasdemarcoyluis.Entity.Entity;
import com.example.aventurasdemarcoyluis.Items.ItemVault;
import com.example.aventurasdemarcoyluis.Items.Items;

/**
 * Interface for the usage of different Players
 */
public interface Players extends Entity {
    /**
     * Adds an item to the armament bag
     * @param aVault represents the ItemVault
     * @param anItem represents the item
     * @param b represents the quantity
     */
    void addItem(ItemVault aVault, Items anItem, int b);

    /**
     * Uses an Item that's in bag
     * @param anItem represents the item to use
     */
    void useItem(ItemVault aVault, Items anItem);

    boolean containsItem(ItemVault aVault, Items anItem);

    int getItem(ItemVault aVault, Items anItem);
    /**
     * Gets the HP
     * @return the HP
     */
    int getHP();

    /**
     * Gets the maxHP
     * @return the maxHP
     */
    int getMaxHP();

    /**
     * Set the current HP to a value
     * @param value represents the HP to set
     */
    void setHP(int value);

    /**
     * Gets the FP
     * @return the FP
     */
    int getFP();

    /**
     * Gets the maxFP
     * @return the maxFP
     */
    int getMaxFP();

    /**
     * Sets the FP
     * @param value represents the value to set the FP
     */
    void setFP(int value);

    /**
     * Gets the Atk
     * @return the Atk
     */
    int getAtk();

    /**
     * Sets the atk
     * @param atk represents the new atk
     */
    void setAtk(int atk);

    /**
     * Gets the defense
     * @return the defense
     */
    int getDef();

    /**
     * Sets the Defense
     * @param def represents the new defense
     */
    void setDef(int def);

    /**
     * gets the Lvl
     * @return the lvl.
     */
    int getLvl();

    /**
     * Sets the lvl.
     * @param lvl represents the new lvl.
     */
    void setLvl(int lvl);

    /**
     * Checks if the player is Knocked Out
     * @return boolean, true if the Player is KO'd, false if not
     */
    boolean checkKO();

    /**
     * Function to attack an enemy
     * @param anEnemy the enemy attacked
     * @param anAttack the attack used
     */
    void attackEnemy(Enemies anEnemy, AttackType anAttack);
}
