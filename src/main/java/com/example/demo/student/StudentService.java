package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //Bean instantiated
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) { //DI
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        //will be converted to JSON object in the browser
        return studentRepository.findAll(); //returns a list of students
    }
}
