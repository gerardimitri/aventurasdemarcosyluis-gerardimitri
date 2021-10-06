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
public class Spiny extends AbstractEnemies{
    /**
     * Creates a new Enemy
     *
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param LVL level of the Unit
     */
    public Spiny(int ATK, int DEF, int HP, int LVL) {
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
        if(anAttack == AttackType.SALTO){
            marco.setHP((int)(marco.getMaxHP() * 0.95));
            return;
        }
        int damage = anAttack.Attack(marco, anAttack, this);
        int newHp = this.getHp() - damage;
        this.setHp(newHp);
    }

    /**
     * Enemy is Attacked by a Luis Player.
     *
     * @param luis     refers to luis.
     * @param anAttack refers to the type of the attack.
     */
    @Override
    public void AttackedByLuis(Luis luis, AttackType anAttack) {
        if(anAttack == AttackType.SALTO){
            luis.setHP((int)(luis.getMaxHP() * 0.95));
            return;
        }
        int damage = anAttack.Attack(luis, anAttack, this);
        int newHp = this.getHp() - damage;
        this.setHp(newHp);
    }
}
