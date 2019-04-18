package com.upc.onlinejudge.mapper.dao;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.upc.onlinejudge.pojo.data.Contest;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ContestDAOTest {
    @Autowired
    ContestDAO contestDAO;

    @Test
    public void getContestList() {
        System.out.println(contestDAO.getContestList());
    }

    @Test
    public void addContest() {
        Contest contest = new Contest();
        contest.setTitle("123");
        contest.setDuration(10);
        contest.setStartTime(new Date());
        contest.setProblems("{1,2,3}");
        contest.setWriters("123");
        contestDAO.addContest(contest);
    }
}
