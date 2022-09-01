package com.controller;

import com.model.Specialty;
import com.service.SpecialtyService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpecialtyControllerTest {

    @Mock
    private SpecialtyService specialtyService;
    private final SpecialtyController specialtyController;

    public SpecialtyControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.specialtyController = new SpecialtyController(specialtyService);
    }

    @Test
    void getSpecialtyById() {
        Mockito.when(specialtyService.getById(1L)).thenReturn(new Specialty(1L, "Java"));

        Specialty specialty = specialtyController.getSpecialtyById(1L);

        assertNotNull(specialty);
        assertEquals(1L, specialty.getId().longValue());
    }

    @Test
    void getAllSpecialty() {
        Mockito.when(specialtyService.getAll()).thenReturn(Arrays.asList(
                new Specialty(1L, "Java"),
                new Specialty(2L, "Cpp")
        ));

        List<Specialty> specialtyList = specialtyController.getAllSpecialty();

        assertNotNull(specialtyList);
        assertEquals(2, specialtyList.size());
        assertEquals("Cpp", specialtyList.get(1).getName());
    }

    @Test
    void deleteSpecialtyById() {
        Mockito.doNothing().when(specialtyService).deleteById(1L);

        specialtyController.deleteSpecialtyById(1L);
        Mockito.verify(specialtyService).deleteById(1L);
    }

    @Test
    void updateSpecialty() {
        Mockito.when(specialtyService.update(new Specialty(1L, "Q"))).thenReturn(new Specialty(1L, "Q"));

        Specialty specialty = new Specialty(1L, "X");
        specialtyController.updateSpecialty(specialty.getId(), specialty.getName());
        assertNotNull(specialty);
        assertEquals(1L, specialty.getId());
        assertEquals("X", specialty.getName());

        specialty.setId(2L);
        specialty.setName("Y");
        specialtyController.updateSpecialty(specialty.getId(), specialty.getName());

        assertNotNull(specialty);
        assertEquals(2L, specialty.getId());
        assertEquals("Y", specialty.getName());
    }

    @Test
    void insertSpecialty() {
        Mockito.when(specialtyService.insert(new Specialty(1L, "Q"))).thenReturn(new Specialty(1L, "Q"));

        Specialty specialty = new Specialty(1L, "X");
        specialtyController.insertSpecialty(specialty.getName());

        assertNotNull(specialty);
        assertEquals(1L, specialty.getId());
        assertEquals("X", specialty.getName());
    }
}