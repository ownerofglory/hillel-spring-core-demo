package ua.hillel.springcoredemo.repo;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ua.hillel.springcoredemo.model.entity.Student;
import ua.hillel.springcoredemo.model.mapper.StudentRowMapper;

import java.sql.PreparedStatement;
import java.sql.Statement;

@Repository
@RequiredArgsConstructor
public class StudentSpringJdbcRepo implements StudentRepo {
    private final JdbcTemplate jdbcTemplate;
    private final StudentRowMapper studentRowMapper;

    @Override
    public Student add(Student student) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        String sql = "INSERT INTO t_student (first_name, last_name) " +
                "VALUES (?, ?)";
        jdbcTemplate.update(conn -> {
            PreparedStatement statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, student.getFirstName());
            statement.setString(2, student.getLastName());

            return statement;
        }, keyHolder);

        Number key = keyHolder.getKey();
        if (key != null) {
            student.setId(key.intValue());
        }
        return student;
    }

    @Override
    public Student findById(Integer id) {
        String sql = "SELECT st.*, sc.* FROM t_student AS st " +
                "JOIN t_school AS sc " +
                "ON st.school_id = sc.id " +
                "WHERE st.id = ? ";
        return jdbcTemplate.queryForObject(sql, new Object[] { id }, studentRowMapper);
    }
}
