package ua.epam.elearn.selection.committee.model.entity;

public class Subject {
    private long id;
    private String name;
    private int grade;

    public Subject() {
    }

    public Subject(String name) {
        this.name = name;
    }

    public Subject(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Subject(long id, String name, int grade) {
        this.id = id;
        this.name = name;
        this.grade = grade;
    }

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

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }
}
