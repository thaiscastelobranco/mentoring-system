package com.internship.mentoringsystem.classes;

import javax.persistence.*;

@Entity
@Table
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
    private Long id;
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
