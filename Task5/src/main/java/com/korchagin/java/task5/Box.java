package com.korchagin.java.task5;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> fruits = new ArrayList<>();

    Box(){
    }

    public boolean compare(Box<T> box){
        return this.fruits.size() * this.fruits.get(0).getWeight() == box.fruits.size() * box.fruits.get(0).getWeight();
    }

    public void getWeight(){
        if (!fruits.isEmpty()){
            float weight = fruits.size() * fruits.get(0).getWeight();
            System.out.println("Вес этой коробки = " + weight);
        } else {
            System.out.println("Вес этой коробки = 0.0");
        }
    }

    public void getFruitOutBox(){
        System.out.println(fruits.size());
    }

    public void intersperse(Box<T> box){
        if (box.fruits.isEmpty()){
            box.fruits.addAll(fruits);
            this.fruits.clear();
            System.out.println("Фрукты были пересыпаны");
        } else {
            System.out.println("Эта коробка не пустая!");
        }
    }

    public void addFruitInBox(T fruit){
        if (this.fruits.isEmpty()){
            this.fruits.add(fruit);
        } else if (fruit.getClass() == fruits.get(0).getClass()){
            this.fruits.add(fruit);
        } else {
            System.out.println("Этот фрункт нельзя положить в эту коробку, попробуйте положить в другую!");
        }
    }
}
