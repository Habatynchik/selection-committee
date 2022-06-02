package ua.epam.elearn.selection.committee.controller.command.impl.admin;

import ua.epam.elearn.selection.committee.controller.command.Command;
import ua.epam.elearn.selection.committee.controller.path.JspFilePath;

import javax.servlet.http.HttpServletRequest;

public class GetCreateRecruitmentCommand implements Command {

    private static final String ID = "id";
    private static final String FACULTY_ID = "facultyId";

    @Override
    public String execute(HttpServletRequest request) {



        request.setAttribute(FACULTY_ID, request.getParameter(ID));

        return JspFilePath.ADD_RECRUITMENT;

    }
}
