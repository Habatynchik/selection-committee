package ua.epam.elearn.selection.committee.model.entity;

import ua.epam.elearn.selection.committee.model.entity.enums.RecruitmentState;

import java.time.LocalDateTime;

public class Recruitment {
    private int enrollmentId;
    private RecruitmentState state;
    private LocalDateTime startDate;
    private LocalDateTime endDate;

}
