package com.korchagin.courses.task5;

import javax.sound.midi.Soundbank;
import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        pingTestArrayList();
        pingTestLinkedList();

        DeleteTestHalfElemInArrayList();
        DeleteTestHalfElemInLinkedList();
        int count = 50_000;
        int count1 = 100_000;
        ArrayList<MyEntry> myEntry = new ArrayList<>(count);
        HashMap<Integer, Integer> hash = new HashMap<>(count);
        ArrayList<Integer> keys = fillKeys(count1);
        fillMyEntry(myEntry, hash, count);
        long StartTime = System.currentTimeMillis();
        for (int i = 0; i < count1; i++) {
            findValue(myEntry, keys.get(i));
        }
        long delta1 = System.currentTimeMillis() - StartTime;
        System.out.println("delta = " + delta1);

        StartTime = System.currentTimeMillis();
        for (int i = 0; i < count1; i++) {
            hash.get(i);
        }
        long delta2 = System.currentTimeMillis() - StartTime;
        System.out.println("delta = " +  delta2);

//        task 1
//        ArrayList
//        10 - 7 мс
//        100 - 3 мс
//        1000 - 0 мс
//        10000 - 0 мс
//        100000 - 0 мс
//
//                LinkedList
//        10 - 8 мс
//        100 - 10 мс
//        1000 - 138 мс
//        10000 - 1040 мс
//        100000 - 12657 мс

//        task2
//        ArrayList
//        10 - 0 мс
//        100 - 0 мс
//        1000 - 0 мс
//        10000 - 1 мс
//        100000 - 143 мс
//
//                LinkedList
//        10 - 0 мс
//        100 - 0 мс
//        1000 - 1 мс
//        10000 - 46 мс
//        100000 - 3045 мс

//        task3
//        MyEntry = 6148
//        HashList = 6
    }

    static ArrayList<Integer> fillKeys(int count){
        ArrayList<Integer> key = new ArrayList<>(count);
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            key.add(rand.nextInt(49999));
        }
        return key;
    }

    static void fillMyEntry(ArrayList<MyEntry> list, HashMap<Integer, Integer> hash, int count){
        Random rand = new Random();
        for (int i = 0; i < count; i++) {
            int value = rand.nextInt(count);
            list.add(new MyEntry(i, value));
            hash.put(i, value);
        }
    }

    static void findValue(ArrayList<MyEntry> list, int key){
        if (key <= list.size()){
            for (MyEntry item: list) {
                if (item.getKey() == key){
//                    System.out.println(item.getValue());
                    break;
                }
            }
        } else {
            System.out.println("В этом списке нет такого элемента");
        }
    }

    static void pingTestArrayList(){
        ArrayList<Long> times = new ArrayList<>();
        for (int i = 10; i <= 100_000; i *= 10) {
            ArrayList<Integer> pingArray = new ArrayList<>(i);
            FillList(pingArray, i);
            times.add(RequestToMiddleElem(pingArray));
        }
        printTimes(times, "ArrayList");
    }

    static void pingTestLinkedList(){

        ArrayList<Long> times = new ArrayList<>();
        for (int i = 10; i <= 100_000; i *= 10) {
            LinkedList<Integer> pingLinkedList = new LinkedList<>();
            FillList(pingLinkedList, i);
            times.add(RequestToMiddleElem(pingLinkedList));
        }
        printTimes(times, "LinkedList");
    }

    static void DeleteTestHalfElemInArrayList(){
        ArrayList<Long> times = new ArrayList<>();
        for (int i = 10; i <= 100_000; i *= 10) {
            ArrayList<Integer> pingArray = new ArrayList<>(i);
            FillList(pingArray, i);
            times.add(DeleteHalfElem(pingArray));
        }
        printTimes(times, "ArrayList");
    }

    static void DeleteTestHalfElemInLinkedList(){
        ArrayList<Long> times = new ArrayList<>();
        for (int i = 10; i <= 100_000; i *= 10) {
            LinkedList<Integer> pingArray = new LinkedList<>();
            FillList(pingArray, i);
            times.add(DeleteHalfElem(pingArray));
        }
        printTimes(times, "LinkedList");
    }

    static void FillList(ArrayList<Integer> list, int size){
        for (int j = 0; j < size; j++) {
            list.add(1);
        }
    }

    static void FillList(LinkedList<Integer> list, int size){
        for (int j = 0; j < size; j++) {
            list.add(1);
        }
    }

    static long RequestToMiddleElem(ArrayList<Integer> list){
        long startTime = System.currentTimeMillis();
        int index = list.size() / 2;
        for (int j = 0; j < 100_000; j++) {
            list.get(index);
        }
        return System.currentTimeMillis() - startTime;
    }

    static long RequestToMiddleElem(LinkedList<Integer> list){
        long startTime = System.currentTimeMillis();
        int index = list.size() / 2;
        for (int j = 0; j < 100_000; j++) {
            list.get(index);
        }
        return System.currentTimeMillis() - startTime;
    }

    static long DeleteHalfElem(ArrayList<Integer> list){
        long startTime = System.currentTimeMillis();
        int index = list.size() / 2;
        for (int j = index * 3/ 2; j > index / 2; j--) {
            list.remove(j);
        }
        return System.currentTimeMillis() - startTime;
    }

    static long DeleteHalfElem(LinkedList<Integer> list){
        long startTime = System.currentTimeMillis();
        int index = list.size() / 2;
        for (int j = index * 3/ 2; j > index / 2; j--) {
            list.remove(j);
        }
        return System.currentTimeMillis() - startTime;
    }

    static void printTimes(ArrayList time, String text){
        int j = 0;
        System.out.println("\n" + text);
        for (int i = 10; i <= 100_000 ; i *= 10) {
            System.out.printf("%6d - %d мс\n", i, time.get(j++));
        }
    }


}
