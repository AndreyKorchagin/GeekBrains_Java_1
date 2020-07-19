package com.korchagin.courses.task14;

import java.io.*;

import java.nio.charset.StandardCharsets;

public class MainApp {
    public static void main(String[] args) throws IOException {
        task1("Abc");
        task2();
        task3("3");
    }

    public static int task1(String template) throws IOException {
        byte[] l = template.getBytes(StandardCharsets.US_ASCII);
        FileInputStream file = new FileInputStream("1.txt");
        int  x;
        int count = 0;
        while ((x = file.read()) != -1){
            if (x == l[0]){
                if (l.length != 1) {
                    int i = 1;
                    while (file.read() == l[i]) {
                        if (i == l.length - 1) {
                            count++;
                        } else if (i < l.length - 1) {
                            i++;
                        }
                    }
                } else {
                    count++;
                }
            }
        }
        System.out.println(count);
        return count;
    }

    public static void task2() throws IOException {
        File dir = new File("2");
        File[] files = dir.listFiles();
        FileOutputStream out = new FileOutputStream("2\\out.txt");
        for (int i = 0; i < files.length; i++) {
            FileInputStream file = new FileInputStream(files[i]);
            int x;
            while ((x = file.read()) != -1){
                out.write(x);
            }
        }
        System.out.println("OK");
    }

    public static void task3(String path) {
        File file = new File(path);
        if (!file.exists())
            return;

        if (file.isDirectory()) {
            for (File f : file.listFiles()) {
                task3(f.getPath());
            }
        }
        file.delete();
        System.out.println("Удаленный файл или папка: " + file.getAbsolutePath());
    }
}
