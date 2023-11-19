package com.pervishkond.arraylist;

import java.util.Comparator;

public class MergeSorter {

    public static <E> void sort(E[] array, Comparator<? super E> comp) {
        mergeSort(array, 0, array.length - 1, comp);
    }

    private static <E> void mergeSort(E[] a, int start, int end, Comparator<? super E> comp) {
        if (start == end)
            return;
        int mid = (start + end) / 2;
        mergeSort(a, start, mid, comp);
        mergeSort(a, mid + 1, end, comp);
        merge(a, start, mid, end, comp);
    }

    private static <E> void merge(E[] a, int start, int mid, int end, Comparator<? super E> comp) {
        int size = end - start + 1;
        Object[] values = new Object[size];
        int startValue = start;
        int middleValue = mid + 1;
        int index = 0;
        while (startValue <= mid && middleValue <= end) {
            if (comp.compare(a[startValue], a[middleValue]) < 0) {
                values[index] = a[startValue];
                startValue++;
            } else {
                values[index] = a[middleValue];
                middleValue++;
            }
            index++;
        }
        while (startValue <= mid) {
            values[index] = a[startValue];
            startValue++;
            index++;
        }
        while (middleValue <= end) {
            values[index] = a[middleValue];
            middleValue++;
            index++;
        }
        for (index = 0; index < size; index++)
            a[start + index] = (E) values[index];
    }
}