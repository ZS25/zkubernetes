package com.sooruth.zkubernetes;

import com.github.javafaker.Faker;
import com.sooruth.zkubernetes.entity.Student;
import com.sooruth.zkubernetes.repository.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.jdbc.JdbcConnectionDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ApplicationConfig {

    private final Logger LOG = LoggerFactory.getLogger(ApplicationConfig.class);


    @Bean
    /**
     * @apiNote This method will execute just after the context is created to initialise the database with some records.
     */
    public CommandLineRunner commandLineRunner(JdbcConnectionDetails jdbcConnectionDetails, StudentRepository studentRepository){
        return args -> {
            displayDatabaseConnectionDetails(jdbcConnectionDetails);
            fillStudentTableAtStartup(studentRepository);
        };
    }

    private void displayDatabaseConnectionDetails(JdbcConnectionDetails jdbcConnectionDetails) {
        String databaseConnectionDetails = StringTemplate.STR."""
                class: \{jdbcConnectionDetails.getClass().getName()}
                JDBC URL: \{jdbcConnectionDetails.getJdbcUrl()}
                Username: \{jdbcConnectionDetails.getUsername()}
                Password: \{jdbcConnectionDetails.getPassword()}
                """;
        LOG.info(databaseConnectionDetails);
    }

    private void fillStudentTableAtStartup(StudentRepository studentRepository) {
        Faker faker = new Faker();
        List<Student> studentList = new ArrayList<>(20);
        for (int i = 0; i < 20; i++) {
            final String firstName = faker.name().firstName();
            final String lastName = faker.name().lastName();
            final String email = String.format("%s.%s@zkubernetes.edu",firstName,lastName);
            final int age = faker.number().numberBetween(18,99);
            final Student student = new Student(firstName,lastName,email,age);

            studentList.add(student);
        }
        studentRepository.saveAll(studentList);
        LOG.info(String.format("Number of records in T_STUDENT at startup: %d", studentRepository.count()));
    }

}
