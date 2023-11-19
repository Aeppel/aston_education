package com.pervishkond.arraylist;

import java.util.Arrays;
import java.util.Comparator;

public class MyArrayList<E> {
    private Object[] array;
    private Object[] newArray;
    private int size = 0;


    public MyArrayList() {
        array = new Object[1];
    }

    public void add(E e) {
        if (array[array.length - 1] != null) {
            add(this.getSize(), e);
        } else {
            array[getSize()] = e;
            size++;
        }
    }

    public void add(int index, E e) {
        if (index > size) {
            array[getSize()] = e;
        } else {
            newArray = new Object[array.length + 1];
            for (int j = 0; j < array.length; j++) {
                newArray[j] = array[j];
            }
            for (int i = array.length; i < newArray.length; i++) {
                newArray[i] = e;
            }
            array = newArray.clone();
        }
        size++;
    }

    public void addAll(MyArrayList<? extends E> otherArrayList) {
        Object[] newArray = new Object[getSize() + otherArrayList.getSize()];
        System.arraycopy(array, 0, newArray, 0, array.length - 1);
        System.arraycopy(otherArrayList.array, 0, newArray, array.length - 1, otherArrayList.getSize());
        array = newArray.clone();
        size += otherArrayList.getSize();
    }


    public void remove(int index) {
        size--;
        array[index] = 0;
        int remove = index;
        replaceNull(remove);
        array[array.length - 1] = null;// возможно было бы проще написать метод System.arraycopy
    }

    public void remove(E e) {
        size--;
        for (int i = 0; i < array.length; i++) {
            if (e.equals(array[i])) {
                array[i] = 0;
                int remove = i;
                replaceNull(remove);
            }
        }
    }

    public int getSize() {
        return size;
    }

    public E get(int index) {
        if (index > getSize()) {
            return null;
        }
        return (E) array[index];
    }

    public void clear() {
        for (int i = 0; i < getSize(); i++) {
            array[i] = null;
        }
    }

    public boolean isEmpty() {
        return getSize() == 0;
    }

    public void sort(Comparator<? super E> c) {
        trim();
        MergeSorter.sort((E[]) array, c);
    }

    private void replaceNull(int remove) {
        while (remove < getSize()) {
            Object removed = array[remove];
            array[remove] = array[remove + 1];
            array[remove + 1] = removed;
            remove++;

        }
    }
    private void trim(){
        newArray = new Object[getSize()];
        System.arraycopy(array, 0, newArray, 0, newArray.length-1);
        array = newArray.clone();
    }
}

