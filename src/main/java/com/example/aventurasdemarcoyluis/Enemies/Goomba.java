package com.example.aventurasdemarcoyluis.Enemies;

import com.example.aventurasdemarcoyluis.Players.AttackType;
import com.example.aventurasdemarcoyluis.Players.Luis;
import com.example.aventurasdemarcoyluis.Players.Marco;

/**
 * Class that represent an Enemy in the game
 *
 *  @author Gerardo Trincado
 *  github: gerardimitri
 */
public class Goomba extends AbstractEnemies{
    /**
     * Creates a new Enemy
     *
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param LVL level of the Unit
     */
    public Goomba(int ATK, int DEF, int HP, int LVL) {
        super(ATK, DEF, HP, LVL);
    }

    /**
     * Enemy is Attacked by a Marco Player.
     *
     * @param marco    refers to marco.
     * @param anAttack refers to the type of the attack.
     */
    @Override
    public void AttackedByMarco(Marco marco, AttackType anAttack) {
        int damage = anAttack.Attack(marco, anAttack, this);
        int newHp = this.getHp() - damage;
        this.setHp(newHp);
    }

    /**
     * Enemy is Attacked by a Luis Player.
     *
     * @param luis     refers to Luis.
     * @param anAttack refers to the type of the attack.
     */
    @Override
    public void AttackedByLuis(Luis luis, AttackType anAttack) {
        int damage = anAttack.Attack(luis, anAttack, this);
        int newHp = this.getHp() - damage;
        this.setHp(newHp);
    }
}
