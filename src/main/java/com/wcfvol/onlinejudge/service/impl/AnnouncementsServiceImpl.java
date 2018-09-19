package com.wcfvol.onlinejudge.service.impl;

import com.github.pagehelper.PageHelper;
import com.wcfvol.onlinejudge.dao.AnnouncementsDAO;
import com.wcfvol.onlinejudge.pojo.data.Announcements;
import com.wcfvol.onlinejudge.pojo.params.AnnouncementsQueryParam;
import com.wcfvol.onlinejudge.service.AnnouncementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.pagehelper.Page;
import java.util.List;

@Service
public class AnnouncementsServiceImpl implements AnnouncementsService {
    @Autowired
    AnnouncementsDAO announcementsDAO;

    @Override
    public List<Announcements> getAllAnnouncements(AnnouncementsQueryParam param) {
        Page page = PageHelper.startPage(param.getPageNum(),param.getPageSize());
        System.out.println(param.getPageNum());
        return announcementsDAO.queryAll(param);
    }

    @Override
    public void addAnnouncements(Announcements announcements) {
        announcementsDAO.addAnnouncement(announcements);
    }
}
