package com.upc.onlinejudge.service;

import java.util.List;

import com.upc.onlinejudge.pojo.data.Announcements;
import com.upc.onlinejudge.pojo.params.AnnouncementsQueryParam;

public interface AnnouncementsService {
    public List<Announcements> getAllAnnouncements(AnnouncementsQueryParam param) ;
    public void addAnnouncements(Announcements announcements);
}
