package com.zipcodewilmington.singlylinkedlist;

import java.util.Comparator;
import java.util.Currency;
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

    public SinglyLinkedList<E> sort() {
        Node current = head;
        Node next = null;
        E temp;

        //bubble sort
        while (current != null) {
            next = current.next;

            while (next != null) {
                if (compareTo((E)current.data, (E)next.data) > 0) {
                    temp = (E)current.data;
                    current.data = next.data;
                    next.data = temp;
                }
                next = next.next;
            }
            current = current.next;
        }

        SinglyLinkedList<E> sortedList = new SinglyLinkedList<E>();
        Node newCurrent = head;
        while (newCurrent != null) {
            sortedList.add((E) newCurrent.data);
            newCurrent = newCurrent.next;
        }
        return sortedList;

    }

    public int compareTo(E data, E data1) {
        return data.compareTo(data1);
    }


    /*
    1. Traverse the list from head to tail, keeping track of the current node and the previous node.
    2. For each node, set the next pointer to point to the previous node.
    3. Set the head pointer to point to the last node in the list (which is now the first node).
     */
    public SinglyLinkedList<E> reverse() {
        Node current = head;
        Node prev = null;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;

        SinglyLinkedList<E> reversedList = new SinglyLinkedList<E>();
        Node newCurrent = head;
        while (newCurrent != null) {
            reversedList.add((E) newCurrent.data);
            newCurrent = newCurrent.next;
        }
        return reversedList;
    }

    public SinglyLinkedList<E> splice(int startIndex, int endIndex) {
        Node current = head;
        SinglyLinkedList<E> splicedList = new SinglyLinkedList<E>();
        for (int i = startIndex; i < endIndex; i++) {
            current = current.next;
            splicedList.add((E)current.data);
        }
        return splicedList;
    }
}