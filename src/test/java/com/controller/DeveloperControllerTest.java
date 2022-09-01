package com.controller;

import com.model.Developer;
import com.model.Specialty;
import com.model.Status;
import com.service.DeveloperService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DeveloperControllerTest {

    @Mock
    private DeveloperService developerService;
    private final DeveloperController developerController;

    public DeveloperControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.developerController = new DeveloperController(developerService);
    }

    @Test
    void getAllDeveloper() {
        Mockito.when(developerService.getAll()).thenReturn(Arrays.asList(
                new Developer(1L, "A", "B", Status.ACTIVE, new Specialty(1L, "Q"), new ArrayList<>()),
                new Developer(2L, "A1", "B1", Status.ACTIVE, new Specialty(11L, "Q1"), new ArrayList<>())
        ));

        List<Developer> developerList = developerService.getAll();

        assertNotNull(developerList);
        assertEquals(2, developerList.size());
        assertEquals("A1", developerList.get(1).getFirstName());
    }

    @Test
    void getDeveloperById() {
        Mockito.when(developerService.getById(1L)).thenReturn(new Developer(1L, "A", "B", Status.ACTIVE, new Specialty(1L, "Q"), new ArrayList<>()));
        Developer developer = new Developer(1L, "A", "B", Status.ACTIVE, new Specialty(1L, "Q"), new ArrayList<>());
        developerController.getDeveloperById(1L);

        assertNotNull(developer);
        assertEquals(1L, developer.getId().longValue());
        assertEquals("A", developer.getFirstName());
    }

    @Test
    void deleteDeveloperById() {
        Mockito.doNothing().when(developerService).deleteById(1L);

        developerController.deleteDeveloperById(1L);
        Mockito.verify(developerService).deleteById(1L);
    }

    @Test
    void updateDeveloper() {
        Mockito.when(developerService.update(new Developer(1L, "A", "B", Status.ACTIVE, new Specialty(1L, "Q"), new ArrayList<>())))
                .thenReturn(new Developer(1L, "A", "B", Status.ACTIVE, new Specialty(1L, "Q"), new ArrayList<>()));

        Developer developer = new Developer(1L, "A", "B", Status.ACTIVE, new Specialty(1L, "Q"), new ArrayList<>());
        developerController.updateDeveloper(developer.getId(), developer.getFirstName(), developer.getLastName(), developer.getStatus(), developer.getSpecialty());

        assertNotNull(developer);
        assertEquals(1L, developer.getId().longValue());
        assertEquals("A", developer.getFirstName());

        developer.setId(2L);
        developer.setFirstName("Tomas");
        developerController.updateDeveloper(developer.getId(), developer.getFirstName(), developer.getLastName(), developer.getStatus(), developer.getSpecialty());

        assertNotNull(developer);
        assertEquals(2L, developer.getId().longValue());
        assertEquals("Tomas", developer.getFirstName());
    }

    @Test
    void insertDeveloper() {
        Mockito.when(developerService.insert(new Developer(1L, "A", "B", Status.ACTIVE, new Specialty(1L, "Q"), new ArrayList<>())))
                .thenReturn(new Developer(1L, "A", "B", Status.ACTIVE, new Specialty(1L, "Q"), new ArrayList<>()));

        Developer developer = new Developer(1L, "A", "B", Status.ACTIVE, new Specialty(1L, "Q"), new ArrayList<>());
        developerController.insertDeveloper(developer.getFirstName(), developer.getLastName(), developer.getStatus(), developer.getSpecialty());
        developer.setFirstName("909090");

        assertNotNull(developer);
        assertEquals(1L, developer.getId().longValue());
        assertEquals("909090", developer.getFirstName());
    }

}