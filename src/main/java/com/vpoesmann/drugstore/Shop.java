/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.drugstore;

import com.vpoesmann.drugstore.consumable.Apple;
import com.vpoesmann.drugstore.consumable.Consumable;
import com.vpoesmann.drugstore.consumable.PoisonVial;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sogeking
 */
public class Shop {
    
    private List<Consumable> items;
    
    public Shop() {
        items = new ArrayList<>();
        items.add(new Apple());
        items.add(new PoisonVial());
        
    }

    public List<Consumable> getItems() {
        return items;
    }
    
    public int getItemsSize() {
        return items.size();
    }
    
    public boolean buy(int itemId, Customer c) {
        int itemCost = items.get(itemId).getPrice();
        if (c.getGold() < itemCost) {
            return false;
        }
        
        c.pay(itemCost);
        c.addToInventory(items.get(itemId));
        return true;
    }
}
