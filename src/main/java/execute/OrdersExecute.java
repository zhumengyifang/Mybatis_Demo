package execute;

import entity.User;
import entity.UserClass;
import entity.UserQueryVo;
import dao.mapper.UserMapper;
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

public class Mybatis {
	
@Test 
public void testFindOrderAndUser() throws Exception { 
//读取配置文件 
//全局配置文件的路径 
String resource = "SqlMapConfig.xml"; 
InputStream inputStream = Resources.getResourceAsStream(resource); 
//创建SqlSessionFactory 
SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
//创建SqlSession 
SqlSession sqlSession = sqlSessionFactory.openSession(); 
OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
 List<OrdersExt> orderAndUser = mapper.findOrderAndUser();
 System.out.println("orderAndUser = " + orderAndUser); sqlSession.close(); 
 }
 
 
 @Test
 public void testFindOrderAndUserRstMap() throws Exception 
 { //读取配置文件 
 //全局配置文件的路径 
 String resource = "SqlMapConfig.xml"; InputStream inputStream = Resources.getResourceAsStream(resource); 
 //创建SqlSessionFactory 
 SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream); 
 //创建SqlSession 
 SqlSession sqlSession = sqlSessionFactory.openSession(); 
 OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class); 
 List<OrderMapExt> orderAndUser = mapper.findOrderAndUserRstMap(); 
 System.out.println("orderAndUser = " + orderAndUser); sqlSession.close(); 
 }


   
}
