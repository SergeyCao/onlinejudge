package com.upc.onlinejudge.service;

import java.util.List;

import com.upc.onlinejudge.pojo.data.ProblemList;

public interface ProblemListService {
    void addProblemList(ProblemList problemList);
    List<ProblemList> getAllProblemList();
    List<ProblemList> getProblemListByLimit(int start, int size);
}
