package execute;

import dao.mapper.UserMapper;
import entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class SpringExecute {

    @Test
    public void testFindUserById() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        UserMapper userMapper = (UserMapper) context.getBean("userMapper");
        User user = userMapper.findUserById(1);
        System.out.println(user);
    }
}
