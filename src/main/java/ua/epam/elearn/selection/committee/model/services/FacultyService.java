package ua.epam.elearn.selection.committee.model.services;

import ua.epam.elearn.selection.committee.model.dao.FacultyDao;
import ua.epam.elearn.selection.committee.model.dto.FacultyDto;
import ua.epam.elearn.selection.committee.model.dto.UserDto;
import ua.epam.elearn.selection.committee.model.entity.Faculty;
import ua.epam.elearn.selection.committee.model.entity.User;
import ua.epam.elearn.selection.committee.model.exception.admin.FacultyNameIsReservedException;
import ua.epam.elearn.selection.committee.model.exception.user.EmailIsReservedException;
import ua.epam.elearn.selection.committee.model.exception.user.LoginIsReservedException;

import java.util.List;

public class FacultyService {

    private final FacultyDao facultyDao;

    public FacultyService(FacultyDao facultyDao) {
        this.facultyDao = facultyDao;
    }

    public List<Faculty> findAllFaculties() {
        return facultyDao.getAllFaculties();
    }


    public Faculty findFacultyByName(String name) {
        return facultyDao.getFacultyByName(name);
    }

    public void addNewFaculty(FacultyDto facultyDto) throws FacultyNameIsReservedException {

        checkFacultyNameIsUnique(facultyDto.getName());
        Faculty faculty = new Faculty(facultyDto);
        facultyDao.addFaculty(faculty);

    }


    private void checkFacultyNameIsUnique(String facultyName) throws FacultyNameIsReservedException {
        if (facultyDao.getFacultyByName(facultyName) != null) throw new FacultyNameIsReservedException();
    }

}
