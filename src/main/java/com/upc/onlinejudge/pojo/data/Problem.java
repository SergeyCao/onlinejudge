package com.upc.onlinejudge.pojo.data;
import lombok.Data;

/**
 * @author Wang Chunfei
 */
@Data
public class Problem {
    private Integer id;
    private String title;
    private String description;
    private String input;
    private String output;
    private String sampleInput;
    private String sampleOutput;
    private String hint;
    private Integer    timeLimit;
    private Integer    memLimit;
    private Integer    submitNum;
    private Integer    acceptNum;
    private Integer    testCase;
}
