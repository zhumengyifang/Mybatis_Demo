package execute;

import dao.mapper.UserMapper;
import entity.User;
import entity.UserClass;
import entity.UserQueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserExecute extends MapperClass {

    //需要修改SqlMapConfig.xml的mappers才可以使用
    public UserExecute() throws IOException {
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


    /**
     * 直接通过mapper接口
     * 测试二级缓存
     *
     * @throws IOException
     */
    @Test
    public void userMapperDemo() throws IOException {

        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        SqlSession sqlSession2 = sqlSessionFactory.openSession();
        UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
        User user1 = mapper1.findUserById(1);
        System.out.println(user1.toString());
        sqlSession1.close();
        //在sqlSession1 close()的时候将缓存保存; 在此过程中有修改动作也就是commit操作会清空缓存
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
        //查询缓存具体查看DEBUG打印的 Cache Hit Ratio [dao.mapper.UserMapper]: 0.5 为 0则未命中缓存
        User user2 = mapper2.findUserById(1);
        System.out.println(user2.toString());
        sqlSession2.close();
    }

    @Test
    public void findByHashMap() throws Exception {
        UserMapper mapper = getMapper(UserMapper.class);
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("username", "王");
        List<User> users = mapper.findUserByHashMap(hashMap);
        users.forEach(p -> System.out.println(p));
    }

    @Test
    public void findUserRstMap() throws Exception {
        UserMapper mapper = getMapper(UserMapper.class);
        User user = mapper.findUserRstMap(1);
        System.out.println(user.toString());
    }

    @Test
    public void findUserListByTag() throws Exception {
        UserMapper mapper = getMapper(UserMapper.class);
        UserQueryVo userQueryVo = new UserQueryVo();
        User user = new User();
        user.setUsername("王");
        user.setSex("2");
        userQueryVo.setUser(user);

        List<User> users = mapper.findUserListByTag(userQueryVo);
        users.forEach(p -> System.out.println(p.toString()));
    }

    @Test
    public void userListByIds() throws Exception {
        UserMapper mapper = getMapper(UserMapper.class);
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);
        ids.add(28);
        List<User> users = mapper.userListByIds(ids);
        users.forEach(p -> System.out.println(p.toString()));
    }
}
