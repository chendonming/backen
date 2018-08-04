package com.xl.backen.model;

import com.xl.backen.entity.Communitys;

/**
 * 社区新增模板
 */
public class CommunitysForAddModel extends Communitys {
    /**
     * 社区负责人
     */
    private String communityLeader;

    /**
     * 社区负责人的手机号码
     */
    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCommunityLeader() {
        return communityLeader;
    }

    public void setCommunityLeader(String communityLeader) {
        this.communityLeader = communityLeader;
    }
}
