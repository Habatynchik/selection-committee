package ua.epam.elearn.selection.committee.model.entity.enums;

public enum Role {
    ADMIN(1), CLIENT(2);

    private final long id;

    Role(int id) {
        this.id = id;
    }

    public long getRole(){
        return id;
    }
}
