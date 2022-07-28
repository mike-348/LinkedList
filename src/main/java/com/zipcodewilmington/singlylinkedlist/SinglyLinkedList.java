package com.zipcodewilmington.singlylinkedlist;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by leon on 1/10/18.
 */

public class SinglyLinkedList<E> {
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

    public void addNode(E data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public Integer getIndex(E data) {
        int index = 0;
        Node current = head;
        while (current != head) {
            if (current.data == data) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
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

    public boolean contains(E data) {
        return getIndex(data) != -1;
    }



//    public void removeNode(int index) {
//        Node current = head;
//        Node prev = null;
//        int i = 0;
//
//        if (current != null && index == 0) {
//            head = current.next;
//        }
//
//        while (current != null && index != i) {
//            prev = current;
//            current = current.next;
//            i++;
//        }
//
//        prev.next = current.next;
//
//    }
//
//    public E unlink(Node<E> x) {
//        // assert x != null;
//        Node<E> first;
//        Node<E> last;
//        int size = 0;
//        int modCount = 0;
//
//        E element = x.item;
//        Node<E> next = x.next;
//        Node<E> prev = x.prev;
//
//        if (prev == null) {
//            first = next;
//        } else {
//            prev.next = next;
//            x.prev = null;
//        }
//
//        if (next == null) {
//            last = prev;
//        } else {
//            next.prev = prev;
//            x.next = null;
//        }
//
//        x.item = null;
//        size--;
//        modCount++;
//        return element;
//    }
//
//    Node<E> getNodeAtIndex(int index) {
//        Node first = head;
//        Node last = tail;
//        int size = 0;
//
//        if (index < (size >> 1)) {
//            Node<E> x = first;
//            for (int i = 0; i < index; i++)
//                x = x.next;
//            return x;
//        } else {
//            Node<E> x = last;
//            for (int i = size - 1; i > index; i--)
//                x = x.prev;
//            return x;
//        }
//    }
//    public E removeAtIndex(int index) {
//        return unlink(getNodeAtIndex(index));
//    }
//
//    public int getIndexOfNode(Object o) {
//        Node first = head;
//        int index = 0;
//        if (o == null) {
//            for (Node<E> x = first; x != null; x = x.next) {
//                if (x.item == null)
//                    return index;
//                index++;
//            }
//        } else {
//            for (Node<E> x = first; x != null; x = x.next) {
//                if (o.equals(x.item))
//                    return index;
//                index++;
//            }
//        }
//        return -1;
//    }
//
//    public boolean contains(Object o) {
//        return getIndexOfNode(o) != -1;
//    }
//
//    public int size() {
//        int count = 0;
//
//    }

}