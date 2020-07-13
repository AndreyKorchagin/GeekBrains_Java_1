package com.korchagin.courses.task11;

import jdk.jfr.StackTrace;

import java.lang.reflect.Method;

public class CheakClass {

    @BeforeSuite
    public static void method1(){
        System.out.println("Hello1");
    }
    @Test(rang = 2)
    public static void method2(){
        System.out.println("Hello2");
    }
    @Test(rang = 1)
    public static void method3(){
        System.out.println("Hello3");
    }
    @Test(rang = 2)
    public static void method4(){
        System.out.println("Hello4");
    }
    @AfterSuite
    public static void method5(){
        System.out.println("Hello5");
    }
}
