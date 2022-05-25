package com.gzy;

import com.gzy.bean.User;
import com.gzy.mappers.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class UserDaoTest {

    private SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    @Test
    public void insertUser() {
        User user = new User();
        user.setId("3");
        user.setUserName("efg");
        user.setAge(20);
        user.setSex(1);
        user.setBirthday(new Date());
        userMapper.insertUser(user);
        sqlSession.commit();
    }

    @Test
    public void deleteUser() {
        userMapper.deleteUser("2");
        sqlSession.commit();
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId("1");
        user.setUserName("abc");
        user.setAge(18);
        user.setSex(1);
        user.setBirthday(new Date());
        userMapper.updateUser(user);
        sqlSession.commit();
    }

    @Test
    public void queryUserAll() {
        List<User> userList = userMapper.queryUserAll();
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserById() {
        System.out.println(userMapper.queryUserById("1"));
    }

    @Test
    public void queryUserAllWithName() {
        List<User> userList = userMapper.queryUserAllWithName("a");
        for (User user : userList) {
            System.out.println(user);
        }
    }

    @Test
    public void queryUserAllWithNameOrAge() {
        List<User> userList = userMapper.queryUserAllWithNameOrAge("f", 19);
        for (User user : userList) {
            System.out.println(user);
        }
    }
}
