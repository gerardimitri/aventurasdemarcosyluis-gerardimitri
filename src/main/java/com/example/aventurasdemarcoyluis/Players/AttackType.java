package com.example.aventurasdemarcoyluis.Players;

import com.example.aventurasdemarcoyluis.Enemies.Enemies;

/**
 * Enumerator that represents de type of attack that a
 * player can choose
 *
 */
public enum AttackType {
    MARTILLO,
    SALTO;

    public int Attack(Players aPlayer, AttackType anAttack, Enemies anEnemy) {
        double k = 0;
        switch (anAttack) {
            case MARTILLO -> {
                int random = (int) Math.floor(Math.random()*(4-1+1)+1);
                aPlayer.setFP(aPlayer.getFP() - 2);
                if (random != 4) {
                    k = 1.5;
                }
            }
            case SALTO -> {
                aPlayer.setFP(aPlayer.getFP() - 1);
                k = 1;
            }
            default -> {
            }
        }
        double aux=k*aPlayer.getAtk();
        double aux2=(double) aPlayer.getLvl() / (double) anEnemy.getDef();
        double damage = aux*aux2;
        int damage1 = (int) damage;
        if(damage%1>0.5){return damage1 +1;}
        return damage1;
    }
}