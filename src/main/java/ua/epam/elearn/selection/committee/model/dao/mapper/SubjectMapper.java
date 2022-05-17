package ua.epam.elearn.selection.committee.model.dao.mapper;

import ua.epam.elearn.selection.committee.model.entity.Faculty;
import ua.epam.elearn.selection.committee.model.entity.Subject;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SubjectMapper {

    public Subject extractFromResultSet(ResultSet rs) throws SQLException {

        return new Subject.Builder()
                .addId(rs.getLong(Fields.SUBJECT_ID))
                .addNameEn(rs.getString(Fields.NAME_EN))
                .addNameRu(rs.getString(Fields.NAME_RU))
                .addNameUk(rs.getString(Fields.NAME_UK))
                .build();
    }
}
