package com.fabiomaciel.dailycoding.utils;

public class TimeUtils {

    public static Long execute(Runnable fn) {
        long start = System.currentTimeMillis();
        fn.run();
        long totalLong = System.currentTimeMillis() - start;
        return totalLong;
    }

    public static void times(Runnable fn, int t) {
        for (int i = 0; i < t; i++)
            fn.run();
    }

    public static void executeTimesAndGetTotalLong(Runnable fn, int times) {
        times(() -> execute(fn), times);
    }

}
