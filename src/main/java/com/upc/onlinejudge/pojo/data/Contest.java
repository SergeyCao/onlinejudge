package com.upc.onlinejudge.pojo.data;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Contest {
    private Integer id;
    private String title;
    private String problems;
    private List<Integer> problemList;
    private String acmRank;
    private String oiRank;
    private Date startTime;
    private Integer duration;
    private String writers;
    private String password;
}
