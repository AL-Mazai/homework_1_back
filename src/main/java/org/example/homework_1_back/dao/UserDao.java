package org.example.homework_1_back.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;
import org.example.homework_1_back.domain.entity.User;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2024-04-08 19:53:53
 */
public interface UserDao extends BaseMapper<User> {

    /**
     * 通过ID查询单条数据
     *
     * @param userId 主键
     * @return 实例对象
     */
    User queryById(Integer userId);

    /**
     * 统计总行数
     *
     * @param user 查询条件
     * @return 总行数
     */
    long count(User user);

    @Select("SELECT * FROM user WHERE user_id = #{userId}")
    User getUserById(Integer userId);
    @Insert("INSERT INTO user(user_name, age, address, email, phone, sex, password, nick_name) VALUES(#{userName}, #{age}, #{address}, #{email}, #{phone}, #{sex}, #{password}, #{nickName},#{type},#{money})")
    @Options(useGeneratedKeys = true, keyProperty = "userId")
    Integer createUser(User user);

    @Update("UPDATE user SET user_name=#{userName}, age=#{age}, address=#{address}, email=#{email}, phone=#{phone}, sex=#{sex}, password=#{password}, nick_name=#{nickName},type=#{type}, money=#{money} WHERE user_id=#{userId}")
    Integer updateUser(User user);

    @Delete("DELETE FROM user WHERE user_id=#{userId}")
    Integer deleteUser(@Param("userId") Integer userId);

    @Select("SELECT * FROM user")
    List<User> listAllUsers();


}

