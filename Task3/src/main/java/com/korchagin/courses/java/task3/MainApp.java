package com.korchagin.courses.java.task3;

public class MainApp {
    public static void main(String[] args) {

        Human man = new Human(15, 4);
        Cat cat = new Cat(20, 10);
        Robot robot = new Robot(3, 3);

        Actions[] participants = {man, cat, robot};
        Barriers[] barriers = {new Wall(2), new Treadmill(10), new Wall(3), new Treadmill(5)};

        for (Actions participant: participants) {
            System.out.println("\n");
            for ( Barriers barrier : barriers) {
                participant.passBarrier(barrier);
            }
        }
    }
}
