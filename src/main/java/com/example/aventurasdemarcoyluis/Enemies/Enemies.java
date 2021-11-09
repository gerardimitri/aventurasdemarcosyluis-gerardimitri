package com.example.aventurasdemarcoyluis.Enemies;

import com.example.aventurasdemarcoyluis.Entity.Entity;
import com.example.aventurasdemarcoyluis.Players.AttackType;
import com.example.aventurasdemarcoyluis.Players.Luis;
import com.example.aventurasdemarcoyluis.Players.Marco;
import com.example.aventurasdemarcoyluis.Players.Players;

/**
 * Interface for the usage of Enemies
 *
 *  @author Gerardo Trincado
 *  github: gerardimitri
 */
public interface Enemies extends Entity {
    /**
     * Enemy is Attacked by a Marco Player.
     * @param marco refers to marco.
     * @param anAttack refers to the type of the attack.
     */
    void AttackedByMarco(Marco marco, AttackType anAttack);

    /**
     * Enemy is Attacked by a Luis Player.
     * @param luis refers to luis.
     * @param anAttack refers to the type of the attack.
     */
    void AttackedByLuis(Luis luis, AttackType anAttack);

    /**
     * Attacks a Player
     * @param aPlayer represents the player attacked
     */
    void attackPlayer(Players aPlayer);

    /**
     * Checks if the enemy is KO'd
     * @return True if enemy is KO'd
     */
    boolean checkKO();

    /**
     * Gets the Def.
     * @return the def.
     */
    int getDef();

    /**
     * Gets the HP.
     * @return the hp.
     */
    int getHp();

    /**
     * Gets the atk.
     * @return the atk.
     */
    int getAtk();

    /**
     * getLvl.
     * @return the lvl.
     */
    int getLvl();

    /**
     * Gets the maxHP.
     * @return the maxHP.
     */
    int getMaxHP();

    /**
     * Sets the atk.
     * @param atk represents the new atk.
     */
    void setAtk(int atk);

    /**
     * Sets the def.
     * @param def represents the new defense.
     */
    void setDef(int def);

    /**
     * Sets the lvl.
     * @param lvl represents the new lvl.
     */
    void setLvl(int lvl);

    /**
     * Sets the HP.
     * @param value represents the new HP.
     */
    void setHp(int value);
}
