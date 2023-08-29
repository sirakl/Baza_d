package com.nikita.schooldb;

import com.nikita.schooldb.data.entity.Person;
import com.nikita.schooldb.data.store.MemoryPersonStore;
import com.nikita.schooldb.data.store.PersonStore;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PersonStore store = new MemoryPersonStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Введіть 1 для додання вчителя або 2 для учня");
            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Введіть ім'я:");
            String firstName = scanner.nextLine();

            System.out.println("Введіть прізвище");
            String lastName = scanner.nextLine();

            if (choice == 1) {
                System.out.println("Введіть спеціалізацію:");
                String specialty = scanner.nextLine();
                store.addTeacher(firstName, lastName, specialty);

            } else if (choice == 2) {
                System.out.println("Введіть клас:");
                int grade = scanner.nextInt();
                store.addStudent(firstName, lastName, grade);
            }

            System.out.println("Список всіх людей:");
            List<Person> people = store.getAll();
            for (int i = 0; i < people.size(); i++) {
                System.out.println((i + 1) + ". " + people.get(i).toString());
            }


            System.out.println("Продовжити 1 вийти 2");
            int continueChoice = scanner.nextInt();
            if (continueChoice != 1) {
                break;
            }
            scanner.nextLine();
        }

        System.out.println("Кінець!!!!!!!");
    }
}
