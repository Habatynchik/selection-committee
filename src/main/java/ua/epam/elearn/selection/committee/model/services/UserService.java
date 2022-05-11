package ua.epam.elearn.selection.committee.model.services;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.epam.elearn.selection.committee.model.dao.UserDao;
import ua.epam.elearn.selection.committee.model.dto.UserDto;
import ua.epam.elearn.selection.committee.model.entity.User;
import ua.epam.elearn.selection.committee.model.exception.user.AuthenticationException;
import ua.epam.elearn.selection.committee.model.exception.user.EmailIsReservedException;
import ua.epam.elearn.selection.committee.model.exception.user.LoginIsReservedException;
import ua.epam.elearn.selection.committee.model.exception.user.UserIsBlockedException;
import ua.epam.elearn.selection.committee.model.services.util.PasswordEncoder;

import java.util.List;

public class UserService {

    private final UserDao userDao;
    private final PasswordEncoder passwordEncoder;

    private final Logger logger = LogManager.getLogger(UserService.class);


    public UserService(PasswordEncoder passwordEncoder, UserDao userDao) {
        this.passwordEncoder = passwordEncoder;
        this.userDao = userDao;
    }

    public User findById(Long id) {
        return userDao.getUserById(id);
    }

    public List<User> findAllUsers() {
        return userDao.getAllUsers();
    }

    public User doAuthentication(String username, String password) throws UserIsBlockedException, AuthenticationException {

        password = passwordEncoder.encode(password);
        User user = userDao.getByLoginAndPassword(username, password);

        if (user != null) {
            if (!user.isBlocked()) {
                return user;
            } else {
                throw new UserIsBlockedException();
            }
        } else {
            throw new AuthenticationException();
        }
    }


    public void registerNewAccount(UserDto userDto) throws LoginIsReservedException, EmailIsReservedException {

        checkLoginIsUnique(userDto.getLogin());
        checkEmailIsUnique(userDto.getEmail());

        User user = new User(userDto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userDao.createUser(user);

        logger.info("New account {} has been created", user);
    }


    public void blockById(Long id) {
        userDao.blockUserById(id);

    }

    public void unblockById(Long id) {
        userDao.unblockUserById(id);

    }

    private void checkLoginIsUnique(String login) throws LoginIsReservedException {
        if (userDao.getUserByLogin(login) != null) throw new LoginIsReservedException();
    }

    private void checkEmailIsUnique(String email) throws EmailIsReservedException {
        if (userDao.getUserByEmail(email) != null) throw new EmailIsReservedException();
    }

}
