package ua.epam.elearn.selection.committee.model.dto;

import java.util.List;
import java.util.Objects;

public class FacultyDto {

    private String name;
    private String generalCapacity;
    private String budgetCapacity;
    private String[] requiredSubjectIdList;

    public FacultyDto() {
    }

    public FacultyDto(String name, String generalCapacity, String budgetCapacity) {
        this.name = name;
        this.generalCapacity = generalCapacity;
        this.budgetCapacity = budgetCapacity;
    }

    public FacultyDto(String name, String generalCapacity, String budgetCapacity, String[] requiredSubjectIdList) {
        this.name = name;
        this.generalCapacity = generalCapacity;
        this.budgetCapacity = budgetCapacity;
        this.requiredSubjectIdList = requiredSubjectIdList;
    }

    public String[] getRequiredSubjectIdList() {
        return requiredSubjectIdList;
    }

    public void setRequiredSubjectIdList(String[] requiredSubjectIdList) {
        this.requiredSubjectIdList = requiredSubjectIdList;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGeneralCapacity() {
        return generalCapacity;
    }

    public void setGeneralCapacity(String generalCapacity) {
        this.generalCapacity = generalCapacity;
    }

    public String getBudgetCapacity() {
        return budgetCapacity;
    }

    public void setBudgetCapacity(String budgetCapacity) {
        this.budgetCapacity = budgetCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyDto that = (FacultyDto) o;
        return Objects.equals(name, that.name) && Objects.equals(generalCapacity, that.generalCapacity) && Objects.equals(budgetCapacity, that.budgetCapacity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, generalCapacity, budgetCapacity);
    }
}
