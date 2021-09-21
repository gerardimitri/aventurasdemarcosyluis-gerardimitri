package com.example.aventurasdemarcoyluis.Items;

import com.example.aventurasdemarcoyluis.AbstractItem;

public class ItemStar extends AbstractItem {
    public ItemStar(int QUANTITY){
        super(QUANTITY);
    }

    public void useItem(){
        if(this.quantity>0){
            setQuantity(this.quantity-1);

        }
    }
}
