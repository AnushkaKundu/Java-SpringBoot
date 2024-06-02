package com.example.demo.student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException(
                "Student with id " + studentId + " not found"
        ));

        if (name != null &&
                !name.isEmpty() &&
            !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (email != null &&
                !email.isEmpty() &&
                !Objects.equals(student.getEmail(), email)) {
            Optional<Student> optionalStudent = studentRepository.findStudentByEmail(email);
            if (optionalStudent.isPresent()) {
                throw new IllegalStateException("Student with email " + email + " already exists");
            } else {
                student.setEmail(email);
            }
        }
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail =  studentRepository
                .findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException("Student with email " + student.getEmail() + " already exists");
        } else {
            studentRepository.save(student);
        }
//        System.out.println(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("Student with id " + studentId + " does not exist");
        }
        studentRepository.deleteById(studentId);
    }
}
