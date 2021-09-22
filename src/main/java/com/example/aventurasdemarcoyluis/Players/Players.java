package com.example.aventurasdemarcoyluis.Players;

import com.example.aventurasdemarcoyluis.Enemies.Enemies;
import com.example.aventurasdemarcoyluis.Enemies.EnemyType;
import com.example.aventurasdemarcoyluis.Items.Items;

import java.util.HashMap;

/**
 * Class that represent a Player in the game
 *
 *  @author Gerardo Trincado
 *  github: gerardimitri
 */
public abstract class Players {
    protected int atk;
    protected int def;
    protected int hp;
    protected int fp;
    protected int lvl=1;
    protected int maxhp;
    protected int maxfp;
    public HashMap<Items, Integer> armamento = new HashMap<Items, Integer>();

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
        maxhp=HP;
        maxfp=FP;

    }


    public void addItem(Items a){
        if(armamento.containsKey(a)){
            armamento.replace(a,armamento.get(a)+1);
        }
        else{
            armamento.put(a,1);
        }
    }

    protected void useItem(Items anItem){
        if(armamento.get(anItem)>0){
            anItem.useItem(this);
        }
    }

    public int getHP(){
        return this.hp;
    }

    public int getMaxHP(){
        return this.maxhp;
    }

    public void setHP(int value) {
        if( value < 0) {
            this.hp=0;
        }
        else if( value > this.maxhp) {
            this.hp=this.maxhp;
        }
        else {
            this.hp = value;
        }
    }

    public int getFP(){
        return this.fp;
    }

    public void setFP(int value) {
        if( value < 0) {
            this.fp=0;
        }
        else {
            this.fp = value;
        }
    }


    public boolean checkKO(){
        if(this.hp <0){
            return true;
        }
        else return false;
    }

    public void attackEnemy(Enemies anEnemy, AttackType anAttack){
        double k = 0;
        double damage = k*this.atk*(this.lvl / anEnemy.getDef());
        int random = (int) Math.floor(Math.random()*(4-1+1)+1);

        //Here we check if the Player can Attack
        if (this.fp == 0 || checkKO()){
            return;
        }
        if (anAttack == AttackType.SALTO){
            k=1;
            this.fp-=1;
            if(anEnemy.getType()== EnemyType.SPINY){
                k=0;
                setHP((int)(this.hp * 0.85));
            }
        }
        if (anAttack == AttackType.MARTILLO){
            this.fp-=2;
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
