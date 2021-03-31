package com.fabiomaciel.dailycoding;

import java.util.Arrays;

/**
 * Given an array of integers, return a new array such that each element at index i
 * of the new array is the product of all the numbers in the original array except the one at i.
 *
 *
 * For example:
 *
 * if our input was [1, 2, 3, 4, 5],
 * the expected output would be [120, 60, 40, 30, 24].
 *
 * If our input was [3, 2, 1],
 * the expected output would be [2, 3, 6].
 */
public class Problem2 {

    public static void main(String[] args) {
        int[] case1 = {1,2,3,4,5};
        String result1 = Arrays.toString(productArray(case1));
        System.out.println(result1);

        int[] case2 = {3, 2, 1};
        String result2 = Arrays.toString(productArray(case2));
        System.out.println(result2);
    }

    /**
     *
     * get the product of all elements
     * then each index is divided by itself
     *
     */
    public static int[] productArray(int[] initial){
        int bigger = 1;
        for(int i = 0; i < initial.length; i++)
            bigger *= initial[i];

        int[] result = new int[initial.length];
        for(int i = 0; i < initial.length; i ++)
            result[i] = bigger / initial[i];

        return result;
    }

}
