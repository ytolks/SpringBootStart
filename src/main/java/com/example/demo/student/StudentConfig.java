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
    CommandLineRunner commandLineRunner (StudentRepository repository){
        return args -> {
           Student jevgenijs = new Student(
                    "Jevgenijs",
                    "yevgeniy.tolks@gmail.com",
                    LocalDate.of(1984, Month.JULY,4),
                    "Sergeja Eizensteina 69-20"
            );

            Student alina = new Student(
                    "Alina",
                    "alina.tolka@gmail.com",
                    LocalDate.of(1985, Month.MARCH,19),
                    "Sergeja Eizensteina 69-20"
            );
            repository.saveAll(List.of(jevgenijs,alina));
        };
    }
}
