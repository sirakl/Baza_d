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
}
