package com.example.aventurasdemarcoyluis.Controller;

/**
 * Class that represent an Abstract Game Controller
 *
 *  @author Gerardo Trincado
 *  github: gerardimitri
 */
public abstract class AbstractGame {
    public AbstractGame() {
        this.init();
    }

    /**
     * Subclasses should initialize everything
     */
    protected abstract void init();

}
