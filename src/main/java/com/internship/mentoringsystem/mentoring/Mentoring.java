package com.internship.mentoringsystem.mentoring;

import com.internship.mentoringsystem.classes.Classes;
import com.internship.mentoringsystem.mentor.Mentor;
import com.internship.mentoringsystem.student.Student;

public class Mentoring {
    private Long id;
    private String mentoringType;
    private Classes classes;
    private Mentor mentor;
    private Student student;

    public Mentoring(Long id, String mentoringType, Classes classes, Mentor mentor, Student student) {
        this.id = id;
        this.mentoringType = mentoringType;
        this.classes = classes;
        this.mentor = mentor;
        this.student = student;
    }

    public Mentoring (String mentoringType, Classes classes, Mentor mentor, Student student) {
        this.mentoringType = mentoringType;
        this.classes = classes;
        this.mentor = mentor;
        this.student = student;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMentoringType() {
        return mentoringType;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Mentoring{" +
                "id=" + id +
                ", mentoringType='" + mentoringType + '\'' +
                ", classes=" + classes +
                ", mentor=" + mentor +
                ", student=" + student +
                '}';
    }
}
