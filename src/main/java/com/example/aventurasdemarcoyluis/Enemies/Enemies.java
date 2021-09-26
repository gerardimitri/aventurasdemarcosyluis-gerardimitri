package com.example.aventurasdemarcoyluis.Enemies;

public class Enemies {
    private int atk;
    private int def;
    private int hp;
    private int lvl;
    private final int maxhp;
    private final EnemyType type;

    /**
     * Creates a new Enemy
     * @param ATK attack points
     * @param DEF defense points
     * @param HP  heal points
     * @param LVL level of the Unit
     *
     */
    public Enemies(int ATK, int DEF, int HP, int LVL, EnemyType t ){
        atk=ATK;
        def=DEF;
        hp=HP;
        lvl=LVL;
        type=t;
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
     * @param def represents the new def.
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
     * Gets the type of enemy.
     * @return the type.
     */
    public EnemyType getType() {
        return type;
    }

    /**
     * Boolean thats serves to compare if enemies are the same.
     * @param o represents an Object to compare.
     * @return boolean true if they are the same, false if not.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Enemies enemies)) {
            return false;
        }
        return atk == enemies.atk && def == enemies.def && hp == enemies.hp && lvl == enemies.lvl;
    }


}
