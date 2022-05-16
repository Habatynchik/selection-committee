package ua.epam.elearn.selection.committee.model.services;

import ua.epam.elearn.selection.committee.model.dao.FacultyDao;
import ua.epam.elearn.selection.committee.model.entity.Faculty;

import java.util.List;

public class FacultyService {

    private final FacultyDao facultyDao;

    public FacultyService(FacultyDao facultyDao) {
        this.facultyDao = facultyDao;
    }

    public List<Faculty> findAllFaculties() {
        return facultyDao.getAllFaculties();
    }
}
