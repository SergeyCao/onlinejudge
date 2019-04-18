package com.upc.onlinejudge.mapper.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.upc.onlinejudge.pojo.data.Authenticate;

/**
 * @author wangchunfei
 */
@Mapper
@Repository
public interface AuthenticateDAO {

    void addAuthenticate(Authenticate authenticate);

    List<Authenticate> getAuthByUsername(String username);

    String getSaltByUsername(String username);
}
