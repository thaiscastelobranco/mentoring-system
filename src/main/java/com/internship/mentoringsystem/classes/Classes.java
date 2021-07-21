package com.internship.mentoringsystem.classes;

import javax.persistence.*;

@Entity
@Table(name = "classes")
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
    private Long classesId;
    private String mentoringPeriod;

    public Classes(){
    }

    public Classes(Long classesId, String mentoringPeriod) {
        this.classesId = classesId;
        this.mentoringPeriod = mentoringPeriod;
    }

    public Classes(String mentoringPeriod) {
        this.mentoringPeriod = mentoringPeriod;
    }

    public Long getClassesId() {
        return classesId;
    }

    public void setClassesId(Long classesId) {
        this.classesId = classesId;
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
                "classesId=" + classesId +
                ", mentoringPeriod='" + mentoringPeriod + '\'' +
                '}';
    }
}
