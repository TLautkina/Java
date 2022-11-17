package ru.geekbrains.courses.java.LautkinaT.Lesson5;

public class Company {
    public static void main(String[] args) {
        Employee [] persArray = new Employee[5];
        persArray[0] = new Employee("Amirova Maria", "Cleaning Manager", "amirovam@mailbox.com",
                "89999007700", 12000, 50);
        persArray[1] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com",
                "89999007701", 60000, 41);
        persArray[2] = new Employee("Petrov Alex", "General Manager", "petrovalex@mailbox.com",
                "89999007702", 50000, 45);
        persArray[3] = new Employee("Sidorov Semen", "System Administrator", "sidorovs@mailbox.com",
                "89999007703", 65000, 34);
        persArray[4] = new Employee("Yakovleva Yulia", "Secretary", "yakovlevaya@mailbox.com",
                "89999007704", 13000, 35);

        System.out.println("Список сотрудников старше 40 лет:");

        for (Employee employee : persArray) {
            if (employee.GetAge() > 40) employee.Show();

        }
    }

}
