package com.korchagin.task6;

import java.util.*;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("\nЗадание №1\n");
        String[] test1 = new String[]{"H", "2", "3", "1", "2", "3", "1", "2", "3", "1", "2", "3", "1", "2", "3"};
        String[] test2 = new String[10];
        findUniqueElem(test1);
        findUniqueElem(test2);

        System.out.println("\nЗадание №2\n");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Andrey", "+819291");
        phoneBook.add("Andrey", "+81");
        phoneBook.get("Andrey");

    }

    public static void findUniqueElem(String[] array){
        boolean empty = true;
        for (String o: array){
            if (o != null){
                empty = false;
                break;
            }
        }

        HashMap<String, Integer> unique = new HashMap<>();
        if (empty == false){
            unique.put(array[0], 1);
            for (int i = 1; i < array.length; i++) {
                if (unique.get(array[i]) != null){
                    int count = unique.get(array[i]);
                    unique.put(array[i], ++count);
                } else {
                    unique.put(array[i], 1);
                }
            }
        } else {
            System.out.println("В исходном массиве нет элементов");
        }

        for (Map.Entry<String, Integer> o : unique.entrySet()) {
            System.out.println("\"" + o.getKey()  + "\"" + " - " + o.getValue() + " шт.");
        }
    }
}
