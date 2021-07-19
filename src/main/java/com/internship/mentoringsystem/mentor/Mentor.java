package com.internship.mentoringsystem.mentor;

import javax.persistence.*;

@Entity
@Table
public class Mentor {
    @Id
    @SequenceGenerator(
            name = "mentor_sequence",
            sequenceName = "mentor_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "mentor_sequence"
    )
    private Long id;
    private String mentorCpf;
    private String mentorName;
    private String mentorAddress;
    private String mentorEmail;

    public Mentor() {
    }

    public Mentor(Long id, String mentorCpf, String mentorName, String mentorAddress, String mentorEmail) {
        this.id = id;
        this.mentorCpf = mentorCpf;
        this.mentorName = mentorName;
        this.mentorAddress = mentorAddress;
        this.mentorEmail = mentorEmail;
    }

    public Mentor(String mentorCpf, String mentorName, String mentorAddress, String mentorEmail) {
        this.mentorCpf = mentorCpf;
        this.mentorName = mentorName;
        this.mentorAddress = mentorAddress;
        this.mentorEmail = mentorEmail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMentorCpf() {
        return mentorCpf;
    }

    public void setMentorCpf(String mentorCpf) {
        this.mentorCpf = mentorCpf;
    }

    public String getMentorName() {
        return mentorName;
    }

    public void setMentorName(String mentorName) {
        this.mentorName = mentorName;
    }

    public String getMentorAddress() {
        return mentorAddress;
    }

    public void setMentorAddress(String mentorAddress) {
        this.mentorAddress = mentorAddress;
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
                ", mentorCpf=" + mentorCpf +
                ", mentorName='" + mentorName + '\'' +
                ", mentorAddress='" + mentorAddress + '\'' +
                ", mentorEmail='" + mentorEmail + '\'' +
                '}';
    }
}
