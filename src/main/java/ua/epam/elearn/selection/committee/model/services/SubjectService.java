package ua.epam.elearn.selection.committee.model.services;

import ua.epam.elearn.selection.committee.model.dao.SubjectDao;
import ua.epam.elearn.selection.committee.model.dto.SubjectDto;
import ua.epam.elearn.selection.committee.model.entity.Subject;
import ua.epam.elearn.selection.committee.model.exception.admin.FacultyNameIsReservedException;

import java.util.List;

public class SubjectService {
    private final SubjectDao subjectDao;

    public SubjectService(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }

    public List<Subject> getAllSubjects() {
        return subjectDao.getAllSubjects();
    }

    public void addNewSubject(SubjectDto subjectDto) {
        Subject subject = new Subject(subjectDto);
        subjectDao.createSubject(subject);
    }

    public void addRequiredSubjects(long facultyId, List<Long> longList){
        subjectDao.addRequiredSubjects(facultyId, longList);
    }

}
