package com.korchagin.courses.java.task3;

public class Robot implements Actions {

    private int runLimit;
    private int jumpLimit;
    private boolean participant;

    public Robot(int runLimit, int jumpLimit) {
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
        this.participant = true;
    }

    @Override
    public void run(int length) {
        System.out.println("Робот бежит");
    }

    @Override
    public void jump(int height) {
        System.out.println("Робот прыгает");
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
                    System.out.println("Робот не смог перепрыгнуть");
                }
            } else {
                System.out.println("Робот выбыл");
            }
        } else if (barrier instanceof Treadmill){
            if (participant) {
                this.runLimit -= ((Treadmill) barrier).getLength();
                if (this.runLimit >= 0) {
                    run(((Treadmill) barrier).getLength());
                } else {
                    this.participant = false;
                    System.out.println("Робот не смог пробежать");
                }
            } else {
                System.out.println("Робот выбыл");
            }
        }
    }
}
