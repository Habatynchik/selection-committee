package ua.epam.elearn.selection.committee.model.services;

import ua.epam.elearn.selection.committee.model.dao.SubjectDao;
import ua.epam.elearn.selection.committee.model.dto.SubjectDto;
import ua.epam.elearn.selection.committee.model.entity.Subject;

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

    public List<Subject> getRequiredSubjects(long facultyId) {
        return subjectDao.getRequiredSubjectsByFacultyId(facultyId);
    }

    public List<Subject> getRequiredSubjectsByRecruitmentId(long recruitmentId) {
        return subjectDao.getRequiredSubjectsByRecruitmentId(recruitmentId);
    }



}
