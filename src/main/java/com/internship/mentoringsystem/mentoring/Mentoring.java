package com.internship.mentoringsystem.mentoring;

import com.internship.mentoringsystem.classes.Classes;
import com.internship.mentoringsystem.mentor.Mentor;
import com.internship.mentoringsystem.student.Student;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "mentoring")
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
    private Long mentoringId;
    private String mentoringType;
    @OneToMany
    private Set<Classes> classes;
    @OneToOne
    @Embedded
    private Mentor mentor;
    @OneToMany
    private Set<Student> student;

    public Mentoring() {
    }

    public Mentoring(Long mentoringId, String mentoringType, Set<Classes> classes, Mentor mentor, Set<Student> student) {
        this.mentoringId = mentoringId;
        this.mentoringType = mentoringType;
        this.classes = classes;
        this.mentor = mentor;
        this.student = student;
    }

    public Mentoring (String mentoringType, Set<Classes> classes, Mentor mentor, Set<Student> student) {
        this.mentoringType = mentoringType;
        this.classes = classes;
        this.mentor = mentor;
        this.student = student;
    }

    public Long getMentoringId() {
        return mentoringId;
    }

    public void setId(Long mentoringId) {
        this.mentoringId = mentoringId;
    }

    public String getMentoringType() {
        return mentoringType;
    }

    public void setMentoringType(String mentoringType) { this.mentoringType = mentoringType; }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "classes")
    public Set<Classes> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classes> classes) {
        this.classes = classes;
    }

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "mentor")
    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Mentoring{" +
                "mentoringId=" + mentoringId +
                ", mentoringType='" + mentoringType + '\'' +
                ", classes=" + classes +
                ", mentor=" + mentor +
                ", student=" + student +
                '}';
    }
}
