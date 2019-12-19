package com.github.wendao76.mergesort;

import java.util.Arrays;

/**
 * 归并排序算法
 * @author wendao76
 */
public class Main {
    public static void main(String[] args) {
        int[] sortArr = new int[]{1,7,4,8,9,2};
        mergeSort(sortArr, 0,5);
        Arrays.stream(sortArr).forEach(i -> {
            System.out.println(i);
        });
    }

    public static void mergeSort(int[] source, int low, int high) {
        if(low < high) {
            int mid = (low+high)/2;
            mergeSort(source, low, mid);
            mergeSort(source, mid+1, high);
            merge(source, low, mid, high);
        }
    }

    public static void merge(int[] source, int low, int mid, int high) {
        int i=low,j=mid+1,k=0;
        int[] copyArr = new int[high - low + 1];
        for (;i<=mid && j<=high;) {
            if(source[i]<source[j]) {
                copyArr[k++] = source[i++];
            }else{
                copyArr[k++] = source[j++];
            }
        }
        while(i<=mid) {
            copyArr[k++] = source[i++];
        }
        while(j<=high){
            copyArr[k++] = source[j++];
        }
        Arrays.stream(copyArr).forEach(item ->{
            System.out.print(item + " ");
        });
        System.out.println("");
        for (i=low, k=0; i<=high; i++) {
            source[i] = copyArr[k++];
        }
    }
}
