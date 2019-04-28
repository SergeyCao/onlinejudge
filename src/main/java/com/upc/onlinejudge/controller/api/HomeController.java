package com.upc.onlinejudge.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.upc.onlinejudge.pojo.RestResult;
import com.upc.onlinejudge.pojo.params.AnnouncementsQueryParam;
import com.upc.onlinejudge.service.AnnouncementsService;
/**
 * @author wangchunfei
 */
@Controller
@RequestMapping(value = "/api")
public class HomeController {

    @Autowired
    private AnnouncementsService announcementsService;


    @RequestMapping(value = "/announcements",method = RequestMethod.POST)
    @ResponseBody
    public RestResult getAnnouncements(@RequestBody AnnouncementsQueryParam param) {
        return RestResult.ok().setData( announcementsService.getAllAnnouncements(param));
    }

}
