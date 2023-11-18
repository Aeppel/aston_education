package com.pervishko.arraylist;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.pervishkond.arraylist.MyArrayList;

public class MyArrayListTest {

    private MyArrayList<Integer> firstList = new MyArrayList<>();
    private MyArrayList<Integer> secondList = new MyArrayList<>();
    private MyArrayList<Integer> thirdList = new MyArrayList<>();

    @BeforeEach
    void init() {
        firstList.add(15);
        firstList.add(7);
        firstList.add(24);
        firstList.add(22);

        thirdList.add(5);
        thirdList.add(78);
        thirdList.add(33);
        thirdList.add(60);
    }

    @Test
    void add() {
        firstList.add(55);
        assertEquals(firstList.get(firstList.getSize()-1), 55);
    }

    @Test
    void addAll() {
        secondList.addAll(thirdList);
        assertEquals(secondList.get(secondList.getSize()-1), thirdList.get(thirdList.getSize()-1));
        assertEquals(secondList.getSize(), thirdList.getSize());

    }

    @Test
    void get() {
        assertEquals(firstList.get(0), 15);
        assertEquals(thirdList.get(2), 33);
    }

    @Test
    void removeUsingIndex(){
        assertEquals(firstList.get(2), 24);
        firstList.remove(2);
        assertEquals(firstList.get(2), 22);
    }

    @Test
    void removeUsingElement(){
        assertEquals(firstList.get(2), 24);
        firstList.remove((Integer) 24);
        assertEquals(firstList.get(2), 22);
    }

    @Test
    void size(){
        assertEquals(firstList.getSize(),4);
    }


}
