package com.service;

import com.model.Skill;
import com.repository.SkillRepository;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SkillServiceTest {

    @Mock
    private SkillRepository skillRepository;
    private final SkillService skillService;

    public SkillServiceTest() {
        MockitoAnnotations.openMocks(this);
        this.skillService = new SkillService(skillRepository);
    }

    @Test
    public void getAll() {
        Mockito.when(skillRepository.getAll()).thenReturn(Arrays.asList(
                new Skill(1L, "Bootstrap"),
                new Skill(2L, "Git")
        ));

        List<Skill> skillList = skillService.getAll();

        assertNotNull(skillList);
        assertEquals(2, skillList.size());
        assertEquals("Git", skillList.get(1).getName());
    }

    @Test
    public void getById() {
        Mockito.when(skillRepository.getById(1L)).thenReturn(new Skill(1L, "Git"));

        Skill skill = skillService.getById(1L);

        assertNotNull(skill);
        assertEquals(1L, skill.getId().longValue());
        assertEquals("Git", skill.getName());
    }

    @Test
    public void deleteById() {
        Mockito.doNothing().when(skillRepository).deleteById(1L);

        skillRepository.deleteById(1L);
        Mockito.verify(skillRepository).deleteById(1L);
    }

    @Test
    public void update() {
        Mockito.when(skillRepository.update(new Skill(1L, "T"))).thenReturn(new Skill(1L, "T"));

        Skill skill = new Skill(1L, "Q");
        skillService.update(skill);

        assertNotNull(skill);
        assertEquals(1L, skill.getId().longValue());
        assertEquals("Q", skill.getName());

        skill.setName("S");
        skill.setId(3L);

        skillService.update(skill);

        assertNotNull(skill);
        assertEquals(3L, skill.getId().longValue());
        assertEquals("S", skill.getName());
    }

    @Test
    public void insert() {
        Mockito.when(skillRepository.insert(new Skill(1L, "Q"))).thenReturn(new Skill(1L, "Q"));

        Skill skill = new Skill(3L, "X");
        skillService.insert(skill);

        assertNotNull(skill);
        assertEquals(3L, skill.getId().longValue());
        assertEquals("X", skill.getName());
    }
}