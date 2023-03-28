package ua.hillel.springcoredemo.repo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ua.hillel.springcoredemo.model.entity.School;
import ua.hillel.springcoredemo.model.entity.Student;
import ua.hillel.springcoredemo.model.mapper.SchoolRowMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class SchoolSpringJdbcRepoTest {
    @Mock
    private JdbcTemplate jdbcTemplateMock;
    @Mock
    private SchoolRowMapper schoolRowMapperMock;

    private SchoolRepo schoolRepo;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        schoolRepo = new SchoolSpringJdbcRepo(jdbcTemplateMock, schoolRowMapperMock);
    }
    @Test
    public void addTest_success() {
        when(jdbcTemplateMock.update(anyString(), anyString()))
                .thenReturn(1);

        schoolRepo.add(new School() {{ setName(""); }});
    }

    @Test
    public void findByIdTest_success() {
        when(jdbcTemplateMock.queryForObject(anyString(), any(), any(RowMapper.class)))
                .thenReturn(new School());

        School byId = schoolRepo.findById(1);
        assertNotNull(byId);
    }

    @Test
    public void enrollTest_success() {
        when(jdbcTemplateMock.update(anyString(), anyInt(), anyInt()))
                .thenReturn(1);

        School testSchool = new School();
        Student testStudent = new Student();

        Student enrolledStudent = schoolRepo.enroll(testSchool, testStudent);

        assertNotNull(enrolledStudent);
        assertNotNull(enrolledStudent.getSchool());
        assertEquals(enrolledStudent.getSchool(), testSchool);
    }
}
