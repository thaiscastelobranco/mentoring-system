package com.internship.mentoringsystem.student;

import com.internship.mentoringsystem.mentor.Mentor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getStudentEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("This student already exists");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long id) {
        boolean exists = studentRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("This student with id: " + id + "already exists");
        }
        studentRepository.deleteById(id);
    }

    public void updateStudent(Long id, Student student) {
        studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Student with id: " + id + "does not exist."));
        student.setId(id);
        studentRepository.save(student);
    }
}