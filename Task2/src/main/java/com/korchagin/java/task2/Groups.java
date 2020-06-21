package com.korchagin.java.task2;

public class Groups {
    private String groupName;
    private Workers[] worker = new Workers[10];
    private static int count;

    public Groups(String groupName){
        this.groupName = groupName;
        this.count = 0;
    }

    public void addWorker(Workers worker){
        if (count == 10){
            System.out.println("В группу нельзя добавить участника. Группа переполнена!");
        } else {
            this.worker[count] = worker;
            count++;
        }
    }

    public void removeByIndex(int index){
        for (int i = index - 1; i < count; i++) {
            worker[i] = worker[i + 1];
        }
        worker[count - 1] = null;
        count--;
        System.out.printf("Был удален сотрудник из группы под нмером '%d'\n", index);
    }

    public void removeAllWorkers(){
        for (int i = 0; i < worker.length; i++) {
            worker[i] = null;
        }
        count = 0;
        System.out.println("Из группы были все сотрудники удалены");
    }

    public void printGroup() {
        if (count == 0) {
            System.out.println("В этой группе никого нет!");
        } else {
            for (int i = 0; i < count; i++) {
                System.out.printf("%d:\t", i + 1);
                worker[i].info();
            }
        }
    }

    public void info(){
        System.out.printf("\nGroup Name = %s\n", groupName);
    }
}
