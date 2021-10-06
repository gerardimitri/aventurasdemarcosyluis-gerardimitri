package com.example.aventurasdemarcoyluis.Enemies;

import com.example.aventurasdemarcoyluis.Players.Players;

/**
 * Class that represent an Abstract Enemy in the game
 *
 *  @author Gerardo Trincado
 *  github: gerardimitri
 */
public abstract class AbstractEnemies implements Enemies{
    private int atk;
    private int def;
    private int hp;
    private int lvl;
    private final int maxhp;

    /**
     * Creates a new Enemy
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param LVL level of the Unit
     *
     */
    public AbstractEnemies(int ATK, int DEF, int HP, int LVL){
        atk=ATK;
        def=DEF;
        hp=HP;
        lvl=LVL;
        maxhp=HP;
    }

    /**
     * Gets the atk.
     * @return the atk.
     */
    public int getAtk() {
        return atk;
    }

    /**
     * Sets the atk.
     * @param atk represents the new atk.
     */
    public void setAtk(int atk) {
        this.atk = atk;
    }

    /**
     * Gets the Def.
     * @return the def.
     */
    public int getDef() {
        return def;
    }

    /**
     * Sets the def.
     * @param def represents the new defense.
     */
    public void setDef(int def) {
        this.def = def;
    }

    /**
     * Gets the HP.
     * @return the hp.
     */
    public int getHp() {
        return hp;
    }

    /**
     * Gets the maxHP.
     * @return the maxHP.
     */
    public int getMaxHP(){
        return this.maxhp;
    }

    /**
     * Sets the HP.
     * @param value represents the new HP.
     */
    public void setHp(int value) {
        if( value < 0) {
            this.hp=0;
        }
        else this.hp = Math.min(value, this.maxhp);
    }

    /**
     * getLvl.
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
     * Checks if the enemy is KO'd
     * @return True if enemy is KO'd
     */
    public boolean checkKO(){
        return this.hp == 0;
    }

    /**
     * Attacks a Player
     * @param aPlayer represents the player attacked
     */
    public void attackPlayer(Players aPlayer){
        double damage = 0.75*(double)this.getAtk()*((double)this.getLvl() / (double)aPlayer.getDef());
        if(damage%1>0.5){
            damage++;
        }
        aPlayer.setHP(aPlayer.getHP()-(int)damage);
    }



}
