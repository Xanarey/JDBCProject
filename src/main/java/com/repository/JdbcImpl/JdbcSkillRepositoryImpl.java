package com.repository.JdbcImpl;

import com.model.Skill;
import com.repository.SkillRepository;
import com.utils.JDBCUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcSkillRepositoryImpl implements SkillRepository {

    @Override
    public Skill getById(Long aLong) {
        Skill skill = new Skill();
        String sqlQuery = "SELECT id, name FROM skills WHERE id = ?";
        try(PreparedStatement preparedStatement = JDBCUtils.getPreparedStatement(sqlQuery)) {
            preparedStatement.setLong(1, aLong);
            ResultSet resultSet = preparedStatement.getResultSet();
            preparedStatement.executeQuery();
            while (resultSet.next()) {
                skill.setId(resultSet.getLong("id"));
                skill.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skill;
    }

    @Override
    public List<Skill> getAll() {
        List<Skill> skillList = new ArrayList<>();
        String sqlQuery = "SELECT id, name FROM skills";
        try(Statement statement = JDBCUtils.getStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                Skill skill = new Skill();
                skill.setId(resultSet.getLong("id"));
                skill.setName(resultSet.getString("name"));
                skillList.add(skill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skillList;
    }

    @Override
    public void deleteById(Long id) {
        String sqlQuery = "DELETE FROM skills WHERE id = ?;";
        try(PreparedStatement preparedStatement = JDBCUtils.getPreparedStatement(sqlQuery)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlQueryDevelopers_skills = "UPDATE developers_skills SET skills_id = NULL WHERE skills_id = ?";
        try(PreparedStatement preparedStatement = JDBCUtils.getPreparedStatement(sqlQueryDevelopers_skills)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Skill update(Skill skill) {
        String sqlQuery = "UPDATE skills SET name = ? WHERE id = ?";
        try(PreparedStatement preparedStatement = JDBCUtils.getPreparedStatement(sqlQuery)) {
            preparedStatement.setString(1, skill.getName());
            preparedStatement.setLong(2, skill.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skill;
    }

    @Override
    public Skill insert(Skill skill) {
        String sqlQuery = "INSERT INTO skills (name) VALUES (?);";
        try(PreparedStatement preparedStatement = JDBCUtils.getPreparedStatement(sqlQuery)) {
            preparedStatement.setString(1, skill.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skill;
    }

}
