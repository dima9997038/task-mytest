package ru.otus.models;

public class Student {
    public String name;
    public String lastName;

    public Student(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Student  " + name + "  " + lastName;
    }
}
