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
public class CircularArrayQueue<T> implements QueueADT<T> {

    private final int DEFAULT_CAPACITY = 2;
    private int front;
    private int rear;
    private T[] queue;
    private int count;

    public CircularArrayQueue() {
        this.front = 0;
        this.rear = 0;
        this.count = 0;
        this.queue = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    public CircularArrayQueue(int initialCapacity) {
        this.front = 0;
        this.rear = 0;
        this.count = 0;

        this.queue = (T[]) (new Object[initialCapacity]);
    }

    @Override
    public void enqueue(T element) {
        //v2
        if (this.count == this.queue.length) {
            expandCapacity();
        }
        this.queue[this.rear] = element;
        this.rear = (this.rear + 1) % this.queue.length;
        this.count++;
    }

    private void expandCapacity() {
        T[] newQueue = (T[]) (new Object[this.queue.length * 2]);

        int t = this.front;
        for (int i = 0; i < this.size(); i++) {
            newQueue[i]=this.queue[t];
            t = (t + 1) % this.queue.length;
        }
        
        this.front=0;
        this.rear = this.count;
        
        this.queue = newQueue;
        
    }

    @Override
    public T dequeue() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Nao tem");
        }
        T current = this.queue[this.front];
        this.queue[this.front] = null;
        this.front = (this.front + 1) % this.queue.length;
        this.count--;
        return current;
    }

    @Override
    public T first() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Nao tem");

        } else {
            return this.queue[this.front];
        }
    }

    @Override
    public boolean isEmpty() {
        if (this.count == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override

    public String toString() {

        StringBuilder str = new StringBuilder();
        str.append("Front: ");
        str.append("Conteudo: ");
        str.append(this.queue[this.front]);
        str.append("|");
        str.append("Posição: ");
        str.append(this.front);
        str.append("\n");
        str.append("Rear: ");
        str.append("Conteudo: ");
        str.append(this.queue[this.rear]);
        str.append("|");
        str.append("Posição: ");
        str.append(this.rear);
        str.append("\n");
        str.append("Tamanho: ");
        str.append(this.size());
        str.append("\n");
        str.append("Tamanho Stack: ");
        str.append(this.queue.length);
        str.append("\n");

        int t = this.front;
        for (int i = 0; i < this.size(); i++) {
            str.append(this.queue[t]);
            str.append("\n");
            t = (t + 1) % this.queue.length;
        }
        return str.toString();
    }

}
