package ua.epam.elearn.selection.committee.model.entity.enums;

public enum ApplicationState {

    REGISTERED(1),
    CANCELED(2),
    REJECTED(3),
    ACCEPTED_FOR_CONTRACT(4),
    ACCEPTED_FOR_BUDGET(5);

    private final int id;

    ApplicationState(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
