package com.train.gdmt.announcement.service;

import com.train.gdmt.announcement.model.Announcement;

import java.util.List;

/**
 * @author:yifan->2540584259@qq.com
 * @date:2020/8/1,10:43
 */
public interface AnnouncementService {
    Announcement getAnnouncement(String announceNum);


    List<Announcement> findAllAnnouncements();

    int deleteAnnouncements(String announceNum);

    void addAnnouncement(Announcement announcement);
    void updateAnnouncement(Announcement announcement);
    List<Announcement> searchAnnouncements(String TitleStr);
}
