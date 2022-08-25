package com.service;

import com.model.Skill;
import com.repository.JdbcImpl.JdbcSkillRepositoryImpl;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class SkillServiceTest {

    private final SkillService skillService = new SkillService();
    private final JdbcSkillRepositoryImpl jdbcSkillRepository = new JdbcSkillRepositoryImpl();

    @Test
    public void getById() {
        JdbcSkillRepositoryImpl skillRepo = Mockito.mock(JdbcSkillRepositoryImpl.class);
        Mockito.when(skillRepo.getById(1L)).thenReturn(jdbcSkillRepository.getById(1L));

        Skill skill = skillService.getById(1L);

        assertEquals(skill, skillRepo.getById(1L));
        Mockito.verify(skillRepo).getById(1L);
    }

    @Test
    public void getByIdNotSuccessful() {
        assertNotNull(skillService.getById(1L));
    }

    @Test
    public void getAll() {
        JdbcSkillRepositoryImpl skillRepo = Mockito.mock(JdbcSkillRepositoryImpl.class);
        Mockito.when(skillRepo.getAll()).thenReturn(jdbcSkillRepository.getAll());

        List<Skill> skillList = skillService.getAll();

        assertEquals(skillList, skillRepo.getAll());
        Mockito.verify(skillRepo).getAll();
    }

    @Test
    public void getAllNotSuccessful() {
        assertNotNull(skillService.getAll());
    }

    @Test
    public void deleteById() {

    }

    @Test
    public void update() {
        assertEquals(skillService.update(new Skill()), jdbcSkillRepository.update(new Skill()));
    }

    @Test
    public void updateNotSuccessful() {
        assertNotNull(skillService.update(new Skill()));
    }

    @Test
    public void insert() {
        assertEquals(skillService.insert(new Skill()), jdbcSkillRepository.insert(new Skill()));
    }

    @Test
    public void insertNotSuccessful() {
        assertNotNull(skillService.insert(new Skill()));
    }
}