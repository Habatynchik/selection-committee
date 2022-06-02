package ua.epam.elearn.selection.committee.controller.command.impl.admin;

import ua.epam.elearn.selection.committee.controller.command.Command;
import ua.epam.elearn.selection.committee.controller.command.impl.mapper.FacultyMapper;
import ua.epam.elearn.selection.committee.controller.command.impl.mapper.RecruitmentMapper;
import ua.epam.elearn.selection.committee.controller.command.impl.mapper.SubjectMapper;
import ua.epam.elearn.selection.committee.controller.path.JspFilePath;
import ua.epam.elearn.selection.committee.controller.path.UrlPath;
import ua.epam.elearn.selection.committee.controller.validator.RecruitmentValidator;
import ua.epam.elearn.selection.committee.controller.validator.SubjectValidator;
import ua.epam.elearn.selection.committee.model.dto.RecruitmentDto;
import ua.epam.elearn.selection.committee.model.dto.SubjectDto;
import ua.epam.elearn.selection.committee.model.services.FacultyService;
import ua.epam.elearn.selection.committee.model.services.RecruitmentService;

import javax.servlet.http.HttpServletRequest;

public class PostCreateRecruitmentCommand implements Command {

    private final RecruitmentMapper recruitmentMapper = new RecruitmentMapper();

    private final RecruitmentService recruitmentService;

    public PostCreateRecruitmentCommand(RecruitmentService recruitmentService) {
        this.recruitmentService = recruitmentService;
    }

    @Override
    public String execute(HttpServletRequest request) {

        RecruitmentDto recruitmentDto = recruitmentMapper.fetchRecruitmentDtoFromRequest(request);
        System.out.println(recruitmentDto.getEndDate());
        boolean recruitmentDtoIsValid = RecruitmentValidator.validate(recruitmentDto, request);


        if (recruitmentDtoIsValid) {
            recruitmentService.addNewRecruitment(recruitmentDto);
            return UrlPath.REDIRECT + UrlPath.FACULTIES;
        }

        recruitmentMapper.insertRecruitmentDtoIntoRequest(recruitmentDto, request);

        return JspFilePath.ADD_RECRUITMENT;
    }
}
