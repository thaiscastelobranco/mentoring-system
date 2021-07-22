package com.internship.mentoringsystem.mentor;

import com.internship.mentoringsystem.mentoring.Mentoring;

import javax.persistence.*;

@Entity
@Table(name = "tb_mentor")
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
    @Column(name = "idt_mentor")
    private Long id;
    @Column(name = "desc_cpf")
    private String mentorCpf;
    @Column(name = "desc_name")
    private String mentorName;
    @Column(name = "desc_address")
    private String mentorAddress;
    @Column(name = "desc_email")
    private String mentorEmail;
    @ManyToOne
    private Mentoring mentoring;

    public Mentor() {
    }

    public Mentor(Long id, String mentorCpf, String mentorName, String mentorAddress, String mentorEmail, Mentoring mentoring) {
        this.id = id;
        this.mentorCpf = mentorCpf;
        this.mentorName = mentorName;
        this.mentorAddress = mentorAddress;
        this.mentorEmail = mentorEmail;
        this.mentoring = mentoring;
    }

    public Mentor(String mentorCpf, String mentorName, String mentorAddress, String mentorEmail, Mentoring mentoring) {
        this.mentorCpf = mentorCpf;
        this.mentorName = mentorName;
        this.mentorAddress = mentorAddress;
        this.mentorEmail = mentorEmail;
        this.mentoring = mentoring;
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

    public Mentoring getMentoring() {
        return mentoring;
    }

    public void setMentoring(Mentoring mentoring) {
        this.mentoring = mentoring;
    }

    @Override
    public String toString() {
        return "Mentor{" +
                "id=" + id +
                ", mentorCpf=" + mentorCpf +
                ", mentorName='" + mentorName + '\'' +
                ", mentorAddress='" + mentorAddress + '\'' +
                ", mentorEmail='" + mentorEmail + '\'' +
                ", mentoring='" + mentoring + '\'' +
                '}';
    }
}
