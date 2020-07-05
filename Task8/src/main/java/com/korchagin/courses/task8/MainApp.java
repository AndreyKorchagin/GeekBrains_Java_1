package com.korchagin.courses.task8;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MainApp {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
    }

    static void task1(){
        String text = "Вест Вхолостую Запрокинуться Кельнер Матрона Наметить Немедля Одноколейный Самобранка Сволочь " +
                "Благожелатель Бобыль Владыка Квалитативный Объектив Оркестр Пробавляться Скомпоновать Факир Формат " +
                "Замазка Клей Лимита Мамонтенок Маршевый Походка Проблеск Тувинцы Шлифовать Ястык " +
                "Боярин Генеральша Мариновать Нетель Окровенить Офис Пагода Протирочный Проткнуть Человекообразный " +
                "Беременная Благорасположение Втрескаться Доканывать Макать Мойва Полюбоваться Скапывать Собраться Шлакобетон " +
                "Вахлак Занемочь Клясть Морализировать Наперекос Обратимый Оглядываться Просорушка Развернуться Шпинат " +
                "Добытчик Запретить Каменноугольный Метрика Негожий Незавершенка Подземный Придирчивый Протопить Форпост " +
                "Аура Балясничать Вещмешок Гигиенист Кинжал Пикантный Раздобриться Самотек Хлеб-соль Чартер " +
                "Вредность Гидросфера Замечтаться Параллельный Перекладка Призрачный Пробираться Проблеск Разъединиться Световод " +
                "Борщок Босоножки Бочарный Глубокоуважаемый Горноспасатель Изгнание Инструментарий Истомить Кулич Опора";

        String outText = Stream.of(text.split(" "))
                .filter(str -> str.length() > 5)
                .collect(Collectors.joining(" "));
        System.out.println(outText.length());
    }

    static void task2(){
        String[][] array = {{"Зимой", "Отфутболить", "Проделка", "Телогрейка", "Флигель"},
                            {"Зимой", "Отфутболить", "Проделка", "Телогрейка", "Флигель"},
                            {"Зимой", "Отфутболить", "Проделка", "Телогрейка", "Флигель"},
                            {"Зимой", "Отфутболить", "Проделка", "Телогрейка", "Флигель"},
                            {"Зимой", "Отфутболить", "Проделка", "Телогрейка", "Флигель"},
                            };

        List<String> uniqueWords = Arrays.stream(array).flatMap(Arrays::stream).distinct().collect(Collectors.toList());
        System.out.println(uniqueWords);
    }
    static void task3(){
        int sum = IntStream.rangeClosed(100, 200).filter(i -> i % 2 == 0).sum();
        System.out.println(sum);

    }
    static void task4(){
        String[] array = {"Зимой", "Отфутболить", "Проделка", "Телогрейка", "Флигель"};
        int sum = Arrays.stream(array).mapToInt(String::length).sum();
        System.out.println(sum);
    }
    static void task5(){
        String[] array = {"Зимой", "Отфутболить", "Проделка", "Телогрейка", "Флигель"};
        List<String> list = Arrays.stream(array).sorted().limit(3).collect(Collectors.toList());
        System.out.println(list);
    }

}
