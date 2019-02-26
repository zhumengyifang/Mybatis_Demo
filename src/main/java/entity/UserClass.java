package entity;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserClass {

    public UserClass() throws IOException {
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    private final InputStream inputStream;
    private final SqlSessionFactory sqlSessionFactory;
    private final SqlSession sqlSession;
    private final String resource = "SqlMapConfig.xml";

    public User findUserById(int id) {
        User user = sqlSession.selectOne("entity.findUserById", id);
        return user;
    }

    public int insertUser(User user) {
        sqlSession.insert("entity.insertUser", user);
        sqlSession.commit();
        return user.getId();
    }

    public void deleteUser(int id) {
        sqlSession.delete("entity.deleteUser", id);
        sqlSession.commit();
    }

    public void updateUser(User user) {
        sqlSession.update("entity.updateUser", user);
        sqlSession.commit();
    }

    public List<User> findUserList(UserQueryVo vo) throws Exception {
        return null;
    }

    public List<User> findUsersByName(String name) {
        List<User> users = sqlSession.selectList("entity.findUsersByName", name);
        return users;
    }

}
