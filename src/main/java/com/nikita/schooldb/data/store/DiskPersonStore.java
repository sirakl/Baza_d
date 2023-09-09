package com.nikita.schooldb.data.store;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nikita.schooldb.data.entity.Person;
import com.nikita.schooldb.data.entity.Student;
import com.nikita.schooldb.data.entity.Teacher;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class DiskPersonStore implements PersonStore {
    private final String teacherFilePath = "teachers.json";
    private final String studentFilePath = "students.json";
    private final Gson gson = new Gson();

    @Override
    public void addTeacher(String firstName, String lastName, String specialty) {
        List<Teacher> teachers = loadTeachers();
        int id = teachers.size();
        Teacher teacher = new Teacher(id, firstName, lastName, specialty);
        teachers.add(teacher);
        saveTeachers(teachers);
    }

    @Override
    public void addStudent(String firstName, String lastName, int grade) {
        List<Student> students = loadStudents();
        int id = students.size();
        Student student = new Student(id, firstName, lastName, grade);
        students.add(student);
        saveStudents(students);
    }

    @Override
    public List<Person> getAll() {
        List<Person> allPeople = new ArrayList<>();
        allPeople.addAll(loadTeachers());
        allPeople.addAll(loadStudents());
        return allPeople;
    }

    @Override
    public void removeRecord(int id) {
        List<Teacher> teachers = loadTeachers();
        List<Student> students = loadStudents();

        boolean removed = false;

        for (int i = 0; i < teachers.size(); i++) {
            if (teachers.get(i).id == id) {
                teachers.remove(i);
                saveTeachers(teachers);
                removed = true;
                break;
            }
        }

        if (!removed) {
            for (int i = 0; i < students.size(); i++) {
                if (students.get(i).id == id) {
                    students.remove(i);
                    saveStudents(students);
                    removed = true;
                    break;
                }
            }
        }

        if (removed) {
            System.out.println("Запис з ID " + id + " видалено.");
        } else {
            System.out.println("Неможливо знайти запис з ID " + id);
        }
    }

    private List<Teacher> loadTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        try (Reader reader = new FileReader(teacherFilePath)) {
            Type type = new TypeToken<List<Teacher>>() {}.getType();
            teachers = gson.fromJson(reader, type);
        } catch (IOException e) {

        }
        return teachers;
    }

    private void saveTeachers(List<Teacher> teachers) {
        try (Writer writer = new FileWriter(teacherFilePath)) {
            gson.toJson(teachers, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Student> loadStudents() {
        List<Student> students = new ArrayList<>();
        try (Reader reader = new FileReader(studentFilePath)) {
            Type type = new TypeToken<List<Student>>() {}.getType();
            students = gson.fromJson(reader, type);
        } catch (IOException e) {

        }
        return students;
    }

    private void saveStudents(List<Student> students) {
        try (Writer writer = new FileWriter(studentFilePath)) {
            gson.toJson(students, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}