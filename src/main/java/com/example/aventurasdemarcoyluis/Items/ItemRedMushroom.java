package com.example.aventurasdemarcoyluis.Items;

import com.example.aventurasdemarcoyluis.Players.Players;

public class ItemRedMushroom extends AbstractItems {
    public ItemRedMushroom(){
    }

    @Override
    public void useItem(Players aPlayer){
            aPlayer.setHP((int)(aPlayer.getHP()+aPlayer.getMaxHP()*0.1));
    }
}
