package ua.epam.elearn.selection.committee.controller.command.impl.mapper;

import ua.epam.elearn.selection.committee.model.dto.FacultyDto;
import ua.epam.elearn.selection.committee.model.dto.UserDto;

import javax.servlet.http.HttpServletRequest;

public class FacultyMapper {
    private static final String FACULTY_NAME = "facultyName";
    private static final String GENERAL_CAPACITY = "generalCapacity";
    private static final String BUDGET_CAPACITY = "budgetCapacity";

    public FacultyDto fetchFacultyDtoFromRequest(HttpServletRequest req) {
        return new FacultyDto(
                req.getParameter(FACULTY_NAME),
                Long.parseLong(req.getParameter(GENERAL_CAPACITY)),
                Long.parseLong(req.getParameter(BUDGET_CAPACITY))
        );
    }

    public void insertFacultyDtoIntoRequest(FacultyDto facultyDto, HttpServletRequest req) {
        req.setAttribute(FACULTY_NAME, facultyDto.getName());
        req.setAttribute(GENERAL_CAPACITY, facultyDto.getGeneralCapacity());
        req.setAttribute(BUDGET_CAPACITY, facultyDto.getBudgetCapacity());

    }
}
