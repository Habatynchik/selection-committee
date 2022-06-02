package ua.epam.elearn.selection.committee.controller.command.impl.common;

import ua.epam.elearn.selection.committee.controller.command.Command;
import ua.epam.elearn.selection.committee.controller.path.JspFilePath;
import ua.epam.elearn.selection.committee.model.entity.Application;
import ua.epam.elearn.selection.committee.model.services.ApplicationService;
import ua.epam.elearn.selection.committee.model.services.ServiceFactory;
import ua.epam.elearn.selection.committee.model.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetProfileCommand implements Command {
    private final String USER = "userId";
    private final String APPLICATIONS = "applications";

    ApplicationService applicationService;
    UserService userService;

    public GetProfileCommand(ApplicationService applicationService) {
        this.applicationService = applicationService;
        userService = ServiceFactory.getInstance().createUserService();
    }


    @Override
    public String execute(HttpServletRequest request) {

        Long userId = Long.valueOf(request.getParameter(USER));

        List<Application> applicationList = applicationService.getAllApplicationsByUserId(userId);

        request.setAttribute(APPLICATIONS, applicationList);
        request.setAttribute(USER, userService.findById(userId));

        return JspFilePath.PROFILE;
    }
}
