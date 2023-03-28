package ua.hillel.springcoredemo.repo;

import ua.hillel.springcoredemo.model.entity.School;
import ua.hillel.springcoredemo.model.entity.Student;

public interface SchoolRepo {
    void add(School school);
    School findById(Integer id);
    Student enroll(School school, Student student);
}
