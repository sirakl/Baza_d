package com.nikita.schooldb.data.store;

import com.nikita.schooldb.data.entity.Person;

import java.util.List;

public interface PersonStore {

    void addTeacher(String firstName, String lastNAme, String speciality);

    void addStudent(String firstName, String lastNAme, int grade);

    List<Person> getAll();
}
