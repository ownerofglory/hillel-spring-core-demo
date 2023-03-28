package ua.hillel.springcoredemo.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.KeyHolder;
import ua.hillel.springcoredemo.model.entity.Student;
import ua.hillel.springcoredemo.model.mapper.StudentRowMapper;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class StudentSpringJdbcRepoTest {
    private StudentRepo studentRepo;
    @Mock
    private JdbcTemplate jdbcTemplateMock;
    @Mock
    private StudentRowMapper studentRowMapperMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        studentRepo = new StudentSpringJdbcRepo(jdbcTemplateMock, studentRowMapperMock);
    }

    @Test
    public void addTest_success() {
        Student testStudent = new Student();

                when(jdbcTemplateMock
                .update(any(PreparedStatementCreator.class),
                        any(KeyHolder.class))
                ).thenReturn(0);


        Student added = studentRepo.add(testStudent);

        assertNotNull(added);
    }

    @Test
    public void findByIdTest_success() throws SQLException {
        when(jdbcTemplateMock
                .queryForObject(anyString(), any(), any(RowMapper.class)))
                .thenReturn(new Student());

        when(studentRowMapperMock.mapRow(any(), anyInt()))
                .thenReturn(new Student());

        studentRepo.findById(100);
    }
}
