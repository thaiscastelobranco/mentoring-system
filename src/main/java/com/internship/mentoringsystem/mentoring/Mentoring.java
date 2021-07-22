package com.internship.mentoringsystem.mentoring;

import com.internship.mentoringsystem.classes.Classes;
import com.internship.mentoringsystem.mentor.Mentor;
import com.internship.mentoringsystem.student.Student;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "tb_mentoring")
public class Mentoring {
    @Id
    @SequenceGenerator(
            name = "mentoring_sequence",
            sequenceName = "mentoring_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "mentoring_sequence"
    )
    @Column(name = "idt_mentoring")
    private Long id;
    @Column(name = "desc_mentoring_type")
    private String mentoringType;
    @ManyToOne
    @JoinColumn(name = "idt_classes", nullable = false)
    private Classes classes;
    @ManyToOne
    @JoinColumn(name = "idt_mentor", nullable = false)
    private Mentor mentor;

    public Mentoring() {
    }

    public Mentoring(Long id, String mentoringType, Classes classes, Mentor mentor) {
        this.id = id;
        this.mentoringType = mentoringType;
        this.classes = classes;
        this.mentor = mentor;
    }

    public Mentoring (String mentoringType, Classes classes, Mentor mentor) {
        this.mentoringType = mentoringType;
        this.classes = classes;
        this.mentor = mentor;
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

    public void setMentoringType(String mentoringType) { this.mentoringType = mentoringType; }

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

    @Override
    public String toString() {
        return "Mentoring{" +
                "id=" + id +
                ", mentoringType='" + mentoringType + '\'' +
                ", classes=" + classes +
                ", mentor=" + mentor +
                '}';
    }
}
