package com.gzy;

import com.gzy.bean.Order;
import com.gzy.mappers.OrderMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

public class OrderMapperTest {

    private OrderMapper orderMapper;

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }

    @Test
    public void queryOrderWithUserAndDetailByOrderNumber() {
        Order order = orderMapper.queryOrderWithUserAndDetailByOrderNumber("123456");
        System.out.println(order);
    }
}
