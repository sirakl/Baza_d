package com.nikita.schooldb.data.entity;

public class Student extends Person {
    public int grade;

    public Student(int id, String firstName, String lastName, int grade) {
        super(id, firstName, lastName);
        this.grade = grade;
    }

    @Override
    public String toString() {
        return super.toString() + ", Клас: " + grade;
    }
}
