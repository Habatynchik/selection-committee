package ua.epam.elearn.selection.committee.controller.command.impl.mapper;

import ua.epam.elearn.selection.committee.model.dto.FacultyDto;
import ua.epam.elearn.selection.committee.model.dto.UserDto;

import javax.servlet.http.HttpServletRequest;

public class FacultyMapper {
    private static final String FACULTY_NAME = "facultyName";
    private static final String GENERAL_CAPACITY = "generalCapacity";
    private static final String BUDGET_CAPACITY = "budgetCapacity";
    private static final String SUBJECTS_ID = "subjectId";

    public FacultyDto fetchFacultyDtoFromRequest(HttpServletRequest req) {
        return new FacultyDto(
                req.getParameter(FACULTY_NAME),
                req.getParameter(GENERAL_CAPACITY),
                req.getParameter(BUDGET_CAPACITY)
        );
    }

    public FacultyDto fetchFacultyDtoWithSubjectsFromRequest(HttpServletRequest req) {
        return new FacultyDto(
                req.getParameter(FACULTY_NAME),
                req.getParameter(GENERAL_CAPACITY),
                req.getParameter(BUDGET_CAPACITY),
                req.getParameterValues(SUBJECTS_ID)
        );
    }

    public void insertFacultyDtoIntoRequest(FacultyDto facultyDto, HttpServletRequest req) {
        req.setAttribute(FACULTY_NAME, facultyDto.getName());
        req.setAttribute(GENERAL_CAPACITY, facultyDto.getGeneralCapacity());
        req.setAttribute(BUDGET_CAPACITY, facultyDto.getBudgetCapacity());

    }
}
