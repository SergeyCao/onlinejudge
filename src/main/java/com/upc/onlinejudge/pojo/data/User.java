package com.upc.onlinejudge.pojo.data;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String username;
    private String email;
    private Integer solved;
    private Integer attempt;
    private Integer isAdmin;
}
