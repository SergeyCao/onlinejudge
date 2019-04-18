package com.upc.onlinejudge.pojo.params;

import java.util.Date;

import com.upc.onlinejudge.pojo.PageInfo;

import lombok.Data;

@Data
public class SubmissionsQueryParam extends PageInfo {
    private String username;
    private Date date;
    private Integer problemId;
    private Integer result;
    private Integer language;
}
