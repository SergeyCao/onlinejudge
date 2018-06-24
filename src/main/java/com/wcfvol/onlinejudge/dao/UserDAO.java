package com.wcfvol.onlinejudge.dao;

import com.wcfvol.onlinejudge.po.User;
import org.apache.ibatis.annotations.*;


@Mapper
public interface UserDAO {
    String TABLE_NAME = "user";
    String INSET_FIELDS = " user_id, username, email, solved, attempt ";
    String SELECT_FIELDS = " id, user_id, username, email, solved, attempt ";

    @Select({" SELECT ",SELECT_FIELDS," FROM ",TABLE_NAME," WHERE user_id = #{userId} "})
    User getUserByUserId(int userId);

    @Insert({"INSERT INTO ",TABLE_NAME," ( ",INSET_FIELDS," ) VALUE (#{userId}, #{username}, #{email}, #{solved}, #{attempt} ) "})
    void addUser(User user);
}