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
import java.util.Locale;

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
        effects = new ArrayList<>();
        
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
    
    public void hurt(int amount) {
        hp -= amount;
        if (hp <= 0) {
            hp = 0;
        }
    }
    
    public boolean isDead() {
        return hp <= 0;
    }
    
    public void pay(int amount) {
        gold -= amount;
    }
    
    public void addToInventory(Consumable c) {
        inventory.add(c);
    }
    
    public List<Consumable> getInventory() {
        return inventory;
    }
    
    public int getInventorySize() {
        return inventory.size();
    }
    
    public void useItem(int itemId) {
        Consumable c = inventory.get(itemId);
        
        try {
            c.use(this);
            inventory.remove(itemId);
        } catch (CannotConsumeException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public String toString() {
        String result = String.format(Locale.FRANCE, "HP : %d/%d\nMP : %d/%d\n", hp, maxHp, mp, maxMp);
        
        for (Effect e : effects) {
            result += e;
            result += "\n";
        }
        
        return result;
    }

    public void nextTurn() {       
        int i = 0;
        while (i < effects.size()) {
            Effect e = effects.get(i);
            e.apply(this);
            if (!e.isStillRunning()) {
                effects.remove(e);
            } else {
                i++;
            }
        }
    }

    public void addEffect(Effect e) {
        effects.add(e);
    }
}
