package com.korchagin.courses.task11;

import java.lang.reflect.InvocationTargetException;

public class MainApp {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        TestClass test = new TestClass();
        test.start(CheakClass.class);
    }
}
