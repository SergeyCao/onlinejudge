package com.upc.onlinejudge.pojo.vo;

import lombok.Data;

@Data
public class ResultVo {
    private int id;
    private int result;
    private double time;
    private int memory;
    private int length;
}
