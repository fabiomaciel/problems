package com.fabiomaciel.dailycoding;

/**
 * The edit distance between two strings refers to the minimum number of character insertions, deletions, and
 * substitutions required to change one string to the other.
 *
 * For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”,
 * substitute the “e” for “i”, and append a “g”.
 *
 * Given two strings, compute the edit distance between them.
 */
public class Problem530 {

    public static void main(String[] args) {
        String x = "sitten";
        String y = "sitten222";

        int distance = levenshteinDistance(x, y);
        System.out.println(distance);
    }

    /**
     * Divide and conquer
     *
     */
    public static int levenshteinDistance(String str1, int str1Size, String str2, int str2Size){
        if(str1Size == 0) return str2Size;
        if(str2Size == 0) return str1Size;

        int cost = str1.charAt(str1Size - 1) == str2.charAt(str2Size - 1) ? 0 : 1;

        return min(
                levenshteinDistance(str1, str1Size - 1, str2, str2Size) + 1,
                levenshteinDistance(str1, str1Size, str2, str2Size -1) + 1,
                levenshteinDistance(str1, str1Size - 1, str2, str2Size - 1) + cost
        );
    }

    /**
     *
     * dynamic programing
     *
     */
    public static int levenshteinDistance(String str1, String str2){
        int str1Size = str1.length();
        int str2Size = str2.length();

        int[][] table = new int[str1Size + 1][str2Size + 1];

        for(int x = 0; x <= str1Size; x++){
            table[x][0] = x;
        }

        for(int y = 0; y <= str2Size; y++){
            table[0][y] = y;
        }

        for (int x = 1; x <= str1Size; x++){
            for(int y = 1; y <= str2Size; y++){

                int cost = str1.charAt(x - 1) == str2.charAt(y - 1) ? 0 : 1;

                table[x][y] = min(
                        table[x - 1][y] + 1,
                        table[x][y -1] + 1,
                        table[x - 1][y - 1] + cost
                );
            }
        }

        return table[str1Size][str2Size];
    }

    public static int min(int x, int y, int z) {
        return Math.min(Math.min(x, y), z);
    }

}
