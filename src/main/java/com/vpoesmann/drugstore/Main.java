/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vpoesmann.drugstore;

import java.util.Scanner;

/**
 *
 * @author sogeking
 */
public class Main {
    
    private static final String menuMsg = "Tapez un nombre pour choisir une option";
    private static Scanner sc;
    
    public static void main(String[] args) {
        Customer c = new Customer();
        sc = new Scanner(System.in);
        
        boolean left = false;
        
        while(!left) {
            
            printMenu();
            
            int choix;
            
            try {
                choix = askForNumber(1, 3);
            } catch (BadChoiceException e) {
                System.out.println("Choix non reconnu");
                continue;
            }
            
            left = true;
        }
    }
    
    public static void printMenu() {
        System.out.println(menuMsg);
        System.out.println("1. Boutique");
        System.out.println("2. Inventaire");
        System.out.println("3. Passer le tour");
        
    }
    
    public static int askForNumber(int min, int max) throws BadChoiceException {
        int choix;
        
        try {
            String choixStr = sc.nextLine();
            choix = Integer.parseInt(choixStr);
        } catch (NumberFormatException e) {
            throw new BadChoiceException(String.format(""), e);
        }
        
        if (choix < min || choix > max) {
            throw new BadChoiceException("");
        }
        
        return choix;
    }
}
