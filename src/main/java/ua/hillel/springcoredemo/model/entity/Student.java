package ua.hillel.springcoredemo.model.entity;

import lombok.Data;
import lombok.ToString;

@Data
public class Student {
    private Integer id;
    private String firstName;
    private String lastName;

    private School school;
}
