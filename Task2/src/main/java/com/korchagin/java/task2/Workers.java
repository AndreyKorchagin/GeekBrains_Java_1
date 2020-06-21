package com.korchagin.java.task2;

public class Workers {
    private String name;
    private String email;
    private String position;
    private int age;

    public Workers(String name, String email, String position, int age){
        this.name = name;
        this.email = email;
        this.position = position;
        this.age = age;
    }

    public void info(){
        System.out.printf("Name - %s\t| Email - %s\t| Position - %s\t| Age - %d\n", name, email, position, age);
    }
}
