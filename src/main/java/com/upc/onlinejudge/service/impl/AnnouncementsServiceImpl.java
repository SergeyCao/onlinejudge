package com.upc.onlinejudge.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upc.onlinejudge.mapper.dao.AnnouncementsDAO;
import com.upc.onlinejudge.pojo.data.Announcements;
import com.upc.onlinejudge.pojo.params.AnnouncementsQueryParam;
import com.upc.onlinejudge.service.AnnouncementsService;
/**
 * @author wangchunfei
 */
@Service
public class AnnouncementsServiceImpl implements AnnouncementsService {
    @Autowired
    AnnouncementsDAO announcementsDAO;

    @Override
    public List<Announcements> getAllAnnouncements(AnnouncementsQueryParam param) {
        return announcementsDAO.queryAll(param);
    }

    @Override
    public void addAnnouncements(Announcements announcements) {
        announcementsDAO.addAnnouncement(announcements);
    }
}
