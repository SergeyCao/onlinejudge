package com.upc.onlinejudge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.onlinejudge.mapper.ext.UserMapper;
import com.upc.onlinejudge.pojo.data.User;
import com.upc.onlinejudge.service.UserService;

/**
 * @author Wang Chunfei
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userDAO;
//    @Autowired
//    UserDAO userDAO;

    @Override
    public User getUser(String username) {
        return userDAO.getUserByUsername(username);
    }

    @Override
    public void addUser(User user) {
        user.setSolved(0);
        user.setAttempt(0);
        user.setIsAdmin(0);
        userDAO.addUser(user);
    }

    @Override
    public void addAttempt(String username) {
        userDAO.updateAttempt(username);
    }

    @Override
    public void addSolved(String username) {
        userDAO.updateSolved(username);
    }

    @Override
    public User getUserBySubmissionId(Integer id) {
        return userDAO.getUserBySubmissionId(id);
    }

}
