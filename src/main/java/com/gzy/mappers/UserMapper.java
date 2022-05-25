package com.gzy.mappers;

import com.gzy.bean.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    /**
     * 新增用户
     */
    void insertUser(User user);

    /**
     * 根据id删除用户信息
     */
    void deleteUser(String id);

    /**
     * 更新用户信息
     */
    void updateUser(User user);

    /**
     * 查询所有用户信息
     */
    List<User> queryUserAll();

    /**
     * 根据id查询用户信息
     */
    User queryUserById(String id);

    /**
     * 根据用户名模糊查询,可为空
     */
    List<User> queryUserAllWithName(String userName);

    List<User> queryUserAllWithNameOrAge(@Param("userName") String userName, @Param("age") Integer age);
}
