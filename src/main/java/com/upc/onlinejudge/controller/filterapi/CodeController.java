package com.upc.onlinejudge.controller.filterapi;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upc.onlinejudge.client.SendCode;
import com.upc.onlinejudge.pojo.RestResult;
import com.upc.onlinejudge.pojo.data.Submission;
import com.upc.onlinejudge.pojo.data.User;
import com.upc.onlinejudge.pojo.po.SubmitPo;
import com.upc.onlinejudge.pojo.po.TaskPo;
import com.upc.onlinejudge.service.ProblemService;
import com.upc.onlinejudge.service.SubmissionService;
import com.upc.onlinejudge.service.UserService;
import com.upc.onlinejudge.util.JwtUtil;

/**
 * @author Wang Chunfei
 */
@Controller
@RequestMapping(value = "/filter_api")
public class CodeController {
    @Autowired
    SubmissionService submissionService;
    @Autowired
    UserService userService;
    @Autowired
    SendCode sendCode;
    @Autowired
    ProblemService problemService;

    @RequestMapping(value = "/submit", method = RequestMethod.POST)
    @ResponseBody
    public RestResult submitCode(HttpServletRequest request, @RequestBody String body) {
        Cookie[] cookies = request.getCookies();
        String token = cookies[cookies.length - 1].getValue();
        String username = JwtUtil.getUsernameFromToken(token);
        Submission submission = submissionService.getSubmissionByBody(body);
        submissionService.addSubmission(submission);
        SubmitPo submitPo = submissionService.getSubmitPojoBySubmission(submission);
        TaskPo task = new TaskPo();
        task.setData(submitPo.toString());
        task.setTaskId(1);
        if (sendCode.send(task.toString())) {
            userService.addAttempt(username);
            problemService.addSubmitNum(submission.getProblemId());
            return RestResult.ok().setData(submission);
        }
        submission.setResult(5);
        submissionService.updateResult(submission);
        return RestResult.fail(0, "提交评测失败");
    }

    @RequestMapping(value = "/code/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestResult getCode(HttpServletRequest request, @PathVariable("id") int id) {
        Cookie[] cookies = request.getCookies();
        String token = cookies[cookies.length - 1].getValue();
        String username = JwtUtil.getUsernameFromToken(token);
        User user = userService.getUser(username);
        Submission sub = submissionService.getSubmissionById(id);
        if (!sub.getUsername().equals(user.getUsername())) {
            return RestResult.fail(0, "没有权限!");
        }
        return RestResult.ok().setData(sub.getCode());
    }
}
