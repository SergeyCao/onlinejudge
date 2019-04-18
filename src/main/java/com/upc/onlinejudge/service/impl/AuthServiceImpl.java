package com.upc.onlinejudge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.onlinejudge.mapper.dao.AuthenticateDAO;
import com.upc.onlinejudge.pojo.data.Authenticate;
import com.upc.onlinejudge.service.AuthService;
@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    AuthenticateDAO authenticateDAO;
    @Override
    public boolean judgeUsername(String username) {
        List userList = authenticateDAO.getAuthByUsername(username);
        return userList.isEmpty();
    }

    @Override
    public boolean saveAuth(Authenticate authenticate) {
        String username = authenticate.getUsername();
        if (judgeUsername(username)) {
            authenticateDAO.addAuthenticate(authenticate);
            return true;
        }
        return false;
    }

    @Override
    public List<Authenticate> getAuth(String username) {
        return authenticateDAO.getAuthByUsername(username);
    }


    @Override
    public String getSalt(String username) {
        return authenticateDAO.getSaltByUsername(username);
    }
}
