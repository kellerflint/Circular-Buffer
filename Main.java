package com.company;

public class Main {

    public static void main(String[] args) {
        ListArray<Integer> list = new ListArray<>();

        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addFirst(-1);
        list.addFirst(-2);
        list.addFirst(-3);
        list.removeLast();
        list.removeLast();
        list.removeLast();
        list.removeLast();

        while (list.size() > 0) {
            System.out.println(list.removeFirst());
        }

    }
}
