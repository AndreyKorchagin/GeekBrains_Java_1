package com.korchagin.courses.java.task12;

public class MainApp {

    public static void main(String[] args) {

        Test t1 = new Test("0SDB1");
        Test t2 = new Test("0SDB2", "Hello2");
        Test t3 = new Test("0SDB3", "Hello3", 200);

        ReflectionRepository<Test> db = new ReflectionRepository<>(Test.class);

        try {
            db.connect();

            db.insertEx(t1);
            db.insertEx(t2);
            db.insertEx(t3);
//            db.deleteEx(3);
//            db.clearTableEx();
            db.readEx(3);
//            db.readAllEx();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            db.disconnect();
        }
    }
}
