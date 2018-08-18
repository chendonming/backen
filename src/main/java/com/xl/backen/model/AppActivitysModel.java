package com.xl.backen.model;

import com.xl.backen.entity.Activitys;

public class AppActivitysModel extends Activitys {

    private static final long serialVersionUID = -7324060875970933234L;

    private Boolean is_join_act;

    @Override
    public String toString() {
        return "AppActivitysModel{" +
                "is_join_act=" + is_join_act +
                ",Activitys=" + super.toString() +
                '}';
    }

    public Boolean getIs_join_act() {
        return is_join_act;
    }

    public void setIs_join_act(Boolean is_join_act) {
        this.is_join_act = is_join_act;
    }
}
