package ua.epam.elearn.selection.committee.controller.command.impl.common;

import ua.epam.elearn.selection.committee.controller.command.Command;
import ua.epam.elearn.selection.committee.controller.path.JspFilePath;
import ua.epam.elearn.selection.committee.model.entity.Faculty;
import ua.epam.elearn.selection.committee.model.services.FacultyService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class GetFacultiesCommand implements Command {

    private static final String FACULTY_LIST = "facultyList";

    FacultyService facultyService;

    public GetFacultiesCommand(FacultyService facultyService) {
        this.facultyService = facultyService;
    }



    @Override
    public String execute(HttpServletRequest request) {

        HttpSession session = request.getSession();

        List<Faculty> facultyList = facultyService.findAllFaculties();

        request.setAttribute(FACULTY_LIST, facultyList);

        return JspFilePath.FACULTIES;
    }
}
