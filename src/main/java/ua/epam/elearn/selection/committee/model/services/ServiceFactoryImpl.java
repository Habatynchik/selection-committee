package ua.epam.elearn.selection.committee.model.services;

import ua.epam.elearn.selection.committee.model.dao.DaoFactory;
import ua.epam.elearn.selection.committee.model.services.util.SHA256PasswordEncoder;

public class ServiceFactoryImpl extends ServiceFactory {

    @Override
    public UserService createUserService() {
        return new UserService(
                new SHA256PasswordEncoder(),
                DaoFactory.getInstance().createUserDao()
        );
    }

}