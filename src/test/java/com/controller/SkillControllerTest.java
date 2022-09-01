package com.controller;

import com.model.Skill;
import com.service.SkillService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SkillControllerTest {

    @Mock
    private SkillService skillService;
    private final SkillController skillController;

    public SkillControllerTest() {
        MockitoAnnotations.openMocks(this);
        this.skillController = new SkillController(skillService);
    }

    @Test
    void getSkillById() {
        Mockito.when(skillService.getById(1L)).thenReturn(new Skill(1L, "Git"));

        Skill skill = skillController.getSkillById(1L);

        assertNotNull(skill);
        assertEquals(1L, skill.getId().longValue());
        assertEquals("Git", skill.getName());
    }

    @Test
    void getAllSkills() {
        Mockito.when(skillService.getAll()).thenReturn(Arrays.asList(
                new Skill(1L, "Bootstrap"),
                new Skill(2L, "Git")
        ));

        List<Skill> skillList = skillController.getAllSkills();

        assertNotNull(skillList);
        assertEquals(2, skillList.size());
        assertEquals("Git", skillList.get(1).getName());
    }

    @Test
    void deleteSkillById() {
        Mockito.doNothing().when(skillService).deleteById(1L);

        skillController.deleteSkillById(1L);
        Mockito.verify(skillService).deleteById(1L);
    }

    @Test
    void updateSkill() {
        Mockito.when(skillService.update(new Skill(1L, "T"))).thenReturn(new Skill(1L, "T"));

        Skill skill = new Skill(1L, "Q");
        skillController.updateSkill(skill.getId(), skill.getName());

        assertNotNull(skill);
        assertEquals(1L, skill.getId().longValue());
        assertEquals("Q", skill.getName());

        skill.setName("S");
        skill.setId(3L);

        skillController.updateSkill(skill.getId(), skill.getName());

        assertNotNull(skill);
        assertEquals(3L, skill.getId().longValue());
        assertEquals("S", skill.getName());
    }

    @Test
    void insertSkill() {
        Mockito.when(skillService.insert(new Skill(1L, "Q"))).thenReturn(new Skill(1L, "Q"));

        Skill skill = new Skill(3L, "X");
        skillController.insertSkill(skill.getName());

        assertNotNull(skill);
        assertEquals(3L, skill.getId().longValue());
        assertEquals("X", skill.getName());
    }
}