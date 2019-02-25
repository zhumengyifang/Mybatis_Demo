package execute;

import dao.mapper.UserMapper;
import entity.User;
import entity.UserClass;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mybatis {

    public Mybatis() throws IOException {
        userClass = new UserClass();
    }

    private final UserClass userClass;

    @Test
    public void findUserById() throws Exception {
        User user = userClass.findUserById(1);
        userClass.closeSqlSession();
        System.out.println(user.toString());
    }

    @Test
    public void findUserByName() throws Exception {
        List<User> users = userClass.findUsersByName("王");
        userClass.closeSqlSession();
        users.forEach(p -> System.out.println(p.toString()));
    }

    @Test
    public void insertUser() throws Exception {
        User user = new User();
        user.setUsername("小黑");
        user.setAddress("北京");
        user.setSex("2");
        int id = userClass.insertUser(user);
        userClass.closeSqlSession();
        System.out.println("新插入数据的ID：" + id);
    }

    @Test
    public void deleteUser() throws IOException {
        userClass.deleteUser(31);
        userClass.closeSqlSession();
        System.out.println("删除成功!");
    }

    @Test
    public void updateUser() throws IOException {
        User user = userClass.findUserById(29);
        user.setUsername("小心");
        user.setSex("2");
        user.setAddress("上海");
        userClass.updateUser(user);
        userClass.closeSqlSession();
        System.out.println("更新成功!");
    }

    /**
     * 直接通过mapper接口
     * @throws IOException
     */
    @Test
    public void userMapperDemo() throws IOException{
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.findUserById(1);
        sqlSession.close();
        System.out.println(user.toString());
    }

}
