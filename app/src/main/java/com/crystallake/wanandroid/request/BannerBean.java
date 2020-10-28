/************************************************************
 * Copyright 2000-2020 OPPO Mobile Comm Corp., Ltd.
 * All rights reserved.
 * <p>
 * FileName       : BannerBean.java
 * Version Number : 1.0
 * Description    :
 * Author         : Dongsheng.Ye
 * Date           : 2020/10/10
 * History        :( ID,     Date,         Author, Description)
 * v1.0, 2020/10/10, Dongsheng.Ye, create
 ************************************************************/
package com.crystallake.wanandroid.request;

import com.crystallake.mylibrary.net.common.BasicResponse;

import java.util.List;

public class BannerBean extends BasicResponse<List<BannerBean.DataBean>> {

    public static class DataBean{
        private String desc;
        private int id;
        private String imagePath;
        private int isVisible;
        private int order;
        private String title;
        private int type;
        private String url;
        private String file_path;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImagePath() {
            return imagePath;
        }

        public void setImagePath(String imagePath) {
            this.imagePath = imagePath;
        }

        public int getIsVisible() {
            return isVisible;
        }

        public void setIsVisible(int isVisible) {
            this.isVisible = isVisible;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getFile_path() {
            return file_path;
        }

        public void setFile_path(String file_path) {
            this.file_path = file_path;
        }
    }

}
    