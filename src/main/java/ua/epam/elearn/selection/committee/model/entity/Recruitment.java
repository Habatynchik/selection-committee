package ua.epam.elearn.selection.committee.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Recruitment implements Serializable {
    private static final long serialVersionUID = 44L;

    private int id;
    private int facultyId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private boolean closed;

}
