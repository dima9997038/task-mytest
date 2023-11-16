package ru.otus.repositories;

import ru.otus.models.Student;

import java.util.List;

public interface StudentRepository {
    List<Student> findAll();
    Student registration(Student student);
}
