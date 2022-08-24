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
import static org.mockito.Mockito.doNothing;

public class DeveloperServiceTest {

    private DeveloperService developerService = new DeveloperService();
    private JdbcDeveloperRepositoryImpl jdbcDeveloperRepository = new JdbcDeveloperRepositoryImpl();

    @Test
    public void getById() {
        JdbcDeveloperRepositoryImpl devRepo = Mockito.mock(JdbcDeveloperRepositoryImpl.class);
        Mockito.when(devRepo.getById(1L)).thenReturn(jdbcDeveloperRepository.getById(1L));

        Developer developer = developerService.getById(1L);

        assertEquals(developer, devRepo.getById(1L));
    }

    @Test
    public void getAll() {
        JdbcDeveloperRepositoryImpl devRepo = Mockito.mock(JdbcDeveloperRepositoryImpl.class);
        Mockito.when(devRepo.getAll()).thenReturn(jdbcDeveloperRepository.getAll());

        List<Developer> developerList = developerService.getAll();

        assertEquals(developerList, devRepo.getAll());
    }

    @Test
    public void deleteById() {
        JdbcDeveloperRepositoryImpl devRepo = Mockito.mock(JdbcDeveloperRepositoryImpl.class);
        doNothing().when(devRepo).deleteById(1L);
        // пока разбираюсь , не пойму как протестить
    }

    @Test
    public void update() {
        Developer developer = new Developer();
        assertEquals(developer, developerService.update(developer));
    }

    @Test
    public void insert() {
        Developer developer = new Developer();
        assertEquals(developer, developerService.insert(developer));
    }
}