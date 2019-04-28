package com.upc.onlinejudge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.onlinejudge.mapper.dao.ProblemListDAO;
import com.upc.onlinejudge.pojo.data.ProblemList;
import com.upc.onlinejudge.service.ProblemListService;
/**
 * @author wangchunfei
 */
@Service
public class ProblemListServiceImpl implements ProblemListService {

    @Autowired
    private ProblemListDAO problemListDAO;

    @Override
    public void addProblemList(ProblemList problemList) {
        problemListDAO.addProblemList(problemList);
    }

    @Override
    public List<ProblemList> getAllProblemList() {
        return problemListDAO.getAllProblemList();
    }

    @Override
    public List<ProblemList> getProblemListByLimit(int start, int size) {
        return problemListDAO.getProblemListByLimit(start,size);
    }
}
