package com.upc.onlinejudge.pojo.data;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * @author Wang Chunfei
 */
@Data
public class Announcements {
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date date;
    private int id;
    private String title;
    private String author;
    private String content;
}
