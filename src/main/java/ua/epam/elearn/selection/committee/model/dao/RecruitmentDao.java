package ua.epam.elearn.selection.committee.model.dao;

import ua.epam.elearn.selection.committee.model.entity.Recruitment;

import java.util.List;

public interface RecruitmentDao {

    Recruitment getRecruitmentById(long id);

    List<Recruitment> getAllRecruitments();

    boolean addRecruitment(Recruitment recruitment);
}
