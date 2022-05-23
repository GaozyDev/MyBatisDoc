package com.gzy.mapper;

import com.gzy.bean.Blog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BlogMapper {

    @Insert("insert into Blog(id, title) values (#{id}, #{title})")
    void insertBlog(@Param("id") String id, @Param("title") String title);

    @Insert("delete from Blog where id = #{id}")
    void deleteBlog(String id);

    @Insert("update Blog set title = #{title} where id = #{id}")
    void updateBlog(@Param("id") String id, @Param("title") String title);

    @Select("SELECT * FROM Blog WHERE id = #{id}")
    Blog queryBlog(String id);

    @Select("select * from Blog")
    List<Blog> queryBlogList();
}