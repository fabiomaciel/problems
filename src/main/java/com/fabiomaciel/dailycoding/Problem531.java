package com.fabiomaciel.dailycoding;

import java.io.*;

/**
 * Using a read7() method that returns 7 characters from a file, implement readN(n) which reads n characters.
 *
 * For example, given a file with the content “Hello world”, three read7() returns “Hello w”, “orld” and then “”.
 */
public class Problem531 {

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/main/resources/problem531/hw.txt");
        stream = new FileInputStream(file);

        int iterations = 3;

        for (int i = 0; i < iterations; i++) {
            System.out.println(read7());
        }
    }

    public static InputStream stream;

    public static String readN(int n) {
        byte[] b = new byte[n];
        try {
            stream.read(b);
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return new String(b);
    }

    public static String read7() {
        return readN(7);
    }


}
