package com.upc.onlinejudge.controller.filterapi;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.upc.onlinejudge.pojo.RestResult;
import com.upc.onlinejudge.pojo.data.User;
import com.upc.onlinejudge.service.UserService;
import com.upc.onlinejudge.util.JwtUtil;

@Controller
@RequestMapping(value = "/filter_api")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/loginbycookie",method = RequestMethod.GET)
    @ResponseBody
    public String loginByCookie(@RequestHeader("Authorization") String authorization) {
        JSONObject jsonResult = new JSONObject();
        String username = JwtUtil.getUsernameFromToken(authorization);
        User user = userService.getUser(username);
        jsonResult.put("ok",1);
        jsonResult.put("data",user);
        return jsonResult.toJSONString();
    }

    @RequestMapping(value = "/profile",method = RequestMethod.GET)
    @ResponseBody
    public RestResult profile(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        String token = cookies[cookies.length-1].getValue();
        String username = JwtUtil.getUsernameFromToken(token);
        return RestResult.ok().setData(userService.getUser(username));
    }
}
