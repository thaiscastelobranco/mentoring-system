package com.internship.mentoringsystem.student;

public class Student {
    private Long id;
    private Integer cpf;
    private String studentName;
    private String studentAdress;
    private String studentEmail;

    public Student() {
    }

    public Student(Long id, Integer cpf, String studentName, String studentAdress, String studentEmail) {
        this.id = id;
        this.cpf = cpf;
        this.studentName = studentName;
        this.studentAdress = studentAdress;
        this.studentEmail = studentEmail;
    }

    public Student(Integer cpf, String studentName, String studentAdress, String studentEmail) {
        this.cpf = cpf;
        this.studentName = studentName;
        this.studentAdress = studentAdress;
        this.studentEmail = studentEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCpf() {
        return cpf;
    }

    public void setCpf(Integer cpf) {
        this.cpf = cpf;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentAdress() {
        return studentAdress;
    }

    public void setStudentAdress(String studentAdress) {
        this.studentAdress = studentAdress;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail() {
        this.studentEmail = studentEmail;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", cpf=" + cpf +
                ", studentName='" + studentName + '\'' +
                ", studentAdress='" + studentAdress + '\'' +
                ", studentEmail='" + studentEmail + '\'' +
                '}';
    }
}
