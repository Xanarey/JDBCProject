package com.controller;

import com.model.Developer;
import com.service.DeveloperService;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class DeveloperControllerTest {

    private final DeveloperController developerController = new DeveloperController();

    @Test
    public void getDeveloperById() {
        DeveloperService developerServiceMock = Mockito.mock(DeveloperService.class);
        Mockito.when(developerServiceMock.getById(1L)).thenReturn(developerController.getDeveloperById(1L));

        Developer developer = developerController.getDeveloperById(1L);

        assertEquals(developer, developerServiceMock.getById(1L));
        Mockito.verify(developerServiceMock).getById(1L);
    }

    @Test
    public void getDeveloperByIdNotSuccessful() {
        assertNotNull(developerController.getDeveloperById(1L));
    }

    @Test
    public void getAllDeveloper() {
        DeveloperService developerServiceMock = Mockito.mock(DeveloperService.class);
        Mockito.when(developerServiceMock.getAll()).thenReturn(developerController.getAllDeveloper());

        List<Developer> developerList = developerController.getAllDeveloper();

        assertEquals(developerList, developerServiceMock.getAll());
        Mockito.verify(developerServiceMock).getAll();
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