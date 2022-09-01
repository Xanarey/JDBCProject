package com.service;

import com.model.Specialty;
import com.repository.SpecialtyRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SpecialtyServiceTest {

    @Mock
    private SpecialtyRepository specialtyRepository;
    private final SpecialtyService specialtyServiceMock;

    public SpecialtyServiceTest() {
        MockitoAnnotations.openMocks(this);
        this.specialtyServiceMock = new SpecialtyService(specialtyRepository);
    }

    @Test
    void getById() {
        Mockito.when(specialtyRepository.getById(1L)).thenReturn(new Specialty(1L, "Java"));

        Specialty specialty = specialtyServiceMock.getById(1L);

        assertNotNull(specialty);
        assertEquals(1L, specialty.getId().longValue());
    }

    @Test
    void getAll() {
        Mockito.when(specialtyRepository.getAll()).thenReturn(Arrays.asList(
                new Specialty(1L, "Java"),
                new Specialty(2L, "Cpp")
        ));

        List<Specialty> specialtyList = specialtyServiceMock.getAll();

        assertNotNull(specialtyList);
        assertEquals(2, specialtyList.size());
        assertEquals("Cpp", specialtyList.get(1).getName());
    }

    @Test
    void deleteById() {
        Mockito.doNothing().when(specialtyRepository).deleteById(1L);

        specialtyServiceMock.deleteById(1L);
        Mockito.verify(specialtyRepository).deleteById(1L);
    }

    @Test
    void update() {
        Mockito.when(specialtyRepository.update(new Specialty(1L, "Q"))).thenReturn(new Specialty(1L, "Q"));

        Specialty specialty = new Specialty(1L, "X");
        specialtyServiceMock.update(specialty);
        assertNotNull(specialty);
        assertEquals(1L, specialty.getId());
        assertEquals("X", specialty.getName());

        specialty.setId(2L);
        specialty.setName("Y");
        specialtyServiceMock.update(specialty);

        assertNotNull(specialty);
        assertEquals(2L, specialty.getId());
        assertEquals("Y", specialty.getName());
    }

    @Test
    void insert() {
        Mockito.when(specialtyRepository.insert(new Specialty(1L, "Q"))).thenReturn(new Specialty(1L, "Q"));

        Specialty specialty = new Specialty(1L, "X");
        specialtyServiceMock.insert(specialty);

        assertNotNull(specialty);
        assertEquals(1L, specialty.getId());
        assertEquals("X", specialty.getName());
    }
}