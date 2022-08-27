package com.service;

import com.model.Developer;
import com.model.Specialty;
import com.model.Status;
import com.repository.JdbcImpl.JdbcDeveloperRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

public class DeveloperServiceTest {

    private final DeveloperService developerService = new DeveloperService();
    private final JdbcDeveloperRepositoryImpl jdbcDeveloperRepository = new JdbcDeveloperRepositoryImpl();

    @Mock
    JdbcDeveloperRepositoryImpl jdbcDevRepoMock = Mockito.mock(JdbcDeveloperRepositoryImpl.class);

    @Test
    public void getById() {
        Mockito.when(jdbcDevRepoMock.getById(1L)).thenReturn(jdbcDeveloperRepository.getById(1L));

        Developer developer = developerService.getById(1L);

        assertEquals(developer, jdbcDevRepoMock.getById(1L));
        Mockito.verify(jdbcDevRepoMock).getById(1L);
    }

    @Test
    public void getByIdNotSuccessful() {
        assertNotNull(developerService.getById(1L));
    }

    @Test
    public void getAll() {
        Mockito.when(jdbcDevRepoMock.getAll()).thenReturn(jdbcDeveloperRepository.getAll());

        List<Developer> developerList = developerService.getAll();

        assertEquals(developerList, jdbcDevRepoMock.getAll());
        Mockito.verify(jdbcDevRepoMock).getAll();
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
        Mockito.when(jdbcDevRepoMock.update(new Developer())).thenReturn(developerService.update(new Developer()));
        assertEquals(new Developer(), jdbcDevRepoMock.update(new Developer()));
        Mockito.verify(jdbcDevRepoMock).update(new Developer());
    }

    @Test
    public void updateNotSuccessful() {
        assertNotNull(developerService.update(new Developer()));
    }

    @Test
    public void insert() {
        Mockito.when(jdbcDevRepoMock.insert(new Developer())).thenReturn(developerService.insert(new Developer()));
        assertEquals(new Developer(), jdbcDevRepoMock.insert(new Developer()));
        Mockito.verify(jdbcDevRepoMock).insert(new Developer());
    }

    @Test
    public void insertNotSuccessful() {
        assertNotNull(developerService.insert(new Developer()));
    }

}