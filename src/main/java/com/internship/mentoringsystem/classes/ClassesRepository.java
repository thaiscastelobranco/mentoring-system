package com.internship.mentoringsystem.classes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long> {

    @Query("SELECT c FROM Classes c WHERE c.mentoringPeriod = ?1")
    Optional<Classes> findByMentoringPeriod(String mentoringPeriod);
}
