package com.example.aventurasdemarcoyluis.Items;

import com.example.aventurasdemarcoyluis.Players.Players;

public class ItemHoneySyrup extends AbstractItems {
    public ItemHoneySyrup(){
    }

    @Override
    public void useItem(Players aPlayer){
            aPlayer.setFP(aPlayer.getFP()+3);
        }

}
