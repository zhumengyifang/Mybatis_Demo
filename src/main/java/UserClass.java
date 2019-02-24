import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserClass implements UserMapper {

    public UserClass() throws IOException {
        inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
    }

    private final InputStream inputStream;
    private final SqlSessionFactory sqlSessionFactory;
    private final SqlSession sqlSession;
    private final String resource = "SqlMapConfig.xml";

    @Override
    public User findUserById(int id) {
        User user = sqlSession.selectOne("model.findUserById", id);
        return user;
    }

    @Override
    public int insertUser(User user) {
        sqlSession.insert("model.insertUser", user);
        sqlSession.commit();
        return user.getId();
    }

    @Override
    public void deleteUser(int id) {
        sqlSession.delete("model.deleteUser", id);
        sqlSession.commit();
    }

    @Override
    public void updateUser(User user) {
        sqlSession.update("model.updateUser", user);
        sqlSession.commit();
    }

    @Override
    public List<User> findUsersByName(String name) {
        List<User> users = sqlSession.selectList("model.findUsersByName", name);
        return users;
    }

    @Override
    public void closeSqlSession() {
        sqlSession.close();
    }

}
