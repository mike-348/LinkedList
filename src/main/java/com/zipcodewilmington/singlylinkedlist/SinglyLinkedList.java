package com.zipcodewilmington.singlylinkedlist;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by leon on 1/10/18.
 */

public class SinglyLinkedList<E extends Comparable<E>> {
    List<String> linkedlist = new LinkedList<String>();

    class Node<E> {
        E data;
        Node<E> next;

        public Node(E element) {
            this.data = element;
            this.next = null;
        }
    }

    public Node head = null;
    public Node tail = null;

    public void add(E data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Integer size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public Integer find(E data) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    public void remove(E data) {
        Node current = head;
        Node last = head;

        while (current != null) {
            if (current.data == data) {
                last.next = current.next;
            }
            last = current;
            current = current.next;
        }
    }

    public boolean contains(E data) {
        return find(data) != -1;
    }

    public E getElementAtIndex(Integer index) {
        Integer runningIndex = 0;
        Node current = head;
        if (index > size()) {
            return null;
        }
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return (E) current.data;
    }

    public void display() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data + "");
            current = current.next;
        }
    }

    public SinglyLinkedList<E> copy() {
        SinglyLinkedList sl = new SinglyLinkedList();
        Node current = head;
        while (current != null) {
            sl.add((E)current.data);
            current = current.next;
        }
        return sl;
    }

    public void sort() {
        Node current = head;

    }

}