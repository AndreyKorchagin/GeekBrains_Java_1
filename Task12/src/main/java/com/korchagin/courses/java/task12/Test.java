package com.korchagin.courses.java.task12;

@DbTable(name = "test")
public class Test {

    @DbId
    private long id = 0;

    @DbColumn
    private String data;

    @DbColumn
    private String message;

    @DbColumn
    private int digital = 0;

    public Test(String data) {
        this.data = data;
    }

    public Test(String data, String message) {
        this.data = data;
        this.message = message;
    }

    public Test(String data, String message, int digital) {
        this.data = data;
        this.message = message;
        this.digital = digital;
    }

    public void info(){
        System.out.println("DATA = " + data + " MESSAGE = " + message + " DIGITAL = " + digital);
    }
}
