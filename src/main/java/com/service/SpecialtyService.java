package com.service;

import com.model.Specialty;
import com.repository.JdbcImpl.JdbcSpecialtyRepositoryImpl;
import com.repository.SpecialtyRepository;

import java.util.List;

public class SpecialtyService {

    private final SpecialtyRepository specialtyRepository = new JdbcSpecialtyRepositoryImpl();

    public SpecialtyService() {}

    public Specialty getById(Long aLong) {
        return specialtyRepository.getById(aLong);
    }

    public List<Specialty> getAll() {
        return specialtyRepository.getAll();
    }

    public void deleteById(Long id) {
        specialtyRepository.deleteById(id);
    }

    public Specialty update(Specialty specialty) {
        return specialtyRepository.update(specialty);
    }

    public Specialty insert(Specialty specialty) {
        return specialtyRepository.insert(specialty);
    }
}
