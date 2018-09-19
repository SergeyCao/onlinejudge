package com.wcfvol.onlinejudge.pojo.data;

import lombok.Data;

@Data
public class User {
    private int id;
    private String username;
    private String email;
    private int solved;
    private int attempt;
    private int isAdmin;
}