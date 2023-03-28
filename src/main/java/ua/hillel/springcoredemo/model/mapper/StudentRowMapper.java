package ua.hillel.springcoredemo.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.hillel.springcoredemo.model.entity.School;
import ua.hillel.springcoredemo.model.entity.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("st.id"));
        student.setFirstName(rs.getString("st.first_name"));
        student.setLastName(rs.getString("st.last_name"));

        School school = new School();
        school.setId(rs.getInt("sc.id"));
        school.setName(rs.getString("sc.name"));

        student.setSchool(school);

        return student;
    }
}
