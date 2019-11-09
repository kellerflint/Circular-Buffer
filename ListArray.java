package com.company;

import java.util.NoSuchElementException;

public class ListArray<T> {
    private T[] list;
    private int size; // current number of elements in array
    private int first; // first index
    private int last; // last index

    public ListArray() {
        list = (T[]) new Object[10];
        size = 0;
        first = 0;
        last = 0;
    }

    // Adds item to the back of the list
    public void addLast(T item) {
        ensureCapacity();
        if (size == 0) {
            list[last] = item;
        } else {
            int nextIndex = (last + 1) % list.length;
            list[nextIndex] = item;
            last = nextIndex;
        }
        size++;
    }

    // Removes item from the back of the list
    public T removeLast() {
        T temp;
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            int previousIndex = mod(last - 1, list.length);
            temp = list[last];
            last = previousIndex;
            size--;
        }
        return temp;
    }

    // Adds item to the front of the list
    public void addFirst(T item) {
        ensureCapacity();
        if (size == 0) {
            list[first] = item;
        } else {
            int previousIndex = mod(first - 1, list.length) ;
            list[previousIndex] = item;
            first = previousIndex;
        }
        size++;

    }

    // Removes item from the front of the list
    public T removeFirst() {
        T temp;
        if (size == 0) {
            throw new NoSuchElementException();
        } else {
            int nextIndex = (first + 1) % list.length;
            temp = list[first];
            first = nextIndex;
            size--;
        }
        return temp;
    }

    public int size() {
        return size;
    }

    // returns new array with twice the capacity
    private T[] resize() {
        T[] new_list = (T[]) new Object[size * 2];
        int current_index = 0;

        for (int i = first; i != last; i++) {
            new_list[current_index] = list[i];
            current_index++;
        }
        new_list[current_index] = list[last];
        return new_list;
    }

    private void ensureCapacity() {
        if (size == list.length) {
            list = resize();
        }
    }

    // mod function borrowed from StackOverflow because WHY DOESN'T THE THING CALLED MOD ACTUALLY MOD?
    // https://stackoverflow.com/questions/90238/whats-the-syntax-for-mod-in-java
    private int mod(int x, int y)
    {
        int result = x % y;
        return result < 0? result + y : result;
    }

}
