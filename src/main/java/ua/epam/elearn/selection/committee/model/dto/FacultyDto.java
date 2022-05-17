package ua.epam.elearn.selection.committee.model.dto;

import java.util.Objects;

public class FacultyDto {

    private String name;
    private long generalCapacity;
    private long budgetCapacity;

    public FacultyDto() {
    }

    public FacultyDto(String name, long generalCapacity, long budgetCapacity) {
        this.name = name;
        this.generalCapacity = generalCapacity;
        this.budgetCapacity = budgetCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getGeneralCapacity() {
        return generalCapacity;
    }

    public void setGeneralCapacity(long generalCapacity) {
        this.generalCapacity = generalCapacity;
    }

    public long getBudgetCapacity() {
        return budgetCapacity;
    }

    public void setBudgetCapacity(long budgetCapacity) {
        this.budgetCapacity = budgetCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FacultyDto that = (FacultyDto) o;
        return generalCapacity == that.generalCapacity && budgetCapacity == that.budgetCapacity && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, generalCapacity, budgetCapacity);
    }
}
