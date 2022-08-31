package com.service;

import com.model.Developer;
import com.model.Specialty;
import com.model.Status;
import com.repository.DeveloperRepository;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DeveloperServiceTest {
    @Mock
    private DeveloperRepository devRepoMock;

    private final DeveloperService devServiceMock;

    public DeveloperServiceTest() {
        MockitoAnnotations.openMocks(this);
        this.devServiceMock = new DeveloperService(devRepoMock);
    }

    @Test
    public void getAll() {
        Mockito.when(devRepoMock.getAll()).thenReturn(Arrays.asList(
                new Developer(1L, "Ann", "Clark", Status.ACTIVE, new Specialty(1L, "Cpp"), new ArrayList<>()),
                new Developer(2L, "Zack", "And", Status.ACTIVE, new Specialty(2L, "Java"), new ArrayList<>())));

        List<Developer> developerList = devServiceMock.getAll();

        assertNotNull(developerList);
        assertEquals(2, developerList.size());
        assertEquals("Zack", developerList.get(1).getFirstName());
    }

    @Test
    public void insert() {
        Mockito.when(devRepoMock.insert(getTestDev())).thenReturn(getTestDev());

        Developer developer = devServiceMock.insert(getTestDev());
        developer.setFirstName("909090");

        assertEquals(1L, developer.getId().longValue());
        assertEquals("909090", developer.getFirstName());
    }

    @Test
    public void update() {
        Mockito.when(devRepoMock.update(getTestDev())).thenReturn(getTestDev());

        Developer developer = devServiceMock.update(getTestDev());

        assertEquals(1L, developer.getId().longValue());
        assertEquals("Ann", developer.getFirstName());

        developer.setId(2L);
        developer.setFirstName("Tomas");
        devServiceMock.update(developer);

        assertEquals(2L, developer.getId().longValue());
        assertEquals("Tomas", developer.getFirstName());

    }

    @Test
    public void deleteById() {
        Mockito.doNothing().when(devRepoMock).deleteById(1L);

        devServiceMock.deleteById(1L);
        Mockito.verify(devRepoMock).deleteById(1L);
    }

    @Test
    public void getById() {
        Mockito.when(devRepoMock.getById(1L)).thenReturn(getTestDev());
        Developer developer = devServiceMock.getById(1L);

        assertNotNull(developer);
        assertEquals(1L, developer.getId().longValue());
        assertEquals("Ann", developer.getFirstName());
    }

    private Developer getTestDev() {
        return new Developer(1L, "Ann", "Chikson", Status.ACTIVE, new Specialty(), new ArrayList<>());
    }

}