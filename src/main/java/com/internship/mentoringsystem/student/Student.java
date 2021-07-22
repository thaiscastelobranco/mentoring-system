package com.internship.mentoringsystem.student;

import com.internship.mentoringsystem.classes.Classes;

import javax.persistence.*;

@Entity
@Table(name = "tb_student")
public class Student {
    @Id
    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue (
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    @Column(name = "idt_student")
    private Long id;
    @Column(name = "desc_cpf")
    private String studentCpf;
    @Column(name = "desc_name")
    private String studentName;
    @Column(name = "desc_address")
    private String studentAddress;
    @Column(name = "desc_email")
    private String studentEmail;
    @ManyToOne
    @JoinColumn(name = "idt_classes", nullable = false)
    private Classes classes;

    public Student() {
    }

    public Student(Long id, String studentCpf, String studentName, String studentAddress, String studentEmail, Classes classes) {
        this.id = id;
        this.studentCpf = studentCpf;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentEmail = studentEmail;
        this.classes = classes;
    }

    public Student(String studentCpf, String studentName, String studentAddress, String studentEmail, Classes classes) {
        this.studentCpf = studentCpf;
        this.studentName = studentName;
        this.studentAddress = studentAddress;
        this.studentEmail = studentEmail;
        this.classes = classes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentCpf() {
        return studentCpf;
    }

    public void setStudentCpf(String studentCpf) {
        this.studentCpf = studentCpf;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentCpf=" + studentCpf +
                ", studentName='" + studentName + '\'' +
                ", studentAddress='" + studentAddress + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                ", classes='" + '\'' +
                '}';
    }
}
