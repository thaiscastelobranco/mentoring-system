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

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException("This student with id: " + studentId + "already exists");
        }
        studentRepository.deleteById(studentId);
    }

    public void updateStudent(Long studentId, String studentCpf, String studentName, String studentAddress, String studentEmail) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException("Mentor with id: " + studentId + "does not exist."));
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