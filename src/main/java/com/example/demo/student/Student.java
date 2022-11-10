package com.example.demo.student;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
@Table
public class Student {

    @Id
    @SequenceGenerator(
            name ="student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long id;
    private String name;
    private String email;
    private LocalDate dob;
    private Integer age;
    private String address;

    public Student(String name, String email, LocalDate dob, Integer age,String address) {
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
        this.address=address;
    }

    public Student(Long id, String name, String email, LocalDate dob, Integer age,String address) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.dob = dob;
        this.age = age;
        this.address=address;
    }
}
