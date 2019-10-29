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
        int escolha = 0;
        
        switch (escolha) {
            case 0:
                Codifica teste = new Codifica("317425");
                teste.codificar("knowledge is power");

                System.out.println(teste.save.toString());
                System.out.println(teste.key.toString());

                System.out.println(teste.descodifica("317425"));
                break;
            case 1:
                Codifica teste2 = new Codifica("345");
                teste2.codificar("power");

                System.out.println(teste2.save.toString());
                System.out.println(teste2.key.toString());

                System.out.println(teste2.descodifica("345"));
                break;
        }
    }
}
