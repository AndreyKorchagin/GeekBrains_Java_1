package com.korchagin.java.task2;

public class MainApp {
    public static void main(String[] args) {

        Workers worker1 = new Workers("Andrey", "1212@121", "Manager", 12);
        worker1.info();

        Groups group1 = new Groups("Hello");
        group1.info();
        group1.printGroup();
        System.out.println("");

        group1.addWorker(worker1);
        group1.addWorker(new Workers("Hello1", "312@3121", "Manager1", 123));
        group1.addWorker(new Workers("Hello2", "312@3122", "Manager2", 123));
        group1.addWorker(new Workers("Hello3", "312@3123", "Manager3", 123));
        group1.addWorker(new Workers("Hello4", "312@3123", "Manager4", 123));
        group1.printGroup();

        System.out.println("");
        group1.removeByIndex(2);
        group1.printGroup();

        group1.removeAllWorkers();
        System.out.println("");
        group1.printGroup();

    }
}
