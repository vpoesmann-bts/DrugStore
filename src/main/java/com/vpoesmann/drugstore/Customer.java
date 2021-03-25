/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.drugstore;

import com.vpoesmann.drugstore.consumable.Consumable;
import com.vpoesmann.drugstore.effect.Effect;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sogeking
 */
public class Customer {
    
    private List<Consumable> inventory;
    private int gold;

    private int hp;
    private int mp;

    private List<Effect> effects;
    
    public Customer() {
        gold = 500;
        inventory = new ArrayList<>();
    }
    
    public int getGold() {
        return gold;
    }
}
