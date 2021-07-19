package com.internship.mentoringsystem.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getStudent() {
        return studentService.getStudent();
    }

    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @DeleteMapping(path = "{studentId}")
    public void deleteClasses(@PathVariable ("studentId") Long studentId) {
        studentService.deleteStudent(studentId);
    }

    @PutMapping(path = "{studentId}")
    public void updateStudent(
            @PathVariable("Student") Long studentId,
            @RequestParam(required = false) String studentCpf,
            @RequestParam(required = false) String studentName,
            @RequestParam(required = false) String studentAddress,
            @RequestParam(required = false) String studentEmail) {
        studentService.updateStudent(studentId, studentCpf, studentName, studentAddress, studentEmail);
    }
}
