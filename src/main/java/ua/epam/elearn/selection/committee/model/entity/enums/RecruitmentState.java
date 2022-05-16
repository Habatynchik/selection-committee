package ua.epam.elearn.selection.committee.model.entity.enums;

public enum RecruitmentState {

    OPENED(1),
    CLOSED(2);

    private final int ordinalNumber;

    RecruitmentState(int ordinalNumber) {
        this.ordinalNumber = ordinalNumber;
    }

    public int getOrdinalNumber(){
        return ordinalNumber;
    }
}
