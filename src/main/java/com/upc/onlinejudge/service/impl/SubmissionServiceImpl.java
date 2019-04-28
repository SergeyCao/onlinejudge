package com.upc.onlinejudge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.upc.onlinejudge.mapper.dao.SubmissionDAO;
import com.upc.onlinejudge.pojo.data.Problem;
import com.upc.onlinejudge.pojo.data.Submission;
import com.upc.onlinejudge.pojo.params.SubmissionsQueryParam;
import com.upc.onlinejudge.pojo.po.SubmitPo;
import com.upc.onlinejudge.service.ProblemService;
import com.upc.onlinejudge.service.SubmissionService;
/**
 * @author wangchunfei
 */
@Service
public class SubmissionServiceImpl implements SubmissionService {
    @Autowired
    private SubmissionDAO submissionDAO;
    @Autowired
    private ProblemService problemService;

    @Override
    public void addSubmission(Submission submission) {
        submissionDAO.addSubmission(submission);
    }

    @Override
    public void updateResult(Submission submission) {
        submissionDAO.addResult(submission);
    }

    @Override
    public List<Submission> getAllSubmission() {
        return submissionDAO.getAllSubmission();
    }

    @Override
    public List<Submission> getSubmissionsByParam(SubmissionsQueryParam param) {
        return submissionDAO.getSubmissionsByParam(param);
    }

//    @Override
//    public List<Submission> getSubmissionList(int start, int size) {
////        return submissionDAO.getSubmissionList(start,size);
//    }

    @Override
    public Submission getSubmissionById(int id) {
        return submissionDAO.getSubmissionById(id);
    }

    @Override
    public Submission getSubmissionByBody(String body) {
        JSONObject jsonBody = (JSONObject) JSONObject.parse(body);
        Submission submission = new Submission();
        submission.setCode(jsonBody.getString("code"));
        submission.setDate(jsonBody.getDate("date"));
        submission.setProblemId(jsonBody.getInteger("problem_id"));
        submission.setUsername(jsonBody.getString("username"));
        submission.setLanguage(jsonBody.getInteger("language"));
        return submission;
    }

    @Override
    public SubmitPo getSubmitPojoBySubmission(Submission submission) {
        SubmitPo submitPo = new SubmitPo();
        submitPo.setLanguage(submission.getLanguage());
        submitPo.setUsername(submission.getUsername());
        submitPo.setProblemId(submission.getProblemId());
        submitPo.setCode(submission.getCode());
        Problem problem =  problemService.getProblemById(submission.getProblemId());
        submitPo.setMemLimit(problem.getMemLimit());
        submitPo.setTimeLimit(problem.getTimeLimit());
        submitPo.setMemLimit(problem.getMemLimit());
        submitPo.setTestCase(problem.getTestCase());
        submitPo.setId(submission.getId());
        return submitPo;
    }
}
