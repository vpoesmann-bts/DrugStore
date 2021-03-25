/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.drugstore.effect;

import com.vpoesmann.drugstore.Customer;

/**
 *
 * @author sogeking
 */
public abstract class Effect {
    protected String name;
    protected int nbTurns;
    
    public int getNbTurns() {
        return nbTurns;
    }
    
    public String getName() {
        return name;
    }
    
    public abstract void apply(Customer c);
}
