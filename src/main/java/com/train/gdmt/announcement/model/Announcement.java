package com.train.gdmt.announcement.model;

import lombok.Data;

/**
 * @author:yifan->2540584259@qq.com
 * @date:2020/8/1,10:43
 */

@Data//自动生成set和get方法
public class Announcement {

       private int announceNum;
       private String announceTitle;
       private String announceTime;
       private String announceContent;
       private String annoviewUrl;
       private String annodeleteUrl;
       private String annoeditUrl;

       public String getAnnoviewUrl() {
              annoviewUrl = "http://localhost:8081/announcement/view?num=" + announceNum;
              return annoviewUrl;
       }

       public String getAnnodeleteUrl() {
              annodeleteUrl = "http://localhost:8081/announcement/delete?num=" + announceNum;
              return annodeleteUrl;
       }

       public String getAnnoeditUrl() {
              annoeditUrl = "http://localhost:8081/announcement/toEdit?num=" + announceNum;
              return annoeditUrl;
       }
}

