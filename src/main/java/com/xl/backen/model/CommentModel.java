package com.xl.backen.model;

import com.xl.backen.entity.Comment;

/**
 * 评论model
 */
public class CommentModel extends Comment {
    private String createId;
    private String createName;
    private String headPic;

    @Override
    public String getCreateId() {
        return createId;
    }

    @Override
    public void setCreateId(String createId) {
        this.createId = createId;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName;
    }
}
