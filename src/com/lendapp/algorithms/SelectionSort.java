package com.lendapp.algorithms;

import java.util.Arrays;

/**
 * Created by maruf on 9/16/16.
 * n^2 complexity.
 */
public class SelectionSort extends Sort {

    public static void main(String[]args) {
        Integer [] s = {1, 2, 5, -7, 2, 3};
        sort(s);
        System.out.print(Arrays.toString(s));
    }

    public static void sort(Integer[] a) {
       int n = a.length;
        for (int i = 0; i < n; i++){
            int min = i;
            for (int j = i; j < n; j++){
                if(a[j] < a[min]) min = j;
            }
            swap(a, i, min);
        }
    }

}
