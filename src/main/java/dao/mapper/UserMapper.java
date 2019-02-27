package dao.mapper;

import entity.User;
import entity.UserQueryVo;
import org.apache.ibatis.annotations.Param;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public interface UserMapper {
    List<User> findUsersByName(String name) throws IOException;

    User findUserById(int id) throws IOException;

    int insertUser(User user) throws IOException;

    void deleteUser(int id) throws IOException;

    void updateUser(User user) throws IOException;

    List<User> findUserList(UserQueryVo vo) throws Exception;

    List<User> findUserByHashMap(HashMap hashMap) throws Exception;

    User findUserRstMap(int id) throws Exception;

    List<User> findUserListByTag(UserQueryVo vo) throws Exception;

    List<User> userListByIds(@Param("li") List<Integer> list) throws Exception;
}

