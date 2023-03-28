package ua.hillel.springcoredemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ua.hillel.springcoredemo.model.entity.School;
import ua.hillel.springcoredemo.model.entity.Student;
import ua.hillel.springcoredemo.repo.SchoolRepo;
import ua.hillel.springcoredemo.repo.StudentRepo;

public class Main {
    public static void main(String[] args) {
//        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext context = new AnnotationConfigApplicationContext("ua.hillel.springcoredemo");

//        WeatherService weatherService = (WeatherService) context.getBean(WeatherService.class);
//
//        Weather weatherInKyiv = weatherService.getWeatherByCity("Kyiv");

        SchoolRepo schoolRepo = context.getBean(SchoolRepo.class);
        StudentRepo studentRepo = context.getBean(StudentRepo.class);

//        schoolRepo.add(school);
        School schoolById = schoolRepo.findById(1);

        Student student = new Student();
        student.setFirstName("Vasyl");
        student.setLastName("Petrenko");

        Student addedStudent = studentRepo.add(student);

        schoolRepo.enroll(schoolById, addedStudent);

        studentRepo.findById(addedStudent.getId());

        System.out.println();
    }
}