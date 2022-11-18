package ru.geekbrains.courses.java.LautkinaT.Lesson6;

public abstract class Animal {
    public static int count;
    String name;
    String color;
    float age;

    public Animal() {

        count++;
    }

    public static int getCount() {

        return Animal.count;
    }

    public abstract boolean run(float distance);

    public abstract boolean swim(float distance);
}
