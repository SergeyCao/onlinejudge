package com.upc.onlinejudge.pojo.po;

import com.alibaba.fastjson.JSONObject;
import lombok.Data;

/**
 * @ClassName TaskPo
 * @Author Wang Chunfei
 * @Date 2018/7/6 下午4:03
 **/
@Data
public class TaskPo {
    int taskId;
    String data;
    @Override
    public String toString() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("taskId",taskId);
        jsonObject.put("data",data);
        return jsonObject.toJSONString();
    }
}
