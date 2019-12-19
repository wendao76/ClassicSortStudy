package com.github.wendao76.quicksort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{7,4,2,8,9,1,10,8,3};
        quickSort(arr, 0, 8);
        Arrays.stream(arr).forEach(item -> {
            System.out.println(item);
        });
    }

    public static void quickSort(int[] source, int low, int high) {
        if(low<high) {
            int mid = partition(source, low, high);
            quickSort(source, low, mid);
            quickSort(source, mid + 1 , high);
        }
    }

    /**
     * 将数组分成两个部分， 右边小，左边大
     * @param source
     * @param low
     * @param high
     * @return
     */
    public static int partition(int[] source, int low, int high) {
        int pivot = source[low];
        int i=low, j=high;
        while(i<j) {
            while(i<j && source[j] >= pivot) {
                j--;
            }
            if(i<j) {
                swap(source, i++, j);
            }
            while(i<j && source[i] < pivot) {
                i++;
            }
            if(i<j) {
                swap(source, j--, i);
            }
        }
        return i;
    }

    /**
     * 数组内容交换
     * @param source
     * @param pos1
     * @param pos2
     */
    public static void swap(int[] source, int pos1, int pos2) {
        int tmp = source[pos1];
        source[pos1] = source[pos2];
        source[pos2] = tmp;
    }
}
