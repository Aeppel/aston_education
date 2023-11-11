package com.pervishkond.arraylist;

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
        for (int i = 0; i < otherArrayList.getSize(); i++) {
            this.add(otherArrayList.get(i));
        }
    }


    public void remove(int index) {
        size--;
        array[index] = 0;
        int remove = index;
        while (remove < getSize()) {  // использую метод пузырька для сохранения порядка
            Object removed = array[remove];
            array[remove] = array[remove + 1];
            array[remove + 1] = removed;
            remove++;
        }
        array[array.length - 1] = null;// возможно было бы проще написать метод System.arraycopy
    }

    public void remove(E e) {
        size--;
        for (int i = 0; i < array.length; i++) {
            if (e.equals(array[i])) {
                array[i] = 0;
                int remove = i;
                while (remove < getSize()) {
                    Object removed = array[remove];
                    array[remove] = array[remove + 1];
                    array[remove + 1] = removed;
                    remove++;
                }
            }
        }
    }

    public int getSize() {
        return size;
    }

    public E get(int index) {
        return (E) array[index];
    }

    public void clear() {
        for (int i = 0; i < getSize(); i++) {
            array[i] = null;
        }
    }

    public boolean isEmpty() {
        if (getSize() == 0) {
            return true;
        }
        return false;
    }

    public void sort(Comparator<? super E> c) {
        MergeSorter.sort((E[]) array, c);
    }


}

