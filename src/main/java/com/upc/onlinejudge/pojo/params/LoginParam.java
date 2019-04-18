package com.upc.onlinejudge.pojo.params;

import com.upc.onlinejudge.pojo.PageInfo;

import lombok.Data;

/**
 * @author wangchunfei
 */
@Data
public class LoginParam extends PageInfo {
    private String username;
    private String password;
    private Boolean isRemember;
}
