package com.korchagin.courses.java.task3;

public class Cat implements Actions {

    private int runLimit;
    private int jumpLimit;
    private boolean participant;

    public Cat(int runLimit, int jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.participant = true;
    }

    @Override
    public void run(int length) {
        System.out.println("Кошка бежит");
    }

    @Override
    public void jump(int height) {
        System.out.println("Кошка прыгает");
    }

    @Override
    public void passBarrier(Barriers barrier) {
        if (barrier instanceof Wall) {
            if (participant) {
                this.jumpLimit -= ((Wall) barrier).getHeight();
                if (this.jumpLimit >= 0) {
                    jump(((Wall) barrier).getHeight());
                } else {
                    this.participant = false;
                    System.out.println("Кошка не смогла перепрыгнуть");
                }
            } else {
                System.out.println("Кошка выбыла");
            }
        } else if (barrier instanceof Treadmill){
            if (participant) {
                this.runLimit -= ((Treadmill) barrier).getLength();
                if (this.runLimit >= 0) {
                    run(((Treadmill) barrier).getLength());
                } else {
                    this.participant = false;
                    System.out.println("Кошка не смога пробежать");
                }
            } else {
                System.out.println("Кошка выбыла");
            }
        }
    }
}
