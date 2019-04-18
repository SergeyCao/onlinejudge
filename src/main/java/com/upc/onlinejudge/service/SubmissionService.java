package com.upc.onlinejudge.service;

import java.util.List;

import com.upc.onlinejudge.pojo.data.Submission;
import com.upc.onlinejudge.pojo.params.SubmissionsQueryParam;
import com.upc.onlinejudge.pojo.po.SubmitPo;

public interface SubmissionService {
    void addSubmission(Submission submission);
    void updateResult(Submission submission);
    List<Submission> getAllSubmission();
    List<Submission> getSubmissionsByParam(SubmissionsQueryParam param);
//    List<Submission> getSubmissionList(int start, int size);
    Submission getSubmissionById(int id);
    Submission getSubmissionByBody(String body);
    SubmitPo getSubmitPojoBySubmission(Submission submission);
}
