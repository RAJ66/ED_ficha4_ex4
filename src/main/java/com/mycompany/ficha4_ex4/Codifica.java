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
    public CircularArrayQueue<Character> save;
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
                key.enqueue(k);
                
                //passagem
                int ch = (int) textoArray[i];
                ch = ch + k;

                char c;
                c = (char) ch;

                this.save.enqueue(c);

            }
            return true;

        }
    }

    public String descodifica(String key) throws EmptyCollectionException {
        while (!this.key.isEmpty()) {            
            this.key.dequeue();
        }
        passarKey(key);

        char[] resultado = new char[this.save.size()];
        

       
        
        int tmp =0;
        while (!this.save.isEmpty()) {            
           char c = this.save.dequeue();
            int ch = (int) c;

            int k = this.key.dequeue();
            this.key.enqueue(k);
            ch = ch - k;

            resultado[tmp] = (char) ch;
            tmp++;
        }

        String string = new String(resultado);
        return string;
    }

}
