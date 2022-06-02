package ua.epam.elearn.selection.committee.model.services;

import ua.epam.elearn.selection.committee.model.dao.FacultyDao;
import ua.epam.elearn.selection.committee.model.dto.FacultyDto;
import ua.epam.elearn.selection.committee.model.entity.Faculty;
import ua.epam.elearn.selection.committee.model.exception.admin.FacultyNameIsReservedException;

import java.util.List;

public class FacultyService {
    private static final int PAGE_SIZE = 4;

    private final FacultyDao facultyDao;

    public FacultyService(FacultyDao facultyDao) {
        this.facultyDao = facultyDao;
    }

    public List<Faculty> findAllFaculties() {
        return facultyDao.getAllFaculties();
    }

    public int getCountOfFaculties() {
        return (int) Math.ceil(facultyDao.getAllFaculties().size() / (double) PAGE_SIZE);
    }
    public List<Faculty> getPaginationAllFaculties(String order, int pageNum) {
        int offset = PAGE_SIZE * (pageNum - 1) ;
        return facultyDao.getPaginationAllFaculties(order, PAGE_SIZE, offset);
    }

    public List<Faculty> findAllFacultiesWhereOpenedRecruitments() {
        return facultyDao.getAllFacultiesWhereOpenedRecruitments();
    }

    public Faculty findFacultyByName(String name) {
        return facultyDao.getFacultyByName(name);
    }

    public Faculty getFacultyById(Long id) {
        return facultyDao.getFacultyById(id);
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
