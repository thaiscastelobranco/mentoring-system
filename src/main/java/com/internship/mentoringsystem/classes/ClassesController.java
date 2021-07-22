package com.internship.mentoringsystem.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/classes")
public class ClassesController {
    private final ClassesService classesService;

    @Autowired
    public ClassesController(ClassesService classesService) {
        this.classesService = classesService;
    }

    @GetMapping
    public List<Classes> getClasses() {
        return classesService.getClasses();
    }

    @PostMapping
    public void registerNewClasses(@RequestBody Classes classes) {
        classesService.addNewClasses(classes);
    }

    @DeleteMapping(path = "{id}")
    public void deleteClasses(@PathVariable("id") Long id) {
        classesService.deleteClasses(id);
    }

    @PutMapping(path = "{id}")
    public void updateClasses (@PathVariable("Classes") Long id,
                               @RequestParam(required = false) String mentoringPeriod) {
        classesService.updateClasses(id, mentoringPeriod);
    }
}
