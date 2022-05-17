package ua.epam.elearn.selection.committee.model.dao;

import ua.epam.elearn.selection.committee.model.entity.Subject;

import java.util.List;

public interface SubjectDao {

    boolean createSubject(Subject subject);

    Subject getSubjectById(long id);

    List<Subject> getAllSubjects();

    boolean addRequiredSubjects(long facultyId, List<Long> subjectList);

}
