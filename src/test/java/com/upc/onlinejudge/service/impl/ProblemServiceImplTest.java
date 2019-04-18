package com.upc.onlinejudge.service.impl;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.upc.onlinejudge.pojo.data.Problem;
import com.upc.onlinejudge.service.ProblemService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Ignore
public class ProblemServiceImplTest {

    @Autowired
    ProblemService problemService;

    @Test
    public void addProblem() {
        Problem problem = new Problem();
        problem.setInput("1");
        problem.setDescription("1");
        problem.setTitle("1");
        problem.setOutput("1");
        problemService.addProblem(problem);
    }

    @Test
    public void getProblemById() {
        Problem problem=problemService.getProblemById(1);
        System.out.println(problem);
    }
}