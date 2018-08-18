package com.xl.backen.model;

import com.xl.backen.entity.Peoples;
import com.xl.backen.entity.Tasks;
import com.xl.backen.entity.TasksPeoples;

import java.util.List;

public class TasksPeopleModel extends TasksPeoples {
    private static final long serialVersionUID = 1943774868937459359L;

    private List<Tasks> tasksList;

    private List<Peoples> peoplesList;

    private Integer pageSize;

    private Integer pageNum;

    @Override
    public String toString() {
        return "TasksPeopleModel{" +
                "tasksList=" + tasksList +
                ", peoplesList=" + peoplesList +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ",super=" +super.toString() +
                '}';
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public List<Tasks> getTasksList() {
        return tasksList;
    }

    public void setTasksList(List<Tasks> tasksList) {
        this.tasksList = tasksList;
    }

    public List<Peoples> getPeoplesList() {
        return peoplesList;
    }

    public void setPeoplesList(List<Peoples> peoplesList) {
        this.peoplesList = peoplesList;
    }
}
