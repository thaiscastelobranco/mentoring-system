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

    public void updateStudent(Long id, String studentCpf, String studentName, String studentAddress, String studentEmail) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("Mentor with id: " + id + "does not exist."));
        if (studentName != null && studentName.length() > 0 && !Objects.equals(student.getStudentName(), studentName)) {
            student.setStudentName(studentName);
        }
        if (studentCpf != null && studentCpf.length() > 0 && Objects.equals(student.getStudentCpf(), studentCpf)) {
            student.setStudentCpf(studentCpf);
        }
        if (studentAddress != null && studentAddress.length() > 0 && !Objects.equals(student.getStudentAddress(), studentAddress)) {
            student.setStudentAddress(studentAddress);
        }
        if (studentEmail != null && studentEmail.length() > 0
                && Objects.equals(student.getStudentEmail(), studentEmail)) {
            Optional<Student> studentOptional = studentRepository.findStudentByEmail(studentEmail);
            if (studentOptional.isPresent()) {
                throw new IllegalStateException("This student already exists.");
            }
            student.setStudentEmail(studentEmail);
        }
    }
}