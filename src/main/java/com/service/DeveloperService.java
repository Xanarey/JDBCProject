package com.service;

import com.model.Developer;
import com.repository.DeveloperRepository;
import com.repository.JdbcImpl.JdbcDeveloperRepositoryImpl;

import java.util.List;

public class DeveloperService{

    private final DeveloperRepository developerRepository = new JdbcDeveloperRepositoryImpl();

    public List<Developer> getAll() {
        return developerRepository.getAll();
    }

    public Developer getById(Long id) {
        return developerRepository.getById(id);
    }

    public Developer update(Developer developer) {
        return developerRepository.update(developer);
    }

    public void deleteById(Long id) {
        developerRepository.deleteById(id);
    }

    public Developer insert(Developer developer) {
        return developerRepository.insert(developer);
    }
}
