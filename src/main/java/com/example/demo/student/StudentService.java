package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("This email is taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("student id not found");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {

        Student student = studentRepository.findById(studentId)
                .orElseThrow(() ->
                        new IllegalStateException("student with id" + studentId + "does not exist"));


        if (name != null && name.length() > 0 && (!Objects.equals(student.getName(), name))) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && (!Objects.equals(student.getEmail(), email))) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(email);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("Email already exists");
            }
            student.setEmail(email);
        }
    }
}
