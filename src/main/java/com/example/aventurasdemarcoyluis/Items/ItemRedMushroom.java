package com.example.aventurasdemarcoyluis.Items;

import com.example.aventurasdemarcoyluis.AbstractItem;

public class ItemRedMushroom extends AbstractItem {
    public ItemRedMushroom(int QUANTITY){
        super(QUANTITY);
    }

    public void useItem(){
        if(this.quantity>0){
            setQuantity(this.quantity-1);
        }
    }
}
