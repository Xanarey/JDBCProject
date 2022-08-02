package com.service;

import com.model.Developer;
import com.repository.DeveloperRepository;
import com.repository.JdbcImpl.JdbcDeveloperRepositoryImpl;

import java.util.List;

public class DeveloperService {

    private final DeveloperRepository developerRepository = new JdbcDeveloperRepositoryImpl();

    public DeveloperService() {}

    public Developer getById(Long aLong) {
        return developerRepository.getById(aLong);
    }

    public List<Developer> getAll() {
        return developerRepository.getAll();
    }

    public void deleteById(Long id) {
        developerRepository.deleteById(id);
    }

    public Developer update(Developer developer) {
        return developerRepository.update(developer);
    }

    public Developer insert(Developer developer) {
        return developerRepository.insert(developer);
    }
}
