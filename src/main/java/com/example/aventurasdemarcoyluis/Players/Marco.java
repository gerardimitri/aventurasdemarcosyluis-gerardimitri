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

    /**
     * Function to attack an enemy
     * @param anEnemy the enemy attacked
     * @param anAttack the attack used
     */

    /*Nota: panxito me dijo que está mal usar tantos if, pero para tratar con
     eso se deben utilizar tecnicas que se verán más adelante en el curso*/
    @Override
    public void attackEnemy(Enemies anEnemy, AttackType anAttack){
        double k = 0;
        int random = (int) Math.floor(Math.random()*(4-1+1)+1);

        //Here we check if the Player can Attack
        if (super.getFP() == 0 || checkKO()){
            return;
        }

        if (anEnemy.getType()== EnemyType.BOO){
            return;
        }

        if (anAttack == AttackType.SALTO){
            k=1;
            super.setFP(super.getFP()-1);
            if(anEnemy.getType()== EnemyType.SPINY){
                k=0;
                setHP((int)(super.getMaxHP() * 0.95));
            }
        }
        if (anAttack == AttackType.MARTILLO){
            super.setFP(super.getFP()-2);
            if (random != 4){
                k=1.5;
            }
            if(anEnemy.getType()== EnemyType.BOO){
                k=0;
            }
        }
        double damage = k*super.getAtk()*((double) (super.getLvl() / anEnemy.getDef()));
        int newHp = anEnemy.getHp() - (int) damage;
        anEnemy.setHp(newHp);
    }
}
