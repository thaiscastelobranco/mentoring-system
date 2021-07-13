package com.internship.mentoringsystem.mentor;

public class Mentor {
    private Long id;
    private Integer cpf;
    private String mentorName;
    private String mentorAdress;
    private String mentorEmail;

    public Mentor() {
    }

    public Mentor(Long id, Integer cpf, String mentorName, String mentorAdress, String mentorEmail) {
        this.id = id;
        this.cpf = cpf;
        this.mentorName = mentorName;
        this.mentorAdress = mentorAdress;
        this.mentorEmail = mentorEmail;
    }

    public Mentor(Integer cpf, String mentorName, String mentorAdress, String mentorEmail) {
        this.cpf = cpf;
        this.mentorName = mentorName;
        this.mentorAdress = mentorAdress;
        this.mentorEmail = mentorEmail;
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

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public String getMentorAdress() {
        return mentorAdress;
    }

    public void setMentorAdress(String mentorAdress) {
        this.mentorAdress = mentorAdress;
    }

    public String getMentorEmail() {
        return mentorEmail;
    }

    public void setMentorEmail(String mentorEmail) {
        this.mentorEmail = mentorEmail;
    }

    @Override
    public String toString() {
        return "Mentor{" +
                "id=" + id +
                ", cpf=" + cpf +
                ", mentorName='" + mentorName + '\'' +
                ", mentorAdress='" + mentorAdress + '\'' +
                ", mentorEmail='" + mentorEmail + '\'' +
                '}';
    }
}
