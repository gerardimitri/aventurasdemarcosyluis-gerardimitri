package com.example.aventurasdemarcoyluis.Players;

import com.example.aventurasdemarcoyluis.Enemies.Enemies;

/**
 * Class that represent a Player in the game
 *
 *  @author Gerardo Trincado
 *  github: gerardimitri
 */

public class Marco extends AbstractPlayers{
    /**
     * Creates a new player
     *
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param FP  fight points
     * @param LVL level of the Unit
     */
    public Marco(int ATK, int DEF, int HP, int FP, int LVL) {
        super(ATK, DEF, HP, FP, LVL);
    }

    /**
     * Function to attack an enemy
     * @param anEnemy the enemy attacked
     * @param anAttack the attack used
     */
    @Override
    public void attackEnemy(Enemies anEnemy, AttackType anAttack){
        //Here we check if the Player can Attack
        if (super.getFP() == 0 || checkKO() || anEnemy.checkKO()){
            return;
        }
        anEnemy.AttackedByMarco(this, anAttack);
    }
}
