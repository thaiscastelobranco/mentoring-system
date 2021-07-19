package com.internship.mentoringsystem.mentoring;

import com.internship.mentoringsystem.student.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MentoringRepository extends JpaRepository<Mentoring,Long> {
    @Query("SELECT d FROM Mentoring d WHERE d.mentoringType = ?1")
    Optional<Mentoring> findByMentoringType(String mentoringType);

}
