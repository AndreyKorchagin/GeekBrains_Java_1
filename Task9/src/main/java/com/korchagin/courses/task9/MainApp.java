package com.korchagin.courses.task9;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class MainApp {
    public static void main(String[] args) {
        int[] array = fillArray(100_000_000);

        findMaxOneTread(array);
        findMaxMultiTread(array);
        findMaxStream(array);
        findMaxParallelStream(array);

    }

    static int[] fillArray(int size){
        int[] array = new int[size];
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = rnd.nextInt(1_000_000);
        }
        return array;
    }

    static void findMaxOneTread(int[] array){
        long startTime = System.currentTimeMillis();
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
            }
        }
        System.out.printf("one tread = %d мс max = %d\n", System.currentTimeMillis() - startTime, max);
    }

    static void findMaxMultiTread(int[] array){
        long startTime = System.currentTimeMillis();
        SearchMax max = new SearchMax(array);
        int m = ForkJoinPool.commonPool().invoke(max);
        System.out.printf("multi tread = %d мс max = %d\n", System.currentTimeMillis() - startTime, m);
    }

    static void findMaxStream(int[] array){
        long startTime = System.currentTimeMillis();

        int max = Arrays.stream(array).reduce(0, Integer::max);
        System.out.printf("stream = %d мс max = %d\n", System.currentTimeMillis() - startTime, max);
    }

    static void findMaxParallelStream(int[] array){
        long startTime = System.currentTimeMillis();

        int max = Arrays.stream(array).parallel().reduce(0, Integer::max);
        System.out.printf("parallel stream = %d мс max = %d\n", System.currentTimeMillis() - startTime, max);
    }

//    one tread = 52 мс max = 999999
//    multi tread = 6930 мс max = 999999
//    stream = 174 мс max = 999999
//    parallel stream = 51 мс max = 999999
//    Самый быстрый вариант оказался paralle stream
}
