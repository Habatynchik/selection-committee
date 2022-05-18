package ua.epam.elearn.selection.committee.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Recruitment implements Serializable {
    private static final long serialVersionUID = 100L;

    private long id;
    private String name;
    private long facultyId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean closed;

    public Recruitment() {
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

    public long getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(long facultyId) {
        this.facultyId = facultyId;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDateTime endDate) {
        this.endDate = endDate;
    }

    public boolean isClosed() {
        return closed;
    }

    public void setClosed(boolean closed) {
        this.closed = closed;
    }

    public static class Builder {
        private final Recruitment newRecruitment;

        public Builder() {
            this.newRecruitment = new Recruitment();
        }

        public Builder addId(long id) {
            newRecruitment.setId(id);
            return this;
        }

        public Builder addName(String name) {
            newRecruitment.setName(name);
            return this;
        }

        public Builder addFacultyId(long facultyId) {
            newRecruitment.setFacultyId(facultyId);
            return this;
        }

        public Builder addStartDate(LocalDateTime startDate) {
            newRecruitment.setStartDate(startDate);
            return this;
        }

        public Builder addEndDate(LocalDateTime endDate) {
            newRecruitment.setEndDate(endDate);
            return this;
        }

        public Builder addClosed(boolean closed) {
            newRecruitment.setClosed(closed);
            return this;
        }

        public Recruitment build() {
            return newRecruitment;
        }

    }
}
