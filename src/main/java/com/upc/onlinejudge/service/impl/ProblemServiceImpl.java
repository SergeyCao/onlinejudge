package com.upc.onlinejudge.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.onlinejudge.mapper.dao.ProblemDAO;
import com.upc.onlinejudge.pojo.data.Problem;
import com.upc.onlinejudge.service.ProblemService;
/**
 * @author wangchunfei
 */
@Service
public class ProblemServiceImpl implements ProblemService {

    @Autowired
    private ProblemDAO problemDAO;

    @Override
    public void addProblem(Problem problem) {
        problemDAO.addProblem(problem);
    }

    @Override
    public Problem getProblemById(int id) {
        return problemDAO.getProblemById(id);
    }

    @Override
    public void updateCaseId(int id,int num) {
        problemDAO.updateCaseId(id, num);
    }

    @Override
    public void addSubmitNum(int id) {
        problemDAO.updateSubmitNum(id);
    }

    @Override
    public void addAcceptNum(int id) {
        problemDAO.updateAcceptNum(id);
    }
}
