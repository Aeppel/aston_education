package com.pervishko.arraylist;
import com.pervishkond.arraylist.MergeSorter;
import com.pervishkond.arraylist.MyArrayList;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

public class MegreSorterTest extends MergeSorter {
        MergeSorter  sorter = new MergeSorter();

    @Test
    void integerSort(){
        Integer[] array = {4,67,54,33,45,89,1,11,23};
        sorter.sort(array, Comparator.naturalOrder());
        Integer[] arraySorted = {4,67,54,33,45,89,1,11,23};
        Arrays.sort(arraySorted);
        assertArrayEquals(array, arraySorted);
    }

    @Test
    void stringSort(){
        String[] array = {"a","vv","ad","ra","ss","sd","va"};
        sorter.sort(array,Comparator.naturalOrder());
        String[] arraySorted = {"a","vv","ad","ra","ss","sd","va"};
        Arrays.sort(arraySorted);
        assertArrayEquals(array, arraySorted);

    }

}
