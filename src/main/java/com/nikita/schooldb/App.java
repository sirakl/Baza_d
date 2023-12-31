package com.nikita.schooldb;

import com.nikita.schooldb.data.entity.Person;
import com.nikita.schooldb.data.entity.Student;
import com.nikita.schooldb.data.entity.Teacher;
import com.nikita.schooldb.data.store.MemoryPersonStore;
import com.nikita.schooldb.data.store.PersonStore;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        PersonStore store = new MemoryPersonStore();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Виберіть команду:");
            System.out.println("-addTeacher: додати вчителя");
            System.out.println("-addStudent: додати учня");
            System.out.println("-displayList: показати список");
            System.out.println("-removeRecord: видалити запис");
            System.out.println("-quit: завершити программу");
            String command = scanner.nextLine();
            switch (command) {
                case "addTeacher":

                System.out.println("Введіть ім'я:");
                String firstName = scanner.nextLine();
                System.out.println("Введіть прізвище");
                String lastName = scanner.nextLine();
                    System.out.println("Введіть спеціалізацію:");
                    String specialty = scanner.nextLine();
                    store.addTeacher(firstName, lastName, specialty);
break;
                case "addStudent":
                    System.out.println("Введіть ім'я:");
                    String StudentfirstName = scanner.nextLine();
                    System.out.println("Введіть прізвище");
                    String StudentlastName = scanner.nextLine();
                    System.out.println("Введіть клас:");
                    int grade = scanner.nextInt();
                    store.addStudent(StudentfirstName, StudentlastName, grade);
break;
                case "displayList":
                System.out.println("Список всіх людей:");
                List<Person> people = store.getAll();
                for (int i = 0; i < people.size(); i++) {
                    System.out.println((i+1) + ". " + people.get(i).toString());
                }
break;
                case "removeRecord":
                    System.out.println("Введіть ID запису для видалення:");
                    int idToRemove = scanner.nextInt();
                    store.removeRecord(idToRemove);
                    break;
                case "quit":
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Неправильна команда.");
            }
        }
    }
}
