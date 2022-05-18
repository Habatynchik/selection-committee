package ua.epam.elearn.selection.committee.model.dao.mapper;

import ua.epam.elearn.selection.committee.model.entity.Faculty;
import ua.epam.elearn.selection.committee.model.entity.Recruitment;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RecruitmentMapper {


    public Recruitment extractFromResultSet(ResultSet rs) throws SQLException {

        return new Recruitment.Builder()
                .addId(rs.getLong(Fields.ID))
                .addName(rs.getString(Fields.NAME))
                .addFacultyId(rs.getLong(Fields.FACULTY_ID))
                .addStartDate(rs.getDate(Fields.START_DATE).toLocalDate().atStartOfDay())
                .addEndDate(rs.getDate(Fields.END_DATE).toLocalDate().atStartOfDay())
                .addClosed(rs.getBoolean(Fields.CLOSED))
                .build();
    }
}
