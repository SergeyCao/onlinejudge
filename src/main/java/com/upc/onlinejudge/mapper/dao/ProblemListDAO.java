package com.upc.onlinejudge.mapper.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.upc.onlinejudge.pojo.data.ProblemList;

/**
 * @author Wang Chunfei
 */
@Mapper
@Repository
public interface ProblemListDAO {
    String TABLE_NAME = "problem_list";
    String INSET_FIELDS = " problem_id, title, author, source ";
    String SELECT_FIELDS = " id, problem_id, title, author, source ";

    @Select({"SELECT ",SELECT_FIELDS," FROM ",TABLE_NAME})
    List<ProblemList> getAllProblemList();

    @Select({"SELECT ",SELECT_FIELDS," FROM ",TABLE_NAME," LIMIT #{start} , #{size}"})
    List<ProblemList> getProblemListByLimit(@Param("start") int start,@Param("size") int size);

    @Insert({"INSERT INTO ",TABLE_NAME," ( ",INSET_FIELDS, " ) VALUES " +
            "( #{problemId},#{title},#{author},#{source} )"})
    void addProblemList(ProblemList problemList);
}
