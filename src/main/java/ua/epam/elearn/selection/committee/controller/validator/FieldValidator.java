package ua.epam.elearn.selection.committee.controller.validator;

public class FieldValidator {
    private FieldValidator() {}

    public static boolean fieldIsEmpty(String field) {
        return field == null || field.trim().isEmpty();
    }

}
