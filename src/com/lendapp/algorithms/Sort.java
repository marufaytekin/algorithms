package com.lendapp.algorithms;

/**
 * Created by maruf on 9/16/16.
 */
public abstract class Sort {


    public static void swap(Integer[] a, int i, int min) {
        int temp = a[i];
        a[i] = a[min];
        a[min] = temp;
    }

}
