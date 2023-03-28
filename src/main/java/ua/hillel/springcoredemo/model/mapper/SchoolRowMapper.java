package ua.hillel.springcoredemo.model.mapper;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import ua.hillel.springcoredemo.model.entity.School;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class SchoolRowMapper implements RowMapper<School> {
    @Override
    public School mapRow(ResultSet rs, int rowNum) throws SQLException {
//        rs.next();

        School school = new School();
        school.setId(rs.getInt("id"));
        school.setName(rs.getString("name"));

        return school;
    }
}
