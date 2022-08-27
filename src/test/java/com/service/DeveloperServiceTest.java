package com.service;

import com.model.Developer;
import com.model.Specialty;
import com.model.Status;
import com.repository.JdbcImpl.JdbcDeveloperRepositoryImpl;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

public class DeveloperServiceTest {

    private final DeveloperService developerService = new DeveloperService();
    private final JdbcDeveloperRepositoryImpl jdbcDeveloperRepository = new JdbcDeveloperRepositoryImpl();

    @Test
    public void getById() {
        JdbcDeveloperRepositoryImpl devRepo = Mockito.mock(JdbcDeveloperRepositoryImpl.class);
        Mockito.when(devRepo.getById(1L)).thenReturn(jdbcDeveloperRepository.getById(1L));

        Developer developer = developerService.getById(1L);

        assertEquals(developer, devRepo.getById(1L));
        Mockito.verify(devRepo).getById(1L);
    }

    @Test
    public void getByIdNotSuccessful() {
        assertNotNull(developerService.getById(1L));
    }

    @Test
    public void getAll() {
        JdbcDeveloperRepositoryImpl devRepo = Mockito.mock(JdbcDeveloperRepositoryImpl.class);
        Mockito.when(devRepo.getAll()).thenReturn(jdbcDeveloperRepository.getAll());

        List<Developer> developerList = developerService.getAll();

        assertEquals(developerList, devRepo.getAll());
        Mockito.verify(devRepo).getAll();
    }

    @Test
    public void getAllNotSuccessful() {
        assertNotNull(developerService.getAll());
    }

    @Test
    public void deleteById() {
        // TODO: Как правильно протестировать работу данного метода ?
    }

    @Test
    public void update() {
        JdbcDeveloperRepositoryImpl jdbcDeveloperRepository = Mockito.mock(JdbcDeveloperRepositoryImpl.class);
        Mockito.when(jdbcDeveloperRepository.update(new Developer())).thenReturn(developerService.update(new Developer()));
        assertEquals(new Developer(), jdbcDeveloperRepository.update(new Developer()));
    }

    @Test
    public void updateNotSuccessful() {
        assertNotNull(developerService.update(new Developer()));
    }

    @Test
    public void insert() {
        JdbcDeveloperRepositoryImpl jdbcDeveloperRepository = Mockito.mock(JdbcDeveloperRepositoryImpl.class);
        Mockito.when(jdbcDeveloperRepository.insert(new Developer())).thenReturn(developerService.insert(new Developer()));
        assertEquals(new Developer(), developerService.insert(new Developer()));
    }

    @Test
    public void insertNotSuccessful() {
        assertNotNull(developerService.insert(new Developer()));
    }
}