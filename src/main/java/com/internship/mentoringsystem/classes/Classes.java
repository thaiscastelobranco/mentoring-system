package com.internship.mentoringsystem.classes;

import com.internship.mentoringsystem.mentoring.Mentoring;

import javax.persistence.*;

@Entity
@Table(name = "tb_classes")
public class Classes {
    @Id
    @SequenceGenerator(
            name = "classes_sequence",
            sequenceName = "classes_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "classes_sequence"
    )
    @Column(name = "idt_class")
    private Long id;
    @Column(name = "desc_mentoring_period")
    private String mentoringPeriod;

    public Classes(){
    }

    public Classes(Long id, String mentoringPeriod) {
        this.id = id;
        this.mentoringPeriod = mentoringPeriod;
    }

    public Classes(String mentoringPeriod) {
        this.mentoringPeriod = mentoringPeriod;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMentoringPeriod() {
        return mentoringPeriod;
    }

    public void setMentoringPeriod(String mentoringPeriod) {
        this.mentoringPeriod = mentoringPeriod;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", mentoringPeriod='" + mentoringPeriod + '\'' +
                '}';
    }
}
