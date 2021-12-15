package com.example.aventurasdemarcoyluis.Controller;

/**
 * Class to see if the game is over
 */
public class Game {
    private int wincount = 0;

    /**
     * Checks if we already won
     * @return false if not
     */
    public boolean checkWin(){
        return wincount == 5;
    }

    /**
     * Gets the wincount
     * @return the wincount
     */
    public int getWincount(){
        return wincount;
    }

    /**
     * Sets the wincount
     * @param value represents the new wincount
     */
    public void setWincount(int value){
        wincount=value;
    }


}
