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
import java.util.HashMap;
import java.util.List;

public class Mybatis {

    public Mybatis() throws IOException {
        userClass = new UserClass();
    }

    private final UserClass userClass;

    @Test
    public void findUserById() {
        User user = userClass.findUserById(1);
        System.out.println(user.toString());
    }

    @Test
    public void findUserByName() {
        List<User> users = userClass.findUsersByName("王");
        users.forEach(p -> System.out.println(p.toString()));
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setUsername("小黑");
        user.setAddress("北京");
        user.setSex("2");
        int id = userClass.insertUser(user);
        System.out.println("新插入数据的ID：" + id);
    }

    @Test
    public void deleteUser() {
        userClass.deleteUser(31);
        System.out.println("删除成功!");
    }

    @Test
    public void updateUser() {
        User user = userClass.findUserById(29);
        user.setUsername("小心");
        user.setSex("2");
        user.setAddress("上海");
        userClass.updateUser(user);
        System.out.println("更新成功!");
    }


    private UserMapper getUserMapper() throws IOException {
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.getMapper(UserMapper.class);
    }

    /**
     * 直接通过mapper接口
     *
     * @throws IOException
     */
    @Test
    public void userMapperDemo() throws IOException {
        UserMapper mapper = getUserMapper();
        User user = mapper.findUserById(1);
        System.out.println(user.toString());
    }

    @Test
    public void findByHashMap() throws Exception {
        UserMapper mapper = getUserMapper();
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("username", "王");
        List<User> users = mapper.findUserByHashMap(hashMap);
        users.forEach(p -> System.out.println(p));
    }
    @Test
    public void findUserRstMap() throws Exception {
        UserMapper mapper=getUserMapper();
        User user= mapper.findUserRstMap(1);
        System.out.println(user.toString());
    }

}
