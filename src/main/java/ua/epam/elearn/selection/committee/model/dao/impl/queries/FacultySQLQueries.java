package ua.epam.elearn.selection.committee.model.dao.impl.queries;

public class FacultySQLQueries {
    private FacultySQLQueries() {
    }

    public static final String SELECT_FACULTY_BY_ID = "SELECT * FROM faculty WHERE id= ?";
    public static final String SELECT_FACULTY_BY_NAME = "SELECT * FROM faculty WHERE name= ?";
    public static final String SELECT_ALL_FACULTIES = "SELECT * FROM faculty";
    public static final String CREATE_FACULTY = "INSERT INTO faculty (name, general_capacity, budget_capacity) values (?, ?, ?)";
}
