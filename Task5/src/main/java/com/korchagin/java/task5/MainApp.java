package com.korchagin.java.task5;

import org.w3c.dom.ls.LSOutput;

import javax.sound.midi.Soundbank;
import javax.swing.table.TableStringConverter;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainApp {
    private static Object Integer;
    private static Object array;

    public static void main(String[] args) {
        Task 1
        String test1[] = {"H", "e", "l", "l", "o"};
        Integer test2[] = {1, 2, 3,4 ,5 ,6 , 7};
        swap(test2, 5, 1);
        swap(test1, 4, 0);

        Task 2
        ArrayList<String> list1 = ConverteToArayList(test1);
        ArrayList<Integer> list2 = ConverteToArayList(test2);
        System.out.println(list1.toString());
        System.out.println(list2.toString());
        System.out.println(list1.size());
        Box orange1 = new Box();
        Box orange2 = new Box();
        Box apple = new Box();
        orange1.addFruitInBox(new Orange());
        orange1.addFruitInBox(new Orange());
        orange1.getFruitOutBox();

        orange1.intersperse(orange2);

        orange1.getWeight();
        orange2.getWeight();
        orange1.addFruitInBox(new Orange());
        orange1.addFruitInBox(new Orange());

        apple.addFruitInBox(new Apple());
        apple.addFruitInBox(new Apple());
        apple.addFruitInBox(new Apple());
        apple.getWeight();

        System.out.println(orange1.compare(orange2));
        System.out.println(orange1.compare(apple));



    }

    public static void swap(Object[] array, int a, int b){
        System.out.println(Arrays.toString(array));
        Object tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
        System.out.println(Arrays.toString(array));
    }

    public static <T> ArrayList<T> ConverteToArayList(T[] array){
        return new ArrayList<>(Arrays.asList(array));
    }
}
