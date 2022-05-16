package ua.epam.elearn.selection.committee.model.entity;

import java.util.List;

public class Faculty {
    private long id;
    private String name;
    private long generalCapacity;
    private long budgetCapacity;
    private List<Subject> requiredSubjects;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Subject> getRequiredSubjects() {
        return requiredSubjects;
    }

    public void setRequiredSubjects(List<Subject> requiredSubjects) {
        this.requiredSubjects = requiredSubjects;
    }

    public static class Builder {

        private final Faculty newFaculty;


        public Builder() {
            this.newFaculty = new Faculty();
        }

        public Builder addId(long id) {
            newFaculty.setId(id);
            return this;
        }

        public Builder addName(String name) {
            newFaculty.setName(name);
            return this;
        }

        public Builder addGeneralCapacity(long generalCapacity) {
            newFaculty.setGeneralCapacity(generalCapacity);
            return this;
        }

        public Builder addBudgetCapacity(long budgetCapacity) {
            newFaculty.setBudgetCapacity(budgetCapacity);
            return this;
        }

        public Builder addRequiredSubjects(List<Subject> requiredSubjects) {
            newFaculty.setRequiredSubjects(requiredSubjects);
            return this;
        }

        public Faculty build() {
            return newFaculty;
        }
    }
}