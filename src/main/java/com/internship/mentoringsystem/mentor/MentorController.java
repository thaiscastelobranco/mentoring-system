package com.internship.mentoringsystem.mentor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/mentor")
public class MentorController {
    private final MentorService mentorService;

    @Autowired
    public MentorController(MentorService mentorService) {
        this.mentorService = mentorService;
    }

    @GetMapping
    public List<Mentor> getMentor() {
        return mentorService.getMentor();
    }

    @PostMapping
    public void registerNewMentor(@RequestBody Mentor mentor){
        mentorService.addNewMentor(mentor);
    }

    @DeleteMapping(path = "{mentorId}")
    public void deleteClasses(@PathVariable ("mentorId") Long mentorId) {
        mentorService.deleteMentor(mentorId);
    }

    @PutMapping(path = "{mentorId}")
    public void updateMentor(
            @PathVariable("Mentor") Long mentorId,
            @RequestParam(required = false) String mentorCpf,
            @RequestParam(required = false) String mentorName,
            @RequestParam(required = false) String mentorAddress,
            @RequestParam(required = false) String mentorEmail) {
        mentorService.updateMentor(mentorId, mentorCpf, mentorName, mentorAddress, mentorEmail);
    }
}
