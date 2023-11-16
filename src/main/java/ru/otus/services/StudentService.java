package ru.otus.services;

import ru.otus.models.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    Student registration(Student student);

    Student getById(Integer id);
}
