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

    @DeleteMapping(path = "{id}")
    public void deleteClasses(@PathVariable ("id") Long id) {
        mentorService.deleteMentor(id);
    }

    @PutMapping(path = "{id}")
    public void updateMentor(
            @PathVariable("Mentor") Long id,
            @RequestParam(required = false) String mentorCpf,
            @RequestParam(required = false) String mentorName,
            @RequestParam(required = false) String mentorAddress,
            @RequestParam(required = false) String mentorEmail) {
        mentorService.updateMentor(id, mentorCpf, mentorName, mentorAddress, mentorEmail);
    }
}
