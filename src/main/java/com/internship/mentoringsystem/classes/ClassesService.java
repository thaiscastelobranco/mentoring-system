package com.internship.mentoringsystem.classes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ClassesService {

    private final ClassesRepository classesRepository;

    @Autowired
    public ClassesService(ClassesRepository classesRepository){
        this.classesRepository = classesRepository;
    }

    public List<Classes> getClasses() {
        return classesRepository.findAll();
    }

    public void addNewClasses(Classes classes) {
        Optional<Classes> classesOptional =
        classesRepository.findByMentoringPeriod(classes.getMentoringPeriod());
        if (classesOptional.isPresent()) {
            throw new IllegalStateException("The class already exists");
        }
        classesRepository.save(classes);
    }

    public void deleteClasses(Long classesId) {
        boolean exists = classesRepository.existsById(classesId);
        if(!exists) {
            throw new IllegalStateException("This class with" + classesId + "does not exists.");
        }
        classesRepository.deleteById(classesId);
    }

    @Transactional
    public void updateClasses(Long id, String mentoringPeriod) {
        Classes classes = classesRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Class with id" +
                        id + "does not exists"));
        if(mentoringPeriod != null &&
                mentoringPeriod.length() > 0) {
            classes.setMentoringPeriod(mentoringPeriod);
        }
        classesRepository.save(classes);
    }
}
