package com.example.aventurasdemarcoyluis.Players;

import com.example.aventurasdemarcoyluis.Enemies.Enemies;
import com.example.aventurasdemarcoyluis.Items.Items;

import java.util.HashMap;

/**
 * Class that represent a Player in the game
 *
 *  @author Gerardo Trincado
 *  github: gerardimitri
 */
public class Players {
    protected int atk;
    protected int def;
    protected int hp;
    protected int fp;
    protected int lvl;
    protected int maxhp;
    protected int maxfp;
    public HashMap<Items, Integer> armamento = new HashMap<>();

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

    /**
     * Adds an item to the armament bag
     * @param a represents the item
     * @param b represents the quantity
     */
    public void addItem(Items a, int b){
            if (armamento.containsKey(a)) {
                armamento.replace(a, armamento.get(a) + b);
            } else {
                armamento.put(a, b);
            }
    }

    /**
     * Uses an Item that's in bag
     * @param anItem represents the item to use
     */
    public void useItem(Items anItem){
        if(armamento.containsKey(anItem) && armamento.get(anItem)>0){
            anItem.useItem(this);
            this.armamento.replace(anItem, armamento.get(anItem)-1);
        }
    }

    /**
     * Gets the HP
     * @return the HP
     */
    public int getHP(){
        return this.hp;
    }

    /**
     * Gets the maxHP
     * @return the maxHP
     */
    public int getMaxHP(){
        return this.maxhp;
    }

    /**
     * Set the current HP to a value
     * @param value represents the HP to set
     */
    public void setHP(int value) {
        if( value < 0) {
            this.hp=0;
        }
        else this.hp = Math.min(value, this.maxhp);
    }

    /**
     * Gets de FP
     * @return the FP
     */
    public int getFP(){
        return this.fp;
    }

    /**
     * Sets the FP
     * @param value represents the value to set the FP
     */
    public void setFP(int value) {
        if( value < 0) {
            this.fp=0;
        }
        else this.fp = Math.min(value, this.maxfp);
    }

    /**
     * Gets the Atk
     * @return the Atk
     */
    public int getAtk() {
        return atk;
    }

    /**
     * Sets the atk
     * @param atk represents the new atk
     */
    public void setAtk(int atk) {
        this.atk = atk;
    }

    /**
     * Gets the defense
     * @return the defense
     */
    public int getDef() {
        return def;
    }

    /**
     * Sets the Defense
     * @param def represents the new defense
     */
    public void setDef(int def) {
        this.def = def;
    }

    /**
     * gets the Lvl
     * @return the lvl.
     */
    public int getLvl() {
        return lvl;
    }

    /**
     * Sets the lvl.
     * @param lvl represents the new lvl.
     */
    public void setLvl(int lvl) {
        this.lvl = lvl;
    }

    /**
     * Checks if the player is Knocked Out
     * @return boolean, true if the Player is KO'd, false if not
     */
    public boolean checkKO(){
        return this.hp == 0;
    }

    /**
     * Function to attack an enemy
     * @param anEnemy the enemy attacked
     * @param anAttack the attack used
     */
    protected void attackEnemy(Enemies anEnemy, AttackType anAttack){
    }

}
