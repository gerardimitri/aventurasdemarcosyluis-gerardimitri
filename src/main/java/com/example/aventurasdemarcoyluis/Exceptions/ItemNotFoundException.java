package com.example.aventurasdemarcoyluis.Exceptions;

/**
 * Exception if the item is not in the Vault
 */
public class ItemNotFoundException extends Exception {
    public ItemNotFoundException(final String message){
        super(message);
    }
}
