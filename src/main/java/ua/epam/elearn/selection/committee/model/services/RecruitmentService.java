package ua.epam.elearn.selection.committee.model.services;

import ua.epam.elearn.selection.committee.model.dao.RecruitmentDao;

public class RecruitmentService {

    RecruitmentDao recruitmentDao;

    public RecruitmentService(RecruitmentDao recruitmentDao) {
        this.recruitmentDao = recruitmentDao;
    }
}
