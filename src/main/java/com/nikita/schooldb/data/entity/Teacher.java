package com.nikita.schooldb.data.entity;

public class Teacher extends Person {
    public String specialty;

    public Teacher(int id, String firstName, String lastName, String specialty) {
        super(id, firstName, lastName);
        this.specialty = specialty;
    }

    @Override
    public String toString() {
        return super.toString() + ", Спеціальність: " + specialty;
    }
}
