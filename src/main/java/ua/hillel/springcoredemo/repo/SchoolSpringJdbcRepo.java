package ua.hillel.springcoredemo.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ua.hillel.springcoredemo.model.entity.School;
import ua.hillel.springcoredemo.model.entity.Student;
import ua.hillel.springcoredemo.model.mapper.SchoolRowMapper;

@Repository
@RequiredArgsConstructor
public class SchoolSpringJdbcRepo implements SchoolRepo {
    private final JdbcTemplate jdbcTemplate;
    private final SchoolRowMapper schoolRowMapper;

    @Override
    public void add(School school) {
        String sql = "INSERT INTO t_school " +
                "(name) " +
                "VALUES (?) ";
        jdbcTemplate.update(sql, school.getName());
    }

    @Override
    public School findById(Integer id) {
        String sql = "SELECT * FROM t_school WHERE id = ? ";
        return jdbcTemplate.queryForObject(sql, new Object[] { id }, schoolRowMapper);
    }

    @Override
    public Student enroll(School school, Student student) {
        String sql = "UPDATE t_student " +
                "SET school_id = ? " +
                "WHERE id = ?";

        jdbcTemplate.update(sql, school.getId(), student.getId());
        student.setSchool(school);

        return student;
    }
}
