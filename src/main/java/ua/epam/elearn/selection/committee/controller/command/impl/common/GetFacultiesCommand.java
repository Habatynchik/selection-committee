package ua.epam.elearn.selection.committee.controller.command.impl.common;

import ua.epam.elearn.selection.committee.controller.command.Command;
import ua.epam.elearn.selection.committee.controller.path.JspFilePath;
import ua.epam.elearn.selection.committee.model.entity.Faculty;
import ua.epam.elearn.selection.committee.model.entity.Subject;
import ua.epam.elearn.selection.committee.model.services.FacultyService;
import ua.epam.elearn.selection.committee.model.services.SubjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetFacultiesCommand implements Command {

    private static final String FACULTY_LIST = "facultyList";
    private static final String SUBJECT_LIST = "subjectList";

    FacultyService facultyService;
    SubjectService subjectService;

    public GetFacultiesCommand(FacultyService facultyService, SubjectService subjectService) {
        this.facultyService = facultyService;
        this.subjectService = subjectService;
    }

    @Override
    public String execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        List<Subject> subjectList = subjectService.getAllSubjects();

        session.setAttribute(SUBJECT_LIST, subjectList);

        List<Faculty> facultyList = facultyService.findAllFaculties();

        request.setAttribute(FACULTY_LIST, facultyList);

        return JspFilePath.FACULTIES;
    }
}
