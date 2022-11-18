package ru.geekbrains.courses.java.LautkinaT.Lesson6;

/*
1. Создать классы Собака и Кот с наследованием от класса Животное.
2. Все животные могут бежать и плыть.
В качестве параметра каждому методу передается длина препятствия.
Результатом выполнения действия будет печать в консоль. (Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');
3. У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.;
плавание: кот не умеет плавать, собака 10 м.).
4.* Добавить подсчет созданных котов, собак и животных.
*/

public class Main_Lesson6 {
    public static void main(String[] args) {
        Animal[] pets = {
                new Dog("Султан", "черный", 2),
                new Dog("Бай", "серый", 1),
                new Dog("Лорд", "белый", 2.3f),
                new Cat("Ларсик", "белый", 1.3f),
                new Cat("Сир Царапка", "серый", 1.5f),
                new Cat("Маркиз", "черный", 2),
        };


        for (Animal a :
                pets) {
            System.out.println(a);
        }

        System.out.println("Всего кошек: " + Cat.getCount());
        System.out.println("Всего собак: " + Dog.getCount());
        System.out.println("Всего животных: " + Animal.getCount());

    }

}



