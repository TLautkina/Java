package ru.geekbrains.courses.java.LautkinaT.Lesson6;

import java.util.Random;

public class Dog extends Animal {
    private static int count;
    private final float RUN_DISTANCE = new Random().nextInt(500);
    //случайное число метров с ограничением дистанции бега 500м
    private final float SWIM_DISTANCE = new Random().nextInt(10);
    //случайное число метров с ограничением дистанции плаванья 10м
    private float runDistance;
    private float swimDistance;

    public Dog(String name, String color, float age) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.runDistance = RUN_DISTANCE;
        this.swimDistance = SWIM_DISTANCE;

        Dog.count++;
    }

    public static int getCount() {
        return Dog.count;
    }

    @Override
    public String toString() {
        return "Собака: " +
                "кличка = '" + this.name + '\'' +
                ", окрас = '" + this.color + '\'' +
                ", возраст = " + this.age + " лет" +
                ", пробежал " + this.runDistance + " м" +
                ", проплыл " + this.swimDistance + " м.";
    }

    @Override
    public boolean run(float distance) {
        return !(distance > this.runDistance && distance > 0);
    }

    @Override
    public boolean swim(float distance) {
        return !(distance > this.swimDistance && distance > 0);
    }

}

