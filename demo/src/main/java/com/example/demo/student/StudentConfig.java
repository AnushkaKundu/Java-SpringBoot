package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Configuration
public class StudentConfig {
    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return args -> {
            Student mary= new Student(
                    "mary",
                    "mary@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );
            Student mariam= new Student(
                    "mariam",
                    "mariam@gmail.com",
                    LocalDate.of(2004, Month.FEBRUARY, 3)
            );

            studentRepository.saveAll(
                    List.of(mary,mariam)
            );
        };
    }
}
