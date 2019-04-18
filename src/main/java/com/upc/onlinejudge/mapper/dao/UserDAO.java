package com.upc.onlinejudge.mapper.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.upc.onlinejudge.pojo.data.User;


@Mapper
public interface UserDAO {
    String TABLE_NAME = "user";
    String INSET_FIELDS = " username, email, solved, attempt, isAdmin ";
    String SELECT_FIELDS = " id, isAdmin, username, email, solved, attempt ";

    @Select({" SELECT ",SELECT_FIELDS," FROM ",TABLE_NAME," WHERE username = #{username} "})
    User getUserByUsername(String username);

    @Insert({"INSERT INTO ",TABLE_NAME," ( ",INSET_FIELDS," ) VALUE ( #{username}, #{email}, #{solved}, #{attempt}, #{isAdmin} ) "})
    void addUser(User user);

    @Update({"UPDATE ",TABLE_NAME," SET attempt = attempt + 1 WHERE username = #{username}"})
    void updateAttempt(String username);

    @Update({"UPDATE ",TABLE_NAME," SET solved = solved + 1 WHERE username = #{username}"})
    void updateSolved(String username);
}
