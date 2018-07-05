package com.wcfvol.onlinejudge.controller.admin;

import com.alibaba.fastjson.JSONObject;
import com.wcfvol.onlinejudge.entity.Problem;
import com.wcfvol.onlinejudge.entity.ProblemList;
import com.wcfvol.onlinejudge.entity.Submission;
import com.wcfvol.onlinejudge.po.RestResult;
import com.wcfvol.onlinejudge.service.ProblemListService;
import com.wcfvol.onlinejudge.service.ProblemService;
import com.wcfvol.onlinejudge.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.File;

/**
 * @ClassName ResultController
 * @Author Wang Chunfei
 * @Date 2018/7/1 下午4:00
 **/
@RestController
@RequestMapping(value = "/admin")
public class AdminController {
    @Autowired
    SubmissionService submissionService;
    @Autowired
    ProblemService problemService;
    @Autowired
    ProblemListService problemListService;

    @RequestMapping(value = "/set_result",method = RequestMethod.POST)
    public RestResult setResult(@RequestBody String body) {
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        Submission submission = new Submission();
        submission.setId(jsonBody.getInteger("Id"));
        submission.setLength(jsonBody.getInteger("Length"));
        submission.setMemory(jsonBody.getInteger("Memory"));
        submission.setTime(jsonBody.getDouble("Time"));
        submission.setResult(jsonBody.getInteger("Result"));
        submissionService.updateResult(submission);
        return RestResult.ok();
    }

    @RequestMapping(value = "/add_problem",method = RequestMethod.POST)
    @Transactional(rollbackFor = Exception.class)
    public RestResult addProblem(@RequestBody String body) {
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        Problem problem = new Problem();
        problem.setDescription(jsonBody.getString("description"));
        problem.setInput(jsonBody.getString("input"));
        problem.setOutput(jsonBody.getString("output"));
        problem.setTitle(jsonBody.getString("title"));
        problem.setHint(jsonBody.getString("hint"));
        problem.setSampleInput(jsonBody.getString("sampleInput"));
        problem.setSampleOutput(jsonBody.getString("sampleOutput"));
        ProblemList problemList = new ProblemList();
        problemList.setAuthor(jsonBody.getString("author"));
        problemList.setSource(jsonBody.getString("source"));
        problemList.setTitle(jsonBody.getString("title"));
        problemService.addProblem(problem);
        problemList.setProblemId(problem.getId());
        problemListService.addProblemList(problemList);
        return RestResult.ok();
    }

    @RequestMapping(value = "/add_input_output",method = RequestMethod.POST)
    public RestResult addInputOutput(@RequestParam("input")File input, @RequestParam("output") File output) {
        // TODO: 2018/7/2  
        return RestResult.ok();
    }

}