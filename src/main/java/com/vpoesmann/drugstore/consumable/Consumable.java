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
public abstract class Consumable {
    public abstract boolean use(Customer c);
}
