import model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class Mybatis {
    @Test
    public void findUserByIdTest() throws Exception{
        //读取配置文件
        //全局配置文件的路径
        String resource = "SqlMapConfig.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //创建SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //调用SqlSession的增删改查方法
        //第一个参数：表示statement的唯一标示
        User user = sqlSession.selectOne("model.findUserById", 1);
        System.out.println(user.getUsername());

        //关闭资源
        sqlSession.close();
    }

}
