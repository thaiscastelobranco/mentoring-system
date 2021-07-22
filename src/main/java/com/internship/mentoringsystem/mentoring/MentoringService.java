package com.internship.mentoringsystem.mentoring;

import com.internship.mentoringsystem.classes.Classes;
import com.internship.mentoringsystem.mentor.Mentor;
import com.internship.mentoringsystem.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

@Service
public class MentoringService{

    private final MentoringRepository mentoringRepository;

    @Autowired
    public MentoringService(MentoringRepository mentoringRepository){
        this.mentoringRepository = mentoringRepository;
    }

    @GetMapping
    public List<Mentoring> getMentoring() {
        return mentoringRepository.findAll();
    }

    public void addMentoring(Mentoring mentoring) {
        Optional<Mentoring> mentoringOptional = mentoringRepository.findByMentoringType(mentoring.getMentoringType());
        if(mentoringOptional.isPresent()) {
            throw new IllegalStateException("This mentoring already exists.");
        }
        mentoringRepository.save(mentoring);
    }

    public void deleteMentoring(Long id) {
        boolean exists = mentoringRepository.existsById(id);
        if(!exists) {
            throw new IllegalStateException("This mentoring with id: " + id + "already exists.");
        }
        mentoringRepository.deleteById(id);
    }

    public void updateMentoring(Long id, String mentoringType) {
        Mentoring mentoring = mentoringRepository.findById(id).orElseThrow(() -> new IllegalStateException("Mentor with id: " + id + "does not exist."));
        if (mentoringType != null && mentoringType.length() > 0 && !Objects.equals(mentoring.getMentoringType(), mentoringType)) {
            mentoring.setMentoringType(mentoringType);
        }
    }
}
