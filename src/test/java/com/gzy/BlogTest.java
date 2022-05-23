package com.gzy;

import com.gzy.bean.Blog;
import com.gzy.mapper.BlogMapper;
import com.gzy.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class BlogTest {

    @Test
    public void insertTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        String id = "2";
        blogMapper.insertBlog(id, "Android");
        sqlSession.commit();

        Blog blog = blogMapper.queryBlog(id);
        System.out.println(blog);

        sqlSession.close();
    }

    @Test
    public void deleteTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        String id = "2";
        blogMapper.deleteBlog(id);
        sqlSession.commit();

        List<Blog> blogList = blogMapper.queryBlogList();
        for (Blog b : blogList) {
            System.out.println(b);
        }

        sqlSession.close();
    }

    @Test
    public void updateTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        String id = "2";
        blogMapper.updateBlog(id, "Java");
        sqlSession.commit();

        Blog blog = blogMapper.queryBlog(id);
        System.out.println(blog);

        sqlSession.close();
    }

    @Test
    public void queryTest() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        BlogMapper blogMapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = blogMapper.queryBlog("1");
        System.out.println(blog);

        List<Blog> blogList = blogMapper.queryBlogList();
        for (Blog b : blogList) {
            System.out.println(b);
        }

        sqlSession.close();
    }
}
