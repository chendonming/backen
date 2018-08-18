package com.xl.backen.model;

import com.xl.backen.entity.Communitys;

/**
 * 社区新增模板
 */
public class CommunitysForAddModel extends Communitys {
    private static final long serialVersionUID = 5919595996098042347L;

	/**
     * 社区负责人
     */
    private String communityLeader;

    /**
     * 社区负责人的手机号码
     */
    private String mobile;

    @Override
    public String toString() {
        return "CommunitysForAddModel{" +
                "communityLeader='" + communityLeader + '\'' +
                ", mobile='" + mobile + '\'' +
                ",super=" +super.toString() +
                '}';
    }

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
