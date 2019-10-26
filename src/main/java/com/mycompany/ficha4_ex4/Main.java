/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ficha4_ex4;

/**
 *
 * @author vitor
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws EmptyCollectionException {
        // TODO code application logic here
        Codifica teste = new Codifica("53174");
        System.out.println(teste.key.toString());
        teste.codificar("power");
        System.out.println(teste.save.toString());
    }
    
}
