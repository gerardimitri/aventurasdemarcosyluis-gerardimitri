package com.example.aventurasdemarcoyluis.Players;

import com.example.aventurasdemarcoyluis.Enemies.Enemies;
import com.example.aventurasdemarcoyluis.Enemies.EnemyType;

public class Marco extends Players{
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

    @Override
    public void attackEnemy(Enemies anEnemy, AttackType anAttack){
        double k = 0;
        double damage = k*super.atk*(super.lvl / anEnemy.getDef());
        int random = (int) Math.floor(Math.random()*(4-1+1)+1);

        //Here we check if the Player can Attack
        if (super.fp == 0 || checkKO()){
            return;
        }

        if (anEnemy.getType()== EnemyType.BOO){
            return;
        }

        if (anAttack == AttackType.SALTO){
            k=1;
            super.fp-=1;
            if(anEnemy.getType()== EnemyType.SPINY){
                k=0;
                setHP((int)(super.hp * 0.85));
            }
        }
        if (anAttack == AttackType.MARTILLO){
            super.fp-=2;
            if (random != 4){
                k=1.5;
            }
            if(anEnemy.getType()== EnemyType.BOO){
                k=0;
            }
        }
        int newHp = anEnemy.getHp() - (int) damage;
        anEnemy.setHp(newHp);
    }
}
