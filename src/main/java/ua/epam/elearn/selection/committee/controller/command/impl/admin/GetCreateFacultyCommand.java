package ua.epam.elearn.selection.committee.controller.command.impl.admin;

import ua.epam.elearn.selection.committee.controller.command.Command;
import ua.epam.elearn.selection.committee.controller.path.JspFilePath;
import ua.epam.elearn.selection.committee.model.entity.Subject;
import ua.epam.elearn.selection.committee.model.services.SubjectService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetCreateFacultyCommand implements Command {

    private static final String SUBJECT_LIST = "subjectList";

    SubjectService subjectService;

    public GetCreateFacultyCommand(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        List<Subject> subjectList = subjectService.getAllSubjects();
        request.setAttribute(SUBJECT_LIST, subjectList);

        return JspFilePath.ADD_FACULTY;
    }
}
