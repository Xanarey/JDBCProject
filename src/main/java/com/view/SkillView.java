package com.view;

import com.controller.SkillController;
import com.model.Skill;

public class SkillView {

    SkillController skillController = new SkillController();

    public void getSkillById(Long id) {
        System.out.println("ID:   " + skillController.getSkillById(id).getId());
        System.out.println("Name: " + skillController.getSkillById(id).getName());
        System.out.println("==========");
    }

    public void getAllSkills() {
        for (Skill d: skillController.getAllSkills()) {
            System.out.println("ID:   " + d.getId());
            System.out.println("Name: " + d.getName());
            System.out.println("==========");
        }
    }

    public void deleteSkillById(Long id) {
        skillController.getSkillById(id);
        System.out.println("Скилл удален");
        skillController.deleteSkillById(id);
    }

    public void updateSkill(Long id, String name) {
        skillController.updateSkill(id, name);
    }

    public void insertSkill(String name) {
        skillController.insertSkill(name);
    }

}
