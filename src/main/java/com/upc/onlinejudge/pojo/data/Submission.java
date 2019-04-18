package com.upc.onlinejudge.pojo.data;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

import java.util.Date;


/**
 * @author Wang Chunfei
 */
@Data
public class Submission {
    private Integer id;
    private String code;
    private String username;
    private Date date;
    private Integer problemId;
    private Integer result;
    private Double time;
    private Integer memory;
    private Integer length;
    private Integer language;

    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("code", code);
        jsonObject.put("userId", username);
        jsonObject.put("date", date);
        jsonObject.put("problemId", problemId);
        jsonObject.put("language", language);
        return jsonObject.toJSONString();
    }
}
