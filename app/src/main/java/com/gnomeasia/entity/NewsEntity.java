package com.gnomeasia.entity;

import com.socks.library.KLog;

/**
 * ================================================
 * 作    者：FangYi
 * 邮    箱：87649669@qq.com
 * 版    本：1.0
 * 日    期：2017/8/28
 * 描    述：
 * 修订历史：
 * ================================================
 */
public class NewsEntity {

    @Override
    public String toString() {
        return "NewsEntity{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", link='" + link + '\'' +
                ", like=" + like +
                ", data='" + data + '\'' +
                '}';
    }

    private String title;
    private String description;
    private String link;
    private Boolean like;
    private String data;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Boolean getLike() {
        return like;
    }

    public void setLike(Boolean like) {
        this.like = like;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
