package com.train.gdmt.announcement.dao;

import com.train.gdmt.announcement.model.Announcement;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author:yifan->2540584259@qq.com
 * @date:2020/8/1,10:43
 */


@Mapper//表示mybatis中负责实体和sql映射的类
@Repository//注册userdao作为一个bean
public interface AnnouncementDao {


    @Select("select * from Announcement where announce_Num=#{announceNum}")
    Announcement getAnnouncement(String announceNum);

    @Select("select * from Announcement")
    List<Announcement> getAllAnnouncement();

    @Delete("delete from Announcement where announce_Num=#{announceNum}")
    int deleteAnnouncement(String announceNum);

    @Insert("INSERT INTO Announcement (Announce_Title ,  Announce_Time , Announce_Content ) " +
            "VALUES (#{announceTitle},#{announceTime},#{announceContent})")
    public void addAnnouncement(Announcement announcement);

    @Update("UPDATE Announcement set Announce_Num=#{announceNum},Announce_Time = #{announceTime},Announce_Title = #{announceTitle},Announce_Content = #{announceContent} " +
            "where Announce_Num = #{announceNum}")
    public void updateAnnouncement(Announcement announcement);

    @Select("select * from Announcement where Announce_Title LIKE #{TitleStr} ")
    List<Announcement> searchAnnouncement(String TitleStr);

}
