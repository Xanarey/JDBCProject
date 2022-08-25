package com.controller;

import com.model.Developer;
import com.service.DeveloperService;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeveloperControllerTest {

    private final DeveloperController developerController = new DeveloperController();
    private final DeveloperService developerService = new DeveloperService();

    @Test
    public void getDeveloperById() {
        assertEquals(developerController.getDeveloperById(1L), developerService.getById(1L));
    }

    @Test
    public void getDeveloperByIdNotSuccessful() {
        assertNotNull(developerController.getDeveloperById(1L));
    }

    @Test
    public void getAllDeveloper() {
        assertEquals(developerController.getAllDeveloper(), developerService.getAll());
    }

    @Test
    public void getAllDeveloperNotSuccessful() {
        assertNotNull(developerController.getAllDeveloper());
    }

    @Test
    public void deleteDeveloperById() {
    }

    @Test
    public void deleteDeveloperByIdNotSuccessful() {
    }

    @Test
    public void updateDeveloper() {

    }

    @Test
    public void updateDeveloperNotSuccessful() {
    }

    @Test
    public void insertDeveloper() {
    }

    @Test
    public void insertDeveloperNotSuccessful() {
    }
}