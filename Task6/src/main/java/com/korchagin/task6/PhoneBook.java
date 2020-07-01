package com.korchagin.task6;

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private HashMap<String, String> phoneBook = new HashMap<>();

    public void get(String surname) {
        int i = 1;
        for (Map.Entry<String, String> o : phoneBook.entrySet()){
            if (o.getValue() == surname){
                System.out.println(i++ + ". " + o.getValue() + " - " + o.getKey());
            }
        }
        if (i == 1){
            System.out.printf("Записей с фамилией %s не было найдено\n", surname);
        }
    }

    public void add(String surname, String numberPhone) {
        this.phoneBook.put(numberPhone, surname);
    }
}
