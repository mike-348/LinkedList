package com.zipcodewilmington.singlylinkedlist;

import org.junit.Assert;
import org.junit.Test;

import java.lang.annotation.Target;
import java.util.Comparator;

/**
 * Created by leon on 1/10/18.
 */
public class SinglyLinkedListTest {

    @Test
    public void addTest() {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.add(1);
        sl.add(100);
        Assert.assertEquals(2, (int) sl.size());
    }

    @Test
    public void findTest() {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.add("apple");
        sl.add("pear");
        sl.add("peach");

        Assert.assertEquals(2, (int) sl.find("peach"));
    }

    @Test
    public void removeTest() {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.add(2);
        sl.add(100);
        sl.add(1000);

        sl.remove(100);

        Assert.assertEquals(null, sl.getElementAtIndex(3));
        Assert.assertEquals(1, (int) sl.find(1000));

    }

    @Test
    public void containsTest() {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.add(2);
        sl.add(4);
        sl.add(6);
        sl.add(8);

        Assert.assertTrue(sl.contains(4));
        Assert.assertFalse(sl.contains(7));
    }

    @Test
    public void sizeTest() {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.add("judge judy");
        sl.add("dr mike");
        sl.add("dr phil");
        sl.add("dr oz");
        sl.add("mr clean");

        Assert.assertEquals(5, (int) sl.size());
    }

    @Test
    public void copyTest() {
        SinglyLinkedList sl = new SinglyLinkedList();
        sl.add("judge judy");
        sl.add("dr mike");
        sl.add("dr phil");
        sl.add("dr oz");
        sl.add("mr clean");

        SinglyLinkedList slCopy = sl.copy();

        Assert.assertEquals(sl.size(), slCopy.size());
        for (int i = 0; i < sl.size(); i++) {
            Assert.assertTrue(sl.getElementAtIndex(i) == (slCopy.getElementAtIndex(i)));
        }
    }


}
