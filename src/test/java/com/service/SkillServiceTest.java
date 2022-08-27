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

    @Mock
    JdbcSkillRepositoryImpl jdbcSkillRepoMock = Mockito.mock(JdbcSkillRepositoryImpl.class);

    @Test
    public void getById() {
        Mockito.when(jdbcSkillRepoMock.getById(1L)).thenReturn(jdbcSkillRepository.getById(1L));

        Skill skill = skillService.getById(1L);

        assertEquals(skill, jdbcSkillRepoMock.getById(1L));
        Mockito.verify(jdbcSkillRepoMock).getById(1L);
    }

    @Test
    public void getByIdNotSuccessful() {
        assertNotNull(skillService.getById(1L));
    }

    @Test
    public void getAll() {
        Mockito.when(jdbcSkillRepoMock.getAll()).thenReturn(jdbcSkillRepository.getAll());

        List<Skill> skillList = skillService.getAll();

        assertEquals(skillList, jdbcSkillRepoMock.getAll());
        Mockito.verify(jdbcSkillRepoMock).getAll();
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
        Mockito.when(jdbcSkillRepoMock.update(new Skill())).thenReturn(skillService.update(new Skill()));
        assertEquals(skillService.update(new Skill()), jdbcSkillRepoMock.update(new Skill()));
        Mockito.verify(jdbcSkillRepoMock).update(new Skill());
    }

    @Test
    public void updateNotSuccessful() {
        assertNotNull(skillService.update(new Skill()));
    }

    @Test
    public void insert() {
        Mockito.when(jdbcSkillRepoMock.insert(new Skill())).thenReturn(skillService.insert(new Skill()));
        assertEquals(skillService.insert(new Skill()), jdbcSkillRepoMock.insert(new Skill()));
        Mockito.verify(jdbcSkillRepoMock).insert(new Skill());
    }

    @Test
    public void insertNotSuccessful() {
        assertNotNull(skillService.insert(new Skill()));
    }
}