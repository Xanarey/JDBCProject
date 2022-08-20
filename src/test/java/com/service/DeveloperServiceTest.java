package com.service;

import com.model.Developer;
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
    List<Developer> developerList;

    @Before
    public void setUp() {
        developerList = jdri.getAll();
    }

    @Test
    public void getById() {
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
    }

    @Test
    public void insert() {
    }

}