package com.korchagin.courses.java.task12;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.logging.FileHandler;

public class ReflectionRepository<T> {

    private Class<T> testClass;
    private String tableName;
    private static Connection connection;
    private static Statement stmt;
    private static PreparedStatement psInsert;
    private static String dbId;


    public ReflectionRepository(Class<T> testClass) {
        if (testClass.isAnnotationPresent(DbTable.class)) {
            Field[] fields = testClass.getDeclaredFields();
            boolean status = false;
            for (Field f: fields) {
                if (f.getAnnotation(DbId.class) != null){
                    status = true;
                }
            }
            if (status){
                this.testClass = testClass;
                this.tableName = testClass.getAnnotation(DbTable.class).name();
            } else {
                System.out.println("В этом классе нет аннотации поля id");
            }

        } else {
            System.out.println("В этом классе нет аннотации с название таблицы");
        }
    }

    public void insertEx(T obj) throws IllegalAccessException, SQLException {
//        INSERT INTO test
        StringBuilder query = new StringBuilder(String.format("INSERT INTO %s (", tableName));
        Field[] fields = testClass.getDeclaredFields();
//        INSERT INTO test (data, message, digital)
        for (Field f : fields) {
            if (f.isAnnotationPresent(DbColumn.class)){
                query.append(f.getName() + ", ");
            }
        }
        query.setLength(query.length() - 2);
//        INSERT INTO test (data, message, digital) VALUES (
        query.append(") VALUES (");

        for ( Field f : fields) {
            f.setAccessible(true);
            if (!f.isAnnotationPresent(DbId.class)) {
                if (f.getType() == String.class){
                    query.append("'" + f.get(obj) + "', ");
                } else if (f.getType() == int.class){
                    query.append(f.get(obj));
                    query.append(", ");
                }
            }
        }
        query.setLength(query.length() - 2);
        query.append(");");
//        System.out.println("query = " + query);
        stmt.executeUpdate(query.toString());
    }

    public void deleteEx(int id) throws SQLException {
//        DELETE FROM tableName WHERE id = id
        StringBuilder query = new StringBuilder(String.format("DELETE FROM %s WHERE id = %d", tableName, id));
        stmt.executeUpdate(query.toString());
    }

    public void clearTableEx() throws SQLException {
//        DELETE FROM tableName
        StringBuilder query = new StringBuilder(String.format("DELETE FROM %s", tableName));
        stmt.executeUpdate(query.toString());
    }

    public void readEx(long id) throws SQLException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        psInsert = connection.prepareStatement(String.format("SELECT * FROM %s WHERE id = ?", tableName));
        psInsert.setLong(1, id);
        try (ResultSet rs = psInsert.executeQuery()){
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("data") + " " + rs.getString("message") + " " + rs.getInt(4));
            }
        }
    }

    public void readAllEx() throws SQLException {
        StringBuilder query = new StringBuilder(String.format("SELECT * FROM %s", tableName));
        try (ResultSet rs = stmt.executeQuery(query.toString())){
            while (rs.next()) {
                System.out.println(rs.getInt(1) + " " + rs.getString("data") + " " + rs.getString("message") + " " + rs.getInt(4));
            }
        }
    }

    public static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:main.db");
        stmt = connection.createStatement();
    }

    public static void disconnect(){
        try {
            if (stmt != null){
                stmt.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        try {
            if (psInsert != null){
                psInsert.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        try {
            if (connection != null){
                connection.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void getDbId() {
        Field[] fields = testClass.getDeclaredFields();
        for (Field f : fields) {
            if (f.isAnnotationPresent(DbId.class)) {
                this.dbId = f.getName();
            }
        }
    }
}
