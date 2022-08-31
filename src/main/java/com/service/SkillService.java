package com.service;

import com.model.Skill;
import com.repository.JdbcImpl.JdbcSkillRepositoryImpl;
import com.repository.SkillRepository;

import java.util.List;

public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService() {
        this.skillRepository = new JdbcSkillRepositoryImpl();
    }

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill getById(Long aLong) {
        return skillRepository.getById(aLong);
    }

    public List<Skill> getAll (){
        return skillRepository.getAll();
    }

    public void deleteById(Long id) {
        skillRepository.deleteById(id);
    }

    public Skill update(Skill skill) {
        return skillRepository.update(skill);
    }

    public Skill insert(Skill skill) {
        return skillRepository.insert(skill);
    }
}
