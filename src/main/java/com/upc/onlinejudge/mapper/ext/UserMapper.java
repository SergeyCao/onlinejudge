package com.upc.onlinejudge.mapper.ext;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.upc.onlinejudge.mapper.dao.UserDAO;
import com.upc.onlinejudge.pojo.data.User;

@Mapper
@Repository
public interface UserMapper extends UserDAO {
    User getUserBySubmissionId(Integer id);
}
