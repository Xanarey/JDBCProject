package com.controller;

import com.model.Developer;
import com.model.Specialty;
import com.model.Status;
import com.service.DeveloperService;

import java.util.List;

public class DeveloperController {

    DeveloperService developerService = new DeveloperService();

    public DeveloperController() {}

    public Developer getDeveloperById(Long id) {
        return developerService.getById(id);
    }

    public List<Developer> getAllDeveloper() {
        return developerService.getAll();
    }

    public void deleteDeveloperById(Long id) {
        developerService.deleteById(id);
    }

    public Developer updateDeveloper(Long id, String firstName, String lastName, Status status, Specialty specialty) {
        Developer developer = new Developer();
        developer.setId(id);
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        developer.setStatus(status);
        developer.setSpecialty(specialty);
        developerService.update(developer);
        return developer;
    }

    public Developer insertDeveloper(String firstName, String lastName, Status status, Specialty specialty) {
        Developer developer = new Developer();
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        developer.setStatus(status);
        developer.setSpecialty(specialty);
        developerService.insert(developer);
        return developer;
    }
}
