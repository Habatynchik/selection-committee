package ua.epam.elearn.selection.committee.controller;

import ua.epam.elearn.selection.committee.controller.command.Command;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ua.epam.elearn.selection.committee.controller.command.impl.admin.*;
import ua.epam.elearn.selection.committee.controller.command.impl.common.GetFacultiesCommand;
import ua.epam.elearn.selection.committee.controller.command.impl.guest.GetLoginCommand;
import ua.epam.elearn.selection.committee.controller.command.impl.guest.GetRegistrationCommand;
import ua.epam.elearn.selection.committee.controller.command.impl.guest.PostLoginCommand;
import ua.epam.elearn.selection.committee.controller.command.impl.guest.PostRegistrationCommand;
import ua.epam.elearn.selection.committee.controller.command.impl.common.GetLogoutCommand;
import ua.epam.elearn.selection.committee.controller.path.UrlPath;
import ua.epam.elearn.selection.committee.model.services.ServiceFactory;

@WebServlet(name = "FrontControllerServlet", urlPatterns = "/")
public class FrontControllerServlet extends HttpServlet {


    private static final String COMMAND_NOT_FOUND = "Command not found";
    private final Map<String, Command> getCommands = new ConcurrentHashMap<>();
    private final Map<String, Command> postCommands = new ConcurrentHashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        putGetCommands(serviceFactory);
        putPostCommands(serviceFactory);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response, getCommands);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        process(request, response, postCommands);
    }

    private void process(HttpServletRequest request, HttpServletResponse response, Map<String, Command> commands) throws IOException, ServletException {
        final String URI = request.getRequestURI();

        String commandKey = commands.keySet().stream()
                .filter(key -> key.equals(URI))
                .findFirst()
                .orElse(COMMAND_NOT_FOUND);


        if (commandKey.equals(COMMAND_NOT_FOUND)) {
            response.sendError(404);
            return;
        }

        Command command = commands.get(commandKey);
        String result = command.execute(request);

        renderPage(request, response, result);
    }

    private void renderPage(HttpServletRequest req, HttpServletResponse resp, String pagePath) throws ServletException, IOException {
        if (pagePath.startsWith(UrlPath.REDIRECT)) {
            resp.sendRedirect(pagePath.replace(UrlPath.REDIRECT, ""));
        } else {
            req.getRequestDispatcher(pagePath).forward(req, resp);
        }
    }

    private void putGetCommands(ServiceFactory serviceFactory) {

        getCommands.put(UrlPath.REGISTRATION, new GetRegistrationCommand());
        getCommands.put(UrlPath.LOGIN, new GetLoginCommand());
        getCommands.put(UrlPath.LOGOUT, new GetLogoutCommand());
        getCommands.put(UrlPath.ADD_FACULTY, new GetCreateFacultyCommand(serviceFactory.createSubjectService()));
        getCommands.put(UrlPath.FACULTIES, new GetFacultiesCommand(serviceFactory.createFacultyService(), serviceFactory.createSubjectService()));
        getCommands.put(UrlPath.SUBJECTS, new GetSubjectsCommand(serviceFactory.createSubjectService()));
        getCommands.put(UrlPath.ADD_SUBJECT, new GetCreateSubjectCommand());

    }


    private void putPostCommands(ServiceFactory serviceFactory) {

        postCommands.put(UrlPath.REGISTRATION, new PostRegistrationCommand(serviceFactory.createUserService()));
        postCommands.put(UrlPath.LOGIN, new PostLoginCommand(serviceFactory.createUserService()));
        postCommands.put(UrlPath.ADD_FACULTY, new PostCreateFacultyCommand(serviceFactory.createFacultyService(), serviceFactory.createSubjectService()));
        postCommands.put(UrlPath.ADD_SUBJECT, new PostCreateSubjectCommand(serviceFactory.createSubjectService()));

    }


}
