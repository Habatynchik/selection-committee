package ua.epam.elearn.selection.committee.controller.command.impl.guest;

import ua.epam.elearn.selection.committee.controller.command.Command;
import ua.epam.elearn.selection.committee.controller.path.JspFilePath;

import javax.servlet.http.HttpServletRequest;

public class GetRegistrationCommand  implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return JspFilePath.REGISTRATION;
    }
}
