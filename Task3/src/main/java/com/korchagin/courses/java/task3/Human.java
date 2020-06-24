package com.korchagin.courses.java.task3;

public class Human implements Actions {

    private int runLimit;
    private int jumpLimit;
    private boolean participant;

    public Human(int runLimit, int jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.participant = true;
    }

    @Override
    public void run(int length) {
        System.out.printf("Человек бежит на %d\n", length);
    }

    @Override
    public void jump(int height) {
        System.out.printf("Человек прыгает на %d\n", height);
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
                    System.out.println("Человек не смог перепрыгнуть");
                }
            } else {
                System.out.println("Человек выбыл");
            }
        } else if (barrier instanceof Treadmill){
            if (participant) {
                this.runLimit -= ((Treadmill) barrier).getLength();
                if (this.runLimit >= 0) {
                    run(((Treadmill) barrier).getLength());
                } else {
                    this.participant = false;
                    System.out.println("Человек не смог пробежать");
                }
            } else {
                System.out.println("Человек выбыл");
            }
        }
    }
}
