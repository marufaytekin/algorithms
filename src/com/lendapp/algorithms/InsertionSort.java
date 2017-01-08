package com.lendapp.algorithms;

import java.util.Arrays;

/**
 * Created by maruf on 9/16/16.
 */
public class InsertionSort extends Sort {


    public static void main(String[]args) {
        Integer [] s = {1, 2, 5, -7, 2, 3};
        sort(s);
        System.out.print(Arrays.toString(s));
    }

    public static void sort(Integer[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++){
            for (int j = i; j > 0; j--){
                if(a[j] < a[j-1]) swap(a, j, j-1);
            }
        }
    }

}
