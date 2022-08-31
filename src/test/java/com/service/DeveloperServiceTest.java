package com.service;

import com.model.Developer;
import com.model.Skill;
import com.model.Specialty;
import com.model.Status;
import com.repository.DeveloperRepository;
import com.repository.JdbcImpl.JdbcDeveloperRepositoryImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;

public class DeveloperServiceTest {

    DeveloperService developerService = new DeveloperService();

    @Mock
    JdbcDeveloperRepositoryImpl jdbcDevRepoMock = Mockito.mock(JdbcDeveloperRepositoryImpl.class);

    @Test
    public void getById() {

    }

    @Test
    public void getByIdNotSuccessful() {
        assertNotNull(developerService.getById(1L));
    }

    @Test
    public void getAll() {

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