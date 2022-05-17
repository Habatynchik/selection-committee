package ua.epam.elearn.selection.committee.controller.validator;

import ua.epam.elearn.selection.committee.controller.exception.admin.CapacityIncorrectException;
import ua.epam.elearn.selection.committee.controller.exception.admin.GeneralCapacityIncorrectException;
import ua.epam.elearn.selection.committee.controller.validator.exceptions.AdminExceptions;
import ua.epam.elearn.selection.committee.model.dto.FacultyDto;

import javax.servlet.http.HttpServletRequest;

public class FacultyValidator {
    private FacultyValidator() {
    }

    public static boolean validate(FacultyDto facultyDto, HttpServletRequest request) {
        try {
            checkGeneralCapacityCorrect(facultyDto.getGeneralCapacity(), facultyDto.getBudgetCapacity());
            checkCapacityCorrect(facultyDto.getBudgetCapacity());
            return true;
        } catch (CapacityIncorrectException e) {
            request.setAttribute(AdminExceptions.CAPACITY_INCORRECT_EXCEPTION, true);
        } catch (GeneralCapacityIncorrectException e) {
            request.setAttribute(AdminExceptions.GENERAL_CAPACITY_INCORRECT_EXCEPTION, true);
        }
        return false;
    }

    private static void checkGeneralCapacityCorrect(long generalCapacity, long budgetCapacity) throws GeneralCapacityIncorrectException {
        if (generalCapacity < budgetCapacity) {
            throw new GeneralCapacityIncorrectException();
        }
        if (generalCapacity < 1) {
            throw new GeneralCapacityIncorrectException();
        }
    }
    private static void checkCapacityCorrect(long capacity) throws CapacityIncorrectException {
        if (capacity < 0) {
            throw new CapacityIncorrectException();
        }
    }

}
