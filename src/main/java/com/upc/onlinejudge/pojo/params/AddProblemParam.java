package com.upc.onlinejudge.pojo.params;

import com.upc.onlinejudge.pojo.PageInfo;

import lombok.Data;

/**
 * @author wangchunfei
 */
@Data
public class AddProblemParam extends PageInfo {
    private String description;
    private String input;
    private String output;
    private String title;
    private String hint;
    private String sampleInput;
    private String sampleOutput;
    private Integer timeLimit;
    private Integer memLimit;
    private String author;
    private String source;
}
