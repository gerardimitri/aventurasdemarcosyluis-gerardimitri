package com.example.aventurasdemarcoyluis;

public abstract class AbstractItem {
    public int quantity;

    public AbstractItem(int QUANTITY){
        quantity=QUANTITY;
    }

    public int getQuantity(){
        return quantity;
    }

    public void setQuantity(int quantity1){
        this.quantity=quantity1;
    }

}


