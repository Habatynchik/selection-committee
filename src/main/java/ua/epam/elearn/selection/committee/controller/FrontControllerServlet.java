package ua.epam.elearn.selection.committee.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.epam.elearn.selection.committee.controller.command.Command;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import ua.epam.elearn.selection.committee.controller.command.impl.guest.GetLoginCommand;
import ua.epam.elearn.selection.committee.controller.command.impl.guest.GetRegistrationCommand;
import ua.epam.elearn.selection.committee.controller.command.impl.guest.PostLoginCommand;
import ua.epam.elearn.selection.committee.controller.command.impl.guest.PostRegistrationCommand;
import ua.epam.elearn.selection.committee.controller.path.UrlPath;
import ua.epam.elearn.selection.committee.model.services.ServiceFactory;

@WebServlet(name = "FrontControllerServlet", value = "/FrontControllerServlet")
public class FrontControllerServlet extends HttpServlet {

    Logger logger = LogManager.getLogger(FrontControllerServlet.class);

    private static final String COMMAND_NOT_FOUND = "Command not found";
    private final Map<String, Command> getCommands = new ConcurrentHashMap<>();
    private final Map<String, Command> postCommands = new ConcurrentHashMap<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        putGetCommands(serviceFactory);
        putPostCommands(serviceFactory);
        logger.info("Dispatcher servlet has been initialized");
    }

    private void putGetCommands(ServiceFactory serviceFactory) {

        getCommands.put(UrlPath.REGISTRATION, new GetRegistrationCommand());
        getCommands.put(UrlPath.LOGIN, new GetLoginCommand());
        logger.warn("page: {} not found !!!!!!!!!!!");
    }


    private void putPostCommands(ServiceFactory serviceFactory) {

        postCommands.put(UrlPath.REGISTRATION, new PostRegistrationCommand(serviceFactory.createUserService()));
        postCommands.put(UrlPath.LOGIN, new PostLoginCommand(serviceFactory.createUserService()));
        logger.warn("page: {} not found");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp, getCommands);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp, postCommands);
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp, Map<String, Command> commands) throws IOException, ServletException {
        final String URI = req.getRequestURI();

        String commandKey = commands.keySet().stream()
                .filter(key -> key.equals(URI))
                .findFirst()
                .orElse(COMMAND_NOT_FOUND);


        if (commandKey.equals(COMMAND_NOT_FOUND)) {
            logger.warn("page: {} not found", URI);
            resp.sendError(404);
            return;
        }

        Command command = commands.get(commandKey);
        String result = command.execute(req);

        renderPage(req, resp, result);
    }

    private void renderPage(HttpServletRequest req, HttpServletResponse resp, String pagePath) throws ServletException, IOException {
        if (pagePath.startsWith(UrlPath.REDIRECT)) {
            resp.sendRedirect(pagePath.replace(UrlPath.REDIRECT, ""));
        } else {
            req.getRequestDispatcher(pagePath).forward(req, resp);
        }
    }
}
