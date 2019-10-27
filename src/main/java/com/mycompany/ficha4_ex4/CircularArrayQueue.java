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

    /**
     * constant to represent the default capacity of the queue
     */
    private final int DEFAULT_CAPACITY = 5;
    /**
     * int that represents the first element of the queue
     */
    private int front;
    /**
     * int that represents the next available position in the queue
     */
    private int rear;
    /**
     * int that represents the number of elements
     */
    private int count;
    /**
     * array of generic elements to represent the queue
     */
    private T[] queue;

    /**
     * Creates an empty queue using the default capacity.
     */
    public CircularArrayQueue() {
        front = 0;
        rear = 0;
        count = 0;
        queue = (T[]) (new Object[DEFAULT_CAPACITY]);
    }

    /**
     * Creates an empty queue using the specified capacity.
     *
     * @param initialCapacity represents the specified capacity
     */
    public CircularArrayQueue(int initialCapacity) {
        front = 0;
        rear = 0;
        count = 0;
        queue = (T[]) (new Object[initialCapacity]);
    }

    /**
     * Adds one element to the rear of this queue.
     *
     * @param element the element to be added to the rear of this queue
     */
    @Override
    public void enqueue(T element) {
        if (this.count == this.queue.length) {
            expandCapacity();
        }
        this.queue[this.rear] = element;
        this.rear = (this.rear + 1) % this.queue.length;
        this.count++;
    }

    /**
     * Removes and returns the element at the front of this queue.
     *
     * @return the element at the front of this queue
     */
    @Override
    public T dequeue() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia");
        }
        T current = this.queue[this.front];
        this.queue[this.front] = null;
        this.front = (this.front + 1) % this.queue.length;
        this.count--;
        return current;

    }

    /**
     * Expands the capacity of this queue
     */
    private void expandCapacity() {
        T[] newQueue = (T[]) (new Object[this.queue.length * 2]);

        int t = this.front;
        for (int i = 0; i < this.size(); i++) {
            newQueue[i] = this.queue[t];
            t = (t + 1) % this.queue.length;
        }

        this.front = 0;
        this.rear = this.count;
        this.queue = newQueue;
    }

    /**
     * Returns without removing the element at the front of this queue.
     *
     * @return the first element in this queue
     */
    @Override
    public T first() throws EmptyCollectionException {
        if (this.isEmpty()) {
            throw new EmptyCollectionException("Lista Vazia!");
        }
        return this.queue[this.front];

    }

    /**
     * Returns true if this queue contains no elements.
     *
     * @return true if this queue is empty
     */
    @Override
    public boolean isEmpty() {
        if (this.count == 0) {
            return true;
        }
        return false;

    }

    /**
     * Returns the number of elements in this queue.
     *
     * @return the integer representation of the size of this queue
     */
    @Override
    public int size() {
        return this.count;
    }

    /**
     * Returns a string representation of this queue.
     *
     * @return the string representation of this queue
     */
    @Override
    public String toString() {
        int t = this.front;
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

        for (int i = 0; i < this.size(); i++) {
            str.append(this.queue[t]);
            str.append("\n");
            t = (t + 1) % this.queue.length;
        }
        return str.toString();
    }

}
