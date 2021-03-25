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
    private int maxHp;
    private int mp;
    private int maxMp;

    private List<Effect> effects;
    
    public Customer() {
        gold = 500;
        inventory = new ArrayList<>();
        
        maxHp = 100;
        maxMp = 100;
        hp = maxHp;
        mp = maxMp;
    }
    
    public int getGold() {
        return gold;
    }

    public boolean hasFullHP() {
        return hp == maxHp;
    }

    public void heal(int amount) {
        hp += amount;
        if (hp > maxHp) {
            hp = maxHp;
        }
    }
    
    public void pay(int amount) {
        gold -= amount;
    }
    
    public void addToInventory(Consumable c) {
        inventory.add(c);
    }
}
