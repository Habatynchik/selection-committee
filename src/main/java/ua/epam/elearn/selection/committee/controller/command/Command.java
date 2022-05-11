package ua.epam.elearn.selection.committee.controller.command;

import javax.servlet.http.HttpServletRequest;

public interface Command {

    String execute(HttpServletRequest request);

}
