package com.upc.onlinejudge.pojo.params;

import com.upc.onlinejudge.pojo.PageInfo;

import lombok.Data;

/**
 * @author wangchunfei
 */
@Data
public class RegisterParam extends PageInfo {
    private String username;
    private String checkPassword;
    private String password;
    private String email;
}
