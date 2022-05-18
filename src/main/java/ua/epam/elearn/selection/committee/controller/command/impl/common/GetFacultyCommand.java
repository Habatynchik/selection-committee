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

public class GetFacultyCommand implements Command {

    private static final String FACULTY = "faculty";
    private static final String REQUIRED_SUBJECTS_LIST = "requiredSubjectList";

    public GetFacultyCommand(FacultyService facultyService, SubjectService subjectService) {
        this.facultyService = facultyService;
        this.subjectService = subjectService;
    }

    private final FacultyService facultyService;
    private final SubjectService subjectService;



    @Override
    public String execute(HttpServletRequest request) {

        Faculty faculty = facultyService.getFacultyById(Long.valueOf(request.getParameter("id")));

        List<Subject> requiredSubjectList = subjectService.getRequiredSubjects(faculty.getId());

        request.setAttribute(FACULTY, faculty);
        request.setAttribute(REQUIRED_SUBJECTS_LIST, requiredSubjectList);

        return JspFilePath.FACULTY;
    }
}
