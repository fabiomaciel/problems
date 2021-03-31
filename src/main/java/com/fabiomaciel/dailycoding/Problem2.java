package com.fabiomaciel.dailycoding;

import java.util.Arrays;

/**
 * Given an array of integers, return a new array such that each element at index i
 * of the new array is the product of all the numbers in the original array except the one at i.
 * <p>
 * <p>
 * For example:
 * <p>
 * if our input was [1, 2, 3, 4, 5],
 * the expected output would be [120, 60, 40, 30, 24].
 * <p>
 * If our input was [3, 2, 1],
 * the expected output would be [2, 3, 6].
 */
public class Problem2 {

    public static void main(String[] args) {
        int[] case1 = {1, 2, 3, 4, 5};
        int[] case2 = {3, 2, 1};


        printArray(productArray(case1));
        printArray(productArray(case2));


        printArray(productArray2(case1));
        printArray(productArray2(case2));
    }

    public static void printArray(int[] arr){
        System.out.println(Arrays.toString(arr));
    }


    /**
     * get the product of all elements
     * then each index is divided by itself
     */
    public static int[] productArray(int[] initial) {
        int bigger = 1;
        for (int i = 0; i < initial.length; i++)
            bigger *= initial[i];

        int[] result = new int[initial.length];
        for (int i = 0; i < initial.length; i++)
            result[i] = bigger / initial[i];

        return result;
    }

    /**
     * this approach uses only product and not division
     */
    public static int[] productArray2(int[] initial) {
        int size = initial.length;

        int[] prefix = new int[size];
        prefix[0] = initial[0];

        for (int i = 1; i < size; i++) {
            prefix[i] = initial[i] * prefix[i - 1];
        }

        int[] suffix = new int[size];
        suffix[size - 1] = initial[size - 1];

        for (int i = (size - 2); i >= 0; i--) {
            suffix[i] = initial[i] * suffix[i + 1];
        }

        int[] result = new int[size];
        result[0] = suffix[1];
        result[size - 1] = prefix[size - 1];

        for (int i = 1; i < (size - 1); i++) {
            result[i] = suffix[i + 1] * prefix[i - 1];
        }

        return result;
    }


}
