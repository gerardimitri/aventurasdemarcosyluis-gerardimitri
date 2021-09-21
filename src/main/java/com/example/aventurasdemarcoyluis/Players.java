package com.example.aventurasdemarcoyluis;

import java.util.List;

/**
 * Class that represent a Player in the game
 *
 *  @author Gerardo Trincado
 *  github: gerardimitri
 */
public class Players {
    private int atk;
    private int def;
    private int hp;
    private int fp;
    private int lvl=1;
    public List<Item> armamento;

    /**
     * Creates a new player
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param FP  fight points
     * @param LVL level of the Unit
     *
     */
    public Players(int ATK, int DEF, int HP, int FP, int LVL ){
        atk=ATK;
        def=DEF;
        hp=HP;
        fp=FP;
        lvl=LVL;
    }


    public void addAItem(Item a){
        armamento.add(a);
    }


    public void setHP(int value) {
        if( value < 0) {
            setHP(0);
        }
        else {
            this.hp = value;
        }
    }

    public void attackEnemy(Enemies anEnemy,AttackType anAttack){
        double k = 0;
        double damage = k*this.atk*(this.lvl / anEnemy.getDef());
        int random = (int) Math.floor(Math.random()*(4-1+1)+1);

        if (this.fp == 0){
            return;
        }
        if (anAttack == AttackType.SALTO){
            k=1;
            this.fp-=1;
            if(anEnemy.getType()==EnemyType.SPINY){
                k=0;
                setHP((int)(this.hp * 0.85));
            }
        }
        if (anAttack == AttackType.MARTILLO){
            this.fp-=2;
            if (random != 4){
                k=1.5;
            }
            if(anEnemy.getType()==EnemyType.BOO){
                k=0;
            }
        }
        int newHp = anEnemy.getHp() - (int) damage;
        anEnemy.setHp(newHp);
    }

    public void useItem(Items anItem){

    }

    public boolean checkKO(){
        if(this.hp <0){
            return true;
        }
        else return false;
    }







}
