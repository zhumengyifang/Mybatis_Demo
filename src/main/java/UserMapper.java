import model.User;

import java.io.IOException;
import java.util.List;

public interface UserMapper {
    List<User> findUsersByName(String name) throws IOException;

    User findUserById(int id) throws IOException;

    int insertUser(User user) throws IOException;

    void deleteUser(int id) throws IOException;

    void updateUser(User user) throws IOException;

    void closeSqlSession();
}

