package com.example.aventurasdemarcoyluis.Items;

import com.example.aventurasdemarcoyluis.AbstractItem;

public class ItemHoneySyrup extends AbstractItem {
    public ItemHoneySyrup(int QUANTITY){
        super(QUANTITY);
    }

    public void useItem(){
        if(this.quantity>0){
            setQuantity(this.quantity-1);
        }
    }
}
