package ua.epam.elearn.selection.committee.model.dao.database;

import ua.epam.elearn.selection.committee.model.dao.impl.UserDaoImpl;

public class Main {


    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        System.out.println(userDao.getUserById(1));
    }
}
