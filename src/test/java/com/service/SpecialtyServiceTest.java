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

    @Mock
    JdbcSpecialtyRepositoryImpl jdbcSpecRepoMock = Mockito.mock(JdbcSpecialtyRepositoryImpl.class);

    @Test
    public void getById() {
        Mockito.when(jdbcSpecRepoMock.getById(1L)).thenReturn(jdbcSpecialtyRepository.getById(1L));

        Specialty specialty = specialtyService.getById(1L);

        assertEquals(specialty, jdbcSpecRepoMock.getById(1L));
        Mockito.verify(jdbcSpecRepoMock).getById(1L);
    }

    @Test
    public void getByIdNotSuccessful() {
        assertNotNull(specialtyService.getById(1L));
    }

    @Test
    public void getAll() {
        Mockito.when(jdbcSpecRepoMock.getAll()).thenReturn(jdbcSpecialtyRepository.getAll());

        List<Specialty> specialtyList = specialtyService.getAll();

        assertEquals(specialtyList, jdbcSpecRepoMock.getAll());
        Mockito.verify(jdbcSpecRepoMock).getAll();
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
        Mockito.when(jdbcSpecRepoMock.update(new Specialty())).thenReturn(specialtyService.update(new Specialty()));
        assertEquals(specialtyService.update(new Specialty()), jdbcSpecRepoMock.update(new Specialty()));
        Mockito.verify(jdbcSpecRepoMock).update(new Specialty());
    }

    @Test
    public void updateNotSuccessful() {
        assertNotNull(specialtyService.update(new Specialty()));
    }

    @Test
    public void insert() {
        Mockito.when(jdbcSpecRepoMock.insert(new Specialty())).thenReturn(specialtyService.insert(new Specialty()));
        assertEquals(specialtyService.insert(new Specialty()), jdbcSpecRepoMock.insert(new Specialty()));
        Mockito.verify(jdbcSpecRepoMock).insert(new Specialty());
    }

    @Test
    public void insertNotSuccessful() {
        assertNotNull(specialtyService.insert(new Specialty()));
    }
}