package com.controller;

import com.model.Skill;
import com.service.SkillService;

import java.util.List;

public class SkillController {

    SkillService skillService = new SkillService();

    public SkillController() {}

    public Skill getSkillById(Long id) {
        return skillService.getById(id);
    }

    public List<Skill> getAllSkills() {
        return skillService.getAll();
    }

    public void deleteSkillById(Long id) {
        skillService.deleteById(id);
    }

    public Skill updateSkill(Long id, String name) {
        Skill skill = new Skill();
        skill.setId(id);
        skill.setName(name);
        skillService.update(skill);
        return skill;
    }

    public Skill insertSkill(String name) {
        Skill skill = new Skill();
        skill.setName(name);
        skillService.insert(skill);
        return skill;
    }
}
