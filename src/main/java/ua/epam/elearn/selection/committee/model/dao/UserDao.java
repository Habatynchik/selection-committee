package ua.epam.elearn.selection.committee.model.dao;

import ua.epam.elearn.selection.committee.model.entity.User;

import java.util.List;

public interface UserDao {

    boolean createUser(User user);

    List<User> getAllUsers();

    User getUserById(long id);

    User getUserByEmail(String email);

    User getUserByLogin(String login);

    User getByLoginAndPassword(String login, String password);

    boolean blockUserById(long id);

    boolean unblockUserById(long id);
}
