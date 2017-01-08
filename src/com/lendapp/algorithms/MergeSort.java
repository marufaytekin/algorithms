package com.lendapp.algorithms;

import java.util.Arrays;

/**
 * Created by maruf on 9/15/16.
 */
public class MergeSort extends Sort{

    public static void main(String[]args) {
        Integer [] s = {1, 2, 5, -7, 2, 3};
        sort(s, 0, 5);
        System.out.print(Arrays.toString(s));

    }

    public static void sort(Integer[] a, int lo, int hi) {
        if (lo >= hi) return;
        int mid = lo + (hi-lo)/2;
        sort (a, lo, mid);
        sort(a, mid+1, hi);
        merge(a, lo, mid, hi);
    }


    public static void merge(Integer [] a, int lo, int mid, int hi) {
        int i = lo;
        int j = mid+1;
        Integer [] temp = new Integer[hi+1];

        for (int k=lo; k < hi+1; k++) {
            temp[k] = a[k];
        }

        for (int k=lo; k < hi; k++){
            if (i > mid) {
                a[k] =  temp[j++];
            }
            else if (j > hi) {
                a[k] = temp[i++];
            }
            else if(temp[j] < temp[i]) {
                a[k] = temp[j++];
            }
            else {
                a[k] = temp[i++];
            }
        }
    }
}
