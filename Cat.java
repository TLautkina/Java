package ru.geekbrains.courses.java.LautkinaT.Lesson7;

public class Cat {
    public String name;
    public int appetite;
    public boolean satiety;

    public Cat(String name, int appetite, boolean fullness) {
        this.name = name;
        this.appetite = appetite;
        this.satiety = satiety;
    }
//    @Override
//    public String toString() {
//        return "Кот: " +
//                "кличка = '" + this.name + '\'' +
//                ", окрас = '" + this.color + '\'' +
//                ", возраст = " + this.age + " лет" +
//                ", пробежал " + this.runDistance + " м" +
//                ", не может плавать.";
    public void eat(Plate p) {
        p.decreaseFood(appetite);
    }
}