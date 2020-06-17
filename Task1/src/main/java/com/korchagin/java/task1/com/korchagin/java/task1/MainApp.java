package com.korchagin.java.task1.com.korchagin.java.task1;

import java.util.Arrays;

public class MainApp {
    public static void main(String[] args) {
        final int N = 9;
        int[] array1 = {1, 0, 1, 1, 1, 1, 1, 1, 0, 1};
        int[] array2 = new int[8];
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int[][] array4 = new int[N][N];
        int[] array5 = {1, 5, 3, 2, 11, 4, 2, 5, 4, 8, 9, 2};
//        System.out.println(checkSum(10, 20))
//        printPassiveOrNegative(-10);
//        System.out.println(checkNegative(-10));
//        printName("Andrey");
//        reverseArray(array1);
//        fillArray(array2);
//        checkEleminArray(array3);
//        fillDiagonals(array4);
//        findMaxMinInArray(array3);
//        checkYear(1981);
//        checkBalance(array5);
    }

    public static boolean checkSum(int a, int b){
        int sum = a + b;
        if (sum >= 10 && sum <= 30){
            return true;
        } else {
            return false;
        }
    }

    public static void printPassiveOrNegative(int a){
        if (a >= 0){
            System.out.println("Passive");
        } else {
            System.out.println("Negative");
        }
    }

    public static boolean checkNegative(int a) {
        if (a < 0) {
            return true;
        }
        return false;
    }

    public static void printName(String str){
        System.out.println("Привет, " + str + "!");
    }

    public static void reverseArray(int[] array ){
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 1){
                array[i] = 0;
            } else if (array[i] == 0){
                array[i] = 1;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void fillArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            array[i] = i * 3 + 2;
        }
        System.out.println(Arrays.toString(array));
    }

    public static void checkEleminArray(int[] array){
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            if(array[i] < 6){
                array[i] *= 2;
            }
        }
        System.out.println(Arrays.toString(array));
    }

    public static void fillDiagonals(int[][] array){
        System.out.println(Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println("");
        }

        for (int i = 0; i < array.length ; i++) {
            for (int j = 0; j < array.length ; j++) {
                if((i == j) || (i + j == array.length - 1)){
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
            }
        }

        System.out.println("-------------");

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println("");
        }
    }

    public static void findMaxMinInArray(int[] array){
        int Max = array[0];
        int Min = array[0];
        for (int i = 0; i < array.length; i++) {
            if(array[i] > Max){
                Max = array[i];
            } else if (array[i] < Min){
                Min = array[i];
            }
        }
        System.out.println("Max = " + Max + " Min = " + Min);
    }

    public static void checkYear(int year){
        if ((year % 4 != 0) || (year % 100 == 0 && year % 400 != 0)){
            System.out.println("Год не Високостный");
        } else {
            System.out.println("Год Високостный");
        }
    }

    public static boolean checkBalance(int[] array) {
        int sum = 0;
        int sum1 = 0;
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        if (sum % 2 == 0){
            System.out.println(sum/2);

            while (sum1 < sum / 2){
                sum1 += array[j++];
            }

            if (sum1 == sum / 2){
                return  true;
            }

            return false;
        } else {
            System.out.println("2");
            return false;
        }
    }

}
