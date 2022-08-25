package com.service;

import com.model.Skill;
import com.model.Specialty;
import com.repository.JdbcImpl.JdbcSpecialtyRepositoryImpl;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class SpecialtyServiceTest {

    private final JdbcSpecialtyRepositoryImpl jdbcSpecialtyRepository = new JdbcSpecialtyRepositoryImpl();
    private final SpecialtyService specialtyService = new SpecialtyService();

    @Test
    public void getById() {
        JdbcSpecialtyRepositoryImpl specRepo = Mockito.mock(JdbcSpecialtyRepositoryImpl.class);
        Mockito.when(specRepo.getById(1L)).thenReturn(jdbcSpecialtyRepository.getById(1L));

        Specialty specialty = specialtyService.getById(1L);

        assertEquals(specialty, specRepo.getById(1L));
        Mockito.verify(specRepo).getById(1L);
    }

    @Test
    public void getByIdNotSuccessful() {
        assertNotNull(specialtyService.getById(1L));
    }

    @Test
    public void getAll() {
        JdbcSpecialtyRepositoryImpl specRepo = Mockito.mock(JdbcSpecialtyRepositoryImpl.class);
        Mockito.when(specRepo.getAll()).thenReturn(jdbcSpecialtyRepository.getAll());

        List<Specialty> specialtyList = specialtyService.getAll();

        assertEquals(specialtyList, specRepo.getAll());
        Mockito.verify(specRepo).getAll();
    }

    @Test
    public void getAllNotSuccessful() {
        assertNotNull(specialtyService.getAll());
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void update() {
        assertEquals(specialtyService.update(new Specialty()), jdbcSpecialtyRepository.update(new Specialty()));
    }

    @Test
    public void updateNotSuccessful() {
        assertNotNull(specialtyService.update(new Specialty()));
    }

    @Test
    public void insert() {
        assertEquals(specialtyService.insert(new Specialty()), jdbcSpecialtyRepository.insert(new Specialty()));
    }

    @Test
    public void insertNotSuccessful() {
        assertNotNull(specialtyService.insert(new Specialty()));
    }
}