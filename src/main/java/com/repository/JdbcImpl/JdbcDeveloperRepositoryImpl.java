package com.repository.JdbcImpl;

import com.model.Developer;
import com.model.Specialty;
import com.model.Status;
import com.repository.DeveloperRepository;
import com.utils.JDBCUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JdbcDeveloperRepositoryImpl implements DeveloperRepository {

    @Override
    public Developer getById(Long aLong) {
        Developer developer = new Developer();
        String sqlQuery = "SELECT id, firstName, lastName, status, specialty_id FROM developers WHERE id = ?";
        try(PreparedStatement preparedStatement = JDBCUtils.getPreparedStatement(sqlQuery)) {
            preparedStatement.setLong(1, aLong);
            ResultSet resultSet = preparedStatement.getResultSet();
            preparedStatement.executeQuery();
            while (resultSet.next()) {
                developer.setId(resultSet.getLong("id"));
                developer.setFirstName(resultSet.getString("firstName"));
                developer.setLastName(resultSet.getString("lastName"));
                if (resultSet.getString("status").equals("ACTIVE"))
                    developer.setStatus(Status.ACTIVE);
                if (resultSet.getString("status").equals("DELETED"))
                    developer.setStatus(Status.DELETED);
                developer.getSpecialty().setId(resultSet.getLong("specialty_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developer;
    }

    @Override
    public List<Developer> getAll() {
        List<Developer> developerList = new ArrayList<>();
        String sqlQuery = "SELECT developers.id, firstName, lastName, status, specialty_id FROM developers";
        try(Statement statement = JDBCUtils.getStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            while (resultSet.next()) {
                Developer developer = new Developer();
                developer.setId(resultSet.getLong("id"));
                developer.setFirstName(resultSet.getString("firstName"));
                developer.setLastName(resultSet.getString("lastName"));
                if (resultSet.getString("status").equals("ACTIVE"))
                    developer.setStatus(Status.ACTIVE);
                if (resultSet.getString("status").equals("DELETED"))
                    developer.setStatus(Status.DELETED);
                Specialty specialty = new Specialty();
                specialty.setId(resultSet.getLong("specialty_id"));
                developer.setSpecialty(specialty);
                developerList.add(developer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developerList;
    }

    @Override
    public void deleteById(Long id) {
        String sqlQuery = "UPDATE developers SET status = 'DELETED' WHERE id = ?";
        try(PreparedStatement preparedStatement = JDBCUtils.getPreparedStatement(sqlQuery)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Developer update(Developer developer) {
        String sqlQuery = "UPDATE developers SET firstName = ?, lastName = ?, status = ?, specialty_id = ? WHERE id = ?";
        try(PreparedStatement preparedStatement = JDBCUtils.getPreparedStatement(sqlQuery)) {
            preparedStatement.setString(1, developer.getFirstName());
            preparedStatement.setString(2, developer.getLastName());
            preparedStatement.setString(3, developer.getStatus().name());
            preparedStatement.setLong(4, developer.getSpecialty().getId());
            preparedStatement.setLong(5, developer.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developer;
    }

    @Override
    public Developer insert(Developer developer) {
        String sqlQuery = "INSERT INTO developers (firstName, lastName, status, specialty_id) VALUES (?, ?, ?, ?);";
        try(PreparedStatement preparedStatement = JDBCUtils.getPreparedStatement(sqlQuery)) {
            preparedStatement.setString(1, developer.getFirstName());
            preparedStatement.setString(2, developer.getLastName());
            preparedStatement.setString(3, developer.getStatus().name());
            preparedStatement.setLong(4, developer.getSpecialty().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return developer;
    }
}