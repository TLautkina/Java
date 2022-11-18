package ru.geekbrains.courses.java.LautkinaT.Lesson6;

import java.util.Random;

public class Cat extends Animal {
    private static int count;
    private final float RUN_DISTANCE = new Random().nextInt(200);
    //случайное число метров с ограничением дистанции до 200 м
    private final float SWIM_DISTANCE = 0.0f;
    //не плавает
    private float runDistance;
    private float swimDistance;

    public Cat(String name, String color, float age) {
        this.name = name;
        this.color = color;
        this.age = age;
        this.runDistance = RUN_DISTANCE;
        this.swimDistance = SWIM_DISTANCE;
        Cat.count++;
    }

    public static int getCount() {
        return Cat.count;
    }

    @Override
    public String toString() {
        return "Кот: " +
                "кличка = '" + this.name + '\'' +
                ", окрас = '" + this.color + '\'' +
                ", возраст = " + this.age + " лет" +
                ", пробежал " + this.runDistance + " м" +
                ", не может плавать.";
    }

    @Override
    public boolean swim(float distance) {
        return false;
    }

    @Override
    public boolean run(float distance) {
        return !(distance > this.runDistance && distance > 0);
    }

}
