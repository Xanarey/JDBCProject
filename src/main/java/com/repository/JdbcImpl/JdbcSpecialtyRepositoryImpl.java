package com.repository.JdbcImpl;

import com.model.Specialty;
import com.repository.SpecialtyRepository;
import com.utils.JDBCUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcSpecialtyRepositoryImpl implements SpecialtyRepository {

    @Override
    public Specialty getById(Long aLong) {
        Specialty specialty = new Specialty();
        String sqlQuery = "SELECT id, name FROM specialty WHERE id = ?";
        try(PreparedStatement preparedStatement = JDBCUtils.getPreparedStatement(sqlQuery)) {
            preparedStatement.setLong(1, aLong);
            ResultSet resultSet = preparedStatement.getResultSet();
            preparedStatement.executeQuery();
            while (resultSet.next()) {
                specialty.setId(resultSet.getLong("id"));
                specialty.setName(resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specialty;
    }

    @Override
    public List<Specialty> getAll() {
        List<Specialty> specialtyList = new ArrayList<>();
        String sqlQuery = "SELECT * FROM specialty";
        try(Statement statement = JDBCUtils.getStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                Specialty specialty = new Specialty();
                specialty.setId(resultSet.getLong("id"));
                specialty.setName(resultSet.getString("name"));
                specialtyList.add(specialty);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specialtyList;
    }

    @Override
    public void deleteById(Long id) {
        String sqlQuery = "DELETE FROM specialty WHERE id = ?;";
        try(PreparedStatement preparedStatement = JDBCUtils.getPreparedStatement(sqlQuery)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String sqlQueryTableDevelopers = "UPDATE developers SET specialty_id = NULL WHERE specialty_id = ?";
        try(PreparedStatement preparedStatement = JDBCUtils.getPreparedStatement(sqlQueryTableDevelopers)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Specialty update(Specialty specialty) {
        String sqlQuery = "UPDATE specialty SET name = ? WHERE id = ?";
        try(PreparedStatement preparedStatement = JDBCUtils.getPreparedStatement(sqlQuery)) {
            preparedStatement.setString(1, specialty.getName());
            preparedStatement.setLong(2, specialty.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specialty;
    }

    @Override
    public Specialty insert(Specialty specialty) {
        String sqlQuery = "INSERT INTO specialty (name) VALUES (?);";
        try(PreparedStatement preparedStatement = JDBCUtils.getPreparedStatement(sqlQuery)) {
            preparedStatement.setString(1, specialty.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return specialty;
    }

}
