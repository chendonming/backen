package com.xl.backen.model;

import com.xl.backen.entity.Tasks;

public class AppTasksModel extends Tasks {

    private static final long serialVersionUID = -1668580345152143825L;

    private Boolean is_join_task;

    @Override
    public String toString() {
        return "AppTasksModel{" +
                "is_join_task=" + is_join_task +
                ",Tasks=" + super.toString() +
                '}';
    }

    public Boolean getIs_join_task() {
        return is_join_task;
    }

    public void setIs_join_task(Boolean is_join_task) {
        this.is_join_task = is_join_task;
    }
}
