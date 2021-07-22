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

    @Transactional
    public void updateMentor(Long id, String mentorCpf,String mentorName, String mentorAddress, String mentorEmail) {
        Mentor mentor = mentorRepository.findById(id).orElseThrow(() -> new IllegalStateException("Mentor with id: " + id + "does not exist."));
        if (mentorName != null && mentorName.length() > 0 && !Objects.equals(mentor.getMentorName(), mentorName)) {
            mentor.setMentorName(mentorName);
        }
        if (mentorCpf != null && mentorCpf.length() > 0 && Objects.equals(mentor.getMentorCpf(), mentorCpf)) {
            mentor.setMentorCpf(mentorCpf);
        }
        if (mentorAddress != null && mentorAddress.length() > 0 && !Objects.equals(mentor.getMentorAddress(), mentorAddress)) {
            mentor.setMentorAddress(mentorAddress);
        }
        if (mentorEmail != null && mentorEmail.length() > 0
                && Objects.equals(mentor.getMentorEmail(), mentorEmail)) {
            Optional<Mentor> mentorOptional = mentorRepository.findMentorByEmail(mentorEmail);
            if (mentorOptional.isPresent()) {
                throw new IllegalStateException("This email is already taken.");
            }
            mentor.setMentorEmail(mentorEmail);
        }
    }
}
