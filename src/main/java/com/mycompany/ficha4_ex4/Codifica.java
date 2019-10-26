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
public class Codifica {

    //depois meter private
    public CircularArrayQueue<String> save;
    public CircularArrayQueue<Integer> key;

    public Codifica(String key) {
        this.save = new CircularArrayQueue<>();
        this.key = new CircularArrayQueue<>();

        passarKey(key);
    }

    private void passarKey(String key) {
        char[] keyArray = key.toCharArray();
        for (int i = 0; i < key.length(); i++) {
            this.key.enqueue(Character.getNumericValue(keyArray[i]));
        }
    }

    public boolean codificar(String texto) throws EmptyCollectionException {
        if (texto == null) {
            return false;
        } else {
            char[] textoArray = texto.toCharArray();

            for (int i = 0; i < texto.length(); i++) {
                int k = key.dequeue();

                //passagem
                int ch = (int) textoArray[i];
                ch = ch + k;

                char c;
                c = (char) ch;

                String add = "" + c;
                this.save.enqueue(add);

            }
            return true;

        }
    }
    
    
    
}
