package com.internship.mentoringsystem.mentoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "api/v1/mentoring")
public class MentoringController {
    private final MentoringService mentoringService;

    @Autowired
    public MentoringController(MentoringService mentoringService) {
        this.mentoringService = mentoringService;
    }

    @GetMapping
    public List<Mentoring> getMentoring(){
        return mentoringService.getMentoring();
    }

    @PostMapping
    public void addNewMentoring(@RequestBody Mentoring mentoring) {
        mentoringService.addMentoring(mentoring);
    }

    @DeleteMapping(path = "{id}")
    public void deleteMentoring(@PathVariable("id") Long id) {
        mentoringService.deleteMentoring(id);
    }

    @PutMapping(path = "{id}")
    public void updateMentoring(
            @PathVariable("Mentoring") Long id,
            @RequestParam(required = false) String mentoringType) {
        mentoringService.updateMentoring(id, mentoringType);
    }
}
