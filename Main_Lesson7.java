package ru.geekbrains.courses.java.LautkinaT.Lesson7;
/*
1. Расширить задачу про котов и тарелки с едой.
2. Сделать так, чтобы в тарелке с едой не могло получиться отрицательного количества еды
(например, в миске 10 еды, а кот пытается покушать 15-20).
3. Каждому коту нужно добавить поле сытость (когда создаем котов, они голодны).
Если коту удалось покушать (хватило еды), сытость = true.
4. Считаем, что если коту мало еды в тарелке, то он её просто не трогает,
то есть не может быть наполовину сыт (это сделано для упрощения логики программы).
5. Создать массив котов и тарелку с едой, попросить всех котов покушать из этой тарелки
и потом вывести информацию о сытости котов в консоль.
6. Добавить в тарелку метод, с помощью которого можно было бы добавлять еду в тарелку.
*/

import java.util.Scanner;

public class Main_Lesson7 {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int action;
        Cat[] allCats = new Cat[4];
        allCats[0] = new Cat("Ларсик", 5, false);
        allCats[1] = new Cat("Барсик", 30, false);
        allCats[2] = new Cat("Марсик", 10, false);
        allCats[3] = new Cat("Сир Царапка", 45, false);

        System.out.println("Начинаем кормить котов!");
        Plate plate = new Plate(50);
        plate.info();
        for (int i = 0; i < allCats.length; i++) {
            if (allCats[i].satiety == false && allCats[i].appetite < plate.food){
                allCats[i].eat(plate);
                allCats[i].satiety = true;
                System.out.println("Котик " + allCats[i].name + " поел!");
            } else {
                System.out.println("Котик " + allCats[i].name + " не стал есть, ему не хватает еды!");
            }
        }
        plate.info();
        System.out.println("Сколько грамм корма добавить еще в миску?");
        action = sc.nextInt();
        plate.increaseFood(action);
        plate.info();

    }
}