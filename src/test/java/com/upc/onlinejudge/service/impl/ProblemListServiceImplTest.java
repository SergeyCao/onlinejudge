package com.upc.onlinejudge.service.impl;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.upc.onlinejudge.pojo.data.ProblemList;
import com.upc.onlinejudge.service.ProblemListService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Ignore
public class ProblemListServiceImplTest {
    @Autowired
    ProblemListService problemListService;

    @Test
    public void addProblemList() {
        ProblemList problemList = new ProblemList();
        problemList.setProblemId(1);
        problemList.setAuthor("1234");
        problemList.setSource("1234");
        problemList.setTitle("1");
        problemListService.addProblemList(problemList);
        System.out.println(problemList.getId());
    }

    @Test
    public void getAllProblemList() {
        List<ProblemList> reslt= problemListService.getAllProblemList();
        for (ProblemList p : reslt) {
            System.out.println(p);
        }
    }

    @Test
    public void getProblemListByLimit() {
        List<ProblemList> reslt= problemListService.getProblemListByLimit(0,3);
        System.out.println("limit---------start");
        for (ProblemList p : reslt) {
            System.out.println(p);
        }
        System.out.println("limit---------end");

    }
}