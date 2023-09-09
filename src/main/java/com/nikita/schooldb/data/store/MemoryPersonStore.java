package com.nikita.schooldb.data.store;

import com.nikita.schooldb.data.entity.Person;
import com.nikita.schooldb.data.entity.Student;
import com.nikita.schooldb.data.entity.Teacher;

import java.util.ArrayList;
import java.util.List;

public class MemoryPersonStore implements PersonStore {
    private final List<Person> people = new ArrayList<>();

    @Override
    public void addTeacher(String firstName, String lastNAme, String speciality) {
        int id = people.size();
        people.add(new Teacher(id, firstName, lastNAme, speciality));
    }

    @Override
    public void addStudent(String firstName, String lastNAme, int grade) {
        int id = people.size();
        people.add(new Student(id, firstName, lastNAme, grade));
    }

    @Override
    public List<Person> getAll() {
        return people;
    }
    @Override
    public void removeRecord(int id) {
        for (int i = 0; i < people.size(); i++) {
            if (people.get(i).id == id) {
                people.remove(i);
                System.out.println("Запис з ID " + id + " видалено.");
                return;
            }
        }
        System.out.println("Неможливо знайти запис з ID " + id);
    }
}


