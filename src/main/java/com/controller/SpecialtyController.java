package com.controller;

import com.model.Specialty;
import com.service.SpecialtyService;

import java.util.List;

public class SpecialtyController {

    private final SpecialtyService specialtyService;

    public SpecialtyController() {
        this.specialtyService = new SpecialtyService();
    }

    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    public Specialty getSpecialtyById(Long id) {
        return specialtyService.getById(id);
    }

    public List<Specialty> getAllSpecialty() {return specialtyService.getAll();}

    public void deleteSpecialtyById(Long id) {
        specialtyService.deleteById(id);
    }

    public Specialty updateSpecialty(Long id, String name) {
        Specialty specialty = new Specialty();
        specialty.setId(id);
        specialty.setName(name);
        specialtyService.update(specialty);
        return specialty;
    }

    public Specialty insertSpecialty(String name) {
        Specialty specialty = new Specialty();
        specialty.setName(name);
        specialtyService.insert(specialty);
        return specialty;
    }
}
