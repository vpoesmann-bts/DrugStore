/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.drugstore.consumable;

import com.vpoesmann.drugstore.Customer;

/**
 *
 * @author sogeking
 */
public class Apple extends Consumable {
    private static final int HEAL_AMOUNT = 10;
    
    public Apple() {
        super(5, "Apple");
    }
    
    @Override
    public boolean use(Customer c) {
        if (c.hasFullHP()) {
            return false;
        }
        
        c.heal(HEAL_AMOUNT);
        return true;
    }
}
