package ua.epam.elearn.selection.committee.model.dao.impl;

import ua.epam.elearn.selection.committee.model.dao.DaoFactory;
import ua.epam.elearn.selection.committee.model.dao.FacultyDao;
import ua.epam.elearn.selection.committee.model.dao.UserDao;

public class DaoFactoryImpl extends DaoFactory {

    public DaoFactoryImpl() {}

    @Override
    public UserDao createUserDao() {
        return new UserDaoImpl();
    }

    @Override
    public FacultyDao createFacultyDao() {
        return new FacultyDaoImpl();
    }

}
