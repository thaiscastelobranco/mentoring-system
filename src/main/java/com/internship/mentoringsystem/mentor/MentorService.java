package com.internship.mentoringsystem.mentor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class MentorService {
    private final MentorRepository mentorRepository;

    @Autowired
    public MentorService(MentorRepository mentorRepository) {
        this.mentorRepository = mentorRepository;
    }

    @GetMapping
    public List<Mentor> getMentor() {
        return mentorRepository.findAll();
    }

    public void addNewMentor(Mentor mentor) {
        Optional<Mentor> mentorOptional = mentorRepository.findMentorByEmail(mentor.getMentorEmail());
        if (mentorOptional.isPresent()) {
            throw new IllegalStateException("The mentor already exists");
        }
        mentorRepository.save(mentor);
    }

    public void deleteMentor(Long id) {
        boolean exists = mentorRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("This mentor with " + id + " already exists.");
        }
        mentorRepository.deleteById(id);
    }

    //@Transactional
    public void updateMentor(Long id, Mentor mentor) {
        mentorRepository.findById(id).orElseThrow(() -> new IllegalStateException("Mentor with id: " + id + "does not exist."));
        mentor.setId(id);
        mentorRepository.save(mentor);
    }
}
