package com.service;

import com.model.Skill;
import com.repository.SkillRepository;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
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

    private List<Skill> getSkills() {
        Skill sk1 = new Skill(1L, "Bootstrap");
        Skill sk2 = new Skill(2L, "Git");
        List<Skill> skillList = new ArrayList<>();
        skillList.add(sk1);
        skillList.add(sk2);
        return skillList;
    }

    @Test
    public void getAll() {
        Mockito.when(skillRepository.getAll()).thenReturn(getSkills());

        List<Skill> skillList = skillService.getAll();

        assertNotNull(skillList);
        assertEquals(2, skillList.size());
    }

    @Test
    public void getById() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void update() {
    }

    @Test
    public void insert() {
    }
}