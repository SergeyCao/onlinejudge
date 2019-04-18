package com.upc.onlinejudge.service;

import java.util.List;

import com.upc.onlinejudge.pojo.data.Authenticate;

public interface AuthService {
    boolean judgeUsername(String username);
    boolean saveAuth(Authenticate authenticate);
    List<Authenticate> getAuth(String username);
    String getSalt(String username);
}
