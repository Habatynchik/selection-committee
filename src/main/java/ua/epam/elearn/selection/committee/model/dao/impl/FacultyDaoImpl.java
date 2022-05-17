package ua.epam.elearn.selection.committee.model.dao.impl;

import ua.epam.elearn.selection.committee.model.dao.FacultyDao;
import ua.epam.elearn.selection.committee.model.dao.database.DBManager;
import ua.epam.elearn.selection.committee.model.dao.impl.queries.FacultySQLQueries;
import ua.epam.elearn.selection.committee.model.dao.impl.queries.UserSQLQueries;
import ua.epam.elearn.selection.committee.model.dao.mapper.FacultyMapper;
import ua.epam.elearn.selection.committee.model.dao.mapper.UserMapper;
import ua.epam.elearn.selection.committee.model.entity.Faculty;
import ua.epam.elearn.selection.committee.model.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FacultyDaoImpl implements FacultyDao {
    @Override
    public Faculty getFacultyById(long id) {
        Faculty faculty = null;

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement stmt = con.prepareStatement(FacultySQLQueries.SELECT_FACULTY_BY_ID)) {
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                FacultyMapper facultyMapper = new FacultyMapper();

                while (rs.next()) {
                    faculty = facultyMapper.extractFromResultSet(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return faculty;
    }

    @Override
    public Faculty getFacultyByName(String name) {
        Faculty faculty = null;

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement stmt = con.prepareStatement(FacultySQLQueries.SELECT_FACULTY_BY_NAME)) {
            stmt.setString(1, name);

            try (ResultSet rs = stmt.executeQuery()) {
                FacultyMapper facultyMapper = new FacultyMapper();

                while (rs.next()) {
                    faculty = facultyMapper.extractFromResultSet(rs);
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return faculty;
    }

    @Override
    public List<Faculty> getAllFaculties() {

        List<Faculty> faculties = new ArrayList<>();

        try (Connection con = DBManager.getInstance().getConnection();
             Statement stmt = con.createStatement()) {

            try (ResultSet rs = stmt.executeQuery(FacultySQLQueries.SELECT_ALL_FACULTIES)) {
                FacultyMapper facultyMapper = new FacultyMapper();
                while (rs.next()) {
                    faculties.add(facultyMapper.extractFromResultSet(rs));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return faculties;
    }

    @Override
    public boolean addFaculty(Faculty faculty) {

        try (Connection con = DBManager.getInstance().getConnection();
             PreparedStatement stmt = con.prepareStatement(FacultySQLQueries.CREATE_FACULTY)) {

            stmt.setString(1, faculty.getName());
            stmt.setLong(2, faculty.getGeneralCapacity());
            stmt.setLong(3, faculty.getBudgetCapacity());

            return stmt.executeUpdate() > 0;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean deleteFaculty(int id) {
        return false;
    }
}
