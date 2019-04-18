package com.upc.onlinejudge.mapper.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.upc.onlinejudge.pojo.data.Announcements;
import com.upc.onlinejudge.pojo.params.AnnouncementsQueryParam;

/**
 * @author Wang Chunfei
 */
@Mapper
@Repository
public interface AnnouncementsDAO {
    List<Announcements> queryAll(AnnouncementsQueryParam param);
    void addAnnouncement(Announcements announcements);
}
