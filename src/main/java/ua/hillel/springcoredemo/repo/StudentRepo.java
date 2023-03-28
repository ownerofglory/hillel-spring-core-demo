package ua.hillel.springcoredemo.repo;

import ua.hillel.springcoredemo.model.entity.Student;

public interface StudentRepo {
    Student add(Student student);
    Student findById(Integer id);
}
