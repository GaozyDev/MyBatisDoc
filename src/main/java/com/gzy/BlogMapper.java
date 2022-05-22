package com.gzy;

import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface BlogMapper {
  @Select("SELECT * FROM Blog WHERE id = #{id}")
  Blog selectBlog(String id);

  @Select("select * from Blog")
  List<Blog> getBlogList();
}