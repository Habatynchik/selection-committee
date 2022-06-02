package ua.epam.elearn.selection.committee.controller.validator;


public class FilterValidator {
    public static final String NAME = "name";
    public static final String GENERAL_CAPACITY = "general_capacity";
    public static final String BUDGET_CAPACITY = "budget_capacity";
    public static final String START_DATE = "start_date";
    public static final String END_DATE = "end_date";
    public static final String FACULTY_NAME = "faculty.name";
    public static final String RECRUITMENT_NAME = "recruitment.name";


    public static boolean validateSortFilterForFaculties(String sort) {
        return sort != null && (sort.equals(NAME) || sort.equals(GENERAL_CAPACITY) || sort.equals(BUDGET_CAPACITY));
    }

    public static boolean validateSortFilterForRecruitments(String sort) {
        return sort != null && (sort.equals(RECRUITMENT_NAME) || sort.equals(START_DATE) || sort.equals(END_DATE) || sort.equals(FACULTY_NAME));
    }
}
