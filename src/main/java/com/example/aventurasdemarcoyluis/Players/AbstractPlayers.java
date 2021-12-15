package com.example.aventurasdemarcoyluis.Players;

import com.example.aventurasdemarcoyluis.Enemies.Enemies;
import com.example.aventurasdemarcoyluis.Entity.Entity;
import com.example.aventurasdemarcoyluis.Exceptions.ItemNotFoundException;
import com.example.aventurasdemarcoyluis.Items.ItemVault;
import com.example.aventurasdemarcoyluis.Items.Items;

/**
 * Class that represent an Abstract Player in the game
 *
 *  @author Gerardo Trincado
 *  github: gerardimitri
 */
public abstract class AbstractPlayers implements Players, Entity {
    private int atk;
    private int def;
    private int hp;
    private int fp;
    private int lvl;
    private int maxhp;
    private int maxfp;

    /**
     * Creates a new player
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param FP  fight points
     * @param LVL level of the Unit
     *
     */
    public AbstractPlayers(int ATK, int DEF, int HP, int FP, int LVL ){
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
     * @param anItem represents the item
     * @param b represents the quantity
     */
    public void addItem(ItemVault aVault,Items anItem, int b){
        aVault.addItem(anItem, b);
    }

    /**
     * Uses an Item that's in bag
     * @param anItem represents the item to use
     */
    public void useItem(ItemVault aVault, Items anItem) throws ItemNotFoundException {
        aVault.useItem(anItem, this);
    }

    public boolean containsItem(ItemVault aVault, Items anItem){
        return aVault.containsKey(anItem);
    }

    public int getItem(ItemVault aVault, Items anItem){
        return aVault.getItemQuantity(anItem);
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
     * Set the current maxHP to a value
     * @param value represents the maxHP to set
     */
    public void setmaxHP(int value) {
        this.maxhp=value;
    }

    /**
     * Gets the FP
     * @return the FP
     */
    public int getFP(){
        return this.fp;
    }

    /**
     * Gets the maxFP
     * @return the maxFP
     */
    public int getMaxFP(){
        return this.maxfp;
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
     * Sets the maxFP
     * @param value represents the value to set the maxFP
     */
    public void setmaxFP(int value) {
        this.maxfp=value;
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
        int current=getLvl();
        for(int i=current; i<lvl; i++){
            setmaxHP((int)(getMaxHP()*1.15));
            setHP((int)(getHP()*1.15));
            setmaxFP((int) (getMaxFP()*1.15));
            setFP((int) (getFP()*1.15));
            setAtk((int)(getAtk()*1.15));
            setDef((int)(getDef()*1.15));

        }
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
    public void attackEnemy(Enemies anEnemy, AttackType anAttack){
    }

}
