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

    @DeleteMapping(path = "{id}")
    public void deleteClasses(@PathVariable ("id") Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "{id}")
    public void updateStudent(
            @PathVariable("Student") Long id,
            @RequestParam(required = false) String studentCpf,
            @RequestParam(required = false) String studentName,
            @RequestParam(required = false) String studentAddress,
            @RequestParam(required = false) String studentEmail) {
        studentService.updateStudent(id, studentCpf, studentName, studentAddress, studentEmail);
    }
}
