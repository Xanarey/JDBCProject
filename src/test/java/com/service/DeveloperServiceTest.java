package com.service;

import com.controller.DeveloperController;
import com.model.Developer;
import com.model.Specialty;
import com.model.Status;
import com.repository.JdbcImpl.JdbcDeveloperRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mock;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DeveloperServiceTest {

    private final DeveloperService developerService = new DeveloperService();
    private final JdbcDeveloperRepositoryImpl jdri = new JdbcDeveloperRepositoryImpl();
    private final DeveloperController dc = new DeveloperController();
    Specialty specialty = new Specialty();
    List<Developer> developerList;
    Developer updateDeveloper;
    Developer deletedDeveloper;
    Developer developer;

    @Before
    public void setUp() {
        specialty.setId(1L);
        developerList = jdri.getAll();
        developer = jdri.getById(1L);
        updateDeveloper = dc.updateDeveloper(1L, "A", "B", Status.ACTIVE, specialty);
    }

    @Test
    public void getById() {
        assertEquals(developerService.getById(1L), developer);
    }

    @Test
    public void getAll() {
        assertEquals(developerService.getAll(), developerList);
        assertNotNull(developerService.getAll());
    }

    @Test
    public void deleteById() {

    }

    @Test
    public void update() {
        assertEquals(dc.updateDeveloper(1L, "A", "B", Status.ACTIVE, specialty), jdri.update(updateDeveloper));
    }

    @Test
    public void insert() {
    }

}