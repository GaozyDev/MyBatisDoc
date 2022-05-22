package com.gzy;

import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        List<Blog> blogList = blogMapper.getBlogList();
        for(Blog blog : blogList){
            System.out.println(blog);
        }

        Blog blog = blogMapper.selectBlog("101");
        System.out.println(blog);
        sqlSession.close();
    }
}
