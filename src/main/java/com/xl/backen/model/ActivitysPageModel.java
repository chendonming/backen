package com.xl.backen.model;

import com.xl.backen.entity.Activitys;

/**
 * ActivitysPageModel
 */
public class ActivitysPageModel extends Activitys {

    private static final long serialVersionUID = 1L;

    private int pageSize;

    private int pageNum;

    @Override
    public String toString() {
        return "ActivitysPageModel{" +
                "pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", Activitys=" + super.toString() +
                '}';
    }

    public int getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }
}