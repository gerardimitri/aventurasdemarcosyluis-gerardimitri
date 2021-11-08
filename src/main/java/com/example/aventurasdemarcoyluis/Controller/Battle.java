package com.example.aventurasdemarcoyluis.Controller;

import com.example.aventurasdemarcoyluis.Enemies.Boo;
import com.example.aventurasdemarcoyluis.Enemies.Enemies;
import com.example.aventurasdemarcoyluis.Enemies.Goomba;
import com.example.aventurasdemarcoyluis.Enemies.Spiny;
import com.example.aventurasdemarcoyluis.Entity.Entity;
import com.example.aventurasdemarcoyluis.Items.*;
import com.example.aventurasdemarcoyluis.Players.Luis;
import com.example.aventurasdemarcoyluis.Players.Marco;
import com.example.aventurasdemarcoyluis.Players.Players;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Class that represent a Battle and the actions taken in the game
 *
 *  @author Gerardo Trincado
 *  github: gerardimitri
 */

public class Battle extends AbstractGame {

    private int turn = 0;
    protected Players[] players;

    private static final ItemStar STAR = new ItemStar();
    private static final ItemHoneySyrup HONEYSYRUP = new ItemHoneySyrup();
    private static final ItemRedMushroom REDMUSHROOM = new ItemRedMushroom();

    private int enemynumber;
    private final ArrayList<Enemies> enemies = new ArrayList<>();

    private final ItemVault Vault = new ItemVault();

    /**
     * Constructor
     */
    public Battle() {
        super();
        players = new Players[2];
        generatePlayers();
        putEnemynumber(players[0]);
        generateVault();
        generateEnemies();
        BeginBattle();
    }

    /**
     * Subclasses should initialize everything
     */
    @Override
    protected void init() {
    }

    /**
     * Generates both players with initial stats
     */
    public void generatePlayers(){
        players[0]=new Marco(17,16,100,15,1);
        players[1]=new Luis(15,15,100,15,1);
    }

    /**
     * function to set a number of enemies according to the player lvl
     *
     * @param aPlayer represents the player of which we will get the lvl
     */
    public void putEnemynumber(Players aPlayer) {
        int lvl = aPlayer.getLvl();
        if (lvl == 1 || lvl == 2) {
            enemynumber = 3;
        } else if (lvl == 3 || lvl == 4) {
            enemynumber = 5;
        } else {
            enemynumber = 3;
        }
    }

    /**
     * Getter for the player
     * @param id represents the player id
     * @return the Player.
     */
    public Players getPlayer(int id){
        return players[id];
    }

    /**
     * Swaps the turn, goes like:
     * Marco
     * Luis
     * enemy_1
     * ...
     * enemy_n
     * Marco
     * ...
     */
    public void swapTurn() {
        int totalTurns=2+enemynumber;
        turn=(turn+1)%totalTurns;
        getTurn();
        //Salta el turno si esta KO.
        if(turn<2){
            Players aPlayer = getPlayerTurn(turn);
            if(aPlayer.checkKO()){
                swapTurn();
            }
        }
        else{
            Enemies anEnemy = getEnemyTurn(turn-2);
            if(anEnemy.checkKO()){
                swapTurn();
            }
        }
    }

    /**
     * Getter for the number of enemies
     * @return the enemynumber
     */
    public int getEnemynumber() {
        return enemynumber;
    }

    public int getTurnid(){
        return turn;
    }

    /**
     * Gets the current entity that is playing
     */
    public Entity getTurn(){
        if(turn<2){
            return getPlayerTurn(turn);
        }
        else{
            return getEnemyTurn(turn-2);
        }
    }


    /**
     * Gets the entity thats playing the next turn
     */
    public Entity getNextTurn(){
        int totalTurns=2+enemynumber;
        int turn2=(turn+1)%totalTurns;
        if(turn2<2){
            return getPlayerTurn(turn2);
        }
        else{
            return getEnemyTurn(turn2-2);
        }
    }

    /**
     * @param turn refers to current turn
     * @return the entity of the current turn
     */
    public Players getPlayerTurn(int turn){
        return players[turn];
    }

    /**
     * @param turn refers to current turn
     * @return the entity of the current turn
     */
    public Enemies getEnemyTurn(int turn){
        return enemies.get(turn);
    }

    /**
     * Generates enemies according to the number required
     */
    public void generateEnemies() {
        Enemies anEnemy;
        for (int i = 0; i < enemynumber; i++) {
            int random = (int) Math.floor(Math.random() * (3 - 1 + 1) + 1);
            if (random == 1) {
                anEnemy=generateGOOMBA();
                enemies.add(anEnemy);
            } else if (random == 2) {
                anEnemy=generateBOO();
                enemies.add(anEnemy);
            } else {
                anEnemy=generateSPINY();
                enemies.add(anEnemy);
            }
        }
    }

    /**
     * Gets the number of enemies through array size
     * @return the number of enemies
     */
    public int getEnemyArrayNumber(){
        return enemies.size();
    }

    /**
     * Gets an enemy from the enemy arrayList
     * @param id indicates the enemyid
     * @return the enemy.
     */
    public Enemies getEnemy(int id){
        return enemies.get(id);
    }


    /**
     * Initializes the vault with level 1
     */
    public void generateVault(){
        Vault.addItem(REDMUSHROOM, 3);
        Vault.addItem(HONEYSYRUP, 3);
    }

    public ItemVault getVault(){
        return Vault;
    }

    /**
     * generates a GOOMBA enemy
     */
    public Goomba generateGOOMBA() {
        Goomba GOOMBA = new Goomba(2, 4, 15, 1);
        return GOOMBA;
    }

    /**
     * generates a BOO enemy
     */
    public Boo generateBOO() {
        Boo BOO = new Boo(5, 9, 3, 1);
        return BOO;
    }

    /**
     * Generates a SPINY enemy
     */
    public Spiny generateSPINY(){
        Spiny SPINY = new Spiny(4,10,6,1);
        return SPINY;
    }

    /**
     * Resets player HP and FP to begin the battle!
     */
    public void BeginBattle(){
        for(Players player: players){
            player.setHP(player.getMaxHP());
            player.setFP(player.getMaxFP());
        }
    }

    /**
     * checks if all the enemies are KO'd
     * @return true if they are
     */
    public boolean checkWin(){
        int count = 0;
        for(int i = 0; i<enemynumber; i++){
            if(enemies.get(i).checkKO()){
                count++;
            }
        }
        return (count == enemynumber);
    }

    /**
     * Allows player to choose an action, this wont be implemented as of today
     * @param anAction represents the chosen action
     * @throws IOException
     *//*
    public void SelectAction(Actions anAction) throws IOException {
        anAction.Action(this, anAction);
    }

    *//**
     * What happens when an ATTACK is chosen as an action
     * @param reader represents the input reader
     * @throws IOException
     *//*
    public void ActionAttack(BufferedReader reader) throws IOException {
        try {
            System.out.println("¿A que enmigo desea atacar? indique numero");
            String input = reader.readLine();

            this.swapTurn();
        }
        catch (IOException e) {
        }
    }

    *//**
     * What happens when an ITEM is chosen as an action
     * @param reader represents the input reader
     * @throws IOException
     *//*
    public void ActionItem(BufferedReader reader) throws IOException {
        try {
            System.out.println("¿Qué item desea usar?(STAR, REDMUSHROOM, HONEYSYRUP)");
            String input = reader.readLine();

            if (input == "STAR") {
                players[turn].useItem(Vault, STAR);
            } else if (input == "REDMUSHROOM") {
                players[turn].useItem(Vault, REDMUSHROOM);
            } else if (input == "HONEYSYRUP") {
                players[turn].useItem(Vault, HONEYSYRUP);
            } else {
            }
            this.swapTurn();
        }
        catch (IOException e) {
        }
    }

    *//**
     * PASS the turn
     *//*
    public void ActionPass(){
        this.swapTurn();
    }*/

    /**
     * Checks if the game is over
     * @return
     */
    public boolean notOver() {
        int count2 = 0;
        for(Players player : players){
            if(player.checkKO()){
                count2++;
            }
        }

        return !(checkWin() || (count2 == 2));
    }
}
