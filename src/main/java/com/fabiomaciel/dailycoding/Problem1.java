package com.fabiomaciel.dailycoding;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Problem1 {
    public static void main(String[] args) {
        int[] list = {15, 3, 10, 7, 8, 2, 1, 80};
        int k = 3;

        System.out.println(twoSum(list, k));
        System.out.println(twoSum2(list, k));
        System.out.println(twoSum3(list, k));

    }

    /**
     *
     * Basic implementation
     *
     */
    public static boolean twoSum(int[] list, int k) {
        for (int i = 0; i < list.length; i++) {
            for (int j = i + 1; j < list.length; j++) {
                if ((list[i] + list[j]) == k) return true;
            }
        }
        return false;
    }


    /**
     *
     * using Map to reduce complexity
     *
     */
    public static boolean twoSum2(int[] list, int k) {
        Set<Integer> viewd = new HashSet<>();

        for (int j : list) {
            if (viewd.contains(k - j)) return true;
            viewd.add(j);
        }
        return false;
    }

    /**
     *
     * sort an array and search using a binary search
     *
     */
    public static boolean twoSum3(int[] list, int k) {
        Arrays.sort(list);
        for (int i : list) {
            if (Arrays.binarySearch(list, k - i) != -1) return true;
        }

        return false;
    }


}


