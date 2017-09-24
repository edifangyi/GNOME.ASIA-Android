package com.gnomeasia.entity;

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
                ", context='" + context + '\'' +
                ", islike='" + islike + '\'' +
                '}';
    }

    private String title;
    private String context;
    private Boolean islike;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Boolean getIslike() {
        return islike;
    }

    public void setIslike(Boolean islike) {
        this.islike = islike;
    }
}
