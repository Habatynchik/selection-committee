package ua.epam.elearn.selection.committee.controller.command.impl.admin;

import ua.epam.elearn.selection.committee.controller.command.Command;
import ua.epam.elearn.selection.committee.controller.path.UrlPath;
import ua.epam.elearn.selection.committee.model.services.ApplicationService;
import ua.epam.elearn.selection.committee.model.services.RecruitmentService;

import javax.servlet.http.HttpServletRequest;

public class PostCloseRecruitmentCommand implements Command {

    private static final String RECRUITMENT_ID = "recruitmentId";


    RecruitmentService recruitmentService;
    ApplicationService applicationService;

    public PostCloseRecruitmentCommand(RecruitmentService recruitmentService, ApplicationService applicationService) {
        this.recruitmentService = recruitmentService;
        this.applicationService = applicationService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        long recruitmentId = Long.parseLong(request.getParameter(RECRUITMENT_ID));

        recruitmentService.closeRecruitment(recruitmentId);
        applicationService.finalizeApplication(recruitmentId);

        return UrlPath.REDIRECT + UrlPath.RECRUITMENTS;
    }
}
