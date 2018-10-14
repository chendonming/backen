package com.xl.backen.model;

import com.github.pagehelper.Page;
import com.xl.backen.entity.Articles;

import java.io.Serializable;
import java.util.List;

/**
 * 分类model
 */
public class ClassificationListModel implements Serializable {
    private static final long serialVersionUID = 9427447450064878L;

    // 分类name
    private String name;

    //分类 uuid
    private String uuid;

    // 带出来的文章列表
    private Page<Articles> articlesList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Page<Articles> getArticlesList() {
        return articlesList;
    }

    public void setArticlesList(Page<Articles> articlesList) {
        this.articlesList = articlesList;
    }
}
