package ru.geekbrains.courses.java.LautkinaT.Lesson5;

/*
1. Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.
2. Конструктор класса должен заполнять эти поля при создании объекта.
3. Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.
4. Создать массив из 5 сотрудников.
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);
5. С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
*/


public class Employee {
    private String name;
    private String post;
    private String email;
    private String phoneNumber;
    private int salary;
    private int age;

    Employee (String name, String post, String email, String phoneNumber, int salary, int age) {
        this.name = name;
        this.post = post;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.age = age;
    }

    int GetAge() {
        return age;
    }

    void Show() {
        System.out.println(name + "\n-" +
                "post: " + post + "\n-" +
                "email: " + email + "\n-" +
                "phoneNumber: " + phoneNumber + "\n-" +
                "salary: " + salary + "\n-" +
                "age: " + age);
        System.out.println();

    }
}
