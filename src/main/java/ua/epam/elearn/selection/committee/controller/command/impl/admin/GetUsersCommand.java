package ua.epam.elearn.selection.committee.controller.command.impl.admin;

import ua.epam.elearn.selection.committee.controller.command.Command;
import ua.epam.elearn.selection.committee.controller.path.JspFilePath;
import ua.epam.elearn.selection.committee.model.entity.User;
import ua.epam.elearn.selection.committee.model.services.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetUsersCommand implements Command {

    private static final String USERS = "users";

    private UserService userService;

    public GetUsersCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        List<User> userList = userService.findAllUsers();
        request.setAttribute(USERS, userList);

        return JspFilePath.USERS;
    }
}
