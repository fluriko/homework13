package mate.academy.database.user;

import mate.academy.model.User;
import java.util.List;
import java.util.Optional;

public interface UserDao {
    int addUser(User user);
    int removeUser(User user);
    Optional<User> getUserByLogin(String login);
    Optional<User> getUserById(int id);
    int editUser(User user);
    List<User> getUsers();
    boolean containsLogin(String login);
    boolean containsMail(String mail);
}
