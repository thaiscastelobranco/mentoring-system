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

    @DeleteMapping(path = "{classesId}")
    public void deleteClasses(@PathVariable("classesId") Long classesId) {
        classesService.deleteClasses(classesId);
    }

    @PutMapping(path = "{classesId}")
    public void updateClasses (@PathVariable("classesId") Long classesId,
                               @RequestParam(required = false) String mentoringPeriod) {
        classesService.updateClasses(classesId, mentoringPeriod);
    }
}
