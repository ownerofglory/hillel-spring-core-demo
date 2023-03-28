package ua.hillel.springcoredemo.model.entity;

import lombok.*;

import java.util.List;

@Data
@ToString(exclude = "students")
@AllArgsConstructor
@NoArgsConstructor
public class School {
    private  Integer id;
    private String name;

    private List<Student> students;
}
