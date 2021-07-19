package com.internship.mentoringsystem.mentor;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    @Query("SELECT m FROM Mentor m WHERE m.mentorEmail = ?1")
    Optional<Mentor> findMentorByEmail(String mentorEmail);

}
