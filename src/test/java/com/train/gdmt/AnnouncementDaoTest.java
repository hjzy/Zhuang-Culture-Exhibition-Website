package com.train.gdmt;

import com.train.gdmt.announcement.dao.AnnouncementDao;
import com.train.gdmt.announcement.model.Announcement;
import com.train.gdmt.user.dao.UserDao;
import com.train.gdmt.user.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @Author: xiuzhong.li
 * @Date: 2020/7/27 10:29
 */


@SpringBootTest
public class AnnouncementDaoTest {


    @Autowired//自动装配指的就是使用将Spring容器中的bean自动的和我们需要这个bean的类组装在一起。
    private AnnouncementDao announcementDao;
    //这个注解的作用在于把UserDao作为一个bean


    /**
     * 1、Java面向对象，对象有方法和属性，那么就需要对象实例来调用方法和属性（即实例化）；
     * <p>
     * 2、凡是有方法或属性的类都需要实例化，这样才能具象化去使用这些方法和属性；
     * <p>
     * 3、规律：凡是子类及带有方法或属性的类都要加上注册Bean到Spring IoC的注解；
     * <p>
     * 4、把Bean理解为类的代理或代言人（实际上确实是通过反射、代理来实现的），这样它就能代表类拥有该拥有的东西了
     */


    @Test
    public void getAnnouncementTest() {

        List<Announcement> announcement = announcementDao.getAllAnnouncement();
        System.out.println(announcement);
        assertThat(announcement).isNotNull();


    }

    //@Test
    public void insert() {
        Announcement announcement = new Announcement();
        announcement.setAnnounceTime("2020-8-1");
        announcement.setAnnounceTitle("love");
        announcement.setAnnounceContent("这是一个测试公告");
        announcementDao.addAnnouncement(announcement);
        //System.out.println(announcementDao.getAllAnnouncement());
    }

}
