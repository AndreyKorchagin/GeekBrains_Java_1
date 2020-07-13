package com.korchagin.courses.task11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class TestClass {

    public static void start(Class testClass) throws InvocationTargetException, IllegalAccessException {
        startMethodWithAnnotationBeforeSuite(testClass);
        startMethodWithAnnotationTest(testClass);
        startMethodWithAnnotationAfterSuite(testClass);
    }

    public static void startMethodWithAnnotationTest(Class testClass) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Выполнение методов с аннотацией Test");
        Method[] methods = testClass.getDeclaredMethods();
        HashMap<Integer, List<Method>> met = new HashMap<>();
        for (Method o : methods) {
            if (o.getAnnotation(Test.class) != null){
                int rang = o.getAnnotation(Test.class).rang();
                List<Method> list = met.getOrDefault(rang, new ArrayList<>());
                list.add(o);
                met.put(rang, list);
            }
        }

        List<Integer> rang = new ArrayList<>(met.keySet());
        rang.sort(Collections.reverseOrder());
        for (Integer r: rang){
            for (Method m: met.get(r)){
                m.invoke(testClass);
            }
        }
    }


    public static void startMethodWithAnnotationBeforeSuite(Class testClass) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Выполнение методов с аннотацией BeforeSuit");
        Method[] methods = testClass.getDeclaredMethods();
        int count = 0;
        Method Suite = null;
        for (Method o: methods) {
            if (o.getAnnotation(BeforeSuite.class) != null){
                count++;
                Suite = o;
            }
        }
        if (count == 0 || count == 1){
            if (count == 1) {
                Suite.invoke(testClass);
            }
        } else {
            throw new RuntimeException("BeforeSuite больше одного");
        }
    }

    public static void startMethodWithAnnotationAfterSuite(Class testClass) throws InvocationTargetException, IllegalAccessException {
        System.out.println("Выполнение методов с аннотацией AfterSuit");
        Method[] methods = testClass.getDeclaredMethods();
        int count = 0;
        Method Suite = null;
        for (Method o: methods) {
            if (o.getAnnotation(AfterSuite.class) != null){
                count++;
                Suite = o;
            }
        }
        if (count == 0 || count == 1){
            if (count == 1) {
                Suite.invoke(testClass);
            }
        } else {
            throw new RuntimeException("BeforeSuite больше одного");
        }
    }
}
